package page_object;

import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {
    //locator
    private final By txtCurrentPassword = By.id("currentPassword");
    private final By txtNewPassowrd = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassowrd = By.cssSelector("input[type='submit']");
    private final By lblErrorMessage = By.cssSelector("fieldset p[class='message error']");

    //element
    private WebElement getTxtCurrentPassword() {
        return DriverHelper.getDriver().findElement(txtCurrentPassword);
    }

    private WebElement getTxtNewPassword() {
        return DriverHelper.getDriver().findElement(txtNewPassowrd);
    }

    private WebElement getTxtConfirmPassword() {
        return DriverHelper.getDriver().findElement(txtConfirmPassword);
    }

    private WebElement getBtnChangePassword() {
        return DriverHelper.getDriver().findElement(btnChangePassowrd);
    }

    private WebElement getLblErrorMessage() {
        return DriverHelper.getDriver().findElement(lblErrorMessage);
    }

    //method
    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        getTxtCurrentPassword().sendKeys(currentPassword);
        getTxtNewPassword().sendKeys(newPassword);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getBtnChangePassword().click();
    }

    public String getErrorMessage() {
        return this.getLblErrorMessage().getText();
    }
}
