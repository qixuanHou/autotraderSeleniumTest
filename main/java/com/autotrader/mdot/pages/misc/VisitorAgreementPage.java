package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.pages.FYC.SearchResultsLandingPage;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/12/2015.
 */
public class VisitorAgreementPage {

    public WebDriver driver;
    public WebDriverWait wait;
    WaitFor waitFor;
    VisitorAgreementPageSelector selector;


    public VisitorAgreementPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.selector = new VisitorAgreementPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getAcceptAgreementButtonSelector());
    }

    public SavedListingsPage clickOnAcceptAgreement(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getAcceptAgreementButtonSelector())).click();
        return new SavedListingsPage(driver);
    }

    public SearchResultsLandingPage clickOnAcceptAgreementSrp(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getAcceptAgreementButtonSelector())).click();
        return new SearchResultsLandingPage(driver);
    }

    public boolean checkOnCorrectPageAfterSignUp(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getAcceptAgreementButtonSelector())).isDisplayed();
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getVisitorAgreementHeaderSelector(), "Visitor Agreement"));
    }
}
