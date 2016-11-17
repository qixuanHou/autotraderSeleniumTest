package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by mwstratton on 10/20/2015.
 */
public class DealerDetailPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By addressLineSelector;
    private By contactButtonSelector;
    private By contactDealerPanelHeaderSelector;
    private By contactDealerPanelSelector;
    private By dealerNameSelector;
    private By emailDealerButtonSelector;
    private By filterButtonSelector;
    private By getDirectionButtonSelector;
    private By imageSelector;
    private By imageViewListViewSelectedSelector;
    private By imageViewSelector;
    private By listingSortBySelector;

    private By listingsSelector;
    private By listSelector;
    private By listViewSelector;
    private By messagePlaceholderTextOnContactPanelSelector;
    private By phoneNumberLineSelector;
    private By priceValuesListedSelector;
    private By websiteLineSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new DealerDetailPageSelector object.
     */
    public DealerDetailPageSelector() {
        initDdpOptions();
        initContactDealerFlyoutPanelOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getAddressLineSelector() {
        return addressLineSelector;
    }

    public By getContactButtonSelector() {
        return contactButtonSelector;
    }

    public By getContactDealerPanelHeaderSelector() {
        return contactDealerPanelHeaderSelector;
    }

    public By getContactDealerPanelSelector() {
        return contactDealerPanelSelector;
    }

    public By getDealerNameSelector() {
        return dealerNameSelector;
    }

    public By getEmailDealerButtonSelector() {
        return emailDealerButtonSelector;
    }

    public By getFilterButtonSelector() {
        return filterButtonSelector;
    }

    public By getGetDirectionButtonSelector() {
        return getDirectionButtonSelector;
    }

    public By getImageSelector() {
        return imageSelector;
    }

    public By getImageViewListViewSelectedSelector() {
        return imageViewListViewSelectedSelector;
    }

    public By getImageViewSelector() {
        return imageViewSelector;
    }

    public By getListingSortBySelector() {
        return listingSortBySelector;
    }

    public By getListingsSelector() {
        return listingsSelector;
    }

    public By getListSelector() {
        return listSelector;
    }

    public By getListViewSelector() {
        return listViewSelector;
    }

    public By getMessagePlaceholderTextOnContactPanelSelector() {
        return messagePlaceholderTextOnContactPanelSelector;
    }

    public By getPhoneNumberLineSelector() {
        return phoneNumberLineSelector;
    }

    public By getPriceValuesListedSelector() {
        return priceValuesListedSelector;
    }

    public By getWebsiteLineSelector() {
        return websiteLineSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initContactDealerFlyoutPanelOptions() {
        contactDealerPanelSelector = By.cssSelector(".mdot-contactSellerPanel");
        contactDealerPanelHeaderSelector = By.cssSelector(".mdot-contactSellerPanel .atcui-center-panel");
        messagePlaceholderTextOnContactPanelSelector = By.cssSelector("textarea[id*='comments']");
        listingSortBySelector = By.cssSelector(".listing-sort-by");
        dealerNameSelector = By.cssSelector(".atcui-title.atcui-internal-inset");
        imageViewListViewSelectedSelector = By.cssSelector(".atcui-strong");
        priceValuesListedSelector = By.cssSelector(".price-value");
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initDdpOptions() {
        listingsSelector = By.cssSelector(".listing-options");
        imageViewSelector = By.xpath("//a[@data-birf-cmp='mdot_pg_vg']");
        listViewSelector = By.xpath("//a[@data-birf-cmp='mdot_pg_vl']");
        imageSelector = By.cssSelector(".atc-image.atcui-vehicle-image");
        listSelector = By.cssSelector(".mdot-dealerDetails.atcui-inset");
        getDirectionButtonSelector = By.cssSelector(".atcui-vertical .atcui-secondaryAction");
        contactButtonSelector = By.cssSelector("div a[href*='contactSellerPanel']");
        addressLineSelector = By.cssSelector("address");
        phoneNumberLineSelector = By.cssSelector(".atcui-block.atcui.ui-link");
        websiteLineSelector = By.cssSelector(".website");
        emailDealerButtonSelector = By.xpath("//a[contains(text(), 'Email Dealer')]");
        filterButtonSelector = By.xpath("//a[contains(@id, 'filtersTrigger')]");
    }
}
