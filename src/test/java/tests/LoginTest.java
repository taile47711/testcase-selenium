package tests;

import common.Constant;
import helper.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_object.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    String errorMsg = "There was a problem with your login and/or errors exist in your form.";

    @Test(description = "User can log into Railway with valid username and password")
    public void tc001_UserCanLogIntoRailwayWithValidUsernameAndPassword() {
        LogHelper.info("Click tab login");
        loginPage.clickLoginTab();

        LogHelper.info("Enter valid data and click Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        LogHelper.info("Get welcome message");
        String actual = loginPage.getWelcomeMessage();

        LogHelper.info("Verify that user can log into Railway with valid username and password");
        Assert.assertEquals(actual, "Welcome to Safe Railway", "A welcome message is not display like expected result");
    }

    @Test(description = "User can't login with blank Username textbox")
    public void tc02_UserCantLoginWithBlankUsernameTextbox() {
        LogHelper.info("Click tab login");
        loginPage.clickLoginTab();

        LogHelper.info("Login with empty username and click Login button");
        loginPage.login("", Constant.PASSWORD);

        LogHelper.info("Get error message");
        String actual = loginPage.getErrorMessage();

        LogHelper.info("Verify that user can't login with blank Username textbox");
        Assert.assertEquals(actual, errorMsg, "An error message is not display like expected result");

    }
}