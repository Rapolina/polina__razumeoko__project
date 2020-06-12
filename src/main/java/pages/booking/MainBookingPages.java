package pages.booking;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import web_driver.Driver;

import java.util.concurrent.TimeUnit;

public class MainBookingPages {


    @FindBy (xpath = "//*[@id='ss']")
    private static WebElement countryChoice;

    @FindBy (xpath = "//*[@data-mode='checkin']")
    private static WebElement checkInChoice;

    @FindBy (xpath = "//*[@data-mode='checkout']")
    private static WebElement checkOutChoice;

    @FindBy (xpath = "//*[@class='sb-searchbox__button ']")
    private static WebElement searchButton;

    @FindBy (xpath = "//*[@id=\"xp__guests__toggle\"]/span[2]/span[1]")
    private static WebElement guestInfo;

    @FindBy (xpath = "//*[@id=\"xp__guests__inputs-container\"]/div/div/div[1]/div/div[2]/button[2]/span")
    private static WebElement adultsInfo;

    @FindBy (xpath = "//*[@id=\"xp__guests__inputs-container\"]/div/div/div[2]/div/div[2]/button[2]")
    private static WebElement childrenInfo;

    @FindBy (xpath = "//*[@id=\"xp__guests__inputs-container\"]/div/div/div[3]/div/div[2]/button[2]/span")
    private static WebElement roomsInfo ;


    public static void findTheRightHotelInMoscow(String city, int chechIn, int checkOut){
        countryChoice.click();
        countryChoice.sendKeys(city);
        WebElement checkIN = Driver.getDriver().findElement(By.xpath(String.format("//*[@data-date='%s']", chechIn)));
        checkIN.click();
        WebElement checkOUT = Driver.getDriver().findElement(By.xpath(String.format("//*[@data-date='%s']", checkOut)));
        checkOUT.click();
        Actions builder = new Actions(Driver.getDriver());
        WebElement adults = Driver.getDriver().findElement(By.cssSelector("#group_adults"));
        builder.click(adults).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        WebElement rooms = Driver.getDriver().findElement(By.cssSelector("#no_rooms"));
        builder.click(rooms).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        searchButton.click();
    }



    public static void findTheRightHotelInOslo(String city, int chechIn, int checkOut){
        countryChoice.click();
        countryChoice.sendKeys(city);
        WebElement checkIN = Driver.getDriver().findElement(By.xpath(String.format("//*[@data-date='%s']", chechIn)));
        checkIN.click();
        WebElement checkOUT = Driver.getDriver().findElement(By.xpath(String.format("//*[@data-date='%s']", checkOut)));
        checkOUT.click();
        guestInfo.click();
        adultsInfo.click();
        adultsInfo.click();
        childrenInfo.click();
        searchButton.click();
    }


    public static void findTheRightHotelInParis(String city, int chechIn, int checkOut){
        countryChoice.click();
        countryChoice.sendKeys(city);
        WebElement checkIN = Driver.getDriver().findElement(By.xpath(String.format("//*[@data-date='%s']", chechIn)));
        checkIN.click();
        WebElement checkOUT = Driver.getDriver().findElement(By.xpath(String.format("//*[@data-date='%s']", checkOut)));
        checkOUT.click();
        guestInfo.click();
        adultsInfo.click();
        adultsInfo.click();
        adultsInfo.click();
        adultsInfo.click();
        roomsInfo.click();
        roomsInfo.click();

        searchButton.click();
    }

    public boolean elementIsDisplayed(String xpath){
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        return element.isDisplayed();
    }
}
