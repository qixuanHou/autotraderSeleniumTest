package com.autotrader.mdot.pages.SYC;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/17/2015.
 */
public class SycAddPhotosPage  {

    public WebDriver driver;
    public WebDriverWait wait;
    WaitFor waitFor;
    SycAddPhotosPageSelector selector;

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getNextReviewAdButtonSelector())).isDisplayed();
    }

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getNextReviewAdButtonSelector());
    }

    public SycAddPhotosPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.selector = new SycAddPhotosPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public SycReviewAdPage clickNextReviewAdButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getNextReviewAdButtonSelector())).click();
        return new SycReviewAdPage(driver);
    }

    public SycPhotoSuggestionsPage clickPhotoSuggestions(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getPhotoSuggestionsButtonSelector())).click();
        return new SycPhotoSuggestionsPage(driver);
    }

    public void clickUploadPhoto(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getUploadPhotosButtonSelector())).click();
    }

    public SycViewOrderPage clickCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getCheckoutButtonSelector())).click();
        return new SycViewOrderPage(driver);
    }

    public void uploadPhoto() throws AWTException{
        StringSelection ss = new StringSelection("I:\\Applications\\Accelerator\\qaphotos\\batmobile.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


}
