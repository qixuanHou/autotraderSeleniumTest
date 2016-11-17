package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 9/14/2015.
 */
public class EditYourAdPage {

    WebDriver driver;
    WebDriverWait wait;
    WaitFor waitFor;
    JavascriptExecutor jse;
    EditYourAdPageSelector selector;

    public EditYourAdPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new EditYourAdPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean checkOnCorrectPage(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getRemoveAdButtonSelector()));
        return driver.findElement(selector.getRemoveAdButtonSelector()).isDisplayed();
    }

    public void waitForObject(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getRemoveAdButtonSelector()));
        waitFor.waitForExpectedConditions(driver, selector.getRemoveAdButtonSelector());
    }

    public RemoveYourAdPage cancelAd(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getRemoveAdButtonSelector()));
        driver.findElement(selector.getRemoveAdButtonSelector()).click();
        return new RemoveYourAdPage(driver);
    }

}
