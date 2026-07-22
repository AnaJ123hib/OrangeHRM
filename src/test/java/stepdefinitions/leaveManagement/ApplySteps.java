package stepdefinitions.leaveManagement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.leaveManagement.ApplyPage;
import pages.leaveManagement.LeavePage;
import testdata.ApplyData;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplySteps {
    private final LoginPage loginPage = new LoginPage();
    private final LeavePage leavePage = new LeavePage();
    private final ApplyPage applyPage = new ApplyPage();

    @Given("the user is on Apply Leave page")
    public void theUserIsOnApplyLeavePage() {
        loginPage.loginAsAdmin();
        leavePage.navigateToLeavePage();
        applyPage.navigateToApplyPage();
    }

    @Then("Apply page should be displayed")
    public void applyPageShouldBeDisplayed() {
        assertTrue(applyPage.isDisplayed());
    }

    @When("the user applies leave with valid information")
    public void theUserAppliesLeaveWithValidInformation() {
        applyPage.createApplyLeave(ApplyData.DEFAULT);
    }

    @Then("the leave request should be displayed in the leave list")
    public void theLeaveRequestShouldBeDisplayedInTheLeaveList() {
        applyPage.navigateToMyLeave();
        assertTrue(applyPage.findMyLeaveRecord(ApplyData.DEFAULT));
    }

    @Given("a pending leave request exists")
    public void aPendingLeaveRequestExists() {
        applyPage.createApplyLeave(ApplyData.DEFAULT);
    }

    @When("the user cancels the leave request")
    public void theUserCancelsTheLeaveRequest() {
        applyPage.navigateToMyLeave();
        applyPage.cancelLeaveRecord(ApplyData.DEFAULT);
    }

    @Then("the leave request status should be Cancelled")
    public void theLeaveRequestStatusShouldBeCancelled() {
        assertTrue(applyPage.leaveRecordIsCanceled(ApplyData.DEFAULT));
    }
}
