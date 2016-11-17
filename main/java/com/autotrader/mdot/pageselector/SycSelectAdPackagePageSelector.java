package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SycSelectAdPackagePageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By selectMOBDeluxeAdSelector;
    private By selectMOBEnhancedAdSelector;

    private By selectMOBPremierAdSelector;
    private By selectMOBStandardAdSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SycSelectAdPackagePageSelector object.
     */
    public SycSelectAdPackagePageSelector() {
        initSycSelectorAdPackagePageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getSelectMOBDeluxeAdSelector() {
        return selectMOBDeluxeAdSelector;
    }

    public By getSelectMOBEnhancedAdSelector() {
        return selectMOBEnhancedAdSelector;
    }

    public By getSelectMOBPremierAdSelector() {
        return selectMOBPremierAdSelector;
    }

    public By getSelectMOBStandardAdSelector() {
        return selectMOBStandardAdSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSycSelectorAdPackagePageOptions() {
        selectMOBPremierAdSelector = By.xpath("//a[contains(text(),'Premier Ad')]");
        selectMOBEnhancedAdSelector = By.xpath("//a[contains(text(),'Enhanced Ad')]");
        selectMOBDeluxeAdSelector = By.xpath("//a[contains(text(),'Deluxe Ad')]");
        selectMOBStandardAdSelector = By.xpath("//a[contains(text(),'Standard Ad')]");
    }
}
