package com.vytrack.tests.vytrackLogInTest;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserStory_58 extends TestBase {
    @Test
    public void StoreManagerLogIn() {
        VytrackUtils.loginAsStoreManger();
        VytrackUtils.waitTillLoaderMaskDisappear();

        //verify Login successfully
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);

        // locate "Fleet" tab
        WebElement LocateFleet = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet'and contains(@class,'title title-level-1')]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(LocateFleet).perform();

        // locate vehicle module button
        WebElement vehicleModuleButton = Driver.getDriver().findElement(By.xpath("//a[@href='/entity/Extend_Entity_VehiclesModel']/span[@class='title title-level-2']"));
        vehicleModuleButton.click();
        VytrackUtils.waitTillLoaderMaskDisappear();

        // locate 10 vehicle modules
        List<WebElement> VehicleModules = Driver.getDriver().findElements(By.xpath("//thead[@class='grid-header']//tr//th//span[1]"));
        List<String> ActualTitleNames = new ArrayList<>();

        for (WebElement eachModule : VehicleModules) {
            String eachText = eachModule.getText();
            ActualTitleNames.add(eachText);
        }

        // my expected names of modules
        List<String> expectedTitleName = new ArrayList<>(Arrays.asList("MODEL NAME", "MAKE", "CAN BE REQUESTED",
                "CVVI", "CO2 FEE (/MONTH)", "COST (DEPRECIATED)", "TOTAL COST (DEPRECIATED)",
                "CO2 EMISSIONS", "FUEL TYPE", "VENDORS"));

        // verify expected and actual
        Assert.assertEquals(expectedTitleName, ActualTitleNames);
    }

    @Test
    public void SalesManagerLogIn() {
        VytrackUtils.loginAsSalesManager();
        VytrackUtils.waitTillLoaderMaskDisappear();

        //verify Login successfully
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);

        // locate "Fleet" tab
        WebElement locateFleet = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet'and contains(@class,'title title-level-1')]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(locateFleet).perform();

        // locate vehicle module button
        WebElement vehicleModuleButton = Driver.getDriver().findElement(By.xpath("//a[@href='/entity/Extend_Entity_VehiclesModel']/span[@class='title title-level-2']"));
        vehicleModuleButton.click();
        VytrackUtils.waitTillLoaderMaskDisappear();

        // locate 10 vehicle modules
        List<WebElement> vehicleModules = Driver.getDriver().findElements(By.xpath("//thead[@class='grid-header']//tr//th//span[1]"));
        List<String> actualTitleNames = new ArrayList<>();
        for (WebElement eachModule : vehicleModules) {
            String eachText = eachModule.getText();
            actualTitleNames.add(eachText);

        }
        List<String> expectedTitleName = new ArrayList<>(Arrays.asList("MODEL NAME", "MAKE", "CAN BE REQUESTED",
                "CVVI", "CO2 FEE (/MONTH)", "COST (DEPRECIATED)", "TOTAL COST (DEPRECIATED)",
                "CO2 EMISSIONS", "FUEL TYPE", "VENDORS"));

        Assert.assertEquals(expectedTitleName, actualTitleNames);

    }

    @Test
    public void truckDriverLogIn() {
        VytrackUtils.loginAsDriver();
        VytrackUtils.waitTillLoaderMaskDisappear();

        //verify Login successfully
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);

        // locate "Fleet" tab
        WebElement locateFleet = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet'and contains(@class,'title title-level-1')]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(locateFleet).perform();

        // locate vehicle module button
        WebElement vehicleModuleButton = Driver.getDriver().findElement(By.xpath("//a[@href='/entity/Extend_Entity_VehiclesModel']/span[@class='title title-level-2']"));
        vehicleModuleButton.click();
        VytrackUtils.waitTillLoaderMaskDisappear();

        //locate error message
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));
        String actualMessage = errorMessage.getText();
        String expectedMessage = "You do not have permission to perform this action.";

        // verify error message
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}

