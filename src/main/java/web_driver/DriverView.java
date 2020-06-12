package web_driver;

import org.openqa.selenium.WebDriver;
import settings.ScreenView;

public class DriverView {
    public static void setScreenView (ScreenView view, WebDriver driver) {
        switch (view) {
            case FULL_SCREEN:
                setWindowView(driver);
            case MAX:
                setMaxView(driver);
        }
    }

    private static void setMaxView(WebDriver driver) {
        driver.manage().window().maximize();
    }

    private static void setWindowView(WebDriver driver) {
        driver.manage().window().fullscreen();
    }
}
