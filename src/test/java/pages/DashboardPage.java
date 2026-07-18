package pages;

import org.openqa.selenium.By;

public class DashboardPage extends BasePage {
    private final By dashboardTitle = By.xpath("//h6[text()='Dashboard']");
    private final By userDropdown = By.cssSelector(".oxd-userdropdown");
    private final By assignLeaveButton = By.cssSelector("button[title='Assign Leave']");
    private final By leaveListButton = By.cssSelector("button[title='Leave List']");
    private final By timeSheetButton = By.cssSelector("button[title='Timesheets']");
    private final By applyLeaveButton = By.cssSelector("button[title='Apply Leave']");
    private final By myLeaveButton = By.cssSelector("button[title='My Leave']");
    private final By myTimesheetButton = By.cssSelector("button[title='My Timesheet']");
    private final By logoutButton = By.xpath("//a[text()='Logout']");
    private final By attendanceChart = By.cssSelector(".emp-attendance-chart");
    private final By attendanceSummary = By.cssSelector(".orangehrm-attendance-card-summary");
    private final By subUnitChart = By.cssSelector
            (".orangehrm-dashboard-widget:nth-child(6) .emp-distrib-chart");
    private final By locationChart = By.cssSelector
            (".orangehrm-dashboard-widget:nth-child(7) .emp-distrib-chart");
    public boolean isDisplayed() {
        return isVisible(dashboardTitle);
    }

    public void logout() {
        click(userDropdown);
        click(logoutButton);
    }

    public boolean isCardTitleDisplayed(String title) {
        return isVisible(cardTitleLocator(title));
    }
    private By cardTitleLocator(String title){
        return By.xpath("//p[text()='" + title + "']");
    }
    public boolean isQuickLaunchWidgetDisplayed() {
        return
                isCardTitleDisplayed("Quick Launch") &&
        isVisible(assignLeaveButton) &&
        isVisible(leaveListButton) &&
        isVisible(timeSheetButton) &&
        isVisible(applyLeaveButton) &&
        isVisible(myLeaveButton) &&
        isVisible(myTimesheetButton);
    }
    public boolean isTimeAtWorkWidgetDisplayed() {
        return
                isCardTitleDisplayed("Time at Work") &&
                        isVisible(attendanceSummary) &&
                        isVisible(attendanceChart);
    }
    public boolean isSubUnitChartDisplayed(){
        return
                isCardTitleDisplayed("Employee Distribution by Sub Unit") &&
                isVisible(subUnitChart);
    }
    public boolean isLocationChartDisplayed() {
        return
                isCardTitleDisplayed("Employee Distribution by Location") &&
                isVisible(locationChart);
    }
}
