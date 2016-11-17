package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/21/2015.
 */
public class FiltersSliderPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By applyButtonSelector;
    private By clearAllButtonSelector;
    private By filterSelector;
    private By makeFilterSelector;
    private By maxPriceSelectorSelector;
    private By minPriceSelectorSelector;
    private By modelFilterSelector;
    private By optionHeaderSelector;
    private By resultsFoundSelector;
    private By selectButtonsSelector;
    private By selectedSelector;
    private By selectOptionSelector;
    private By selectSubOptionSelector;
    private By trimFilterSelector;
    private By vehicleFeatureSelector;
    private By yearFromSelector;
    private By yearToSelector;
    private By stylesSelector;
    private By exteriorColorSelector;
    private By interiorColorSelector;
    private By keywordInputSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new FiltersSliderPageSelector object.
     */
    public FiltersSliderPageSelector() {
        initFilterSliderPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getKeywordInputSelector() { return keywordInputSelector; }

    public By getExteriorColorSelector() { return exteriorColorSelector; }

    public By getStylesSelector() { return stylesSelector; }

    public By getApplyButtonSelector() {
        return applyButtonSelector;
    }

    public By getClearAllButtonSelector() {
        return clearAllButtonSelector;
    }

    public By getFilterSelector() {
        return filterSelector;
    }

    public By getMakeFilterSelector() {
        return makeFilterSelector;
    }

    public By getMaxPriceSelectorSelector() {
        return maxPriceSelectorSelector;
    }

    public By getMinPriceSelectorSelector() {
        return minPriceSelectorSelector;
    }

    public By getModelFilterSelector() {
        return modelFilterSelector;
    }

    public By getOptionHeaderSelector() {
        return optionHeaderSelector;
    }

    public By getResultsFoundSelector() {
        return resultsFoundSelector;
    }

    public By getSelectButtonsSelector() {
        return selectButtonsSelector;
    }

    public By getSelectedSelector() {
        return selectedSelector;
    }

    public By getSelectOptionSelector() {
        return selectOptionSelector;
    }

    public By getSelectSubOptionSelector() {
        return selectSubOptionSelector;
    }

    public By getTrimFilterSelector() {
        return trimFilterSelector;
    }

    public By getVehicleFeatureSelector() {
        return vehicleFeatureSelector;
    }

    public By getYearFromSelector() {
        return yearFromSelector;
    }

    public By getYearToSelector() {
        return yearToSelector;
    }

    public By getInteriorColorSelector() { return interiorColorSelector; }

    /**
     * TODO: Enter Javadoc
     */
    public void initFilterSliderPageOptions() {
        makeFilterSelector = By.xpath("//div[contains(@id, 'makeFilterPanel')]/ul/li");
        modelFilterSelector = By.xpath("//div[contains(@id, 'modelFilterPanel')]/ul/li");
        trimFilterSelector = By.xpath("//div[contains(@id, 'trimFilterPanel')]/ul/li");
        applyButtonSelector =
            By.cssSelector(".atcui-button.atcui-action.atcui-close-panel.filters-action.scrollPanel-footer");
        clearAllButtonSelector = By.xpath("//a[contains(text(),'Clear All')]");
        minPriceSelectorSelector = By.xpath("//input[contains(@id, 'minPrice')]");
        maxPriceSelectorSelector = By.xpath("//input[contains(@id, 'maxPrice')]");
        selectedSelector = By.cssSelector(".selectedLabel");
        selectButtonsSelector = By.cssSelector(".atcui-button.atcui-action.atcui-close-nested-panel.select-action");
        yearFromSelector = By.xpath("//select[contains(@id, 'yearFrom')]");
        yearToSelector = By.xpath("//select[contains(@id, 'yearTo')]");
        selectOptionSelector = By.xpath("//div[@class='atcui-scrollPanel-wrapper']/ul/li");
        selectSubOptionSelector = By.xpath("//table[@class='atcui-selectList atcui-inset']/tbody/tr");
        filterSelector = By.cssSelector(".mdot-filterPanelTrigger");
        vehicleFeatureSelector = By.xpath("//li[contains(@id, 'features')]");
        optionHeaderSelector = By.cssSelector(".atcui-expand-header");
        resultsFoundSelector = By.cssSelector(".atcui-block.listing-count");
        stylesSelector = By.xpath("//li[contains(@id, 'vehicleStyleCodes')]");
        exteriorColorSelector = By.xpath("//li[contains(@id, 'extColor')]");
        interiorColorSelector = By.xpath("//li[contains(@id, 'interiorColorsSimple')]");
        keywordInputSelector = By.xpath("//textarea[contains(@id, 'keywords')]");

    }
}
