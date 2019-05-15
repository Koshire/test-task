package by.softclub.akulov.tests;

import by.softclub.akulov.logic.Auth;
import by.softclub.akulov.logic.ExitProfile;
import by.softclub.akulov.pages.HomePage;
import by.softclub.akulov.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSecond {

    @BeforeTest
    public void prepare() {

        if (!new LoginPage().isLoginPage() && !new HomePage().isHomePage()) {
            new Auth().login();
        }
    }

    @Test
    public void scenario2() {
        new ExitProfile().logoff();
        Assert.assertTrue(new LoginPage().isLoginPage());
    }
}
