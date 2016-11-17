package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SycEnhanceYourAdPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By enhancementsSelector;

    private By extendYourRunSelector;
    private By nextCheckoutButtonSelector;
    private By rtsUpsCheckBoxSelector;
    private By thumbnailCheckBoxSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SycEnhanceYourAdPageSelector object.
     */
    public SycEnhanceYourAdPageSelector() {
        initSycEnhanceYourAdPageSelector();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getEnhancementsSelector() {
        return enhancementsSelector;
    }

    public By getExtendYourRunSelector() {
        return extendYourRunSelector;
    }

    public By getNextCheckoutButtonSelector() {
        return nextCheckoutButtonSelector;
    }

    public By getRtsUpsCheckBoxSelector() {
        return rtsUpsCheckBoxSelector;
    }

    public By getThumbnailCheckBoxSelector() {
        return thumbnailCheckBoxSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSycEnhanceYourAdPageSelector() {
        extendYourRunSelector = By.cssSelector(".durationFeature");
        nextCheckoutButtonSelector = By.xpath("//a[contains(text(), 'Next: Checkout')]");
        enhancementsSelector =
            By.cssSelector(".atcui-form-row.atcui-form-row-checkbox.flexWrap-nowrap.direction-right");
        rtsUpsCheckBoxSelector = By.xpath("//label[contains(@for, 'extendDurationSelect')]");
        thumbnailCheckBoxSelector = By.xpath("//label[contains(@for, 'thumbnailSrpSelect')]");
    }
}
