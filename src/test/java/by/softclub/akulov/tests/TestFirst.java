package by.softclub.akulov.tests;

import by.softclub.akulov.logic.Auth;
import by.softclub.akulov.pages.HomePage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TestFirst {

    @Test
    public void scenario1() {
        new Auth().login();
        Assert.assertTrue(new HomePage().isHomePage());
    }
}

