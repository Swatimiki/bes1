package hooks;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
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

		String driverPath = "C:\\Users\\swattrip\\Downloads\\edgedriver_win64\\msedgedriver.exe";
		File driverFile = new File(driverPath);

		if (!driverFile.exists())
			throw new RuntimeException("msedgedriver.exe not found at: " + driverPath);

		System.setProperty("webdriver.edge.driver", driverPath);

		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
		//options.addArguments("--headless");

		EdgeDriverService service = new EdgeDriverService.Builder().usingDriverExecutable(driverFile).build();

		try {
			WebDriver driver = new EdgeDriver(service, options);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			context.setDriver(driver);
			context.setWait(new WebDriverWait(driver, Duration.ofSeconds(60)));
			context.setPageManager(null);

		} catch (Exception e) {
			System.err.println("Failed to launch Edge. Error: " + e.getMessage());
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