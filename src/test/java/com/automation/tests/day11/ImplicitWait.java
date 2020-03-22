package com.automation.tests.day11;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    private WebDriver driver;


    @BeforeMethod
    private void setup(){
        driver= DriverFactory.createADriver("chrome");

    }


    @AfterMethod
    private void teardown(){
        driver.quit();
    }

    @Test
    public void waitForTitle(){
        driver.get("http://google.com");


        WebDriverWait wait = new WebDriverWait(driver,10);
                //wait up tp 10 seconds until title contains Google
                wait.until(ExpectedConditions.titleContains("Google"));
        System.out.println(driver.getTitle());

    }

}
