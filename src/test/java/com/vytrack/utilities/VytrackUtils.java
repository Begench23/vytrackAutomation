package com.vytrack.utilities;

import org.openqa.selenium.By;

public class VytrackUtils {



        public static void login(String username, String password) {
            //go to website
            Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
            // pass username
            // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
            Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(username);
            //pass password
            Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(password);
            //click login button
            Driver.getDriver().findElement(By.tagName("button")).click();

        }

        public static void loginAsDriver() {
            //go to website
            Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
            // pass username
            // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
            Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getProperty("truckDriver1_userName"));
            //pass password
            Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(ConfigurationReader.getProperty("password"));
            //click login button
            Driver.getDriver().findElement(By.tagName("button")).click();
        }

        public static void loginAsStoreManger() {
            //go to website
            Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
            // pass username
            // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
            Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getProperty("storeManager4_userName"));
            //pass password
            Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(ConfigurationReader.getProperty("password"));
            //click login button
            Driver.getDriver().findElement(By.tagName("button")).click();
        }

        public static void loginAsSalesManager() {
            //go to website
            Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
            // pass username
            // Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
            Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getProperty("salesManager1_userName"));
            //pass password
            Driver.getDriver().findElement(By.cssSelector("#prependedInput2")).sendKeys(ConfigurationReader.getProperty("password"));
            //click login button
            Driver.getDriver().findElement(By.tagName("button")).click();
        }
        
        
        public static void waitTillLoaderMaskDisappear() {
            try {
                WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
                WebElement loaderMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
                wait.until(ExpectedConditions.invisibilityOf(loaderMask));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void navigate(String tab,String module){

        }
        
}
