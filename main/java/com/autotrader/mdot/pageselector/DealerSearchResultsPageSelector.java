package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/21/2015.
 */
public class DealerSearchResultsPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By addressListedSelector;
    private By dealerNameForListingSelector;
    private By directionLineSelector;

    private By filterButtonSelector;
    private By hamburgerButtonSelector;
    private By headingForCarDealersSelector;
    private By listMapButtonsSelector;
    private By loadMoreButtonSelector;
    private By mapDealerSelector;
    private By phoneListedSelector;
    private By phoneNumberLineSelector;
    private By viewListingsButtonsSelector;
    private By viewListingSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new DealerSearchResultsPageSelector object.
     */
    public DealerSearchResultsPageSelector() {
        initDealerSearchResultPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getAddressListedSelector() {
        return addressListedSelector;
    }

    public By getDealerNameForListingSelector() {
        return dealerNameForListingSelector;
    }

    public By getDirectionLineSelector() {
        return directionLineSelector;
    }

    public By getHamburgerButtonSelector() {
        return hamburgerButtonSelector;
    }

    public By getHeadingForCarDealersSelector() {
        return headingForCarDealersSelector;
    }

    public By getListMapButtonsSelector() {
        return listMapButtonsSelector;
    }

    public By getLoadMoreButtonSelector() {
        return loadMoreButtonSelector;
    }

    public By getMapDealerSelector() {
        return mapDealerSelector;
    }

    public By getPhoneListedSelector() {
        return phoneListedSelector;
    }

    public By getPhoneNumberLineSelector() {
        return phoneNumberLineSelector;
    }

    public By getViewListingsButtonsSelector() {
        return viewListingsButtonsSelector;
    }

    public By getViewListingSelector() {
        return viewListingSelector;
    }

    /**
     * TODO: Enter Javadoc
     *
     * @return out value
     */
    public By getfilterButtonSelector() {
        return filterButtonSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initDealerSearchResultPageOptions() {
        filterButtonSelector = By.xpath("//a[@data-birf-cmp = 'mdot_fyd_fltr_md']");
        viewListingSelector = By.cssSelector(".atcui-button.atcui-action.atcui-inset");
        listMapButtonsSelector = By.cssSelector(".atcui-flexboxItem");
        loadMoreButtonSelector = By.xpath("//a[contains(text(), 'Tap to Load More')]");
        hamburgerButtonSelector = By.cssSelector("a[data-qaid='qa_global_navigation_menu']");
        phoneNumberLineSelector = By.cssSelector(".atcui-block.atcui.ui-link");
        directionLineSelector = By.cssSelector(".atcui-address");
        mapDealerSelector = By.cssSelector(".atcui-mapPanel.fullSize");
        headingForCarDealersSelector = By.xpath("//h1[contains(text(), 'Car Dealers')]");
        addressListedSelector = By.cssSelector(".address1");
        phoneListedSelector = By.cssSelector(".atcui-icon.atcui-phone.atcui-content-icon");
        viewListingsButtonsSelector = By.xpath("//a[contains(text(), 'View')]");
        dealerNameForListingSelector = By.cssSelector(".atcui-title.atcui-internal-inset");
    }
}
