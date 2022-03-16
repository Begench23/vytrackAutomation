package com.vytrack.tests.vytrackLogInTest;

import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US3 {

    @Test(priority = 1)
    public void testPinBar()  {

        VytrackUtils.loginAsDriver();

        WebElement learnHowToUseLink = Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']"));
        learnHowToUseLink.click();

        VytrackUtils.waitTillLoaderMaskDisappear();
        WebElement how_to_use_pinbar_message = Driver.getDriver().findElement(By.xpath("//h3[.='How To Use Pinbar']"));

        String actualMessage = how_to_use_pinbar_message.getText();
        String expectedMessage = "How To Use Pinbar";
        Assert.assertEquals(actualMessage, expectedMessage, "How to use pinbar message did not match and fail");


        WebElement pin_icon_message = Driver.getDriver().findElement(By.xpath("(//p)[1]"));

        String actualHeaderMessage = pin_icon_message.getText();
        String expectedHeaderMessage = "Use pin icon on the right top corner of page to create fast access link in the pinbar.";
        Assert.assertEquals(actualHeaderMessage, expectedHeaderMessage, "Pin icon message did not match and fail");

    }

    @Test(priority = 2)
    public void testValidateUsersSeeImage() {

        VytrackUtils.loginAsDriver();

        WebElement learnHowToUseLink = Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']"));
        learnHowToUseLink.click();

        VytrackUtils.waitTillLoaderMaskDisappear();

        WebElement image = Driver.getDriver().findElement(By.cssSelector("img[src='/bundles/oronavigation/images/pinbar-location.jpg']"));

        Assert.assertTrue(image.isDisplayed());

        String actualSource = image.getAttribute("src").replace("https://qa1.vytrack.com", "");
        String expectedSource = "/bundles/oronavigation/images/pinbar-location.jpg";
        Assert.assertEquals(actualSource, expectedSource);


    }

}
