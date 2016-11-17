package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
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
public class SellerInfoPage {
    public WebDriver driver;
    public WebDriverWait wait;
    SellerInfoPageSelector selector;

    public SellerInfoPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.selector = new SellerInfoPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean checkGetDirections() {
        return driver.findElement(selector.getGetDirectionButtonSelector()).isDisplayed();
    }

    public boolean checkEmailDealer() {
        return driver.findElement(selector.getEmailDealerButtonSelector()).isDisplayed();
    }

    public void emailDealer() {
        driver.findElement(selector.getEmailDealerButtonSelector()).click();
    }

    public void submitEmail() {
        List<WebElement> choices = driver.findElements(selector.getEmailButtonSelector());
        wait.until(ExpectedConditions.elementToBeClickable(choices.get(1))).click();
    }

    public boolean checkAlertDisplayed() {
        List<WebElement> choices = driver.findElements(selector.getAlertTextSelector());
        return choices.size() == 3;
    }

    public void cancelEmail() {
        List<WebElement> choices = driver.findElements(selector.getEmailButtonSelector());
        wait.until(ExpectedConditions.elementToBeClickable(choices.get(0))).click();
    }

    public boolean checkViewInventory() {
        return driver.findElement(selector.getViewInventoryButtonSelector()).isDisplayed();
    }

    public boolean checkOnCorrectPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getCheckOnPageSelector()));
        return driver.findElement(selector.getCheckOnPageSelector()).getText().contains("Seller Info");
    }

    public VehicleDetailsPage clickCarInfo(){
        List<WebElement> choice = driver.findElements(selector.getNavBarSelector());
        wait.until(ExpectedConditions.elementToBeClickable(choice.get(0)));
        choice.get(0).click();
        return new VehicleDetailsPage(driver);
    }

    public void clickPhoneToCall(){
        List<WebElement> choice = driver.findElements(selector.getButtonsSelector());
        wait.until(ExpectedConditions.elementToBeClickable(choice.get(26))).click();
    }

    public ResearchPage clickResearch(){
        List<WebElement> choice = driver.findElements(selector.getNavBarSelector());
        wait.until(ExpectedConditions.elementToBeClickable(choice.get(2)));
        choice.get(2).click();
        return new ResearchPage(driver);
    }

    public void clickSellYourCallButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getSellYourCar())).click();
    }


}
