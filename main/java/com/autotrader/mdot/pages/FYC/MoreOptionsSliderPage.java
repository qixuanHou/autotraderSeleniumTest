package com.autotrader.mdot.pages.FYC;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.pages.misc.HomeMainPage;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/19/2015.
 */
public class MoreOptionsSliderPage {

    WebDriver driver;
    WebDriverWait wait;
    WaitFor waitFor;
    JavascriptExecutor jse;
    MoreOptionsSliderPageSelector selector;


    public MoreOptionsSliderPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new MoreOptionsSliderPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getApplyButtonSelector());
    }

    public void selectAnOption(String option) {
        List<WebElement> choice = driver.findElements(selector.getSelectOptionSelector());
        for(WebElement e : choice){
            if(e.getText().contains(option)){
                e.click();
                break;
            }
        }
    }

    public void selectSubOption(String subOption){
        List<WebElement> choice = driver.findElements(selector.getSelectSubOptionSelector());
        for(WebElement e : choice){
            if(e.getText().contains(subOption)){
                e.click();
                break;
            }
        }
    }

    public void selectVehicleFeatures(String feature) {
        List<WebElement> choice = driver.findElements(selector.getVehicleFeatureSelector());
        for(WebElement e : choice){
            if(e.getText().contains(feature)){
                e.click();
                break;
            }
        }
    }

    public void selectExtColor(String color) {
        List<WebElement> colors = driver.findElements(selector.getExtColorSelector());
        for (WebElement e: colors) {
            if (e.getText().contains(color)) {
                e.click();
                break;
            }
        }
    }

    public void selectIntColor(String color) {
        List<WebElement> colors = driver.findElements(selector.getIntColorSelector());
        for (WebElement e: colors) {
            if (e.getText().contains(color)) {
                e.click();
                break;
            }
        }
    }

    public boolean checkSelectedLabel(String expectedLabel, int index) {
        return driver.findElements(selector.getSelectedLabelSelector()).get(index).getText().contains(expectedLabel);
    }

    public void enterMinAndMaxPrice(String minPrice, String maxPrice){
        selectAnOption("Price");
        driver.findElement(selector.getMinPriceSelectorSelector()).sendKeys(minPrice);
        driver.findElement(selector.getMaxPriceSelectorSelector()).sendKeys(maxPrice);
    }


    public void enterKeywords(String keyword){
        selectAnOption("Keyword");
        driver.findElement(selector.getSelectKeywordsSelector()).sendKeys(keyword);
    }

    public HomeMainPage clickOnApply(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getApplyButtonSelector())).click();
        return new HomeMainPage(driver);
    }

    public void clickClearButton() throws InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(selector.getClearButtonSelector())).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
