package tests;

import common.Constant;
import helper.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_object.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can log into Railway with valid username and password")
    public void tc001_UserCanLogIntoRailwayWithValidUsernameAndPassword() {
        LogHelper.info("Click tab login");
        loginPage.clickLoginTab();

        LogHelper.info("Enter valid data and click Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        LogHelper.info("Compare with expected result");
        String actual = loginPage.getWelcomeMessage();

        Assert.assertEquals(actual, "Welcome to Safe Railway", "A welcome message is not display like expected result");
    }
}