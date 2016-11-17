package com.autotrader.mdot.pages.SYC;

import com.autotrader.mdot.pageselector.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 9/29/2015.
 */
public class SycViewOrderPage {

    public WebDriver driver;
    public WebDriverWait wait;
    SycViewOrderPageSelector selector;

    public SycViewOrderPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.selector = new SycViewOrderPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getReviewYourOrderBannerSelector(), "Review Your Order"));
    }

}
