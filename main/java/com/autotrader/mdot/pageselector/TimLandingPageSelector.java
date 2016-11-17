package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class TimLandingPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By extColorSelector;
    private By exteriorColorValidationSelector;
    private By hamburgerButtonSelector;
    private By intColorSelector;
    private By interiorColorValidationSelector;
    private By learnMoreSelector;
    private By makeSelector;
    private By makeValidationSelector;
    private By mileageSelector;
    private By mileageValidationSelector;
    private By modelSelector;
    private By modelValidationSelector;
    private By nextButtonSelector;
    private By styleSelector;
    private By styleValidationSelector;
    private By yearSelector;
    private By yearValidationSelector;
    private By zipSelector;
    private By zipValidationSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new TimLandingPageSelector object.
     */
    public TimLandingPageSelector() {
        initTimLandingPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getExtColorSelector() {
        return extColorSelector;
    }

    public By getExteriorColorValidationSelector() {
        return exteriorColorValidationSelector;
    }

    public By getHamburgerButtonSelector() {
        return hamburgerButtonSelector;
    }

    public By getIntColorSelector() {
        return intColorSelector;
    }

    public By getInteriorColorValidationSelector() {
        return interiorColorValidationSelector;
    }

    public By getLearnMoreSelector() {
        return learnMoreSelector;
    }

    public By getMakeSelector() {
        return makeSelector;
    }

    public By getMakeValidationSelector() {
        return makeValidationSelector;
    }

    public By getMileageSelector() {
        return mileageSelector;
    }

    public By getMileageValidationSelector() {
        return mileageValidationSelector;
    }

    public By getModelSelector() {
        return modelSelector;
    }

    public By getModelValidationSelector() {
        return modelValidationSelector;
    }

    public By getNextButtonSelector() {
        return nextButtonSelector;
    }

    public By getStyleSelector() {
        return styleSelector;
    }

    public By getStyleValidationSelector() {
        return styleValidationSelector;
    }

    public By getYearSelector() {
        return yearSelector;
    }

    public By getYearValidationSelector() {
        return yearValidationSelector;
    }

    public By getZipSelector() {
        return zipSelector;
    }

    public By getZipValidationSelector() {
        return zipValidationSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initTimLandingPageOptions() {
        yearSelector = By.xpath("//select[contains(@id, 'vehicleYear')]");
        makeSelector = By.xpath("//select[contains(@id, 'vehicleMake')]");
        modelSelector = By.xpath("//select[contains(@id, 'vehicleModel')]");
        styleSelector = By.xpath("//select[contains(@id, 'vehicleStyle')]");
        extColorSelector = By.xpath("//select[contains(@id, 'extColor')]");
        intColorSelector = By.xpath("//select[contains(@id, 'intColor')]");
        mileageSelector = By.xpath("//input[contains(@id, 'mileage')]");
        zipSelector = By.xpath("//input[contains(@id, 'zip')]");
        nextButtonSelector = By.cssSelector("input[data-qaid='next']");
        yearValidationSelector = By.cssSelector(".atcui-form-error:nth-of-type(1)");
        zipValidationSelector = By.cssSelector(".atcui-form-error:nth-of-type(3)");
        makeValidationSelector = By.cssSelector(".atcui-form-error:nth-of-type(1)");
        modelValidationSelector = By.cssSelector(".atcui-form-error:nth-of-type(1)");
        styleValidationSelector = By.cssSelector(".atcui-form-error:nth-of-type(1)");
        exteriorColorValidationSelector = By.cssSelector(".atcui-form-error:nth-of-type(1)");
        interiorColorValidationSelector = By.cssSelector(".atcui-form-error:nth-of-type(1)");
        mileageValidationSelector = By.cssSelector(".atcui-form-error:nth-of-type(1)");
        hamburgerButtonSelector = By.cssSelector("a[data-qaid='qa_global_navigation_menu']");
        learnMoreSelector = By.xpath("//a[contains(text(), 'Learn more')]");
    }
}
