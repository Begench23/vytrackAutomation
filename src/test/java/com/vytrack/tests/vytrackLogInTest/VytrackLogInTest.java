package com.vytrack.tests.vytrackLogInTest;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class VytrackLogInTest {



    @Test
    public void testLogIn() {
        String userName = ConfigurationReader.getProperty("storeManager4_userName");
        String password = ConfigurationReader.getProperty("password");

        VytrackUtils.login(userName, password);

        String expectedTitle = "Dashboard";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "Log In Fail!");

    }

    @Test
    public void testLogInDriver() {
        VytrackUtils.loginAsDriver();

        String expectedTitle = "Dashboard";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "Log In Fail!");

    }

    @Test
    public void testLogInStoreManager() {
        VytrackUtils.loginAsStoreManger();

        String expectedTitle = "Dashboard";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "Log In Fail!");

    }

    @Test
    public void testLogInSalesManager() {
        VytrackUtils.loginAsSalesManager();

        String expectedTitle = "Dashboard";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "Log In Fail!");

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}