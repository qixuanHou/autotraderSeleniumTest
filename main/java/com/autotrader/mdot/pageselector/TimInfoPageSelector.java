package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by mwstratton on 10/23/2015.
 */
public class TimInfoPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By informationBoxTitleSelector;

    private By informationBulletPointsSelector;
    private By informationHeaderSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new TimInfoPageSelector object.
     */
    public TimInfoPageSelector() {
        initTimInfoPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getInformationBoxTitleSelector() {
        return informationBoxTitleSelector;
    }

    public By getInformationBulletPoints() {
        return informationBulletPointsSelector;
    }

    public By getInformationHeaderSelector() {
        return informationHeaderSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initTimInfoPageOptions() {
        informationBulletPointsSelector = By.cssSelector(".atcui-list-item");
        informationHeaderSelector = By.cssSelector(".atcui-section-title");
        informationBoxTitleSelector = By.cssSelector(".atcui-title.atcui-internal-inset");
    }
}
