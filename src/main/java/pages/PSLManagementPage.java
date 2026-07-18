package pages;

import common.BasePage;
import common.WaitUtils;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
    
    public static final By USE_EXISTING_OPTION = By.xpath("//div[contains(@class,'dx-menu-item')]//span[@class='dx-menu-item-text'][normalize-space()='Use existing from another baseline']");
    public static final By VIEW_PSL_OPTION = By.xpath("//div[contains(@class,'dx-menu-item')]//span[@class='dx-menu-item-text'][normalize-space()='View Project-Specific Library']");
    public static final By POPUP_ESTIMATE_ROW = By.xpath("//div[contains(@class,'dx-overlay-content')]//tr[contains(@class,'dx-data-row')][.//*[normalize-space()='101899.15']]");
    public static final By SAVE_BUTTON = By.xpath("//div[@role='button'][@aria-label='save' and not(@title='Save Layout')]");
    public static final By PSL_SECTION_TAB = By.xpath("//div[@role='menuitem']//span[normalize-space()='Project-Specific Library']");

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
            find(SEARCH).sendKeys("101842.01");
            System.out.println("Entered estimates");
            Thread.sleep(3000);
            WebElement PROJECTNO = driver.findElement(By.xpath(
                    "//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3' and not(contains(@class,'dx-hidden-cell'))]//span[text()='101842.01']"));
            waits.waitForVisible(PROJECTNO);
            Actions actions = new Actions(driver);
            actions.contextClick(PROJECTNO).perform();
            System.out.println("Right clicked on project");
            waits.waitForClickable(MANAGE_REVISIONS);
            click(MANAGE_REVISIONS);
            System.out.println("Clicked on Manage Revisions");
            waitForLoadingToFinish();

        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void selectUseExistingOption() throws InterruptedException {
        waits.waitForVisible(USE_EXISTING_OPTION);
        click(USE_EXISTING_OPTION);
        System.out.println("Clicked on Use existing from another baseline");
        waitForLoadingToFinish();
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
        waits.waitForVisible(VIEW_PSL_OPTION);
        click(VIEW_PSL_OPTION);
        System.out.println("Clicked on View Project-Specific Library");
        waitForLoadingToFinish();
        Thread.sleep(3000);
    }

    public void comparePSLCodes() throws InterruptedException {

        try {
            List<String> currentCodes = getPSLCodes();
            System.out.println("101842.01 PSL codes: " + currentCodes);

            waits.waitForVisible(ESTIMATES);
            click(ESTIMATES);
            System.out.println("Clicked on Estimates");
            Thread.sleep(3000);
            waits.waitForClickable(SEARCH);
            click(SEARCH);
            find(SEARCH).sendKeys("101899.15");
            System.out.println("Entered estimates");
            Thread.sleep(3000);
            WebElement PROJECTNO = driver.findElement(By.xpath(
                    "//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3' and not(contains(@class,'dx-hidden-cell'))]//span[text()='101899.15']"));
            waits.waitForVisible(PROJECTNO);
            Actions actions = new Actions(driver);
            actions.contextClick(PROJECTNO).perform();
            System.out.println("Right clicked on estimate 101899.15");
            waits.waitForClickable(MANAGE_REVISIONS);
            click(MANAGE_REVISIONS);
            System.out.println("Clicked on Manage Revisions");
            waitForLoadingToFinish();

            viewProjectSpecificLibrary();

            List<String> sourceCodes = getPSLCodes();
            System.out.println("101899.15 PSL codes: " + sourceCodes);

            if (!currentCodes.equals(sourceCodes)) {
                throw new AssertionError(
                        "PSL codes do not match. 101842.01: " + currentCodes + " vs 101899.15: " + sourceCodes);
            }
            System.out.println("PSL codes match between 101842.01 and 101899.15");

        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            throw e;
        }
    }

    private List<String> getPSLCodes() {
        List<String> codes = new ArrayList<>();
        for (WebElement cell : driver.findElements(By.xpath(
                "//tr[contains(@class,'dx-data-row')]/td[@aria-colindex='2' and not(contains(@class,'dx-hidden-cell'))]"))) {
            String text = cell.getText().trim();
            if (!text.isEmpty() && !codes.contains(text))
                codes.add(text);
        }
        return codes;
    }

    public void navigateToPSLSection() throws InterruptedException {
        waits.waitForClickable(PSL_SECTION_TAB);
        click(PSL_SECTION_TAB);
        System.out.println("Clicked on Project-Specific Library dropdown");
        Thread.sleep(1000);
    }
}