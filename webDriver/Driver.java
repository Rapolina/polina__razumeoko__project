package web_driver;

import org.openqa.selenium.WebDriver;
import settings.Config;

import java.net.MalformedURLException;

public class Driver {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(Config config) {
        if (null == driver.get()) {
    //        try {
               driver.set(DriverManager.getDriver(config));
    //        } catch (MalformedURLException e) {
    //            e.printStackTrace();
    //        }
        }
    }

    public static WebDriver getDriver() {
        if (null == driver.get()) {
         //   try {
              driver.set(DriverManager.getDriver(Config.CHROME));
         //   } catch (MalformedURLException e) {
         //       e.printStackTrace();
         //   }
        }
        return driver.get();
    }

    public static void destroy() {
        driver.get().close();
driver.get().quit();
    }
}
