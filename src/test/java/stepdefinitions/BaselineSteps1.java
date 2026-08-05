package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;

import static hooks.Hooks.context;

public class BaselineSteps1 {
    @Then("User navigates to Estimate Baseline Page")
    public void userNavigatesToEstimateBaselinePage() {
        // Write code here that turns the phrase above into concrete actions
        context.getPageManager().getEstimateRevisionsManagementPage().estimaterevisions();
        throw new PendingException();
    }
}
