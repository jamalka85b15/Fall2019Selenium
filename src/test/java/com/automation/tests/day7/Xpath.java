package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {
    static String userNameLocator="//label[text()='Username']/following-sibling::input";
    static  String passwordLocator="//label[text()='Password']/following-sibling::input";
    static String LoginBntLocator="//button[contains(text(), 'Login')]";
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(LoginBntLocator)).click();


        BrowserUtils.wait(3);
        driver.quit();

    }
}
