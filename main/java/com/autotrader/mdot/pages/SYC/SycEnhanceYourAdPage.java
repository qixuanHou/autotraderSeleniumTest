package com.autotrader.mdot.pages.SYC;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/18/2015.
 */
public class SycEnhanceYourAdPage {

    public WebDriver driver;
    public WebDriverWait wait;
    WaitFor waitFor;
    SycEnhanceYourAdPageSelector selector;

    public boolean checkOnCorrectPage(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getNextCheckoutButtonSelector()));
        return driver.findElement(selector.getNextCheckoutButtonSelector()).isDisplayed();
    }

    public SycEnhanceYourAdPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.selector = new SycEnhanceYourAdPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void clickExtendYourRun(){
        WebElement e = driver.findElement(selector.getEnhancementsSelector());
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+e.getLocation().x+")");
        e.click();
    }

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getNextCheckoutButtonSelector());
    }

    public SycCheckoutPage clickNextCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getNextCheckoutButtonSelector()));
        driver.findElement(selector.getNextCheckoutButtonSelector()).click();
        return new SycCheckoutPage(driver);
    }

    public void checkFiveDaysUps(){
        List<WebElement> checkBox = driver.findElements(selector.getEnhancementsSelector());
        wait.until(ExpectedConditions.elementToBeClickable(checkBox.get(0)));
        checkBox.get(0);
    }

    public void checkOneWeekUps(){
        List<WebElement> checkBox = driver.findElements(selector.getEnhancementsSelector());
        wait.until(ExpectedConditions.elementToBeClickable(checkBox.get(1)));
        checkBox.get(1);
    }

    public void checkOneMonthUps(){
        List<WebElement> checkBox = driver.findElements(selector.getEnhancementsSelector());
        wait.until(ExpectedConditions.elementToBeClickable(checkBox.get(2)));
        checkBox.get(2);
    }

    public void checkRtsUps(){
        List<WebElement> checkBox = driver.findElements(selector.getEnhancementsSelector());
        wait.until(ExpectedConditions.elementToBeClickable(checkBox.get(3)));
        checkBox.get(3);
    }

    public void checkPremiumEhn(){
        List<WebElement> checkBox = driver.findElements(selector.getEnhancementsSelector());
        wait.until(ExpectedConditions.elementToBeClickable(checkBox.get(4)));
        checkBox.get(4);
    }

    public void checkKbbEhn(){
        List<WebElement> checkBox = driver.findElements(selector.getEnhancementsSelector());
        wait.until(ExpectedConditions.elementToBeClickable(checkBox.get(5)));
        checkBox.get(5);
    }

    /**
     * These methods below are for standard ad
     *
     */

    public void clickRtsUps(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getRtsUpsCheckBoxSelector()));
    }

    public void clickThumbnailCheckBox(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getThumbnailCheckBoxSelector())).click();
    }

    public boolean verifyRtsUpsCheckBox(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getRtsUpsCheckBoxSelector()));
        return driver.findElement(selector.getRtsUpsCheckBoxSelector()).isDisplayed();
    }

    public boolean verifyThumbnailCheckBox(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getThumbnailCheckBoxSelector()));
        return driver.findElement(selector.getThumbnailCheckBoxSelector()).isDisplayed();
    }


}
