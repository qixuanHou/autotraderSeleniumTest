package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by mwstratton on 11/23/2015.
 */
public class SpecialOffersPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By specialOffersHeaderSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SpecialOffersPageSelector object.
     */
    public SpecialOffersPageSelector() {
        initSpecialOffersPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getSpecialOffersHeaderSelector() {
        return specialOffersHeaderSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSpecialOffersPageOptions() {
        specialOffersHeaderSelector = By.cssSelector(".atcui-center-panel.atcui-header-item");
    }
}
