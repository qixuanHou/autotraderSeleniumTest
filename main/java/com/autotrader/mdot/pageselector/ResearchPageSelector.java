package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class ResearchPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By checkPageSelector;
    private By contentSelector;
    private By navBarSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new ResearchPageSelector object.
     */
    public ResearchPageSelector() {
        initResearchPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getCheckPageSelector() {
        return checkPageSelector;
    }

    public By getContentSelector() {
        return contentSelector;
    }

    public By getNavBarSelector() {
        return navBarSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initResearchPageOptions() {
        contentSelector = By.cssSelector(".findcar-articleSummary-wrapper.atcui-inset");
        navBarSelector = By.cssSelector(".atcui-navBarItem");
        checkPageSelector = By.cssSelector(".atcui-navBarItem.atcui-active");
    }
}
