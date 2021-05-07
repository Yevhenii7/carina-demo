package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SkipPageBase extends AbstractPage {

    public SkipPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract NoteDescriptionPageBase clickNoteBtn();
}
