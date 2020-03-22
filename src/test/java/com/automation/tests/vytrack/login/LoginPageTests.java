package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests {
    private WebDriver driver;
    private String URL="https://qa2.vytrack.com/user/login";
    private String username="storemanager85";
    private String password="UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By warningMessageBy = By.cssSelector("[class='alert alert-error'] > div");

    @Test(description = "verify that warning message displays when user enters invalid username")
    public void invalidUsername() {
            driver.findElement(usernameBy).sendKeys("invalidusername");
            driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
            BrowserUtilities.wait(5);
            WebElement warningElement = driver.findElement(warningMessageBy);
            assertTrue(warningElement.isDisplayed());

        String expected ="Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(actual,expected);
    }

    @Test(description = "Login as store manager and verify that title is equal to Dashboard")
    public void loginAsStoreManager(){
driver.findElement(usernameBy).sendKeys(username);
driver.findElement(passwordBy).sendKeys(password,Keys.ENTER);
BrowserUtilities.wait(5);
String expeted="Dashboard";
String actual=driver.getTitle();

assertEquals(actual,expeted,"Page title is not correct");
    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void teardown(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }

    }


}
