package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PhoneFinderPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(PhoneFinderPage.class);

    @FindBy(xpath = "//h1[@class='article-info-name'][text()='Phone finder']")
    private ExtendedWebElement articlePhoneFinder;

    @FindBy(xpath = "//button[@data-id='sMakers']")
    private ExtendedWebElement dropUpMenu;

    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    private ExtendedWebElement inputBrandField;

    @FindBy(xpath = "(//input[@class='pf-button'])[2]")
    private ExtendedWebElement btnShow;

    @FindBy(xpath = "(//span[@class='pf-results'])[2]")
    private ExtendedWebElement textFromBtnShow;

    public PhoneFinderPage(WebDriver driver) {
        super(driver);
        setPageURL("/search.php3");
    }

    public boolean isArticlePhoneFinderPresent() {
        return articlePhoneFinder.isPresent();
    }

    public void clickDropDownButton() {
        dropUpMenu.click();
        LOGGER.info("Drop down button clicked");
    }

    public void inputModelBrand(String brand) {
        inputBrandField.type(brand);
        inputBrandField.sendKeys(Keys.ENTER);
        LOGGER.info("Model brand selected");
    }

    public boolean isShowBtnPresent() {
        return btnShow.isPresent();
    }

    public String readResultTextFromBtnShow() {
        LOGGER.info("Text from button show: " + textFromBtnShow.getText());
        return textFromBtnShow.getText();
    }

    public PhoneFinderResultPage clickShowButton() {
        btnShow.click();
        LOGGER.info("Show btn pressed");
        return new PhoneFinderResultPage(getDriver());
    }
}
