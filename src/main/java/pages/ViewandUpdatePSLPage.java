package pages;

import common.BasePage;
import common.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.CommonUtils;


public class ViewandUpdatePSLPage extends BasePage {

    public ViewandUpdatePSLPage(WebDriver driver) {
        super(driver);
    }
    protected WaitUtils waits = new WaitUtils(driver);

    // Locators
    public static final By ESTIMATES = By.xpath("//div[@aria-label='Estimates']//span[@class='dx-button-text']");
    public static final By SEARCH = By.xpath("//input[@placeholder='Search']");
    public static final By MANAGE_REVISIONS = By.xpath("//span[normalize-space()='Manage Revisions']");
    public static final By LOADING_OVERLAY = By.xpath("//div[contains(@class, 'dx-loadpanel-content')]");
    public static final By PSL_SECTION_TAB = By.xpath("//div[@role='menuitem']//span[normalize-space()='Project-Specific Library']");
    public static final By VIEW_UPDATE_BUTTON = By.xpath("//tr[@aria-rowindex='1']//div[@role='button' and @aria-label='View/Update']//span[@class='dx-button-text']");
    public static final By EPDCode = By.xpath("//span[contains(text(),'EPD Code')]/preceding::input[1]");
    public static final By EPDDescription = By.xpath("//span[contains(text(),'EPD Description')]/preceding::input[1]");
    public static final By issueDate = By.xpath("//span[contains(text(),'Issue Date')]/preceding::input[1]/following::div[@role='button'][1]");
    public static final By issueDateValue = By.xpath("//td[@data-value='2026/07/24']");
    public static final By expiryDate = By.xpath("//span[contains(text(),'Expiry Date')]/preceding::input[1]/following::div[@role='button'][1]");
    public static final By expiryDateValue = By.xpath("//td[@data-value='2026/07/30']");
    public static final By a1A3Factor = By.xpath("//input[@id='projectResourceCarbA1A3Factor']");
    public static final By a4Factor = By.xpath("//input[@id='projectResourceCarbA4Factor']");
    public static final By a5_1Factor = By.xpath("//input[@id='projectResourceCarbA5_1_Factor']");
    public static final By a5_2Factor = By.xpath("//input[@id='projectResourceCarbA5_2_Factor']");
    public static final By a5_3Factor = By.xpath("//input[@id='projectResourceCarbA5_3_Factor']");
    public static final By EPD_TEXTBOX = By.xpath("//input[contains(@name,'EPD')]");
    public static final By POPUP_SAVE_BUTTON = By.xpath("//div[@role='button'][@aria-label='save']");
    public static final By UPDATED_EPD_VALUE = By.xpath("//td[contains(@class,'modified')]");
    public static final By PSL_PAGE_SAVE_BUTTON = By.xpath("//div[@role='button'][@aria-label='save']");
    public static final By EPD_POPUP_VALUE = By.xpath("//input[contains(@name,'EPD')]");
    public static final By CLOSE_BUTTON = By.xpath("//span[normalize-space()='Close']");

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
            waits.waitForClickable(SEARCH);
            click(SEARCH);
            find(SEARCH).sendKeys("101866.01");
            System.out.println("Entered estimates");
            Thread.sleep(3000);
            WebElement PROJECTNO = driver.findElement(By.xpath(
                    "//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3' and not(contains(@class,'dx-hidden-cell'))]//span[normalize-space()='101866.01']"));
            waits.waitForVisible(PROJECTNO);
            Actions actions = new Actions(driver);
            actions.contextClick(PROJECTNO).perform();
            System.out.println("Right clicked on project");
            waits.waitForClickable(MANAGE_REVISIONS);
            click(MANAGE_REVISIONS);
            System.out.println("Clicked on Manage Revisions");
            waitForLoadingToFinish();
            waits.waitForClickable(EPDCode);
            enterText(EPDCode, "3");
            Thread.sleep(1000);
            enterText(EPDDescription, "Test");

            click(issueDate);
            click(issueDateValue);
            Thread.sleep(2000);
            click(expiryDate);
            click(expiryDateValue);
            Thread.sleep(1000);

            enterText(a1A3Factor, "34");
            Thread.sleep(1000);
            commonUtils.scrollToElement(find(a4Factor));
            enterText(a4Factor, "55");
            Thread.sleep(1000);

            enterText(a5_1Factor, "34");
            Thread.sleep(1000);

            enterText(a5_2Factor, "55");
            Thread.sleep(1000);

            enterText(a5_3Factor, "54");

            Thread.sleep(2000);

        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void navigateToPSLSection() throws InterruptedException {
        waits.waitForClickable(PSL_SECTION_TAB);
        click(PSL_SECTION_TAB);
        System.out.println("Clicked on Project-Specific Library dropdown");
        Thread.sleep(1000);
    }

    public void clickViewUpdateButton() throws InterruptedException {
        waits.waitForClickable(VIEW_UPDATE_BUTTON);
        click(VIEW_UPDATE_BUTTON);
        System.out.println("Clicked on View/Update button");
        Thread.sleep(2000);
    }

    public void updateEPDDetails() throws InterruptedException {
        waits.waitForVisible(EPD_TEXTBOX);
        enterText(EPD_TEXTBOX, "Updated EPD");
        find(EPD_TEXTBOX).sendKeys("Updated EPD");
        System.out.println("Updated EPD details");
        Thread.sleep(1000);
    }

    public void clickPopupSaveButton() throws InterruptedException {
        waits.waitForClickable(POPUP_SAVE_BUTTON);
        click(POPUP_SAVE_BUTTON);
        System.out.println("Clicked Save button in popup");
        Thread.sleep(2000);
    }
    public void verifyUpdatedEPDDetailsHighlighted() {
        waits.waitForVisible(UPDATED_EPD_VALUE);
        Assert.assertTrue("Updated EPD details are not highlighted", find(UPDATED_EPD_VALUE).isDisplayed());
        System.out.println("Verified updated EPD details are highlighted");
    }
    public void clickSaveButtonInPSLPage() throws InterruptedException {
        waits.waitForClickable(PSL_PAGE_SAVE_BUTTON);
        click(PSL_PAGE_SAVE_BUTTON);
        System.out.println("Clicked Save button in PSL page");
        Thread.sleep(2000);
    }

    public void verifyUpdatedEPDDetailsInPopup() {
        waits.waitForVisible(EPD_POPUP_VALUE);
        String actualValue =
        find(EPD_POPUP_VALUE).getAttribute("value");
        Assert.assertEquals("Updated EPD", actualValue);
        System.out.println("Verified updated EPD details in popup");
    }

    public void clickCloseButton() throws InterruptedException {
        waits.waitForClickable(CLOSE_BUTTON);
        click(CLOSE_BUTTON);
        System.out.println("Clicked Close button");
        Thread.sleep(1000);
    }
}
