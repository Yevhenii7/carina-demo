package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.components.NewsItem;
import com.qaprosoft.carina.demo.gui.pages.*;
import com.qaprosoft.carina.demo.gui.service.LoginService;
import com.qaprosoft.carina.demo.gui.service.UserCreator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.qaprosoft.carina.demo.gui.components.WebConstants.*;

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
        Assert.assertEquals(homePage.getHeaderMenu().getUserNickname(), R.TESTDATA.get("nickname"), "Icon LogOut is not present");
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

    @Test(description = "JIRA#AUTO-0005")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifyArticleNameTest() {
        LoginService loginService = new LoginService();
        UserCreator userCreator = new UserCreator();
        HomePage homePage = loginService.login(userCreator);
        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
        String titleNews = newsPage.getFirstArticleFromNewsPage();
        ArticlePage articlePage = newsPage.clickFirstArticleFromNewsPage();
        Assert.assertTrue(articlePage.isPageOpened(), "Article page is not opened");
        Assert.assertEquals(articlePage.getArticleTitle(), titleNews, "Articles are not the same");
    }

    @Test(description = "JIRA#AUTO-0006")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifySearchingProcessTest() {
        LoginService loginService = new LoginService();
        UserCreator userCreator = new UserCreator();
        HomePage homePage = loginService.login(userCreator);
        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
        final String searchQ = "iphone";
        String resultSearch = "Results for \"" + searchQ + "\"";
        List<NewsItem> news = newsPage.searchNews(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(news), "News not found!");
        Assert.assertEquals(newsPage.getFirstArticleFromNewsPage(), resultSearch, "Titles are not equals");
        for (NewsItem newsItem : news) {
            Assert.assertTrue(StringUtils.containsIgnoreCase(newsItem.readTitle(), searchQ), "Invalid search results!");
        }
    }

    @Test(description = "JIRA#AUTO-0007")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void findSpecificDevicesTest() {
        LoginService loginService = new LoginService();
        UserCreator userCreator = new UserCreator();
        HomePage homePage = loginService.login(userCreator);
        AllBrandsPage allBrandsPage = homePage.getSliderMenu().clickAllBrandsLink();
        Assert.assertEquals(allBrandsPage.getArticleTitle(), ALL_MOBILE_PHONE_BRANDS_TITLE, "Article titles are not the same");
        ApplePage applePage = allBrandsPage.clickAppleLink();
        Assert.assertEquals(applePage.getArticleTitle(), ARTICLE_TITLE_IPHONE, "Article titles are not the sam");
        applePage.clickIconCompare();
        applePage.selectModels("0", "1", "2");
        CompareModelsPage compareModelsPage = applePage.clickIcon();
        Assert.assertTrue(compareModelsPage.isPageOpened(), "Compare model page is not opened");
    }
}
