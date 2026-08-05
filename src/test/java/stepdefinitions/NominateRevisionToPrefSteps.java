package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import utilities.TestContext;

public class NominateRevisionToPrefSteps {

    private TestContext context = Hooks.getContext();

//    @Then("User navigates to NominateRevisions section")
//    public void user_navigates_to_nominate_revisions_section() throws InterruptedException  {
//        context.getPageManager().getNominatingtheRevisionToPreferredStatus().NominateRevisionsPage();
//        // throw new io.cucumber.java.PendingException();
//    }

//	@Then("User navigates to NominateRevisions section")
//	public void click_on_the_nominate_pef_revision_button1() throws InterruptedException {
//		context.getPageManager().getNominatingtheRevisionToPreferredStatus().NominateRevisions();
//		 throw new io.cucumber.java.PendingException();
//	}

    @Then("Admin navigates to Nominate Revisions section")
    public void user_navigates_to_nominate_revisions_section() throws InterruptedException {
        context.getPageManager().getNominatingtheRevisionToPreferredStatus().NominateRevisionsPage();
    }

    @Then("Contractor navigates to Revisions section")
    public void user_navigates_to_revisions_section() throws InterruptedException {
        context.getPageManager().getNominatingtheRevisionToPreferredStatus().ContractorRevisionsPage();
    }

    @Then("Admin complete the review complete process")
    public void user_complete_the_review_complete_process() throws InterruptedException {
        context.getPageManager().getNominatingtheRevisionToPreferredStatus().RevisionCompleteReview();
    }

    @Then("Admin2 authorised the revision")
    public void user_authorised_the_revision() throws InterruptedException {
        context.getPageManager().getNominatingtheRevisionToPreferredStatus().RevisionAuthorisePage();
    }
}

