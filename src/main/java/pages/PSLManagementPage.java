package pages;

import common.BasePage;
import common.WaitUtils;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert; // Import Assert for assertions

public class PSLManagementPage extends BasePage {

    public PSLManagementPage(WebDriver driver) {

        super(driver);
    }

    protected WaitUtils waits = new WaitUtils(driver);

    // Locators
    public static final By ESTIMATES = By.xpath("//div[@aria-label='Estimates']//span[@class='dx-button-text']");
    public static final By SEARCH = By.xpath("//input[@placeholder='Search']");
    public static final By MANAGE_REVISIONS = By.xpath("//span[normalize-space()='Manage Revisions']");
    public static final By LOADING_OVERLAY = By.xpath("//div[contains(@class, 'dx-loadpanel-content')]");
    public static final By SECTION_MENU = By.xpath("//div[@id='section-context-menu-button']");
    public static final By USE_EXISTING_OPTION = By.xpath("//span[contains(@class,'dx-menu-item-text') and contains(.,'Use existing')]");
    public static final By VIEW_PSL_OPTION = By.xpath("//span[contains(@class,'dx-menu-item-text') and normalize-space()='View Project-Specific Library']");
    public static final By DELETE_PSL_OPTION = By.xpath("//span[contains(@class,'dx-menu-item-text') and normalize-space()='Delete Project Specific Library']");
    public static final By POPUP_ESTIMATE_ROW = By.xpath("//div[contains(@class,'dx-overlay-content')]//tr[contains(@class,'dx-data-row')][.//*[normalize-space()='101899.15']]");
    public static final By SAVE_BUTTON = By.xpath("//div[@role='button'][@aria-label='save' and not(@title='Save Layout')]");
    public static final By PSL_SECTION_TAB = By.xpath("//span[contains(normalize-space(),'Project-Specific Library')]");
    public static final By ERROR_MESSAGE_TOAST = By.xpath("//div[contains(@class, 'dx-toast-message')]"); // Common locator for toast messages

    public void waitForLoadingToFinish() {
        try {
            waits.waitForInvisibility(LOADING_OVERLAY);
        } catch (Exception e) {
            // Overlay may not appear or vanish too quickly
        }
    }

    public void searchAndNavigateToRevisions() throws InterruptedException {

        try {
            waitForLoadingToFinish();
            waits.waitForVisible(ESTIMATES);
            System.out.println("I am on Estimates page");
            click(ESTIMATES);
            System.out.println("Clicked on Estimates");
            waitForLoadingToFinish();
            Thread.sleep(3000);
            // Retry once if the grid didn't load after the first click
            if (driver.findElements(SEARCH).isEmpty()) {
                System.out.println("Estimates grid not loaded - clicking Estimates again");
                click(ESTIMATES);
                waitForLoadingToFinish();
                Thread.sleep(3000);
            }
            waits.waitForClickable(SEARCH);
            click(SEARCH);
            find(SEARCH).sendKeys("101854.01");
            System.out.println("Entered estimates");
            Thread.sleep(3000);
            WebElement PROJECTNO = driver.findElement(By.xpath(
                    "//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3' and not(contains(@class,'dx-hidden-cell'))]//span[text()='101854.01']"));
            waits.waitForVisible(PROJECTNO);
            Actions actions = new Actions(driver);
            actions.contextClick(PROJECTNO).perform();
            System.out.println("Right clicked on project");
            waits.waitForClickable(MANAGE_REVISIONS);
            click(MANAGE_REVISIONS);
            System.out.println("Clicked on Manage Revisions");
            waitForLoadingToFinish();
            waits.waitForClickable(SECTION_MENU);
            click(SECTION_MENU);


        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void selectUseExistingOption() throws InterruptedException {
        waitForLoadingToFinish();
        System.out.println("URL = " + driver.getCurrentUrl());
        System.out.println("Title = " + driver.getTitle());
        System.out.println("Menu Count = " + driver.findElements(USE_EXISTING_OPTION).size());
        waits.waitForVisible(USE_EXISTING_OPTION);
        click(USE_EXISTING_OPTION);
    }
    public void selectEstimateFromPopup() throws InterruptedException {
        Thread.sleep(3000);
        waits.waitForVisible(POPUP_ESTIMATE_ROW);
        click(POPUP_ESTIMATE_ROW);
        System.out.println("Selected estimate 101899.15 from popup");
        Thread.sleep(1000);
    }

    public void clickSave() throws InterruptedException {
        waits.waitForClickable(SAVE_BUTTON);
        click(SAVE_BUTTON);
        System.out.println("Clicked on Save");
        waitForLoadingToFinish();
        Thread.sleep(3000);
    }

    public void viewProjectSpecificLibrary() throws InterruptedException {
        waits.waitForClickable(PSL_SECTION_TAB);
        click(PSL_SECTION_TAB);
        System.out.println("Clicked on Project-Specific Library dropdown again");
        Thread.sleep(2000);
        System.out.println("View PSL Count = " + driver.findElements(VIEW_PSL_OPTION).size());
        waits.waitForVisible(VIEW_PSL_OPTION);
        click(VIEW_PSL_OPTION);
    }

    public void navigateToPSLSection() throws InterruptedException {
        waitForLoadingToFinish();
        System.out.println("URL = " + driver.getCurrentUrl());
        System.out.println("Title = " +driver.getTitle());
        System.out.println("Count = " + driver.findElements(PSL_SECTION_TAB).size());
        waits.waitForClickable(PSL_SECTION_TAB);
        click(PSL_SECTION_TAB);
        System.out.println("Clicked on Project-Specific Library dropdown");
        Thread.sleep(1000);
    }

    // New methods for deletion scenario
    public void clickDeleteProjectSpecificLibraryOption() throws InterruptedException {
        waits.waitForClickable(DELETE_PSL_OPTION);
        click(DELETE_PSL_OPTION);
        System.out.println("Clicked on Delete Project Specific Library option");
        waitForLoadingToFinish();
        Thread.sleep(1000);
    }

    public void verifyErrorMessage(String expectedErrorMessage) throws InterruptedException {
        waits.waitForVisible(ERROR_MESSAGE_TOAST);
        WebElement errorMessageElement = find(ERROR_MESSAGE_TOAST);
        String actualErrorMessage = errorMessageElement.getText().trim();
        Assert.assertEquals("Error message mismatch", expectedErrorMessage, actualErrorMessage);
        System.out.println("Verified error message: " + actualErrorMessage);
        Thread.sleep(1000);
    }
}