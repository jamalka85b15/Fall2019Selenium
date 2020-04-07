package com.automation.tests;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;


public class TestBase {
    protected WebDriver driver;
    protected String url;

    @BeforeMethod
    public void setup(){
        driver= Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        url= ConfigurationReader.getProperty("url");
        driver.get(url);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        Driver.closeDriver();
    }

}
