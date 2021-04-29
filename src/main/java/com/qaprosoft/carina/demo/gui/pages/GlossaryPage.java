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
        setPageURL("/glossary.php3");
    }

    public boolean isGlossaryParagraphSizeMatchesListSize() {
        return glossaryLinks.size() == glossaryTitles.size();
    }

    public List<GlossaryLinks> getParagraphLinks() {
        return glossaryLinks;
    }

    public boolean verifyGlossaryParagraphMatchesText() {
        for (int i = 0; i < glossaryLinks.size(); i++) {
            List<String> links = glossaryLinks.get(i).readTitle();
            for (String elements : links) {
                if (!(glossaryTitles.get(i).getText().charAt(0) == (elements.charAt(0)))) {
                    if (!(Character.isDigit(glossaryTitles.get(i).getText().charAt(0))
                            && Character.isDigit(elements.charAt(0)))) {
                        LOGGER.error("Glossary paragraph header: [" + glossaryTitles.get(i).getText().charAt(0) + "] does not matches first number or letter [" + elements.charAt(0) + "]");
                        return false;
                    }
                }
            }
            LOGGER.info("Glossary paragraph header: [" + glossaryTitles.get(i).getText() + "] matches first letter or number");
        }
        return true;
    }

    public boolean verifyGlossaryParagraphTextByAlphabet() {
        for (GlossaryLinks glossaryLink : glossaryLinks) {
            List<String> linkList = glossaryLink.readTitle();
            for (int j = 0; j < linkList.size() - 1; j++) {
                if (linkList.get(j).compareToIgnoreCase(linkList.get(j + 1)) < 0) {
                    LOGGER.info("Glossary paragraph text: [" + linkList.get(j) + "] [" + linkList.get(j + 1) + "] by alphabet!");
                } else if (linkList.get(j).compareToIgnoreCase(linkList.get(j + 1)) > 0) {
                    LOGGER.error("Glossary paragraph text: [" + linkList.get(j) + "] [" + linkList.get(j + 1) + " " + "] is not by alphabet!");
                    return false;
                }
            }
        }
        return true;
    }
}