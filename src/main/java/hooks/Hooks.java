package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.TestContext;

public class Hooks {

	private static TestContext context = new TestContext();

	public Hooks() {
	}

	@Before
	public void setup() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
		//options.addArguments("--headless");

		try {
			// Selenium Manager (built into Selenium 4.21) resolves chromedriver automatically
			WebDriver driver = new ChromeDriver(options);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			context.setDriver(driver);
			context.setWait(new WebDriverWait(driver, Duration.ofSeconds(60)));
			context.setPageManager(null);

		} catch (Exception e) {
			System.err.println("Failed to launch Chrome. Error: " + e.getMessage());
			throw e;
		}
	}

	@After
	public void tearDown() {

		if (context.getDriver() != null)
			//context.getDriver().quit();

		context.setDriver(null);
		context.setWait(null);
		context.setPageManager(null);
	}

	public static TestContext getContext() {
		return context;
	}
}