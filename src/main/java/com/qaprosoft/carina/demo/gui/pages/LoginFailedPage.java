package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginFailedPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//div[@class='normal-text res-error']/child::p")
    private ExtendedWebElement textFromLoginPage;

    public LoginFailedPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromLoginFailedPage() {
        assertElementPresent(textFromLoginPage);
        LOGGER.info("User record not found");
        return textFromLoginPage.getText();
    }

    public String loginEmailFailed() {
        return "Reason: User record not found.";
    }

    public String loginPasswordFailed() {
        return "Reason: Wrong password.";
    }
}
