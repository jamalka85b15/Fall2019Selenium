package com.automation.tests.day12;

import com.automation.tests.TestBase;
import com.automation.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.security.Key;

public class LoginTest extends TestBase {
    @Test
    public void login() {
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
        driver.findElement(By.id("prependedInput")).sendKeys("user1", Keys.ENTER);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
    }

}
