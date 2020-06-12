package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import settings.Config;
import steps.BaseSteps;
import steps.SpecialSteps;
import web_driver.Driver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static tests.BookingNewAccoutTest.yandexEmail;
import static tests.BookingNewAccoutTest.yandexPassword;

public class BookingFavouritesTest {
    static String BOOKING_URL = "https://www.booking.com/";
    int daysShift = 30;
    int daysAmount = 5;
    String firstHotel;
    String secondHotel;

    @Before
    public void beforeMethod() {
        Driver.initDriver(Config.CHROME);
    }

    @Test
    public void addToFavoritesTest() throws InterruptedException {
        Driver.getDriver().get(BOOKING_URL);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"current_account\"]")).click();
        TimeUnit.SECONDS.sleep(3);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(yandexEmail);
        TimeUnit.SECONDS.sleep(3);
        Driver.getDriver().findElement(By.xpath("//*[@type=\"submit\"]")).click();
        TimeUnit.SECONDS.sleep(4);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(yandexPassword);
        Driver.getDriver().findElement(By.xpath("//*[@type=\"submit\"]")).click();
        TimeUnit.SECONDS.sleep(4);
        Driver.getDriver().findElement(By.xpath("//*[@id='ss']")).click();
        BaseSteps.findElementClick(Driver.getDriver(), "//*[@data-mode='checkin']");
        BaseSteps.findElementClick(Driver.getDriver(), String.format("//*[@data-date='%s']", SpecialSteps.setDays(daysShift)));
        BaseSteps.findElementClick(Driver.getDriver(), String.format("//*[@data-date='%s']", SpecialSteps.setDays(daysShift + daysAmount)));
        BaseSteps.findElementClick(Driver.getDriver(), "(//*[contains(@type,'submit')])[1]");
        TimeUnit.SECONDS.sleep(3);
    }

    public void setFavoritesCheckClolor() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[1]/div[1]/div/button")).click();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[1]/div[1]/div/button/*[1]"));
        TimeUnit.SECONDS.sleep(2);


    }
}
