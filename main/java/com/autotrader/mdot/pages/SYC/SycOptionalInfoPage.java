package com.autotrader.mdot.pages.SYC;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/17/2015.
 */
public class SycOptionalInfoPage {

    public WebDriver driver;
    public WebDriverWait wait;
    WaitFor waitFor;
    Actions actions;
    SycOptionalInfoPageSelector selector;
    JavascriptExecutor jse;

    public SycOptionalInfoPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.selector = new SycOptionalInfoPageSelector();
        actions = new Actions(driver);
        this.jse = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getNextAddPhotosButtonSelector());
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getNextAddPhotosButtonSelector())).isDisplayed();
    }

    public void selectTrim(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getTrimInputSelector(), text));
        new Select(driver.findElement(selector.getTrimInputSelector())).selectByVisibleText(text);
    }

    public void selectDoors(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getDoorsInputSelector(), text));
        new Select(driver.findElement(selector.getDoorsInputSelector())).selectByVisibleText(text);
    }

    public void selectEngine(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getEngineInputSelector(), text));
        new Select(driver.findElement(selector.getEngineInputSelector())).selectByVisibleText(text);
    }

    public void selectTransmission(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getTransmissionInputSelector(), text));
        new Select(driver.findElement(selector.getTransmissionInputSelector())).selectByVisibleText(text);
    }

    public void selectFuel(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getFuelTypeInputSelector(), text));
        new Select(driver.findElement(selector.getFuelTypeInputSelector())).selectByVisibleText(text);
    }

    public void selectDriveType(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getDriveTypeInputSelector(), text));
        new Select(driver.findElement(selector.getDriveTypeInputSelector())).selectByVisibleText(text);
    }

    public void selectExtColor(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getExtColorInputSelector(), text));
        new Select(driver.findElement(selector.getExtColorInputSelector())).selectByVisibleText(text);
    }

    public void selectIntColor(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getIntColorInputSelector(), text));
        new Select(driver.findElement(selector.getIntColorInputSelector())).selectByVisibleText(text);
    }

    public void enterVinNumber(String text){
        driver.findElement(selector.getVinInputFieldSelector()).clear();
        driver.findElement(selector.getVinInputFieldSelector()).sendKeys(text);
    }

    public void clickTrimInfoIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(selector.getInfoButtonsSelector()).get(0))).click();
    }

    public void clickVinInfoIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(selector.getInfoButtonsSelector()).get(1))).click();
    }

    public boolean checkVinValidationError(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getVinValidationErrorSelector(), "VIN must be exactly 17 letters and numbers."));
    }

    public boolean checkAmountOfInstalledFeatures(int amtChosen){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getAmountOfSelectedFeaturesSelector(), amtChosen + " Installed Features"));
    }

    public void enterComments(String text){
        driver.findElements(selector.getCommentInputFieldSelector());
        boolean isPresent = driver.findElements(selector.getCommentInputFieldSelector()).size() > 0;
        if(isPresent){
            driver.findElement(selector.getCommentInputFieldSelector()).clear();
            driver.findElement(selector.getCommentInputFieldSelector()).sendKeys(text);
        }
    }

    public void selectInstalledFeatures(int index) {
        List<WebElement> selection = driver.findElements(selector.getSelectionSelector());
        wait.until(ExpectedConditions.elementToBeClickable(selection.get(index)));
        selection.get(index).click();
    }

    public void selectComments(int index){
        List<WebElement> selection = driver.findElements(selector.getSelectCommentsSelector());
        wait.until(ExpectedConditions.elementToBeClickable(selection.get(index))).click();
    }

    public void clickDoneFromSelectedFeatures(){
        List<WebElement> e = driver.findElements(selector.getButtonsSelector());
        wait.until(ExpectedConditions.elementToBeClickable(e.get(1))).click();
    }

    public void clickDoneFromCommentBuilder(){
        List<WebElement> e = driver.findElements(selector.getButtonsSelector());
        wait.until(ExpectedConditions.elementToBeClickable(e.get(0))).click();
    }

    public void clickInstalledFeatures(){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getInstalledFeaturesButtonSelector())).click();
    }

    public void clickCommentBuilder(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getCommentBuilderButtonSelector())).click();
    }

    public SycAddPhotosPage clickOnNextButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getNextAddPhotosButtonSelector())).click();
        return new SycAddPhotosPage(driver);
    }

    public SycViewOrderPage clickOnCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getCheckoutButtonSelector())).click();
        return new SycViewOrderPage(driver);
    }

}
