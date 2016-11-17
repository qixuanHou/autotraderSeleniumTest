package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class VisitorAgreementPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By acceptAgreementButtonSelector;
    private By visitorAgreementHeaderSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new VisitorAgreementPageSelector object.
     */
    public VisitorAgreementPageSelector() {
        initVisitorAgreementPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getAcceptAgreementButtonSelector() {
        return acceptAgreementButtonSelector;
    }

    public By getVisitorAgreementHeaderSelector() {
        return visitorAgreementHeaderSelector;
    }

    /**
     * TODO: Enter Javadoc
     */
    public void initVisitorAgreementPageOptions() {
        acceptAgreementButtonSelector = By.xpath("//input[@data-qaid='j_id_cp']");
        visitorAgreementHeaderSelector = By.cssSelector(".atcui-center-panel.atcui-header-item");
    }
}
