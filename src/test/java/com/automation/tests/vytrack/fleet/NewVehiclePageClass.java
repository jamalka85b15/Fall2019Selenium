package com.automation.tests.vytrack.fleet;

import com.automation.pages.LoginPage;
import com.automation.pages.fleet.VehiclePage;
import com.automation.tests.TestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NewVehiclePageClass extends TestBase {

    @Test
    public void verifyTitle(){
        LoginPage loginPage=new LoginPage();
        VehiclePage vehiclePage=new VehiclePage();

        loginPage.login();
        vehiclePage.navigateTo("Fleet", "Vehicles");
        String expected="Car - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expected);
    }

}
