package com.autotrader.mdot.pages.FYC;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.pages.SYC.SycViewOrderPage;
import com.autotrader.mdot.pages.misc.HomeMainPage;
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
 * Created by mwstratton on 8/19/2015.
 */
public class YearMakeModelTrimSliderPage {

    WebDriver driver;
    WebDriverWait wait;
    WaitFor waitFor;
    Actions action;
    JavascriptExecutor jse;
    YearMakeModelTrimSliderPageSelector selector;

    public YearMakeModelTrimSliderPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new YearMakeModelTrimSliderPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        action = new Actions(driver);
    }

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getApplyButtonSelector());
    }

    public void selectYearBeginning(String text){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getYearBeginningInputSelector(), text));
        new Select(driver.findElement(selector.getYearBeginningInputSelector())).selectByVisibleText(text);
    }

    public boolean confirmYearBegin(String text) {
        Select mySelect= new Select(driver.findElement(selector.getYearBeginningInputSelector()));
        WebElement option = mySelect.getFirstSelectedOption();
        return option.getText().contains(text);
    }

    public void selectYearEnding(String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getYearEndingInputSelector(), text));
        new Select(driver.findElement(selector.getYearEndingInputSelector())).selectByVisibleText(text);
    }

    public boolean confirmYearEnd(String text) {
        Select mySelect= new Select(driver.findElement(selector.getYearEndingInputSelector()));
        WebElement option = mySelect.getFirstSelectedOption();
        return option.getText().contains(text);
    }

    public boolean confirmYearRangeYearEnd(String text) {
        Select mySelect= new Select(driver.findElement(selector.getYearEndingInputSelector()));
        List<WebElement> options = mySelect.getOptions();
        for (WebElement option: options) {
            if (option.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }

    public boolean confirmYearRangeYearBegin(String text) {
        Select mySelect= new Select(driver.findElement(selector.getYearBeginningInputSelector()));
        List<WebElement> options = mySelect.getOptions();
        for (WebElement option: options) {
            if (option.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }
    public void clickMakeSelector(){
        List<WebElement> e = driver.findElements(selector.getSelectorListSelector());
        wait.until(ExpectedConditions.elementToBeClickable(e.get(5))).click();
    }

    public void clickModelSelector(){
        List<WebElement> e = driver.findElements(selector.getSelectorListSelector());
        wait.until(ExpectedConditions.elementToBeClickable(e.get(6))).click();
    }

    public void clickTrimSelector(){
        List<WebElement> e = driver.findElements(selector.getSelectorListSelector());
        wait.until(ExpectedConditions.elementToBeClickable(e.get(7))).click();
    }

    public void selectMake(String make) {
        List<WebElement> choice = driver.findElements(selector.getMakeFilterSelector());
        for(WebElement e : choice){
            if(e.getText().equals(make)){
                wait.until(ExpectedConditions.elementToBeClickable(e));
                e.click();
                break;
            }
        }
    }

    public void selectModel(String model){
        List<WebElement> choice = driver.findElements(selector.getModelFilterSelector());
        for(WebElement e : choice){
            if(e.getText().equals(model)){
                wait.until(ExpectedConditions.elementToBeClickable(e));
                e.click();
                break;
            }
        }
    }

    public void selectTrim(String trim){
        List<WebElement> choice = driver.findElements(selector.getTrimFilterSelector());
        for(WebElement e : choice){
            if(e.getText().equals(trim)){
                wait.until(ExpectedConditions.elementToBeClickable(e));
                e.click();
                break;
            }
        }
    }

    public void clickMakeSelect(){
        List<WebElement> e = driver.findElements(selector.getSelectButtonSelector());
        wait.until(ExpectedConditions.elementToBeClickable(e.get(0)));
        e.get(0).click();
    }


    public void clickModelSelect() {
        List<WebElement> e = driver.findElements(selector.getSelectButtonSelector());
        wait.until(ExpectedConditions.elementToBeClickable(e.get(1)));
        e.get(1).click();
    }

    public void clickTrimSelect(){
        List<WebElement> e = driver.findElements(selector.getSelectButtonSelector());
        wait.until(ExpectedConditions.elementToBeClickable(e.get(2)));
        e.get(2).click();
    }

    public HomeMainPage clickApplyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(selector.getApplyButtonSelector())).click();
        return new HomeMainPage(driver);
    }

    public void waitForMakeView() {
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSelectButtonSelector()));
    }

    public void waitForModelView() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(selector.getSelectButtonSelector()).get(1)));
    }

    public void waitForTrimView() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(selector.getSelectButtonSelector()).get(2)));
    }

    public Boolean confirmMake(String selectedMake) {
        return driver.findElements(selector.getDisplayedSelector()).get(12).getText().contains(selectedMake);
    }

    public Boolean confirmModel(String selectedModel) {
        return driver.findElements(selector.getDisplayedSelector()).get(14).getText().contains(selectedModel);
    }

    public Boolean confirmTrim(String selectedTrim) {
        return driver.findElements(selector.getDisplayedSelector()).get(16).getText().contains(selectedTrim);
    }

    public void clickAddAnotherCar() {
        driver.findElements(selector.getButtonListSelector()).get(5).click();
    }

    public void clickCancelTheSelectedCar(int i) {
        driver.findElements(selector.getButtonListSelector()).get(i - 1).click();
    }

    public boolean checkNumberOfCarDisplayed(int n) {
        for (int i = 0; i < n; i++)  {
            if (!driver.findElements(selector.getCarListSelector()).get(i).isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyMakeAdIsDisplayed(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getMakeAdSelector())).isDisplayed();
    }

    public boolean verifyModelAdIsDisplayed(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getModelAdSelector())).isDisplayed();
    }


}
