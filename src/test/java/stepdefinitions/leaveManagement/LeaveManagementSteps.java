package stepdefinitions.leaveManagement;

import enums.LeavesColumn;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.leaveManagement.LeavePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeaveManagementSteps {
    private final LeavePage leavePage = new LeavePage();
    private final LoginPage loginPage = new LoginPage();

    @Given("the user is on the Leave page")
    public void theUserIsOnTheLeavePage() {
        loginPage.loginAsAdmin();
        leavePage.navigateToLeavePage();
    }

    @Then("Leave Management should be displayed")
    public void leaveManagementShouldBeDisplayed() {
        assertTrue(leavePage.isDisplayed());
    }

    @When("the user searches leave records by {word} {string}")
    public void theUserSearchesLeaveRecordsBy(String colum,String value) {
        LeavesColumn leavesColumn = LeavesColumn.from(colum);
        leavePage.searchLeavesBy(leavesColumn, value);
    }

    @Then("all leave records by {word} {string} should be displayed")
    public void leaveRecordsByEmployeeShouldBeDisplayed(String colum, String value) {
        LeavesColumn leavesColumn = LeavesColumn.from(colum);
        assertTrue(leavePage.allEmployeesAreSearchedBy(leavesColumn, value));
    }
}
