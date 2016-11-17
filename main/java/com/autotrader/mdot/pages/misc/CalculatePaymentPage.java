package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.String;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/12/2015.
 */
public class CalculatePaymentPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor jse;
    WaitFor waitFor;
    CalculatePaymentPageSelector selector;

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getCalculateButtonSelector());
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getCalculateButtonSelector())).isDisplayed();
    }

    public CalculatePaymentPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new CalculatePaymentPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void setInterestRateInput(String text){
        driver.findElement(selector.getInterestRateInputSelector()).clear();
        driver.findElement(selector.getInterestRateInputSelector()).sendKeys(text);
    }

    public void setPriceInput(String text){
        driver.findElement(selector.getPriceInputSelector()).clear();
        driver.findElement(selector.getPriceInputSelector()).sendKeys(text);
    }

    public void setDownPaymentInput(String text){
        driver.findElement(selector.getDownPaymentInputSelector()).clear();
        driver.findElement(selector.getDownPaymentInputSelector()).sendKeys(text);
    }

    public void setTradeInValueInput(String text){
        driver.findElement(selector.getTradeInValueInputSelector()).clear();
        driver.findElement(selector.getTradeInValueInputSelector()).sendKeys(text);
    }

    public void setAmountOwnedOnTradeInput(String text){
        driver.findElement(selector.getAmountOwnedOnTradeInputSelector()).clear();
        driver.findElement(selector.getAmountOwnedOnTradeInputSelector()).sendKeys(text);
    }

    public void clickCalculateButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getCalculateButtonSelector()));
        driver.findElement(selector.getCalculateButtonSelector()).click();
    }

    public void clickResetButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getResetButtonSelector()));
        driver.findElement(selector.getResetButtonSelector()).click();
    }

    public void selectMonth(String monthChoice){
        List<WebElement> choice = driver.findElements(selector.getMonthSelector());
        for(WebElement e : choice){
            if(e.getText().contains(monthChoice)){
                e.click();
                break;
            }
        }
    }

}
