package com.automation.tests.warmup;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LastNameColumn {
    private WebDriver driver;


    @Test
    public void verifyNameOrder() {
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
        BrowserUtils.wait(2);
        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
        for (int i = 0; i < column.size()-1; i++) {
            String value = column.get(i).getText();
            String nextValue = column.get(i + 1).getText();
            System.out.println(value.compareTo(nextValue));
            Assert.assertTrue(value.compareTo(nextValue) <= 0);
        }
    }

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }
}

