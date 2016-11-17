package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.Environments;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by cher1 on 7/16/2015.
 */
public class SignInPage {
    // Declare driver
    public WebDriver driver;
    public WebDriverWait wait;
    WaitFor waitFor;
    SignInPageSelector selector;

    // Constructor
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.selector = new SignInPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // Call utilities folder
    Environments url = new Environments();


    // Page objects and declarations


    public void waitForObject() {
        waitFor.waitForExpectedConditions(driver, selector.getSignInSelector());
    }

    public SignUpPage clickSignUpNow(){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getSignUpNowLinkSelector())).click();
        return new SignUpPage(driver);
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getSignInSelector())).isDisplayed();
    }

    public void enterEmail(String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getEmailInputSelector())).clear();
        driver.findElement(selector.getEmailInputSelector()).sendKeys(text);
    }

    public void enterPassword(String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getPasswordInputSelector())).clear();
        driver.findElement(selector.getPasswordInputSelector()).sendKeys(text);
    }

    public HomeMainPage clickSignIn(){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getSignInSelector()));
        driver.findElement(selector.getSignInSelector()).click();
        return new HomeMainPage(driver);
    }

    public VehicleDetailsPage clickSignInForSaveListing(){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getSignInSelector()));
        driver.findElement(selector.getSignInSelector()).click();
        return new VehicleDetailsPage(driver);
    }




}
