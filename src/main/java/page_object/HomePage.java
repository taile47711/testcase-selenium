package page_object;

import helper.DriverHelper;
import helper.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    // Locator
    private final By lblWelcomeContentAtTop = By.cssSelector("div#content h1");

    // Element
    private WebElement getLblWelcomeContentAtTop() {
        return DriverHelper.getDriver().findElement(lblWelcomeContentAtTop);
    }

    // Method
    public String getWelcomeContentAtTop() {
        return this.getLblWelcomeContentAtTop().getText();
    }
}