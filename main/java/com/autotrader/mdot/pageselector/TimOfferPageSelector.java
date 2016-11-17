package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class TimOfferPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By imageIdentifierSelector;
    private By instantCashOfferBannerSelector;
    private By congratulationsMessageSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new TimOfferPageSelector object.
     */
    public TimOfferPageSelector() {
        initTimOfferPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getImageIdentifierSelector() {
        return imageIdentifierSelector;
    }

    public By getInstantCashOfferBannerSelector() { return instantCashOfferBannerSelector; }

    public By getCongratulationsMessageSelector() { return congratulationsMessageSelector; }

    /**
     * TODO: Enter Javadoc
     */
    public void initTimOfferPageOptions() {
        imageIdentifierSelector = By.xpath("//img[contains(@src, '/resources/img/tim/offer/ICO_Logo.jpg')]");
        instantCashOfferBannerSelector = By.xpath("//div[contains(text(), 'INSTANT CASH OFFER')]");
        congratulationsMessageSelector = By.xpath("//span[contains(text(), 'Congratulations!')]");
    }
}
