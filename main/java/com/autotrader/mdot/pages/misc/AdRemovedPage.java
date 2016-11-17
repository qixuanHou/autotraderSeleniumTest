package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 9/14/2015.
 */
public class AdRemovedPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor jse;
    AdRemovedPageSelector selector;

    public AdRemovedPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new AdRemovedPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean checkOnCorrectPage(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getHomeButtonSelector()));
        return driver.findElement(selector.getHomeButtonSelector()).isDisplayed();
    }

    public HomeMainPage clickHomeButton(){
        driver.findElement(selector.getHomeButtonSelector()).click();
        return new HomeMainPage(driver);
    }



}
