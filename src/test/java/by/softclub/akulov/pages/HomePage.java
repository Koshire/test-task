package by.softclub.akulov.pages;

import by.softclub.akulov.utils.Constants;
import by.softclub.akulov.utils.WDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static final String inboxConst = ".aHS-bnt > div:nth-child(2)";
    private static final String profileConst = ".gb_Da";
    private static final String newMessageButtonConst = ".T-I-KE";
    private static final String textToConst = "to";
    private static final String subjConst = "subjectbox";
    private static final String messageTextConst = "//div[contains(@aria-label,'Тело письма')]";
    private static final String logOffConst = "//*[@id=\"gb_71\"]";
    private static final String letterToMeConst = "//div//span[contains(.,'This is test text!')]";

    private WebDriver drv = WDriver.getInstance();

    @FindBy(css = inboxConst)
    private WebElement inbox;

    @FindBy(css = profileConst)
    private WebElement profile;

    @FindBy(css = newMessageButtonConst)
    private WebElement newMessageButton;

    @FindBy(name = textToConst)
    private WebElement textTo;

    @FindBy(name = subjConst)
    private WebElement subject;

    @FindBy(xpath = messageTextConst)
    private WebElement messageText;

    @FindBy(xpath = logOffConst)
    private WebElement logoff;

    @FindBy(xpath = letterToMeConst)
    private WebElement letterToMe;

    public HomePage() {
        PageFactory.initElements(drv, this);
    }

    public HomePage newMessageCreate(String to, String subj, String messText) {
        WDriver.check(textTo);
        textTo.sendKeys(to);
        subject.sendKeys(subj);
        messageText.sendKeys(messText);
        String send = Keys.chord(Keys.CONTROL, Keys.ENTER);
        messageText.sendKeys(send);
        return this;
    }

    public boolean meMessage() {
        WDriver.check(letterToMe);
        return letterToMe.isDisplayed();
    }

    public HomePage newMessageClick() {
        WDriver.check(newMessageButton);
        newMessageButton.click();
        return this;
    }

    public boolean isHomePage() {
        String url = drv.getCurrentUrl();
        return url.contains(Constants.urlContainHome);
    }

    public void logOff() {
        profile.click();
        logoff.click();
    }

    public HomePage getHomePage() {
        return new HomePage();
    }
}
