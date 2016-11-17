package com.autotrader.mdot.pageselector;

import com.autotrader.mdot.pages.misc.RetrievePasswordPage;

import org.openqa.selenium.By;

/**
 * Created by mwstratton on 11/23/2015.
 */
public class RetrievePasswordPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By emailInputSelector;
    private By headerSelector;
    private By submitButtonSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new RetrievePasswordPageSelector object.
     */
    public RetrievePasswordPageSelector() {
        initRetrievePasswordPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getEmailInputSelector() {
        return emailInputSelector;
    }

    public By getHeaderSelector() {
        return headerSelector;
    }

    public By getSubmitButtonSelector() {
        return submitButtonSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initRetrievePasswordPageOptions() {
        emailInputSelector = By.xpath("//input[contains(@id, 'retrievePasswordEmail')]");
        submitButtonSelector = By.xpath("//input[@data-qaid = 'j_id_fd']");
        headerSelector = By.xpath("//span[contains(text(), 'Forgot your password?')]");
    }
}
