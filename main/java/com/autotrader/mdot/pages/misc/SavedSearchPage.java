package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.pages.FYC.SearchResultsLandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
/**
 * Created by qhou on 9/9/2015.
 */
public class SavedSearchPage {
    public WebDriver driver;
    public WebDriverWait wait;
    SavedSearchPageSelector selector;


    public SavedSearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.selector = new SavedSearchPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getEditButtonSelector())).isDisplayed();
    }

    public boolean verifyHeaderIsDisplayed(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector.getHeaderSelector())). isDisplayed();
    }

    public void deleteSearchFromEditMode(int i) {
        List<WebElement> deleteButton = driver.findElements(selector.getDeleteButtonSelector());
        deleteButton.get(i).click();
        clickConfirmDelete();
    }

    public void clickDeleteAll(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getDeleteAllButtonSelector())).click();
    }

    public void clickEditButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getEditButtonSelector()));
        driver.findElement(selector.getEditButtonSelector()).click();
    }

    public SearchResultsLandingPage clickSavedSearchByIndex(int index){
        List<WebElement> searches = driver.findElements(selector.getSavedSearchesSelector());
        wait.until(ExpectedConditions.elementToBeClickable(searches.get(index))).click();
        return new SearchResultsLandingPage(driver);
    }

    public void clickConfirmDeleteAll(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getConfirmDeleteAllSelector())).click();
    }

    public void clickConfirmDelete(){
        List<WebElement> deleteButtons = driver.findElements(selector.getConfirmDeleteButtonSelector());
        wait.until(ExpectedConditions.elementToBeClickable(deleteButtons.get(1))).click();
    }

    public HomeSidePage clickHamburgerButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getHamburgerButtonSelector())).click();
        return new HomeSidePage(driver);
    }

}

