package com.automation.tests.day9;

import com.automation.tests.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {
    private WebDriver driver;
    private Actions actions;


    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createADriver("chrome");
        actions=new Actions(driver);

    }
    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtilities.wait(5);
        WebElement img1=driver.findElement(By.xpath("//img[1]"));
        WebElement img2=driver.findElement(By.xpath("//img[2]"));
        WebElement img3=driver.findElement(By.xpath("//img[3]"));
        //build() needs when you have couple actions
        //always finish with perform()
        actions.moveToElement(img1).pause(1000)
                .moveToElement(img2).build().perform();
    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
