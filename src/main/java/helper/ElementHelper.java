package helper;

import com.logigear.driver.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

public class ElementHelper {
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) DriverHelper.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static boolean isDisplayed(By selector){
        try{
            return DriverUtils.getWebDriver().findElement(selector).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
}