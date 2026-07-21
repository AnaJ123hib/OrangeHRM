package stepdefinitions.admin;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.admin.AdminPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminSteps {
    private final AdminPage adminPage = new AdminPage();

    @When("the user navigates to the Admin module")
    public void theUserNavigatesToTheAdminModule() {
        adminPage.navigateToAdminModule();
    }

    @Then("the Admin page should be displayed")
    public void theAdminPageShouldBeDisplayed() {
        assertTrue(adminPage.isDisplayed());
    }
}
