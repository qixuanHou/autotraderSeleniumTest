package com.autotrader.mdot.pages.TIM;

import com.autotrader.mdot.pageselector.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class TimContactInfoPage
{
    WebDriver driver;
    WebDriverWait wait;
    TimContactInfoPageSelector selector;


    public TimContactInfoPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.selector = new TimContactInfoPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public boolean checkOnCorrectPage()
    {
        return driver.findElement(selector.getFirstNameInputFieldSelector()).isDisplayed();
    }
    public void setFirstNameInputField( String text)
    {
        driver.findElement(selector.getFirstNameInputFieldSelector()).sendKeys(text);
    }
    public void setLastNameInputField( String text)
    {
        driver.findElement(selector.getLastNameInputFieldSelector()).sendKeys(text);
    }
    public void setEmailInputField( String text)
    {
        driver.findElement(selector.getEmailInputFieldSelector()).clear();
        driver.findElement(selector.getEmailInputFieldSelector()).sendKeys(text);
    }
    public void setEmailVerifyInputField( String text)
    {
        driver.findElement(selector.getEmailVerifyInputFieldSelector()).clear();
        driver.findElement(selector.getEmailVerifyInputFieldSelector()).sendKeys(text);
    }
    public void setPhoneInputField( String text)
    {
        driver.findElement(selector.getPhoneInputFieldSelector()).clear();
        driver.findElement(selector.getPhoneInputFieldSelector()).sendKeys(text);
    }
    public void clickBuyAnotherCheckBox()
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Object elementObject = driver.findElement(selector.getBuyAnotherCheckBoxSelector());
        js.executeScript("arguments[0].click();", elementObject);
    }
    public void selectReplacementMakeDropDown( String text)
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getReplacementMakeDropDownSelector(), text));
                new Select(driver.findElement(selector.getReplacementMakeDropDownSelector())).selectByVisibleText(text);

    }
    public void selectReplacementModelDropDown(String text)
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getReplacementModelDropDownSelector(), text));
                new Select(driver.findElement(selector.getReplacementModelDropDownSelector())).selectByVisibleText(text);
    }
    public void clickVisitAgreementCheckBox()
    {

        JavascriptExecutor js = (JavascriptExecutor)driver;
        Object elementObject = driver.findElement(selector.getVisitAgreementCheckBoxSelector());
        js.executeScript("arguments[0].click();", elementObject);
    }
    public void clickNextButton() throws InterruptedException
    {
        driver.findElement(selector.getNextButtonSelector()).click();
        Thread.sleep(500);
    }
    /*
    public void checkAllContactFormEmptyValidation()
    {
        assertTrue(driver.findElement(firstNameInputFieldValidation).getText().equals("This field is required."));
        assertTrue(driver.findElement(lastNameInputFieldValidation).getText().equals("This field is required."));
        assertTrue(driver.findElement(emailInputFieldValidation).getText().equals("This field is required."));
        assertTrue(driver.findElement(emailVerifyInputFieldValidation).getText().equals("This field is required."));
        assertTrue(driver.findElement(phoneInputFieldValidation).getText().equals("This field is required."));
    }
    */
    public boolean checkEmptyFirstNameInputFieldValidation(){
        return driver.findElement(selector.getFirstNameInputFieldValidationSelector()).getText().equals("This field is required.");
    }

    public boolean checkEmptyLastNameInputFieldValidation(){
        return driver.findElement(selector.getFirstNameInputFieldValidationSelector()).getText().equals("This field is required.");
    }
    public boolean checkEmptyEmailInputFieldValidation(){
        return driver.findElement(selector.getFirstNameInputFieldValidationSelector()).getText().equals("This field is required.");
    }
    public boolean checkEmptyEmailVerifyInputFieldValidation(){
        return driver.findElement(selector.getFirstNameInputFieldValidationSelector()).getText().equals("This field is required.");
    }
    public boolean checkEmptyPhoneInputFieldValidation(){
        return driver.findElement(selector.getFirstNameInputFieldValidationSelector()).getText().equals("This field is required.");
    }

    public boolean checkContactEmailsMatchValidation()
    {
         return driver.findElement(selector.getEmailVerifyInputFieldValidationSelector()).getText().equals("Email addresses do not match.");
    }

    public boolean checkContactEmailFormatValidation() {
        return driver.findElement(selector.getEmailInputFieldValidationSelector()).getText().equals("Please enter a valid email address.");
    }
    public boolean checkContactVerifyEmailFormatValidation() {
        return driver.findElement(selector.getEmailVerifyInputFieldValidationSelector()).getText().equals("Please enter a valid email address.");
    }

    public boolean checkPhoneFormatValidation()
    {
        return driver.findElement(selector.getPhoneInputFieldValidationSelector()).getText().equals("Please enter only digits.");
    }
}
