package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import common.BasePage;
import common.WaitUtils;

public class NominatingtheRevisionToPreferredStatus extends BasePage {
	
	public NominatingtheRevisionToPreferredStatus(WebDriver driver) {
		super(driver);

}
	WaitUtils waits = new WaitUtils(driver);

	public static final By ESTIMATES = By.xpath("//div[@aria-label='Estimates']//span[@class='dx-button-text']");
	public static final By SEARCH = By.xpath("//input[@placeholder='Search']");
	public static final By ManageRevisions = By.xpath("//span[normalize-space()='Manage Revisions']");
	public static final By CHEVRON = By.xpath("//i[@class='fa-solid fa-chevron-up']");
	
	
	
	
	
	
	
	
	
	
	
	public void NominateRevisions() throws InterruptedException {

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
			click(CHEVRON);
	         
	
	
	
	
	
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	
	

}}
