package tests;

import com.logigear.driver.DriverProperty;
import com.logigear.driver.DriverUtils;
import com.logigear.helper.BrowserSettingHelper;
import common.Constant;
import helper.LogHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    @BeforeMethod
    @Parameters("Browser")
    public void beforeMethod(@Optional("chrome.local") String browser) throws Exception {
        LogHelper.info("Before method");
        DriverProperty driverProperty = BrowserSettingHelper.getDriverProperty(Constant.BROWSER_SETTING_FILE, browser);
        DriverUtils.getDriver(driverProperty);
        DriverUtils.setTimeOut(Constant.LONG_WAITING_TIME);
        DriverUtils.navigate(Constant.URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverUtils.quitBrowser();
    }
}
