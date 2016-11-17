package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class RemoveYourAdPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By removeAdListingButtonSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new RemoveYourAdPageSelector object.
     */
    public RemoveYourAdPageSelector() {
        initRemoveYourAdPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getRemoveAdListingButtonSelector() {
        return removeAdListingButtonSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initRemoveYourAdPageOptions() {
        removeAdListingButtonSelector = By.xpath("//a[contains(text(), 'Remove Ad Listing')]");
    }
}
