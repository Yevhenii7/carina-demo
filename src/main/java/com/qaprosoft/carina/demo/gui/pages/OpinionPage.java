package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class OpinionPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(OpinionPage.class);

    @FindBy(xpath = "//li[@class='upost']/time")
    private List<ExtendedWebElement> dates;

    @FindBy(xpath = "(//select[@name='nSortNew']//option[text()='Best rating'])[1]")
    private ExtendedWebElement bestRating;

    @FindBy(xpath = "//span[@class='thumbs-score']")
    private List<ExtendedWebElement> ratingScore;

    @FindBy(xpath = "//a[@class='voting-link vote-up']")
    private List<ExtendedWebElement> commentVoteUp;

    @FindBy(xpath = "//a[@class='voting-link vote-down']")
    private List<ExtendedWebElement> commentVoteDown;

    public OpinionPage(WebDriver driver) {
        super(driver);
    }

    public boolean sortByNewestFirst() {
        List<Date> dateList = new ArrayList<>();
        for (ExtendedWebElement element : dates) {
            String date = element.getText();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
            try {
                Date allDate = simpleDateFormat.parse(date);
                dateList.add(allDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
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

    public boolean sortByBestRating() {
        List<Integer> ratings = new ArrayList<>();
        for (ExtendedWebElement element : ratingScore) {
            String ratingNumbers = element.getText();
            int allRatingNumbers = Integer.parseInt(ratingNumbers);
            ratings.add(allRatingNumbers);
        }
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

    public boolean isCommentRated() {
        List<String> listBeforeRatings = new ArrayList<>();
        List<String> listAfterRatings = new ArrayList<>();
        for (ExtendedWebElement element : ratingScore) {
            String ratingBefore = element.getText();
            listBeforeRatings.add(ratingBefore);
        }
        int beforeRating = Integer.parseInt(listBeforeRatings.get(0));
        for (int i = 0; i < commentVoteUp.size(); i++) {
            commentVoteUp.get(0).click();
        }
        for (ExtendedWebElement element : ratingScore) {
            String ratingAfter = element.getText();
            listAfterRatings.add(ratingAfter);
        }
        int afterRating = Integer.parseInt(listAfterRatings.get(0));
        if (beforeRating < afterRating) {
            LOGGER.info("Comment is rated : [" + beforeRating + "]" + " before rating " + "[" + afterRating + "]" + " after rating");
        } else if (beforeRating > afterRating) {
            LOGGER.error("Comment is not rated: [" + beforeRating + "]" + " before rating " + "[" + afterRating + "]" + " after rating");
            return false;
        }
        return true;
    }

    public boolean isCommentUnrated() {
        List<String> listBeforeRatings = new ArrayList<>();
        List<String> listAfterRatings = new ArrayList<>();
        for (ExtendedWebElement element : ratingScore) {
            String ratingBefore = element.getText();
            listBeforeRatings.add(ratingBefore);
        }
        int beforeRating = Integer.parseInt(listBeforeRatings.get(0));
        for (int i = 0; i < commentVoteDown.size(); i++) {
            commentVoteDown.get(0).click();
        }
        for (ExtendedWebElement element : ratingScore) {
            String ratingAfter = element.getText();
            listAfterRatings.add(ratingAfter);
        }
        int afterRating = Integer.parseInt(listAfterRatings.get(0));
        if (beforeRating > afterRating) {
            LOGGER.info("Comment is unrated : [" + beforeRating + "]" + " before rating " + "[" + afterRating + "]" + " after rating");
        } else if (beforeRating < afterRating) {
            LOGGER.error("Comment is not unrated: [" + beforeRating + "]" + " before rating " + "[" + afterRating + "]" + " after rating");
            return false;
        }
        return true;
    }
}
