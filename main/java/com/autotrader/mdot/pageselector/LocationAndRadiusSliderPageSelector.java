package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/21/2015.
 */
public class LocationAndRadiusSliderPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By doneButtonSelector;
    private By keywordInputSelector;
    private By maxPriceInputSelector;
    private By minPriceInputSelector;
    private By zipInputSelector;
    private By locationHeaderSelector;
    private By doneButtonNationalSrpSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new LocationAndRadiusSliderPageSelector object.
     */
    public LocationAndRadiusSliderPageSelector() {
        initLocationAndRadiusSliderPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getDoneButtonSelector() {
        return doneButtonSelector;
    }

    public By getDoneButtonNationalSrpSelector() { return doneButtonNationalSrpSelector; }

    public By getKeywordInputSelector() {
        return keywordInputSelector;
    }

    public By getMaxPriceInputSelector() {
        return maxPriceInputSelector;
    }

    public By getMinPriceInputSelector() {
        return minPriceInputSelector;
    }

    public By getZipInputSelector() {
        return zipInputSelector;
    }

    public By getLocationHeaderSelector() { return locationHeaderSelector; }

    /**
     * TODO: Enter Javadoc
     */
    public void initLocationAndRadiusSliderPageOptions() {
        doneButtonSelector = By.id("hpFilters-locationFilterPanel-j_id_63-j_id_65-j_id_67-j_id_69");
        minPriceInputSelector = By.xpath("//input[contains(@id, 'minPrice')]");
        maxPriceInputSelector = By.xpath("//input[contains(@id, 'maxPrice')]");
        keywordInputSelector = By.xpath("//textarea[contains(@id, 'keywords']");
        zipInputSelector = By.cssSelector("input[id*='filterGeolocation-zip']");
        locationHeaderSelector = By.xpath("//div[contains(text(), 'Location')]");
        doneButtonNationalSrpSelector = By.xpath("//input[@data-qaid='j_id_9c']");
    }
}
