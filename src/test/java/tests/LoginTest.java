package tests;

import common.Constant;
import helper.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_object.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    String errorMessage = "There was a problem with your login and/or errors exist in your form.";

    @Test(description = "User can log into Railway with valid username and password")
    public void tc001_UserCanLogIntoRailwayWithValidUsernameAndPassword() {
        LogHelper.info("click tab login");
        loginPage.clickLoginTab();
        LogHelper.info("Enter valid data and click Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actual = loginPage.getWellcomeMessage();

        Assert.assertEquals(actual, "Welcome to Safe Railway", "Message is not displayed as expected");
    }

    @Test(description = "User can't login with blank Username text box")
    public void tc002_UserCantLoginWithBlankUsernameTextBox() {
        LogHelper.info("click tab login");
        loginPage.clickLoginTab();
        LogHelper.info("Doesn't type any into \"Username\" field but enter valid info into \"Password\" field " +
                "and click Login button");
        loginPage.login("", Constant.PASSWORD);
        String actual = loginPage.getErrorMessage();

        Assert.assertEquals(actual, errorMessage, "Error message is not displayed as expected");
    }
}