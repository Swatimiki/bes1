package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.TestContext;

public class ViewandUpdatePSLSteps {

    private TestContext context = Hooks.getContext();

    // Add your step definitions here for ViewandUpdatePSL.feature

    @Then("User clicks on View or Update button")
    public void user_clicks_on_view_update_button() throws InterruptedException {
        context.getPageManager().getViewandUpdatePSLPage().clickViewUpdateButton();
    }

    @Then("User updates the EPD details in the popup")
    public void user_updates_the_epd_details_in_the_popup() throws InterruptedException {
        context.getPageManager().getViewandUpdatePSLPage().updateEPDDetails();
    }

    @Then("User clicks on save button in the popup")
    public void user_clicks_on_save_button_in_the_popup() throws InterruptedException {
        context.getPageManager().getViewandUpdatePSLPage().clickPopupSaveButton();
    }

    @Then("Updated EPD details should be highlighted in Project Specific Library")
    public void updated_epd_details_should_be_highlighted_in_project_specific_library() throws InterruptedException {
        context.getPageManager().getViewandUpdatePSLPage().verifyUpdatedEPDDetailsHighlighted();
    }

    @When("User clicks on save button in Project Specific Library Page")
    public void user_clicks_on_save_button_in_project_specific_library_page() throws InterruptedException {
        context.getPageManager().getViewandUpdatePSLPage().clickSaveButtonInPSLPage();

    }

    @Then("User should verify the updated EPD details in the popup")
    public void user_should_verify_the_updated_epd_details_in_the_popup() throws InterruptedException {
        context.getPageManager().getViewandUpdatePSLPage().verifyUpdatedEPDDetailsInPopup();
    }

    @Then("User clicks on close button")
    public void user_clicks_on_close_button() throws InterruptedException {
        context.getPageManager().getViewandUpdatePSLPage().clickCloseButton();
    }
}

