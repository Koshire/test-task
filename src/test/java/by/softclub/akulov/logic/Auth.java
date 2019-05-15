package by.softclub.akulov.logic;

import by.softclub.akulov.pages.LoginPage;
import by.softclub.akulov.pages.PasswordPage;
import by.softclub.akulov.utils.Constants;

public class Auth {

    public void login() {
        new OpenSite().openSite();
        new LoginPage().LoginActive(Constants.e_mail);
        new PasswordPage().PasswordActive(Constants.password);
    }
}
