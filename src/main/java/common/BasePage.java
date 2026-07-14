package common;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	protected WebElement find(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	protected List<WebElement> findElements(By locator) {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	protected void enterText(By locator, String text) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		try {
			element.click();
			Thread.sleep(1500);
			element.clear();
			element.sendKeys(text);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	protected void click(By locator) {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
			System.out.println("Element click Success: " + element);
		} catch (Exception e) {
			try {
				WebElement element = driver.findElement(locator);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				System.out.println("Element click Success (JS): " + element);
			} catch (Exception e2) {
				WebElement element = driver.findElement(locator);
				Actions actions = new Actions(driver);
				actions.moveToElement(element).click().build().perform();
				System.out.println("Element click Success (Actions): " + element);
			}
		}
	}

	protected String getText(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}
}