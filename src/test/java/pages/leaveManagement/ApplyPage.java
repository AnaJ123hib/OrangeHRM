package pages.leaveManagement;

import components.Dropdown;
import components.Table;
import models.Apply;
import org.openqa.selenium.By;
import pages.BasePage;

import java.time.format.DateTimeFormatter;

public class ApplyPage extends BasePage {
    private final By applyLeaveButton = By.xpath("//a[text()='Apply']");
    private final By myLeaveButton = By.xpath("//a[text()='My Leave']");
    private final By applyTitle = By.xpath("//h6[text()='Apply Leave']");
    private final By leaveTypeDropdown =
            By.xpath("//label[normalize-space()='Leave Type']/../following-sibling::div/div/div");
    private final By durationDropdown =
            By.xpath("//label[normalize-space()='Duration']/../following-sibling::div/div/div");
    private final By commentsInput =
            By.xpath("//label[text()='Comments']/../following-sibling::div/textarea");
    private final By fromDateInput =
            By.xpath("//label[normalize-space()='From Date']/../following-sibling::div//input");
    private final By toDateInput =
            By.xpath("//label[normalize-space()='To Date']/../following-sibling::div//input");
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final Dropdown dropdown = new Dropdown();
    private final By applyButton = By.xpath("//button[normalize-space()='Apply']") ;
    private final By messageToast = By.xpath("//p[text()='Successfully Saved']");
    private final Table table = new Table();
    private final By tableMyLeave = By.cssSelector(".oxd-table");
    private final By cancelButton = By.xpath("//button[normalize-space='Cancel']");
    private final By searchButton = By.xpath("//button[normalize-space='Search']");

    public void navigateToApplyPage() {
        click(applyLeaveButton);
    }
    public void navigateToMyLeave(){
        click(myLeaveButton);
    }
    public boolean isDisplayed(){
        return isVisible(applyTitle);
    }

    public void createApplyLeave(Apply apply) {
        dropdown.select(leaveTypeDropdown, apply.getLeaveType());
        type(fromDateInput, apply.getFromDate().format(formatter));
        type(toDateInput, apply.getFromDate().format(formatter));
        dropdown.select(durationDropdown, apply.getDuration());
        type(commentsInput, apply.getComments());
        click(applyButton);
        waitUntilVisible(messageToast);
    }

    private void searchLeaveRecord(Apply apply) {
        waitUntilVisible(tableMyLeave);
        System.out.println(driver.findElement(tableMyLeave).getSize());
        dropdown.select(leaveTypeDropdown, apply.getLeaveType());
        type(fromDateInput, apply.getFromDate().format(formatter));
        click(searchButton);
    }
    public boolean findMyLeaveRecord(Apply apply) {
        searchLeaveRecord(apply);

        return table.findOneSingleRecord(tableMyLeave, apply.getComments()) &&
        table.findOneSingleRecord(tableMyLeave, apply.getFromDate().toString()) &&
        table.findOneSingleRecord(tableMyLeave, apply.getLeaveType());
    }

    public void cancelLeaveRecord(Apply apply) {
        searchLeaveRecord(apply);
        click(cancelButton);
    }

    public boolean leaveRecordIsCanceled(Apply apply) {
        searchLeaveRecord(apply);
        return table.findOneSingleRecord(tableMyLeave, "Canceled");
    }
}
