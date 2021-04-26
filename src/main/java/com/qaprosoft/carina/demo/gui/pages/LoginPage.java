package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//div[@class='normal-text res-error']/child::p")
    private ExtendedWebElement textLoginFail;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String loginFailed() {
        assertElementPresent(textLoginFail);
        LOGGER.info("User record not found");
        return textLoginFail.getText();
    }

}
