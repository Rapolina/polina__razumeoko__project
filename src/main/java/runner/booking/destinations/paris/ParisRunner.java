package runner.booking.destinations.paris;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps.cucumber.booking.trip_paris"},
        features = {"src/test/resources/features/booking/BookingParisTest.feature"
        },

        monochrome = true,
        snippets = SnippetType.CAMELCASE
)
public class ParisRunner {
}
