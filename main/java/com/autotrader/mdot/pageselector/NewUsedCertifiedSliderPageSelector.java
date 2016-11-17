package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/21/2015.
 */
public class NewUsedCertifiedSliderPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By anySelector;
    private By applyButtonSelector;
    private By cancelButtonSelector;
    private By certifiedSelector;
    private By clearButtonSelector;
    private By newSelector;
    private By usedSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new NewUsedCertifiedSliderPageSelector object.
     */
    public NewUsedCertifiedSliderPageSelector() {
        initNewUsedCertifiedSliderPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getAnySelector() {
        return anySelector;
    }

    public By getApplyButtonSelector() {
        return applyButtonSelector;
    }

    public By getCancelButtonSelector() {
        return cancelButtonSelector;
    }

    public By getCertifiedSelector() {
        return certifiedSelector;
    }

    public By getClearButtonSelector() {
        return clearButtonSelector;
    }

    public By getNewSelector() {
        return newSelector;
    }

    public By getUsedSelector() {
        return usedSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initNewUsedCertifiedSliderPageOptions() {
        anySelector = By.xpath("//label[contains(@for, 'listingTypes-0')]");
        newSelector = By.xpath("//label[contains(@for, 'listingTypes-1')]");
        usedSelector = By.xpath("//label[contains(@for, 'listingTypes-2')]");
        certifiedSelector = By.xpath("//label[contains(@for, 'listingTypes-3')]");
        applyButtonSelector = By.cssSelector(".atcui-button.atcui-action.atcui-close-panel.update-action-listingType");
        clearButtonSelector = By.cssSelector(".atcui-button.atcui-primary.filters-clear.single-filter");
        cancelButtonSelector = By.cssSelector(".atcui-button.atcui-bordered.atcui-close-panel.atcui-reset");
    }
}
