package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;;
import settings.Config;
import web_driver.Driver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BookingParisTest {
    @Before
    public void beforeMethod() {
        Driver.initDriver(Config.CHROME);
    }

    @Test
    public void bookingParis() throws InterruptedException {
        Driver.getDriver().get("https://www.booking.com/");
        WebElement direction = Driver.getDriver().findElement(By.cssSelector("#ss"));
        direction.sendKeys(Keys.chord(Keys.COMMAND, "a"), "Paris");

        WebElement period = Driver.getDriver().findElement(By.xpath("//*[@data-mode='checkin']"));
        period.click();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        Date threeDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date tenDays = calendar.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusThreeDays = dateFormat.format(threeDays);
        String datePlusTenDays = dateFormat.format(tenDays);
        WebElement checkIn = Driver.getDriver().findElement(By.xpath(String.format("//*[@data-date='%s']", datePlusThreeDays)));
        checkIn.click();
        WebElement checkOut = Driver.getDriver().findElement(By.xpath(String.format("//*[@data-date='%s']", datePlusTenDays)));
        checkOut.click();

        WebElement guestInfo = Driver.getDriver().findElement(By.xpath("//*[@id=\"xp__guests__toggle\"]/span[2]/span[1]"));
        guestInfo.click();
        WebElement adultsNumber = Driver.getDriver().findElement(By.xpath("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[1]/div/div[2]/button[2]/span"));
        adultsNumber.click();
        adultsNumber.click();
        WebElement number0fRooms = Driver.getDriver().findElement(By.xpath("//*[@id=\"xp__guests__inputs-container\"]/div/div/div[3]/div/div[2]/button[2]/span"));
        number0fRooms.click();

        WebElement search = Driver.getDriver().findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button/span[1]"));
        search.click();
        Thread.sleep(5000);

        WebElement budget = Driver.getDriver().findElement(By.xpath("//*[@id=\"filter_price\"]/div[2]/a[5]/label/div"));
        budget.click();

        String expensiveHotel = budget.getText().replaceAll("[^0-9]+", "");
        System.out.println("The most expensive hotel costs  per night:" + expensiveHotel);
        int expensiveHotelPerNight = Integer.parseInt(expensiveHotel);
        Thread.sleep(5000);

        WebElement lowBudget = Driver.getDriver().findElement(By.xpath("//*[@id=\"sort_by\"]/ul/li[3]/a"));
        lowBudget.click();

        WebElement MinFromMax = Driver.getDriver().findElement(By.xpath("//*[@data-hotelid][1]//div[contains(@class,'bui-price-display__value')]"));
        String minPriceFromMax = MinFromMax.getText().replaceAll("[^0-9]+", "");
        int hotelPerNight = Integer.parseInt(minPriceFromMax) / 7;
        System.out.println("Minimum price per night from " + hotelPerNight);

        Assert.assertTrue("Something wrong", hotelPerNight >= expensiveHotelPerNight);

    }

    @After
    public void afterMethod() {
        Driver.destroy();
        Driver.driver.remove();
    }
}

