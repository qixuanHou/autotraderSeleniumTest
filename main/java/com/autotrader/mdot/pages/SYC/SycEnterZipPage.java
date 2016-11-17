package com.autotrader.mdot.pages.SYC;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/17/2015.
 */
public class SycEnterZipPage {

    public WebDriver driver;
    public WebDriverWait wait;
    public String zipCode = "30032";
    WaitFor waitFor;
    SycEnterZipPageSelector selector;

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getZipCodeSelector());
    }
    public boolean checkOnCorrectPage(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getZipCodeSelector()));
        return driver.findElement(selector.getZipCodeSelector()).isDisplayed();
    }

    public SycEnterZipPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.selector = new SycEnterZipPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void enterZipCode(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getZipCodeSelector())).sendKeys(zipCode);
    }

    public SycSelectAdPackagePage clickSubmitZipButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSubmitZipButtonSelector())).click();
        return new SycSelectAdPackagePage(driver);
    }

    public boolean checkZipValidationError(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getValidationErrorMessagesSelector(), "Please enter a valid ZIP Code."));
    }

}
