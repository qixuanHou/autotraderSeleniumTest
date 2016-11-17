package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SycLandingPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By hamburgerButtonSelector;
    private By placeYourAdButtonSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SycLandingPageSelector object.
     */
    public SycLandingPageSelector() {
        initSycLandingPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getHamburgerButtonSelector() {
        return hamburgerButtonSelector;
    }

    public By getPlaceYourAdButtonSelector() {
        return placeYourAdButtonSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSycLandingPageOptions() {
        placeYourAdButtonSelector = By.xpath("//a[contains(text(), 'Place Your Ad')]");
        hamburgerButtonSelector = By.cssSelector("a[data-qaid='qa_global_navigation_menu']");
    }
}
