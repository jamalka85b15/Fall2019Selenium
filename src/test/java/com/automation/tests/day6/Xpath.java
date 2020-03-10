package com.automation.tests.day6;

import com.automation.tests.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtilities.wait(3);


        WebElement btn1=driver.findElement(By.xpath("//button[@onclick='button1()']"));
        btn1.click();

        BrowserUtilities.wait(3);
        driver.quit();
    }
}
