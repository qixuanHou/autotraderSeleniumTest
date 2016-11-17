package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class FraudAwarenessPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By fraudAwarenessHeaderSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new FraudAwarenessPageSelector object.
     */
    public FraudAwarenessPageSelector() {
        initFraudAwarenessPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getFraudAwarenessHeaderSelector() {
        return fraudAwarenessHeaderSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initFraudAwarenessPageOptions() {
        fraudAwarenessHeaderSelector = By.cssSelector(".atcui-center-panel.atcui-header-item");
    }
}
