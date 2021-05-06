package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.PhoneFinderPage;
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

    public PhoneFinderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public PhoneFinderPage openPhoneFinderPage() {
        phoneFinderLink.click();
        LOGGER.info("Phone finder link pressed");
        return new PhoneFinderPage(getDriver());
    }
}
