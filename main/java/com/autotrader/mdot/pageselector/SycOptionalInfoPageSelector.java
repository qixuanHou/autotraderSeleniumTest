package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SycOptionalInfoPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By amountOfSelectedFeaturesSelector;
    private By buttonsSelector;
    private By checkoutButtonSelector;
    private By commentBuilderButtonSelector;
    private By commentInputFieldSelector;
    private By doorsInputSelector;
    private By driveTypeInputSelector;
    private By engineInputSelector;
    private By extColorInputSelector;
    private By fuelTypeInputSelector;
    private By infoButtonsSelector;
    private By installedFeaturesButtonSelector;
    private By intColorInputSelector;
    private By nextAddPhotosButtonSelector;
    private By selectCommentsSelector;
    private By selectionSelector;
    private By transmissionInputSelector;
    private By trimInputSelector;
    private By vinInputFieldSelector;
    private By vinValidationErrorSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SycOptionalInfoPageSelector object.
     */
    public SycOptionalInfoPageSelector() {
        initSycOptionInfoPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getAmountOfSelectedFeaturesSelector() {
        return amountOfSelectedFeaturesSelector;
    }

    public By getButtonsSelector() {
        return buttonsSelector;
    }

    public By getCheckoutButtonSelector() {
        return checkoutButtonSelector;
    }

    public By getCommentBuilderButtonSelector() {
        return commentBuilderButtonSelector;
    }

    public By getCommentInputFieldSelector() {
        return commentInputFieldSelector;
    }

    public By getDoorsInputSelector() {
        return doorsInputSelector;
    }

    public By getDriveTypeInputSelector() {
        return driveTypeInputSelector;
    }

    public By getEngineInputSelector() {
        return engineInputSelector;
    }

    public By getExtColorInputSelector() {
        return extColorInputSelector;
    }

    public By getFuelTypeInputSelector() {
        return fuelTypeInputSelector;
    }

    public By getInfoButtonsSelector() {
        return infoButtonsSelector;
    }

    public By getInstalledFeaturesButtonSelector() {
        return installedFeaturesButtonSelector;
    }

    public By getIntColorInputSelector() {
        return intColorInputSelector;
    }

    public By getNextAddPhotosButtonSelector() {
        return nextAddPhotosButtonSelector;
    }

    public By getSelectCommentsSelector() {
        return selectCommentsSelector;
    }

    public By getSelectionSelector() {
        return selectionSelector;
    }

    public By getTransmissionInputSelector() {
        return transmissionInputSelector;
    }

    public By getTrimInputSelector() {
        return trimInputSelector;
    }

    public By getVinInputFieldSelector() {
        return vinInputFieldSelector;
    }

    public By getVinValidationErrorSelector() {
        return vinValidationErrorSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSycOptionInfoPageOptions() {
        trimInputSelector = By.xpath("//select[contains(@id, 'carTrimSelect')]");
        doorsInputSelector = By.xpath("//select[contains(@id, 'carDoorsSelect')]");
        engineInputSelector = By.xpath("//select[contains(@id, 'carEngineSelect')]");
        transmissionInputSelector = By.xpath("//select[contains(@id, 'carTransmissionSelect')]");
        fuelTypeInputSelector = By.xpath("//select[contains(@id, 'carFuelTypeSelect')]");
        driveTypeInputSelector = By.xpath("//select[contains(@id, 'carDriveTypeSelect')]");
        extColorInputSelector = By.xpath("//select[contains(@id, 'carExtColorSelect')]");
        intColorInputSelector = By.xpath("//select[contains(@id, 'carIntColorSelect')]");
        vinInputFieldSelector = By.xpath("//input[contains(@id , 'vin')]");
        commentInputFieldSelector = By.xpath("//textarea[contains(@id, 'sellerComments')]");
        nextAddPhotosButtonSelector = By.xpath("//input[@value='Next: Add Photos']");
        checkoutButtonSelector = By.xpath("//input[contains(@value, 'Checkout')]");
        installedFeaturesButtonSelector = By.xpath("//a[contains(@name, 'featuresTrigger')]");
        commentBuilderButtonSelector = By.xpath("//div[contains(text(), 'Comment Builder')]");
        vinValidationErrorSelector = By.xpath("//span[contains(@id, 'vin')]");
        amountOfSelectedFeaturesSelector = By.cssSelector(".atcui-value.atcui-block");
        infoButtonsSelector = By.cssSelector(".atcui-icon.atcui-info");
        buttonsSelector = By.cssSelector(".atcui-button.atcui-bordered");
        selectionSelector = By.cssSelector(".atcui-selectListItem");
        selectCommentsSelector = By.cssSelector(".atcui-list-view-item.atcui-selectListItem");
    }
}
