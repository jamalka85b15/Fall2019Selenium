package com.automation.tests.day9;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
        WebElement img1=driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2=driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3=driver.findElement(By.xpath("(//img)[3]"));
        //build() needs when you have couple actions
        //always finish with perform()
        actions.moveToElement(img1).pause(1000)
                .moveToElement(img2).pause(1000)
                .moveToElement(img3).build().perform();
        BrowserUtilities.wait(3);
        actions.moveToElement(img1).perform();
       WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Assert.assertTrue(imgText1.isDisplayed());

        actions.moveToElement(img2).perform();
        WebElement imgText2=driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());
    }

    @Test
    public void jqueryTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        BrowserUtilities.wait(2);
        WebElement enabled=driver.findElement(By.id("ui-id-3"));
        WebElement downloads=driver.findElement(By.id("ui-id-4"));
        WebElement pdf=driver.findElement(By.id("ui-id-5"));
        actions.moveToElement(enabled).pause(1000)
                .moveToElement(downloads).pause(1000)
                .moveToElement(pdf).pause(1000).perform();

    }
    @Test
    public void dragAndDropTest() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop");
        driver.manage().window().maximize();
        BrowserUtilities.wait(3);
        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon, earth).perform();
        String expected = "You did great!";
        String actual = earth.getText();
        Assert.assertEquals(expected, actual);
    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
