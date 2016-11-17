package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.utilities.Environments;
import com.autotrader.mdot.utilities.WaitFor;
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
public class ResearchPage {
    public WebDriver driver;
    Environments url = new Environments();
    WaitFor wait;
    ResearchPageSelector selector;
    public WebDriverWait driverWait;

    public ResearchPage(WebDriver driver){
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, 20);
        this.wait = new WaitFor(driver);
        this.selector = new ResearchPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitForObject() {
        wait.waitForExpectedConditions(driver, selector.getContentSelector());
    }

    public boolean checkOnCorrectPage(){
        driverWait.until(ExpectedConditions.presenceOfElementLocated(selector.getCheckPageSelector()));
        return driver.findElement(selector.getCheckPageSelector()).getText().contains("Research");
    }

    public void clickArticleByIndex(int index){
        List<WebElement> articles = driver.findElements(selector.getContentSelector());
        driverWait.until(ExpectedConditions.elementToBeClickable(articles.get(index)));
        articles.get(index).click();
    }

    public VehicleDetailsPage clickCarInfo(){
        List<WebElement> choice = driver.findElements(selector.getNavBarSelector());
        driverWait.until(ExpectedConditions.elementToBeClickable(choice.get(0)));
        choice.get(0).click();
        return new VehicleDetailsPage(driver);
    }

    public SellerInfoPage clickSellerInfo(){
        List<WebElement> choice = driver.findElements(selector.getNavBarSelector());
        driverWait.until(ExpectedConditions.elementToBeClickable(choice.get(2)));
        choice.get(2).click();
        return new SellerInfoPage(driver);
    }
}
