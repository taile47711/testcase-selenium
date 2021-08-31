package page_object;

import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends BasePage{
    //locator
    private final By lblBookTicket = By.cssSelector("div [id='content'] h1[align='center']");

    //element
    private WebElement getLblBookTicket() {
        return DriverHelper.getDriver().findElement(lblBookTicket);
    }

    //method
    public String getBookTicketTitle() {
        return this.getLblBookTicket().getText();
    }
}