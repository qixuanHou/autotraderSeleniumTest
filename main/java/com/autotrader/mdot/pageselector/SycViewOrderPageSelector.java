package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SycViewOrderPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By reviewYourOrderBannerSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SycViewOrderPageSelector object.
     */
    public SycViewOrderPageSelector() {
        initSycViewOrderPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getReviewYourOrderBannerSelector() {
        return reviewYourOrderBannerSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSycViewOrderPageOptions() {
        reviewYourOrderBannerSelector = By.cssSelector(".atcui-title.atcui-internal-inset");
    }
}
