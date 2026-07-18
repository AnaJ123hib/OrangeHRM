package pages;

import config.ConfigurationManager;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By invalidCredentialMessage =
            By.xpath("//p[text()='Invalid credentials']");
    private final By usernameRequired =
            By.xpath("(//span[text()='Required'])[1]");

    private final By passwordRequired =
            By.xpath("(//span[text()='Required'])[2]");

    public boolean isLoginPageDisplayed() {
        return isVisible(loginButton);
    }
    public void login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
    }

    public void loginAsAdmin() {
        type(usernameInput, ConfigurationManager.getProperty("username"));
        type(passwordInput, ConfigurationManager.getProperty("password"));
        click(loginButton);
    }

    public String getAuthenticationErrorMessage(){
        return getText(invalidCredentialMessage);
    }

    public String isUsernameRequiredMessageDisplayed() {
        return getText(usernameRequired);
    }

    public String isPasswordRequiredMessageDisplayed() {
        return getText(passwordRequired);
    }
}
