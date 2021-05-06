package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.BurgerMenu;
import com.qaprosoft.carina.demo.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.gui.components.ModelItem;
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
        Assert.assertTrue(homePage.getHeaderMenu().isIconLogOutPresent(), "Icon LogOut is not present");
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
        String titleNews = newsPage.getTitleFromNewsPage();
        ArticlePage articlePage = newsPage.clickFirstArticleFromNewsPage();
        Assert.assertTrue(articlePage.isPageOpened(), "Article page is not opened");
        Assert.assertEquals(articlePage.getArticleTitle(), titleNews, "Articles are not the same");
    }

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/mobile.xlsx", sheet = "GSMArena", dsUid = "TUID", dsArgs = "brand")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifySearchingProcessTest(String searchQ) {
        LoginService loginService = new LoginService();
        UserCreator userCreator = new UserCreator();
        HomePage homePage = loginService.login(userCreator);
        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");
        String resultSearch = "Results for \"" + searchQ + "\"";
        List<NewsItem> news = newsPage.searchNews(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(news), "News not found!");
        Assert.assertEquals(newsPage.getTitleFromNewsPage(), resultSearch, "Titles are not equals");
        for (NewsItem newsItem : news) {
            Assert.assertTrue(StringUtils.containsIgnoreCase(newsItem.readTitle(), searchQ), "Invalid search results!");
        }
    }

    @Test(description = "JIRA#AUTO-0008")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifyGlossaryParagraphTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        GlossaryPage glossaryPage = homePage.getFooterMenu().openGlossaryPage();
        Assert.assertTrue(glossaryPage.isPageOpened(), "Glossary page is not opened");
        Assert.assertTrue(glossaryPage.isGlossaryParagraphSizeMatchesListSize(), "Size are not equals");
        Assert.assertTrue(glossaryPage.verifyGlossaryParagraphMatchesText(), "Titles are not sorted by alphabet");
    }

    @Test(description = "JIRA#AUTO-0009")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifyGlossaryParagraphTextByAlphabetTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        GlossaryPage glossaryPage = homePage.getFooterMenu().openGlossaryPage();
        Assert.assertTrue(glossaryPage.isPageOpened(), "Glossary page is not opened");
        Assert.assertTrue(glossaryPage.verifyGlossaryParagraphTextByAlphabet(), "Glossary paragraph by alphabet");
    }

    @Test(description = "JIRA#AUTO-0010")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifyBurgerMenuInHeader() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        BurgerMenu burgerMenu = homePage.getHeaderMenu().clickBurgerMenu();
        Assert.assertTrue(burgerMenu.isBurgerMenuVisible(), "Burger menu is not visible");
        homePage = burgerMenu.openHomePage();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        NewsPage newsPage = burgerMenu.openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened");
        ReviewsPage reviewsPage = burgerMenu.openReviewsPage();
        Assert.assertTrue(reviewsPage.isPageOpened(), "Reviews page is not opened");
        VideosPage videosPage = burgerMenu.openVideosPage();
        Assert.assertTrue(videosPage.isPageOpened(), "Videos page is not opened");
        FeaturedPage featuredPage = burgerMenu.openFeaturedPage();
        Assert.assertTrue(featuredPage.isPageOpened(), "Featured page is not opened");
        PhoneFinderPage phoneFinderPage = burgerMenu.openPhoneFinderPage();
        Assert.assertTrue(phoneFinderPage.isPageOpened(), "Phone finder page is not opened");
        DealsPage dealsPage = burgerMenu.openDealsPage();
        Assert.assertTrue(dealsPage.isPageOpened(), "Deals page is not opened");
        ToolsPage toolsPage = burgerMenu.openToolsPage();
        Assert.assertTrue(toolsPage.isPageOpened(), "Tools page is not opened");
        CoveragePage coveragePage = burgerMenu.openCoveragePage();
        Assert.assertTrue(coveragePage.isPageOpened(), "Coverage page is not opened");
        ContactPage contactPage = burgerMenu.openContactPage();
        Assert.assertTrue(contactPage.isPageOpened(), "Contact page is not opened");
    }

    @Test(description = "JIRA#AUTO-0011")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifyPhoneFinderTest() {
        final String textResult = "results";
        final String modelBrand = "xiaomi";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPhoneFinderBlockPresent(), "Phone finder block is not present");
        PhoneFinderPage phoneFinderPage = homePage.getPhoneFinderMenu().openPhoneFinderPage();
        Assert.assertTrue(phoneFinderPage.isPageOpened(), "Phone finder page is not opened");
        Assert.assertTrue(phoneFinderPage.isArticlePhoneFinderPresent(), "Article phone finder is not present");
        phoneFinderPage.clickDropDownButton();
        phoneFinderPage.inputModelBrand(modelBrand);
        Assert.assertTrue(phoneFinderPage.isShowBtnPresent(), "Show button is not present");
        String textFromShowBtn = phoneFinderPage.readResultTextFromBtnShow();
        Assert.assertTrue(textFromShowBtn.contains(textResult), "Text from show btn is not contains results");
        PhoneFinderResultPage resultPage = phoneFinderPage.clickShowButton();
        Assert.assertTrue(resultPage.isPageOpened(), "Phone finder result page is not opened");
        String textSearchResult = resultPage.readSearchResult();
        Assert.assertTrue(textSearchResult.contains(textFromShowBtn), "Search result does not contains text from 'Show' button");
        Assert.assertTrue(resultPage.isClickHereLinkPresent(), "'Click here' link is not present");
        List<ModelItem> listModels = resultPage.readModelItemList();
        Assert.assertFalse(listModels.isEmpty(), "List of models is empty");

        for (ModelItem item : listModels) {
            Assert.assertTrue(item.readModel().toLowerCase().contains(modelBrand.toLowerCase()), "List of models does not contains " + modelBrand);
        }
        Assert.assertTrue(resultPage.isHereLinkPresent(), "'Here' link is not present");
        resultPage.clickLinkClickHere();
        Assert.assertTrue(phoneFinderPage.isArticlePhoneFinderPresent(), "Article 'Phone Finder' is not present");
    }

    @Test(description = "JIRA#AUTO-0011")
    @MethodOwner(owner = "Kolchyba Yevhenii")
    public void verifyOpinionsOnPhonePageTest() {
        final String brandName = "Apple";
        LoginService loginService = new LoginService();
        UserCreator userCreator = new UserCreator();
        HomePage homePage = loginService.login(userCreator);
        BrandModelsPage productsPage = homePage.selectBrand(brandName);
        Assert.assertTrue(productsPage.isPageWithBrandPhonesOpened(brandName), "Brand phones page is not opened");
        productsPage.clickPopularityTab();
        ModelInfoPage productInfoPage = productsPage.clickFirstPhone();
        Assert.assertTrue(productInfoPage.isPageWithPhoneOpened(), "Page with phone is not opened");
        OpinionPage opinionPage = productInfoPage.openOpinionsTab();
        Assert.assertTrue(opinionPage.isOpinionsSortedByNewestFirst(), "Newest first are not sorted");
        opinionPage.clickSortByBestRating();
        Assert.assertTrue(opinionPage.IsOpinionsSortedByBestRating(), "Best rating not sorted");
        int ratingBefore = opinionPage.getNumberBeforeRating();
        opinionPage.clickCommentVoteUp();
        int ratingAfter = opinionPage.getNumberAfterRating();
        Assert.assertTrue(ratingBefore < ratingAfter, "Comment is not rated");
        int unRatingAfter = opinionPage.getNumberAfterUnRating();
        opinionPage.clickCommentVoteDown();
        int unRatingBefore = opinionPage.getNumberBeforeUnRating();
        Assert.assertTrue(unRatingAfter > unRatingBefore, "Comment is not unrated");
    }
}
