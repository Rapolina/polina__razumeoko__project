package steps.not_cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"runner.fake"},
        features = {"src/main/java/resources/features/fake/FakeOne.feature"})

public class FakeRunner {
}
