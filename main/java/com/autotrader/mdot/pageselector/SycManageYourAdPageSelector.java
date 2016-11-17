package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SycManageYourAdPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By contactInfoListedSelector;
    private By editableInfoBoxSelector;
    private By mileageListedSelector;
    private By priceListedSelector;
    private By removeAdButtonSelector;
    private By cancelButtonSelector;
    private By saveButtonSelector;
    private By newMileageSelector;
    private By newPriceSelector;
    private By newCommentsSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SycManageYourAdPageSelector object.
     */
    public SycManageYourAdPageSelector() {
        initSycManageYourAdPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getContactInfoListedSelector() {
        return contactInfoListedSelector;
    }

    public By getEditableInfoBoxSelector() {
        return editableInfoBoxSelector;
    }

    public By getMileageListedSelector() {
        return mileageListedSelector;
    }

    public By getPriceListedSelector() {
        return priceListedSelector;
    }

    public By getRemoveAdButtonSelector() {
        return removeAdButtonSelector;
    }

    public By getCancelButtonSelector() { return cancelButtonSelector; }

    public By getSaveButtonSelector() { return saveButtonSelector; }

    public By getNewMileageSelector() { return newMileageSelector; }

    public By getNewPriceSelector() { return newPriceSelector; }

    public By getNewCommentsSelector() { return newCommentsSelector; }

    /**
     * TODO: Enter Javadoc
     */
    public void initSycManageYourAdPageOptions() {
        removeAdButtonSelector = By.xpath("//a[contains(text(), 'Remove Ad')]");
        mileageListedSelector = By.xpath("//span[contains(@id, 'listingMileage')]");
        priceListedSelector = By.xpath("//span[contains(@id, 'listingPrice')]");
        contactInfoListedSelector = By.xpath("//div[contains(@id, 'listingContactInfo')]");
        editableInfoBoxSelector = By.cssSelector(".atcui-container.atcui-primary.atcui-inset");
        saveButtonSelector = By.xpath("//a[contains(text(), 'Save')]");
        cancelButtonSelector = By.xpath("//a[contains(text(), 'Cancel')]");
        newMileageSelector = By.xpath("//input[@id='carMileage']");
        newPriceSelector = By.xpath("//input[@id='carPrice']");
        newCommentsSelector = By.xpath("//input[@id='sellersComments']");
    }
}
