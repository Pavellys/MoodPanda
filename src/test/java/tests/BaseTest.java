package tests;

import com.codeborne.selenide.Configuration;
import constants.Constants;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.FeedPage;
import pages.LoginPage;
import pages.RateYourHappiness;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest implements Constants {
    LoginPage loginPage;
    FeedPage feedPage;
    RateYourHappiness rateYourHappiness;

    @BeforeMethod
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 15000;
        loginPage = new LoginPage();
        feedPage = new FeedPage();
        rateYourHappiness = new RateYourHappiness();
    }
    @AfterMethod
    public void closeBrowser(){
        getWebDriver().quit();
    }
}
