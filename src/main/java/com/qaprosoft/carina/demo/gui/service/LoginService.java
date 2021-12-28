package com.qaprosoft.carina.demo.gui.service;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.components.LoginForm;
import org.testng.Assert;

public class LoginService implements IDriverPool {

    public HomePage login(UserService user) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        LoginForm loginForm = homePage.getHeaderMenu().openLoginForm();
        loginForm.login(user);
        Assert.assertTrue(loginForm.isLoginFormPresent(), "User wasn't login on website");
        return new HomePage(getDriver());
    }
}
