package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AllBrandsPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement articleTitle;

    @FindBy(xpath = "//a[@href='apple-phones-48.php']/child::br")
    private ExtendedWebElement linkApple;

    public AllBrandsPage(WebDriver driver) {
        super(driver);
    }

    public String getArticleTitle() {
        assertElementPresent(articleTitle);
        LOGGER.info(articleTitle.getText());
        return articleTitle.getText();
    }

    public ApplePage clickAppleLink() {
        linkApple.click();
        return new ApplePage(getDriver());
    }
}
