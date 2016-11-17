package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class TimReviewOfferPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By submitButtonSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new TimReviewOfferPageSelector object.
     */
    public TimReviewOfferPageSelector() {
        initTimReviewOfferPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getSubmitButtonSelector() {
        return submitButtonSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initTimReviewOfferPageOptions() {
        submitButtonSelector = By.linkText("Get Instant Cash Offer");
    }
}
