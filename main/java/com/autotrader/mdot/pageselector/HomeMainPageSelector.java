package com.autotrader.mdot.pageselector;

import javax.swing.*;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class HomeMainPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By confirmLogoutButtonSelector;
    private By FYCFilterLabelListSelector;
    private By hamburgerButtonSelector;
    private By headerSelector;
    private By homeHeaderAdSelector;
    private By imageSelector;
    private By privacyPolicyLinkSelector;
    private By searchForCarsButtonSelector;
    private By sellYourVehicleButtonSelector;
    private By signInButtonBottomSelector;
    private By signInButtonTopRightSelector;
    private By sliderSelector;

    private By tradeYourVehicleSelector;
    private By vehicleButtonsSelector;
    private By viewAllDealersButtonSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new HomeMainPageSelector object.
     */
    public HomeMainPageSelector() {
        initHomeMainPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getConfirmLogoutButtonSelector() {
        return confirmLogoutButtonSelector;
    }

    public By getFYCFilterLabelListSelector() {
        return FYCFilterLabelListSelector;
    }

    public By getHamburgerButtonSelector() {
        return hamburgerButtonSelector;
    }

    public By getHeaderSelector() {
        return headerSelector;
    }

    public By getHomeHeaderAdSelector() {
        return homeHeaderAdSelector;
    }

    public By getImageSelector() {
        return imageSelector;
    }

    public By getPrivacyPolicyLinkSelector() {
        return privacyPolicyLinkSelector;
    }

    public By getSearchForCarsButtonSelector() {
        return searchForCarsButtonSelector;
    }

    public By getSellYourVehicleButtonSelector() {
        return sellYourVehicleButtonSelector;
    }

    public By getSignInButtonBottomSelector() {
        return signInButtonBottomSelector;
    }

    public By getSignInButtonTopRightSelector() {
        return signInButtonTopRightSelector;
    }

    public By getSliderSelector() {
        return sliderSelector;
    }

    public By getTradeYourVehicleSelector() {
        return tradeYourVehicleSelector;
    }

    public By getVehicleButtonsSelector() {
        return vehicleButtonsSelector;
    }

    public By getViewAllDealersButtonSelector() {
        return viewAllDealersButtonSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initHomeMainPageOptions() {
        hamburgerButtonSelector = By.cssSelector("a[data-qaid='qa_global_navigation_menu']");
        imageSelector = By.cssSelector("img[alt='Autotrader.com']");
        signInButtonTopRightSelector = By.xpath("//a[@data-qaid='QA_HP_SignIn']");
        searchForCarsButtonSelector = By.xpath("//a[contains(text(),'Search for Cars')]");
        confirmLogoutButtonSelector = By.xpath("//div[2]/div/a[2]");
        signInButtonBottomSelector = By.xpath("//a[contains(text(),'Sign In Now')]");
        homeHeaderAdSelector = By.xpath("//iframe[contains(@id, 'google_ads_iframe')]");
        viewAllDealersButtonSelector = By.xpath("//a[contains(text(), 'View All Dealers')]");
        privacyPolicyLinkSelector = By.xpath("//a[contains(text(),'Privacy Policy')]");
        headerSelector = By.cssSelector(".atcui-title.atcui-internal-inset");
        FYCFilterLabelListSelector = By.cssSelector(".atcui-block");
        sliderSelector = By.cssSelector(".atcui-list-view-item.atcui-internal-inset");
        vehicleButtonsSelector = By.cssSelector(".atcui-flexboxItem");
        tradeYourVehicleSelector = By.xpath("//span[contains(text(), 'Trade Your')]");
        sellYourVehicleButtonSelector = By.xpath("//span[contains(text(), 'Sell Your')]");
    }
}
