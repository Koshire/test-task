package by.softclub.akulov.tests;

import by.softclub.akulov.logic.Auth;
import by.softclub.akulov.logic.ExitProfile;
import by.softclub.akulov.logic.OnlyPassword;
import by.softclub.akulov.pages.HomePage;
import by.softclub.akulov.utils.Constants;
import by.softclub.akulov.utils.WDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestThird {

    private WebDriver driver = WDriver.getInstance();

    @BeforeTest
    public void prepare() {

        if (driver.getTitle().toString().equals("")) {
            new Auth().login();
        } else {
            new OnlyPassword().login();
        }
    }

    @Test
    public void scenario2() {
        HomePage homePage = new HomePage();
        homePage.newMessageClick()
                .newMessageCreate(Constants.e_mail, Constants.subject, Constants.mail_text);
        Assert.assertTrue(homePage.meMessage());
    }

    @AfterTest
    public void end() {
        new ExitProfile().logoff();
    }
}
