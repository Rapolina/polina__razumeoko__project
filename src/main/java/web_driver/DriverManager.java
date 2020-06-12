package web_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import settings.Config;

public class DriverManager {

    public static WebDriver getDriver(Config config) {

        switch (config) {
            case CHROME:
                return getChromeDriver();
            case FF:
                return getFFDriver();
            case EDGE:
                return getEdgeDriver();
            default:
                throw null;
        }
    }



    private static WebDriver getEdgeDriver() {

        return new EdgeDriver();
    }

    private static WebDriver getFFDriver() {
        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();

        //options.addArguments("--headless");
       // options.addArguments("--disable-gpu");
      //  options.addArguments("--window-size=1920,1200");
        options.addArguments("--ignore-certificate-errors");

        System.setProperty("webdriver.chrome.driver", "extra/chromedriver");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        return new ChromeDriver();
    }
}

