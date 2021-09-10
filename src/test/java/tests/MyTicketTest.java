package tests;

import common.Constant;
import helper.DataHelper;
import helper.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_object.BookTicketPage;
import page_object.LoginPage;
import page_object.MyTicketPage;
import common.Ticket;

public class MyTicketTest extends BaseTest {
    MyTicketPage myTicketPage = new MyTicketPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();
    Ticket ticket = new Ticket();

    @Test(description = "User can cancel ticket")
    public void tc16_UserCanCancelTicket() {
        LogHelper.info("Click login tab");
        loginPage.clickLoginTab();

        LogHelper.info("Enter valid data and click Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        LogHelper.info("click book ticket tab");
        bookTicketPage.clickBookTicketTab();

        LogHelper.info("Input valid data");
        String departDate = DataHelper.getDateFromToday(4, "M/d/yyyy");
        ticket.setDepartDate(departDate);
        ticket.setDepartFrom("Đà Nẵng");
        ticket.setArriveAt("Huế");
        ticket.setSeat("Soft bed with air conditioner");
        ticket.setTicketAmount("1");
        bookTicketPage.bookTicket(ticket);

        LogHelper.info("click my ticket page");
        myTicketPage.clickTabMyTicket();

        LogHelper.info("Cancel ticket");
        myTicketPage.clickCancelTicket(ticket);

        LogHelper.info("Verify that user can cancel the ticket");
        Assert.assertFalse(myTicketPage.isCanCelButtonDisplayed(ticket), "User can't cancel the ticket");
    }
}