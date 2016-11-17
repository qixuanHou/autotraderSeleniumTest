package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SycEnterZipPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By submitZipButtonSelector;
    private By validationErrorMessagesSelector;
    private By zipCodeSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SycEnterZipPageSelector object.
     */
    public SycEnterZipPageSelector() {
        initSycEnterZipPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getSubmitZipButtonSelector() {
        return submitZipButtonSelector;
    }

    public By getValidationErrorMessagesSelector() {
        return validationErrorMessagesSelector;
    }

    public By getZipCodeSelector() {
        return zipCodeSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSycEnterZipPageOptions() {
        zipCodeSelector = By.xpath("//input[contains(@id, 'zip')]");
        submitZipButtonSelector = By.xpath("//input[@type='submit']");
        validationErrorMessagesSelector = By.cssSelector(".rf-msg-err.atcui-form-error");
    }
}
