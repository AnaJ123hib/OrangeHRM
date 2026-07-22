package pages.employeeManagement;

import components.Autocomplete;
import components.Table;
import models.Employee;
import org.openqa.selenium.By;
import pages.BasePage;

public class EmployeeListPage extends BasePage {
    private final By pimButton = By.xpath("//a[normalize-space()='PIM']");
    private final By employeeManagementPage = By.xpath("//h5[normalize-space()='Employee Information']");
    private final By nameInput =
            By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
    private final By idInput =
            By.xpath("//label[text()='Employee ID']/../following-sibling::div//input");

    private final By searchButton = By.xpath("//button[normalize-text()='Search']");
    private final By employeeTableResult =By.cssSelector(".orangehrm-employee-list");
    private final By editButton = By.cssSelector(".oxd-table-cell-actions button:nth-child(2)");

    private final Autocomplete autocomplete = new Autocomplete();
    private final Table table = new Table();
    public void navigateToEmployeeManagementPage() {
        click(pimButton);
    }
    public boolean isDisplayed(){
        return isVisible(employeeManagementPage);
    }

    public void searchBy(Employee employee) {
        if(employee.getFullName() != null) {
            autocomplete.select(nameInput,employee.getFullName());
        }
        if(employee.getEmployeeId() != null) {
            type(idInput, employee.getEmployeeId());
        }
        click(searchButton);
        waitUntilVisible(employeeTableResult);
    }

    public boolean isTheResultMatching(Employee employee) {
        if(employee.getFullName() != null
                && table.findOneSingleRecord(employeeTableResult, employee.getFirstName())) {
            return false;
        }
        else return employee.getEmployeeId() == null
                || !table.findOneSingleRecord(employeeTableResult, employee.getEmployeeId());
    }

    public void editEmployee() {
        click(editButton);
    }
}
