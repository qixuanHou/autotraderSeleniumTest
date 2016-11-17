package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class HomeSidePageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By confirmLogoutButtonSelector;
    private By sideMenuLinksSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new HomeSidePageSelector object.
     */
    public HomeSidePageSelector() {
        initHomeSidePageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getConfirmLogoutButtonSelector() {
        return confirmLogoutButtonSelector;
    }

    public By getSideMenuLinksSelector() {
        return sideMenuLinksSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initHomeSidePageOptions() {
        sideMenuLinksSelector = By.cssSelector(".atcui-content-text.atcui-align-left");
        confirmLogoutButtonSelector = By.xpath("//div[2]/div/a[2]");
    }
}
