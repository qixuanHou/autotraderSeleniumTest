package com.autotrader.mdot.pageselector;

import org.openqa.selenium.By;

/**
 * Created by qhou on 10/22/2015.
 */
public class CalculatePaymentPageSelector {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private By amountOwnedOnTradeInputSelector;
    private By calculateButtonSelector;
    private By downPaymentInputSelector;
    private By interestRateInputSelector;
    private By monthSelector;
    private By priceInputSelector;
    private By resetButtonSelector;
    private By tradeInValueInputSelector;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * Creates a new CalculatePaymentPageSelector object.
     */
    public CalculatePaymentPageSelector() {
        initCalculatePaymentPageOptions();
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public By getAmountOwnedOnTradeInputSelector() {
        return amountOwnedOnTradeInputSelector;
    }

    public By getCalculateButtonSelector() {
        return calculateButtonSelector;
    }

    public By getDownPaymentInputSelector() {
        return downPaymentInputSelector;
    }

    public By getInterestRateInputSelector() {
        return interestRateInputSelector;
    }

    public By getMonthSelector() {
        return monthSelector;
    }

    public By getPriceInputSelector() {
        return priceInputSelector;
    }

    public By getResetButtonSelector() {
        return resetButtonSelector;
    }

    public By getTradeInValueInputSelector() {
        return tradeInValueInputSelector;
    }

    public void initCalculatePaymentPageOptions() {
        interestRateInputSelector = By.xpath("//input[contains(@id, 'interestRate')]");
        priceInputSelector = By.xpath("//input[contains(@id, 'vehiclePrice')]");
        downPaymentInputSelector = By.xpath("//input[contains(@id, 'downPayment')]");
        tradeInValueInputSelector = By.xpath("//input[contains(@id, 'tradeInValue')]");
        amountOwnedOnTradeInputSelector = By.xpath("//input[contains(@id, 'amountOwedAtTradeIn')]");
        calculateButtonSelector = By.xpath("//a[contains(text(),'Calculate')]");
        resetButtonSelector = By.xpath("//a[contains(text(),'Reset')]");
        monthSelector =
            By.xpath(
                "//table[@id='genericCalculatorForm-genericCalculator-calculatorSlidePanel-j_id_6-j_id_v-j_id_x-j_id_21-calcFields-j_id_28-j_id_2a-j_id_2g-lengthOfLoan']/tbody/tr/td/label");
    }
}
