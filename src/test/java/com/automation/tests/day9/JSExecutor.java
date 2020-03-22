package com.automation.tests.day9;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {
    RemoteWebDriver driver;

    @Test
    public void scrollTest() {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        for (int i = 0; i < 10; i++) {
            driver.executeScript("window.scrollBy(0,250)");
            BrowserUtilities.wait(2);
        }
    }


    @Test
    public void scrolltoElementTest(){
        driver.get("http://practice.cybertekschool.com");
        driver.manage().window().maximize();
        BrowserUtilities.wait(2);
            WebElement link = driver.findElement(By.linkText("Cybertek School"));
            driver.executeScript("arguments[0].scrollIntoView(true)", link);
    }


        @BeforeMethod
        public void setup(){
            WebDriverManager.chromedriver().version("79").setup();
            //driver = (RemoteWebDriver) MethodsContainer.createDriver("chrome");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @AfterMethod
        public void teardown(){
            BrowserUtilities.wait(3);
            driver.quit();
        }
    }