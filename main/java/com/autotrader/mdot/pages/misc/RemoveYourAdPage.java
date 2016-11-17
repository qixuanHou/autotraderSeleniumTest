package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 9/14/2015.
 */
public class RemoveYourAdPage {

    public WebDriver driver;
    public WebDriverWait wait;
    RemoveYourAdPageSelector selector;

    public RemoveYourAdPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.selector = new RemoveYourAdPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public AdRemovedPage clickRemoveAdListing(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getRemoveAdListingButtonSelector()));
        driver.findElement(selector.getRemoveAdListingButtonSelector()).click();
        return new AdRemovedPage(driver);
    }

}
