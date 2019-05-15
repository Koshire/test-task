package by.softclub.akulov.pages;

import by.softclub.akulov.utils.Constants;
import by.softclub.akulov.utils.WDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {


    private static final String butNext = "//*[@id=\"passwordNext\"]";
    private static final String passIdent = ".I0VJ4d > div:nth-child(1) > input:nth-child(1)";
    private static final String urlContainPass = "pwd?";


    private WebDriver driver = WDriver.getInstance();

    @FindBy(css = passIdent)
    private WebElement password;

    @FindBy(xpath = butNext)
    private WebElement buttonNext;

    public PasswordPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isPasswordPage() {
        String url = driver.getCurrentUrl();
        return url.contains(urlContainPass) && url.contains(Constants.urlContainLogin);
    }

    public void PasswordActive(String pass) {
        WDriver.check(password);
        password.sendKeys(pass);
        WDriver.check(buttonNext);
        buttonNext.click();
    }
}
