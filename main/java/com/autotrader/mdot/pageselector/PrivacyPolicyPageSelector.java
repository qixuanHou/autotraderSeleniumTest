package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class PrivacyPolicyPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By privacyPolicyHeaderSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new PrivacyPolicyPageSelector object.
     */
    public PrivacyPolicyPageSelector() {
        initPrivacyPolicyPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getPrivacyPolicyHeaderSelector() {
        return privacyPolicyHeaderSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initPrivacyPolicyPageOptions() {
        privacyPolicyHeaderSelector = By.cssSelector(".atcui-center-panel.atcui-header-item");
    }
}
