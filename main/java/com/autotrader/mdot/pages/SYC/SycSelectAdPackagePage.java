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
public class SycSelectAdPackagePage {

    public WebDriver driver;
    public WebDriverWait wait;
    WaitFor waitFor;
    SycSelectAdPackagePageSelector selector;

    public SycSelectAdPackagePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        waitFor = new WaitFor(driver);
        this.selector = new SycSelectAdPackagePageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getSelectMOBDeluxeAdSelector())).isDisplayed();
    }

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getSelectMOBEnhancedAdSelector());
    }

    public SycRequiredInfoPage clickSelectMOBPremierAd(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSelectMOBPremierAdSelector())).click();
        return new SycRequiredInfoPage(driver);
    }

    public SycRequiredInfoPage clickSelectMOBEnhancedAd(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSelectMOBEnhancedAdSelector())).click();
        return new SycRequiredInfoPage(driver);
    }

    public SycRequiredInfoPage clickSelectMOBDeluxeAd(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSelectMOBDeluxeAdSelector())).click();
        return new SycRequiredInfoPage(driver);
    }

    public SycRequiredInfoPage clickSelectMOBStandardAd(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSelectMOBStandardAdSelector())).click();
        return new SycRequiredInfoPage(driver);
    }

}
