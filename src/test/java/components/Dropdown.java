package components;

import org.openqa.selenium.By;
import pages.BasePage;

public class Dropdown extends BasePage {
    public void select(By dropdown, String option) {
        click(dropdown);
        By optionLocator = By.xpath(
                "//div[contains(@class,'oxd-select-dropdown')]//span[normalize-space()='" +
                        option + "']"
        );
        click(optionLocator);
    }
}
