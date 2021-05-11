package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class RumorMillPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(HomePage.class);

    @FindBy(xpath = "//td[@headers='th3c']")
    private List<ExtendedWebElement> scores;


    public RumorMillPage(WebDriver driver) {
        super(driver);
        setPageURL("/rumored.php3");
    }

    public boolean isTop10DevicesSorted() {
        List<Integer> listScores = new ArrayList<>();
        for (ExtendedWebElement element : scores) {
            listScores.add(Integer.parseInt(element.getText().replaceAll(",", "")));
        }
        for (int i = 0; i < listScores.size() - 1; i++) {
            if (listScores.get(i) > listScores.get(i + 1)) {
                LOGGER.info("Top 10 devices sorted" + "[" + listScores.get(i) + "] [" + listScores.get(i + 1) + "]");
            } else if (listScores.get(i) < listScores.get(i + 1)) {
                LOGGER.error("Top 10 devices are not sorted" + "[" + listScores.get(i) + "] [" + listScores.get(i + 1) + "]");
                return false;
            }
        }
        return true;
    }

}
