package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AllMenu extends AbstractUIObject {

    @FindBy(id = "menu")
    private ExtendedWebElement allMenu;

    @FindBy(xpath = "//ul[@id='menu']/child::li[1]")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//ul[@id='menu']/child::li[2]")
    private ExtendedWebElement newsLink;

    @FindBy(xpath = "//ul[@id='menu']/child::li[3]")
    private ExtendedWebElement reviewsLink;

    @FindBy(xpath = "//ul[@id='menu']/child::li[4]")
    private ExtendedWebElement videosLink;

    @FindBy(xpath = "//ul[@id='menu']/child::li[5]")
    private ExtendedWebElement featuredLink;

    @FindBy(xpath = "//ul[@id='menu']/child::li[6]")
    private ExtendedWebElement phoneFinderLink;

    @FindBy(xpath = "//ul[@id='menu']/child::li[7]")
    private ExtendedWebElement dealsLink;

    @FindBy(xpath = "//ul[@id='menu']/child::li[8]")
    private ExtendedWebElement toolsLink;

    @FindBy(xpath = "//ul[@id='menu']/child::li[9]")
    private ExtendedWebElement coverageLink;

    @FindBy(xpath = "//ul[@id='menu']/child::li[10]")
    private ExtendedWebElement contactLink;

    public AllMenu(WebDriver driver) {
        super(driver);
    }

    public boolean isAllMenuOpened() {
        return allMenu.isVisible();
    }

    public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(getDriver());
    }

    public NewsPage openNewsPage() {
        newsLink.click();
        return new NewsPage(getDriver());
    }

    public ReviewsPage openReviewsPage() {
        reviewsLink.click();
        return new ReviewsPage(getDriver());
    }

    public VideosPage openVideosPage() {
        videosLink.click();
        return new VideosPage(getDriver());
    }

    public FeaturedPage openFeaturedPage() {
        featuredLink.click();
        return new FeaturedPage(getDriver());
    }

    public PhoneFinderPage openPhoneFinderPage() {
        phoneFinderLink.click();
        return new PhoneFinderPage(getDriver());
    }

    public DealsPage openDealsPage() {
        dealsLink.click();
        return new DealsPage(getDriver());
    }

    public ToolsPage openToolsPage() {
        toolsLink.click();
        return new ToolsPage(getDriver());
    }

    public CoveragePage openCoveragePage() {
        coverageLink.click();
        return new CoveragePage(getDriver());
    }

    public ContactPage openContactPage() {
        contactLink.click();
        return new ContactPage(getDriver());
    }
}
