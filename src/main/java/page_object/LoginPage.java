package page_object;

import helper.DriverHelper;
import helper.ElementHelper;
import org.openqa.selenium.WebElement;
import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;

public class LoginPage extends BasePage {
    //locator
    private final TextBox txtUsername = new TextBox("id=username");
    private final TextBox txtPassword = new TextBox("id=password");
    private final Button btnLogin = new Button("css=input[value='Login']");
    private final Label lblWelcomeMessage = new Label("css=div[class='account'] > strong");
    private final Label lblErrorMessage = new Label("css=p[class='message error LoginForm']");

    //method
    public void login(String username, String password) {
        txtUsername.scrollToView();
        txtUsername.enter(username);
        txtPassword.enter(password);
        btnLogin.click();
    }

    public String getWelcomeMessage() {
        return lblWelcomeMessage.getText();
    }

    public String getErrorMessage() {
        return lblErrorMessage.getText();
    }

    public void loginMultipleTimes(int numberOfTimes, String username, String password) {
        for (int i = 0; i < numberOfTimes; i++) {
            txtUsername.clear();
            login(username, password);
        }
    }
}