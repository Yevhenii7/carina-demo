package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.service.UserService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AbstractUIObject {

    private static final Logger LOGGER = Logger.getLogger(LoginForm.class);

    @FindBy(id = "login-popup2")
    private ExtendedWebElement loginForm;

    @FindBy(id = "email")
    private ExtendedWebElement inputEmail;

    @FindBy(id = "upass")
    private ExtendedWebElement inputPassword;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement submitButton;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public HomePage submitLogin() {
        submitButton.click();
        LOGGER.info("Login performed");
        return new HomePage(getDriver());
    }

    public HomePage login(UserService user) {
        inputEmail.type(user.getUser().getEmail());
        inputPassword.type(user.getUser().getPassword());
        return submitLogin();
    }

    public LoginPage loginWithInvalidEmail(UserService user) {
        inputEmail.type(user.getUserWithInvalidEmail().getEmail());
        inputPassword.type(user.getUserWithInvalidEmail().getPassword());
        submitButton.click();
        LOGGER.info("Login is not performed out of invalid email!");
        return new LoginPage(getDriver());
    }

    public LoginPage loginWithInvalidPassword(UserService user) {
        inputEmail.type(user.getUserWithInvalidPassword().getEmail());
        inputPassword.type(user.getUserWithInvalidPassword().getPassword());
        submitButton.click();
        LOGGER.info("Login is not performed out of invalid password!");
        return new LoginPage(getDriver());
    }

    public boolean isLoginFormPresent() {
        return loginForm.isPresent();
    }
}
