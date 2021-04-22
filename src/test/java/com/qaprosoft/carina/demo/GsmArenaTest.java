package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.compare.HeaderMenu;
import com.qaprosoft.carina.demo.gui.model.User;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.LoginFailedPage;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GsmArenaTest extends AbstractTest {

    @Test(description = "JIRA#AUTO-0001")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifyHeaderComponents() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        softAssert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
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
        String iconUserLogOut = "Icon user log out is not present";
        User testUser = UserCreator.withCredentialsFromProperty();
        boolean userLoggedIn = new LoginPage(getDriver())
                .openPage()
                .login(testUser)
                .isIconUserLogOutPresent();
        Assert.assertTrue(userLoggedIn, iconUserLogOut);
    }

    @Test(description = "JIRA#AUTO-0003")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifyUnsuccessfulLogin() {
        LoginFailedPage loginFailedPage = new LoginFailedPage(getDriver());
        User testUser = UserCreator.withCredentialsFromProperty();
        String userRecordNotFound = new LoginPage(getDriver())
                .openPage()
                .loginWithWrongEmail(testUser)
                .getTextFromLoginFailedPage();
        Assert.assertEquals(userRecordNotFound, loginFailedPage.loginEmailFailed());
    }

    @Test(description = "JIRA#AUTO-0004")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifyUnsuccessfulPassword() {
        LoginFailedPage loginFailedPage = new LoginFailedPage(getDriver());
        User testUser = UserCreator.withCredentialsFromProperty();
        String userRecordNotFound = new LoginPage(getDriver())
                .openPage()
                .loginWithWrongPassword(testUser)
                .getTextFromLoginFailedPage();
        Assert.assertEquals(userRecordNotFound, loginFailedPage.loginPasswordFailed());
    }
}
