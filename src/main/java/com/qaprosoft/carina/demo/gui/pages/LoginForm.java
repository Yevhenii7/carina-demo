package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.service.UserCreator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(GlossaryPage.class);

    @FindBy(id = "login-popup2")
    private ExtendedWebElement loginForm;

    @FindBy(id = "email")
    private ExtendedWebElement inputEmail;

    @FindBy(id = "upass")
    private ExtendedWebElement inputPassword;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement loginBtn;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public HomePage login(UserCreator user) {
        inputEmail.type(user.getUser().getEmail());
        inputPassword.type(user.getUser().getPassword());
        loginBtn.click();
        LOGGER.info("Login performed");
        return new HomePage(getDriver());
    }

    public LoginPage loginWithInvalidEmail(UserCreator user) {
        inputEmail.type(user.getUserWithInvalidEmail().getEmail());
        inputPassword.type(user.getUserWithInvalidEmail().getPassword());
        loginBtn.click();
        LOGGER.info("Login is not performed out of invalid email!");
        return new LoginPage(getDriver());
    }

    public LoginPage loginWithInvalidPassword(UserCreator user) {
        inputEmail.type(user.getUserWithInvalidPassword().getEmail());
        inputPassword.type(user.getUserWithInvalidPassword().getPassword());
        loginBtn.click();
        LOGGER.info("Login is not performed out of invalid password!");
        return new LoginPage(getDriver());
    }

    public boolean isLoginFormPresent() {
        return loginForm.isPresent();
    }
}
