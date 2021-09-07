package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class TicketHelper {
    private String departDate;
    private String departFrom;
    private String arriveAt;
    private String seat;
    private String ticketAmount;

    public String getDepartDate() {

        return departDate;
    }

    public String getDepartFrom() {

        return departFrom;
    }

    public String getSeat() {
        return seat;
    }

    public String getArriveAt() {
        return arriveAt;
    }

    public String getTicketAmount() {
        return ticketAmount;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public void setArriveAt(String arriveAt) {
        this.arriveAt = arriveAt;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void setTicketAmount(String ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public static boolean isTicketDisplayed(By selector) {
        try {
            return DriverHelper.getDriver().findElement(selector).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}