package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.compare.GlossaryLinks;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

public class GlossaryPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(GlossaryPage.class);

    @FindBy(xpath = "//div[@class='st-text']/h3")
    private List<ExtendedWebElement> glossaryTitles;

    @FindBy(xpath = "//div[@class='article-hgroup']/child::h1")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[@class='st-text']/p")
    private List<GlossaryLinks> glossaryLinks;

    public GlossaryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    public boolean isParagraphHeaderSizeAndGlossaryListSizeAreEquals() {
        return glossaryLinks.size() == glossaryTitles.size();
    }

    public List<GlossaryLinks> getParagraphLinks() {
        return glossaryLinks;
    }

    public boolean verifyTitlesFirstLetter() {
        for (int i = 0; i < glossaryLinks.size(); i++) {
            Set<String> links = glossaryLinks.get(i).readTitle();
            for (String elements : links) {
                if (!(elements.charAt(0) == glossaryTitles.get(i).getText().charAt(0))) {
                    if (!(Character.isDigit(elements.charAt(0))
                            && Character.isDigit(glossaryTitles.get(i).getText().charAt(0)))) {
                        return false;
                    }
                }
            }
            LOGGER.info("The first symbol matches the title " + glossaryTitles.get(i).getText());
        }
        return true;
    }

    public boolean verifyGlossaryParagraphTestByAlphabet() {
        for (GlossaryLinks glossaryLinks : glossaryLinks) {
            Set<String> linkList = glossaryLinks.readTitle();
            LOGGER.info(linkList);
            if (!linkList.equals(glossaryLinks.readTitle())) {
                return false;
            }
        }
        return true;
    }
}