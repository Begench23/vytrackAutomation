package com.vytrack.tests.vytrackLogInTest;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VytrackUtils;
import org.testng.annotations.Test;

public class VytrackLogInTest extends TestBase {


    @Test
    public void testLogIn() {
        String userName = ConfigurationReader.getProperty("truckDriver2_userName");
        String password = ConfigurationReader.getProperty("password");

        VytrackUtils.login(userName, password);

        BrowserUtils.sleep(3);
    }

    @Test
    public void testLogInDriver() {
        VytrackUtils.loginAsDriver();

        BrowserUtils.sleep(3);

    }

    @Test
    public void testLogInStoreManager() {
        VytrackUtils.loginAsStoreManger();
        BrowserUtils.sleep(3);

    }

    @Test
    public void testLogInSalesManager() {
        VytrackUtils.loginAsSalesManager();
        BrowserUtils.sleep(3);

    }

}