package steps.fake_steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import settings.Config;
import web_driver.Driver;


public class FakeBaseSteps {
    private static final Logger LOGGER = LogManager.getLogger(FakeBaseSteps.class);

    @Before
    public void beforeTest(){
        LOGGER.info("Initializing WebDriver...");
        Driver.initDriver(Config.CHROME);
    }

    @After
    public  void afterTest(){
        LOGGER.info("Killing WebDriver");
        Driver.destroy();
    }
}
