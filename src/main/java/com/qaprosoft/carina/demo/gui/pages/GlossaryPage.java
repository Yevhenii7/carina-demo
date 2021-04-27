package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.compare.GlossaryLinks;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GlossaryPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(GlossaryPage.class);

    @FindBy(xpath = "//div[@class='st-text']/h3")
    private List<ExtendedWebElement> glossaryTitles;

    @FindBy(xpath = "//div[@class='st-text']/p")
    private List<GlossaryLinks> glossaryLinks;

    public GlossaryPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleGlossaryPage() {
        LOGGER.info("Title from Glossary page - " + getDriver().getTitle());
        return getDriver().getTitle();
    }

    public List<ExtendedWebElement> getAllLetters() {
        return glossaryTitles;
    }

    public List<GlossaryLinks> getParagraphLinks() {
        return glossaryLinks;
    }

    public boolean verifyTitlesFirstLetter() {
        for (int i = 0; i < glossaryLinks.size(); i++) {
            List<String> links = glossaryLinks.get(i).readTitle();
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
}