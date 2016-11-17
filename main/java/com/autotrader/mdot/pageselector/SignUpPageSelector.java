package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SignUpPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By emailInputSelector;
    private By emailValidationErrorSelector;
    private By passwordInputSelector;
    private By passwordValidationErrorSelector;
    private By reEnterEmailInputSelector;
    private By reEnterPasswordInputSelector;
    private By signUpButtonSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SignUpPageSelector object.
     */
    public SignUpPageSelector() {
        initSignUpPageSelector();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getEmailInputSelector() {
        return emailInputSelector;
    }

    public By getEmailValidationErrorSelector() {
        return emailValidationErrorSelector;
    }

    public By getPasswordInputSelector() {
        return passwordInputSelector;
    }

    public By getPasswordValidationErrorSelector() {
        return passwordValidationErrorSelector;
    }

    public By getReEnterEmailInputSelector() {
        return reEnterEmailInputSelector;
    }

    public By getReEnterPasswordInputSelector() {
        return reEnterPasswordInputSelector;
    }

    public By getSignUpButtonSelector() {
        return signUpButtonSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSignUpPageSelector() {
        emailInputSelector = By.xpath("//input[@id='signUpForm-signup-j_id_3i-j_id_45-j_id_4a-j_id_4o-email']");
        reEnterEmailInputSelector = By.xpath("//input[contains(@placeholder, 'reenter email')]");
        passwordInputSelector = By.xpath("//input[@id='signUpForm-signup-j_id_3i-j_id_45-j_id_4a-j_id_59-pw']");
        reEnterPasswordInputSelector = By.xpath("//input[contains(@placeholder, 'reenter password')]");
        signUpButtonSelector = By.xpath("//input[@value='Sign Up']");
        emailValidationErrorSelector = By.xpath("//span[@class='rf-msg-det']");
        passwordValidationErrorSelector = By.xpath("//span[@class='rf-msg-det']");
    }
}
