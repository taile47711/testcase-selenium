package tests;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_object.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    String errorMessage = "There was a problem with your login and/or errors exist in your form.";

    @Test(description = "User can log into Railway with valid username and password")
    public void tc001_UserCanLogIntoRailwayWithValidUsernameAndPassword() {
        loginPage.clickLoginTab();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actual = loginPage.getWellcomeMessage();

        Assert.assertEquals(actual, "Welcome to Safe Railway", "Message is not displayed as expected");
    }

}
