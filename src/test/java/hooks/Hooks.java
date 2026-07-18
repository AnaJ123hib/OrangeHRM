package hooks;

import config.ConfigurationManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import driver.DriverFactory;

public class Hooks {
    @Before
    public void setUp(){
        DriverFactory.initializeDriver();
        DriverFactory.getDriver().get(ConfigurationManager.getProperty("base.url"));
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
