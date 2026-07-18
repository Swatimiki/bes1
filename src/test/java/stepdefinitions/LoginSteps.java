package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.TestContext;

public class LoginSteps {

	private TestContext context = Hooks.getContext();

	@Given("Login page")
	public void i_am_on_the_login_page() {
		context.getPageManager().getLoginPage().openURL();
	}

	@When("Enter username {string} and password {string}")
	public void i_enter_username_and_password(String username, String password) {
		context.getPageManager().getLoginPage().enterCredentials(username, password);
	}

	@And("Click on the login button")
	public void i_click_on_the_login_button() {
		context.getPageManager().getLoginPage().clickOnLogin();
	}

	@Then("Logged in based on {string}")
	public void i_should_able_to_login_based_on(String expectedStatus) {
		
		if (expectedStatus.equalsIgnoreCase("success"))
			Assert.assertTrue("Login Success!", context.getPageManager().getLoginPage().isLoginSuccessful());
		else
			Assert.assertTrue("Error message not displayed!", context.getPageManager().getLoginPage().isLoginFailed());
	}

	@Then("Redirect to the dashboard")
	public void i_should_be_redirected_to_the_dashboard() {

		context.getWait()
				.until(ExpectedConditions.or(ExpectedConditions.urlContains("dashboard"),
						ExpectedConditions.urlContains("home"), ExpectedConditions.visibilityOfElementLocated(
								By.xpath("//*[contains(text(),'Dashboard')] | //app-dashboard"))));

		String currentUrl = context.getDriver().getCurrentUrl();

		Assert.assertTrue(currentUrl.contains("dashboard") || currentUrl.contains("home"));
	}
}
