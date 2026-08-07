package pages;

import common.BasePage;
import common.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static pages.EstimateRevisionsManagementPage.CLOSE;

public class BaselinePage extends BasePage {

    public BaselinePage(WebDriver driver) {
        super(driver);
    }

    protected WaitUtils waits = new WaitUtils(driver);

    public static final By ESTIMATES = By.xpath("//div[@aria-label='Estimates']//span[@class='dx-button-text']");
    public static final By SEARCH = By.xpath("//input[@placeholder='Search']");
    public static final By VIEWESTIMATE = By.xpath("//span[text()='View Estimate Overview']");
    public static final By SECTION = By.xpath("//td[not(contains(@class,'dx-hidden-cell')) and normalize-space()='Water Non Infrastructure']");
    public static final By RECALCULATE = By.xpath("//div[@title='Recalculate']");
    public static final By YES = By.xpath("//div[@aria-label='Yes']");
    public static final By APPLYSTANDARD = By.xpath("//div[@aria-label='Apply Standard Recalculation']");
    public static final By THREEDOTS = By.xpath("//div[@id='section-context-menu-button']");
    public static final By ONCOSTS = By.xpath("//span[@title='On Costs']");
    public static final By Recalculate = By.xpath("//div[@class='dx-button-content']//i[@class='dx-icon fas fa-calculator']");
    public static final By EXPANDALL = By.xpath("//div[@aria-label='Expand All']/div");
    public static final By ResourceEditButton = By.xpath("//tr[@aria-rowindex='16']//td[not(contains(@class,'dx-hidden-cell'))]//i[contains(@class,'dx-icon-edit')]");
    public static final By PAS2080 = By.xpath("//div[@role='radio']//div[contains(@class,'dx-accordion-item-title-caption') and normalize-space()='PAS2080 A1-A5']");
    public static final By radioButton = By.xpath("(//div[@role='radiogroup']//div[@role='radio']/div)[1]");
    public static final By EPDCODE = By.xpath("//span[contains(text(),'EPD Code')]/preceding::input[1]");
    public static final By EPDDESCRIPTION = By.xpath("//span[contains(text(),'EPD Description')]/preceding::input[1]");
    public static final By IssueDate = By.xpath("//span[contains(text(),'Issue Date')]/preceding::input[1]/following::div[@role='button'][1]");
    public static final By issueDateValue = By.xpath("//td[@data-value='2026/06/23']");
    public static final By expiryDate = By.xpath("//span[contains(text(),'Expiry Date')]/preceding::input[1]");
    public static final By expiryDateValue = By.xpath("//td[@data-value='2026/06/30']");
    public static final By expandRadio = By.xpath("(//div[@role='radiogroup']//div[@role='radio']/div)[1]/following::div[@class='dx-accordion-wrapper'][1]");
    public static final By a1A3Factor = By.xpath("//input[@id='carbA1A3Factor']");
    public static final By a4Factor = By.xpath("//input[@id='carbA4Factor']");
    public static final By a5_1Factor = By.xpath("//input[@id='carbA51Factor']");
    public static final By a5_2Factor = By.xpath("//input[@id='carbA52Factor']");
    public static final By a5_3Factor = By.xpath("//span[contains(text(),'A5.3 KgCO2e/unit')]/preceding::input[contains(@class,'dx-texteditor-input')][1]");
    public static final By a5_4Factor = By.xpath("//input[@id='carbA54Factor']");
    public static final By applyButton = By.xpath("//div[@aria-label='Apply']");
    public static final By SUCCESS_TOAST_MESSAGE = By.xpath("//div[contains(@class, 'dx-toast-message')]");

    public void estimatebaseline() throws InterruptedException {

        try {
            waits.waitForVisible(ESTIMATES);
            System.out.println("I am on Estimates page");
            click(ESTIMATES);
            System.out.println("Clicked on Estimates");
            Thread.sleep(3000);
            waits.waitForClickable(SEARCH);
            click(SEARCH);
            find(SEARCH).sendKeys("101961.01");
            System.out.println("Entered estimates");
            Thread.sleep(3000);
            WebElement PROJECTNO = driver.findElement(
                    By.xpath("//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3']//span[text()='101961.01']"));
            waits.waitForVisible(PROJECTNO);
            Actions actions = new Actions(driver);
            actions.contextClick(PROJECTNO).perform();
            click(VIEWESTIMATE);
            // actions.sendKeys(Keys.ARROW_DOWN).perform();
            // actions.sendKeys(Keys.ENTER).perform();
            waits.waitForClickable(RECALCULATE);
            click(RECALCULATE);
            waits.waitForClickable(YES);
            click(YES);
            // Recalculation runs directly after Yes (no 'Apply Standard' step for this estimate)
            Thread.sleep(60000);
            System.err.println("Baseline recalculation Done");
            waits.waitForVisible(THREEDOTS);
            click(THREEDOTS);
            waits.waitForVisible(ONCOSTS);
            click(ONCOSTS);
            Thread.sleep(3000);
            click(Recalculate);
            Thread.sleep(1000);
            click(YES);
            // Recalculation runs directly after Yes (no 'Apply Standard' step for this estimate)
            Thread.sleep(80000);
            System.err.println("OnCosts recalculation Done");
            // waits.waitForVisible(COMPLETE);
            // click(COMPLETE);
            // click(YES);
            // click(RequestAuthorization);
            // Thread.sleep(3000);
            // switchToWindow(driver, myWindowsList.get(1));
            // driver.switchTo().window(windowHandle);

            click(CLOSE);

            // actions.sendKeys(Keys.ARROW_DOWN).perform();
            // actions.sendKeys(Keys.ENTER).perform();

        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void editResource() throws InterruptedException {

        // After recalculation, open the section, then expand all to reveal its resources
        waits.waitForVisible(SECTION);
        click(SECTION);
        Thread.sleep(2000);
        waits.waitForClickable(EXPANDALL);
        click(EXPANDALL);
        Thread.sleep(4000);
        // The edit icon is revealed on row hover, so hover line 16 first, then click it
        waits.waitForClickable(RADIOBUTTON);
        Thread.sleep(2000);
        click(RADIOBUTTON);
        Thread.sleep(1000);
        // Re-click if the first selection did not register (DevExtreme radios are timing-sensitive)
        if (!"true".equals(driver.findElement(By.xpath("//div[@role='radio'][.//div[normalize-space()='PAS2080 A1-A5']]")).getAttribute("aria-checked"))) {
            click(RADIOBUTTON);
        }
        System.out.println("Selected PAS2080 radio button");
        click(PAS2080);
        Thread.sleep(1000);
//        WebElement row16 = driver.findElement(By.xpath("//tr[@aria-rowindex='16' and not(.//td[contains(@class,'dx-hidden-cell')])]"));
//        new Actions(driver).moveToElement(row16).perform();
//        Thread.sleep(1000);
//        click(ResourceEditButton);
//        Thread.sleep(2000);
//        waits.waitForClickable(radioButton);
//        click(radioButton);
//        Thread.sleep(1000);
        waits.waitForVisible(EPDCODE);
        enterText(EPDCODE, "Test");
        enterText(EPDDESCRIPTION, "EPD Test");
        click(IssueDate);
        Thread.sleep(1000);
        click(issueDateValue);
        WebElement expiryDateValue = find(expiryDate);
        expiryDateValue.click();
        Thread.sleep(500);
        expiryDateValue.sendKeys(Keys.END);
        for (int i = 0; i < 12; i++)
            expiryDateValue.sendKeys(Keys.BACK_SPACE);
        expiryDateValue.sendKeys("06/30/2026");
        expiryDateValue.sendKeys(Keys.TAB);
        System.out.println("Entered Expiry Date");
        Thread.sleep(1000);
        click(expandRadio);
        commonUtils.scrollToElement(driver.findElement(By.xpath("//input[@id='carbA1A3Factor']")));
        enterText(a1A3Factor, "34");
        Thread.sleep(1000);
        commonUtils.scrollToElement(find(a4Factor));
        enterText(a4Factor, "55");
        Thread.sleep(1000);
        enterText(a5_1Factor, "34");
        Thread.sleep(1000);
        enterText(a5_2Factor, "55");
        Thread.sleep(1000);
        commonUtils.scrollToElement(find(a5_3Factor));
        enterText(a5_3Factor, "54");
        Thread.sleep(1000);
        commonUtils.scrollToElement(find(a5_4Factor));
        enterText(a5_4Factor, "50");
        Thread.sleep(2000);
        click(applyButton);
        Thread.sleep(4000);

        waits.waitForVisible(SUCCESS_TOAST_MESSAGE);
        String actualMessage = find(SUCCESS_TOAST_MESSAGE).getText().trim();
        System.out.println("Success message displayed: " + actualMessage);
        Assert.assertEquals(actualMessage, "Changes applied successfully", "Success message mismatch");
        System.out.println("Verified changes applied successfully");
        Thread.sleep(1000);

    }




    }

