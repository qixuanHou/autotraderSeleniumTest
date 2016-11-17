package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.pages.Dealers.DealerLocationPage;
import com.autotrader.mdot.pages.FYC.*;
import com.autotrader.mdot.pages.SYC.SycLandingPage;
import com.autotrader.mdot.pages.TIM.TimLandingPage;
import com.autotrader.mdot.utilities.Environments;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by cher1 on 7/13/2015.
 */
public class HomeMainPage {

    // Declare driver
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    WaitFor waitFor;
    JavascriptExecutor jse;
    HomeMainPageSelector selector;

    // Constructor
    public HomeMainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        actions = new Actions(driver);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new HomeMainPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // Call utilities folder
    Environments url = new Environments();

    // Page objects and declarations
    public String pageUrl = url.getUrl();

    public HomeSidePage clickHambergerButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getHamburgerButtonSelector())).click();
        return new HomeSidePage(driver); // This is the handoff to the home side page
    }

    public void waitForObject() {
        waitFor.waitForExpectedConditions(driver, selector.getImageSelector());
    }

    public boolean checkOnCorrectPage(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getImageSelector()));
        return driver.findElement(selector.getImageSelector()).isDisplayed();
    }

    public boolean checkForAd(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getHomeHeaderAdSelector()));
        return driver.findElement(selector.getHomeHeaderAdSelector()).isDisplayed();
    }

    public SignInPage clickSignInButtonTopRight(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSignInButtonTopRightSelector()));
        driver.findElement(selector.getSignInButtonTopRightSelector()).click();
        return new SignInPage(driver);
    }

    public SignInPage clickSignInButtonBottom(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSignInButtonBottomSelector()));
        driver.findElement(selector.getSignInButtonBottomSelector()).click();
        return new SignInPage(driver);
    }

    public NewUsedCertifiedSliderPage clickNewUsedCertified(){
        List<WebElement> slider = driver.findElements(selector.getSliderSelector());
        wait.until(ExpectedConditions.elementToBeClickable(slider.get(0)));
        slider.get(0).click();
        return new NewUsedCertifiedSliderPage(driver);
    }

    public YearMakeModelTrimSliderPage clickYearMakeModelTrim(){
        List<WebElement> slider = driver.findElements(selector.getSliderSelector());
        wait.until(ExpectedConditions.elementToBeClickable(slider.get(1)));
        slider.get(1).click();
        return new YearMakeModelTrimSliderPage(driver);
    }

    public StyleSliderPage clickStyle(){
        List<WebElement> slider = driver.findElements(selector.getSliderSelector());
        wait.until(ExpectedConditions.elementToBeClickable(slider.get(2)));
        slider.get(2).click();
        return new StyleSliderPage(driver);
    }

    public LocationAndRadiusSliderPage clickLocationAndRadius(){
        List<WebElement> slider = driver.findElements(selector.getSliderSelector());
        wait.until(ExpectedConditions.elementToBeClickable(slider.get(4)));
        slider.get(4).click();
        return new LocationAndRadiusSliderPage(driver);
    }

    public MoreOptionsSliderPage clickMoreOptions(){
        List<WebElement> slider = driver.findElements(selector.getSliderSelector());
        wait.until(ExpectedConditions.elementToBeClickable(slider.get(3)));
        slider.get(3).click();
        return new MoreOptionsSliderPage(driver);
    }

    public SearchResultsLandingPage clickSearchForCars(){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getSearchForCarsButtonSelector()));
        waitFor.staleElementClick(selector.getSearchForCarsButtonSelector());
        return new SearchResultsLandingPage(driver);
    }

    public LocationAndRadiusSliderPage clickSearchForCarsWithoutZipCode(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSearchForCarsButtonSelector()));
        driver.findElement(selector.getSearchForCarsButtonSelector()).click();
        return new LocationAndRadiusSliderPage(driver);
    }

    public HomeMainPage confirmLogOut(){
        driver.findElement(selector.getConfirmLogoutButtonSelector()).click();
        return new HomeMainPage(driver);
    }

    public SycLandingPage clickSellYourVehicle(){
        List<WebElement> btn = driver.findElements(selector.getVehicleButtonsSelector());
        btn.get(0).click();
        return new SycLandingPage(driver);
    }

    public TimLandingPage clickTradeYourVehicle(){
        List<WebElement> btn = driver.findElements(selector.getVehicleButtonsSelector());
        btn.get(1).click();
        return new TimLandingPage(driver);
    }

    public DealerLocationPage clickViewAllDealers(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getViewAllDealersButtonSelector()));
        driver.findElement(selector.getViewAllDealersButtonSelector()).click();
        return new DealerLocationPage(driver);
    }

    public VisitorAgreementPage clickPrivacyPolicyLink(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getPrivacyPolicyLinkSelector()));
        driver.findElement(selector.getPrivacyPolicyLinkSelector()).click();
        return new VisitorAgreementPage(driver);
    }

    public boolean confirmUsedSelectedCertifiedDisplayed(String chosenType) {
        return driver.findElements(selector.getFYCFilterLabelListSelector()).get(1).getText().contains(chosenType);
    }

    public boolean confirmYearMakeModelTrim(String chosenType) {
        return driver.findElements(selector.getFYCFilterLabelListSelector()).get(3).getText().contains(chosenType);
    }

    public boolean confirmStyle(String chosenType) {
        return driver.findElements(selector.getFYCFilterLabelListSelector()).get(5).getText().contains(chosenType);
    }

    public boolean confirmOption(String chosenType) {
        return driver.findElements(selector.getFYCFilterLabelListSelector()).get(7).getText().contains(chosenType);
    }

    public boolean confirmRadiusAndLocation(String chosenType) {
        return driver.findElements(selector.getFYCFilterLabelListSelector()).get(9).getText().contains(chosenType);
    }

    public boolean verifySignInTopRight(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSignInButtonTopRightSelector()));
        return driver.findElement(selector.getSignInButtonTopRightSelector()).isDisplayed();
    }

    public boolean verifySignInBottom(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSignInButtonBottomSelector()));
        return driver.findElement(selector.getSignInButtonBottomSelector()).isDisplayed();
    }

    public boolean checkFYCDisplayed() {
        return driver.findElements(selector.getHeaderSelector()).get(0).getText().contains("Find Cars for Sale");
    }

    public boolean checkFYCNewUsedCertifiedFilterDisplayed(String type) {
        return driver.findElements(selector.getFYCFilterLabelListSelector()).get(0).getText().contains("New") &&
                driver.findElements(selector.getFYCFilterLabelListSelector()).get(1).getText().contains(type);
    }

    public boolean checkFYCYearMakeModelTrimFilterDisplayed(String type) {
        return driver.findElements(selector.getFYCFilterLabelListSelector()).get(2).getText().contains("Year") &&
                driver.findElements(selector.getFYCFilterLabelListSelector()).get(3).getText().contains(type);
    }

    public boolean checkFYCStyleFilterDisplayed(String type) {
        return driver.findElements(selector.getFYCFilterLabelListSelector()).get(4).getText().contains("Style") &&
                driver.findElements(selector.getFYCFilterLabelListSelector()).get(5).getText().contains(type);
    }

    public boolean checkFYCMoreOptionFilterDisplayed(String type) {
        return driver.findElements(selector.getFYCFilterLabelListSelector()).get(6).getText().contains("Option") &&
                driver.findElements(selector.getFYCFilterLabelListSelector()).get(7).getText().contains(type);
    }

    public boolean checkFYCLocationRadiusFilterDisplayed() {
        return driver.findElements(selector.getFYCFilterLabelListSelector()).get(8).getText().contains("Location");
    }

    public boolean checkSearchForCarButtonDisplayed() {
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getSearchForCarsButtonSelector())).isDisplayed();
    }

    public boolean verifyDealersButtonIsClickable(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getViewAllDealersButtonSelector())).isDisplayed();
    }

    public boolean verifyNewUsedCertifiedIsClickable(){
        return driver.findElements(selector.getFYCFilterLabelListSelector()).get(0).isDisplayed();
    }

    public boolean verifyYearMakeModelTrimIsClickable(){
        return driver.findElements(selector.getFYCFilterLabelListSelector()).get(2).isDisplayed();
    }

    public boolean verifyStyleIsClickable(){
        return driver.findElements(selector.getFYCFilterLabelListSelector()).get(4).isDisplayed();
    }

    public boolean verifyMoreOptionsIsClickable(){
        return driver.findElements(selector.getFYCFilterLabelListSelector()).get(6).isDisplayed();
    }

    public boolean verifyLocationAndRadiusIsClickable(){
        return driver.findElements(selector.getFYCFilterLabelListSelector()).get(8).isDisplayed();
    }

    public boolean verifyTradeYourVehicleButtonIsClickable(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getTradeYourVehicleSelector())).isDisplayed();
    }

    public boolean verifySellYourVehicleButton(){
        return wait.until(ExpectedConditions.elementToBeClickable(selector.getSellYourVehicleButtonSelector())).isDisplayed();
    }


}
