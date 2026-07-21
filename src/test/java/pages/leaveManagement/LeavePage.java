package pages.leaveManagement;

import enums.LeavesColumn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class LeavePage extends BasePage {
    private final By leaveManagementButton = By.xpath("//span[text()='Leave']");
    private final By leaveTitle =
            By.xpath("//h5[normalize-space()='Leave List']");
    private final By employeeInput =
            By.xpath("//label[normalize-space()='Employee Name']/../following-sibling::div//input");
    private final By leavesResult =
            By.cssSelector(".oxd-table-card");
    private final By employeeDropdown =
            By.cssSelector(".oxd-autocomplete-option");
    private final By leavesEmployee =
            By.xpath("//div[contains(@class,'oxd-table-row')]//div[@role='cell'][3]/div");
    private final By leavesStatus =
            By.xpath("//div[contains(@class,'oxd-table-row')]//div[@role='cell'][7]/div");

    private final By searchButton = By.xpath("//button[normalize-space()='Search']");
    private final By statusDropdown =
            By.xpath("//label[text()='Show Leave with Status']/../following-sibling::div/div/div");
    private final By dropdownOptions = By.cssSelector(".oxd-select-dropdown");

    public boolean isDisplayed(){
        return isVisible(leaveTitle);
    }

    private By employeeDropdownOption(String employeeName) {
        return By.xpath(
                "//div[contains(@class,'oxd-autocomplete-option')][.//span[normalize-space()='" +
                        employeeName +
                        "']]"
        );
    }
    private void selectEmployee(String employee) {
        type(employeeInput, employee);
        waitUntilVisible(employeeDropdown);
        By employeeOption = employeeDropdownOption(employee);
        waitUntilClickable(employeeOption);
        click(employeeOption);
    }

    private By selectDropdownOption(String option) {
        waitUntilVisible(dropdownOptions);
        return By.xpath("//div[contains(@class,'oxd-select-option')]" +
                "[.//span[text()='"+ option +"']]");
    }
    private void selectStatus(String status) {
        click(statusDropdown);
        click(selectDropdownOption(status));
    }
    private List<String> getByFilter(String value) {
        By option = switch (value) {
            case "employee" -> leavesEmployee;
            case "status" -> leavesStatus;
            default -> throw new IllegalArgumentException("Invalid filter: " + value);
        };

        return driver.findElements(option)
                .stream()
                .map(WebElement::getText)
                .map(text -> text.replaceAll("\\s*\\(.*\\)", "").trim())
                .toList();
    }
    private List<String> getEmployees(){
        return getByFilter("employee");
    }
    private List<String> getStatus() {
        return getByFilter("status");
    }
    public void navigateToLeavePage() {
        click(leaveManagementButton);
    }
    public void searchLeavesBy(LeavesColumn column, String value) {
         switch (column) {
            case EMPLOYEE -> selectEmployee(value);
            case STATUS -> selectStatus(value);

        }
         click(searchButton);
         waitUntilVisible(leavesResult);

    }

    public boolean allEmployeesAreSearchedBy(LeavesColumn column, String value) {
        return switch (column) {
            case EMPLOYEE ->
                    getEmployees().stream().allMatch(employee -> employee.equals(value));
            case STATUS ->
                    getStatus().stream().allMatch(employee -> employee.equals(value));
        };
    }
}
