package com.autotrader.mdot.pages.SYC;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/18/2015.
 */
public class SycCheckoutPage {

    public WebDriver driver;
    public WebDriverWait wait;
    WaitFor waitFor;
    SycCheckoutPageSelector selector;

    public boolean checkOnCorrectPage(){
        return driver.findElement(selector.getCardTypeSelector()).isDisplayed();
    }

    public SycCheckoutPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.selector = new SycCheckoutPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitForObject(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getCardTypeSelector()));
        waitFor.waitForExpectedConditions(driver, selector.getCardTypeSelector());
    }

    public void selectCardType(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getCardTypeSelector(), text));
        new Select(driver.findElement(selector.getCardTypeSelector())).selectByVisibleText(text);
    }

    public void setCardNumber(String text){
        driver.findElement(selector.getCardNumberInputSelector()).clear();
        driver.findElement(selector.getCardNumberInputSelector()).sendKeys(text);
    }

    public void setSecurityCode(String text){
        driver.findElement(selector.getSecurityCodeInputSelector()).clear();
        driver.findElement(selector.getSecurityCodeInputSelector()).sendKeys(text);
    }

    public void selectExpirationMonth(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getExpirationMonthSelector(), text));
        new Select(driver.findElement(selector.getExpirationMonthSelector())).selectByVisibleText(text);
    }

    public void selectExpirationYear(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getExpirationYearSelector(), text));
        new Select(driver.findElement(selector.getExpirationYearSelector())).selectByVisibleText(text);
    }

    public void checkSavePaymentInformation(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSavePaymentInformationSelector())).click();
    }

    public void setFirstName(String text){
        driver.findElement(selector.getFirstNameInputSelector()).clear();
        driver.findElement(selector.getFirstNameInputSelector()).sendKeys(text);
    }

    public void setLastName(String text){
        driver.findElement(selector.getLastNameInputSelector()).clear();
        driver.findElement(selector.getLastNameInputSelector()).sendKeys(text);
    }

    public void setAddressLine(String text){
        driver.findElement(selector.getAddressLine1InputSelector()).clear();
        driver.findElement(selector.getAddressLine1InputSelector()).sendKeys(text);
    }

    public void setCity(String text){
        driver.findElement(selector.getCityInputSelector()).clear();
        driver.findElement(selector.getCityInputSelector()).sendKeys(text);
    }

    public void selectState(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getStateSelector(), text));
        new Select(driver.findElement(selector.getStateSelector())).selectByVisibleText(text);
    }

    public void setZipCode(String text){
        driver.findElement(selector.getZipCodeInputSelector()).clear();
        driver.findElement(selector.getZipCodeInputSelector()).sendKeys(text);
    }

    public void clickCancelButton(){
        driver.findElement(selector.getCancelButton()).click();
    }

    public SycOrderConfirmationPage clickSubmitButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSubmitButton())).click();
        return new SycOrderConfirmationPage(driver);
    }

}
