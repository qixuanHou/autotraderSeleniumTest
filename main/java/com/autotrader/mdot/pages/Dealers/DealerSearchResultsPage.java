package com.autotrader.mdot.pages.Dealers;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.pages.misc.HomeSidePage;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by cher1 on 7/16/2015.
 */
public class DealerSearchResultsPage {
    // Declare driver
    WebDriver driver;
    WebDriverWait driverWait;
    WaitFor waitFor;
    JavascriptExecutor jse;
    DealerSearchResultsPageSelector selector;

    // Constructor
    public DealerSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new DealerSearchResultsPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitForObject() {
        waitFor.waitForExpectedConditions(driver, selector.getListMapButtonsSelector());
    }

    public boolean checkOnCorrectPage(){
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getHeadingForCarDealersSelector())).isDisplayed();
    }

    public DsrpFilterPage clickFilter() {
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getfilterButtonSelector())).click();
        return new DsrpFilterPage(driver);
    }

    public DealerDetailPage clickViewListings() {
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElements(selector.getViewListingSelector()).get(1))).click();
        return new DealerDetailPage(driver);
    }

    public DealerSearchResultsPage MapView() {
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElements(selector.getListMapButtonsSelector()).get(1))).click();
        return new DealerSearchResultsPage(driver);
    }

    public boolean confirmMapView() {
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getMapDealerSelector())).isDisplayed();
    }

    public DealerSearchResultsPage ListView() {
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElements(selector.getListMapButtonsSelector()).get(0))).click();
        return new DealerSearchResultsPage(driver);
    }

    public boolean confirmListView() {
        return driverWait.until(ExpectedConditions.elementToBeClickable(selector.getLoadMoreButtonSelector())).isDisplayed();
    }

    public DealerSearchResultsPage clickLoadMore() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getLoadMoreButtonSelector())).click();
        return new DealerSearchResultsPage(driver);
    }

    public HomeSidePage clickHamburgerButton(){
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getHamburgerButtonSelector())).click();
        return new HomeSidePage(driver);
    }

    public String getDirectionLine(){
        return driver.findElement(selector.getDirectionLineSelector()).getText();
    }

    public String getPhoneNumberLine(){
        return driver.findElement(selector.getPhoneNumberLineSelector()).getText();
    }

    public boolean isDirectionLineTappable(){
        try{
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.elementToBeClickable(selector.getDirectionLineSelector()));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean isPhoneLineTappable(){
        try{
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.elementToBeClickable(selector.getPhoneNumberLineSelector()));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public DealerDetailPage clickListingByIndex(int index){
        List<WebElement> saveSearchStar = driver.findElements(selector.getViewListingsButtonsSelector());
        driverWait.until(ExpectedConditions.elementToBeClickable(saveSearchStar.get(index))).click();
        return new DealerDetailPage(driver);
    }

    public boolean verifyAddressIsDisplayed(int index){
        return driver.findElements(selector.getAddressListedSelector()).get(index).isDisplayed();
    }

    public boolean verifyPhoneNumbersAreDisplayed(int index){
        return driver.findElements(selector.getPhoneListedSelector()).get(index).isDisplayed();
    }

    public boolean verifyViewListingButtons(int index){
        return driver.findElements(selector.getViewListingsButtonsSelector()).get(index).isDisplayed();
    }

    public boolean verifyCorrectZip(String zip){
        return driver.findElement(selector.getHeadingForCarDealersSelector()).getText().contains(zip);
    }

    public String getNameOfDealer(int index){
        return driver.findElements(selector.getDealerNameForListingSelector()).get(index).getText();
    }
}
