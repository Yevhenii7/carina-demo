/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.gui.pages;

import java.util.List;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.components.PhoneFinderMenu;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.ModelItem;

public class BrandModelsPage extends AbstractPage {

    private static final Logger LOGGER = Logger.getLogger(BrandModelsPage.class);

    @FindBy(xpath = "//div[@id='review-body']//li")
    private List<ModelItem> models;

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement titleBrandName;

    @FindBy(xpath = "//li[@class='article-info-meta-link help help-sort-popularity']")
    private ExtendedWebElement linkPopularity;

    @FindBy(xpath = "//div[@class='makers']/ul/li[1]")
    private ExtendedWebElement linkFirstPhone;

    public BrandModelsPage(WebDriver driver) {
        super(driver);
    }

    public ModelInfoPage selectModel(String modelName) {
        for (ModelItem model : models) {
            if (model.readModel().equalsIgnoreCase(modelName)) {
                return model.openModelPage();
            }
        }
        throw new RuntimeException("Unable to open model: " + modelName);
    }

    public boolean isPageWithBrandPhonesOpened(String brand) {
        LOGGER.info("Title from brand phones page " + titleBrandName.getText());
        return titleBrandName.isElementWithTextPresent(brand + " phones");
    }

    public void clickPopularityTab() {
        linkPopularity.click();
        LOGGER.info("Popularity tab pressed");
    }

    public ModelInfoPage clickFirstPhone() {
        linkFirstPhone.click();
        return new ModelInfoPage(getDriver());
    }
}
