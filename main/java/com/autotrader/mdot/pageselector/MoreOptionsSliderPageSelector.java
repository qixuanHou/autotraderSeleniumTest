package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/21/2015.
 */
public class MoreOptionsSliderPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By applyButtonSelector;
    private By clearButtonSelector;
    private By extColorSelector;
    private By intColorSelector;
    private By maxPriceSelectorSelector;
    private By minPriceSelectorSelector;
    private By selectedLabelSelector;
    private By selectKeywordsSelector;
    private By selectOptionSelector;
    private By selectSubOptionSelector;
    private By vehicleFeatureSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new MoreOptionsSliderPageSelector object.
     */
    public MoreOptionsSliderPageSelector() {
        initMoreOptionSliderPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getApplyButtonSelector() {
        return applyButtonSelector;
    }

    public By getClearButtonSelector() {
        return clearButtonSelector;
    }

    public By getExtColorSelector() {
        return extColorSelector;
    }

    public By getIntColorSelector() {
        return intColorSelector;
    }

    public By getMaxPriceSelectorSelector() {
        return maxPriceSelectorSelector;
    }

    public By getMinPriceSelectorSelector() {
        return minPriceSelectorSelector;
    }

    public By getSelectedLabelSelector() {
        return selectedLabelSelector;
    }

    public By getSelectKeywordsSelector() {
        return selectKeywordsSelector;
    }

    public By getSelectOptionSelector() {
        return selectOptionSelector;
    }

    public By getSelectSubOptionSelector() {
        return selectSubOptionSelector;
    }

    public By getVehicleFeatureSelector() {
        return vehicleFeatureSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initMoreOptionSliderPageOptions() {
        applyButtonSelector = By.cssSelector(".atcui-button.atcui-action.atcui-close-panel.update-action-moreOptions");
        minPriceSelectorSelector = By.xpath("//input[@class='min-price']");
        maxPriceSelectorSelector = By.xpath("//input[@class='max-price']");
        selectKeywordsSelector = By.cssSelector("textarea[id*='keywords']");
        selectedLabelSelector = By.cssSelector(".selectedLabel");
        clearButtonSelector = By.cssSelector(".atcui-button.atcui-primary.filters-clear.multi-filter");
        selectOptionSelector = By.xpath("//div[contains(@class, 'scrollPanel')]/ul/li");
        selectSubOptionSelector = By.xpath("//table[@class='atcui-selectList atcui-inset']/tbody/tr");
        vehicleFeatureSelector = By.xpath("//ul[contains(@id, 'features')]/li/a");
        extColorSelector = By.xpath("//li[contains(@id, 'extColor')]");
        intColorSelector = By.xpath("//li[contains(@id, 'interiorColorsSimple')]");
    }
}
