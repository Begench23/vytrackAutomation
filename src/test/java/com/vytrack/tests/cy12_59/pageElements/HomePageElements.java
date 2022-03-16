package com.vytrack.tests.cy12_59.pageElements;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageElements {



    public HomePageElements() {

        PageFactory.initElements(Driver.getDriver(), this);

    }


    //homePage Modules
    @FindBy (xpath = "//span[@class='title title-level-1']")
    private List<WebElement> modules;

    public List<WebElement> getModules() {
        return modules;
    }

    @FindBy (xpath= "//span[text()='Vehicles']")
    private WebElement vehiclesOption;

    public WebElement getVehiclesOption() {
        return vehiclesOption;
    }

    @FindBy (xpath = "//h1[@class='oro-subtitle']")
    private WebElement carsPageHeader;

    public WebElement getCarsPageHeader() {
        return carsPageHeader;
    }


    @FindBy (xpath = "//div[@class='more-bar-holder']/div")
    private List<WebElement> moreOptionsBars;

    public List<WebElement> getMoreOptionsBars() {
        return moreOptionsBars;
    }






















    @FindBy (xpath = "//tr//td//div[@class='more-bar-holder']")
    private List<WebElement> moreOptionsButtons;

    public List<WebElement> gerMoreOptionsButtons(){
        return moreOptionsButtons;
    }

    // all available vehicles, visible only after hovering
    @FindBy (xpath = "//a[@href='#'][@title='Delete']")
    private WebElement deleteVehicleIcon;

    public WebElement getDeleteVehicleIcon() {
        return deleteVehicleIcon;
    }


    @FindBy (xpath = "//tr//td//div[@class='more-bar-holder']/div/ul/li/ul/li/a[@title='View']")
    private List<WebElement> viewOption;

    public List<WebElement> getViewOption() {
        return viewOption;
    }


    //Fleet Module options
    @FindBy (xpath = "(//ul/li[@class='dropdown dropdown-level-1'])[1]//span[@class='title title-level-2']")
    public List<WebElement> fleetOptions;




}
