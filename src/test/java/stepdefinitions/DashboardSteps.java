package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.DashboardPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DashboardSteps {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    @Then("Quick launch widget should be displayed")
    public void quickLaunchWidgetShouldBeDisplayed() {
        assertTrue(dashboardPage.isQuickLaunchWidgetDisplayed());
    }

    @Then("Time at work widget should be displayed")
    public void timeWorkWidgetShouldBeDisplayed() {
        assertTrue(dashboardPage.isTimeAtWorkWidgetDisplayed());
    }

    @Then("Sub Unit widget should be displayed")
    public void isSubUnitDistributionWidgetDisplayed() {
        assertTrue(dashboardPage.isSubUnitChartDisplayed());
    }

    @And("Location widget should be displayed")
    public void isLocationDistributionWidgetDisplayed() {
        assertTrue(dashboardPage.isCardTitleDisplayed("Employee Distribution by Location"));
        assertTrue(dashboardPage.isLocationChartDisplayed());
    }
}
