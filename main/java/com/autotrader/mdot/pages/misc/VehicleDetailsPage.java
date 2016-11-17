package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.Environments;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by qhou on 9/8/2015.
 */
public class VehicleDetailsPage {
    public WebDriver driver;
    Environments url = new Environments();
    WaitFor wait;
    WebDriverWait driverWait;
    VehicleDetailsPageSelector selector;

    // Page objects and declarations

    public VehicleDetailsPage(WebDriver driver){
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, 20);
        this.wait = new WaitFor(driver);
        this.selector = new VehicleDetailsPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public ResearchPage clickResearch() {
        List<WebElement> choice = driver.findElements(selector.getNavBarSelector());
        driverWait.until(ExpectedConditions.elementToBeClickable(choice.get(1)));
        choice.get(1).click();
        return new ResearchPage(driver);
    }

    public SellerInfoPage clickSellerInfo() {
        List<WebElement> choice = driver.findElements(selector.getNavBarSelector());
        driverWait.until(ExpectedConditions.elementToBeClickable(choice.get(2)));
        choice.get(2).click();
        return new SellerInfoPage(driver);
    }

    public HomeSidePage clickHamburgerButton(){
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getHamburgerButtonSelector()));
        driver.findElement(selector.getHamburgerButtonSelector()).click();
        return new HomeSidePage(driver);
    }

    public CalculatePaymentPage clickCalculatePayment(){
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getCalculatePaymentSelector())).click();
        return new CalculatePaymentPage(driver);
    }

    public boolean checkOnCorrectPage(){
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getCalculatePaymentSelector()));
        return driver.findElement(selector.getCalculatePaymentSelector()).isDisplayed();
    }

    public void saveListing() {
        driverWait.until(ExpectedConditions.elementToBeClickable(selector.getUnSavedListingStarSelector())).click();
    }

    public String getPageHeading() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getPageHeadingSelector()));
        return driver.findElement(selector.getPageHeadingSelector()).getText();
    }

    public String getDealerAddress() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getDealerAddressSelector()));
        return driver.findElement(selector.getDealerAddressSelector()).getText();
    }

    public String getListingIdFromUrl() {
        String vdpUrl = driver.getCurrentUrl();
        String[] vdpSplit1 = vdpUrl.split("listingId=");
        String[] vdpSplit2 = vdpSplit1[1].split("&");
        String listingId = vdpSplit2[0];
        return listingId;
    }

    public String getURLForCPOTileOnCarInfo(){
        return driver.findElement(selector.getCpoTileSelector()).getAttribute("src");}

    public String getURLForCPOTileOnWarrantyAccordion(){
        return driver.findElement(selector.getWarrantyCPOTileSelector()).getAttribute("src");}

    public void expandWarrantySection(){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getWarrantySectionSelector()));
        driver.findElement(selector.getWarrantySectionSelector()).click();
    }

    public String getWarrantyTabLinkText(){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getWarrantyLinkSelector()));
        return driver.findElement(selector.getWarrantyLinkSelector()).getText();
    }

    public void clickWarrantyLink(){
        WebElement offSiteLink = driver.findElement(selector.getWarrantyLinkSelector());
        offSiteLink.click();
    }

    public String getWarrantyText(){
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getWarrantyDetailSelector())).getText();
    }

    public boolean checkFoundThePage() {
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getContactDealerButtonSelector())).isDisplayed();
    }

    public void waitForObject() {
        wait.waitForExpectedConditions(driver, selector.getPageHeadingSelector());
    }

    public String getDirectionsLine() {
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getDirectionLineSelector())).getText();
    }

    public String getMilesLine() {
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getMilesLineSelector())).getText();
    }

    public String getPhoneNumberLine(){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getPhoneNumberLineSelector()));
        return driver.findElement(selector.getPhoneNumberLineSelector()).getText();
    }

    public String getWebsiteLine() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getWebsiteLineSelector()));
        return driver.findElement(selector.getWebsiteLineSelector()).getText();
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

    public boolean isWebsiteLineTappable(){
        try{
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.elementToBeClickable(selector.getWebsiteLineSelector()));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public String getEmailDealerButtonText(){
        return driver.findElement(selector.getEmailDealerButtonSelector()).getText();
    }

    public String getCPOBITag(){
        return driver.findElement(selector.getWarrantyLinkSelector()).getAttribute("data-birf-cmp");
    }

    public boolean verifyVehicleDetails(String text){
        List<WebElement> e = driver.findElements(selector.getVehicleListSelector());
        return e.get(3).getText().contains(text);
    }

    public boolean verifyVdpAdIsDisplayed(){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getVdpAdSelector()));
        return driver.findElement(selector.getVdpAdSelector()).isDisplayed();
    }

    public boolean verifySaveListingStar(){
        return (driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getUnSavedListingStarSelector())).isDisplayed() || driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getSavedListingStarSelector())).isDisplayed());
    }

    public boolean verifyFeature(String feature){
        boolean tf = false;
        List<WebElement> ftr = driver.findElements(selector.getVehicleFeaturesSelector());
        for(WebElement e : ftr){
            if(e.getText().equals(feature)){
                tf = true;
                break;
            }
        }
        return tf;
    }

    public boolean verifyExteriorColor(String extColor){
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getExteriorColorListedSelector())).getText().contains(extColor);
    }

    public boolean verifyInteriorColor(String intColor){
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getInteriorColorListedSelector())).getText().contains(intColor);
    }

    public boolean verifyFuelType(String fuelType){
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getFuelTypeListedSelector())).getText().contains(fuelType);
    }

    public boolean verifyTransmission(String transmission){
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getTransmissionListedSelector())).getText().contains(transmission);
    }

    public boolean verifyDoors(String doors){
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getDoorsListedSelector())).getText().contains(doors);
    }

    public boolean verifyEngine(String engine){
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getEngineListedSelector())).getText().contains(engine);
    }

    public boolean verifyDriveType(String driveType){
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getDriveTypeListedSelector())).getText().contains(driveType);
    }

    public boolean verifyVin(String vin){
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getVinListedSelector())).getText().contains(vin);
    }

    public boolean verifyStockNumber(String stockNumber){
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getStockNumberListedSelector())).getText().contains(stockNumber);
    }

    public boolean verifyCarId(String carId){
        return driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getCarIdListedSelector())).getText().contains(carId);
    }
}
