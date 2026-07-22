package pages.admin;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import enums.UserColumn;

import java.util.List;

public class UserManagementPage extends BasePage {

    private final By usernameInput =
            By.xpath("//label[text()='Username']/../following-sibling::div/input");
    private final By roleDropdown =
            By.xpath("//label[text()='User Role']/../following-sibling::div/div");
    private final By searchButton = By.xpath("//button[normalize-space()='Search']");
    private final By usernameDesktop =
            By.xpath("//div[contains(@class,'oxd-table-row')]//div[@role='cell'][2]/div");
    private final By usernameMobile  =
            By.xpath("//div[@class='header' and text()='Username']/following-sibling::div[@class='data']");
    private final By userTableRows =
            By.cssSelector(".oxd-table-body .oxd-table-card");
    private final By userRole =
            By.xpath("//div[contains(@class,'oxd-table-row')]//div[@role='cell'][3]/div");
    private final By statusDropdown =By.xpath("//label[text()='Status']/..//following-sibling::div/div");
    private final By userStatus =
            By.xpath("//div[contains(@class,'oxd-table-row')]//div[@role='cell'][5]/div");
    private final By resetButton = By.xpath("//button[normalize-space()='Reset']");
    private final By addUserButton = By.xpath("//button[normalize-space()='Add']");
    private final By passwordInput = By.xpath("//label[text()='Password']/..//following-sibling::div/input");
    private final By confirmPasswordInput = By.xpath("//label[text()='Confirm Password']/..//following-sibling::div/input");
    private final By employeeInput = By.xpath("//label[text()='Employee Name']/..//following-sibling::div/div/div/input");
    private final By employeeDropdown = By.cssSelector(".oxd-autocomplete-dropdown");
    private final By saveButton = By.xpath("//button[normalize-space()='Save']");

    private final By deleteButton = By.cssSelector(".oxd-table-cell-actions button:first-child");
    private final By editButton = By.cssSelector(".oxd-table-cell-actions button:nth-child(2)");
    private final By confirmationDeleteButton = By.xpath("//button[normalize-space()='Yes, Delete']");
    public void searchByUsername(String username) {
        type(usernameInput, username);
        click(searchButton);
        waitUntilUserTableLoads();
    }

    private void waitUntilUserTableLoads() {
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(userTableRows));
    }

    private By dropdownOption(String userOption) {
        return By.xpath(
                "//div[contains(@class,'oxd-select-dropdown')]//div[@role='option'][.//span[normalize-space()='" + userOption + "']]"
        );
    }

    private void selectEmployee(String employeeName) {
        type(employeeInput, employeeName);
        waitForVisibility(employeeDropdown);
        By option = employeeDropdownOption(employeeName);
        waitForVisibility(option);
        click(option);
    }

    private By employeeDropdownOption(String employeeName) {
        return By.xpath(
                "//div[contains(@class,'oxd-autocomplete-option')][.//span[normalize-space()='" +
                        employeeName +
                        "']]"
        );
    }

    private List<String> getRoles() {
        List<WebElement> elements;
        elements = driver.findElements(userRole);
        return elements.stream()
                .map(WebElement::getText)
                .toList();
    }

    public List<String> getUsernames() {

        List<WebElement> elements;

        if (!driver.findElements(usernameDesktop).isEmpty()) {
            elements = driver.findElements(usernameDesktop);
        } else {
            elements = driver.findElements(usernameMobile);
        }

        return elements.stream()
                .map(WebElement::getText)
                .toList();
    }

    private List<String> getStatus() {
        List<WebElement> elements;
        elements = driver.findElements(userStatus);
        return elements.stream()
                .map(WebElement::getText)
                .toList();
    }

    private void selectRole(String role) {
        click(roleDropdown);
        click(dropdownOption(role));
    }

    private void selectStatus(String status) {
        click(statusDropdown);
        click(dropdownOption(status));
    }
    public boolean allUsersHaveTheSameFilter(UserColumn column, String userFilter) {
        return switch (column) {
            case ROLE ->
                    getRoles().stream().allMatch(role -> role.equals(userFilter));

            case USERNAME ->
                    getUsernames().stream().allMatch(username -> username.equals(userFilter));

            case STATUS ->
                    getStatus().stream().allMatch(status -> status.equals(userFilter));

        };
    }

    public void searchUserByRol(String userRole) {
        click(roleDropdown);
        click(dropdownOption(userRole));
        click(searchButton);
        waitUntilUserTableLoads();
    }

    public void searchUserByStatus(String userStatus) {
        selectStatus(userStatus);
        click(searchButton);
        waitUntilUserTableLoads();
    }

    public void resetFilters() {
        click(resetButton);
    }

    public boolean filtersAreCleared() {
        return
                getValue(usernameInput).isEmpty() &&
                        getText(roleDropdown).equals("-- Select --")
                && getText(statusDropdown).equals("-- Select --");
    }

    private void fillUserForm(User user, boolean includePassword){
        if (!user.getUsername().isBlank()) {
            type(usernameInput, user.getUsername());
        }

        selectEmployee(user.getEmployee().getFullName());

        if (!user.getStatus().isBlank()) {
            selectStatus(user.getStatus());
        }

        if (!user.getRole().isBlank()) {
            selectRole(user.getRole());
        }
        if(includePassword) {
            type(passwordInput, user.getPassword());
            type(confirmPasswordInput, user.getPassword());
        }
    }
    public void createUser(User user) {
        click(addUserButton);
        fillUserForm(user, true);
        click(saveButton);
        waitForVisibility(searchButton);
    }

    public void deleteUser() {
        click(deleteButton);
        waitForVisibility(confirmationDeleteButton);
        click(confirmationDeleteButton);
    }

    public void editUser(User user) {
        click(editButton);
        fillUserForm(user, false);
        click(saveButton);
        waitForVisibility(searchButton);
    }
}


