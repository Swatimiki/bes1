package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.TestContext;

public class EstimateSteps1 {

	private TestContext context = Hooks.getContext();


	@Then("User navigates to Estimates section1")
	public void click_on_the_estimate_button() throws InterruptedException {
		context.getPageManager().getEstimateRevisionsManagementPage().estimaterevisions();
	}

	@Given("User Navigates to search the project on estimate page")
	public void user_navigates_to_search_the_project_on_estimate_page() throws InterruptedException {
		context.getPageManager().getEstimateRevisionsManagementPage().estimaterevisions();
        context.getPageManager().getEstimateRevisionsManagementPage().CreateRevision();


	}


}
