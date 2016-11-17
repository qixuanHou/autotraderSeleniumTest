package com.autotrader.mdot.pages.TIM;

import com.autotrader.mdot.pageselector.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class TimVehicleHistoryPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor js;
    TimVehicleHistoryPageSelector selector;


    public TimVehicleHistoryPage(WebDriver driver){
        this.actions = new Actions(driver);
        this.driver = driver;
        this.js = (JavascriptExecutor)driver;
        this.wait = new WebDriverWait(driver, 20);
        this.selector = new TimVehicleHistoryPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    //public void checkOnCorrectPage( String url);
    public boolean checkOnCorrectPage() {
        return driver.findElement(selector.getYesOriginalOwnerSelector()).isDisplayed();
    }
    public boolean clickYesOriginalOwner()
    {

        Object elementObject = driver.findElement(selector.getYesOriginalOwnerSelector());
        js.executeScript("arguments[0].click();", elementObject);

        //driver.findElement(yesOriginalOwnerSelector).click();
        return driver.findElement(selector.getYesOriginalOwnerSelector()).getAttribute("class").contains("ui-radio-on");
        //actions.moveToElement(driver.findElement(yesOriginalOwnerSelector)).click().perform();
    }

    public boolean clickYesClearTitle()
    {

        Object elementObject = driver.findElement(selector.getYesClearTitleSelector());
        js.executeScript("arguments[0].click();", elementObject);

        //driver.findElement(yesClearTitleSelector).click();
        return driver.findElement(selector.getYesClearTitleSelector()).getAttribute("class").contains("ui-radio-on");
        //actions.moveToElement(driver.findElement(yesClearTitleSelector)).click().perform();
    }
    public boolean clickYesCleanHistoryReport()
    {
        Object elementObject = driver.findElement(selector.getYesCleanHistoryReportSelector());
        js.executeScript("arguments[0].click();", elementObject);

        //driver.findElement(yesCleanHistoryReportSelector).click();
        return driver.findElement(selector.getYesCleanHistoryReportSelector()).getAttribute("class").contains("ui-radio-on");
        //actions.moveToElement(driver.findElement(yesCleanHistoryReportSelector)).click().perform();
    }
    public boolean clickNoInsuranceClaims()
    {
        Object elementObject = driver.findElement(selector.getNoInsuranceClaimsSelector());
        js.executeScript("arguments[0].click();", elementObject);

        //driver.findElement(noInsuranceClaimsSelector).click();
        return driver.findElement(selector.getNoInsuranceClaimsSelector()).getAttribute("class").contains("ui-radio-on");
        //actions.moveToElement(driver.findElement(noInsuranceClaimsSelector)).click().perform();
    }
    public boolean clickNoSmokingInVehicle()
    {
        Object elementObject = driver.findElement(selector.getNoSmokingInVehicleSelector());
        js.executeScript("arguments[0].click();", elementObject);

        //driver.findElement(noSmokingInVehicleSelector).click();
        return driver.findElement(selector.getNoSmokingInVehicleSelector()).getAttribute("class").contains("ui-radio-on");
        //actions.moveToElement(driver.findElement(noSmokingInVehicleSelector)).click().perform();
    }
    public boolean clickYesCompleteServiceRecords()
    {
        Object elementObject = driver.findElement(selector.getYesCompleteServiceRecordsSelector());
        js.executeScript("arguments[0].click();", elementObject);

        //driver.findElement(yesCompleteServiceRecordsSelector).click();
        return driver.findElement(selector.getYesCompleteServiceRecordsSelector()).getAttribute("class").contains("ui-radio-on");
        //actions.moveToElement(driver.findElement(yesCompleteServiceRecordsSelector)).click().perform();
    }
    public boolean clickYesTwoSetsOfKeys()
    {
        Object elementObject = driver.findElement(selector.getYesTwoSetsOfKeysSelector());
        js.executeScript("arguments[0].click();", elementObject);

        //driver.findElement(yesTwoSetsOfKeysSelector).click();
        return driver.findElement(selector.getYesTwoSetsOfKeysSelector()).getAttribute("class").contains("ui-radio-on");
        //actions.moveToElement(driver.findElement(yesTwoSetsOfKeysSelector)).click().perform();
    }
    public boolean clickNoAutoAuction()
    {
        Object elementObject = driver.findElement(selector.getNoAutoAuctionSelector());
        js.executeScript("arguments[0].click();", elementObject);

        //driver.findElement(noAutoAuctionSelector).click();
        return driver.findElement(selector.getNoAutoAuctionSelector()).getAttribute("class").contains("ui-radio-on");
        //actions.moveToElement(driver.findElement(noAutoAuctionSelector)).click().perform();
    }
    public boolean clickNoRentalCar()
    {
        Object elementObject = driver.findElement(selector.getNoRentalCarSelector());
        js.executeScript("arguments[0].click();", elementObject);

        //driver.findElement(noRentalCarSelector).click();
        return driver.findElement(selector.getNoRentalCarSelector()).getAttribute("class").contains("ui-radio-on");
        //actions.moveToElement(driver.findElement(noRentalCarSelector)).click().perform();
    }
    public void clickNextButton()
    {
        driver.findElement(selector.getNextButtonSelector()).click();
    }

    public boolean checkOriginalOwnerValidation(){
        return driver.findElement(selector.getYesOriginalOwnerValidationSelector()).getText().equals("This field is required");
    }
    public boolean checkClearTitleValidation(){
        return driver.findElement(selector.getYesClearTitleValidationSelector()).getText().equals("This field is required");
    }
    public boolean checkCleanHistoryReportValidation(){
        return driver.findElement(selector.getYesCleanHistoryReportValidationSelector()).getText().equals("This field is required");
    }
    public boolean checkInsuranceClaimsValidation(){
        return driver.findElement(selector.getNoInsuranceClaimsValidationSelector()).getText().equals("This field is required");
    }
    public boolean checkSmokingInVehicleValidation(){
        return driver.findElement(selector.getNoSmokingInVehicleValidationSelector()).getText().equals("This field is required");
    }
    public boolean checkCompleteServiceRecordsValidation(){
        return driver.findElement(selector.getYesCompleteServiceRecordsValidationSelector()).getText().equals("This field is required");
    }
    public boolean checkTwoSetsOfKeysValidation(){
        return driver.findElement(selector.getYesTwoSetsOfKeysValidationSelector()).getText().equals("This field is required");
    }
    public boolean checkAutoAuctionValidation(){
        return driver.findElement(selector.getNoAutoAuctionValidationSelector()).getText().equals("This field is required");
    }
    public boolean checkRentalCarValidation(){
        return driver.findElement(selector.getNoRentalCarValidationSelector()).getText().equals("This field is required");
    }
}
