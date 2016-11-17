package com.autotrader.mdot.pages.SYC;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.pages.misc.EditYourAdPage;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/17/2015.
 */
public class SycReviewAdPage {

    public WebDriver driver;
    public WebDriverWait wait;
    WaitFor waitFor;
    SycReviewAdPageSelector selector;

    public SycReviewAdPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.selector = new SycReviewAdPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void waitForObject(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getNextHeaderButtonSelector()));
        waitFor.waitForExpectedConditions(driver, selector.getNextHeaderButtonSelector());
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector.getNextHeaderButtonSelector())).isDisplayed();
    }

    public SycCheckoutPage clickNextCheckOutButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getNextCheckOutButtonSelector())).click();
        return new SycCheckoutPage(driver);
    }

    public SycEnhanceYourAdPage clickNextEnhanceAdButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getNextEnhanceAdButtonSelector())).click();
        return new SycEnhanceYourAdPage(driver);
    }

    public boolean verifyHeader(String year, String make, String model, String trim){
        String fullSelection = year + " " + make + " " + model + " " + trim;
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getAdHeaderSelector(), fullSelection));
    }

    public boolean verifyEditPhotosButton(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getEditPhotosButtonSelector())).isDisplayed();
    }

    public boolean verifyEmailSellerButton(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getEmailSellerButtonSelector())).isDisplayed();
    }

    public boolean verifyEditRequiredInfoButton(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getEditRequiredInfoButtonSelector())).isDisplayed();
    }

    public boolean verifyEditOptionalInfoButton(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getEditOptionalInfoButtonSelector())).isDisplayed();
    }

}
