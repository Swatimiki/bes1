package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import utilities.TestContext;

public class ValidationDeletePSL {

    private TestContext context = Hooks.getContext();

    @Then("User navigates to Estimate Revisions Management Page")
    public void user_navigates_to_estimate_revisions_page() throws InterruptedException {
        context.getPageManager().getPSLManagementPage().searchAndNavigateToRevisions();
    }

    @Then("User navigate to Project Specific Library section")
    public void user_navigate_to_psl_section() throws InterruptedException {
        context.getPageManager().getPSLManagementPage().navigateToPSLSection();
    }

    @Then("User clicks on use existing from another baseline")
    public void user_clicks_use_existing_from_baseline() throws InterruptedException {
        context.getPageManager().getPSLManagementPage().selectUseExistingOption();
    }

    @Then("User selects estimate from the popup")
    public void user_selects_estimate_from_popup() throws InterruptedException {
        context.getPageManager().getPSLManagementPage().selectEstimateFromPopup();
    }

    @Then("User clicks on save")
    public void user_clicks_on_save() throws InterruptedException {
        context.getPageManager().getPSLManagementPage().clickSave();
    }

    @Then("User views Project Specific Library")
    public void user_views_psl() throws InterruptedException {
        context.getPageManager().getPSLManagementPage().viewProjectSpecificLibrary();
    }

    @Then("navigate back to Estimate Revisions Management")
    public void navigate_back_to_estimate_revisions_management() throws InterruptedException {
        context.getPageManager().getPSLManagementPage().navigateBackToEstimateRevisions();
    }

    @Then("click on Project Specific Library dropdown")
    public void click_on_psl_dropdown() throws InterruptedException {
        context.getPageManager().getPSLManagementPage().navigateToPSLSection();
    }

    @Then("click on Delete Project Specific Library option")
    public void click_on_delete_project_specific_library_option() throws InterruptedException {
        context.getPageManager().getPSLManagementPage().clickDeleteProjectSpecificLibraryOption();
    }

    @Then("User should get error message {string}")
    public void user_should_get_error_message(String expectedErrorMessage) throws InterruptedException {
        context.getPageManager().getPSLManagementPage().verifyErrorMessage(expectedErrorMessage);
    }
}