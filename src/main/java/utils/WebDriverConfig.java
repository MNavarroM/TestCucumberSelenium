package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverConfig {

    private static ChromeDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\navar\\eclipse-workspace\\SeleniumPageObject\\test-selenium-page-factory\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

}
