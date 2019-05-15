package by.softclub.akulov.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WDriver {

    private static WebDriver driver = null;

    private WDriver() {
        System.setProperty(Constants.web_driver, Constants.web_driver_path);
        driver = new FirefoxDriver();
    }

    private static class LazyHolder {
        private static final WDriver INSTANCE = new WDriver();
    }

    public static WebDriver getInstance() {
        return LazyHolder.INSTANCE.driver;
    }

    public static void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void check(WebElement element) {
        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions
                        .visibilityOf(element));
    }

}
