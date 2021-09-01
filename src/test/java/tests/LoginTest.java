package tests;

import common.Constant;
import helper.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_object.BookTicketPage;
import page_object.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    String errorMsg = "There was a problem with your login and/or errors exist in your form.";

    @Test(description = "User can login into Railway with valid username and password")
    public void tc001_UserCanLoginIntoRailwayWithValidUsernameAndPassword() {
        LogHelper.info("Click login tab");
        loginPage.clickLoginTab();

        LogHelper.info("Enter valid data and click Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        LogHelper.info("Get welcome message");
        String actual = loginPage.getWelcomeMessage();

        LogHelper.info("Verify that user can log into Railway with valid username and password");

        Assert.assertEquals(actual, "Welcome to Safe Railway", "A welcome message is not displayed as expected result");
    }

    @Test(description = "User can't login with blank Username textbox")
    public void tc02_UserCantLoginWithBlankUsernameTextbox() {
        LogHelper.info("Click login tab");
        loginPage.clickLoginTab();

        LogHelper.info("Doesn't type any words into Username textbox but enter valid information into Password textbox" +
                " and click Login button");
        loginPage.login("", Constant.PASSWORD);

        LogHelper.info("Get error message");
        String actual = loginPage.getErrorMessage();

        LogHelper.info("Verify that user can't login with blank Username textbox");

        Assert.assertEquals(actual, errorMsg, "An error message is not displayed as expected result");
    }

    @Test(description = "User cannot login into Railway with invalid password")
    public void tc03_UserCannotLoginIntoRailwayWithInvalidPassword() {
        LogHelper.info("Click login tab");
        loginPage.clickLoginTab();

        LogHelper.info("Enter valid email and invalid password. Click Login button");
        loginPage.login(Constant.USERNAME, "!@#$%^&***");

        LogHelper.info("Get error message");
        String actual = loginPage.getErrorMessage();

        LogHelper.info("Verify that user cannot log into Railway with invalid password");

        Assert.assertEquals(actual, "Invalid username or password. Please try again.",
                "An error message is not displayed as expected result");
    }

    @Test(description = "User is redirected to Book Ticket page after logging in")
    public void tc04_UserIsRedirectedToBookPageAfterLoggingIn() {
        BookTicketPage bookTicketPage = new BookTicketPage();

        LogHelper.info("Click Book ticket tab");
        bookTicketPage.clickBookTicketTab();

        LogHelper.info("Login with valid account and click Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        LogHelper.info("Get book ticket title");
        String actual = bookTicketPage.getBookTicketTitle();

        LogHelper.info("Verify that user is redirected to Book Ticket page after logging in");
        Assert.assertEquals(actual, "Book ticket", "Navigate incorrectly to Book ticket page");
    }

    @Test(description = "System shows message when user enters wrong password several times")
    public void tc05_SystemShowsMessageWhenUserEntersWrongPasswordSeveralTimes() {
        LogHelper.info("Click login tab");
        loginPage.clickLoginTab();
        LogHelper.info("Enter valid data into Username textbox except Password textbox and click login button. Repeat 3 times");
        for (int i = 0; i < 4; i++) {
            loginPage.login(Constant.USERNAME, "");
        }

        LogHelper.info("Get error message");
        String actual = loginPage.getErrorMessage();
        String expected = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        LogHelper.info("Verify that system shows message when user enters wrong password several times");

        Assert.assertEquals(actual, expected, "An error message is not display like expected result");
    }
}