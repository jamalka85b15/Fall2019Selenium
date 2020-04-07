package com.automation.tests.day12;
import com.automation.pages.LoginPage;
import com.automation.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    @Test
    public void login() {
        LoginPage loginPage=new LoginPage();
//        driver.findElement(By.id("prependedInput")).sendKeys("user1", Keys.ENTER);
//        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        loginPage.username.sendKeys("prependedInput");
        loginPage.password.sendKeys("prependedInput2");
        loginPage.login.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

    }
    @Test
    public void loginUser(){
        LoginPage loginPage=new LoginPage();
        loginPage.login("user2","UserUser123");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
}
@Test
public void loginAdDriver(){
    LoginPage loginPage=new LoginPage();
    loginPage.login();
    Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }
}

