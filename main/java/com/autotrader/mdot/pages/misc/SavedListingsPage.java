package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
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
 * Created by qhou on 9/9/2015.
 */
public class SavedListingsPage {
    WebDriver driver;
    WebDriverWait wait;
    WaitFor waitFor;
    JavascriptExecutor jse;
    SavedListingsPageSelector selector;

    public SavedListingsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new SavedListingsPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean checkOnCorrectPage(){
        return driver.findElement(selector.getEditButtonSelector()).isDisplayed();
    }

    public boolean verifyHeaderIsDisplayed(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector.getHeaderSelector())).isDisplayed();
    }


    public void waitForObject() {
        waitFor.waitForExpectedConditions(driver, selector.getEditButtonSelector());
    }

    public void deleteSavedListing(int index) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getSaveListingStarSelector())).get(index).click();
    }

    public void clickOnEdit(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getEditButtonSelector())).click();
    }

    public void confirmDeletion(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getConfirmDeleteSelector())).click();
    }

    public void deleteAllListings(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getDeleteAllButtonSelector())).click();
    }

    public HomeSidePage clickHamburgerButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getHamburgerButtonSelector())).click();
        return new HomeSidePage(driver);
    }

    public void deleteListingFromEditMode(int i) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getEditModeDeleteSelector())).get(i).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getConfirmDeleteSelector())).click();
    }

    public void confirmDeleteAll(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getConfirmDeleteAllSelector())).click();
    }

    public void clickCancelButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getCancelButtonSelector())).click();
    }

    public HomeMainPage clickStartYourSearch(){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getStartYourSearchButtonSelector())).click();
        return new HomeMainPage(driver);
    }

    public boolean checkOnCorrectPageAfterAcceptingAgreement() {
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getStartYourSearchButtonSelector())).isDisplayed();
    }

    public boolean verifyListView(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getCurrentViewSelectedSelector(), "List View"));
    }

    public boolean verifyImageView(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getCurrentViewSelectedSelector(), "Image View"));
    }

    public void clickImageView(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getImageViewSelector())).click();
    }

    public void clickListView(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getListViewSelector())).click();
    }
}


