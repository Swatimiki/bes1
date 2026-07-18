//package pages;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//
//import common.BasePage;
//import common.WaitUtils;
//import utilities.CommonUtils;
//
//public class EstimateRevisionsManagementPage1 extends BasePage {
//
//	public EstimateRevisionsManagementPage1(WebDriver driver) {
//		super(driver);
//
//	}
//
//	WaitUtils waits = new WaitUtils(driver);
//
//
//	public static final By ESTIMATES = By.xpath("//div[@aria-label='Estimates']//span[@class='dx-button-text']");
//	public static final By SEARCH = By.xpath("//input[@placeholder='Search']");
//	public static final By VIEWESTIMATE = By.xpath("//span[text()='View Estimate Overview']");
//
//	public static final By RECALCULATE = By.xpath("//div[@title='Recalculate']");
//	public static final By YES = By.xpath("//div[@aria-label='Yes']");
//	public static final By APPLYSTANDARD = By.xpath("//div[@aria-label='Apply Standard Recalculation']");
//	public static final By THREEDOTS = By.xpath("//div[@id='section-context-menu-button']");
//	public static final By ONCOSTS = By.xpath("//span[@title='On Costs']");
//	public static final By Recalculate = By
//			.xpath("//div[@class='dx-button-content']//i[@class='dx-icon fas fa-calculator']");
//	public static final By COMPLETE = By.xpath("//div[@role='button'][.//span[normalize-space()='🟢 Complete']]");
//	public static final By RequestAuthorization = By
//			.xpath("//div[@class='dx-button-content']//span[text()='📩 Request Authorization']");
//	public static final By Authorize = By.xpath("//div[@class='dx-button-content']//span[text()='🛡️✔️ Authorize']");
//	public static final By ManageRevisions = By.xpath("//span[normalize-space()='Manage Revisions']");
//	public static final By AddRevision = By.xpath("//span[normalize-space()='Add Revision']");
//	public static final By SUBMIT = By.xpath("//span[normalize-space()='Submit']");
//	public static final By CHEVRON = By.xpath("//i[@class='fa-solid fa-chevron-up']");
//	public static final By PROJECTSELECT = By.xpath("//td[contains(text(),'Automation-CT1')]");
//	public static final By NEWREVISION = By
//			.xpath("//tr[contains(@class,'dx-data-row')]//td[text()='Automation_Project2-CT1']");
//	public static final By SECTION = By.xpath("//label[@title='Sewerage Non Infrastructure']");
//	public static final By EXPANDALL = By.xpath("//div[@aria-label='Expand All']/div");
//	public static final By SELECTFILE = By.xpath("//span[normalize-space()='Select a file']");
//	public static final By Logoutdropdownarrow = By.xpath(
//			"//div[@class='dx-widget dx-button dx-button-mode-text dx-button-normal user-button']//div[@class='dropdown-arrow']");
//	public static final By CLOSE = By.xpath("//div[contains(@class,'dx-closebutton')]/div");
//	private static final String windowHandle = null;
//	public static final By allrows = By.xpath("//tr[contains(@class,'dx-data-row')]");
//	public static final By description = By.xpath("(//tbody[@role='presentation']/tr[@role='row'])[3]/td[2]");
//	// public static final By LOGOUT = By.xpath("//span[normalize-space()='Select a
//	// file']");
//	public static final By firstEditButton = By
//			.xpath("(//span[@title='Delete'])[1]/preceding-sibling::span[@title='Edit']/button");
//	public static final By radioButton = By.xpath("(//div[@role='radiogroup']//div[@role='radio']/div)[1]");
//	public static final By secondRadioButton = By.xpath("(//div[@role='radiogroup']//div[@role='radio']/div)[1]");
//	public static final By dropdownselectpsl = By.xpath("/html/body/div[2]/div/div[2]/div/div/div[1]/div[6]/div/div/div[2]/div[2]/div[1]/div[1]/div/div/div[1]/div/div[2]/div[2]/div/div");
//	public static final By fileUpload = By.xpath("//input[@type='file']");
//	public static final By EPDCode = By.xpath("//span[contains(text(),'EPD Code')]/preceding::input[1]");
//	public static final By EPDDescription = By.xpath("//span[contains(text(),'EPD Description')]/preceding::input[1]");
//	public static final By issueDate = By
//			.xpath("//span[contains(text(),'Issue Date')]/preceding::input[1]/following::div[@role='button'][1]");
//	public static final By issueDateValue = By.xpath("//td[@data-value='2026/06/20']");
//	public static final By expiryDate = By
//			.xpath("//span[contains(text(),'Expiry Date')]/preceding::input[1]/following::div[@role='button'][1]");
//	public static final By expiryDateValue = By.xpath("//td[@data-value='2026/06/30'][1]");
//	public static final By expandRadio = By.xpath(
//			"(//div[@role='radiogroup']//div[@role='radio']/div)[1]/following::div[@class='dx-accordion-wrapper'][1]");
//	public static final By a1A3Factor = By.xpath("//input[@id='projectResourceCarbA1A3Factor']");
//	public static final By a4Factor = By.xpath("//input[@id='projectResourceCarbA4Factor']");
//	public static final By a5_1Factor = By.xpath("//input[@id='projectResourceCarbA5_1_Factor']");
//	public static final By a5_2Factor = By.xpath("//input[@id='projectResourceCarbA5_2_Factor']");
//	public static final By a5_3Factor = By.xpath("//input[@id='projectResourceCarbA5_3_Factor']");
//	public static final By applyButton = By.xpath("//div[@aria-label='Apply']");
//	public static final By container = By.xpath("(//div[@class='dx-scrollable-wrapper']//div[@role='treegrid'])[1]");
//	public static final By AutomationCT = By.xpath("//div[text()='Automation-CT1']");
//	public static final By ActionDropdown = By.xpath("//div[@id='erm-context-btn'][1]");
//	public static final By DuplicateRevision = By.xpath("//span[text()='Create Duplicate Revision']");
//
//
//
//	public CommonUtils commonUtils = new CommonUtils(driver);
//
//
//
//
//	public void estimaterevisions() throws InterruptedException {
//		try {
//
//			waits.waitForVisible(ESTIMATES);
//			System.out.println("I am on Estimates page");
//
//			click(ESTIMATES);
//
//			System.out.println("Clicked on Estimates");
//			Thread.sleep(3000);
//			waits.waitForClickable(SEARCH);
//			click(SEARCH);
//			find(SEARCH).sendKeys("101854.01");
//			System.out.println("Enetered Project Number");
//			Thread.sleep(3000);
//			WebElement PROJECTNO = driver.findElement(
//					By.xpath("//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3']//span[text()='101854.01']"));
//
//			waits.waitForElement(PROJECTNO);
//			Actions actions = new Actions(driver);
//			actions.contextClick(PROJECTNO).perform();
//			System.out.println("Selected Project");
//			/*
//	click(VIEWESTIMATE);
//	// actions.sendKeys(Keys.ARROW_DOWN).perform();
//	// actions.sendKeys(Keys.ENTER).perform();
//	click(RECALCULATE);
//	Thread.sleep(3000);
//	click(YES);
//	Thread.sleep(2000);
//	click(APPLYSTANDARD);
//	Thread.sleep(60000);
//	System.err.println("Baseline recalculation Done");
//	waits.waitForVisible(THREEDOTS);
//	click(THREEDOTS);
//	waits.waitForVisible(ONCOSTS);
//	click(ONCOSTS);
//	Thread.sleep(3000);
//	click(Recalculate);
//	Thread.sleep(1000);
//	click(YES);
//	Thread.sleep(2000);
//	click(APPLYSTANDARD);
//	Thread.sleep(80000);
//	System.err.println("OnCosts recalculation Done");
//	// waits.waitForVisible(COMPLETE);
//	// click(COMPLETE);
//	// click(YES);
//	// click(RequestAuthorization);
//	// Thread.sleep(3000);
//	// switchToWindow(driver, myWindowsList.get(1));
//	// driver.switchTo().window(windowHandle);
//
//	click(CLOSE);
//
//	// actions.sendKeys(Keys.ARROW_DOWN).perform();
//	// actions.sendKeys(Keys.ENTER).perform();
//	///
//	 */
//
//} catch (Exception e) {
//	System.err.println(e.getLocalizedMessage());
//}
//}
//
//
//	List<String> myWindowsList;
//
//
//	public List<String> switchtocurrentwindow(WebDriver driver) throws InterruptedException {
//		isPageReady(driver);
//		System.err.println(driver.getWindowHandles());
//		Set<String> myWindows = driver.getWindowHandles();
//		myWindowsList = new ArrayList<>(myWindows);
//		switchToWindow(driver, myWindowsList.get(2));
//		isPageReady(driver);
//		Thread.sleep(1500);
//		return myWindowsList;
//	}
//
//
//	private void isPageReady(WebDriver driver) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void switchToWindow(WebDriver driver, String string) {
//		// TODO Auto-generated method stub
//
//	}
//	public static final By NO = By.xpath("//span[normalize-space()='No']");
//
//	public void CreateRevision() {
//
//		try {
//
//
//			waits.waitForVisible(ESTIMATES);
//			System.out.println("I am on Project Estimates page");
//
//			click(ManageRevisions);
//			click(AddRevision);
//			Thread.sleep(2000);
//			click(SUBMIT);
//			Thread.sleep(8000);
//			click(CHEVRON);
//			// need to write code to selesct random line
//			Thread.sleep(2000);
//			click(PROJECTSELECT);
//			System.out.println("Selected Project");
//			Thread.sleep(2000);
//			click(description);
//			System.out.println("Clicked Description WNI ");
//			Thread.sleep(5000);
//           waits.waitForClickable(EXPANDALL);
//			click(EXPANDALL);
//		//	 click(NEWREVISION);
//			// click(SECTION);
//			Thread.sleep(3000);
//			System.out.println("Clicked Expand all");
//
////			commonUtils.scrollToMiddle();
//			commonUtils.scrollToElement(find(firstEditButton));
//
////			commonUtils.scrollToElementInGrid(find(container), find(firstEditButton));
//
//
//			Thread.sleep(1000);
//
//			click(firstEditButton);
//
//			waits.waitForClickable(radioButton);
//			click(radioButton);
//			Thread.sleep(1000);
//
//			find(fileUpload).sendKeys("C:\\Users\\SHMHETRE\\Downloads\\scorereport (1).pdf");
//
//			waits.waitForClickable(EPDCode);
//			enterText(EPDCode, "3");
//			Thread.sleep(1000);
//			enterText(EPDDescription, "Test");
//
//			click(issueDate);
//			click(issueDateValue);
//			Thread.sleep(2000);
//			click(expiryDate);
//			Thread.sleep(2000);
//			click(expiryDateValue);
//			Thread.sleep(1000);
//			System.out.println("Entered Resource details");
//
//
//			click(expandRadio);
//			Thread.sleep(4000);
//			commonUtils.scrollToElement(find(a1A3Factor));
//			enterText(a1A3Factor, "34");
//			Thread.sleep(2000);
//			commonUtils.scrollToElement(find(a4Factor));
//			enterText(a4Factor, "55");
//			Thread.sleep(2000);
//
//			enterText(a5_1Factor, "34");
//			Thread.sleep(2000);
//
//			enterText(a5_2Factor, "55");
//			Thread.sleep(2000);
//
//			enterText(a5_3Factor, "54");
//			System.out.println("Entered Carbon Factor details");
//
//			Thread.sleep(2000);
//			click(applyButton);
//			Thread.sleep(4000);
//
//			System.out.println("Clicked apply button");
//			Thread.sleep(2000);
//
//			click(firstEditButton);
//			System.out.println("Clicked edit button second time");
//			Thread.sleep(2000);
//			click(secondRadioButton);
//			Thread.sleep(2000);
//			System.out.println("Clicked Second radio button");
//		//	click(dropdownselectpsl);
//
//			WebElement dropdown = driver.findElement(dropdownselectpsl);
//			Select select = new Select(dropdown);
//			Thread.sleep(2000);
//			select.selectByVisibleText("Project-Specific Library");
//			Thread.sleep(2000);
//			click(applyButton);
//			Thread.sleep(4000);
//			System.out.println("Automatic PSL Applied");
//			Thread.sleep(4000);
//			click(AutomationCT);
//			Thread.sleep(2000);
//			System.out.println("Navigated Back to Revision Page");
//			click(ActionDropdown);
//			Thread.sleep(2000);
//			click(DuplicateRevision);
//			Thread.sleep(4000);
//			System.out.println("Duplicate Revision Created");
//
//
//
//		} catch (Exception e) {
//			System.err.println(e.getLocalizedMessage());
//
//		}
//
//	}
//
//	void selectProject() {
//		try {
//
//			CommonUtils utils = new CommonUtils(driver);
//			int noOfRows = findElements(allrows).size();
//			int row = utils.getRandomNumber(noOfRows);
////			String xpath = String.format("(//tr[contains(@class,'dx-data-row')][%d]/td[3])", row);
//			String xpath = "(//tr[contains(@class,'dx-data-row')][1]/td[3])";
//			click(By.xpath(xpath));
//			System.err.println("select project completed");
//
//		} catch (Exception e) {
//			System.err.println("select project not completed");
//			System.err.println(e.getLocalizedMessage());
//
//		}
//	}
//
//
//	private List<String> findElements(By driver) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//}