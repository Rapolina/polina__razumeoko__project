package pages.booking;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsBookingPages {

    public DetailsBookingPages(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//*[@data-id='pri-1']")
    private WebElement lowestPriceInfo;

   // @FindBy(xpath =)
    //private WebElement priceInfo;

    @FindBy(xpath = "//*[@data-id='class-3']")
    private WebElement starsThree;

    @FindBy(xpath = "//*[@data-id='class-4']")
    private WebElement startsFour;

    @FindBy(xpath = "//*[@data-hotelid][10]")
    private WebElement findTenthHotel;

    public int getHotelsWithLowestPriceInMoscow() {
        lowestPriceInfo.click();
        return 0;
    }

    public int getHotelWithPriceInMoscow() {
        return 0;
    }

    public void selectStars() {
        starsThree.click();
        startsFour.click();
    }

    public void findTenthHotel() {
        findTenthHotel.click();

    }
}
