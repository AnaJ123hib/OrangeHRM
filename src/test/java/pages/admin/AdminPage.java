package pages.admin;

import org.openqa.selenium.By;
import pages.BasePage;

public class AdminPage extends BasePage {
    private final By adminButton =
            By.xpath("//span[text()='Admin']");
    private final By adminTitle = By.xpath("//h6[text()='Admin']");

    public void navigateToAdminModule() {
        click(adminButton);
    }

    public boolean isDisplayed() {
        return isVisible(adminTitle);
    }
}
