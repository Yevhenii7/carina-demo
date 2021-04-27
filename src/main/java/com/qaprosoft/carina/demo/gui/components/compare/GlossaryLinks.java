package com.qaprosoft.carina.demo.gui.components.compare;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.apache.pdfbox.pdfwriter.COSWriterXRefEntry;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class GlossaryLinks extends AbstractUIObject {

    @FindBy(xpath = "./a")
    public List<ExtendedWebElement> titleLinks;

    public GlossaryLinks(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public Set<String> readTitle() {
        Set<String> titles = new TreeSet<>();
        for (ExtendedWebElement element : titleLinks)
            titles.add(element.getText().toUpperCase());
        return titles;
    }
}
