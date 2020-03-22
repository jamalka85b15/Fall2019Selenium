package com.automation.tests.vytrack.fleet;
import com.automation.utilities.BrowserUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehiclePageTests {
    private String URL = "https://qa2.vytrack.com/user/login";
    //    CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By subtitleBy = By.className("oro-subtitle");
    private By pageNumber =By.cssSelector("input[type='number']");
    private WebDriver driver;

    //****************************************************************

    @Test
    public void verifyPageSubTitle(){

        //find subtitle element
        WebElement subTitleElement = driver.findElement(subtitleBy);
        System.out.println(subTitleElement.getText());
        String expected="All Cars";
        String actual=subTitleElement.getText();
        Assert.assertEquals(actual,expected);
    }

    //*********************************************************

    @Test(description = "Verify page is equal to '1' ")
            public void verifyPageEqualToOne() {
    String expected ="1";
    String actual=driver.findElement(pageNumber).getAttribute("value");
    Assert.assertEquals(expected,actual);
    }

    //**********************************************************

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtilities.wait(5);
        driver.findElement(fleetBy).click();
        BrowserUtilities.wait(2);

        driver.findElement(By.linkText("Vehicles")).click();

        BrowserUtilities.wait(5);
    }

    //*************************************************************

    @AfterMethod
    public void teardown() {
        //if webdriver object alive
        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy webdriver object for sure
            driver = null;
        }
    }
}