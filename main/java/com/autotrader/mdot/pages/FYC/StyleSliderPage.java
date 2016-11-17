package com.autotrader.mdot.pages.FYC;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.pages.misc.HomeMainPage;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/19/2015.
 */
public class StyleSliderPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor jse;
    WaitFor waitFor;
    StyleSliderPageSelector selector;

    public StyleSliderPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new StyleSliderPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getApplyButtonSelector());
    }

    public void selectStyle(String style) {
        List<WebElement> choice = driver.findElements(selector.getChoiceSelector());
        for(WebElement e : choice){
            if(e.getText().equals(style)){
                e.click();
                break;
            }
        }
    }

    public HomeMainPage clickApplyButton(){
        driver.findElement(selector.getApplyButtonSelector()).click();
        return new HomeMainPage(driver);
    }

}
