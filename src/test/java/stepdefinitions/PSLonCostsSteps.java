package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import utilities.TestContext;

public class PSLonCostsSteps {
	
	
	private TestContext context = Hooks.getContext();
	
	@Then("User navigates to PSLONCOSTS section")
	public void click_on_the_psloncost() throws InterruptedException {
		context.getPageManager().getPSLCreatedfromONCOSTPage().psloncost();
	
	}

}
