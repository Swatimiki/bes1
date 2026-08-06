package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utilities.TestContext;
import hooks.Hooks;

public class BaselineSteps1 {
    private TestContext context = Hooks.getContext();

    @Then("User navigates to Estimate Baseline Page")
    public void userNavigatesToEstimateBaselinePage() throws InterruptedException  {
        // Write code here that turns the phrase above into concrete actions
        context.getPageManager().getEstimateRevisionsManagementPage().estimatebaseline();
    }

    @And("User edit any Resources")
    public void userEditAnyResources() throws InterruptedException {
        context.getPageManager().getEstimateRevisionsManagementPage().editResource();
    }



}
