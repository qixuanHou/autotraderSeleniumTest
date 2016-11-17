package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class TimVehicleConditionPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By nextButtonSelector;
    private By noMechanicalIssuesSelector;
    private By noMechanicalIssuesValidationSelector;
    private By noSeriousAccidentDamageSelector;
    private By noSeriousAccidentDamageValidationSelector;

    private By noWearAndTearSelector;
    private By noWearAndTearValidationSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new TimVehicleConditionPageSelector object.
     */
    public TimVehicleConditionPageSelector() {
        initTimVehicleConditionPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getNextButtonSelector() {
        return nextButtonSelector;
    }

    public By getNoMechanicalIssuesSelector() {
        return noMechanicalIssuesSelector;
    }

    public By getNoMechanicalIssuesValidationSelector() {
        return noMechanicalIssuesValidationSelector;
    }

    public By getNoSeriousAccidentDamageSelector() {
        return noSeriousAccidentDamageSelector;
    }

    public By getNoSeriousAccidentDamageValidationSelector() {
        return noSeriousAccidentDamageValidationSelector;
    }

    public By getNoWearAndTearSelector() {
        return noWearAndTearSelector;
    }

    public By getNoWearAndTearValidationSelector() {
        return noWearAndTearValidationSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initTimVehicleConditionPageOptions() {
        noWearAndTearSelector = By.xpath(".//label[contains(@for, '2_choices-1')]");
        noMechanicalIssuesSelector = By.xpath(".//label[contains(@for, '3_choices-1')]");
        noSeriousAccidentDamageSelector = By.xpath(".//label[contains(@for, '4_choices-1')]");
        nextButtonSelector = By.xpath("//input[contains(@value, 'Next')]");
        noWearAndTearValidationSelector = By.id("qc_L2_error");
        noMechanicalIssuesValidationSelector = By.id("qc_L3_error");
        noSeriousAccidentDamageValidationSelector = By.id("qc_L4_error");
    }
}
