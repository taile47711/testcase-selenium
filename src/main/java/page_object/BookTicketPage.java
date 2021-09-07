package page_object;

import helper.DriverHelper;
import helper.ElementHelper;
import helper.TicketHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends BasePage {
    //locator
    private final By drdDepartDate = By.name("Date");
    private final By drdDepartFrom = By.name("DepartStation");
    private final By drdArriveAt = By.name("ArriveStation");
    private final By drdSeatType = By.name("SeatType");
    private final By drdTicketAmount = By.name("TicketAmount");
    private final By lblBookTicket = By.cssSelector("div [id='content'] h1[align='center']");
    private final By btnBookTicket = By.cssSelector("input[type='submit']");

    //element
    private Select getDrdDepartDate() {
        Select select = new Select(DriverHelper.getDriver().findElement(drdDepartDate));
        return select;
    }

    private Select getDrdDepartFrom() {
        Select select = new Select(DriverHelper.getDriver().findElement(drdDepartFrom));
        return select;
    }

    private Select getDrdArriveAt() {
        Select select = new Select(DriverHelper.getDriver().findElement(drdArriveAt));
        return select;
    }

    private Select getDrdSeatType() {
        Select select = new Select(DriverHelper.getDriver().findElement(drdSeatType));
        return select;
    }

    private Select getDrdTicketAmount() {
        Select select = new Select(DriverHelper.getDriver().findElement(drdTicketAmount));
        return select;
    }

    private WebElement getBtnBookTicket() {
        return DriverHelper.getDriver().findElement(btnBookTicket);
    }

    private WebElement getLblBookTicketTitle() {
        return DriverHelper.getDriver().findElement(lblBookTicket);
    }

    //method
    public void bookTicket(TicketHelper ticket) {
        ElementHelper.scrollToElement(getBtnBookTicket());
        getDrdDepartDate().selectByVisibleText(ticket.getDepartDate());
        getDrdDepartFrom().selectByVisibleText(ticket.getDepartFrom());
        getDrdArriveAt().selectByVisibleText(ticket.getArriveAt());
        getDrdSeatType().selectByVisibleText(ticket.getSeat());
        getDrdTicketAmount().selectByVisibleText(ticket.getTicketAmount());
        getBtnBookTicket().click();
    }

    public String getBookTicketTitle() {
        return this.getLblBookTicketTitle().getText();
    }
}