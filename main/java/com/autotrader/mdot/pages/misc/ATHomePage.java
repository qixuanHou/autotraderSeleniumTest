package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/17/2015.
 */
public class ATHomePage {

    WebDriver driver;
    WebDriverWait wait;
    String currentUrl = "";
    ATHomePageSelector selector;


    public boolean checkOnCorrectPage(){
        currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("MOBILETOATC");
    }

    public ATHomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.selector = new ATHomePageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
