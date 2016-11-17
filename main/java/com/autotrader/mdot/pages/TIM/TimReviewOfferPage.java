package com.autotrader.mdot.pages.TIM;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TimReviewOfferPage
{
    WebDriver driver;
    WebDriverWait wait;
    WaitFor waitFor;
    TimReviewOfferPageSelector selector;

    public TimReviewOfferPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.selector = new TimReviewOfferPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getSubmitButtonSelector());
    }
    public boolean checkOnCorrectPage()
    {
        return driver.findElement(selector.getSubmitButtonSelector()).isDisplayed();
    }
    public void clickSubmitButton()
    {
        driver.findElement(selector.getSubmitButtonSelector()).click();
    }

}
