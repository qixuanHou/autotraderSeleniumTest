package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by mwstratton on 10/20/2015.
 */
public class DealerLocationPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By doneButtonSelector;
    private By radiusListsSelector;
    private By useCurrentLocationSelector;

    private By zipCodeInputSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new DealerLocationPageSelector object.
     */
    public DealerLocationPageSelector() {
        initDealerLocationPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getDoneButtonSelector() {
        return doneButtonSelector;
    }

    public By getRadiusListsSelector() {
        return radiusListsSelector;
    }

    public By getUseCurrentLocationSelector() {
        return useCurrentLocationSelector;
    }

    public By getZipCodeInputSelector() {
        return zipCodeInputSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initDealerLocationPageOptions() {
        zipCodeInputSelector = By.cssSelector(".zipcode");
        doneButtonSelector = By.xpath("//input[@value='DONE']");
        radiusListsSelector = By.xpath("//table[contains(@id, 'searchRadius')]/tbody/tr/td/label");
        useCurrentLocationSelector = By.xpath("//a[contains(text(), 'Use Current Location')]");
    }
}
