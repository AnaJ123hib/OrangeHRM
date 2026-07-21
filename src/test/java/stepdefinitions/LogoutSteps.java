package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutSteps {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        loginPage.loginAsAdmin();
        assertTrue(dashboardPage.isDisplayed());
    }

    @When("the user logs out")
    public void theUserLogsOut() {
        dashboardPage.logout();
    }

    @Then("the login page should be displayed")
    public void theLoginPageShouldBeDisplayed() {
        assertTrue(loginPage.isLoginPageDisplayed());
    }

}
