package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/21/2015.
 */
public class YearMakeModelTrimSliderPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By applyButtonSelector = By.xpath("//a[contains(text(), 'Apply')]");
    private By buttonListSelector = By.cssSelector(".atcui-subheader-panel.rightPanel");
    private By carListSelector = By.cssSelector(".atcui-subheader.atcui-primary.atcui-inset");
    private By displayedSelector = By.cssSelector(".atcui-block");
    private By makeAdSelector = By.xpath("//iframe[contains(@id, 'home_2')]");
    private By makeFilterSelector = By.xpath("//div[contains(@id, 'makeFilterPanel')]/ul/li");
    private By modelAdSelector = By.xpath("//iframe[contains(@id, 'home_3')]");
    private By modelFilterSelector = By.xpath("//div[contains(@id, 'modelFilterPanel')]/ul/li");
    private By selectButtonSelector =
        By.cssSelector(".atcui-button.atcui-action.atcui-close-nested-panel.select-action");
    private By selectorListSelector = By.cssSelector(".atcui-list-view-item.atcui-internal-inset");
    private By trimFilterSelector = By.xpath("//div[contains(@id, 'trimFilterPanel')]/ul/li");

    private By yearBeginningInputSelector = By.xpath("//select[contains(@id, 'yearFrom')]");
    private By yearEndingInputSelector = By.xpath("//select[contains(@id, 'yearTo')]");

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new YearMakeModelTrimSliderPageSelector object.
     */
    public YearMakeModelTrimSliderPageSelector() {
        initYearMakeModelTrimSliderPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getApplyButtonSelector() {
        return applyButtonSelector;
    }

    public By getButtonListSelector() {
        return buttonListSelector;
    }

    public By getCarListSelector() {
        return carListSelector;
    }

    public By getDisplayedSelector() {
        return displayedSelector;
    }

    public By getMakeAdSelector() {
        return makeAdSelector;
    }

    public By getMakeFilterSelector() {
        return makeFilterSelector;
    }

    public By getModelAdSelector() {
        return modelAdSelector;
    }

    public By getModelFilterSelector() {
        return modelFilterSelector;
    }

    public By getSelectButtonSelector() {
        return selectButtonSelector;
    }

    public By getSelectorListSelector() {
        return selectorListSelector;
    }

    public By getTrimFilterSelector() {
        return trimFilterSelector;
    }

    public By getYearBeginningInputSelector() {
        return yearBeginningInputSelector;
    }

    public By getYearEndingInputSelector() {
        return yearEndingInputSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initYearMakeModelTrimSliderPageOptions() {
        yearBeginningInputSelector = By.xpath("//select[contains(@id, 'yearFrom')]");
        yearEndingInputSelector = By.xpath("//select[contains(@id, 'yearTo')]");
        selectButtonSelector = By.cssSelector(".atcui-button.atcui-action.atcui-close-nested-panel.select-action");
        applyButtonSelector = By.xpath("//a[contains(text(), 'Apply')]");
        displayedSelector = By.cssSelector(".atcui-block");
        selectorListSelector = By.className("mdot-filterPanelTrigger");
        makeFilterSelector = By.xpath("//div[contains(@id, 'makeFilterPanel')]/ul/li");
        modelFilterSelector = By.xpath("//div[contains(@id, 'modelFilterPanel')]/ul/li");
        trimFilterSelector = By.xpath("//div[contains(@id, 'trimFilterPanel')]/ul/li");
        buttonListSelector = By.cssSelector(".atcui-subheader-panel.rightPanel");
        carListSelector = By.cssSelector(".atcui-subheader.atcui-primary.atcui-inset");
        makeAdSelector = By.xpath("//iframe[contains(@id, 'home_2')]");
        modelAdSelector = By.xpath("//iframe[contains(@id, 'home_3')]");
    }
}
