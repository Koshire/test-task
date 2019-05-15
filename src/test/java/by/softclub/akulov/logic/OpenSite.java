package by.softclub.akulov.logic;

import by.softclub.akulov.utils.Constants;
import by.softclub.akulov.utils.WDriver;
import org.openqa.selenium.WebDriver;

public class OpenSite {

    private WebDriver drv = WDriver.getInstance();

    public void openSite() {
        drv.get(Constants.site_name);
    }
}
