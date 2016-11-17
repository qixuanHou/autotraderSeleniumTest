package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class SignInPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By emailInputSelector;
    private By passwordInputSelector;
    private By signInSelector;
    private By signUpNowLinkSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SignInPageSelector object.
     */
    public SignInPageSelector() {
        initSignInPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getEmailInputSelector() {
        return emailInputSelector;
    }

    public By getPasswordInputSelector() {
        return passwordInputSelector;
    }

    public By getSignInSelector() {
        return signInSelector;
    }

    public By getSignUpNowLinkSelector() {
        return signUpNowLinkSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSignInPageOptions() {
        signInSelector = By.cssSelector("a[data-qaid='QA_GN_SavedSearches_SignIn']");
        signUpNowLinkSelector = By.xpath("//a[@href='#signUpForm-signup']");
        emailInputSelector = By.xpath("//input[contains(@id, 'email')]");
        passwordInputSelector = By.xpath("//input[@type='password']");
    }
}
