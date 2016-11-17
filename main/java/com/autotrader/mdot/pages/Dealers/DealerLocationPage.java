package com.autotrader.mdot.pages.Dealers;

import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.autotrader.mdot.pageselector.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by qhou on 9/8/2015.
 */
public class DealerLocationPage {
    WebDriver driver;
    WebDriverWait wait;
    WebDriverWait driverWait;
    WaitFor waitFor;
    JavascriptExecutor jse;
    DealerLocationPageSelector selector;

    public DealerLocationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.driverWait = new WebDriverWait(driver, 20);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new DealerLocationPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getZipCodeInputSelector())).isDisplayed();
    }

    public boolean verifyUseCurrentLocationButton(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getUseCurrentLocationSelector())).isDisplayed();
    }

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getZipCodeInputSelector());
    }


    public DealerSearchResultsPage clickDone(){
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getDoneButtonSelector())).click();
        return new DealerSearchResultsPage(driver);
    }

    public void enterZipCode(String text){
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getZipCodeInputSelector())).clear();
        driver.findElement(selector.getZipCodeInputSelector()).sendKeys(text);
    }

    public void chooseRadius(String mileChoice){
        List<WebElement> choice = driver.findElements(selector.getRadiusListsSelector());
        for(WebElement e : choice){
            if(e.getText().contains(mileChoice)){
                driverWait.until(ExpectedConditions.elementToBeClickable(e)).click();
                break;
            }
        }
    }
}
