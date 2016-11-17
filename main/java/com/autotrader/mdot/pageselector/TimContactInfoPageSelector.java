package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class TimContactInfoPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By buyAnotherCheckBoxSelector;
    private By emailInputFieldSelector;
    private By emailInputFieldValidationSelector;
    private By emailVerifyInputFieldSelector;
    private By emailVerifyInputFieldValidationSelector;
    private By firstNameInputFieldSelector;
    private By firstNameInputFieldValidationSelector;
    private By lastNameInputFieldSelector;
    private By lastNameInputFieldValidationSelector;
    private By nextButtonSelector;
    private By phoneInputFieldSelector;
    private By phoneInputFieldValidationSelector;
    private By replacementMakeDropDownSelector;
    private By replacementModelDropDownSelector;
    private By visitAgreementCheckBoxSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new TimContactInfoPageSelector object.
     */
    public TimContactInfoPageSelector() {
        initTimContactInfoPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getBuyAnotherCheckBoxSelector() {
        return buyAnotherCheckBoxSelector;
    }

    public By getEmailInputFieldSelector() {
        return emailInputFieldSelector;
    }

    public By getEmailInputFieldValidationSelector() {
        return emailInputFieldValidationSelector;
    }

    public By getEmailVerifyInputFieldSelector() {
        return emailVerifyInputFieldSelector;
    }

    public By getEmailVerifyInputFieldValidationSelector() {
        return emailVerifyInputFieldValidationSelector;
    }

    public By getFirstNameInputFieldSelector() {
        return firstNameInputFieldSelector;
    }

    public By getFirstNameInputFieldValidationSelector() {
        return firstNameInputFieldValidationSelector;
    }

    public By getLastNameInputFieldSelector() {
        return lastNameInputFieldSelector;
    }

    public By getLastNameInputFieldValidationSelector() {
        return lastNameInputFieldValidationSelector;
    }

    public By getNextButtonSelector() {
        return nextButtonSelector;
    }

    public By getPhoneInputFieldSelector() {
        return phoneInputFieldSelector;
    }

    public By getPhoneInputFieldValidationSelector() {
        return phoneInputFieldValidationSelector;
    }

    public By getReplacementMakeDropDownSelector() {
        return replacementMakeDropDownSelector;
    }

    public By getReplacementModelDropDownSelector() {
        return replacementModelDropDownSelector;
    }

    public By getVisitAgreementCheckBoxSelector() {
        return visitAgreementCheckBoxSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initTimContactInfoPageOptions() {
        firstNameInputFieldSelector = By.xpath("//input[contains(@id, 'FirstName_input')]");
        lastNameInputFieldSelector = By.xpath("//input[contains(@id, 'LastName_input')]");
        emailInputFieldSelector = By.xpath("//input[contains(@id, 'Email_input')]");
        emailVerifyInputFieldSelector = By.xpath("//input[contains(@id, 'Email_verify')]");
        phoneInputFieldSelector = By.xpath("//input[contains(@id, 'Phone_input')]");
        buyAnotherCheckBoxSelector = By.id("buyAnother-buyAnother");
        replacementMakeDropDownSelector = By.xpath("//select[contains(@id, 'VehicleMake')]");
        replacementModelDropDownSelector = By.xpath("//select[contains(@id, 'VehicleModel')]");
        visitAgreementCheckBoxSelector = By.xpath("//input[@id='visitorAgreement-visitorAgreement']");
        nextButtonSelector = By.xpath("//input[contains(@value, 'Next')]");
        firstNameInputFieldValidationSelector = By.xpath("//span[contains(@for, 'FirstName_input')]");
        lastNameInputFieldValidationSelector = By.xpath("//span[contains(@for, 'LastName_input')]");
        emailInputFieldValidationSelector = By.xpath("//span[contains(@for, 'Email_input')]");
        emailVerifyInputFieldValidationSelector = By.xpath("//span[contains(@for, 'Email_verify')]");
        phoneInputFieldValidationSelector = By.xpath("//span[contains(@for, 'Phone_input')]");
    }
}
