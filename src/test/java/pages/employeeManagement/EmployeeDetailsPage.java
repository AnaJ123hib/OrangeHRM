package pages.employeeManagement;

import components.Dropdown;
import models.Employee;
import org.openqa.selenium.By;
import pages.BasePage;

public class EmployeeDetailsPage extends BasePage {
    private final By nameInput = By.name("firstName");
    private final By middleNameInput = By.name("middleName");
    private final By lastNameInput = By.name("lastName");
    private final By idInput = By.xpath("//label[text()=''Employee Id]" +
            "/../following-next::div//input");
    private final By nationalityDropdown = By.xpath("//label[text()=''Nationality]" +
            "/../following-next::div/div/div");
    private final By maritalStatusDropdown = By.xpath("//label[text()=''Marital Status]" +
            "/../following-next::div/div/div");
    private Dropdown dropdown = new Dropdown();
    private final By savePersonalInfoButton =
            By.xpath("//div[.//h6[normalize-space()='Personal Details']]//button[normalize-space()='Save']");

    private final By messageToast = By.xpath("//p[text()='Successfully Saved']");

    private final By editForm = By.cssSelector(".orangehrm-edit-employee-content");

    public void editEmployee(Employee employee) {
        waitUntilVisible(editForm);
        if(employee.getFirstName() != null) {
            type(nameInput, employee.getFirstName());
        }
        if(employee.getMiddleName() != null) {
            type(middleNameInput, employee.getMiddleName());
        }
        if(employee.getLastName() != null) {
            type(lastNameInput, employee.getLastName());
        }
        if(employee.getEmployeeId() != null) {
            type(idInput, employee.getEmployeeId());
        }
        if(employee.getNationality() != null) {
            dropdown.select(nationalityDropdown, employee.getNationality());
        }
        if(employee.getMaritalStatus() != null) {
            dropdown.select(maritalStatusDropdown, employee.getMaritalStatus());
        }
        click(savePersonalInfoButton);
        waitUntilVisible(messageToast);
    }

    public boolean isEmployeeEdited(Employee employee) {
        return employee.getFirstName().equals(getValue(nameInput)) &&
                employee.getMiddleName().equals(getValue(middleNameInput)) &&
                employee.getLastName().equals(getValue(lastNameInput)) &&
                employee.getEmployeeId().equals(getValue(idInput)) &&
                employee.getNationality().equals(dropdown.getSelectedOption(nationalityDropdown)) &&
                employee.getMaritalStatus().equals(dropdown.getSelectedOption(maritalStatusDropdown));
    }
}
