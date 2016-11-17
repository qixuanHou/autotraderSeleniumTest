package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class AdRemovedPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By homeButtonSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new AdRemovedPageSelector object.
     */
    public AdRemovedPageSelector() {
        initAdRemovedPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getHomeButtonSelector() {
        return homeButtonSelector;
    }

    public void initAdRemovedPageOptions() {
        homeButtonSelector = By.xpath("//a[@href='/index.xhtml']");
    }
}
