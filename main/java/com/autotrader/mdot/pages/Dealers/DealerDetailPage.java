package com.autotrader.mdot.pages.Dealers;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.pages.misc.SignInPage;
import com.autotrader.mdot.pages.misc.VehicleDetailsPage;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by qhou on 9/8/2015.
 */
public class DealerDetailPage {
    WebDriver driver;
    WaitFor wait;
    WebDriverWait driverWait;
    JavascriptExecutor jse;
    DealerDetailPageSelector selector;

    public DealerDetailPage(WebDriver driver){
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, 20);
        this.wait = new WaitFor(driver);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new DealerDetailPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public VehicleDetailsPage selectFirstListing() {
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElements(selector.getListingsSelector()).get(0))).click();
        return new VehicleDetailsPage(driver);
    }

    public VehicleDetailsPage selectListingByIndex(int index){
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getListingsSelector())).get(index).click();
        return new VehicleDetailsPage(driver);
    }

    public void clickImageView() {
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getImageViewSelector())).click();
    }

    public boolean verifyImageView(){
        return driverWait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getImageViewListViewSelectedSelector(), "Image View"));
    }

    public void clickListView() {
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getListViewSelector())).click();
    }

    public boolean verifyListView(){
        return driverWait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getImageViewListViewSelectedSelector(), "List View"));
    }

    public boolean foundImage() {
        return driver.findElement(selector.getImageSelector()).isDisplayed();
    }

    public boolean foundList() {
        return driver.findElement(selector.getListSelector()).isDisplayed();
    }

    public void changeSortingOption(String selectedSortingOption) {
        WebElement select = driver.findElements(By.cssSelector(".listing-sort-by")).get(0);
        select.click();
        List<WebElement> allOptions = select.findElements(By.tagName("option"));
        for (WebElement option : allOptions) {
            if (option.getText().contentEquals(selectedSortingOption)) {
                option.click();
                break;
            }
        }
    }

    public boolean foundContactButton() {
        return driver.findElement(selector.getContactButtonSelector()).isDisplayed();
    }

    public boolean foundGetDirectionButton() {
        try {
            return driver.findElement(selector.getContactButtonSelector()).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public void waitForObject() {
        wait.waitForExpectedConditions(driver, selector.getEmailDealerButtonSelector());
    }

    public boolean isCurrentPage() {
        return driver.getCurrentUrl().contains("dealerInfo.xhtml");
    }

    public String getAddressLine() {
        return driver.findElement(selector.getAddressLineSelector()).getText();
    }

    public String getPhoneNumberLine() {
        return driver.findElement(selector.getPhoneNumberLineSelector()).getText();
    }

    public String getWebsiteLine() {
        return driver.findElement(selector.getWebsiteLineSelector()).getText();
    }

    public String getContactButtonText() {
        return driver.findElement(selector.getContactButtonSelector()).getText();
    }

    public boolean isDirectionRowTappable(){
        try{
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.elementToBeClickable(selector.getAddressLineSelector()));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean isCallRowTappable(){
        try{
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.elementToBeClickable(selector.getPhoneNumberLineSelector()));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean isWebsiteRowTappable(){
        try{
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.elementToBeClickable(selector.getWebsiteLineSelector()));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void clickContactDealerButton() {
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getContactButtonSelector()));
        driver.findElement(selector.getContactButtonSelector()).click();
    }

    public boolean isContactDealerPanelVisable() {
        wait.waitForExpectedConditions(driver, selector.getContactDealerPanelSelector());
        return driver.findElement(selector.getContactDealerPanelSelector()).isDisplayed();
    }

    public String getContactDealerPanelHeader() {
        return driver.findElement(selector.getContactDealerPanelHeaderSelector()).getText();
    }

    public String getMessagePlaceholderText() {
        return driver.findElement(selector.getMessagePlaceholderTextOnContactPanelSelector()).getAttribute("placeholder");
    }

    public boolean verifyFilterOptions(String text){
            List<WebElement> e = driver.findElements(selector.getListingSortBySelector());
            return e.get(0).getText().contains(text);
    }

    public boolean verifyEmailDealerButton(){
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getEmailDealerButtonSelector()));
        return driver.findElement(selector.getEmailDealerButtonSelector()).isDisplayed();
    }

    public SignInPage clickSaveListingLoggedOutByIndex(int i){
        List<WebElement> e = driver.findElements(By.cssSelector(".atcui-icon.atcui-unfavorite"));
        driverWait.until(ExpectedConditions.elementToBeClickable(e.get(i)));
        e.get(i).click();
        return new SignInPage(driver);
    }

    public void saveListing(int index){
        List<WebElement> e = driver.findElements(By.cssSelector(".atcui-icon.atcui-unfavorite"));
        driverWait.until(ExpectedConditions.elementToBeClickable(e.get(index))).click();
    }

    public boolean checkOnCorrectPage(){
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getEmailDealerButtonSelector()));
        return driver.findElement(selector.getEmailDealerButtonSelector()).isDisplayed();
    }

    public DdpFilterPage clickFilterButton(){
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getFilterButtonSelector())).click();
        return new DdpFilterPage(driver);
    }

    public boolean verifyDealerName(String text){
        return driver.findElement(selector.getDealerNameSelector()).getText().equals(text);
    }

    public boolean verifyPriceListed(String minPrice, String maxPrice, int index){
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getPriceValuesListedSelector()));
        String priceListed = driver.findElements(selector.getPriceValuesListedSelector()).get(index).getText();
        priceListed = priceListed.replaceAll("\\D+","");
        int min = Integer.parseInt(minPrice);
        int max = Integer.parseInt(maxPrice);
        int cashMoney =  Integer.parseInt(priceListed);
        return ((cashMoney >= min) && (cashMoney <= max));
    }


}
