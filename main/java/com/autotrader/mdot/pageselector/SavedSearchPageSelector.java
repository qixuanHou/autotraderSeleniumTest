package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SavedSearchPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By confirmDeleteAllSelector;
    private By confirmDeleteButtonSelector;
    private By deleteAllButtonSelector;
    private By deleteButtonSelector;
    private By editButtonSelector;
    private By hamburgerButtonSelector;
    private By headerSelector;
    private By savedSearchesSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SavedSearchPageSelector object.
     */
    public SavedSearchPageSelector() {
        initSavedSearchPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getConfirmDeleteAllSelector() {
        return confirmDeleteAllSelector;
    }

    public By getConfirmDeleteButtonSelector() {
        return confirmDeleteButtonSelector;
    }

    public By getDeleteAllButtonSelector() {
        return deleteAllButtonSelector;
    }

    public By getDeleteButtonSelector() {
        return deleteButtonSelector;
    }

    public By getEditButtonSelector() {
        return editButtonSelector;
    }

    public By getHamburgerButtonSelector() {
        return hamburgerButtonSelector;
    }

    public By getHeaderSelector() {
        return headerSelector;
    }

    public By getSavedSearchesSelector() {
        return savedSearchesSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSavedSearchPageOptions() {
        deleteAllButtonSelector = By.cssSelector("#myAtcSearches-editHeader-j_id_a2");
        confirmDeleteButtonSelector = By.xpath("//a[contains(text(), 'Delete')]");
        editButtonSelector = By.xpath("//a[contains(@id, 'headerEditButton')]");
        savedSearchesSelector = By.cssSelector(".atcui-button.atcui-action.atcui-primary.myatc-searchresult-count");
        confirmDeleteAllSelector = By.xpath("//a[contains(@id, 'deleteAllButton')]");
        hamburgerButtonSelector = By.cssSelector("a[data-qaid='qa_global_navigation_menu']");
        deleteButtonSelector = By.cssSelector(".myatc-editmode-delete-item.atcui-icon.atcui-minus");
        headerSelector = By.cssSelector("#myAtcSearches-standardHeader-headerTitle");
    }
}
