package tests;

import common.Constant;
import helper.DriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void setup(){
        DriverHelper.initDrive();
        DriverHelper.navigate(Constant.URL);
    }
    @AfterMethod
    public void tearDown(){
        DriverHelper.quit();
    }
}
