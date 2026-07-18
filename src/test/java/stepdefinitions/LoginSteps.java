package stepdefinitions;

import config.ConfigurationManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    @Given("the user is on OrangeHRM login page")
    public void theUserIsOnTheLoginPage() {
        assertTrue(loginPage.isLoginPageDisplayed());
    }

    @When("the user logins with valid credentials")
    public void theUserLoginsWithValidCredentials() {
        loginPage.login(
                ConfigurationManager.getProperty("username"),
                ConfigurationManager.getProperty("password")
        );
    }

    @When("the user logs in with invalid credentials")
    public void theUserLogsInWithInvalidCredentials() {
        loginPage.login(
                ConfigurationManager.getProperty("username"),
                ConfigurationManager.getProperty("invalid.password"));
    }

    @Then("Dashboard should be displayed")
    public void dashboardShouldBeDisplayed() {
        assertTrue(dashboardPage.isDisplayed());
    }

    @Then("the message {string} should be displayed")
    public void anAuthenticationErrorMessageShouldBeDisplayed(String expectedMessage) {
        String errorMessage = loginPage.getAuthenticationErrorMessage();
        assertEquals(expectedMessage, errorMessage);
    }


    @When("the user logins with unregistered username")
    public void theUserLoginsWithUnregisteredUsername() {
        loginPage.login(
                ConfigurationManager.getProperty("invalid.username"),
                ConfigurationManager.getProperty("password"));
    }

    @When("the user attempts to log in without entering credentials")
    public void theUserAttemptsToLogInWithoutEnteringCredentials() {
        loginPage.login("","");
    }

    @Then("the username field should display a required validation message")
    public void theUsernameFieldShouldDisplayARequiredValidationMessage() {
        assertEquals("Required", loginPage.isUsernameRequiredMessageDisplayed());
    }

    @And("the password field should display a required validation message")
    public void thePasswordFieldShouldDisplayARequiredValidationMessage() {
        assertEquals("Required", loginPage.isPasswordRequiredMessageDisplayed());
    }

}
