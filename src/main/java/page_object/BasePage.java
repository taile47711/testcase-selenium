package page_object;

import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    //locator
    private By tabLogin = By.cssSelector("li a[href*='/Account/Login.cshtml']");

    //element
    private WebElement getTabLogin() {
        return DriverHelper.getDriver().findElement(tabLogin);
    }

    //method
    public void clickLoginTab() {
        getTabLogin().click();
    }
}