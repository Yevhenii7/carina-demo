package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//h3[text()='RedMagic Watch now available globally']")
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

    public String articleFromNewsPage() {
        String oldTab = driver.getWindowHandle();
        driver.switchTo().defaultContent();
        String newWindow = "window.open('about:blank','_blank');";
        ((JavascriptExecutor) driver).executeScript(newWindow);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.get("https://www.gsmarena.com/news.php3");
        String articleFromNewsPage = (articleTitle).getText();
        driver.switchTo().window(oldTab);
        return articleFromNewsPage;
    }
}
