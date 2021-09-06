package page_object;

import helper.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    //locator
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPID = By.id("pid");
    private final By btnRegister = By.cssSelector("input[type='submit']");
    private final By lblSuccessMessage = By.cssSelector("body div [id='content']");

    //element
    private WebElement getTxtEmail() {
        return DriverHelper.getDriver().findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return DriverHelper.getDriver().findElement(txtPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return DriverHelper.getDriver().findElement(txtConfirmPassword);
    }

    private WebElement getTxtPID() {
        return DriverHelper.getDriver().findElement(txtPID);
    }

    private WebElement getBtnRegister() {
        return DriverHelper.getDriver().findElement(btnRegister);
    }

    private WebElement getLblSuccessMessage() {
        return DriverHelper.getDriver().findElement(lblSuccessMessage);
    }

    //method
    public void register(String email, String password, String confirm, String pid) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirm);
        getTxtPID().sendKeys(pid);
        getBtnRegister().click();
    }

    public String getSuccessMessage() {
        return this.getLblSuccessMessage().getText();
    }
}