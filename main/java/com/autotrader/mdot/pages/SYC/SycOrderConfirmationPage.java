package com.autotrader.mdot.pages.SYC;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/31/2015.
 */
public class SycOrderConfirmationPage {

    public WebDriver driver;
    public WebDriverWait wait;
    WaitFor waitFor;
    SycOrderConfirmationPageSelector selector;

    public SycOrderConfirmationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.selector = new SycOrderConfirmationPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getEditYourAdButtonSelector())).isDisplayed();
    }

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getEditYourAdButtonSelector());
    }

    public String returnAdIdNumber(){
        String result1 = "";
        List<WebElement> choice = driver.findElements(selector.getChoiceSelector());
        for(WebElement e : choice){
            result1 = e.getText();
            result1 = result1.replaceAll("\\D+","");
            if(result1.contains("Save")){
                break;
            }
        }
        return result1;
    }

    public SycManageYourAdPage clickOnEditYourAd(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getEditYourAdButtonSelector())).click();
        return new SycManageYourAdPage(driver);
    }


}
