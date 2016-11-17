package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SavedListingsPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By cancelButtonSelector;
    private By confirmDeleteAllSelector;
    private By confirmDeleteSelector;
    private By currentViewSelectedSelector;
    private By deleteAllButtonSelector;
    private By editButtonSelector;
    private By editModeDeleteSelector;
    private By hamburgerButtonSelector;
    private By headerSelector;
    private By imageViewSelector;
    private By listViewSelector;
    private By saveListingStarSelector;
    private By startYourSearchButtonSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SavedListingsPageSelector object.
     */
    public SavedListingsPageSelector() {
        initSavedListingsPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getCancelButtonSelector() {
        return cancelButtonSelector;
    }

    public By getConfirmDeleteAllSelector() {
        return confirmDeleteAllSelector;
    }

    public By getConfirmDeleteSelector() {
        return confirmDeleteSelector;
    }

    public By getCurrentViewSelectedSelector() {
        return currentViewSelectedSelector;
    }

    public By getDeleteAllButtonSelector() {
        return deleteAllButtonSelector;
    }

    public By getEditButtonSelector() {
        return editButtonSelector;
    }

    public By getEditModeDeleteSelector() {
        return editModeDeleteSelector;
    }

    public By getHamburgerButtonSelector() {
        return hamburgerButtonSelector;
    }

    public By getHeaderSelector() {
        return headerSelector;
    }

    public By getImageViewSelector() {
        return imageViewSelector;
    }

    public By getListViewSelector() {
        return listViewSelector;
    }

    public By getSaveListingStarSelector() {
        return saveListingStarSelector;
    }

    public By getStartYourSearchButtonSelector() {
        return startYourSearchButtonSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSavedListingsPageOptions() {
        editButtonSelector = By.cssSelector(".atcui-button.atcui-bordered.myatc-editmode-enable");
        confirmDeleteSelector =
            By.cssSelector("#myAtcCars-j_id_cm-editMode_deleteItemDialog-j_id_dg-editMode_deleteItemButton");
        confirmDeleteAllSelector = By.xpath("//a[contains(@id, 'deleteAllButton')]");
        deleteAllButtonSelector = By.cssSelector("#myAtcCars-editHeader-j_id_9y");
        hamburgerButtonSelector = By.cssSelector("a[data-qaid='qa_global_navigation_menu']");
        cancelButtonSelector = By.cssSelector("#myAtcCars-editHeader-j_id_a0");
        startYourSearchButtonSelector = By.xpath("//a[contains(text(), 'START YOUR SEARCH')]");
        currentViewSelectedSelector = By.cssSelector(".atcui-strong");
        imageViewSelector = By.xpath("//span[contains(text(), 'Image View')]");
        listViewSelector = By.xpath("//span[contains(text(), 'List View')]");
        saveListingStarSelector = By.cssSelector(".atcui-icon.atcui-favorite");
        editModeDeleteSelector = By.cssSelector(".myatc-editmode-delete-item.atcui-icon.atcui-minus");
        headerSelector = By.cssSelector("#myAtcCars-standardHeader-headerTitle");
    }
}
