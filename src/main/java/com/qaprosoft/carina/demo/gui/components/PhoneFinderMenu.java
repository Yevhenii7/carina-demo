package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.AllBrandPage;
import com.qaprosoft.carina.demo.gui.pages.PhoneFinderPage;
import com.qaprosoft.carina.demo.gui.pages.RumorMillPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PhoneFinderMenu extends AbstractUIObject {

    private static final Logger LOGGER = Logger.getLogger(PhoneFinderMenu.class);

    @FindBy(xpath = "//p[@class='pad'][1]")
    private ExtendedWebElement phoneFinderLink;

    @FindBy(xpath = "//a[@href='apple-phones-48.php']")
    private ExtendedWebElement linkApplePhones;

    @FindBy(xpath = "//a[@class='pad-multiple pad-rumormill']")
    private ExtendedWebElement linkRumorMill;

    @FindBy(xpath = "//a[@class='pad-multiple pad-allbrands']")
    private ExtendedWebElement linkAllBrand;

    public PhoneFinderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public PhoneFinderPage openPhoneFinderPage() {
        phoneFinderLink.click();
        LOGGER.info("Phone finder link pressed");
        return new PhoneFinderPage(getDriver());
    }

    public RumorMillPage openRumorMillPage() {
        linkRumorMill.click();
        LOGGER.info("Link rumor mill pressed");
        linkRumorMill.isElementNotPresent(1);
        return new RumorMillPage(getDriver());
    }

    public AllBrandPage openAllBrandPage() {
        linkAllBrand.click();
        LOGGER.info("Link all brand pressed");
        return new AllBrandPage(getDriver());
    }
}

