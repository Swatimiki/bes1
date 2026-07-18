package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

	private WebDriver driver;
	private WebDriverWait wait;

	public WaitUtils(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	// ✅ Wait for visibility
	public WebElement waitForVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// ✅ Wait for clickable
	public WebElement waitForClickable(By locator) {
		return wait.until(driver -> {
			WebElement el = driver.findElement(locator);
			return (el.isDisplayed() && el.isEnabled()) ? el : null;
		});
	}

	// ✅ Wait for presence (DOM only)
	public WebElement waitForPresence(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// ✅ Wait for invisibility
	public boolean waitForInvisibility(By locator) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	// ✅ Wait for URL
	public boolean waitForUrlContains(String value) {
		return wait.until(ExpectedConditions.urlContains(value));
	}

	// ✅ Wait for element to disappear (useful for loaders)
	public boolean waitForLoaderToDisappear(By loader) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	}

	public void waitForVisible(WebElement projectno) {
		// TODO Auto-generated method stub

	}

	public void isPageReady(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			for (int i = 0; i < 200; i++) {
				Thread.sleep((long) (1 * 1000));
				if ("complete".equalsIgnoreCase(js.executeScript("return document.readyState").toString())) {
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
