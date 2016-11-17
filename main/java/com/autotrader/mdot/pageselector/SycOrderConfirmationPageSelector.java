package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SycOrderConfirmationPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By choiceSelector;
    private By editYourAdButtonSelector;
    private By searchForYourNextCarButtonSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SycOrderConfirmationPageSelector object.
     */
    public SycOrderConfirmationPageSelector() {
        initSycOrderConfirmationPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getChoiceSelector() {
        return choiceSelector;
    }

    public By getEditYourAdButtonSelector() {
        return editYourAdButtonSelector;
    }

    public By getSearchForYourNextCarButtonSelector() {
        return searchForYourNextCarButtonSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSycOrderConfirmationPageOptions() {
        editYourAdButtonSelector = By.xpath("//a[contains(text(), 'Edit Your Ad')]");
        searchForYourNextCarButtonSelector = By.xpath("//a[contains(text(), 'Search For Your Next Car')]");
        choiceSelector = By.xpath("//div[@class='atcui-content-text atcui-align-left']/strong");
    }
}
