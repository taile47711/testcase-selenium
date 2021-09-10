package page_object;

import com.logigear.control.common.imp.Label;

public class HomePage extends BasePage {
    // Locator
    private final Label lblWelcomeCMessage = new Label("css=div#content h1");

    // Method
    public String getWelcomeMessage() {
        return lblWelcomeCMessage.getText();
    }
}