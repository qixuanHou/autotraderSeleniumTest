package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.String;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/12/2015.
 */
public class FraudAwarenessPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor jse;
    FraudAwarenessPageSelector selector;

    private String urlKeyWord = "fraudAwareness";

    public FraudAwarenessPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new FraudAwarenessPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean checkOnCorrectPage(){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getFraudAwarenessHeaderSelector(), "Fraud Awareness"));
        return driver.findElement(selector.getFraudAwarenessHeaderSelector()).getText().contains("Fraud Awareness");
    }
}
