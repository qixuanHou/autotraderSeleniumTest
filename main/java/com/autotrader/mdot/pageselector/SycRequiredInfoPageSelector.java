package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SycRequiredInfoPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By answerInputFieldSelector;
    private By bodyStyleInputSelector;
    private By bodyStyleValidationErrorSelector;
    private By emailAddressInputFieldSelector;
    private By emailValidationErrorSelector;
    private By makeInputSelector;
    private By makeValidationErrorSelector;
    private By mileageInputFieldSelector;
    private By mileageValidationErrorSelector;
    private By mobileCheckValidationErrorSelector;
    private By mobileContactCheckInputSelector;
    private By mobileContactValidationErrorSelector;
    private By mobileNumberCheckInputSelector;
    private By modelInputSelector;
    private By modelValidationErrorSelector;
    private By nextOptionalInfoButtonSelector;
    private By noMobileNumberCheckInputSelector;
    private By phoneInputFieldSelector;
    private By phoneValidationErrorSelector;
    private By priceInputFieldSelector;
    private By priceValidationErrorSelector;
    private By securityQuestionAnswerValidationErrorSelector;
    private By securityQuestionInputSelector;
    private By securityQuestionValidationErrorSelector;
    private By yearInputSelector;
    private By yearValidationErrorSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SycRequiredInfoPageSelector object.
     */
    public SycRequiredInfoPageSelector() {
        initSycRequiredInfoPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getAnswerInputFieldSelector() {
        return answerInputFieldSelector;
    }

    public By getBodyStyleInputSelector() {
        return bodyStyleInputSelector;
    }

    public By getBodyStyleValidationErrorSelector() {
        return bodyStyleValidationErrorSelector;
    }

    public By getEmailAddressInputFieldSelector() {
        return emailAddressInputFieldSelector;
    }

    public By getEmailValidationErrorSelector() {
        return emailValidationErrorSelector;
    }

    public By getMakeInputSelector() {
        return makeInputSelector;
    }

    public By getMakeValidationErrorSelector() {
        return makeValidationErrorSelector;
    }

    public By getMileageInputFieldSelector() {
        return mileageInputFieldSelector;
    }

    public By getMileageValidationErrorSelector() {
        return mileageValidationErrorSelector;
    }

    public By getMobileCheckValidationErrorSelector() {
        return mobileCheckValidationErrorSelector;
    }

    public By getMobileContactCheckInputSelector() {
        return mobileContactCheckInputSelector;
    }

    public By getMobileContactValidationErrorSelector() {
        return mobileContactValidationErrorSelector;
    }

    public By getMobileNumberCheckInputSelector() {
        return mobileNumberCheckInputSelector;
    }

    public By getModelInputSelector() {
        return modelInputSelector;
    }

    public By getModelValidationErrorSelector() {
        return modelValidationErrorSelector;
    }

    public By getNextOptionalInfoButtonSelector() {
        return nextOptionalInfoButtonSelector;
    }

    public By getNoMobileNumberCheckInputSelector() {
        return noMobileNumberCheckInputSelector;
    }

    public By getPhoneInputFieldSelector() {
        return phoneInputFieldSelector;
    }

    public By getPhoneValidationErrorSelector() {
        return phoneValidationErrorSelector;
    }

    public By getPriceInputFieldSelector() {
        return priceInputFieldSelector;
    }

    public By getPriceValidationErrorSelector() {
        return priceValidationErrorSelector;
    }

    public By getSecurityQuestionAnswerValidationErrorSelector() {
        return securityQuestionAnswerValidationErrorSelector;
    }

    public By getSecurityQuestionInputSelector() {
        return securityQuestionInputSelector;
    }

    public By getSecurityQuestionValidationErrorSelector() {
        return securityQuestionValidationErrorSelector;
    }

    public By getYearInputSelector() {
        return yearInputSelector;
    }

    public By getYearValidationErrorSelector() {
        return yearValidationErrorSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSycRequiredInfoPageOptions() {
        yearInputSelector = By.xpath("//select[contains(@id, 'year')]");
        makeInputSelector = By.xpath("//select[contains(@id, 'makeCode')]");
        modelInputSelector = By.xpath("//select[contains(@id, 'modelCode')]");
        bodyStyleInputSelector = By.xpath("//select[contains(@id, 'bodyStyle')]");
        mileageInputFieldSelector = By.xpath("//input[contains(@id, 'mileage')]");
        priceInputFieldSelector = By.xpath("//input[contains(@id, 'price')]");
        phoneInputFieldSelector = By.xpath("//input[contains(@id, 'phone')]");
        mobileNumberCheckInputSelector = By.xpath("//label[contains(@for, 'isMobile-0')]");
        noMobileNumberCheckInputSelector = By.xpath("//label[contains(@for, 'isMobile-1')]");
        mobileContactCheckInputSelector = By.xpath("//label[contains(@for, 'isAutoDial-1')]");
        emailAddressInputFieldSelector = By.xpath("//input[contains(@id, 'email')]");
        securityQuestionInputSelector = By.xpath("//select[contains(@id, 'question')]");
        answerInputFieldSelector = By.xpath("//input[contains(@id, 'answer')]");
        nextOptionalInfoButtonSelector = By.xpath("//input[@value='Next: Optional Info']");
        yearValidationErrorSelector = By.xpath("//span[contains(@id, 'year')]");
        makeValidationErrorSelector = By.xpath("//span[contains(@id, 'makeCode')]");
        modelValidationErrorSelector = By.xpath("//span[contains(@id, 'modelCode')]");
        bodyStyleValidationErrorSelector = By.xpath("//span[contains(@id, 'bodyStyle')]");
        mileageValidationErrorSelector = By.xpath("//span[contains(@id, 'mileage')]");
        priceValidationErrorSelector = By.xpath("//span[contains(@id, 'price')]");
        phoneValidationErrorSelector = By.xpath("//span[contains(@id, 'phone')]");
        emailValidationErrorSelector = By.xpath("//span[contains(@id, 'email')]");
        securityQuestionValidationErrorSelector = By.xpath("//span[contains(@id, 'question')]");
        securityQuestionAnswerValidationErrorSelector = By.xpath("//span[contains(@id, 'answer')]");
        mobileCheckValidationErrorSelector = By.xpath("//span[contains(@id, 'isMobile')]");
        mobileContactValidationErrorSelector = By.xpath("//span[contains(@id, 'isAutoDial')]");
    }
}
