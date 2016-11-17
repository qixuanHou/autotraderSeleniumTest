package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SycCheckoutPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By addressLine1InputSelector;
    private By cancelButton;
    private By cardNumberInputSelector;
    private By cardTypeSelector;
    private By cityInputSelector;
    private By expirationMonthSelector;
    private By expirationYearSelector;
    private By firstNameInputSelector;
    private By lastNameInputSelector;
    private By savePaymentInformationSelector;
    private By securityCodeInputSelector;
    private By stateSelector;
    private By submitButton;
    private By zipCodeInputSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SycCheckoutPageSelector object.
     */
    public SycCheckoutPageSelector() {
        initSycCheckoutPageSelector();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getAddressLine1InputSelector() {
        return addressLine1InputSelector;
    }

    public By getCancelButton() {
        return cancelButton;
    }

    public By getCardNumberInputSelector() {
        return cardNumberInputSelector;
    }

    public By getCardTypeSelector() {
        return cardTypeSelector;
    }

    public By getCityInputSelector() {
        return cityInputSelector;
    }

    public By getExpirationMonthSelector() {
        return expirationMonthSelector;
    }

    public By getExpirationYearSelector() {
        return expirationYearSelector;
    }

    public By getFirstNameInputSelector() {
        return firstNameInputSelector;
    }

    public By getLastNameInputSelector() {
        return lastNameInputSelector;
    }

    public By getSavePaymentInformationSelector() {
        return savePaymentInformationSelector;
    }

    public By getSecurityCodeInputSelector() {
        return securityCodeInputSelector;
    }

    public By getStateSelector() {
        return stateSelector;
    }

    public By getSubmitButton() {
        return submitButton;
    }

    public By getZipCodeInputSelector() {
        return zipCodeInputSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSycCheckoutPageSelector() {
        cardTypeSelector = By.id("card_type");
        cardNumberInputSelector = By.xpath("//input[@id='card_number']");
        securityCodeInputSelector = By.xpath("//input[@id='card_cvn']");
        expirationMonthSelector = By.xpath("//select[contains(@id, 'card_expirationMonth')]");
        expirationYearSelector = By.xpath("//select[contains(@id, 'card_expirationYear')]");
        savePaymentInformationSelector = By.xpath("//input[@id='save_card']");
        firstNameInputSelector = By.xpath("//input[@id='bill_to_forename']");
        lastNameInputSelector = By.xpath("//input[@id='bill_to_surname']");
        addressLine1InputSelector = By.xpath("//input[@id='bill_to_address_line1']");
        cityInputSelector = By.xpath("//input[@id='bill_to_address_city']");
        stateSelector = By.xpath("//select[contains(@id, 'bill_to_address_state')]");
        zipCodeInputSelector = By.xpath("//input[@id='bill_to_address_postal_code']");
        submitButton = By.xpath("//input[@id='submitForm']");
        cancelButton = By.xpath("//a[contains(text(),'Cancel')]");
    }
}
