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

        Assert.assertEquals(actual, "Welcome to Safe Railway", "A welcome message is not displayed as expected result");
    }

    @Test(description = "User can't login with blank Username textbox")
    public void tc02_UserCantLoginWithBlankUsernameTextbox() {
        LogHelper.info("Click tab login");
        loginPage.clickLoginTab();

        LogHelper.info("Doesn't type any words into Username textbox but enter valid information into Password textbox" +
                " and click Login button");
        loginPage.login("", Constant.PASSWORD);

        LogHelper.info("Get error message");
        String actual = loginPage.getErrorMessage();

        LogHelper.info("Verify that user can't login with blank Username textbox");

        Assert.assertEquals(actual, errorMsg, "An error message is not displayed as expected result");
    }

    @Test(description = "User cannot log into Railway with invalid password")
    public void tc03_UserCannotLogIntoRailwayWithInvalidPassword() {
        LogHelper.info("Click tab login");
        loginPage.clickLoginTab();

        LogHelper.info("Enter valid email and invalid password. Click login button");
        loginPage.login(Constant.USERNAME, "!@#$%^&***");

        LogHelper.info("Get error message");
        String actual = loginPage.getErrorMessage();

        LogHelper.info("Verify that user cannot log into Railway with invalid password");

        Assert.assertEquals(actual, "Invalid username or password. Please try again.",
                "An error message is not displayed as expected result");
    }
}