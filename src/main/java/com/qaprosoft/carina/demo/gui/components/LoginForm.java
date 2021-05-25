package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.service.UserCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.log4testng.Logger;

public class LoginForm extends AbstractUIObject {

    private static final Logger LOGGER = Logger.getLogger(LoginForm.class);

    @FindBy(id = "login-popup2")
    private ExtendedWebElement loginForm;

    @FindBy(id = "email")
    private ExtendedWebElement inputEmail;

    @FindBy(id = "upass")
    private ExtendedWebElement inputPassword;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement btnSubmit;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginFormPresent() {
        return loginForm.isPresent();
    }

    public void inputEmail(String email) {
        inputEmail.type(email);
        LOGGER.info("Input email " + email);
    }

    public void inputPassword(String password) {
        inputPassword.type(password);
        LOGGER.info("Input password " + password);
    }

    public void clickSubmitBtn() {
        btnSubmit.click();
        LOGGER.info("Login performed");
    }

    public LoginPage loginWithInvalidEmail(UserCreator user) {
        inputEmail.type(user.getUserWithInvalidEmail().getEmail());
        inputPassword.type(user.getUserWithInvalidEmail().getPassword());
        btnSubmit.click();
        LOGGER.info("Login is not performed out of invalid email!");
        return new LoginPage(getDriver());
    }

    public LoginPage loginWithInvalidPassword(UserCreator user) {
        inputEmail.type(user.getUserWithInvalidPassword().getEmail());
        inputPassword.type(user.getUserWithInvalidPassword().getPassword());
        btnSubmit.click();
        LOGGER.info("Login is not performed out of invalid password!");
        return new LoginPage(getDriver());
    }

}
