package page_object;

import com.logigear.control.common.imp.Label;
import com.logigear.driver.DriverUtils;
import common.Ticket;

public class MyTicketPage extends BasePage {
    //locator
    private final Label btnCancelTicket = new Label("//table[@class='MyTable']/tbody//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/input[@value='Cancel']");

    //method
    public void clickCancelTicket(String departStation, String arriveStation, String departDate, String ticketAmount) {
        btnCancelTicket.setDynamicValue(departStation, arriveStation, departDate, ticketAmount);
        btnCancelTicket.click();
        DriverUtils.acceptAlert();
    }

    public boolean isCanCelButtonDisplayed(Ticket ticket) {
        btnCancelTicket.setDynamicValue(ticket.getDepartFrom(), ticket.getArriveAt(), ticket.getDepartDate(), ticket.getTicketAmount());
        return btnCancelTicket.isVisible(5);
    }
}