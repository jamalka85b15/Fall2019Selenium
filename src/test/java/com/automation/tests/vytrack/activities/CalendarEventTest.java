package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalendarEventTest {

    private String URL = "https://qa2.vytrack.com/user/login";
    private String storeManagerUserName = "storemanager85";
    private String storeManagerPassword = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By createCalendarEventBtnBy = By.cssSelector("a[title='Create Calendar event']");

    private WebDriver driver;
    private Actions actions;

@Test
public void verifyCreateButton() {
    WebElement createCallendarEventBtn= driver.findElement(createCalendarEventBtnBy);
    Assert.assertTrue(createCallendarEventBtn.isDisplayed());

    }


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        actions=new Actions(driver);
        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtilities.wait(5);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtilities.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtilities.wait(5);


    }

    //*************************************************************

    @AfterMethod
    public void teardown() {
        driver.quit();

    }


}

