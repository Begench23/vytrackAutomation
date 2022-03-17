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

public class UserStory_66 extends TestBase {

    @Test
    public void SalesManagerLogIn() {
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

        //locate "Vehicle Costs"
        WebElement vehicleCosts=Driver.getDriver().findElement(By.xpath("//a[@href='/entity/Extend_Entity_VehicleCosts']/span"));
        vehicleCosts.click();

        //expected modules
        List<String> ExpectedModulesText=new ArrayList<>(Arrays.asList("TYPE","TOTAL PRICE","DATE"));

        //locate modules and get text
        WebElement TypeModule=Driver.getDriver().findElement(By.xpath("//table//span[.='Type']"));
        WebElement TotalPriceModule=Driver.getDriver().findElement(By.xpath("//table//span[.='Total Price']"));
        WebElement DateModule=Driver.getDriver().findElement(By.xpath("//table//span[.='Date']"));

        ArrayList<String> ActualModulesText=new ArrayList<>(Arrays.asList(TypeModule.getText(),
                TotalPriceModule.getText(),DateModule.getText()));

        //verify 3 modules text as expected    TYPE,TOTAL PRICE,DATE
        Assert.assertEquals(ActualModulesText,ExpectedModulesText);

        // verify other check box are not selected before I checked first check box
        List<WebElement> allCheckBox=Driver.getDriver().findElements(By.xpath("//table//td//input[@type='checkbox']"));
        for (WebElement each : allCheckBox) {
            Assert.assertFalse(each.isSelected());
        }

        //locate first check Box and select it
        WebElement firstCheckBox=Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']/input[@type='checkbox']"));
        firstCheckBox.click();

        Assert.assertTrue(firstCheckBox.isSelected());
        for (WebElement each : allCheckBox) {
            Assert.assertTrue(each.isSelected());
        }
    }
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

        //locate "Vehicle Costs"
        WebElement vehicleCosts=Driver.getDriver().findElement(By.xpath("//a[@href='/entity/Extend_Entity_VehicleCosts']/span"));
        vehicleCosts.click();

        //expected modules
        List<String> ExpectedModulesText=new ArrayList<>();
        ExpectedModulesText.addAll(Arrays.asList("TYPE","TOTAL PRICE","DATE"));

        //locate modules and get text
        WebElement TypeModule=Driver.getDriver().findElement(By.xpath("//table//span[.='Type']"));
        WebElement TotalPriceModule=Driver.getDriver().findElement(By.xpath("//table//span[.='Total Price']"));
        WebElement DateModule=Driver.getDriver().findElement(By.xpath("//table//span[.='Date']"));

        ArrayList<String> ActualModulesText=new ArrayList<>(Arrays.asList(TypeModule.getText(),
                TotalPriceModule.getText(),DateModule.getText()));

        //verify 3 modules text as expected    TYPE,TOTAL PRICE,DATE
        Assert.assertEquals(ActualModulesText,ExpectedModulesText);

        // verify other check box are not selected before I checked first check box
        List<WebElement> allCheckBox=Driver.getDriver().findElements(By.xpath("//table//td//input[@type='checkbox']"));
        for (WebElement each : allCheckBox) {
            Assert.assertFalse(each.isSelected());
        }

        //locate first check Box and select it
        WebElement firstCheckBox=Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']/input[@type='checkbox']"));
        firstCheckBox.click();

        Assert.assertTrue(firstCheckBox.isSelected());
        for (WebElement each : allCheckBox) {
            Assert.assertTrue(each.isSelected());
        }
    }

}

