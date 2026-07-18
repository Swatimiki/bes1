package pages;

import common.BasePage;
import common.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    
    public static final By PSL_DROPDOWN = By.xpath("//div[contains(@class, 'dx-dropdowneditor-button')]//div[@class='dx-dropdowneditor-icon']");
    public static final By USE_EXISTING_OPTION = By.xpath("//div[contains(@class, 'dx-item-content')][text()='Use existing from another baseline']");
    public static final By POPUP_ESTIMATE_ROW = By.xpath("(//div[contains(@class, 'dx-overlay-content')]//tr[contains(@class, 'dx-data-row')])[1]");
    public static final By SAVE_BUTTON = By.xpath("//div[@aria-label='Save']");
    public static final By PSL_SECTION_TAB = By.xpath("//div[@role='tab']//span[text()='Project Specific Library']");

    public void waitForLoadingToFinish() {
        try {
            waits.waitForInvisibility(LOADING_OVERLAY);
        } catch (Exception e) {
            // Overlay may not appear or vanish too quickly
        }
    }

    public void searchAndNavigateToRevisions(String projectNo) throws InterruptedException {
        waits.waitForVisible(ESTIMATES);
        click(ESTIMATES);
        waitForLoadingToFinish();

        waits.waitForClickable(SEARCH);
        click(SEARCH);
        find(SEARCH).clear();
        find(SEARCH).sendKeys(projectNo);
        waitForLoadingToFinish();

        By projectRow = By.xpath("//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3']//span[normalize-space()='" + projectNo + "']");
        waits.waitForVisible(projectRow);
        
        Actions actions = new Actions(driver);
        actions.contextClick(find(projectRow)).perform();
        
        waits.waitForClickable(MANAGE_REVISIONS);
        click(MANAGE_REVISIONS);
        waitForLoadingToFinish();
    }

    public void clickPSLDropdown() throws InterruptedException {
        waits.waitForClickable(PSL_DROPDOWN);
        click(PSL_DROPDOWN);
        // Small delay to allow the dropdown animation to complete
        Thread.sleep(500);
    }

    public void selectUseExistingOption() throws InterruptedException {
        waits.waitForVisible(USE_EXISTING_OPTION);
        click(USE_EXISTING_OPTION);
        waitForLoadingToFinish();
    }

    public void selectEstimateFromPopup() throws InterruptedException {
        // Wait for the popup table to render
        waits.waitForVisible(POPUP_ESTIMATE_ROW);
        click(POPUP_ESTIMATE_ROW);
    }

    public void clickSave() throws InterruptedException {
        waits.waitForClickable(SAVE_BUTTON);
        click(SAVE_BUTTON);
        waitForLoadingToFinish();
    }

    public void navigateToPSLSection() throws InterruptedException {
        waits.waitForClickable(PSL_SECTION_TAB);
        click(PSL_SECTION_TAB);
        waitForLoadingToFinish();
    }
}