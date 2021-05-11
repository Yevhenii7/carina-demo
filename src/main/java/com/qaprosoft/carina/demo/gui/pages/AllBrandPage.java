package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AllBrandPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(PhoneFinderResultPage.class);

    @FindBy(xpath = "//div[@class='st-text']//a")
    private List<ExtendedWebElement> mobileBrands;

    public AllBrandPage(WebDriver driver) {
        super(driver);
        setPageURL("/makers.php3");
    }

    public boolean isAllMobileBrandsByAlphabet() {
        List<String> brands = new ArrayList<>();
        for (ExtendedWebElement element : mobileBrands) {
            brands.add(element.getText().toUpperCase());
        }
        for (int j = 0; j < brands.size() - 1; j++) {
            if (brands.get(j).compareToIgnoreCase(brands.get(j + 1)) < 0) {
                LOGGER.info("Brands text by alphabet: [" + brands.get(j) + "] [" + brands.get(j + 1) + "]");
            } else if (brands.get(j).compareToIgnoreCase(brands.get(j + 1)) > 0) {
                LOGGER.error("Brands text by alphabet: [" + brands.get(j) + "] [" + brands.get(j + 1) + "]");
                return false;
            }
        }
        return true;
    }
}
