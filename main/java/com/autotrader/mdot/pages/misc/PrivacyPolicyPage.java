package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/12/2015.
 */
public class PrivacyPolicyPage {

    public WebDriver driver;
    public WebDriverWait wait;
    PrivacyPolicyPageSelector selector;

    public PrivacyPolicyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.selector = new PrivacyPolicyPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean checkOnCorrectPage(){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getPrivacyPolicyHeaderSelector(), "Autotrader Privacy Statement"));
        return driver.findElement(selector.getPrivacyPolicyHeaderSelector()).getText().contains("Autotrader Privacy Statement");
    }
}
