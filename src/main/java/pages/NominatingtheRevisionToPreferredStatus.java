package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import common.BasePage;
import common.WaitUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonUtils;

import java.time.Duration;

public class NominatingtheRevisionToPreferredStatus extends BasePage {
	
	public NominatingtheRevisionToPreferredStatus(WebDriver driver) {
		super(driver);

}
	WaitUtils waits = new WaitUtils(driver);

	public static final By ESTIMATES = By.xpath("//div[@aria-label='Estimates']//span[@class='dx-button-text']");
	public static final By SEARCH = By.xpath("//input[@placeholder='Search']");
	public static final By ManageRevisions = By.xpath("//span[normalize-space()='Manage Revisions']");
	public static final By AddRevision = By.xpath("//span[normalize-space()='Add Revision']");
	public static final By CHEVRON = By.xpath("//i[@class='fa-solid fa-chevron-up']");
	public static final By SUBMIT = By.xpath("//span[normalize-space()='Submit']");
	public static final By NewRevisions = By.xpath("//span[normalize-space()='Estimate Number']");
	public static final By allrows = By.xpath("//tr[contains(@class,'dx-data-row')]");
	public static final By SECTION = By.xpath("//label[@title='Sewerage Non Infrastructure']");
	public static final By CompleteButton = By.xpath("//div[@role='button' and @aria-label='🟢 Complete']//span[@class='dx-button-text']");
	public static final By YesButton = By.xpath("//div[@role='button' and @aria-label='Yes']//span[@class='dx-button-text']");
	public static final By Request_Auth = By.xpath("//span[normalize-space()= '📩 Request Authorization']");
//	public static final By ReviAutho = By.xpath("//div[@role='button' and @aria-label='🛡️✔️ Authorize']//span[@class='dx-button-text']");
	public static final By Logoutdropdownarrow = By.xpath("//div[@class='dx-widget dx-button dx-button-mode-text dx-button-normal user-button']//div[@class='dropdown-arrow']");
	public static final By Logout = By.xpath("//span[normalize-space()='Logout']");
	public static final By LastRevision = By.xpath("(//td[starts-with(normalize-space(),'Auto_cont-CT')])[last()]");
	public static final By ActionBtn = By.xpath("//div[contains(@class,'dx-datagrid-content-fixed')]//i[contains(@class,'dx-icon-spindown')]");
	public static final By SubRevision = By.xpath("//span[normalize-space()='Submit for Review']");
	public static final By YesButton2 = By.xpath("//div[@role='button' and @aria-label='Yes']//span[@class='dx-button-text']");
	public static final By ChangeBtn = By.xpath("//span[normalize-space()='Change Status']");
	//	public static final By ChangeStsDropDwn = By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/div/div/div[2]/div[2]");
	public static final By ChangeStsDropDwn = By.xpath("(//div[@role='button' and @class='dx-widget dx-button-normal dx-dropdowneditor-button'])[4]");
	//	public static final By ChangeStsDropDwn = By.xpath("(//div[@role='button' and @class='dx-widget dx-button-normal dx-dropdowneditor-button'])[4]");
	public static final By ReviewComplete = By.xpath("//div[@role='listbox']/div[@role='option'][3]/div[contains(@class,'dx-list-item-content')]");
	public static final By CheckBox = By.xpath("//div[@role='checkbox' and @aria-label='Select row']");
	public static final By Save = By.xpath("//span[normalize-space()='Save']");
	public static final By NominateBtn = By.xpath("//span[normalize-space()='Nominate Preferred Revision']");
	public static final By NominateDropDwn = By.xpath("(//div[@role='button' and @class='dx-widget dx-button-normal dx-dropdowneditor-button'])[4]");
	public static final By SelectRev = By.xpath("//div[@class='dx-item-content dx-list-item-content']");
	public static final By CONFIRM_YES = By.xpath("//div[contains(@class,'dx-button')][.//span[@class='dx-button-text' and normalize-space()='Yes']]");

	public void NominateRevisionsPage() throws InterruptedException {

		try {

			waits.waitForVisible(ESTIMATES);
			System.out.println("I am on Estimates page");

			click(ESTIMATES);

			System.out.println("Clicked on Estimates");
			Thread.sleep(2000);
			waits.waitForVisible(SEARCH);
			click(SEARCH);
			find(SEARCH).sendKeys("101985.01");
			System.err.println("Entered estimates");
			click(SEARCH);
			Thread.sleep(2000);
			WebElement PROJECTNO = driver.findElement(
					By.xpath("//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3']//span[text()='101985.01']"));
			waits.waitForVisible(PROJECTNO);
			Actions actions1 = new Actions(driver);
			actions1.contextClick(PROJECTNO).perform();
			click(ManageRevisions);
			click(AddRevision);
			click(SUBMIT);
			Thread.sleep(6000);
			click(CHEVRON);
			Thread.sleep(3000);



			try {

			    WebElement scrollContainer = driver.findElement(
			            By.xpath("//*[@id='gridContainer']//div[contains(@class,'dx-datagrid-rowsview')]//div[contains(@class,'dx-scrollable-container')]"));

			    JavascriptExecutor js = (JavascriptExecutor) driver;

			    long previousHeight = 0;

			    while (true) {

			        js.executeScript(
			                "arguments[0].scrollTop = arguments[0].scrollHeight;",
			                scrollContainer);

			        Thread.sleep(2000);

			        long currentHeight = ((Number) js.executeScript(
			                "return arguments[0].scrollHeight;",
			                scrollContainer)).longValue();

			        if (currentHeight == previousHeight) {
			            System.out.println("Reached bottom of grid");
			            break;
			        }

			        previousHeight = currentHeight;
			    }

			} catch (Exception e) {
			    e.printStackTrace();
			}

			Thread.sleep(2000);

			click(LastRevision);
//			WebElement ele = driver.findElement(
//				    By.xpath("//td[@aria-describedby='dx-col-1159-fixed' and contains(.,'Auto_cont-CT1')]"));

//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				js.executeScript("arguments[0].click();", ele);
			//	driver.findElement(By.xpath("//tr[.//td[@title='Automation_contractor_1-CTI']]")).click();

			//		selectProject();

			Thread.sleep(2000);
			click(CompleteButton);

			Thread.sleep(10000);


			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			WebElement dialog = wait.until(
					ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//div[@role='dialog'][.//*[contains(text(),'Do you want to mark all Sections and Items as Complete?')]]")
					)
			);

			wait.until(ExpectedConditions.elementToBeClickable(YesButton));
			click(YesButton);
			System.err.println("Revision Completed");
			Thread.sleep(1000);
			click(Request_Auth);
			System.err.println("Requested for Authorised Revision");
//			click(ReviAutho);
//			Thread.sleep(1000);
//			System.err.println("Revision Authorised");
//			Thread.sleep(20000);
//			click(Logoutdropdownarrow);
//			Thread.sleep(1000);
//			click(Logout);



		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}

	}
	public void RevisionAuthorisePage() throws InterruptedException{

		try {

			waits.waitForVisible(ESTIMATES);
			System.out.println("I am on Estimates page");

			click(ESTIMATES);

			System.out.println("Clicked on Estimates");
			Thread.sleep(2000);
			waits.waitForVisible(SEARCH);
			click(SEARCH);
			find(SEARCH).sendKeys("101985.01");
			System.err.println("Entered estimates");
			click(SEARCH);
			Thread.sleep(2000);
			WebElement PROJECTNO = driver.findElement(
					By.xpath("//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3']//span[text()='101985.01']"));
			waits.waitForVisible(PROJECTNO);
			Actions actions1 = new Actions(driver);
			actions1.contextClick(PROJECTNO).perform();
			click(ManageRevisions);
//			click(AddRevision);
//			click(SUBMIT);
//			Thread.sleep(3000);
			click(CHEVRON);
			Thread.sleep(3000);

			try {

				WebElement scrollContainer = driver.findElement(
						By.xpath("//*[@id='gridContainer']//div[contains(@class,'dx-datagrid-rowsview')]//div[contains(@class,'dx-scrollable-container')]"));

				JavascriptExecutor js = (JavascriptExecutor) driver;

				long previousHeight = 0;

				while (true) {

					js.executeScript(
							"arguments[0].scrollTop = arguments[0].scrollHeight;",
							scrollContainer);

					Thread.sleep(2000);

					long currentHeight = ((Number) js.executeScript(
							"return arguments[0].scrollHeight;",
							scrollContainer)).longValue();

					if (currentHeight == previousHeight) {
						System.out.println("Reached bottom of grid");
						break;
					}

					previousHeight = currentHeight;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			Thread.sleep(2000);



		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}

	}


	private void selectProject() throws InterruptedException {



		// TODO Auto-generated method stub
		try {

			CommonUtils utils = new CommonUtils(driver);
			int noOfRows = findElements(allrows).size();
			int row = utils.getRandomNumber(noOfRows);
//		        String xpath = String.format("(//tr[contains(@class,'dx-data-row')][%d]/td[3])", row);
			String xpath = "(//tr[contains(@class,'dx-data-row')][1]/td[3])";
			click(By.xpath(xpath));
			System.err.println("select project completed");

		} catch (Exception e) {
			System.err.println("select project not completed");
			System.err.println(e.getLocalizedMessage());

		}
	}




	public void ContractorRevisionsPage() throws InterruptedException{
		// TODO Auto-generated method stub

		try {

			waits.waitForVisible(ESTIMATES);
			Thread.sleep(10000);
			click(ESTIMATES);

			waits.waitForVisible(SEARCH);
			click(SEARCH);
			Thread.sleep(1000);
			find(SEARCH).sendKeys("101985.01");

			click(SEARCH);

			WebElement PROJECTNO = driver.findElement(
					By.xpath("//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3']//span[text()='101985.01']"));

			waits.waitForVisible(PROJECTNO);

			Actions actions1 = new Actions(driver);
			actions1.contextClick(PROJECTNO).perform();

			click(ManageRevisions);

			driver.navigate().refresh();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//span[normalize-space()='Estimate Revisions Management']")
			));

			Thread.sleep(5000);
			click(CHEVRON);
			Thread.sleep(5000);

			click(ActionBtn);
			Thread.sleep(2000);
			click(SubRevision);
			Thread.sleep(2000);
			WebElement dialog = wait.until(
					ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//div[@role='dialog'][.//*[contains(text(),'Are you sure you want to submit this revision for review? This action will lock the revision and its library and on-cost.')]]")
					)
			);

			wait.until(ExpectedConditions.elementToBeClickable(YesButton2));
			click(YesButton2);
			Thread.sleep(2000);
			System.err.println("Revision Submited for Review");

			Thread.sleep(2000);
//		        WebElement scrollContainer = driver.findElement(
//                By.xpath("//*[@id='gridContainer']//div[contains(@class,'dx-datagrid-rowsview')]//div[contains(@class,'dx-scrollable-container')]"));
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        long previousHeight = 0;
//	        while (true) {
//
//	            js.executeScript(
//	                    "arguments[0].scrollTop = arguments[0].scrollHeight;",
//	                    scrollContainer);
//
//	            Thread.sleep(2000);
//
//	            long currentHeight = ((Number) js.executeScript(
//	                    "return arguments[0].scrollHeight;",
//	                    scrollContainer)).longValue();
//
//	            if (currentHeight == previousHeight) {
//	                System.out.println("Reached bottom of grid");
//	                break;
//	            }
//
//	            previousHeight = currentHeight;
//	        }
//
//	        Thread.sleep(2000);
//           click(LastRevision);

		} catch (Exception e) {
			e.printStackTrace();
		}




	}


	public void RevisionCompleteReview() {
		// TODO Auto-generated method stub
		try {

			waits.waitForVisible(ESTIMATES);
			System.out.println("I am on Estimates page");

			click(ESTIMATES);

			System.out.println("Clicked on Estimates");
			Thread.sleep(2000);
			waits.waitForVisible(SEARCH);
			click(SEARCH);
			find(SEARCH).sendKeys("101985.01");
			System.err.println("Entered estimates");
			click(SEARCH);
			Thread.sleep(2000);
			WebElement PROJECTNO = driver.findElement(
					By.xpath("//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3']//span[text()='101985.01']"));
			waits.waitForVisible(PROJECTNO);
			Actions actions1 = new Actions(driver);
			actions1.contextClick(PROJECTNO).perform();
			click(ManageRevisions);
			click(CHEVRON);
			Thread.sleep(3000);
			click(CheckBox);
			Thread.sleep(3000);
			System.err.println("Checkbox Click Successfully");
			//		click(LastRevision);
			click(ChangeBtn);

			WebElement dialog = wait.until(
					ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//div[@role='dialog'][.//*[contains(text(),'Change Status')]]")));


			wait.until(ExpectedConditions.elementToBeClickable(ChangeStsDropDwn));
			click(ChangeStsDropDwn);

			Thread.sleep(10000);
			click(ReviewComplete);
			Thread.sleep(1000);
			click(Save);
			System.err.println("Revision Review Complete");

			click(NominateBtn);

			WebElement dialog2 = wait.until(
					ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//div[@role='dialog'][.//*[contains(text(),'Nominate Preferred Revision')]]")));


			wait.until(ExpectedConditions.elementToBeClickable(NominateDropDwn));
			click(NominateDropDwn);

			click(SelectRev);
			Thread.sleep(1000);
			click(Save);

			click(CONFIRM_YES);
			System.out.println("Clicked Yes on confirmation dialog");
			Thread.sleep(2000);
			System.err.println("Revision Nominated to preffered Complete");

		}catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}

	}



}