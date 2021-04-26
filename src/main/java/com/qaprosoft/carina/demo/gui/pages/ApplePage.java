package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ApplePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement articleTitle;

    @FindBy(xpath = "//i[@class='head-icon icon-compare']")
    private ExtendedWebElement iconCompare;

    public ApplePage(WebDriver driver) {
        super(driver);
    }

    public String getArticleTitle() {
        LOGGER.info(articleTitle.getText());
        return articleTitle.getText();
    }

    public void clickIconCompare() {
        iconCompare.click();
    }

    public void selectModels(String... elements) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        for (String element : elements) {
            js.executeScript("document.querySelectorAll('.makers.compare-mode ul li')[" + element + "].className = 'checked'");
        }
    }

    public CompareModelsPage clickIcon() {
        iconCompare.click();
        return new CompareModelsPage(getDriver());
    }
}
