package runner.booking.destinations.moscow;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import web_driver.Driver;


import javax.swing.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps.cucumber.booking.trip_paris"},
        features = {"src/main/resources/features/booking/BookingMoscowOsloParis.feature"

        },

        monochrome = true,
        snippets = SnippetType.CAMELCASE
)
public class MoscowRunner {
        static WebDriver driver;

        @BeforeClass
        public static void start() {
                driver = Driver.getDriver();
        }

        @AfterClass
        public static void close() {
                Driver.destroy();
        }


}
