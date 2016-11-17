package com.autotrader.mdot.pages.Dealers;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 10/8/2015.
 */
public class DdpFilterPage {

    WebDriver driver;
    WebDriverWait wait;
    WaitFor waitFor;
    JavascriptExecutor jse;
    DdpFilterPageSelector selector;

    public DdpFilterPage(WebDriver driver){
        this.driver = driver;
        this.waitFor = new WaitFor(driver);
        this.wait = new WebDriverWait(driver, 20);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new DdpFilterPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitForObject(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getApplyButtonSelector()));
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector.getApplyButtonSelector())).isDisplayed();
    }

    public void selectAnOption(int index) {
        List<WebElement> choice = driver.findElements(selector.getOptionsSelector());
        wait.until(ExpectedConditions.elementToBeClickable(choice.get(index))).click();
    }

    public void selectSubOption(String subOption){
        List<WebElement> choice = driver.findElements(selector.getSubOptionsSelector());
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getSubOptionsSelector()));
        for(WebElement e : choice){
            if(e.getText().contains(subOption)){
                wait.until(ExpectedConditions.elementToBeClickable(e)).click();
                break;
            }
        }
    }

    public DealerDetailPage clickOnApply(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getApplyButtonSelector())).click();
        return new DealerDetailPage(driver);
    }

    public void clickClearAllButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getClearAllButtonSelector())).click();
    }

    public void clickMakeAndSelect(String make){
        List<WebElement> slider = driver.findElements(selector.getMakeModelTrimSelector());
        wait.until(ExpectedConditions.elementToBeClickable(slider.get(0))).click();
        selectMake(make);
        clickNestedSelect(0);
    }

    public void clickModelAndSelect(String model){
        List<WebElement> slider = driver.findElements(selector.getModelFilterSelector());
        wait.until(ExpectedConditions.elementToBeClickable(slider.get(1))).click();
        selectModel(model);
        clickNestedSelect(1);
    }

    public void clickTrimAndSelect(String trim){
        List<WebElement> slider = driver.findElements(selector.getTrimFilterSelector());
        wait.until(ExpectedConditions.elementToBeClickable(slider.get(2))).click();
        selectTrim(trim);
        clickNestedSelect(2);
    }

    public void selectMake(String make) {
        List<WebElement> choice = driver.findElements(selector.getMakeFilterSelector());
        for(WebElement e : choice){
            if(e.getText().equals(make)){
                wait.until(ExpectedConditions.elementToBeClickable(e)).click();
                break;
            }
        }
    }

    public void selectModel(String model) {
        List<WebElement> choice = driver.findElements(selector.getMakeFilterSelector());
        for(WebElement e : choice){
            if(e.getText().equals(model)){
                wait.until(ExpectedConditions.elementToBeClickable(e)).click();
                break;
            }
        }
    }

    public void selectTrim(String trim) {
        List<WebElement> choice = driver.findElements(selector.getMakeFilterSelector());
        for(WebElement e : choice){
            if(e.getText().equals(trim)){
                wait.until(ExpectedConditions.elementToBeClickable(e)).click();
                break;
            }
        }
    }

    public void clickNestedSelect(int index){
        List<WebElement> e = driver.findElements(selector.getSelectButtonsSelector());
        wait.until(ExpectedConditions.elementToBeClickable(e.get(index))).click();
    }

    public void clickNewUsedCertifiedAndSelect(String choice){
        selectAnOption(newUsedCertifiedOption());
        selectSubOption(choice);
    }

    public void clickPriceAndSelectMinAndMax(String minPrice, String maxPrice){
        selectAnOption(priceOption());
        wait.until(ExpectedConditions.elementToBeClickable(selector.getMinPriceSelector())).clear();
        driver.findElement(selector.getMinPriceSelector()).sendKeys(minPrice);

        wait.until(ExpectedConditions.elementToBeClickable(selector.getMaxPriceSelector())).clear();
        driver.findElement(selector.getMaxPriceSelector()).sendKeys(maxPrice);
    }

    //<editor-fold desc="Index for Options">
    public int newUsedCertifiedOption(){
        return 0;
    }

    public int yearMakeModelTrimOption(){
        return 1;
    }

    public int styleOption(){
        return 2;
    }

    public int priceOption(){
        return 3;
    }

    public int dealersOrPrivateSellersOption(){
        return 4;
    }

    public int mileageOption(){
        return 5;
    }

    public int exteriorColorOption(){
        return 6;
    }

    public int interiorColorOption(){
        return 7;
    }

    public int transmissionOption(){
        return 8;
    }

    public int engineTypeOption(){
        return 9;
    }

    public int fuelEconomyOption(){
        return 10;
    }

    public int fuelTypeOption(){
        return 11;
    }

    public int driveTypeOption(){
        return 12;
    }

    public int doorsOption(){
        return 13;
    }

    public int vehicleFeaturesOption(){
        return 14;
    }

    public int premiumFeaturesOption(){
        return 15;
    }

    public int listingFeaturesOption(){
        return 16;
    }

    public int keywordOption(){
        return 17;
    }
    //</editor-fold>


}
