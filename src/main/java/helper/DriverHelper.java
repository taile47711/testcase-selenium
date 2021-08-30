package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHelper {
    private static WebDriver driver;

    public static void initDrive() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void navigate(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
