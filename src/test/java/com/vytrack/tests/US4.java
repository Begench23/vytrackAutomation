package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class US4 extends TestBase {

    @Test (priority = 1)
    public void verify_contractPages_as_sales_manager() {

        //login as sales manager
        VytrackUtils.loginAsSalesManager();

        //go to the Fleet
        String fleetTabElementLocator = "//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]";
        WebElement fleetTabElement = Driver.getDriver().findElement(By.xpath(fleetTabElementLocator));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetTabElement).perform();

        String vehiclesContractModuleLocator = "//span[normalize-space()='Vehicle Contracts' and contains(@class, 'title title-level-2')]";
        WebElement vehiclesContractElement = Driver.getDriver().findElement(By.xpath(vehiclesContractModuleLocator));


        VytrackUtils.waitTillLoaderMaskDisappear();
        vehiclesContractElement.click();



        VytrackUtils.waitTillLoaderMaskDisappear();
        String actualVehiclesContractTitle = Driver.getDriver().getTitle();
        String expectedVehicleContractTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";

        Assert.assertEquals(actualVehiclesContractTitle,expectedVehicleContractTitle);


    }

    @Test (priority = 2)
    public void verify_contractPages_as_driver() {

        //login as driver
        VytrackUtils.loginAsDriver();

        //go to the Fleet
        String fleetTabElementLocator = "//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]";
        WebElement fleetTabElement = Driver.getDriver().findElement(By.xpath(fleetTabElementLocator));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetTabElement).perform();

        String vehiclesContractModuleLocator = "//span[normalize-space()='Vehicle Contracts' and contains(@class, 'title title-level-2')]";
        WebElement vehiclesContractElement = Driver.getDriver().findElement(By.xpath(vehiclesContractModuleLocator));



        VytrackUtils.waitTillLoaderMaskDisappear();
        vehiclesContractElement.click();

        VytrackUtils.waitTillLoaderMaskDisappear();

        String vehiclesContractModuleDriverAlertLocator = "//div[.='You do not have permission to perform this action.']";
        WebElement vehiclesContractModuleDriverAlertElement = Driver.getDriver().findElement(By.xpath(vehiclesContractModuleDriverAlertLocator));

        String actualVehiclesContractModuleDriverAlert = vehiclesContractModuleDriverAlertElement.getText();
        String expectedVehiclesContractModuleDriverAlert = "You do not have permission to perform this action.";

        Assert.assertEquals(actualVehiclesContractModuleDriverAlert , expectedVehiclesContractModuleDriverAlert);

    }







}
