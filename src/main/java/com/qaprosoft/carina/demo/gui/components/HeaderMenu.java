package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderMenu extends AbstractUIObject {

    private static final Logger LOGGER = Logger.getLogger(HeaderMenu.class);

    @FindBy(css = ".lines-button.minus")
    private ExtendedWebElement burgerMenu;

    @FindBy(id = "logo")
    private ExtendedWebElement logo;

    @FindBy(id = "topsearch-text")
    private ExtendedWebElement topSearch;

    @FindBy(css = ".tip-icon")
    private ExtendedWebElement tipUsIcon;

    @FindBy(css = ".head-icon.icon-soc-fb2")
    private ExtendedWebElement faceBookIcon;

    @FindBy(css = ".head-icon.icon-soc-twitter2")
    private ExtendedWebElement twitterIcon;

    @FindBy(css = ".head-icon.icon-instagram")
    private ExtendedWebElement instagramIcon;

    @FindBy(css = ".head-icon.icon-soc-youtube")
    private ExtendedWebElement youtubeIcon;

    @FindBy(css = ".head-icon.icon-soc-rss2")
    private ExtendedWebElement rssIcon;

    @FindBy(css = ".head-icon.icon-login")
    private ExtendedWebElement loginIcon;

    @FindBy(css = ".head-icon.icon-user-plus")
    private ExtendedWebElement userIcon;

    @FindBy(css = ".head-icon.icon-login")
    private ExtendedWebElement iconLogin;

    @FindBy(xpath = "//a[@id='login-active']/span[@class='icon-count'][text()='test.user']")
    private ExtendedWebElement userName;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public BurgerMenu clickBurgerMenu() {
        burgerMenu.click();
        LOGGER.info("Burger button pressed");
        return new BurgerMenu(driver);
    }

    public boolean isBurgerMenuPresent() {
        return burgerMenu.isPresent();
    }

    public boolean isLogoPresent() {
        return logo.isElementPresent();
    }

    public boolean isTopSearch() {
        return topSearch.isElementPresent();
    }

    public boolean isTipUsIconPresent() {
        return tipUsIcon.isElementPresent();
    }

    public boolean isFaceBookIconPresent() {
        return faceBookIcon.isElementPresent();
    }

    public boolean isTwitterIconPresent() {
        return twitterIcon.isElementPresent();
    }

    public boolean isInstagramIconPresent() {
        return instagramIcon.isElementPresent();
    }

    public boolean isYoutubeIconPresent() {
        return youtubeIcon.isElementPresent();
    }

    public boolean isRssIconPresent() {
        return rssIcon.isElementPresent();
    }

    public boolean isLoginIconPresent() {
        return loginIcon.isElementPresent();
    }

    public boolean isUserIconPresent() {
        return userIcon.isElementPresent();
    }

    public LoginForm openLoginForm() {
        iconLogin.click();
        return new LoginForm(driver);
    }

    public String getUserNickname() {
        waitUntil(ExpectedConditions.presenceOfElementLocated(userName.getBy()), 10);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        LOGGER.info(js.executeScript("return document.querySelectorAll('.icon-count',':before')[6].textContent"));
        return (String) js.executeScript("return document.querySelectorAll('.icon-count',':before')[6].textContent");
    }
}
