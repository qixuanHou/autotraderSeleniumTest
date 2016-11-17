package com.autotrader.mdot.pages.TIM;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by mwstratton on 10/23/2015.
 */
public class TimInfoPage {

    WebDriver driver;
    WebDriverWait wait;
    WaitFor waitFor;
    TimInfoPageSelector selector;
    JavascriptExecutor jse;

    public TimInfoPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.selector = new TimInfoPageSelector();
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector.getInformationBoxTitleSelector())).isDisplayed();
    }

    public boolean verifyBulletInfo(String text) {
        boolean hammer = false;
        List<WebElement> choice = driver.findElements(selector.getInformationBulletPoints());
        for(WebElement e : choice){
            if(e.getText().contains(text)){
                hammer = true;
                break;
            }else{
                hammer = false;
            }
        }
        return hammer;
    }

    public boolean verifyInfoTitle(String text){
        boolean hammer = false;
        List<WebElement> choice = driver.findElements(selector.getInformationHeaderSelector());
        for(WebElement e : choice){
            if(e.getText().contains(text)){
                hammer = true;
                break;
            }else{
                hammer = false;
            }
        }
        return hammer;
    }

    public boolean verifyBoxHeader(String text){
        return driver.findElement(selector.getInformationBoxTitleSelector()).getText().contains(text);
    }

    }
