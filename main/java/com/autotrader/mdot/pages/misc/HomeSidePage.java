package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.pages.Dealers.DealerLocationPage;
import com.autotrader.mdot.pages.Dealers.DealerSearchResultsPage;
import com.autotrader.mdot.pages.FYC.SearchResultsLandingPage;
import com.autotrader.mdot.pages.SYC.SycLandingPage;
import com.autotrader.mdot.pages.TIM.TimLandingPage;
import com.autotrader.mdot.pages.TIM.TimRetrieveOfferPage;
import com.autotrader.mdot.pages.TIM.TimReviewOfferPage;
import com.autotrader.mdot.utilities.Environments;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by cher1 on 7/14/2015.
 */
public class HomeSidePage {

    // Declare driver
    public WebDriver driver;
    public WebDriverWait wait;

    WaitFor waitFor;
    HomeSidePageSelector selector;

    // Constructor
    public HomeSidePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.selector = new HomeSidePageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getSideMenuLinksSelector());
    }
    //<editor-fold desc="Click Home">
    public HomeMainPage clickSideMenuHomeLink(String linkName) {
        // Load the list
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());

        // Loop through the array until the link is found and then click the link
        for (WebElement e : clickLink) {
            if (e.getText().equals(linkName)) {
                e.click();
                break;
            }
        }
        return new HomeMainPage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Saved Listings (Signed Out)">
    public SignInPage clickSideMenuSavedListingsLink(String linkName) {
        // Load the list
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());

        // Loop through the array until the link is found and then click the link
        for (WebElement e : clickLink) {
            if (e.getText().equals(linkName)) {
                e.click();
                break;
            }
        }
        return new SignInPage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Saved Listings (Signed In)">
    public SavedListingsPage clickSideMenuSavedListingsLinkSignedIn(String linkName) {
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());

        // Loop through the array until the link is found and then click the link
        for (WebElement e : clickLink) {
            if (e.getText().contains(linkName)) {
                e.click();
                break;
            }
        }
        return new SavedListingsPage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Saved Searches (Signed Out)">
    public SignInPage clickSideMenuSavedSearchesLink(String linkName) {
        // Load the list
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());

        // Loop through the array until the link is found and then click the link
        for (WebElement e : clickLink) {
            if (e.getText().equals(linkName)) {
                e.click();
                break;
            }
        }
        return new SignInPage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Saved Searches (Signed In)">
    public SavedSearchPage clickSideMenuSavedSearchesLinkSignedIn(String linkName) {
        // Load the list
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());

        // Loop through the array until the link is found and then click the link
        for (WebElement e : clickLink) {
            if (e.getText().contains(linkName)) {
                e.click();
                break;
            }
        }
        return new SavedSearchPage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Dealers">
    public DealerLocationPage clickSideMenuDealersLink(String linkName) {
        // Load the list
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());

        // Loop through the array until the link is found and then click the link
        for (WebElement e : clickLink) {
            if (e.getText().equals(linkName)) {
                e.click();
                break;
            }
        }
        return new DealerLocationPage(driver);
    }
    //</editor-fold>

    public DealerSearchResultsPage clickSideMenuDealersLinkFromDdp(String linkName){
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e : clickLink){
            if(e.getText().equals(linkName)){
                e.click();
                break;
            }
        }
        return new DealerSearchResultsPage(driver);
    }

    //<editor-fold desc="Click Fraud Awareness">
    public FraudAwarenessPage clickSideMenuFraudAwareness(String linkName){
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e : clickLink){
            if(e.getText().equals(linkName)){
                e.click();
                break;
            }
        }
        return new FraudAwarenessPage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Payment Calculator">
    public CalculatePaymentPage clickSideMenuPaymentCalculator(String linkName){
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e: clickLink){
            if(e.getText().equals(linkName)){
                e.click();
                break;
            }
        }
        return new CalculatePaymentPage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Sign Up/Sign In">
    public SignInPage clickSignInSignUp(String linkName){
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e : clickLink){
            if(e.getText().equals(linkName)){
                e.click();
                break;
            }
        }
        return new SignInPage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Privacy Policy">
    public PrivacyPolicyPage clickPrivacyPolicy(String linkName){
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e : clickLink){
            if(e.getText().equals(linkName)){
                e.click();
                break;
            }
        }
        return new PrivacyPolicyPage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Sign Out">
    public HomeMainPage clickSignOut(String linkName){
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e : clickLink){
            if(e.getText().equals(linkName)){
                e.click();
                break;
            }
        }
        return new HomeMainPage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Desktop Site">
    public ATHomePage clickDesktopSite(String linkName){
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e : clickLink){
            if(e.getText().equals(linkName)){
                e.click();
                break;
            }
        }
        return new ATHomePage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Trade In Your Car">
    public TimLandingPage clickTradeInYourCar(String linkName){
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e : clickLink){
            if(e.getText().equals(linkName)){
                e.click();
                break;
            }
        }
        return new TimLandingPage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Retrieve My Offer">
    public TimRetrieveOfferPage clickRetrieveMyOffer(String linkName){
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e : clickLink){
            if(e.getText().equals(linkName)){
                e.click();
                break;
            }
        }
        return new TimRetrieveOfferPage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Sell Your Car">
    public SycLandingPage clickSellYourCar(String linkName){
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e : clickLink){
            if(e.getText().equals(linkName)){
                e.click();
                break;
            }
        }
        return new SycLandingPage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Edit Your Ad">
    public SycLandingPage clickEditYourAd(String linkName){
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e : clickLink){
            if(e.getText().equals(linkName)){
                e.click();
                break;
            }
        }
        return new SycLandingPage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Edit Your Ad (Account has placed an Ad)">
    public EditYourAdPage clickEditYourAdWithAd(String linkName){
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e : clickLink){
            if(e.getText().equals(linkName)){
                e.click();
                break;
            }
        }
        return new EditYourAdPage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Visitor Agreement">
    public VisitorAgreementPage clickVisitorAgreement(String linkName){
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e : clickLink){
            if(e.getText().equals(linkName)){
                e.click();
                break;
            }
        }
        return new VisitorAgreementPage(driver);
    }
    //</editor-fold>

    //<editor-fold desc="Click Copyright, Feedback, or AdChoices ">
    public void clickPopUpLinks(String linkName){
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e : clickLink){
            if(e.getText().equals(linkName)){
                e.click();
                break;
            }
        }
    }
    //</editor-fold>

    public boolean verifyAmountOfSavedListings(String linkName, String amt){
        boolean verify = false;
        List<WebElement> link = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e : link){
            if((e.getText().contains(linkName))&&(e.getText().contains(amt))){
                verify = true;
                break;
            }
        }
        return verify;
    }

    public boolean verifyAmountOfSavedSearches(String linkName, String amt){
        boolean verify = false;
        List<WebElement> link = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e : link){
            if((e.getText().contains(linkName))&&(e.getText().contains(amt))){
                verify = true;
                break;
            }
        }
        return verify;
    }

    public SearchResultsLandingPage clickReturnToSearch(String linkName){
        List<WebElement> clickLink = driver.findElements(selector.getSideMenuLinksSelector());
        for(WebElement e : clickLink){
            if(e.getText().equals(linkName)){
                e.click();
                break;
            }
        }
        return new SearchResultsLandingPage(driver);
    }

    public SignInPage confirmLogOut(){
        driver.findElement(selector.getConfirmLogoutButtonSelector()).click();
        return new SignInPage(driver);
    }








}
