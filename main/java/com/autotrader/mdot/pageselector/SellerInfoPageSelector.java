package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SellerInfoPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By alterTextSelector;
    private By buttonsSelector;
    private By checkOnPageSelector;
    private By emailButtonSelector;
    private By emailDealerButtonSelector;
    private By getDirectionButtonSelector;
    private By navBarSelector;
    private By sellYourCar;
    private By viewInventoryButtonSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SellerInfoPageSelector object.
     */
    public SellerInfoPageSelector() {
        initSellerInfoPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getAlertTextSelector() {
        return alterTextSelector;
    }

    public By getButtonsSelector() {
        return buttonsSelector;
    }

    public By getCheckOnPageSelector() {
        return checkOnPageSelector;
    }

    public By getEmailButtonSelector() {
        return emailButtonSelector;
    }

    public By getEmailDealerButtonSelector() {
        return emailDealerButtonSelector;
    }

    public By getGetDirectionButtonSelector() {
        return getDirectionButtonSelector;
    }

    public By getNavBarSelector() {
        return navBarSelector;
    }

    public By getSellYourCar() {
        return sellYourCar;
    }

    public By getViewInventoryButtonSelector() {
        return viewInventoryButtonSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSellerInfoPageOptions() {
        getDirectionButtonSelector = By.xpath("//a[@data-birf-cmp='mdot_cs_view_map']");
        emailDealerButtonSelector = By.xpath("//a[@data-birf-cmp='mdot_si_dlr_eml_slr']");
        viewInventoryButtonSelector = By.xpath("//a[@data-birf-cmp='mdot_dlr_inv']");
        navBarSelector = By.cssSelector(".atcui-navBarItem");
        checkOnPageSelector = By.cssSelector(".atcui-navBarItem.atcui-active");
        emailButtonSelector = By.className("atcui-button");
        alterTextSelector = By.className("rf-msg-err");
        buttonsSelector = By.className("atcui-button");
        sellYourCar = By.className("mdot-reciprocalLink");
    }
}
