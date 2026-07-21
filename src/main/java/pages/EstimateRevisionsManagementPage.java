package pages;

import common.BasePage;
import common.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EstimateRevisionsManagementPage extends BasePage {

	public EstimateRevisionsManagementPage(WebDriver driver) {
		super(driver);

	}

	WaitUtils waits = new WaitUtils(driver);

	public static final By ESTIMATES = By.xpath("//div[@aria-label='Estimates']//span[@class='dx-button-text']");
	public static final By SEARCH = By.xpath("//input[@placeholder='Search']");
	public static final By VIEWESTIMATE = By.xpath("//span[text()='View Estimate Overview']");

	public static final By RECALCULATE = By.xpath("//div[@title='Recalculate']");
	public static final By YES = By.xpath("//div[@aria-label='Yes']");
	public static final By APPLYSTANDARD = By.xpath("//div[@aria-label='Apply Standard Recalculation']");
	public static final By THREEDOTS = By.xpath("//div[@id='section-context-menu-button']");
	public static final By ONCOSTS = By.xpath("//span[@title='On Costs']");
	public static final By Recalculate = By
			.xpath("//div[@class='dx-button-content']//i[@class='dx-icon fas fa-calculator']");
	public static final By COMPLETE = By.xpath("//div[@role='button'][.//span[normalize-space()='🟢 Complete']]");
	public static final By RequestAuthorization = By
			.xpath("//div[@class='dx-button-content']//span[text()='📩 Request Authorization']");
	public static final By Authorize = By.xpath("//div[@class='dx-button-content']//span[text()='🛡️✔️ Authorize']");
	public static final By ManageRevisions = By.xpath("//span[normalize-space()='Manage Revisions']");
	public static final By AddRevision = By.xpath("//span[normalize-space()='Add Revision']");
	public static final By SUBMIT = By.xpath("//span[normalize-space()='Submit']");
	public static final By CHEVRON = By.xpath("//i[@class='fa-solid fa-chevron-up']");
	public static final By NewRevisions = By.xpath("//span[normalize-space()='Estimate Number']");
	//	public static final By NEWREVISION = By
//			.xpath("//tr[contains(@class,'dx-data-row')]//td[text()='Automation_Project2-CT1']");
	public static final By SECTION = By.xpath("//label[@title='Sewerage Non Infrastructure']");
	public static final By EXPANDALL = By.xpath("//div[@aria-label='Expand All']/div");
	public static final By SELECTFILE = By.xpath("//span[normalize-space()='Select a file']");
	public static final By Logoutdropdownarrow = By.xpath(
			"//div[@class='dx-widget dx-button dx-button-mode-text dx-button-normal user-button']//div[@class='dropdown-arrow']");
	public static final By CLOSE = By.xpath("//div[contains(@class,'dx-closebutton')]/div");
	private static final String windowHandle = null;
	public static final By allrows = By.xpath("//tr[contains(@class,'dx-data-row')]");
	public static final By description = By.xpath("(//tbody[@role='presentation']/tr[@role='row'])[3]/td[2]");
	// public static final By LOGOUT = By.xpath("//span[normalize-space()='Select a
	// file']");
//	public static final By firstEditButton = By
//			.xpath("(//span[@title='Delete'])[1]/preceding-sibling::span[@title='Edit']/button");

	//	public static final By ELEMENT_NAME = By.xpath("//*[text()='Temporary Davit Arms inc Counterweght']");
	public static final By ResourceEditButton = By.xpath("//*[@class='dx-icon-edit cursor-pointer']");
	public static final By radioButton = By.xpath("(//div[@role='radiogroup']//div[@role='radio']/div)[1]");
	public static final By fileUpload = By.xpath("//input[@type='file']");
	public static final By EPDCode = By.xpath("//span[contains(text(),'EPD Code')]/preceding::input[1]");
	public static final By EPDDescription = By.xpath("//span[contains(text(),'EPD Description')]/preceding::input[1]");
	public static final By issueDate = By
			.xpath("//span[contains(text(),'Issue Date')]/preceding::input[1]/following::div[@role='button'][1]");
	public static final By issueDateValue = By.xpath("//td[@data-value='2026/06/20']");
	public static final By expiryDate = By
			.xpath("//span[contains(text(),'Expiry Date')]/preceding::input[1]/following::div[@role='button'][1]");
	public static final By expiryDateValue = By.xpath("//td[@data-value='2026/06/30']");
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



	public void estimaterevisions() throws InterruptedException {

		try {
			waits.waitForVisible(ESTIMATES);
			System.out.println("I am on Estimates page");
			click(ESTIMATES);
			System.out.println("Clicked on Estimates");
			Thread.sleep(3000);
			waits.waitForClickable(SEARCH);
			click(SEARCH);
			find(SEARCH).sendKeys("101808.01");
			System.out.println("Entered estimates");
			Thread.sleep(3000);
			WebElement PROJECTNO = driver.findElement(
					By.xpath("//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3']//span[text()='101808.01']"));
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

	List<String> myWindowsList;

	public List<String> switchtocurrentwindow(WebDriver driver) throws InterruptedException {
		isPageReady(driver);
		System.err.println(driver.getWindowHandles());
		Set<String> myWindows = driver.getWindowHandles();
		myWindowsList = new ArrayList<>(myWindows);
		switchToWindow(driver, myWindowsList.get(2));
		isPageReady(driver);
		Thread.sleep(1500);
		return myWindowsList;
	}

	private void isPageReady(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	private void switchToWindow(WebDriver driver, String string) {
		// TODO Auto-generated method stub

	}

	public static final By NO = By.xpath("//span[normalize-space()='No']");

	public void Authorization() {

		try {

			Thread.sleep(4000);
			click(Logoutdropdownarrow);

			System.out.println("Enetered into Authorization method");
			WebElement dropdown = driver.findElement(
					By.xpath("//div[@class='dx-item-content dx-menu-item-content']/span[text()='Logout']"));
			dropdown.click();

			WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
			Username.sendKeys("nikita.kature");

			WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
			Password.sendKeys("Welcome123");

			Thread.sleep(2000);
			WebElement Login = driver.findElement(By.xpath("//div[@role='button']//div[text()='Log In'] "));
			Login.click();

			waits.waitForVisible(ESTIMATES);
			System.out.println("I am on Estimates page");

			click(ESTIMATES);

			System.out.println("Clicked on Estimates");
			Thread.sleep(3000);
			waits.waitForClickable(SEARCH);
			click(SEARCH);
			find(SEARCH).sendKeys("101808.01");
			// System.err.println("Entered estimates");
			// Thread.sleep(2000);
			// WebElement PROJECTNO = driver.findElement(
			// By.xpath("//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3']//span[text()='101808.01']"));
			// waits.waitForVisible(PROJECTNO);
			// Actions actions = new Actions(driver);
			// actions.contextClick(PROJECTNO).perform();
			// click(VIEWESTIMATE);
			// click(Authorize);
			// driver.navigate().back();
			// click(NO);
			// waits.waitForVisible(SEARCH);
			// click(SEARCH);
			// find(SEARCH).sendKeys("101808.01");
			// System.err.println("Entered estimates");
			Thread.sleep(3000);
			WebElement PROJECTNO1 = driver.findElement(
					By.xpath("//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3']//span[text()='101808.01']"));
			waits.waitForVisible(PROJECTNO1);
			Actions actions1 = new Actions(driver);
			actions1.contextClick(PROJECTNO1).perform();
			click(ManageRevisions);
			click(AddRevision);
			Thread.sleep(2000);
			click(SUBMIT);
			Thread.sleep(8000);
			click(CHEVRON);
			selectProject();
			Thread.sleep(2000);
			click(description);
			Thread.sleep(4000);

			waits.waitForClickable(EXPANDALL);
			click(EXPANDALL);
			// click(NEWREVISION);
			// click(SECTION);
			Thread.sleep(3000);

			commonUtils.scrollToElement(driver.findElement(By.xpath("//*[text()='Temporary Davit Arms inc Counterweght']")));
			//	commonUtils.scrollToMiddle();
			commonUtils.scrollToElement(find(ResourceEditButton));

//			commonUtils.scrollToElementInGrid(find(container), find(firstEditButton));

			Thread.sleep(1000);

			click(ResourceEditButton);

			waits.waitForClickable(radioButton);
			click(radioButton);
			Thread.sleep(1000);

			find(fileUpload).sendKeys("C:\\Users\\vuswaroo\\Downloads\\BES.pdf");

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

	void selectProject() {
		try {

			CommonUtils utils = new CommonUtils(driver);
			int noOfRows = findElements(allrows).size();
			int row = utils.getRandomNumber(noOfRows);
//			String xpath = String.format("(//tr[contains(@class,'dx-data-row')][%d]/td[3])", row);
			String xpath = "(//tr[contains(@class,'dx-data-row')][1]/td[3])";
			click(By.xpath(xpath));
			System.err.println("select project completed");

		} catch (Exception e) {
			System.err.println("select project not completed");
			System.err.println(e.getLocalizedMessage());

		}
	}

	public void CreateRevision() {
		// TODO Auto-generated method stub
	}

}
