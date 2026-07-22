package components;

import org.openqa.selenium.By;
import pages.BasePage;
import testdata.ApplyData;

public class Table extends BasePage {
    public boolean findOneSingleRecord(By table, String value) {

        String tableText = driver.findElement(table).getText();
        return tableText.contains(value);
    }
}
