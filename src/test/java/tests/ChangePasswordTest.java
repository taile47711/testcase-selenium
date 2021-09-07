package tests;

import common.Constant;
import helper.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_object.ChangePasswordPage;
import page_object.LoginPage;

public class ChangePasswordTest extends BaseTest {
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can't change password when New Password and Confirm Password are different.")
    public void tc09_UserCantChangePasswordWhenNewPasswordAndConfirmPasswordAreDifferent() {
        LogHelper.info("Click login tab");
        loginPage.clickLoginTab();

        LogHelper.info("Enter valid data and click Login button");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        LogHelper.info("Click change password tab");
        changePasswordPage.clickChangePasswordTab();

        LogHelper.info("Change password with new password and confirm password are different");
        String newPassword = "a123:\"/{}!@$\\";
        String confirmPassword = "b456:\"/{}!@$\\";
        changePasswordPage.changePassword(Constant.PASSWORD, newPassword, confirmPassword);

        LogHelper.info("Get error message after click Change Password button in change password page");
        String actualErrorMessage = changePasswordPage.getErrorMessage();
        String expectedErrorMessage = "Password change failed. Please correct the errors and try again.";

        LogHelper.info("Verify that user can't change password when New Password and Confirm Password are different");
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
                "An error message is not displayed as expected result");
    }
}