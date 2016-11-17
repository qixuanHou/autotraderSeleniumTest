package com.autotrader.mdot.pages.FYC;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.autotrader.mdot.pages.misc.HomeMainPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/19/2015.
 */
public class NewUsedCertifiedSliderPage {

    WebDriver driver;
    WebDriverWait wait;
    WaitFor waitFor;
    JavascriptExecutor jse;
    NewUsedCertifiedSliderPageSelector selector;

    public NewUsedCertifiedSliderPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new NewUsedCertifiedSliderPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getAnySelector());
    }

    public void selectAny(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getAnySelector())).click();
    }

    public void selectUsed(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getUsedSelector())).click();
    }

    public void selectNew(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getNewSelector())).click();
    }

    public void selectCertified(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getCertifiedSelector())).click();
    }

    public HomeMainPage clickApplyButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getApplyButtonSelector())).click();
        return new HomeMainPage(driver);
    }

    public void clickClearButton() throws InterruptedException{
        driver.findElements(selector.getClearButtonSelector()).get(1).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public HomeMainPage clickCancelButton() {
        driver.findElements(selector.getCancelButtonSelector()).get(1).click();
        return new HomeMainPage(driver);
    }

    public boolean confirmAnyDisplayed() {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getAnySelector(), "Any"));
    }

    public boolean confirmNewDisplayed() {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getNewSelector(), "New"));
        //return driver.findElement(newSelector).getText().contains("New");
    }

    public boolean confirmUsedDisplayed() {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getUsedSelector(), "Used"));
    }

    public boolean confirmCertifiedDisplayed() {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getCertifiedSelector(), "Certified"));
    }


}
