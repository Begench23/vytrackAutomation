package com.vytrack.tests.cy12_59;

import com.vytrack.tests.cy12_59.pageElements.HomePageElements;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CY12_59_UserStory {


    // global usage classes
    HomePageElements homePageElements = new HomePageElements();
    Actions action = new Actions(Driver.getDriver());

    @BeforeClass
    public void classSetUp() {

        VytrackUtils.loginAsDriver();
        Assert.assertEquals(Driver.getDriver().getTitle(),("Dashboard"));

    }
    @AfterClass
    public void classTearDown(){
        Driver.closeDriver();
    }



    @Test
    public void CY12_59Test_step1() {

        List<WebElement> homePageModules = homePageElements.getModules();

        String expectedText = "Fleet";
        String actualText = homePageModules.get(0).getText();
        Assert.assertEquals(actualText, expectedText);

        //user hover to Fleet module
        action.moveToElement(homePageModules.get(0)).perform();

    }

    @Test
    public void CY12_59Test_step2() {

        WebElement vehiclesOption = homePageElements.getVehiclesOption();

        String expectedText = "Vehicles";
        String actualText = vehiclesOption.getText();
        Assert.assertEquals(actualText, expectedText);

        //user click Vehicle option
        action.moveToElement(vehiclesOption).click().perform();

        Assert.assertTrue(homePageElements.getCarsPageHeader().isDisplayed());

    }

    @Test
    public void CY12_59Test_step3() {

        String beforeHover= "dropdown";
        String afterHover= "dropdown open";

        List<WebElement> moreOptionsBars = homePageElements.getMoreOptionsBars();

        BrowserUtils.sleep(4);


        for (WebElement eachBar : moreOptionsBars) {

            Assert.assertEquals(eachBar.getAttribute("class"),beforeHover);

            action.moveToElement(eachBar).perform();

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

            wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//div[@class='dropdown open']"))));

            Assert.assertEquals(eachBar.getAttribute("class"),afterHover);
        }

    }


}


