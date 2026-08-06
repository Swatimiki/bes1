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
    public static final By SECTION = By.xpath("//label[@title='Water Non Infrastructure']");
    public static final By RECALCULATE = By.xpath("//div[@title='Recalculate']");
    public static final By YES = By.xpath("//div[@aria-label='Yes']");
    public static final By APPLYSTANDARD = By.xpath("//div[@aria-label='Apply Standard Recalculation']");
    public static final By THREEDOTS = By.xpath("//div[@id='section-context-menu-button']");
    public static final By ONCOSTS = By.xpath("//span[@title='On Costs']");
    public static final By Recalculate = By.xpath("//div[@class='dx-button-content']//i[@class='dx-icon fas fa-calculator']");
    public static final By EXPANDALL = By.xpath("//div[@aria-label='Expand All']/div");
    public static final By ResourceEditButton = By.xpath("//tr[.//td[normalize-space()='16']]//i[contains(@class,'dx-icon-edit')]");
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
            click(RECALCULATE);
            Thread.sleep(3000);
            click(YES);
            Thread.sleep(2000);
            click(APPLYSTANDARD);
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
            Thread.sleep(2000);
            click(APPLYSTANDARD);
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

        waits.waitForClickable(EXPANDALL);
        click(EXPANDALL);
        Thread.sleep(2000);
        waits.waitForClickable(ResourceEditButton);
        click(ResourceEditButton);
        Thread.sleep(2000);
        waits.waitForVisible(EPDCODE);
        enterText(EPDCODE, "Test");
        enterText(EPDDESCRIPTION, "EPD Test");
        click(IssueDate);
        Thread.sleep(1000);
        click(issueDateValue);
        click(expiryDate);
        Thread.sleep(1000);
        click(expiryDateValue);
        enterText(a1A3Factor, "10");
        enterText(a4Factor, "20");
        enterText(a5_1Factor, "30");
        enterText(a5_2Factor, "10");
        enterText(a5_3Factor, "20");
        enterText(a5_4Factor, "30");

        waits.waitForClickable(applyButton);
        click(applyButton);
        Thread.sleep(2000);

        waits.waitForVisible(SUCCESS_TOAST_MESSAGE);
        String actualMessage = find(SUCCESS_TOAST_MESSAGE).getText().trim();
        System.out.println("Success message displayed: " + actualMessage);
        Assert.assertEquals(actualMessage, "Changes applied successfully", "Success message mismatch");
        System.out.println("Verified changes applied successfully");
        Thread.sleep(1000);

    }




    }

