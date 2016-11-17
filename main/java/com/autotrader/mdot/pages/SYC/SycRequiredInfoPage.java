package com.autotrader.mdot.pages.SYC;

import com.autotrader.mdot.pageselector.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.lang.String;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/17/2015.
 */
public class SycRequiredInfoPage {

    public WebDriver driver;
    public WebDriverWait wait;
    public String premierAdId = "125188";
    public String deluxeAdId = "125192";
    public String standardAdId = "125190";
    public String enhancedAdId = "126146";
    SycRequiredInfoPageSelector selector;

    public SycRequiredInfoPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.selector = new SycRequiredInfoPageSelector();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getYearInputSelector())).isDisplayed();
    }

    public void selectYear(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getYearInputSelector(), text));
        new Select(driver.findElement(selector.getYearInputSelector())).selectByVisibleText(text);
    }

    public void selectMake(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector.getMakeInputSelector()));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getMakeInputSelector(), text));
        new Select(driver.findElement(selector.getMakeInputSelector())).selectByVisibleText(text);
    }

    public void selectModel(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getModelInputSelector(), text));
        new Select(driver.findElement(selector.getModelInputSelector())).selectByVisibleText(text);
    }

    public void selectBodyStyle(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getBodyStyleInputSelector(), text));
        new Select(driver.findElement(selector.getBodyStyleInputSelector())).selectByVisibleText(text);
    }

    public void setMileageInputField(String text){
        driver.findElement(selector.getMileageInputFieldSelector()).clear();
        driver.findElement(selector.getMileageInputFieldSelector()).sendKeys(text);
    }

    public void setPriceInputField(String text){
        driver.findElement(selector.getPriceInputFieldSelector()).clear();
        driver.findElement(selector.getPriceInputFieldSelector()).sendKeys(text);
    }

    public void setPhoneInputField(String text){
        driver.findElement(selector.getPhoneInputFieldSelector()).clear();
        driver.findElement(selector.getPhoneInputFieldSelector()).sendKeys(text);
    }

    public void checkMobileNumberBox(){
       WebElement e = driver.findElement(selector.getMobileNumberCheckInputSelector());
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0," + e.getLocation().x + ")");
        e.click();
    }

    public void checkMobileContactBox(){
        WebElement e = driver.findElement(selector.getMobileContactCheckInputSelector());
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+e.getLocation().x+")");
        e.click();
    }

    public void checkNoMobileContactBox(){
        WebElement e = driver.findElement(selector.getNoMobileNumberCheckInputSelector());
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+e.getLocation().x+")");
        e.click();
    }

    public void setEmailAddressInputField(String text){

        driver.findElement(selector.getEmailAddressInputFieldSelector()).clear();
        driver.findElement(selector.getEmailAddressInputFieldSelector()).sendKeys(text);
    }

    public void setSecurityQuestionInputSelector(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getSecurityQuestionInputSelector(), text));
        new Select(driver.findElement(selector.getSecurityQuestionInputSelector())).selectByVisibleText(text);
    }

    public void setAnswerInputField(String text){
        driver.findElement(selector.getAnswerInputFieldSelector()).clear();
        driver.findElement(selector.getAnswerInputFieldSelector()).sendKeys(text);
    }

    public SycOptionalInfoPage clickNextOptionalInfoButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getNextOptionalInfoButtonSelector())).click();
        return new SycOptionalInfoPage(driver);
    }

    public boolean checkYearValidationError(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getYearValidationErrorSelector(), "Please select a year."));
    }

    public boolean checkMakeValidationError(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getMakeValidationErrorSelector(), "Please select a make."));
    }

    public boolean checkModelValidationError(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getModelValidationErrorSelector(), "Please select a model."));
    }

    public boolean checkBodyStyleValidationError(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getBodyStyleValidationErrorSelector(), "Please select a body style."));
    }

    public boolean checkMileageValidationError(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getMileageValidationErrorSelector(), "Please enter only numbers for mileage."));
    }

    public boolean checkPhoneValidationError(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getPhoneValidationErrorSelector(), "Please provide a valid phone number."));
    }

    public boolean checkPhoneTenDigitsValidationError(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getPhoneValidationErrorSelector(), "Please enter a phone number with 10 digits."));
    }

    public boolean checkPriceValidationError(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getPriceValidationErrorSelector(), "Please provide a valid price."));
    }

    public boolean checkMobileNumberCheckValidationError(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getMobileCheckValidationErrorSelector(), "Please specify if this is a Mobile Number"));
    }

    public boolean checkContactValidationError(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getMobileContactValidationErrorSelector(), "Please specify an Answer"));
    }

    public boolean checkEmailValidationError(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getEmailValidationErrorSelector(), "Please enter a valid email address."));
    }

    public boolean checkSecurityQuestionValidationError(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getSecurityQuestionValidationErrorSelector(), "Select one"));
    }

    public boolean checkSecurityQuestionAnswerValidationError(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getSecurityQuestionAnswerValidationErrorSelector(), "Please provide a valid security answer."));
    }


    //<editor-fold desc="Verify Premier Ad ID">
    public boolean checkPremierAdId(String getUrl){
        boolean verified;
        if(!getUrl.contains(premierAdId)){
            verified = false;
        }else{
            verified = true;
        }
        return verified;
    }
    //</editor-fold>

    //<editor-fold desc="Verify Deluxe Ad ID">
    public boolean checkDeluxeAdId(String getUrl){
        boolean verified;
        if(!getUrl.contains(deluxeAdId)){
            verified = false;
        }else{
            verified = true;
        }
        return verified;
    }
    //</editor-fold>

    //<editor-fold desc="Verify Standard Ad ID">
    public boolean checkStandardAdId(String getUrl){
        boolean verified;
        if(!getUrl.contains(standardAdId)){
            verified = false;
        }else{
            verified = true;
        }
        return verified;
    }
    //</editor-fold>

    //<editor-fold desc="Verify Enhanced Ad ID">
    public boolean checkEnhancedAdId(String getUrl){
        boolean verified;
        if(!getUrl.contains(enhancedAdId)){
            verified = false;
        }else{
            verified = true;
        }
        return verified;
    }
    //</editor-fold>

    //</editor-fold>

}
