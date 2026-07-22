package stepdefinitions.employeeManagement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.employeeManagement.AddEmployeePage;
import pages.employeeManagement.EmployeeDetailsPage;
import pages.employeeManagement.EmployeeListPage;
import testdata.EmployeeData;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeManagementSteps {
    private final LoginPage loginPage = new LoginPage();
    private final EmployeeListPage employeeListPage = new EmployeeListPage();
    private final AddEmployeePage addEmployeePage = new AddEmployeePage();
    private final EmployeeDetailsPage employeeDetailsPage = new EmployeeDetailsPage();

    @Given("the user is on the Employee Management page")
    public void theUserIsOnTheEmployeeManagementPage() {
        loginPage.loginAsAdmin();
        employeeListPage.navigateToEmployeeManagementPage();
    }

    @Then("Employee Management page should be displayed")
    public void employeeManagementPageShouldBeDisplayed() {
        assertTrue(employeeListPage.isDisplayed());
    }

    @When("the user search an employee by name")
    public void theUserSearchAnEmployeeByName() {
        employeeListPage.searchBy(EmployeeData.FULL_NAME);
    }

    @Then("the employee should be displayed")
    public void theEmployeeShouldBeDisplayed() {
        assertTrue(employeeListPage.isTheResultMatching(EmployeeData.FULL_NAME));
    }

    @When("the user search an employee by id")
    public void theUserSearchAnEmployeeById() {
        employeeListPage.searchBy(EmployeeData.ID);
    }

    @Then("the employee id should be displayed")
    public void theEmployeeIdShouldBeDisplayed() {
        assertTrue(employeeListPage.isTheResultMatching(EmployeeData.ID));
    }

    @Given("the user is in Add Employee page")
    public void theUserIsInAddEmployeePage() {
        addEmployeePage.navigateToAddEmployee();
    }

    @When("the user creates a new employee with valid information")
    public void theUserCreatesANewEmployeeWithValidInformation() {
        addEmployeePage.addEmployee(EmployeeData.DEFAULT_EMPLOYEE);
    }

    @Then("the new employee should be displayed in the results table")
    public void theNewEmployeeShouldBeDisplayedInTheResultsTable() {
        employeeListPage.navigateToEmployeeManagementPage();
        employeeListPage.searchBy(EmployeeData.DEFAULT_EMPLOYEE);
        assertTrue(employeeListPage.isTheResultMatching(EmployeeData.DEFAULT_EMPLOYEE));
    }

    @When("the user updates the created employee with valid information")
    public void theUserUpdatesTheCreatedEmployeeWithValidInformation() {
        employeeListPage.navigateToEmployeeManagementPage();
        employeeListPage.searchBy(EmployeeData.FULL_NAME);
        employeeListPage.editEmployee();
        employeeDetailsPage.editEmployee(EmployeeData.FULLY_EDITED_EMPLOYEE);
    }

    @Then("the edited employee should be displayed")
    public void theEditedEmployeeShouldBeDisplayed() {
        assertTrue(employeeDetailsPage.isEmployeeEdited(EmployeeData.FULLY_EDITED_EMPLOYEE));
    }
}
