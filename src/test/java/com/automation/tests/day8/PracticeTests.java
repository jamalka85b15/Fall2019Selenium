package com.automation.tests.day8;

import com.automation.tests.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeTests {
   private WebDriver driver;

@Test
public void loginTest(){
    driver.findElement(By.linkText("Form Authentication")).click();
    driver.findElement(By.name("username")).sendKeys("tomsmith");
    driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
    driver.findElement(By.id("wooden_spoon")).click();
    BrowserUtilities.wait(5);
    String expected ="Welcome to the Secure Area. When you are done click logout below.";
    String actual=driver.findElement(By.tagName("h4")).getText();
    Assert.assertEquals(expected,actual,"syb-header is not matching");
}



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
