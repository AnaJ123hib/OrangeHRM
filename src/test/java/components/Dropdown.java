package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    public String getSelectedOption(By dropdown) {

        WebElement dropdownElement = driver.findElement(dropdown);

        return dropdownElement
                .findElement(By.cssSelector(".oxd-select-text-input"))
                .getText();
    }
}
