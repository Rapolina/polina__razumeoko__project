package runner.booking;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps.base", "steps.gui"},
        features = {
                "src/test/resources/ApiTest.feature"
        },
       // tags = {"@qa or @prod"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE
        //strict = false
        )

public class cucumberRunner {
}

