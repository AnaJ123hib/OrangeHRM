package components;

import org.openqa.selenium.By;
import pages.BasePage;

public class Autocomplete extends BasePage {
    private By dropdownOption(String value) {
        return By.xpath(
                "//div[contains(@class,'oxd-autocomplete-option')][.//span[normalize-space()='" +
                        value +
                        "']]"
        );
    }
    public void select(By input, String value) {
        type(input, value);
        waitUntilInvisible(By.cssSelector(".oxd-autocomplete-dropdown"));
        By option = dropdownOption(value);
        waitUntilVisible(option);
        click(option);
    }
}
