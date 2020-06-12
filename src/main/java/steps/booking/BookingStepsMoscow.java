package steps.booking;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import settings.Config;
import settings.ScreenView;
import web_driver.Driver;

public class BookingStepsMoscow {
    int staying = 5;
    int checkIn = 10;
    int adults = 4;
    int children = 0;
    int numberOfRooms = 1;
    String maxPrice;
    WebElement webElement;
    private static final Logger LOGGER = LogManager.getLogger(BookingStepsMoscow.class);

    @Given("I open website booking.com")
    public void iOpenWebsiteBookingCom () {
        LOGGER.info("start");
        Driver.initDriver(Config.CHROME);
        Driver.followTheLinkSetWindowMode ("https://www.booking.com/", ScreenView.MAX);
    }

    @Then("I fill necessary fields such as country, check in, check out")
    public void IFillNecessaryFields () {
    }

    @Then("I use actions to enter adults and rooms")
    public void IUseActionsToEnterAdultsAndRooms () {
        Actions actions = new Actions(Driver.getDriver());

    }

}
