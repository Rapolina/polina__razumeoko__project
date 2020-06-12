package web_driver;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import settings.Config;
import settings.ScreenView;

public class Driver {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static WebElement element;
    private static final Logger LOGGER = LogManager.getLogger(Driver.class);

    public static void initDriver(Config config) {
        if (null == driver.get()) {
            driver.set(DriverManager.getDriver(config));
        }
    }

    public static WebDriver getDriver() {
        if (null == driver.get()) {
            driver.set(DriverManager.getDriver(Config.CHROME));
        }
        return driver.get();
    }

    public static void destroy() {
        driver.get().close();
        driver.get().quit();
    }

    public static void followTheLinkSetWindowMode(String url, ScreenView screenView) {
        DriverView.setScreenView(screenView, driver.get());
        driver.get().get(url);
    }

   // public static void keysSend (String xPath, String xPath){
   //     element = Driver.getDriver().findElement(By.xpath(xPath));
   //     element.keysSend(keys);

}
