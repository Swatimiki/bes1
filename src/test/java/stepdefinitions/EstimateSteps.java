package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.TestContext;

public class EstimateSteps {
	private TestContext context = Hooks.getContext();


	@Then("User navigates to Estimates section")
	public void click_on_the_estimate_button() throws InterruptedException {
		context.getPageManager().getEstimateRevisionsManagementPage().estimaterevisions();
	}

	@Then("User navigates to Authorization section")
	public void click_on_the_authorize_button() throws InterruptedException {
		context.getPageManager().getEstimateRevisionsManagementPage().Authorization();
	}
}