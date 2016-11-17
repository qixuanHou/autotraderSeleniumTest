package com.autotrader.mdot.pages.TIM;

import com.autotrader.mdot.pageselector.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by jmcox1 on 7/9/2015.
 */
public class TimOfferPage
{
    WebDriver driver;
    WebDriverWait wait;
    TimOfferPageSelector selector;


    public TimOfferPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.selector = new TimOfferPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public boolean checkOnOfferPage()
    {
        return driver.findElement(selector.getCongratulationsMessageSelector()).isDisplayed();
    }

    public boolean validateTimOfferPageBanner(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector.getInstantCashOfferBannerSelector())).isDisplayed();
    }
}
