package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import utilities.TestContext;

public class PSLSteps {

    private TestContext context = Hooks.getContext();

    @Then("User navigate to Project Specific Library section")
    public void user_navigate_to_psl_section() throws InterruptedException {
        context.getPageManager().getPSLManagementPage().navigateToPSLSection();
    }

}