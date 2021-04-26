package com.qaprosoft.carina.demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.AllBrandsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SliderMenu extends AbstractUIObject {

    @FindBy(xpath = "//i[@class='head-icon icon-mobile-phone231']")
    private ExtendedWebElement allBrandsLink;

    public SliderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AllBrandsPage clickAllBrandsLink() {
        allBrandsLink.click();
        return new AllBrandsPage(getDriver());
    }


}
