package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BurgerMenu extends AbstractUIObject {

    private static final Logger LOGGER = Logger.getLogger(BurgerMenu.class);

    @FindBy(id = "menu")
    private ExtendedWebElement burgerMenu;

    @FindBy(xpath = "//ul[@id='menu']/li/a[text()='Home']")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//ul[@id='menu']/li/a[text()='News']")
    private ExtendedWebElement newsLink;

    @FindBy(xpath = "//ul[@id='menu']/li/a[text()='Reviews']")
    private ExtendedWebElement reviewsLink;

    @FindBy(xpath = "//a[text()='Videos'][1]")
    private ExtendedWebElement videosLink;

    @FindBy(xpath = "//ul[@id='menu']/li/a[text()='Featured']")
    private ExtendedWebElement featuredLink;

    @FindBy(xpath = "//ul[@id='menu']/li/a[text()='Phone Finder']")
    private ExtendedWebElement phoneFinderLink;

    @FindBy(xpath = "//a[text()='Deals'][1]")
    private ExtendedWebElement dealsLink;

    @FindBy(xpath = "//a[text()='Tools'][1]")
    private ExtendedWebElement toolsLink;

    @FindBy(xpath = "//ul[@id='menu']/li/a[text()='Coverage']")
    private ExtendedWebElement coverageLink;

    @FindBy(xpath = "//a[text()='Contact'][1]")
    private ExtendedWebElement contactLink;

    public BurgerMenu(WebDriver driver) {
        super(driver);
    }

    public boolean isBurgerMenuVisible() {
        return burgerMenu.isVisible();
    }

    public HomePage openHomePage() {
        homeLink.click();
        LOGGER.info("Home link pressed");
        return new HomePage(getDriver());
    }

    public NewsPage openNewsPage() {
        newsLink.click();
        LOGGER.info("News link pressed");
        return new NewsPage(getDriver());
    }

    public ReviewsPage openReviewsPage() {
        reviewsLink.click();
        LOGGER.info("Reviews link pressed");
        return new ReviewsPage(getDriver());
    }

    public VideosPage openVideosPage() {
        videosLink.click();
        LOGGER.info("Videos link pressed");
        return new VideosPage(getDriver());
    }

    public FeaturedPage openFeaturedPage() {
        featuredLink.click();
        LOGGER.info("Featured link pressed");
        return new FeaturedPage(getDriver());
    }

    public PhoneFinderPage openPhoneFinderPage() {
        phoneFinderLink.click();
        LOGGER.info("Phone finder link pressed");
        return new PhoneFinderPage(getDriver());
    }

    public DealsPage openDealsPage() {
        dealsLink.click();
        LOGGER.info("Deals link pressed");
        return new DealsPage(getDriver());
    }

    public ToolsPage openToolsPage() {
        toolsLink.click();
        LOGGER.info("Tools link pressed");
        return new ToolsPage(getDriver());
    }

    public CoveragePage openCoveragePage() {
        coverageLink.click();
        LOGGER.info("Coverage link pressed");
        return new CoveragePage(getDriver());
    }

    public ContactPage openContactPage() {
        contactLink.click();
        LOGGER.info("Contact link pressed");
        return new ContactPage(getDriver());
    }
}
