package page_object;

import helper.DriverHelper;
import helper.ElementHelper;
import helper.TicketHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends BasePage {
    //locator
    String btnCancelTicket = "//table[@class='MyTable']/tbody/tr//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/input[@value='Cancel']";

    private WebElement getBtnCancelTicket(String departStation, String arriveAt) {
        By btnCancel = By.xpath(String.format(btnCancelTicket, departStation, arriveAt));
        return DriverHelper.getDriver().findElement(btnCancel);
    }

    //element
    public void clickCancelButton(TicketHelper ticketHelpert) {
        getBtnCancelTicket(ticketHelpert.getDepartFrom(), ticketHelpert.getArriveAt()).click();
    }

    //method
    public void clickOKButton() {
        DriverHelper.getDriver().switchTo().alert().accept();
    }

    public boolean isTicketDisplay(TicketHelper ticketHelper){
        return ElementHelper.isTicketDisplayed(By.xpath(String.format(btnCancelTicket,
                ticketHelper.getDepartDate(),
                ticketHelper.getDepartFrom(),
                ticketHelper.getArriveAt(),
                ticketHelper.getSeat(),
                ticketHelper.getTicketAmount())));
    }
}