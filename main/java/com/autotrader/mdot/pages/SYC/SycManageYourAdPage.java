package com.autotrader.mdot.pages.SYC;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.pages.misc.RemoveYourAdPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/31/2015.
 */
public class SycManageYourAdPage {

    public WebDriver driver;
    public WebDriverWait wait;
    SycManageYourAdPageSelector selector;

    public SycManageYourAdPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.selector = new SycManageYourAdPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getRemoveAdButtonSelector())).isDisplayed();
    }

    public RemoveYourAdPage clickOnRemoveAd(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getRemoveAdButtonSelector())).click();
        return new RemoveYourAdPage(driver);
    }

    public void clickMileageBox(){
        List<WebElement> e = driver.findElements(selector.getEditableInfoBoxSelector());
        wait.until(ExpectedConditions.elementToBeClickable(e.get(1))).click();
    }

    public void clickPriceBox(){
        List<WebElement> e = driver.findElements(selector.getEditableInfoBoxSelector());
        wait.until(ExpectedConditions.elementToBeClickable(e.get(2))).click();
    }

    public void clickPhotosBox(){
        List<WebElement> e = driver.findElements(selector.getEditableInfoBoxSelector());
        wait.until(ExpectedConditions.elementToBeClickable(e.get(3))).click();
    }

    public void clickCommentsBox(){
        List<WebElement> e = driver.findElements(selector.getEditableInfoBoxSelector());
        wait.until(ExpectedConditions.elementToBeClickable(e.get(4))).click();
    }

    public void clickEnhanceYourAdBox(){
        List<WebElement> e = driver.findElements(selector.getEditableInfoBoxSelector());
        wait.until(ExpectedConditions.elementToBeClickable(e.get(5))).click();
    }

    public void clickContactInfoBox(){
        List<WebElement> e = driver.findElements(selector.getEditableInfoBoxSelector());
        wait.until(ExpectedConditions.elementToBeClickable(e.get(6))).click();
    }

    public void enterNewMileage(String newMileage){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getNewMileageSelector())).clear();
        wait.until(ExpectedConditions.elementToBeClickable(selector.getNewMileageSelector())).sendKeys(newMileage);
    }

    public void enterNewPrice(String newPrice){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getNewPriceSelector())).clear();
        wait.until(ExpectedConditions.elementToBeClickable(selector.getNewPriceSelector())).sendKeys(newPrice);
    }

    public void enterNewComments(String newComment){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getNewCommentsSelector())).clear();
        wait.until(ExpectedConditions.elementToBeClickable(selector.getNewCommentsSelector())).sendKeys(newComment);
    }

    public void saveNewMileage(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getSaveButtonSelector())).get(0).click();
    }

    public void cancelNewMileage(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getCancelButtonSelector())).get(0).click();
    }

    public void saveNewPrice(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getSaveButtonSelector())).get(1).click();
    }

    public void cancelNewPrice(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getCancelButtonSelector())).get(1).click();
    }

    public void saveNewComments(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getSaveButtonSelector())).get(2).click();
    }

    public void cancelNewComments(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getCancelButtonSelector())).get(2).click();
    }

    public boolean validateMileageListed(String mileage){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getMileageListedSelector(), mileage));
    }

    public boolean validatePriceListed(String price){
        String listedPrice = wait.until(ExpectedConditions.presenceOfElementLocated(selector.getPriceListedSelector())).getText();
        listedPrice = listedPrice.replaceAll("\\D+", "");
        return listedPrice.equals(price);
    }

}
