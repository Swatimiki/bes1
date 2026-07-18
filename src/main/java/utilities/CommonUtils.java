package utilities;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;

public class CommonUtils extends BasePage {

	public CommonUtils(WebDriver driver) {
		super(driver);
	}

	public int getRandomNumber(int max) {
		Random random = new Random();
		return random.nextInt(max) + 1; // 1 to max
	}

	public void scrollToElement(WebElement element) {
		if (element == null)
			return;

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'});",
					element);
			Thread.sleep(300);
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	public void scrollToMiddle() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo({ top: document.body.scrollHeight / 2, behavior: 'smooth' });");
			Thread.sleep(300);
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	public void scrollToElementInGrid(WebElement container, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"arguments[0].scrollTop = arguments[1].offsetTop - arguments[0].offsetTop - (arguments[0].clientHeight / 2);",
					container, element);
			Thread.sleep(300);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
