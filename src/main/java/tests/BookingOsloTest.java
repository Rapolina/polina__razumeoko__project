package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import settings.Config;
import settings.ScreenView;
import steps.BaseSteps;
import steps.SpecialSteps;
import web_driver.Driver;

import java.util.concurrent.TimeUnit;

public class BookingOsloTest {
    int daysShift = 1;
    int daysAmount = 1;
    int childrenNeed = 1;
    static String BOOKING_URL="https://www.booking.com/";
    WebDriver driver;

    @Before
    public void beforeMethod() {
        Driver.initDriver(Config.CHROME);
        BaseSteps.followTheLinkSetWindowMode(Driver.getDriver(), BOOKING_URL, ScreenView.MAX);
    }

    @Test
    public void bookingOsloTest() throws InterruptedException {
        BaseSteps.findElementSendKeys(Driver.getDriver(), "//*[@id='ss']", "Oslo");
        BaseSteps.findElementClick(Driver.getDriver(), "//*[@data-mode='checkin']");
        BaseSteps.findElementClick(Driver.getDriver(), String.format("//*[@data-date='%s']", SpecialSteps.setDays(daysShift)));
        BaseSteps.findElementClick(Driver.getDriver(), String.format("//*[@data-date='%s']", SpecialSteps.setDays(daysShift + daysAmount)));
        BaseSteps.findElementClick(Driver.getDriver(), "//*[@id='xp__guests__toggle']");
        int childrenAmount = Integer.parseInt(BaseSteps.findElementGetAttribute(Driver.getDriver(), "//*[contains(@class,'children')]//input", "value"));
        BaseSteps.findElementClickRepeat(Driver.getDriver(), "//*[@aria-describedby='group_children_desc'][2]", childrenAmount, childrenNeed);
        BaseSteps.findElementClick(Driver.getDriver(), "(//*[contains(@type,'submit')])[1]");
        TimeUnit.SECONDS.sleep(3);

        BaseSteps.findElementClick(Driver.getDriver(), "//*[@data-id='class-3']");
        BaseSteps.findElementClick(Driver.getDriver(), "//*[@data-id='class-4']");
        TimeUnit.SECONDS.sleep(3);

        SpecialSteps.findElementScrollIntoView(Driver.getDriver(), "//*[@data-hotelid][10]");
        TimeUnit.SECONDS.sleep(3); //just to have time to see this action
        BaseSteps.findElementHighlight(Driver.getDriver(), "//*[@data-hotelid][10]//span[contains(@class,'sr-hotel__name')]");
        TimeUnit.SECONDS.sleep(3); //just to have time to see this action
        SpecialSteps.findElementSetAttribute(Driver.getDriver(), "//*[@data-hotelid][10]", "backgroundColor", "green");
        TimeUnit.SECONDS.sleep(3); //just to have time to see this action
        SpecialSteps.findElementSetAttribute(Driver.getDriver(), "//*[@data-hotelid][10]//span[contains(@class,'sr-hotel__name')]", "color", "red");
        TimeUnit.SECONDS.sleep(3); //just to have time to see this action
        BaseSteps.findElementCheckAttribute(Driver.getDriver(), "//*[@data-hotelid][10]//span[contains(@class,'sr-hotel__name')]", "style", "color: red;");
    }

    @After
    public void afterMethod() {
        Driver.destroy();
        Driver.driver.remove();
    }
}