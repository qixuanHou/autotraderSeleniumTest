package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class TimRetrieveOfferPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By timRetrieveOfferHeaderSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new TimRetrieveOfferPageSelector object.
     */
    public TimRetrieveOfferPageSelector() {
        initTimeRetrieveOfferPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getTimRetrieveOfferHeaderSelector() {
        return timRetrieveOfferHeaderSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initTimeRetrieveOfferPageOptions() {
        timRetrieveOfferHeaderSelector = By.cssSelector(".atcui-center-panel.atcui-header-item");
    }
}
