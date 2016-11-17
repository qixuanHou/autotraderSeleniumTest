package com.autotrader.mdot.pages.FYC;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.pages.misc.HomeMainPage;
import com.autotrader.mdot.utilities.WaitFor;
import com.autotrader.mdot.utilities.mDotElements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/19/2015.
 */
public class LocationAndRadiusSliderPage {

    WebDriver driver;
    WebDriverWait wait;
    WaitFor waitFor;
    JavascriptExecutor jse;
    LocationAndRadiusSliderPageSelector selector;

    String radiusString = "input[id*='searchRadius-%1$d']";
    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getDoneButtonSelector());
    }

    public void selectCheckbox(String byId){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", driver.findElement(By.cssSelector(byId)));
    }

    public LocationAndRadiusSliderPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new LocationAndRadiusSliderPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void selectRadius(mDotElements.Radius radius){
        selectCheckbox(String.format(radiusString, radius.getPosition()));
    }

    public HomeMainPage clickOnDone(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getDoneButtonSelector())).click();
        return new HomeMainPage(driver);
    }

    public SearchResultsLandingPage clickOnDoneToGetToNationalSrp(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getDoneButtonNationalSrpSelector())).click();
        return new SearchResultsLandingPage(driver);
    }

    public void setMinPrice(String text){
        driver.findElement(selector.getMinPriceInputSelector()).sendKeys(text);
    }

    public void setMaxPrice(String text){
        driver.findElement(selector.getMaxPriceInputSelector()).sendKeys(text);
    }

    public void setKeywords(String text){
        driver.findElement(selector.getKeywordInputSelector()).sendKeys(text);
    }

    public void setZip(String text){
        WebElement zipBox = driver.findElement(selector.getZipInputSelector());
        zipBox.click();
        zipBox.sendKeys(text);
    }



}
