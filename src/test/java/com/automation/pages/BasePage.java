package com.automation.pages;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver = Driver.getDriver();

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //methods to navigate in fleet management
    //tabName like Dashboard, Activities
    //moduleName like Vehicle cost, Vehovles
    public void navigateTo(String tabName, String moduleName) {
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'" + tabName + "')]";
        String moduleXpath = "//span[@class='title title-level-2' and text()='" + moduleName + "']";

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));

        Actions actions = new Actions(driver);
        BrowserUtilities.wait(4);
        actions.moveToElement(tabElement).
                pause(2000).
                click(moduleElement).
                build().perform();

        BrowserUtilities.wait(4);
    }
}




