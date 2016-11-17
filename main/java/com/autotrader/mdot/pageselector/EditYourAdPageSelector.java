package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class EditYourAdPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By removeAdButtonSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new EditYourAdPageSelector object.
     */
    public EditYourAdPageSelector() {
        initEditYourAdPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getRemoveAdButtonSelector() {
        return removeAdButtonSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initEditYourAdPageOptions() {
        removeAdButtonSelector = By.id("sellcarManageAd-j_id_n3-j_id_nh");
    }
}
