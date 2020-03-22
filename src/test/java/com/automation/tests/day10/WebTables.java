package com.automation.tests.day10;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {
    private WebDriver driver;

    @Test
    public void getColumnName(){
        //th-represents table headers cells
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email","Due", "Web Site","Action");
        List<WebElement> columnNames=driver.findElements(By.xpath("//table[1]//th"));
        for(WebElement columnName:columnNames){
            System.out.println(columnName.getText());
        }
        Assert.assertEquals(BrowserUtilities.getTextFromWebElements(columnNames),expected);
    }

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        BrowserUtilities.wait(3);
        driver.quit();
    }
}


