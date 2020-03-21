package com.automation.tests.day10;

import com.automation.tests.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecuter {
    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyTitle(){
    String expected="Practice";
        JavascriptExecutor js=(JavascriptExecutor)driver;
        String actual=(String) js.executeScript("return document.title").toString();

        Assert.assertEquals(actual,expected);
    }
    @Test
    public void clickTest(){
        WebElement link=driver.findElement(By.linkText("Multiple Buttons"));
        //link.click();
        JavascriptExecutor js =(JavascriptExecutor)driver;
        //after "" you can list webelements that will be used
        js.executeScript("arguments[0].click()",link);
        WebElement button6=driver.findElement(By.id("disappearing_button"));
        js.executeScript("arguments[0].click()",button6);
        BrowserUtilities.wait(2);
        WebElement result=driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),"Now it's gone!");

    }

    @Test
    public void textInputTest() {
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtilities.wait(3);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbtn = driver.findElement(By.name("wooden_spoon"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //to get text from input box - read attribute "value"
        //to enter text - set attribute "value"
        //.setAttribute ('value','text') -enter some text
        js.executeScript("arguments[0].setAttribute('value', 'tomsmith')", username);
        js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')", password);
        js.executeScript("arguments[0].click()", loginbtn);
        BrowserUtilities.wait(5);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent")
                .toString();
        Assert.assertEquals(subheader, expected);
    }
        @Test
    public void scrollToElement(){
        BrowserUtilities.wait(5);



    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
