package com.automation.tests.vytrack.fleet;

import com.automation.tests.BrowserUtilities;
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


import java.util.List;

public class VehiclePageTests {
    private WebDriver driver;
    private String URL="https://qa2.vytrack.com/user/login";
    private String username="storemanager85";
    private String password="UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By fleetBy=By.xpath("//span[@class='title title-level-1' and contains(text(), 'Fleet')]");
    private By subtitleBy=By.className("oro-subtitle");



@Test
    public void verifyPageSubTitle(){
    driver.findElement(usernameBy).sendKeys(username);
    driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
    BrowserUtilities.wait(5);
    driver.findElement(fleetBy).click();
    BrowserUtilities.wait(2);

    driver.findElement(By.linkText("Vehicles")).click();
    WebElement subtitleElement =driver.findElement(subtitleBy);
    System.out.println(subtitleElement.getText());
   


}

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }


    }
}
