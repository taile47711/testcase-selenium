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
    private By tabTimetable = By.cssSelector("li a[href*='TrainTimeListPage.cshtml']");
    private By tabTicketPrice = By.cssSelector("li a[href*='/Page/TrainPriceListPage.cshtml']");
    private By tabLogout = By.cssSelector("a[href$='Logout']");
    private By tabContact = By.cssSelector("a[href*='Contact']");
    private By tabChangePassword = By.cssSelector("li a[href='/Account/ChangePassword.cshtml']");

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

    private WebElement getTabTimetable() {
        return DriverHelper.getDriver().findElement(tabTimetable);
    }

    private WebElement getTabTicketPrice() {
        return DriverHelper.getDriver().findElement(tabTicketPrice);
    }

    private WebElement getTabLogout() {
        return DriverHelper.getDriver().findElement(tabLogout);
    }

    private WebElement getTabContact() {
        return DriverHelper.getDriver().findElement(tabContact);
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

    public void clickTimetableTab() {
        getTabTimetable().click();
    }

    public void clickTicketPriceTab() {
        getTabTicketPrice().click();
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

    public boolean isLoginTabDisplayed() {
        return ElementHelper.isElementDisplayed(this.getTabLogin());
    }

    public boolean isLogoutTabDisplayed() {
        return ElementHelper.isElementDisplayed(this.getTabLogout());
    }
}