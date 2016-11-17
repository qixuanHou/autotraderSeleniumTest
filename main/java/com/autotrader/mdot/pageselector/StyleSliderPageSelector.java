package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/21/2015.
 */
public class StyleSliderPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By applyButtonSelector;
    private By choiceSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new StyleSliderPageSelector object.
     */
    public StyleSliderPageSelector() {
        initStyleSliderPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getApplyButtonSelector() {
        return applyButtonSelector;
    }

    public By getChoiceSelector() {
        return choiceSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initStyleSliderPageOptions() {
        applyButtonSelector = By.id("hpFilters-styleFilterPanel-j_id_c2-j_id_es-j_id_eu-j_id_ez-j_id_fa");
        choiceSelector =
            By.xpath("//div[@id='hpFilters-styleFilterPanel-j_id_c2-j_id_d7-j_id_d9-vehicleStyleCodes-j_id_dz']/ul/li");
    }
}
