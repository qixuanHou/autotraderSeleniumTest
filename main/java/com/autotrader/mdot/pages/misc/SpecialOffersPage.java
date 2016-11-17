package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.SpecialOffersPageSelector;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mwstratton on 11/23/2015.
 */
public class SpecialOffersPage {

    WebDriver driver;
    WebDriverWait wait;
    WaitFor waitFor;
    JavascriptExecutor jse;
    SpecialOffersPageSelector selector;

    public SpecialOffersPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new SpecialOffersPageSelector();
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getSpecialOffersHeaderSelector())).get(1).getText().contains("Special Offers");
    }

}
