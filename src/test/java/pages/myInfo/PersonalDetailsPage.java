package pages.myInfo;

import components.Dropdown;
import models.Employee;
import org.openqa.selenium.By;
import pages.BasePage;

public class PersonalDetailsPage extends BasePage {
    private final By myInfoButton = By.xpath("//a[normalize-space()='My Info']");
    private final By personalPageTitle = By.xpath("//h6[text()='Personal Details']");
    private final By firstNameInput = By.name("firstName");
    private final By lastNameInput = By.name("lastName");
    private final By nationalityDropdown =
            By.xpath("//label[text()='Nationality']/../following-sibling::div/div/div");
    private final By maritalStatusDropdown =
            By.xpath("//label[text()='Marital Status']/../following-sibling::div/div/div");
    private final By dateOfBirthPickup =
            By.xpath("//label[text()='Date of Birth']/../following-sibling::div//input");

    private final By savePersonalInfoButton =
            By.xpath("//div[.//h6[normalize-space()='Personal Details']]//button[normalize-space()='Save']");

    private final By messageToast = By.xpath("//p[text()='Successfully Saved']");

    private final Dropdown dropdown = new Dropdown();
    public void navigateToMyInfo() {
        click(myInfoButton);
    }
    public boolean isDisplayed() {
        return isVisible(personalPageTitle);
    }

    public void updatePersonalDetails(Employee employee) {
        if(employee.getFirstName() != null) {
            type(firstNameInput,employee.getFirstName());
        }
        else if(employee.getLastName() != null) {
            type(lastNameInput,employee.getLastName());
        }
        else if(employee.getNationality() != null) {
            dropdown.select(nationalityDropdown, employee.getNationality());
        }
        else if(employee.getMaritalStatus() != null) {
            dropdown.select(maritalStatusDropdown, employee.getMaritalStatus());
        }
        else if(employee.getDateOfBirth() != null) {
            type(dateOfBirthPickup, employee.getDateOfBirth());
        }
        click(savePersonalInfoButton);
        waitUntilVisible(messageToast);
    }

    public boolean isPersonalDetailsUpdated(Employee employee) {
        if(employee.getFirstName() != null &&
                !getValue(firstNameInput).equals(employee.getFirstName())) {
            return false;
        }
        else if(employee.getLastName() != null &&
                !getValue(lastNameInput).equals(employee.getLastName())) {
            return false;
        }
        else if(employee.getNationality() != null &&
                !dropdown.getSelectedOption(nationalityDropdown).equals(employee.getNationality())) {
            return false;
        }
        else if(employee.getMaritalStatus() != null &&
                !dropdown.getSelectedOption(maritalStatusDropdown).equals(employee.getMaritalStatus())) {
            return false;
        }
        else return employee.getDateOfBirth() == null ||
                    getValue(dateOfBirthPickup).equals(employee.getDateOfBirth());
    }

}
