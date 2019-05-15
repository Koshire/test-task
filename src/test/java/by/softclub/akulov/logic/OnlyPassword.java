package by.softclub.akulov.logic;

import by.softclub.akulov.pages.PasswordPage;
import by.softclub.akulov.utils.Constants;

public class OnlyPassword {

    public void login() {
        new PasswordPage().PasswordActive(Constants.password);
    }
}
