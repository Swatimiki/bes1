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

    private CommonUtils commonUtils = new CommonUtils(driver);

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
    public static final By issueDateInput = By.xpath("//span[contains(text(),'Issue Date')]/preceding::input[1]");
    public static final By expiryDateInput = By.xpath("//span[contains(text(),'Expiry Date')]/preceding::input[1]");
    public static final By a1A3Factor = By.xpath("//span[contains(text(),'A1-A3 GWP')]/preceding::input[1]");
    public static final By a4Factor = By.xpath("//span[contains(text(),'A4 GWP')]/preceding::input[1]");
    public static final By a5_1Factor = By.xpath("//span[contains(text(),'A5.1 GWP')]/preceding::input[1]");
    public static final By a5_2Factor = By.xpath("//span[contains(text(),'A5.2 GWP')]/preceding::input[1]");
    public static final By a5_3Factor = By.xpath("//span[contains(text(),'A5.3 GWP')]/preceding::input[1]");
    public static final By a5_4Factor = By.xpath("//span[contains(text(),'A5.4 GWP')]/preceding::input[1]");
    public static final By POPUP_SAVE_BUTTON = By.xpath("//div[@role='button'][@aria-label='Save']");
    public static final By UPDATED_EPD_VALUE = By.xpath("//td[contains(@class,'modified')]");
    public static final By PSL_PAGE_SAVE_BUTTON = By.xpath("//div[@role='button'][@aria-label='save']");
    public static final By EPD_POPUP_VALUE = By.xpath("//input[contains(@name,'EPD')]");
    public static final By CLOSE_BUTTON = By.xpath("//div[contains(@class,'dx-closebutton')]/div");
    public static final By CONFIRM_YES = By.xpath("//div[@aria-label='Yes']");

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
        waits.waitForClickable(EPDCode);
        enterText(EPDCode, "5");
        Thread.sleep(1000);
        enterText(EPDDescription, "Test1");

        // Clear the existing date with keystrokes - clear() does not propagate to the datebox widget
        WebElement issueField = find(issueDateInput);
        issueField.click();
        Thread.sleep(500);
        issueField.sendKeys(org.openqa.selenium.Keys.END);
        for (int i = 0; i < 12; i++)
            issueField.sendKeys(org.openqa.selenium.Keys.BACK_SPACE);
        issueField.sendKeys("07/25/2026");
        issueField.sendKeys(org.openqa.selenium.Keys.TAB);
        System.out.println("Entered Issue Date");
        Thread.sleep(2000);

        WebElement expiryField = find(expiryDateInput);
        expiryField.click();
        Thread.sleep(500);
        expiryField.sendKeys(org.openqa.selenium.Keys.END);
        for (int i = 0; i < 12; i++)
            expiryField.sendKeys(org.openqa.selenium.Keys.BACK_SPACE);
        expiryField.sendKeys("07/31/2026");
        expiryField.sendKeys(org.openqa.selenium.Keys.TAB);
        System.out.println("Entered Expiry Date");
        Thread.sleep(1000);

        enterText(a1A3Factor, "15");
        Thread.sleep(1000);
        commonUtils.scrollToElement(find(a4Factor));
        enterText(a4Factor, "25");
        Thread.sleep(1000);

        enterText(a5_1Factor, "35");
        Thread.sleep(1000);

        enterText(a5_2Factor, "12");
        Thread.sleep(1000);

        enterText(a5_3Factor, "18");
        Thread.sleep(1000);

        enterText(a5_4Factor, "22");

        Thread.sleep(2000);
        System.out.println("Updated EPD details");
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
        // Confirm the 'new Unassured entry in the Dynamic Library' dialog if it appears
        if (!driver.findElements(CONFIRM_YES).isEmpty()) {
            click(CONFIRM_YES);
            System.out.println("Clicked Yes on confirmation dialog");
            Thread.sleep(2000);
        }
    }

    public void verifyUpdatedEPDDetailsInPopup() throws InterruptedException {
        waits.waitForClickable(VIEW_UPDATE_BUTTON);
        click(VIEW_UPDATE_BUTTON);
        System.out.println("Reopened View/Update popup");
        Thread.sleep(2000);
        waits.waitForVisible(EPDDescription);
        String actualValue = find(EPDDescription).getAttribute("value");
        Assert.assertEquals("EPD Description mismatch", "Test1", actualValue);
        System.out.println("Verified updated EPD details in popup");
    }

    public void clickCloseButton() throws InterruptedException {
        waits.waitForClickable(CLOSE_BUTTON);
        click(CLOSE_BUTTON);
        System.out.println("Clicked Close button");
        Thread.sleep(1000);
    }
}
