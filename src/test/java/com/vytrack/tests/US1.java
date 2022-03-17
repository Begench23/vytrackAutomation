package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class US1 extends TestBase {
    @Test(priority = 1)
    public void verify_login_sales_manager_and_store_manager() {

        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env2"));

        // pass username
        Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']")).sendKeys(ConfigurationReader.getProperty("salesManager2_userName"));

        //pass password
        Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys(ConfigurationReader.getProperty("password"));

        //click login button
        Driver.getDriver().findElement(By.tagName("button")).click();

        VytrackUtils.waitTillLoaderMaskDisappear();

        //Locate module panel
        List<WebElement> modules = Driver.getDriver().findElements(By.xpath("//span[contains(@class, 'title title-level-1')]"));

        //create ArrayList that will store expected module names as a text
        ArrayList textFromModules = new ArrayList();

        //iterate through web elements of the module dashboard
        for (WebElement eachModule : modules) {
            textFromModules.add(eachModule.getText());
        }

        //Create list of actual module names
        List<String> actualModuleNames = new ArrayList<>(textFromModules);

        //Create list of expected module names
        List<String> expectedModuleNames = new ArrayList<>(Arrays.asList("Dashboards", "Fleet",
                "Customers", "Sales", "Activities", "Marketing", "Reports & Segments", "System"));

        //Compare actual with expected module names
        Assert.assertEquals(actualModuleNames, expectedModuleNames);
    }

    @Test(priority = 2)
    public void verify_login_driver() {

        //go to website
        Driver.getDriver().get(ConfigurationReader.getProperty("env2"));
        // pass username
        Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']")).sendKeys(ConfigurationReader.getProperty("truckDriver1_userName"));
        //pass password
        Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys(ConfigurationReader.getProperty("password"));
        //click login button
        Driver.getDriver().findElement(By.tagName("button")).click();

        VytrackUtils.waitTillLoaderMaskDisappear();

        //Locate module panel
        List<WebElement> modules = Driver.getDriver().findElements(By.xpath("//span[contains(@class, 'title title-level-1')]"));

        //create ArrayList that will store expected module names as a text
        ArrayList array = new ArrayList();

        //iterate through web elements of the module dashboard
        for (WebElement eachModule : modules) {
            array.add(eachModule.getText());
        }

        //Create list of actual module names
        List<String> actualModuleNames = new ArrayList<>(array);

        //Create list of expected module names
        List<String> expectedModuleNames = new ArrayList<>(Arrays.asList("Fleet", "Customers", "Activities", "System"));

        //Compare actual with expected module names
        Assert.assertEquals(actualModuleNames, expectedModuleNames);
    }
}