package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='article-hgroup']/child::h1")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[@class='news-item'][1]/a/h3")
    private ExtendedWebElement articleTitle;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    public String getArticleTitle() {
        return title.getText();
    }
}
