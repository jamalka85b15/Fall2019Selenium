package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByID {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        WebElement userName=driver.findElement(By.name("username"));
        userName.sendKeys("tomsmith");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);
        String expected ="Welcome to the Secure Area. When you are done click logout below.";

        String actual=driver.findElement(By.tagName("h4")).getText();
        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        WebElement logout =driver.findElement(By.partialLinkText("Logout"));
        logout.click();
        Thread.sleep(2000);





    }
}
