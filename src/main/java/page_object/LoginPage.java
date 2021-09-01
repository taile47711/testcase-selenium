package page_object;

import helper.DriverHelper;
import helper.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    //locator
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.cssSelector("input[type='submit']");
    private final By lblWelcomeMessage = By.cssSelector("div#content>h1[align='center']");
    private final By lblErrorMessage = By.cssSelector("div#content>p[class='message error LoginForm']");

    //element
    private WebElement getTxtUsername() {
        return DriverHelper.getDriver().findElement(txtUsername);
    }

    private WebElement getTxtPassword() {
        return DriverHelper.getDriver().findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return DriverHelper.getDriver().findElement(btnLogin);
    }

    private WebElement getLblWelcomeMessage() {
        return DriverHelper.getDriver().findElement(lblWelcomeMessage);
    }

    private WebElement getLblErrorMessage() {
        return DriverHelper.getDriver().findElement(lblErrorMessage);
    }

    //method
    public void login(String username, String password) {
        ElementHelper.scrollToElement(getBtnLogin());
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
    }

    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public String getErrorMessage() {
        return this.getLblErrorMessage().getText();
    }

    public void loginMultipleTime(int n, String username, String pasword) {
        for (int i = 0; i < n; i++) {
            login(username, pasword);
        }
    }
}