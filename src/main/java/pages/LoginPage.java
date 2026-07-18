package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import common.BasePage;
import common.WaitUtils;

public class LoginPage extends BasePage {
	
	
	public static final By USERNAME = By.cssSelector(
			"input[formcontrolname='username'], input#username, input[name='username'], input[type='text'], input[placeholder*='Username']");

	public static final By PASSWORD = By.cssSelector(
			"input[formcontrolname='password'], input#password, input[name='password'], input[type='password'], input[placeholder*='Password']");

	public static final By LOGIN_BUTTON = By.cssSelector("input.dx-button-submit-input[type='submit']");

	public static final By DASHBOARD = By.xpath("//*[contains(text(),'Dashboard')] | //app-dashboard");

	public static final By ALERTMSG = By
			.cssSelector(".alert-danger, .error, mat-error, .login-error, .message-box, .dx-invalid-message");

	
		
	

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	WaitUtils waitUtils = new WaitUtils(driver);

	public void openURL() {
		driver.get("https://sw-uat.webapp.benchmarkestimating.com/#/login");
	}

	public void enterCredentials(String username, String password) {

		find(USERNAME).sendKeys(username);

		var passwordField = find(PASSWORD);
		passwordField.clear();
		passwordField.sendKeys(password);
		passwordField.sendKeys(Keys.TAB);
	}

	public void clickOnLogin() {
		click(LOGIN_BUTTON);
	}

	public boolean isLoginSuccessful() {
		try {
			boolean urlCheck = wait.until(
					driver -> driver.getCurrentUrl().contains("dashboard") || driver.getCurrentUrl().contains("home"));
			return urlCheck;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isLoginFailed() {
		try {
			wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(ALERTMSG),
					ExpectedConditions.urlContains("login")));
			return true;
		} catch (Exception e) {
			return false;
			}
	}
}