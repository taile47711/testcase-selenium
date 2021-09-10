package page_object;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.TextBox;
public class ChangePasswordPage extends BasePage {
    //locator
    private final TextBox txtCurrentPassword = new TextBox("id=currentPassword");
    private final TextBox txtNewPassword = new TextBox("id=newPassword");
    private final TextBox txtConfirmPassword = new TextBox("id=confirmPassword");
    private final Button btnChangePassword = new Button("css=input[type='submit']");
    private final Label lblErrorMessage = new Label("css=fieldset p[class='message error']");

    //method
    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        txtCurrentPassword.enter(currentPassword);
        txtNewPassword.enter(newPassword);
        txtConfirmPassword.enter(confirmPassword);
        btnChangePassword.click();
    }

    public String getErrorMessage() {
        return lblErrorMessage.getText();
    }
}