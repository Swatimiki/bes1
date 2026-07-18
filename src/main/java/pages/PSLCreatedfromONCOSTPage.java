package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import common.BasePage;
import common.WaitUtils;
import utilities.CommonUtils;

public class PSLCreatedfromONCOSTPage extends BasePage {

	public PSLCreatedfromONCOSTPage(WebDriver driver) {
		super(driver);

	}

	WaitUtils waits = new WaitUtils(driver);

	public static final By ESTIMATES = By.xpath("//div[@aria-label='Estimates']//span[@class='dx-button-text']");
	public static final By SEARCH = By.xpath("//input[@placeholder='Search']");
	public static final By ManageRevisions = By.xpath("//span[normalize-space()='Manage Revisions']");
	public static final By AddRevision = By.xpath("//span[normalize-space()='Add Revision']");
	public static final By SUBMIT = By.xpath("//span[normalize-space()='Submit']");
	public static final By Collapse = By.xpath("//button[@aria-label='Collapse']");
	public static final By PSLTAB = By.xpath("//span[normalize-space()='Project-Specific Library']");
	public static final By ViewPSLoption = By.xpath("//span[normalize-space()='View Project-Specific Library']");
	public static final By THREEDOTS = By.xpath("//div[@id='section-context-menu-button']");
	public static final By ONCOSTS = By.xpath("//span[@title='On Costs']");
	public static final By ONCOSTSSearch = By.xpath("//input[@aria-label='Search in the tree list']");
	public static final By HVORESULT = By.xpath("//table[contains(@class,'dx-treelist-table')]//tr[@role='row'][7]");
	public static final By RADIOBUTTON = By.xpath("//div[@role='radio']//div[contains(@class,'dx-accordion-item-title-caption') and normalize-space()='PAS2080 A1-A5']");
	public static final By SELECTFILE = By.xpath("//span[normalize-space()='Select a file']");
	public static final By EPDCODE = By.xpath("//span[normalize-space()='EPD Code']");
	public static final By EPDDESCRIPTION = By.xpath("//span[normalize-space()='EPD Description']");
	public static final By IssueDate = By.xpath("//span[normalize-space()='Issue Date']");
	public static final By ExpiryDate = By.xpath("//span[normalize-space()='Expiry Date']");
	public static final By issueDateValue = By.xpath("//td[@data-value='2026/06/20']");
	public static final By expiryDate = By
			.xpath("//span[contains(text(),'Expiry Date')]/preceding::input[1]/following::div[@role='button'][1]");
	public static final By expiryDateValue = By.xpath("//td[@data-value='2026/06/27']");
	public static final By expandRadio = By.xpath(
			"(//div[@role='radiogroup']//div[@role='radio']/div)[1]/following::div[@class='dx-accordion-wrapper'][1]");
	public static final By a1A3Factor = By.xpath("//input[@id='projectResourceCarbA1A3Factor']");
	public static final By a4Factor = By.xpath("//input[@id='projectResourceCarbA4Factor']");
	public static final By a5_1Factor = By.xpath("//input[@id='projectResourceCarbA5_1_Factor']");
	public static final By a5_2Factor = By.xpath("//input[@id='projectResourceCarbA5_2_Factor']");
	public static final By a5_3Factor = By.xpath("//input[@id='projectResourceCarbA5_3_Factor']");
	public static final By applyButton = By.xpath("//div[@aria-label='Apply']");
	public static final By container = By.xpath("(//div[@class='dx-scrollable-wrapper']//div[@role='treegrid'])[1]");
	public CommonUtils commonUtils = new CommonUtils(driver);
	
	
	
	

	public void psloncost() throws InterruptedException {

		try {

			waits.waitForVisible(ESTIMATES);
			System.out.println("I am on Estimates page");

			click(ESTIMATES);

			System.out.println("Clicked on Estimates");
			Thread.sleep(2000);
			waits.waitForVisible(SEARCH);
			click(SEARCH);
			find(SEARCH).sendKeys("101808.01");
			System.err.println("Entered estimates");
			click(SEARCH);
			WebElement PROJECTNO = driver.findElement(
					By.xpath("//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3']//span[text()='101808.01']"));
			waits.waitForVisible(PROJECTNO);
			Actions actions1 = new Actions(driver);
			actions1.contextClick(PROJECTNO).perform();
			click(ManageRevisions);
			click(AddRevision);
			click(SUBMIT);
			click(Collapse);
			waits.waitForVisible(THREEDOTS);
			click(THREEDOTS);
			waits.waitForVisible(ONCOSTS);
			click(ONCOSTS);
			Thread.sleep(5000);
			click(ONCOSTSSearch);
			find(ONCOSTSSearch).sendKeys("HVO");
			click(HVORESULT);
			click(RADIOBUTTON);
			click(SELECTFILE);
			
			WebElement upload = driver.findElement(By.xpath("//span[normalize-space()='Select a file']"));
			upload.sendKeys("C:\\Users\\vuswaroo\\Downloads\\BES.pdf");
			
			click(EPDCODE);

			find(EPDCODE).sendKeys("5");
			click(EPDDESCRIPTION);

			find(EPDDESCRIPTION).sendKeys("test");
			click(IssueDate);
			click(issueDateValue);
			Thread.sleep(2000);
			click(expiryDate);
			click(expiryDateValue);
			Thread.sleep(1000);

			click(expandRadio);

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
			click(applyButton);
			
			
			
			
			
			
			
			
			
			

		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
}