package com.autotrader.mdot.pages.TIM;

import com.autotrader.mdot.pageselector.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 10/14/2015.
 */
public class TimRetrieveOfferPage {

    public WebDriver driver;
    public WebDriverWait wait;
    TimRetrieveOfferPageSelector selector;

    public TimRetrieveOfferPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.selector = new TimRetrieveOfferPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean checkOnCorrectPage(){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getTimRetrieveOfferHeaderSelector(), "Review Existing Instant Cash Offer"));
        return driver.findElement(selector.getTimRetrieveOfferHeaderSelector()).getText().contains("Review Existing Instant Cash Offer");
    }

}
