package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ModelItem;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PhoneFinderResultPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(PhoneFinderResultPage.class);

    @FindBy(xpath = "//h1[@class='article-info-name'][text()='Phone finder results']")
    private ExtendedWebElement searchPhoneFinderResults;

    @FindBy(xpath = "(//div[@class='st-text']/p)[1]")
    private ExtendedWebElement textSearchResult;

    @FindBy(xpath = "//div[@class='st-text'][1]/p/a")
    private ExtendedWebElement linkClickHere;

    @FindBy(xpath = "(//div[@class='st-text']/p)[2]/a")
    private ExtendedWebElement linkHere;

    @FindBy(xpath = "//div[@id='review-body']/div/ul/li")
    private List<ModelItem> modelItemList;

    public PhoneFinderResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return searchPhoneFinderResults.isPresent();
    }

    public String readSearchResult() {
        LOGGER.info("Text from search result - " + textSearchResult.getText());
        return textSearchResult.getText();
    }

    public boolean isClickHereLinkPresent() {
        return linkClickHere.isPresent();
    }

    public boolean isHereLinkPresent() {
        return linkHere.isPresent();
    }

    public List<ModelItem> readModelItemList() {
        return modelItemList;
    }

    public void clickLinkClickHere() {
        linkClickHere.click();
        LOGGER.info("Link 'ClickHere' pressed");
    }
}
