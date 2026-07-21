package pages;

import common.BasePage;
import common.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class RestrictAccessToRevisionsPage extends BasePage {
	
	
	public RestrictAccessToRevisionsPage(WebDriver driver) {
		super(driver);

}
	WaitUtils waits = new WaitUtils(driver);

	public static final By ESTIMATES = By.xpath("//div[@aria-label='Estimates']//span[@class='dx-button-text']");
	public static final By SEARCH = By.xpath("//input[@placeholder='Search']");
	public static final By ManageRevisions = By.xpath("//span[normalize-space()='Manage Revisions']");
	public static final By CHEVRON = By.xpath("//i[@class='fa-solid fa-chevron-up']");
	public static final By Logoutdropdownarrow = By.xpath(
			"//div[@class='dx-widget dx-button dx-button-mode-text dx-button-normal user-button']//div[@class='dropdown-arrow']");
	public static final By ACTIONIcon = By.xpath("//td[@class='dx-cell-focus-disabled']//i[@class='dx-icon dx-icon-spindown']");
	public static final By SUBMITFORREVIEW = By.xpath("//span[normalize-space()='Submit for Review']");
	
	
	
	
	
	
	
	
	public void AccessToRevisions() throws InterruptedException {

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
			
			// Locate all rows of the grid
			List<WebElement> rows = driver.findElements(By.xpath("//div[@class='dx-scrollable-content']"));

			for (WebElement row : rows) {

			    // Locate checkbox inside each row
			    WebElement checkbox = row.findElement(By.xpath("//div[contains(@class,'dx-datagrid')]//div[contains(@class,'dx-checkbox') and @aria-checked='false']"));

			    // Check if checkbox is unchecked
			    if (!checkbox.isSelected()) {
			        checkbox.click();   // check it
			        //break;             
			    }
			}
			
			Thread.sleep(4000);
			click(Logoutdropdownarrow);

			System.out.println("Enetered into Authorization method");
			WebElement dropdown = driver.findElement(
					By.xpath("//div[@class='dx-item-content dx-menu-item-content']/span[text()='Logout']"));
			dropdown.click();

			WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
			Username.sendKeys("Anil.kumar");

			WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
			Password.sendKeys("Test@2026");
			
			Thread.sleep(2000);
			WebElement Login = driver.findElement(By.xpath("//div[@role='button']//div[text()='Log In'] "));
			Login.click();
			
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
			WebElement PROJECTNO1 = driver.findElement(
					By.xpath("//tr[contains(@class,'dx-data-row')]//td[@aria-colindex='3']//span[text()='101886.01']"));
			waits.waitForVisible(PROJECTNO1);
			Thread.sleep(2000);
			Actions actions2 = new Actions(driver);
			actions2.contextClick(PROJECTNO).perform();
			click(ManageRevisions);
			click(CHEVRON);
			click(ACTIONIcon);
			click(SUBMITFORREVIEW);
			
			
			
			
			
			
			
			

		
			
			
			
			
			
			
			

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	
	
}
	}