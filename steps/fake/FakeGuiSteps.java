package steps.fake_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import settings.Config;
import steps.utils.FakeWaiter;
import web_driver.Driver;

import java.util.concurrent.TimeUnit;

public class FakeGuiSteps {

   /* @Given(" I go to tut.by")
    public void checkHeaderTest(){
        Driver.getDriver().get("https://tut.by");
    }

    @When("I start waiting")
    public void checkFooterTest() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Then("I just passed")
    public void verify(){
        Assert.assertTrue(true);
    }
*/

    @Given("I go to tut.by")
    public void i_go_to_tut_by() {
        Driver.getDriver().get("https://tut.by");
    }

    @When("I start waiting")
    public void i_start_waiting() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        TimeUnit.SECONDS.sleep(3);
    }

    @Then("I just passed")
    public void i_just_passed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(true);
    }}
