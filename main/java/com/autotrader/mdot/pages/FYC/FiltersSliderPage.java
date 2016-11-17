package com.autotrader.mdot.pages.FYC;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/28/2015.
 */
public class FiltersSliderPage {

    WebDriver driver;
    WebDriverWait wait;
    WaitFor waitFor;
    JavascriptExecutor jse;
    FiltersSliderPageSelector selector;

    /**Constructor*/
    public FiltersSliderPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new FiltersSliderPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }



    /**Page Validation & Wait**/
    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getApplyButtonSelector());
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getApplyButtonSelector())).isDisplayed();
    }



    /**Methods for Page Elements**/
    public void selectAnOption(String option) {
        List<WebElement> choice = driver.findElements(selector.getSelectOptionSelector());
        for(WebElement e : choice){
            if(e.getText().contains(option)){
                wait.until(ExpectedConditions.elementToBeClickable(e));
                e.click();
                break;
            }
        }
    }

    public void selectSubOption(String subOption){
        List<WebElement> choice = driver.findElements(selector.getSelectSubOptionSelector());
        for(WebElement e : choice){
            if(e.getText().contains(subOption)){
                wait.until(ExpectedConditions.elementToBeClickable(e));
                e.click();
                break;
            }
        }
    }

    public void selectYearBeginning(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getYearFromSelector(), text));
        new Select(driver.findElement(selector.getYearFromSelector())).selectByVisibleText(text);
    }

    public void selectYearEnding(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getYearToSelector(), text));
        new Select(driver.findElement(selector.getYearToSelector())).selectByVisibleText(text);
    }

    public void enterMinAndMaxPrice(String minPrice, String maxPrice){
        selectAnOption("Price");
        wait.until(ExpectedConditions.elementToBeClickable(selector.getMinPriceSelectorSelector()));
        wait.until(ExpectedConditions.elementToBeClickable(selector.getMaxPriceSelectorSelector()));
        driver.findElement(selector.getMaxPriceSelectorSelector()).clear();
        driver.findElement(selector.getMinPriceSelectorSelector()).clear();
        driver.findElement(selector.getMinPriceSelectorSelector()).sendKeys(minPrice);
        driver.findElement(selector.getMaxPriceSelectorSelector()).sendKeys(maxPrice);
    }

    public SearchResultsLandingPage clickOnApply(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getApplyButtonSelector())).click();
        return new SearchResultsLandingPage(driver);
    }

    public void clickClearAllButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getClearAllButtonSelector())).click();
    }

    public void selectDriveType(String driveType){
        selectAnOption("Drive Type");
        selectSubOption(driveType);
    }


    public void selectFuelType(String fuelType) {
        selectAnOption("Fuel Type");
        selectSubOption(fuelType);
    }

    public void selectFromAndToYear(String from, String to){
        selectAnOption("Year/Make/Model/Trim");
        selectYearBeginning(from);
        selectYearEnding(to);
    }

    public void selectCondition(String condition){
        selectAnOption("New/Used/Certified");
        selectSubOption(condition);
    }

    public void selectMileage(String miles){
        selectAnOption("Mileage");
        selectSubOption(miles);
    }

    public void selectDoors(String doors){
        selectAnOption("Doors");
        selectSubOption(doors);
    }

    public void selectTransmision(String tranny){
        selectAnOption("Transmission");
        selectSubOption(tranny);
    }

    public void selectEngineType(String engineType){
        selectAnOption("Engine Type");
        selectSubOption(engineType);
    }

    public void selectFuelEconomy(String fuelEconomy){
        selectAnOption("Fuel Economy");
        selectSubOption(fuelEconomy);
    }

    public void selectVehicleFeatures(String feature) {
        selectAnOption("Vehicle Features");
        List<WebElement> choice = driver.findElements(selector.getVehicleFeatureSelector());
        for(WebElement e : choice){
            if(e.getText().contains(feature)){
                wait.until(ExpectedConditions.elementToBeClickable(e)).click();
                break;
            }
        }
    }


    public void clickMakeAndSelect(String make)throws InterruptedException{
        List<WebElement> slider = driver.findElements(selector.getFilterSelector());
        jse.executeScript("arguments[0].click();", slider.get(0));
        Thread.sleep(2000);
        selectMake(make);
        clickNestedSelect(0);
    }

    public void clickModelAndSelect(String model)throws InterruptedException{
        List<WebElement> slider = driver.findElements(selector.getFilterSelector());
        jse.executeScript("arguments[0].click();", slider.get(1));
        Thread.sleep(2000);
        selectModel(model);
        clickNestedSelect(1);
    }

    public void clickTrimAndSelect(String trim)throws InterruptedException{
        List<WebElement> slider = driver.findElements(selector.getFilterSelector());
        jse.executeScript("arguments[0].click();", slider.get(2));
        Thread.sleep(2000);
        selectTrim(trim);
        clickNestedSelect(2);
    }

    public void selectMake(String make){
        List<WebElement> choice = driver.findElements(selector.getMakeFilterSelector());
        for(WebElement e : choice){
            if(e.getText().equals(make)){
                wait.until(ExpectedConditions.elementToBeClickable(e)).click();
                break;
            }
        }
    }

    public void selectModel(String model) throws InterruptedException{
        List<WebElement> choice = driver.findElements(selector.getModelFilterSelector());
        for(WebElement e : choice){
            if(e.getText().equals(model)){
                Thread.sleep(6000);
                wait.until(ExpectedConditions.elementToBeClickable(e)).click();
                Thread.sleep(6000);
                break;
            }
        }
    }

    public void selectTrim(String trim) {
        List<WebElement> choice = driver.findElements(selector.getTrimFilterSelector());
        for(WebElement e : choice){
            if(e.getText().equals(trim)){
                wait.until(ExpectedConditions.elementToBeClickable(e)).click();
                break;
            }
        }
    }

    public void selectStyle(String style){
        List<WebElement> choice = driver.findElements(selector.getStylesSelector());
        for(WebElement e : choice){
            if(e.getText().equals(style)){
                wait.until(ExpectedConditions.elementToBeClickable(e)).click();
                break;
            }
        }
    }

    public void selectExteriorColor(String color){
        List<WebElement> choice = driver.findElements(selector.getExteriorColorSelector());
        for(WebElement e : choice){
            if(e.getText().equals(color)){
                wait.until(ExpectedConditions.elementToBeClickable(e)).click();
                break;
            }
        }
    }

    public void selectInteriorColor(String color){
        List<WebElement> choice = driver.findElements(selector.getInteriorColorSelector());
        for(WebElement e : choice){
            if(e.getText().equals(color)){
                wait.until(ExpectedConditions.elementToBeClickable(e)).click();
                break;
            }
        }
    }

    public void clickNestedSelect(int index){
        List<WebElement> e = driver.findElements(selector.getSelectButtonsSelector());
        wait.until(ExpectedConditions.elementToBeClickable(e.get(index))).click();
    }


    /**Validation Methods**/
    public boolean confirmDriveType(String chosenOne) {
        return driver.findElements(selector.getSelectedSelector()).get(13).getText().contains(chosenOne);
    }

    public boolean confirmFuelType(String chosenOne) {
        return driver.findElements(selector.getSelectedSelector()).get(12).getText().contains(chosenOne);
    }

    public boolean confirmVehicleFeatures(String chosenOne) {
        return driver.findElements(selector.getSelectedSelector()).get(15).getText().contains(chosenOne);
    }

    public boolean confirmOptionIsAvailable(String optionName, int index){
        return driver.findElements(selector.getOptionHeaderSelector()).get(index).getText().contains(optionName);
    }

    public int getAmountOfResults(){
        String results = wait.until(ExpectedConditions.presenceOfElementLocated(selector.getResultsFoundSelector())).getText();
        results = results.replaceAll("\\D+", "");
        int amt = Integer.parseInt(results);
        return amt;
    }

    public void enterKeywords(String text){
        selectAnOption("Keyword");
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getKeywordInputSelector())).sendKeys(text);
    }
}
