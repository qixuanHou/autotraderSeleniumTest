package com.autotrader.mdot.pages.Dealers;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by qhou on 9/8/2015.
 */
public class DsrpFilterPage {

    WebDriver driver;
    WaitFor wait;
    WebDriverWait driverWait;
    JavascriptExecutor jse;
    DsrpFilterPageSelector selector;

    public DsrpFilterPage(WebDriver driver){
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, 20);
        this.wait = new WaitFor(driver);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new DsrpFilterPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitForObject() {
        wait.waitForExpectedConditions(driver, selector.getApplyButtonSelector());
    }

    public void displayMakeDropDown() {
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElements(selector.getConfirmZipMakeKeywordSelector()).get(1)));
        driver.findElements(selector.getConfirmZipMakeKeywordSelector()).get(1).click();
    }

    public void selectMake(String makeChoice){
        List<WebElement> choice = driver.findElements(selector.getMakeListSelector());
        for(WebElement a : choice){
            if (a.getText().contains(makeChoice)) {
                a.click();
                break;
            }
        }
    }

    public void displayKeywordDropDown() {
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElements(selector.getConfirmZipMakeKeywordSelector()).get(2)));
        driver.findElements(selector.getConfirmZipMakeKeywordSelector()).get(2).click();
    }

    public void inputKeyword(String keyword) {
        driver.findElement(selector.getKeywordInputSelector()).sendKeys(keyword);
    }

    public DealerSearchResultsPage clickApply() {
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getApplyButtonSelector()));
        driver.findElement(selector.getApplyButtonSelector()).click();
        return new DealerSearchResultsPage(driver);
    }

    public void displayLocationDropDown() {
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElements(selector.getConfirmZipMakeKeywordSelector()).get(0)));
        driver.findElements(selector.getConfirmZipMakeKeywordSelector()).get(0).click();
    }

    public void inputZipCode(String keyword) {
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getInputZipCodeSelector()));
        driver.findElement(selector.getInputZipCodeSelector()).sendKeys(keyword);
    }

    public void selectRadius(String radiusChoice){
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getRadiusListSelector()));
        List<WebElement> choice = driver.findElements(selector.getRadiusListSelector());
        for(WebElement a : choice){
            if (a.getText().contains(radiusChoice)) {
                a.click();
                break;
            }
        }
    }

    public DealerSearchResultsPage clickCancel() {
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getCancelButtonSelector()));
        driver.findElement(selector.getCancelButtonSelector()).click();
        return new DealerSearchResultsPage(driver);
    }

    public DsrpFilterPage clickClearAll() throws InterruptedException {
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getClearAllButtonSelector()));
        driver.findElement(selector.getClearAllButtonSelector()).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return new DsrpFilterPage(driver);
    }

    public boolean confirmZipCode(String zip) {
        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getConfirmZipMakeKeywordSelector(), zip));
        return driver.findElements(selector.getConfirmZipMakeKeywordSelector()).get(0).getText().contains(zip);
    }

    public boolean confirmMake(String make) {
        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getConfirmZipMakeKeywordSelector(), make));
        return driver.findElements(selector.getConfirmZipMakeKeywordSelector()).get(1).getText().contains(make);
    }

    public boolean confirmKeyword() {
        return driver.findElements(selector.getConfirmZipMakeKeywordSelector()).get(2).getText().contains("Keywords");
    }

    public int returnAmtOfListings(){
        String resultAmt = driver.findElement(selector.getListingCountSelector()).getText();
        resultAmt = resultAmt.replaceAll("\\D+", "");
        int amt = Integer.parseInt(resultAmt);
        return amt;
    }

    public boolean verifyDsrpOptions(){
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getConfirmZipMakeKeywordSelector()));
        return (driver.findElements(selector.getConfirmZipMakeKeywordSelector()).get(0).isDisplayed()) && (driver.findElements(selector.getConfirmZipMakeKeywordSelector()).get(1).isDisplayed()) && (driver.findElements(selector.getConfirmZipMakeKeywordSelector()).get(2).isDisplayed());
    }

}
