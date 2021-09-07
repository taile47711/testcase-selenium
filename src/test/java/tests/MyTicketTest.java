package tests;

import common.Constant;
import helper.DataHelper;
import helper.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_object.BookTicketPage;
import page_object.LoginPage;
import page_object.MyTicketPage;
import helper.TicketHelper;

public class MyTicketTest extends BaseTest {
    MyTicketPage myTicketPage = new MyTicketPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can cancel ticket")
    public void tc16_UserCanCancelTicket(){
        LogHelper.info("Click login tab");
        loginPage.clickLoginTab();

        LogHelper.info("Enter valid data and click Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        LogHelper.info("click book ticket tab");
        bookTicketPage.clickBookTicketTab();

        LogHelper.info("Input valid data");
        String departDate = DataHelper.getDateFromToday(4,"M/d/yyyy");
        TicketHelper ticketHelper = new TicketHelper();
        ticketHelper.setDepartDate(departDate);
        ticketHelper.setDepartFrom("Sài Gòn");
        ticketHelper.setArriveAt("Huế");
        ticketHelper.setSeat("Soft bed with air conditioner");
        ticketHelper.setTicketAmount("1");
        bookTicketPage.bookTicket(ticketHelper);

        LogHelper.info("click my ticket page");
        myTicketPage.clickTabMyTicket();

        LogHelper.info("Cancel ticket");
        myTicketPage.clickCancelButton(ticketHelper);

        LogHelper.info("Click Ok in alert");
        myTicketPage.clickOKButton();

        LogHelper.info("Verify that user can cancel the ticket");
        Assert.assertFalse(myTicketPage.isTicketDisplay(ticketHelper),"User can't cancel the ticket");
    }
}