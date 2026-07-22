package stepdefinitions.myInfo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.myInfo.PersonalDetailsPage;
import testdata.EmployeeData;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonalDetailsSteps {
    private LoginPage loginPage = new LoginPage();
    private PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();

    @Given("the user is on Personal Details page")
    public void theUserIsOnPersonalDetailsPage() {
        loginPage.loginAsAdmin();
        personalDetailsPage.navigateToMyInfo();
    }

    @Then("the Personal Details page should be displayed")
    public void thePersonalDetailsPageShouldBeDisplayed() {
        assertTrue(personalDetailsPage.isDisplayed());
    }

    @When("the user updates the first name")
    public void theUserUpdatesTheFirstName() {
        personalDetailsPage.updatePersonalDetails(EmployeeData.EDITED_FIRST_NAME);
    }

    @Then("the updated first name should be displayed in Personal Details")
    public void theUpdatedFirstNameShouldBeDisplayedInPersonalDetails() {
        assertTrue(personalDetailsPage.isPersonalDetailsUpdated(EmployeeData.EDITED_FIRST_NAME));
    }

    @When("the user updates the last name")
    public void theUserUpdatesTheLastName() {
        personalDetailsPage.updatePersonalDetails(EmployeeData.EDITED_LAST_NAME);
    }

    @Then("the updated last name should be displayed in Personal Details")
    public void theUpdatedLastNameShouldBeDisplayedInPersonalDetails() {
        assertTrue(personalDetailsPage.isPersonalDetailsUpdated(EmployeeData.EDITED_LAST_NAME));
    }

    @When("the user updates the nationality")
    public void theUserUpdatesTheNationality() {
        personalDetailsPage.updatePersonalDetails(EmployeeData.EDITED_NATIONALITY);
    }

    @Then("the updated nationality should be displayed in Personal Details")
    public void theUpdatedNationalityShouldBeDisplayedInPersonalDetails() {
        assertTrue(personalDetailsPage.isPersonalDetailsUpdated(EmployeeData.EDITED_NATIONALITY));
    }

    @When("the user updates the marital status")
    public void theUserUpdatesTheMaritalStatus() {
        personalDetailsPage.updatePersonalDetails(EmployeeData.EDITED_MARITAL_STATUS);
    }

    @Then("the updated marital status should be displayed in Personal Details")
    public void theUpdatedMaritalStatusShouldBeDisplayedInPersonalDetails() {
        assertTrue(personalDetailsPage.isPersonalDetailsUpdated(EmployeeData.EDITED_MARITAL_STATUS));
    }

    @When("the user updates the date of birth")
    public void theUserUpdatesTheDateOfBirth() {
        personalDetailsPage.updatePersonalDetails(EmployeeData.EDITED_DATE_OF_BIRTH);
    }

    @Then("the updated date of birth should be displayed in Personal Details")
    public void theUpdatedDateOfBirthShouldBeDisplayedInPersonalDetails() {
        assertTrue(personalDetailsPage.isPersonalDetailsUpdated(EmployeeData.EDITED_DATE_OF_BIRTH));
    }
}
