package pages.employeeManagement;

import models.Employee;
import org.openqa.selenium.By;
import pages.BasePage;

public class AddEmployeePage extends BasePage {
    private final By addEmployeeButton = By.xpath("//a[text()='Add employee']");
    private final By addEmployeeTitle = By.xpath("//a[text()='Add employee]");
    private final By firstNameInput = By.name("firstName");
    private final By middleNameInput = By.name("middleName");
    private final By lastNameInput = By.name("lastName");
    private final By idInput =
            By.xpath("//label[text()='Employee Id']/../following-sibling::div//input");
    private final By saveButton = By.xpath("//button[normalize-space()='Save']");
    private final By messageToast = By.xpath("//p[text()='Successfully Saved']");


    public void navigateToAddEmployee() {
        click(addEmployeeButton);
    }

    public boolean isDisplayed() {
        return isVisible(addEmployeeTitle);
    }

    public void addEmployee(Employee employee) {
        if(employee.getFirstName() != null) {
            type(firstNameInput, employee.getFirstName());
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
        click(saveButton);
        waitUntilVisible(messageToast);
    }
}
