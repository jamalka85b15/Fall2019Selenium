package com.automation.tests.day7;

import com.automation.tests.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;

public class Xpath {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtilities.wait(3);


        BrowserUtilities.wait(3);
        driver.quit();
    }
}
