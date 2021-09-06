package tests;

import common.Constant;
import helper.DataHelper;
import helper.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_object.RegisterPage;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage = new RegisterPage();
    String email = "";
    String pid = "";

    @Test(description = "User can create new account")
    public void tc07_UserCanCreateNewAccount() {
        LogHelper.info("Click register tab");
        registerPage.clickRegisterTab();

        LogHelper.info("Enter valid information into all fields and click Register button");
        email = DataHelper.getRandomEmail();
        pid = DataHelper.getRandomPID(9);
        registerPage.register(email, Constant.USERNAME, Constant.USERNAME, pid);

        LogHelper.info("Get success message in register page after click Register button");
        String actual = registerPage.getSuccessMessage();

        LogHelper.info("Verify that user can create new account");
        Assert.assertEquals(actual, "You're here", "User can't create account with valid data");
    }
}