package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class TimOptionsPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By nextButtonSelector;
    private By noAfterMarketEquipmentValidationSelector;
    private By noAfterMarketEquipSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new TimOptionsPageSelector object.
     */
    public TimOptionsPageSelector() {
        initTimOptionsPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getNextButtonSelector() {
        return nextButtonSelector;
    }

    public By getNoAfterMarketEquipmentValidationSelector() {
        return noAfterMarketEquipmentValidationSelector;
    }

    public By getNoAfterMarketEquipSelector() {
        return noAfterMarketEquipSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initTimOptionsPageOptions() {
        noAfterMarketEquipSelector = By.xpath(".//label[contains(@for, '1_choices-1')]");
        nextButtonSelector = By.xpath("//input[contains(@value, 'Next')]");
        noAfterMarketEquipmentValidationSelector = By.cssSelector(".component-error");
    }
}
