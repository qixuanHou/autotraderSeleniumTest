package com.autotrader.mdot.pages.SYC;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.pages.misc.HomeSidePage;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/12/2015.
 */
public class SycLandingPage {

    public WebDriver driver;
    public WebDriverWait wait;
    public String baseUrl = "https://m-test2.autotrader.com/sell-your-car/index.xhtml";
    WaitFor waitFor;
    SycLandingPageSelector selector;

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getPlaceYourAdButtonSelector());
    }

    public SycLandingPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.selector = new SycLandingPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getPlaceYourAdButtonSelector())).isDisplayed();
    }

    public SycEnterZipPage clickPlaceYourAd(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getPlaceYourAdButtonSelector())).click();
        return new SycEnterZipPage(driver);
    }

    public HomeSidePage clickHamburgerButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getHamburgerButtonSelector())).click();
        return new HomeSidePage(driver);
    }
}
