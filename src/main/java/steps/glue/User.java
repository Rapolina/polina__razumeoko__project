package steps.glue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class User {


    @Given("I start execution")
    public void iStartExecution() {
        System.out.println("I start execution");

    }

    @When("I search user by \"(.*)\"  name")
    public void iSearchUserByName(String string) {
        System.out.println("I search user by  name");

    }

    @Then("I verify that I got \"(.*)\" ")
    public void iVerifyThatIGot(String string) {
        System.out.println("I verify that I got ");
    }
}
