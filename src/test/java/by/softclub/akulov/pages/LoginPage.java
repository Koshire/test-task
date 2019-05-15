package by.softclub.akulov.pages;

import by.softclub.akulov.utils.Constants;
import by.softclub.akulov.utils.WDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private static final String butNext = "//*[@id=\"identifierNext\"]";
    private static final String inputUserName = "//*[@id=\"identifierId\"]";
    private static final String isLogo = ".qZp31e > svg:nth-child(1)";

    private WebDriver driver = WDriver.getInstance();

    @FindBy(xpath = inputUserName)
    private WebElement userName;

    @FindBy(xpath = butNext)
    private WebElement buttonNext;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isLoginPage() {
        String url = driver.getCurrentUrl();
        return url.contains(Constants.urlContainLogin);
    }

    public LoginPage LoginActive(String user) {
        WDriver.check(userName);
        userName.sendKeys(user);
        WDriver.check(buttonNext);
        buttonNext.click();
        return this;
    }
}
