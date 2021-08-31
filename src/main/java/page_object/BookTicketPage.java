package page_object;

import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends BasePage{
    //locator
    private final By lblBookTicketTitle = By.cssSelector("div [id='content'] h1[align='center']");

    //element
    private WebElement getLblBookTicketTitle() {
        return DriverHelper.getDriver().findElement(lblBookTicketTitle);
    }

    //method
    public String getBookTicketTitle() {
        return this.getLblBookTicketTitle().getText();
    }
}