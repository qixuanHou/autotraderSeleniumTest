package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/12/2015.
 */
public class SignUpPage {

    public WebDriver driver;
    public WebDriverWait wait;
    SignUpPageSelector selector;

    WaitFor waitFor;

    private String testEmail = "ohioborn1991@yahoo.com";
    private String testPass = "123aaa";

    public String passForGeneratedEmail = "Aaaaaa07";
    public String generatedEmail = "";

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.selector = new SignUpPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getEmailInputSelector());
    }

    public boolean checkOnCorrectPage(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getEmailInputSelector()));
        return driver.findElement(selector.getEmailInputSelector()).isDisplayed();
    }
    public void enterEmailAddress(String text){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getEmailInputSelector()));
        driver.findElement(selector.getEmailInputSelector()).sendKeys(text);
    }

    public void reEnterEmailAddress(String text){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getReEnterEmailInputSelector()));
        driver.findElement(selector.getReEnterEmailInputSelector()).sendKeys(text);
    }

    public void enterPassword(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getPasswordInputSelector()));
        driver.findElement(selector.getPasswordInputSelector()).sendKeys(passForGeneratedEmail);
    }

    public void reEnterPassword(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getReEnterPasswordInputSelector()));
        driver.findElement(selector.getReEnterPasswordInputSelector()).sendKeys(passForGeneratedEmail);
    }

    public VisitorAgreementPage clickSignUpButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSignUpButtonSelector()));
        driver.findElement(selector.getSignUpButtonSelector()).click();
        return new VisitorAgreementPage(driver);
    }

    public String getPassForGeneratedEmail(){
        return this.passForGeneratedEmail;
    }

    public boolean validateEmailError(){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getEmailValidationErrorSelector(), "Email confirmation is required."));
        return driver.findElement(selector.getEmailValidationErrorSelector()).getText().contains("Email confirmation is required.");
    }

    public boolean validatePasswordError(){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getPasswordValidationErrorSelector(), "Password confirmation is required."));
        return driver.findElement(selector.getPasswordValidationErrorSelector()).getText().contains("Password confirmation is required.");
    }
}
