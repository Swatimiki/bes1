package pages;

import org.openqa.selenium.By;
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
	public static final By ReviAutho = By.xpath("//div[@role='button' and @aria-label='🛡️✔️ Authorize']//span[@class='dx-button-text']");



	public void NominateRevisionsPage() throws InterruptedException {

		try {

			waits.waitForVisible(ESTIMATES);
			System.out.println("I am on Estimates page");

			click(ESTIMATES);

			System.out.println("Clicked on Estimates");
			Thread.sleep(2000);
			waits.waitForVisible(SEARCH);
			click(SEARCH);
			find(SEARCH).sendKeys("101886.01");
			System.err.println("Entered estimates");
			click(SEARCH);
			WebElement PROJECTNO = driver.findElement(
					By.xpath("//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3']//span[text()='101886.01']"));
			waits.waitForVisible(PROJECTNO);
			Actions actions1 = new Actions(driver);
			actions1.contextClick(PROJECTNO).perform();
			click(ManageRevisions);
//			click(AddRevision);
//			click(SUBMIT);

			click(CHEVRON);
			Thread.sleep(2000);
			selectProject();
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
			click(ReviAutho);









		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}



	}




	private void selectProject() {
		// TODO Auto-generated method stub
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
}