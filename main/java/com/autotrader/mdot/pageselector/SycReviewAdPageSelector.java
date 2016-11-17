package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */

public class SycReviewAdPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By adHeaderSelector;
    private By editOptionalInfoButtonSelector;
    private By editPhotosButtonSelector;
    private By editRequiredInfoButtonSelector;
    private By emailSellerButtonSelector;
    private By nextCheckOutButtonSelector;
    private By nextEnhanceAdButtonSelector;
    private By nextHeaderButtonSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SycReviewAdPageSelector object.
     */
    public SycReviewAdPageSelector() {
        initSycReviewAdPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getAdHeaderSelector() {
        return adHeaderSelector;
    }

    public By getEditOptionalInfoButtonSelector() {
        return editOptionalInfoButtonSelector;
    }

    public By getEditPhotosButtonSelector() {
        return editPhotosButtonSelector;
    }

    public By getEditRequiredInfoButtonSelector() {
        return editRequiredInfoButtonSelector;
    }

    public By getEmailSellerButtonSelector() {
        return emailSellerButtonSelector;
    }

    public By getNextCheckOutButtonSelector() {
        return nextCheckOutButtonSelector;
    }

    public By getNextEnhanceAdButtonSelector() {
        return nextEnhanceAdButtonSelector;
    }

    public By getNextHeaderButtonSelector() {
        return nextHeaderButtonSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSycReviewAdPageOptions() {
        adHeaderSelector = By.cssSelector(".atcui-bold");
        nextCheckOutButtonSelector = By.xpath("//a[contains(text(), 'Next: Checkout')]");
        nextEnhanceAdButtonSelector = By.xpath("//a[contains(text(), 'Next: Enhance Ad')]");
        nextHeaderButtonSelector = By.cssSelector(".atcui-button.atcui-bordered.atcui-highlight");
        editPhotosButtonSelector = By.xpath("//a[contains(text(), 'Edit Photos')]");
        emailSellerButtonSelector = By.xpath("//a[contains(text(), 'E-mail Seller')]");
        editRequiredInfoButtonSelector = By.xpath("//a[contains(text(), 'Edit Required Information')]");
        editOptionalInfoButtonSelector = By.xpath("//a[contains(text(), 'Edit Optional Information')]");
    }
}
