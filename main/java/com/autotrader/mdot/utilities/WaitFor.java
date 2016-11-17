package com.autotrader.mdot.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


/**
 * Created by cher1 on 7/14/2015.
 */
public class WaitFor {

    WebDriver driver;
    WebDriverWait wait;

    public WaitFor(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // Wait for a certain element to be clickable
    public void waitForExpectedConditions(WebDriver driver, By by) {
        WebElement ruThere = driver.findElement(by);
        (new WebDriverWait(driver, 1200)).until(ExpectedConditions.elementToBeClickable(ruThere));
    }

    // Waits for the DOM to be ready
    public void waitForDomReady(WebDriver driver) {
        ((JavascriptExecutor)driver).executeScript("return document.readyState.match(\"complete\")");
    }

    public void waitForDocumentReady(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(documentReadyCompleteCondition);
    }

    public void staleElementClick(By by){
        long time = System.currentTimeMillis() + 30000;
        while(System.currentTimeMillis() < time){
            try{
                driver.findElement(by).click();
                break;
            }catch(StaleElementReferenceException e){
            }
        }
    }

    public void clickWithForce(WebElement ele){
        long time = System.currentTimeMillis() + 30000;
        while(System.currentTimeMillis() < time){
            try{
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
            }catch(Exception e){

            }
        }
    }

    public void clickUniqueWithForce(By by){
        long time = System.currentTimeMillis() + 30000;
        while(System.currentTimeMillis() < time){
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", by);
            }catch(Exception e){

            }
        }
    }

    private final ExpectedCondition<Boolean> documentReadyCompleteCondition = new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver webDriver) {
            return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
        }
    };
}
