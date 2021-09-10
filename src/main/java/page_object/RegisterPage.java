package page_object;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;
import helper.DriverHelper;
import helper.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    private final TextBox txtEmail = new TextBox("id=email");
    private final TextBox txtPassword = new TextBox("id=password");
    private final TextBox txtConfirmPassword = new TextBox("id=confirmPassword");
    private final TextBox txtPID = new TextBox("id=pid");
    private final Button btnRegisterButton = new Button("css=input[value='Register']");
    private final Label lblSuccessMessage = new Label("css=div#content p");

    //method
    public void register(String email, String password, String confirm, String pid) {
        btnRegisterButton.scrollToView();
        txtEmail.enter(email);
        txtPassword.enter(password);
        txtPID.enter(pid);
        txtConfirmPassword.enter(confirm);
        btnRegisterButton.click();
    }

    public String getSuccessMessage() {
        return lblSuccessMessage.getText();
    }
}