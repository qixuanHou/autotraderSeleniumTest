package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class VehicleDetailsPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By calculatePaymentSelector;
    private By contactDealerButtonSelector;
    private By cpoTileSelector;
    private By dealerAddressSelector;
    private By directionLineSelector;
    private By emailDealerButtonSelector;
    private By hamburgerButtonSelector;
    private By milesLineSelector;
    private By navBarSelector;
    private By pageHeadingSelector;
    private By phoneNumberLineSelector;
    private By savedListingStarSelector;
    private By unSavedListingStarSelector;
    private By vdpAdSelector;
    private By vdpImageSelector;
    private By vehicleListSelector;
    private By vehiclePriceSelector;
    private By warrantyCPOTileSelector;
    private By warrantyDetailSelector;
    private By warrantyLinkSelector;
    private By warrantySectionSelector;
    private By websiteLineSelector;
    private By vehicleFeaturesSelector;
    private By exteriorColorListedSelector;
    private By interiorColorListedSelector;
    private By fuelTypeListedSelector;
    private By transmissionListedSelector;
    private By doorsListedSelector;
    private By engineListedSelector;
    private By driveTypeListedSelector;
    private By vinListedSelector;
    private By stockNumberListedSelector;
    private By carIdListedSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new VehicleDetailsPageSelector object.
     */
    public VehicleDetailsPageSelector() {
        initVehicleDetailsPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getExteriorColorListedSelector() { return exteriorColorListedSelector; }

    public By getInteriorColorListedSelector() { return interiorColorListedSelector; }

    public By getFuelTypeListedSelector() { return fuelTypeListedSelector; }

    public By getTransmissionListedSelector() { return transmissionListedSelector; }

    public By getDoorsListedSelector() { return doorsListedSelector; }

    public By getEngineListedSelector() { return engineListedSelector; }

    public By getDriveTypeListedSelector() { return driveTypeListedSelector; }

    public By getVinListedSelector() { return vinListedSelector; }

    public By getStockNumberListedSelector() { return stockNumberListedSelector; }

    public By getCarIdListedSelector() { return carIdListedSelector; }

    public By getVehicleFeaturesSelector() { return vehicleFeaturesSelector; }

    public By getCalculatePaymentSelector() {
        return calculatePaymentSelector;
    }

    public By getContactDealerButtonSelector() {
        return contactDealerButtonSelector;
    }

    public By getCpoTileSelector() {
        return cpoTileSelector;
    }

    public By getDealerAddressSelector() {
        return dealerAddressSelector;
    }

    public By getDirectionLineSelector() {
        return directionLineSelector;
    }

    public By getEmailDealerButtonSelector() {
        return emailDealerButtonSelector;
    }

    public By getHamburgerButtonSelector() {
        return hamburgerButtonSelector;
    }

    public By getMilesLineSelector() {
        return milesLineSelector;
    }

    public By getNavBarSelector() {
        return navBarSelector;
    }

    public By getPageHeadingSelector() {
        return pageHeadingSelector;
    }

    public By getPhoneNumberLineSelector() {
        return phoneNumberLineSelector;
    }

    public By getSavedListingStarSelector() {
        return savedListingStarSelector;
    }

    public By getUnSavedListingStarSelector() {
        return unSavedListingStarSelector;
    }

    public By getVdpAdSelector() {
        return vdpAdSelector;
    }

    public By getVdpImageSelector() {
        return vdpImageSelector;
    }

    public By getVehicleListSelector() {
        return vehiclePriceSelector;
    }

    public By getVehiclePriceSelector() {
        return vehiclePriceSelector;
    }

    public By getWarrantyCPOTileSelector() {
        return warrantyCPOTileSelector;
    }

    public By getWarrantyDetailSelector() {
        return warrantyDetailSelector;
    }

    public By getWarrantyLinkSelector() {
        return warrantyLinkSelector;
    }

    public By getWarrantySectionSelector() {
        return warrantySectionSelector;
    }

    public By getWebsiteLineSelector() {
        return websiteLineSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initVehicleDetailsPageOptions() {
        vdpImageSelector = By.cssSelector("#evePhoto > img");
        pageHeadingSelector = By.cssSelector("h1");
        dealerAddressSelector = By.cssSelector(".atcui-address");
        vehiclePriceSelector = By.cssSelector(".price-value");
        cpoTileSelector = By.cssSelector(".atc-image.cpoTile");
        warrantySectionSelector = By.cssSelector(".atcui-content.findcar-warranty");
        warrantyLinkSelector = By.cssSelector(".visit.ui-link");
        warrantyCPOTileSelector = By.cssSelector(".atcui-content.findcar-warranty .atc-image");
        warrantyDetailSelector = By.cssSelector(".findcar-warrantyDetail");
        contactDealerButtonSelector = By.cssSelector(".atcui-button.atcui-action");
        directionLineSelector = By.cssSelector(".atcui-address");
        milesLineSelector = By.cssSelector("address.atcui-address > span.atcui-normal");
        phoneNumberLineSelector = By.cssSelector(".atcui-content.atcui-centered.phoneNumber.bordered");
        emailDealerButtonSelector = By.cssSelector(".atcui-button.atcui-action[data-birf-cmp='mdot_dlr_eml_slr']");
        websiteLineSelector = By.cssSelector(".atcui-content.atcui-centered.website");
        unSavedListingStarSelector = By.cssSelector(".atcui-icon.atcui-unfavorite");
        vdpAdSelector = By.xpath("//iframe[contains(@id, 'vdp_0')]");
        calculatePaymentSelector = By.xpath("//a[contains(text(), 'Calculate Payment')]");
        hamburgerButtonSelector = By.cssSelector("a[data-qaid='qa_global_navigation_menu']");
        navBarSelector = By.xpath("//div[@class='atcui-navBar atcui- ']/a");
        vehicleListSelector = By.cssSelector(".atcui-center-panel.atcui-header-item");
        savedListingStarSelector = By.cssSelector(".atcui-icon.atcui-favorite");
        vehicleFeaturesSelector = By.cssSelector(".atcui-block");
        exteriorColorListedSelector = By.xpath("//span[@data-qaid='qa_exteriorColor']");
        interiorColorListedSelector = By.xpath("//span[@data-qaid='qa_interiorColor']");
        fuelTypeListedSelector = By.xpath("//span[@data-qaid='qa_fuelType']");
        transmissionListedSelector = By.xpath("//span[@data-qaid='qa_transmission']");
        doorsListedSelector = By.xpath("//span[@data-qaid='qa_doors']");
        engineListedSelector = By.xpath("//span[@data-qaid='qa_engine']");
        driveTypeListedSelector = By.xpath("//span[@data-qaid='qa_driveType']");
        vinListedSelector = By.xpath("//span[@data-qaid='qa_vin']");
        stockNumberListedSelector = By.xpath("//span[@data-qaid='qa_stockNumber']");
        carIdListedSelector = By.xpath("//span[@data-qaid='qa_atCarId']");
    }
}
