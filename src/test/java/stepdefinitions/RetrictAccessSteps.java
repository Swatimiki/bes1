package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import utilities.TestContext;

public class RetrictAccessSteps {
	
	
		
	private TestContext context = Hooks.getContext();

	
	@Then("User checks the Access restrictions")
	public void check_on_the_access() throws InterruptedException {
		context.getPageManager().getRestrictAccessToRevisionsPage().AccessToRevisions();
	
}
}