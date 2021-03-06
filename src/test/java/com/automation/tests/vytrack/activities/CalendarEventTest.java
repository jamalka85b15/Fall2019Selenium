package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
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
    private By currentuserBy=By.cssSelector("#user-menu > a");
    private By ownerBy=By.className("select2-chosen");
    private By titleBy= By.cssSelector("[name='oro_calendar_event_form[title]']");

    private WebDriver driver;
    private Actions actions;

@Test
public void verifyCreateButton() {
    WebElement createCallendarEventBtn= driver.findElement(createCalendarEventBtnBy);
    Assert.assertTrue(createCallendarEventBtn.isDisplayed());

    }
    @Test (description = "Default options")
    public void verifyDefaultValues(){
    driver.findElement(createCalendarEventBtnBy).click();
    BrowserUtils.wait(3);
    String currentUserName=driver.findElement(currentuserBy).getText().trim();
    String defaultOwner=driver.findElement(ownerBy).getText().trim();
    Assert.assertEquals(currentUserName,defaultOwner);

    WebElement titleElement= driver.findElement(titleBy);
    Assert.assertTrue(titleElement.getAttribute("value").isEmpty());
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
        BrowserUtils.wait(5);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(5);


    }

    //*************************************************************

    @AfterMethod
    public void teardown() {
        driver.quit();

    }


}

