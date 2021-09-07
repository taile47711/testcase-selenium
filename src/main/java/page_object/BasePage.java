package page_object;

import helper.DriverHelper;
import helper.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage extends DriverHelper {
    //locator
    private By tabLogin = By.cssSelector("li a[href*='/Account/Login.cshtml']");
    private By tabRegister = By.cssSelector("li a[href='/Account/Register.cshtml']");
    private By tabBookTicket = By.cssSelector("li a[href='/Page/BookTicketPage.cshtml']");
    private By tabLogout = By.cssSelector("a[href$='Logout']");
    private By tabContact = By.cssSelector("a[href*='Contact']");
    private By tabChangePassword = By.cssSelector("li a[href='/Account/ChangePassword.cshtml']");
    private By tabMyTicket = By.cssSelector("li a[href='/Page/ManageTicket.cshtml']");

    //element
    private WebElement getTabLogin() {
        return DriverHelper.getDriver().findElement(tabLogin);
    }

    private WebElement getTabRegister() {
        return DriverHelper.getDriver().findElement(tabRegister);
    }

    private WebElement getTabBookTicket() {
        return DriverHelper.getDriver().findElement(tabBookTicket);
    }

    private WebElement getTabLogout() {
        return DriverHelper.getDriver().findElement(tabLogout);
    }

    private WebElement getTabContact() {
        return DriverHelper.getDriver().findElement(tabContact);
    }

    private WebElement getTabMyTicket() {
        return DriverHelper.getDriver().findElement(tabMyTicket);
    }

    private WebElement getTabChangePassword() {
        return DriverHelper.getDriver().findElement(tabChangePassword);
    }

    //method
    public void clickLoginTab() {
        getTabLogin().click();
    }

    public void clickRegisterTab() {
        getTabRegister().click();
    }

    public void clickBookTicketTab() {
        getTabBookTicket().click();
    }

    public void clickLogoutTab() {
        getTabLogout().click();
    }

    public void clickContactTab() {
        getTabContact().click();
    }

    public void clickChangePasswordTab() {
        getTabChangePassword().click();
    }

    public void clickTabMyTicket() {
        getTabMyTicket().click();
    }

    public boolean isLoginTabDisplayed() {
        return ElementHelper.isElementDisplayed(this.getTabLogin());
    }

    public boolean isLogoutTabDisplayed() {
        return ElementHelper.isElementDisplayed(this.getTabLogout());
    }
}