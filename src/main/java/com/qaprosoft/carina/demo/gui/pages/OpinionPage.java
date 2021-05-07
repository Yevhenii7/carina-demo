package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import groovy.util.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class OpinionPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(OpinionPage.class);

    @FindBy(xpath = "//li[@class='upost']/time")
    private List<ExtendedWebElement> dates;

    @FindBy(xpath = "(//select[@name='nSortNew']//option[text()='Best rating'])[1]")
    private ExtendedWebElement bestRating;

    @FindBy(xpath = "//span[@class='thumbs-score']")
    private List<ExtendedWebElement> ratingScore;

    @FindBy(xpath = "(//span[@class='thumbs-score'])[1]")
    private ExtendedWebElement scoreRating;

    @FindBy(xpath = "(//a[@class='voting-link vote-up'])[1]")
    private ExtendedWebElement commentVoteUp;

    @FindBy(xpath = "(//a[@class='voting-link vote-down'])[1]")
    private ExtendedWebElement commentVoteDown;

    public OpinionPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpinionsSortedByNewestFirst() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
        List<LocalDate> dateList = dates.stream()
                .map(date -> LocalDate.parse(date.toString(), formatter)).collect(Collectors.toList());
//        List<Date> dateList = new ArrayList<>();
//        for (ExtendedWebElement element : dates) {
//            String date = element.getText();
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
//            try {
//                dateList.add(simpleDateFormat.parse(date));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
        for (int j = 0; j < dateList.size() - 1; j++) {
            if (dateList.get(j).compareTo(dateList.get(j + 1)) >= 0) {
                LOGGER.info("Sort by Newest first: [" + dateList.get(j) + "] [" + dateList.get(j + 1) + "]");
            } else if (dateList.get(j).compareTo(dateList.get(j + 1)) < 0) {
                LOGGER.error("Sort is not by Newest first: [" + dateList.get(j) + "] [" + dateList.get(j + 1) + "]");
                return false;
            }
        }
        return true;
    }

    public void clickSortByBestRating() {
        bestRating.click();
        LOGGER.info("Title 'best rating' selected");
    }

    public boolean isOpinionsSortedByBestRating() {
        List<Integer> ratings = ratingScore.stream()
                .map(x -> Integer.valueOf(String.valueOf(x))).collect(Collectors.toList());
//        List<Integer> ratings = new ArrayList<>();
//        for (ExtendedWebElement element : ratingScore) {
//            ratings.add(Integer.parseInt(element.getText()));
//        }
        for (int i = 0; i < ratings.size() - 1; i++) {
            if (ratings.get(i) >= ratings.get(i + 1)) {
                LOGGER.info("Sort by Best rating: [" + ratings.get(i) + "] [" + ratings.get(i + 1) + "]");
            } else if (ratings.get(i) < ratings.get(i + 1)) {
                LOGGER.error("Sort is not by Best rating: [" + ratings.get(i) + "] [" + ratings.get(i + 1) + "]");
                return false;
            }
        }
        return true;
    }

    public void clickCommentVoteUp() {
        commentVoteUp.click();
        LOGGER.info("Comment vote up clicked");
    }

    public void clickCommentVoteDown() {
        commentVoteDown.click();
        LOGGER.info("Comment vote down clicked");
    }

    public int getNumberRating() {
        String ratingNumber = scoreRating.getText();
        LOGGER.info("Rating before " + ratingNumber);
        return Integer.parseInt(ratingNumber);
    }

    public int getNumberUnRating() {
        String unRatingNumber = scoreRating.getText();
        LOGGER.info("Rating before " + unRatingNumber);
        return Integer.parseInt(unRatingNumber);
    }
}
