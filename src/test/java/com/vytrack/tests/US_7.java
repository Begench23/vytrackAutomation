package com.vytrack.tests;

import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US_7 {


    @BeforeMethod
    public void setup(){

        //login as store manager
        VytrackUtils.loginAsStoreManger();

        //Go to Fleet Tab and click the vehicle page
        String fleetTabElementLocator = "//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]";

        WebElement fleetTabElement = Driver.getDriver().findElement(By.xpath(fleetTabElementLocator));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetTabElement).perform();
        String vehiclesLocator = "//span[normalize-space()='Vehicles' and contains(@class, 'title title-level-2')]";
        WebElement vehiclesElement = Driver.getDriver().findElement(By.xpath(vehiclesLocator));
        VytrackUtils.waitTillLoaderMaskDisappear();
        vehiclesElement.click();
        VytrackUtils.waitTillLoaderMaskDisappear();

    }


@Test
    public void verify_vehicle_Page_and_check_boxes_visible_as_store_manager(){

    // Checked boxes are visible for the users
    String checked_boxes_visible= "//th[@class='select-all-header-cell renderable grid-cell grid-header-cell grid-header-cell-massAction']";
    WebElement verified = Driver.getDriver().findElement(By.xpath(checked_boxes_visible));
    Assert.assertTrue(verified.isDisplayed());
   // Driver.closeDriver();
}

@Test
    public void select_vehicle(){
        WebElement selectVehicle= Driver.getDriver().findElement(By.xpath("(//input[@tabindex='-1'])[1]"));
        selectVehicle.click();
      // Driver.closeDriver();
}

@Test
    public void all_Vehicle_is_selected(){
   WebElement select_All_vehicle = Driver.getDriver().findElement(By.xpath("//th[@class='select-all-header-cell renderable grid-cell grid-header-cell grid-header-cell-massAction']"));
    select_All_vehicle.click();
   //Driver.closeDriver();

}
@AfterMethod
    public void tearDown(){
        Driver.closeDriver();
}


}









