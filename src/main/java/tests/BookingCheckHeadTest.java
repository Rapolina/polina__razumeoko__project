package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import settings.Config;
import web_driver.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static tests.BookingNewAccoutTest.yandexEmail;
import static tests.BookingNewAccoutTest.yandexPassword;

public class BookingCheckHeadTest {

    static String BOOKING_URL = "https://www.booking.com/";



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
        List<WebElement> list = new ArrayList<>();
        list.add(Driver.getDriver().findElement(By.xpath("//*[contains(@data-ga-track, 'accommodation')]")));
        list.add(Driver.getDriver().findElement(By.xpath("//*[contains(@data-ga-track, 'flights')]")));
        list.add(Driver.getDriver().findElement(By.xpath("//*[@class='header-wrapper']/img")));
        list.add(Driver.getDriver().findElement(By.xpath("//*[contains(@data-ga-track, 'rentalcars')]")));
        list.add(Driver.getDriver().findElement(By.xpath("//*[contains(@data-ga-track, 'attractions')]")));
        list.add(Driver.getDriver().findElement(By.xpath("//*[contains(@data-ga-track, 'airport_taxis')]")));
        list.add(Driver.getDriver().findElement(By.xpath("//*[contains(@data-id, 'currency')]")));
        list.add(Driver.getDriver().findElement(By.xpath("//*[contains(@data-id, 'language')]")));
        list.add(Driver.getDriver().findElement(By.xpath("//*[contains(@data-id, 'notifications')]")));
        list.add(Driver.getDriver().findElement(By.xpath("//*[contains(@class, 'helpcenter')]/a")));
        list.add(Driver.getDriver().findElement(By.xpath("//*[contains(@id, 'property')]")));
        list.add(Driver.getDriver().findElement(By.xpath("//*[contains(@id, 'account')]")));
        Assert.assertTrue(isElementDisplayed(list));
    }

    public boolean isElementDisplayed(List<WebElement> list) {
        for (WebElement x : list) {
            if (!x.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    @After
    public void afterMethod() {
        Driver.destroy();
        Driver.driver.remove();
    }
}
