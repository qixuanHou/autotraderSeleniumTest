package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by mwstratton on 11/23/2015.
 */
public class SycLoginPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By adIdInputSelector;
    private By cancelButtonSelector;

    private By emailInputSelector;
    private By loginButtonSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new SycLoginPageSelector object.
     */
    public SycLoginPageSelector() {
        initSycLoginPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getAdIdInputSelector() {
        return adIdInputSelector;
    }

    public By getCancelButtonSelector() {
        return cancelButtonSelector;
    }

    public By getEmailInputSelector() {
        return emailInputSelector;
    }

    public By getLoginButtonSelector() {
        return loginButtonSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initSycLoginPageOptions() {
        emailInputSelector = By.xpath("//input[contains(@id, 'email')]");
        adIdInputSelector = By.xpath("//input[contains(@id, 'adId')]");
        cancelButtonSelector = By.xpath("//a[contains(text(), 'Cancel')]");
        loginButtonSelector = By.xpath("//input[@data-qaid = 'j_id_c5']");
    }
}
