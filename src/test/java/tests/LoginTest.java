package tests;

import common.Constant;
import helper.LogHelper;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_object.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    String errorMessage = "There was a problem with your login and/or errors exist in your form.";

    @Test(description = "User can log into Railway with valid username and password")
    public void tc001_UserCanLogIntoRailwayWithValidUsernameAndPassword() {
        LogHelper.info("ckick tab login");
        loginPage.clickLoginTab();
        LogHelper.info("Enter valid data and click Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actual = loginPage.getWellcomeMessage();

        Assert.assertEquals(actual, "Welcome to Safe Railway", "Message is not displayed as expected");
    }

}
