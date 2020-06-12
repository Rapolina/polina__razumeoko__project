package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import settings.Config;
import steps.BaseSteps;
import steps.SpecialSteps;
import web_driver.Driver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class BookingMoscowTest {
    int daysShift = 10;
    int daysAmount = 5;
    static String BOOKING_URL = "https://www.booking.com/";

    @Before
    public void beforeMethod() {
        Driver.initDriver(Config.CHROME);
    }

    @Test
    public void bookingMoscowTest() throws InterruptedException {
        Driver.driver.get().get(BOOKING_URL);
        BaseSteps.findElementSendKeys(Driver.getDriver(), "//*[@id='ss']", "Moscow");
        BaseSteps.findElementClick(Driver.getDriver(), "//*[@data-mode='checkin']");
        BaseSteps.findElementClick(Driver.getDriver(), String.format("//*[@data-date='%s']", SpecialSteps.setDays(daysShift)));
        BaseSteps.findElementClick(Driver.getDriver(), String.format("//*[@data-date='%s']", SpecialSteps.setDays(daysShift + daysAmount)));
        BaseSteps.findElementClick(Driver.getDriver(), "(//*[contains(@type,'submit')])[1]");
        TimeUnit.SECONDS.sleep(3);

        Actions actions = new Actions(Driver.getDriver());
        WebElement chooseAdults = BaseSteps.findElementByCssSelector(Driver.getDriver(), "#group_adults");
        chooseAdults.click();
        Driver.getDriver().findElement(By.xpath("//*[@id='group_adults']/option[4]")).click();
       // actions.moveToElement(chooseAdults).click().moveToElement(Driver.getDriver().findElement(By.xpath("//*[@id='group_adults']/option[4]"))).click().perform();
        WebElement chooseRooms = BaseSteps.findElementByCssSelector(Driver.getDriver(), "#no_rooms");
       // actions.moveToElement(chooseRooms).click().sendKeys(Keys.ARROW_DOWN).click().perform();
        chooseRooms.click();
        Driver.getDriver().findElement(By.xpath("//*[@id='no_rooms']/option[2]")).click();
        BaseSteps.findElementClick(Driver.getDriver(), "//*[contains(@type,'submit')]");
        TimeUnit.SECONDS.sleep(3);

        String budget = BaseSteps.findElementClickGetText(Driver.getDriver(), "//*[@data-id='pri-1']");
        int budgetPerNight = Integer.parseInt(budget.substring(budget.indexOf("-")).replaceAll("\\D+", ""));
        TimeUnit.SECONDS.sleep(3);

        String firstPrice = BaseSteps.findElementGetText(Driver.getDriver(), "(//*[contains(@class,'bui-price-display')]/div[2]/div)[1]").replaceAll("\\D+", "");
        int hotelPerNight = Integer.parseInt(firstPrice) / daysAmount;
        System.out.println("Budget per night up to " + budgetPerNight);
        System.out.println("Price per night of first on the list from " + hotelPerNight);
        assertTrue("Something wrong", hotelPerNight <= budgetPerNight);
    }

    @After
    public void postCondition() {
        Driver.destroy();
        Driver.driver.remove();
    }
}
