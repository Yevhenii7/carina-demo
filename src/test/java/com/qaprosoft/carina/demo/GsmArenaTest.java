package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.components.WebConstants;
import com.qaprosoft.carina.demo.gui.pages.*;
import com.qaprosoft.carina.demo.gui.service.LoginService;
import com.qaprosoft.carina.demo.gui.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.qaprosoft.carina.demo.gui.components.WebConstants.GSM_ARENA_LOGIN_FAILED_EMAIL;
import static com.qaprosoft.carina.demo.gui.components.WebConstants.GSM_ARENA_LOGIN_FAILED_PASSWORD;

public class GsmArenaTest extends AbstractTest {

    @Test(description = "JIRA#AUTO-0001")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifyHeaderComponents() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        HeaderMenu headerMenu = homePage.getHeaderMenu();
        softAssert.assertTrue(headerMenu.isBurgerMenuPresent(), "Burger menu is not present");
        softAssert.assertTrue(headerMenu.isLogoPresent(), "Logo is not present");
        softAssert.assertTrue(headerMenu.isTopSearch(), "Top search is not present");
        softAssert.assertTrue(headerMenu.isTipUsIconPresent(), "Tip Us icon is not present");
        softAssert.assertTrue(headerMenu.isFaceBookIconPresent(), "Facebook icon is not present");
        softAssert.assertTrue(headerMenu.isTwitterIconPresent(), "Twitter icon in not present");
        softAssert.assertTrue(headerMenu.isInstagramIconPresent(), "Instagram icon is not present");
        softAssert.assertTrue(headerMenu.isYoutubeIconPresent(), "Youtube icon is not present");
        softAssert.assertTrue(headerMenu.isRssIconPresent(), "Rss icon is not present");
        softAssert.assertTrue(headerMenu.isLoginIconPresent(), "Login icon is not present");
        softAssert.assertTrue(headerMenu.isUserIconPresent(), "Login icon is not present");
        softAssert.assertAll();
    }

    @Test(description = "JIRA#AUTO-0002")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifySuccessLogin() {
        UserCreator userCreator = new UserCreator();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        LoginForm loginForm = homePage.getHeaderMenu().openLoginForm();
        Assert.assertTrue(loginForm.isLoginFormPresent(), "Login form is not present");
        loginForm.login(userCreator);
        Assert.assertTrue(homePage.getHeaderMenu().isIconLogOutPresent(), "Log out icon is not present");
    }

    @Test(description = "JIRA#AUTO-0003")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifyLoginWithInvalidEmail() {
        UserCreator userCreator = new UserCreator();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        LoginForm loginForm = homePage.getHeaderMenu().openLoginForm();
        Assert.assertTrue(loginForm.isLoginFormPresent(), "Login form is not present");
        LoginPage loginPage = loginForm.loginWithInvalidEmail(userCreator);
        Assert.assertEquals(loginPage.loginFailed(), GSM_ARENA_LOGIN_FAILED_EMAIL, "Login is not failed");
    }

    @Test(description = "JIRA#AUTO-0004")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifyLoginWithInvalidPassword() {
        UserCreator userCreator = new UserCreator();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page doesn't open");

        LoginForm loginForm = homePage.getHeaderMenu().openLoginForm();
        Assert.assertTrue(loginForm.isLoginFormPresent(), "Login form is not present");
        LoginPage loginPage = loginForm.loginWithInvalidPassword(userCreator);
        Assert.assertEquals(loginPage.loginFailed(), GSM_ARENA_LOGIN_FAILED_PASSWORD, "Password is not wrong");
    }

//    @Test(description = "JIRA#AUTO-0004")
//    @MethodOwner(owner = "Kolchyba Yevhenii")
//    public void verifyArticleName() {
//        LoginService loginService = new LoginService();
//        UserCreator userCreator = new UserCreator();
//        HomePage homePage = new HomePage(getDriver());
//        homePage.open();
//        Assert.assertTrue(homePage.isPageOpened(), "Home page doesn't open");
//
//        loginService.login(userCreator);
//        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
//        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
//
//        ArticlePage articlePage = newsPage.clickLinkFirstArticle();
//        Assert.assertTrue(articlePage.isPageOpened(),"Article page is not opened");
//        Assert.assertEquals();
//    }
}
