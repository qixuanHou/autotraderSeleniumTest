package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SycPhotoSuggestionsPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By exteriorViewBannerSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SycPhotoSuggestionsPageSelector object.
     */
    public SycPhotoSuggestionsPageSelector() {
        initSycPhotoSuggestionPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getExteriorViewBannerSeleector() {
        return exteriorViewBannerSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSycPhotoSuggestionPageOptions() {
        exteriorViewBannerSelector = By.cssSelector(".atcui-title.atcui-internal-inset");
    }
}
