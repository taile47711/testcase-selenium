package page_object;

import common.Ticket;
import com.logigear.control.common.imp.ComboBox;
import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;

public class BookTicketPage extends BasePage {
    //locator
    private final ComboBox cbbDepartDate = new ComboBox("name=Date");
    private final ComboBox cbbDepartFrom = new ComboBox("name=DepartStation");
    private final ComboBox cbbArriveAt = new ComboBox("name=ArriveStation");
    private final ComboBox cbbSeatType = new ComboBox("name=SeatType");
    private final ComboBox cbbTicketAmount = new ComboBox("name=TicketAmount");
    private final Label lblBookTicket = new Label("css=div [id='content'] h1[align='center']");
    private final Button btnBookTicket = new Button("css=input[type='submit']");

    //method
    public void selectDepartDate(String departDate) {
        cbbDepartDate.select(departDate);
    }

    public void selectDepartFrom(String departFrom) {
        cbbDepartFrom.select(departFrom);
    }

    public void selectArriveAt(String arriveAt) {
        cbbArriveAt.waitForStalenessOfElement();
        cbbArriveAt.select(arriveAt);
    }

    public void selectSeatType(String seatType) {
        cbbSeatType.select(seatType);
    }

    public void selectTicketAmount(String ticketAmount) {
        cbbTicketAmount.select(ticketAmount);
    }

    public void bookTicket(Ticket ticket) {
        selectDepartDate(ticket.getDepartDate());
        selectDepartFrom(ticket.getDepartFrom());
        selectArriveAt(ticket.getArriveAt());
        selectSeatType(ticket.getSeat());
        selectTicketAmount(ticket.getTicketAmount());
        btnBookTicket.click();
    }

    public String getBookTicketTitle() {
        return lblBookTicket.getText();
    }
}