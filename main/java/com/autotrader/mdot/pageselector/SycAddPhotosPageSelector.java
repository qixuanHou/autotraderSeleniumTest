package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SycAddPhotosPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By checkoutButtonSelector;
    private By nextReviewAdButtonSelector;
    private By photoSuggestionsButtonSelector;
    private By uploadPhotosButtonSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SycAddPhotosPageSelector object.
     */
    public SycAddPhotosPageSelector() {
        initSycAddPhotoPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getCheckoutButtonSelector() {
        return checkoutButtonSelector;
    }

    public By getNextReviewAdButtonSelector() {
        return nextReviewAdButtonSelector;
    }

    public By getPhotoSuggestionsButtonSelector() {
        return photoSuggestionsButtonSelector;
    }

    public By getUploadPhotosButtonSelector() {
        return uploadPhotosButtonSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSycAddPhotoPageOptions() {
        uploadPhotosButtonSelector = By.xpath("//a[contains(text(), 'Upload Photos')]");
        nextReviewAdButtonSelector = By.xpath("//a[contains(text(), 'Next: Review Ad')]");
        photoSuggestionsButtonSelector = By.xpath("//a[contains(text(), 'Photo Suggestions')]");
        checkoutButtonSelector = By.xpath("//a[contains(text(), 'Checkout')]");
    }
}
