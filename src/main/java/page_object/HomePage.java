package page_object;

import com.logigear.control.common.imp.Label;

public class HomePage extends BasePage {
    // Locator
    private final Label lblWelcomeContentAtTop = new Label("css=div#content h1");

    // Method
    public String getWelcomeContentAtTop() {
        return lblWelcomeContentAtTop.getText();
    }
}