package stepdefinitions.admin;

import config.ConfigurationManager;
import enums.UserColumn;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.admin.AdminPage;
import pages.admin.UserManagementPage;
import testdata.UserData;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserManagementSteps {
    private final AdminPage adminPage = new AdminPage();
    private final LoginPage loginPage = new LoginPage();
    private final UserManagementPage userManagementPage = new UserManagementPage();

    @Given("the user is on the User Management page")
    public void theUserIsOnTheUserManagementPage() {
        loginPage.loginAsAdmin();
        adminPage.navigateToAdminModule();
    }

    @When("the user searches for username {string}")
    public void anExitedUserIsSearchByUsername(String username) {
        userManagementPage.searchByUsername(username);
    }

    @When("the user filters by role {string}")
    public void theUserSearchByRole(String userRole) {
        userManagementPage.searchUserByRol(userRole);
    }

    @When("the user filters by status {string}")
    public void theUserSearchByStatus(String userStatus) {
        userManagementPage.searchUserByStatus(userStatus);
    }


    @Given("the user has entered a value in at least one search filter")
    public void theUserHasEnteredAValueInAtLeastOneSearchFilter() {
        userManagementPage.searchByUsername(ConfigurationManager.getProperty("username"));
    }

    @When("the user clicks the Reset button")
    public void theUserClicksTheResetButton() {
        userManagementPage.resetFilters();
    }

    @Then("all search filters should be cleared")
    public void allSearchFiltersShouldBeCleared() {
        assertTrue(userManagementPage.filtersAreCleared());
    }

    @When("the user creates a new user with valid information")
    public void theUserCreatesANewUserWithValidInformation() {
        userManagementPage.createUser(UserData.DEFAULT_USER);
    }

    @Then("the new user should be displayed in the results table")
    public void theNewUserShouldBeDisplayedInTheResultsTable() {
        userManagementPage.searchByUsername(UserData.DEFAULT_USER.getUsername());
        assertTrue(userManagementPage.allUsersHaveTheSameFilter(UserColumn.USERNAME, "userExample"));
        userManagementPage.deleteUser();
    }

    @Given("a valid user has been created")
    public void aValidUserHasBeenCreated() {
        userManagementPage.createUser(UserData.DEFAULT_USER);
    }

    @When("the user updates the created user with valid information")
    public void theUserUpdatesTheCreatedUserWithValidInformation() {
        userManagementPage.searchByUsername(UserData.EDITED_USER.getUsername());
        userManagementPage.editUser(UserData.EDITED_USER);
    }

    @Then("the created user should be displayed with the updated data in the result table")
    public void theCreatedUserShouldBeDisplayedWithTheUpdatedDataInTheResultTable() {
        userManagementPage.searchByUsername(UserData.EDITED_USER.getUsername());
        assertTrue(userManagementPage.allUsersHaveTheSameFilter(UserColumn.USERNAME, "usernameEdited"));
    }

    @When("the user deletes the created user")
    public void theUserDeletesTheCreatedUser() {
        userManagementPage.searchByUsername(UserData.DEFAULT_USER.getUsername());
        userManagementPage.deleteUser();
    }

    @Then("the created user shouldn't be displayed the result table")
    public void theCreatedUserShouldnTBeDisplayedTheResultTable() {
        userManagementPage.searchByUsername(UserData.DEFAULT_USER.getUsername());
        assertFalse(userManagementPage.allUsersHaveTheSameFilter(UserColumn.USERNAME, "userExample"));
    }

    @Then("all users should have {word} {string}")
    public void allUsersShouldHave(String column, String value) {
        UserColumn userColumn = UserColumn.from(column);
        assertTrue(userManagementPage.allUsersHaveTheSameFilter(userColumn, value));
    }
}
