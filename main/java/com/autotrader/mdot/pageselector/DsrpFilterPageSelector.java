package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/21/2015.
 */
public class DsrpFilterPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By applyButtonSelector;
    private By cancelButtonSelector;
    private By clearAllButtonSelector;
    private By confirmZipMakeKeywordSelector;
    private By inputZipCodeSelector;
    private By keywordInputSelector;
    private By listingCountSelector;
    private By makeListSelector;
    private By radiusListSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new DsrpFilterPageSelector object.
     */
    public DsrpFilterPageSelector() {
        initDsrpFilterPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getApplyButtonSelector() {
        return applyButtonSelector;
    }

    public By getCancelButtonSelector() {
        return cancelButtonSelector;
    }

    public By getClearAllButtonSelector() {
        return clearAllButtonSelector;
    }

    public By getConfirmZipMakeKeywordSelector() {
        return confirmZipMakeKeywordSelector;
    }

    public By getInputZipCodeSelector() {
        return inputZipCodeSelector;
    }

    public By getKeywordInputSelector() {
        return keywordInputSelector;
    }

    public By getListingCountSelector() {
        return listingCountSelector;
    }

    public By getMakeListSelector() {
        return makeListSelector;
    }

    public By getRadiusListSelector() {
        return radiusListSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initDsrpFilterPageOptions() {
        applyButtonSelector =
            By.xpath(
                "//input[@class='atcui-button atcui-action  atcui-close-panel filters-action scrollPanel-footer']");
        keywordInputSelector = By.xpath("//textarea[contains(@id, 'keywords')]");
        inputZipCodeSelector = By.xpath("//input[contains(@id, 'filterGeolocation-zip')]");
        makeListSelector = By.xpath("//table[contains(@id, 'makeCodes')]/tbody/tr/td/label");
        radiusListSelector = By.xpath("//table[contains(@id, 'searchRadius')]/tbody/tr/td/label");
        cancelButtonSelector = By.xpath("//a[@data-rel='close']");
        clearAllButtonSelector = By.xpath("//a[@class='atcui-button atcui-primary   filters-clear']");
        confirmZipMakeKeywordSelector = By.cssSelector(".atcui-expand-header");
        listingCountSelector = By.cssSelector(".atcui-block.listing-count");
    }
}
