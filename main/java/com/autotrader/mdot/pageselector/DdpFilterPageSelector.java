package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by mwstratton on 10/20/2015.
 */
public class DdpFilterPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By applyButtonSelector;
    private By clearAllButtonSelector;

    private By makeFilterSelector;
    private By makeModelTrimSelector;
    private By maxPriceSelector;
    private By minPriceSelector;
    private By modelFilterSelector;
    private By optionsSelector;
    private By selectButtonsSelector;
    private By subOptionsSelector;
    private By trimFilterSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new DdpFilterPageSelector object.
     */
    public DdpFilterPageSelector() {
        initDdpFilterPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getApplyButtonSelector() {
        return applyButtonSelector;
    }

    public By getClearAllButtonSelector() {
        return clearAllButtonSelector;
    }

    public By getMakeFilterSelector() {
        return makeFilterSelector;
    }

    public By getMakeModelTrimSelector() {
        return makeModelTrimSelector;
    }

    public By getMaxPriceSelector() {
        return maxPriceSelector;
    }

    public By getMinPriceSelector() {
        return minPriceSelector;
    }

    public By getModelFilterSelector() {
        return modelFilterSelector;
    }

    public By getOptionsSelector() {
        return optionsSelector;
    }

    public By getSelectButtonsSelector() {
        return selectButtonsSelector;
    }

    public By getSubOptionsSelector() {
        return subOptionsSelector;
    }

    public By getTrimFilterSelector() {
        return trimFilterSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initDdpFilterPageOptions() {
        makeFilterSelector = By.xpath("//div[contains(@id, 'makeFilterPanel')]/ul/li");
        modelFilterSelector = By.xpath("//div[contains(@id, 'modelFilterPanel')]/ul/li");
        trimFilterSelector = By.xpath("//div[contains(@id, 'trimFilterPanel')]/ul/li");
        applyButtonSelector =
            By.cssSelector(".atcui-button.atcui-action.atcui-close-panel.filters-action.scrollPanel-footer");
        clearAllButtonSelector = By.xpath("//a[contains(text(),'Clear All')]");
        minPriceSelector = By.xpath("//input[contains(@id, 'minPrice')]");
        maxPriceSelector = By.xpath("//input[contains(@id, 'maxPrice')]");
        selectButtonsSelector = By.cssSelector(".atcui-button.atcui-action.atcui-close-nested-panel.select-action");
        optionsSelector = By.cssSelector(".atcui-expand.atcui-expand-close");
        subOptionsSelector = By.xpath("//table[@class='atcui-selectList atcui-inset']/tbody/tr");
        makeModelTrimSelector = By.cssSelector(".mdot-filterPanelTrigger");
    }
}
