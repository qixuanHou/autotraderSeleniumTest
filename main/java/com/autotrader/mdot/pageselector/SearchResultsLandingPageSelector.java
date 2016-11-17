package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/21/2015.
 */
public class SearchResultsLandingPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By actionItemSelector;
    private By alphaAdCarouselSelector;
    private By alphaAdSelector;
    private By alphaAdViewInventorySelector;
    private By doneSavedSearchButtonSelector;
    private By extColorConditionMileageListedSelector;
    private By filterButtonSelector;
    private By firstAdSelector;
    private By firstListingSelector;
    private By hamburgerButtonSelector;
    private By headerSelector;
    private By imageViewButtonSelector;
    private By imageViewSelector;
    private By listingSelector;
    private By listingSortBySelector;
    private By listingsSelector;
    private By listViewButtonSelector;
    private By listViewSelector;
    private By makeValueListedSelector;
    private By modelValueListedSelector;
    private By optionSelector;
    private By premiumListingsBannerSelector;
    private By priceValuesListedSelector;
    private By primaryPriceSelector;
    private By savedSearchNameInputSelector;
    private By saveListingStarSelector;
    private By saveSearchStarButtonSelector;
    private By saveSearchStarSelector;
    private By secondAdSelector;
    private By selectedOptionSelector;
    private By sortOptionSelector;
    private By tapToLoadMoreSelector;
    private By thirdAdSelector;
    private By trimValueListedSelector;
    private By yearValueListedSelector;
    private By nationalSrpHeaderSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SearchResultsLandingPageSelector object.
     */
    public SearchResultsLandingPageSelector() {
        initSearchResultsLandingPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getNationalSrpHeaderSelector() { return nationalSrpHeaderSelector; }

    public By getActionItemSelector() {
        return actionItemSelector;
    }

    public By getAlphaAdCarouselSelector() {
        return alphaAdCarouselSelector;
    }

    public By getAlphaAdSelector() {
        return alphaAdSelector;
    }

    public By getAlphaAdViewInventorySelector() {
        return alphaAdViewInventorySelector;
    }

    public By getDoneSavedSearchButtonSelector() {
        return doneSavedSearchButtonSelector;
    }

    public By getExtColorConditionMileageListedSelector() {
        return extColorConditionMileageListedSelector;
    }

    public By getFilterButtonSelector() {
        return filterButtonSelector;
    }

    public By getFirstAdSelector() {
        return firstAdSelector;
    }

    public By getFirstListingSelector() {
        return firstListingSelector;
    }

    public By getHamburgerButtonSelector() {
        return hamburgerButtonSelector;
    }

    public By getHeaderSelector() {
        return headerSelector;
    }

    public By getImageViewButtonSelector() {
        return imageViewButtonSelector;
    }

    public By getImageViewSelector() {
        return imageViewSelector;
    }

    public By getListingSelector() {
        return listingSelector;
    }

    public By getListingSortBySelector() {
        return listingSortBySelector;
    }

    public By getListingsSelector() {
        return listingsSelector;
    }

    public By getListViewButtonSelector() {
        return listViewButtonSelector;
    }

    public By getListViewSelector() {
        return listViewSelector;
    }

    public By getMakeValueListedSelector() {
        return makeValueListedSelector;
    }

    public By getModelValueListedSelector() {
        return modelValueListedSelector;
    }

    public By getOptionSelector() {
        return optionSelector;
    }

    public By getPremiumListingsBannerSelector() {
        return premiumListingsBannerSelector;
    }

    public By getPriceValuesListedSelector() {
        return priceValuesListedSelector;
    }

    public By getPrimaryPriceSelector() {
        return primaryPriceSelector;
    }

    public By getSavedSearchNameInputSelector() {
        return savedSearchNameInputSelector;
    }

    public By getSaveListingStarSelector() {
        return saveListingStarSelector;
    }

    public By getSaveSearchStarButtonSelector() {
        return saveSearchStarButtonSelector;
    }

    public By getSaveSearchStarSelector() {
        return saveSearchStarSelector;
    }

    public By getSecondAdSelector() {
        return secondAdSelector;
    }

    public By getSelectedOptionSelector() {
        return selectedOptionSelector;
    }

    public By getSortOptionSelector() {
        return sortOptionSelector;
    }

    public By getTapToLoadMoreSelector() {
        return tapToLoadMoreSelector;
    }

    public By getThirdAdSelector() {
        return thirdAdSelector;
    }

    public By getTrimValueListedSelector() {
        return trimValueListedSelector;
    }

    public By getYearValueListedSelector() {
        return yearValueListedSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSearchResultsLandingPageOptions() {
        hamburgerButtonSelector = By.cssSelector("a[data-qaid='qa_global_navigation_menu']");
        saveSearchStarButtonSelector = By.cssSelector(".savesearch-button");
        savedSearchNameInputSelector = By.xpath("//input[contains(@id, 'bookmarkName')]");
        doneSavedSearchButtonSelector = By.xpath("//a[contains(text(),'DONE')]");
        filterButtonSelector = By.xpath("//a[contains(@id, 'filtersTrigger')]");
        firstListingSelector = By.cssSelector(".listing-content.atcui-inset");
        listingsSelector = By.cssSelector(".listing-content.atcui-inset");
        imageViewButtonSelector = By.xpath("//a[@data-birf-cmp='mdot_pg_vg']");
        listViewButtonSelector = By.xpath("//a[@data-birf-cmp='mdot_pg_vl']");
        listingSortBySelector = By.cssSelector(".listing-sort-by");
        tapToLoadMoreSelector = By.cssSelector(".atcui-button.atcui-secondary");
        saveListingStarSelector = By.cssSelector(".atcui-icon.atcui-unfavorite");
        alphaAdSelector = By.xpath("//div[@data-atc-role='alpha']");
        alphaAdCarouselSelector = By.cssSelector(".atcui-carousel-pagination-switch");
        alphaAdViewInventorySelector = By.xpath("//a[contains(text(), 'View Inventory')]");
        firstAdSelector = By.xpath("//iframe[contains(@id, 'srp_0')]");
        secondAdSelector = By.xpath("//iframe[contains(@id, 'srp_1')]");
        thirdAdSelector = By.xpath("//iframe[contains(@id, 'srp_2')]");
        premiumListingsBannerSelector = By.cssSelector(".atcui-list-view-item.atcui-internal-inset.priority-type");
        priceValuesListedSelector = By.cssSelector(".price-value");
        yearValueListedSelector = By.cssSelector(".listing-year");
        makeValueListedSelector = By.cssSelector(".listing-make");
        modelValueListedSelector = By.cssSelector(".listing-model");
        trimValueListedSelector = By.cssSelector(".listing-trim");
        extColorConditionMileageListedSelector = By.cssSelector(".atcui-inline.listing-options-item");
        primaryPriceSelector = By.cssSelector(".primary-price");
        saveSearchStarSelector = By.cssSelector(".savelisting-trigger.favorite.needsclick.recursive.ui-link");
        listingSelector = By.cssSelector(".atc-price.listing-options-item");
        headerSelector = By.cssSelector(".atcui-center-panel.atcui-header-item");
        sortOptionSelector = By.xpath("//div[@class='atcui-subheader-panel leftPanel']");
        selectedOptionSelector = By.xpath("//select[contains(@name, 'searchResults')]");
        imageViewSelector = By.cssSelector(".atcui-list-view.listings");
        listViewSelector = By.cssSelector(".atcui-list-view.atcui-list-view-dividers");
        actionItemSelector = By.className("listing-actions");
        optionSelector = By.tagName("option");
        nationalSrpHeaderSelector = By.xpath("//h1[contains(text(), 'Nationwide')]");
    }
}
