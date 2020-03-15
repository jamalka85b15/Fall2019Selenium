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

import java.util.List;

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

@Test
public void forgotPassword(){
    driver.findElement(By.linkText("Forgot Password")).click();
    driver.findElement(By.name("email")).sendKeys("jamal_d@list.ru");
    driver.findElement(By.id("form_submit")).click();
    String expected = "Your e-mail's been sent!";
    String actual=driver.findElement(By.name("confirmation_message")).getText();
    Assert.assertEquals(actual,expected);

}

@Test
public void selectBox1(){
    driver.findElement(By.linkText("Checkboxes")).click();
    List<WebElement> checkboxes=driver.findElements(By.tagName("input"));
    BrowserUtilities.wait(3);

    checkboxes.get(0).click();
     Assert.assertTrue(checkboxes.get(0).isSelected());
     BrowserUtilities.wait(4);

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
