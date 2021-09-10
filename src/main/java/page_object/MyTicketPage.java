package page_object;

import com.logigear.control.common.imp.Label;
import com.logigear.driver.DriverUtils;
import common.Ticket;

public class MyTicketPage extends BasePage {
    //locator
    private final Label btnCancelTicket = new Label("//table[@class='MyTable']/tbody//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/input[@value='Cancel']");

    //method
    public void clickCancelTicket(Ticket ticket) {
        btnCancelTicket.setDynamicValue(ticket.getDepartFrom(), ticket.getArriveAt(), ticket.getDepartDate(), ticket.getTicketAmount());
        btnCancelTicket.click();
        DriverUtils.acceptAlert();
    }

    public boolean isCanCelButtonDisplayed(Ticket ticket) {
        btnCancelTicket.setDynamicValue(ticket.getDepartFrom(), ticket.getArriveAt(), ticket.getDepartDate(), ticket.getTicketAmount());
        return btnCancelTicket.isVisible(3);
    }
}