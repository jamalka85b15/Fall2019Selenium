package com.automation.tests;

import com.automation.pages.DashboardPage;
import com.automation.pages.LoginPage;
import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;


public class PageSubtitleTest extends TestBase {

    @Test
    public void verifyySubtitleTest() {
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("driver");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();
    }
}
