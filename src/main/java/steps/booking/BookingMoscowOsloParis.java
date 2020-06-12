package steps.booking;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.booking.MainBookingPages;
import pages.booking.DetailsBookingPages;
import settings.ScreenView;
import web_driver.Driver;

public class BookingMoscowOsloParis {
    static WebDriver driver;
    static MainBookingPages mainBookingPages;
    static DetailsBookingPages detailsBookingPagesPage;


    int realPriceMoscow;
    int expectedPriceMoscow;
    int realPriceParis;
    int expectedPriceParis;



    @Before
    public void getPages() {
        driver = Driver.getDriver();
   //     mainBookingPages = new MainBookingPages(driver);
        detailsBookingPagesPage = new DetailsBookingPages(driver);
    }

    @Given("I open website booking.com")
    public void IOpenWebsite() {
        Driver.followTheLinkSetWindowMode ("https://www.booking.com/", ScreenView.MAX);
    }

    @Then("I am looking for hotels in Moscow")
    public void IAmLookingForTheHotelInMoscow (){
        MainBookingPages.findTheRightHotelInMoscow("Moscow", 10, 15);
    }

    @And("I filter hotels with the lowest cost")
    public void IFilterHotelsWithLowestPrice (){
       expectedPriceMoscow = detailsBookingPagesPage.getHotelsWithLowestPriceInMoscow();
       //realPriceMoscow = detailsBookingPagesPage.
    }



    @Then("I am looking for hotels in Oslo")
    public void IAmLookingForTheHotelInOslo (){ MainBookingPages.findTheRightHotelInOslo("Oslo", 1, 1);
    }

    @Then("I am looking for hotels in Paris]")
    public void IAmLookingForTheHotelInParis (){ MainBookingPages.findTheRightHotelInParis("Paris", 3, 10);
    }


}
