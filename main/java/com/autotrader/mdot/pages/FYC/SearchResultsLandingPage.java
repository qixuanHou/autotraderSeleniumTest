package com.autotrader.mdot.pages.FYC;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.pages.misc.HomeSidePage;
import com.autotrader.mdot.pages.misc.SignInPage;
import com.autotrader.mdot.pages.misc.VehicleDetailsPage;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 8/21/2015.
 */
public class SearchResultsLandingPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor jse;
    WaitFor waitFor;
    SearchResultsLandingPageSelector selector;


    public SearchResultsLandingPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.waitFor = new WaitFor(driver);
        this.jse = (JavascriptExecutor)driver;
        this.selector = new SearchResultsLandingPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector.getFilterButtonSelector())).isDisplayed();
    }

    public boolean checkOnNationalSrp(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector.getNationalSrpHeaderSelector())).isDisplayed();
    }

    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getSaveSearchStarButtonSelector());
    }

    public HomeSidePage clickHamburgerButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getHamburgerButtonSelector())).click();
        return new HomeSidePage(driver);
    }

    public SignInPage clickSaveSearchStarButtonLoggedOut(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSaveSearchStarButtonSelector())).click();
        return new SignInPage(driver);
    }

    public void clickSaveSearchStarButtonLoggedIn(){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getSaveSearchStarButtonSelector())).click();
    }

    public void inputSavedSearchName(String text){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSavedSearchNameInputSelector()));
        driver.findElement(selector.getSavedSearchNameInputSelector()).sendKeys(text);
    }

    public void clickDoneButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getDoneSavedSearchButtonSelector())).click();
    }

    public FiltersSliderPage clickFiltersButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getFilterButtonSelector()));
        driver.findElement(selector.getFilterButtonSelector()).click();
        return new FiltersSliderPage(driver);
    }

    public VehicleDetailsPage clickFirstListingAndGoToVDP(){
        driver.findElement(selector.getFirstListingSelector()).click();
        if(wait.until(ExpectedConditions.stalenessOf(driver.findElement(selector.getPrimaryPriceSelector())))) {
            wait.until(ExpectedConditions.presenceOfElementLocated(selector.getPrimaryPriceSelector()));
        }
        return new VehicleDetailsPage(driver);
    }

    public VehicleDetailsPage clickOneListing(int i) {
        List<WebElement> choices = driver.findElements(selector.getListingsSelector());
        wait.until(ExpectedConditions.elementToBeClickable(choices.get(i))).click();
        return new VehicleDetailsPage(driver);
    }

    public void saveListing(int i){
        List<WebElement> stars = driver.findElements(selector.getSaveListingStarSelector());
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getSaveListingStarSelector()));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", stars.get(i));
    }

    public void unSaveListing(int i){
        List<WebElement> saveSearchStar = driver.findElements(selector.getSaveSearchStarSelector());
        wait.until(ExpectedConditions.elementToBeClickable(saveSearchStar.get(i)));
        saveSearchStar.get(i).click();
    }

    public void clickListView(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getListViewButtonSelector()));
        driver.findElement(selector.getListViewButtonSelector()).click();
    }

    public void clickImageView(){
        driver.findElement(selector.getImageViewButtonSelector()).click();
    }

    public boolean confirmPage() {
        return driver.findElement(selector.getFilterButtonSelector()).isDisplayed();
    }

    public void changeSortingOption(String selectedSortingOption) {
        WebElement select = driver.findElement(selector.getSortOptionSelector());
        select.click();
        List<WebElement> allOptions = select.findElements(selector.getOptionSelector());
        for (WebElement option : allOptions) {
            if (option.getText().contentEquals(selectedSortingOption)) {
                option.click();
                break;
            }
        }
    }

    public boolean confirmSortSelected(String chosen) {
        String selectedOption = new Select(driver.findElement(selector.getSelectedOptionSelector())).getFirstSelectedOption().getText();
        return selectedOption.contains(chosen);
    }

    public boolean confirmImageView() {
        return driver.findElement(selector.getImageViewSelector()).isDisplayed();
    }

    public boolean confirmListView() {
        return driver.findElements(selector.getListViewSelector()).get(1).isDisplayed();
    }

    public boolean verifySaveSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSaveSearchStarButtonSelector()));
        return driver.findElement(selector.getSaveSearchStarButtonSelector()).isDisplayed();
    }

    public boolean verifyFilterOptions(String text){
        List<WebElement> e = driver.findElements(selector.getListingSortBySelector());
        return e.get(0).getText().contains(text);
    }

    public boolean verifyFirstAdIsDisplayed(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getFirstAdSelector()));
        return driver.findElement(selector.getFirstAdSelector()).isDisplayed();
    }

    public boolean verifySecondAdIsDisplayed(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSecondAdSelector()));
        return driver.findElement(selector.getSecondAdSelector()).isDisplayed();
    }

    public boolean verifyPremiumListingsBannerIsDisplayed(){
        return driver.findElement(selector.getPremiumListingsBannerSelector()).isDisplayed();
    }

    public boolean verifyThirdAdIsDisplayed(){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getThirdAdSelector()));
        return driver.findElement(selector.getThirdAdSelector()).isDisplayed();
    }

    public void clickTapToLoadMore(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getTapToLoadMoreSelector()));
        driver.findElement(selector.getTapToLoadMoreSelector()).click();
    }

    public void clickAlphaAdCarouselByIndex(int index){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getAlphaAdCarouselSelector())).get(index).click();
    }

    public boolean verifyPriceListed(String minPrice, String maxPrice, int index){
        String priceListed = driver.findElements(selector.getPriceValuesListedSelector()).get(index).getText();
        int min = Integer.parseInt(minPrice);
        int max = Integer.parseInt(maxPrice);
        int length = priceListed.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            Character character = priceListed.charAt(i);
            if (Character.isDigit(character)) {
                result += character;
            }
        }
        Integer cashMoney = Integer.valueOf(result);
        return ((cashMoney >= min) && (cashMoney <= max));
    }

    public boolean verifyYearListed(String fromYear, String toYear, int index){
        String yearListed = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector.getYearValueListedSelector())).get(index).getText();
        int min = Integer.parseInt(fromYear);
        int max = Integer.parseInt(toYear);
        int returnYear = Integer.parseInt(yearListed);
        return ((returnYear >= min) && (returnYear <= max));
    }

    public boolean verifyMakeListed(String make, int index){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getMakeValueListedSelector()));
        String comparableMake = driver.findElements(selector.getMakeValueListedSelector()).get(index).getText();
        return make.equals(comparableMake);
    }

    public boolean verifyModelListed(String model, int index){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getModelValueListedSelector()));
        String comparableModel = driver.findElements(selector.getModelValueListedSelector()).get(index).getText();
        return model.equals(comparableModel);
    }

    public boolean verifyExtColorListed(String extColor, int index){
        return driver.findElements(selector.getExtColorConditionMileageListedSelector()).get(index).getText().contains(extColor);
    }

    public boolean verifyConditionListed(String condition, int index){
        boolean result = driver.findElements(selector.getExtColorConditionMileageListedSelector()).get(index).getText().contains(condition);
        if (!result) {
            return  driver.findElements(selector.getExtColorConditionMileageListedSelector()).get(index).getText().contains("Certified");
        } else {
            return result;
        }
    }

    public boolean verifyTrimListed(String trim, int index) {
        return driver.findElements(selector.getTrimValueListedSelector()).get(index).getText().contains(trim);
    }

    public boolean verifyMileageListed(int min, int max, int index){
        String s = driver.findElements(selector.getExtColorConditionMileageListedSelector()).get(index).getText();
        int length = s.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            Character character = s.charAt(i);
            if (Character.isDigit(character) || character.equals(".")) {
                result += character;
            }
        }
        int mileage =  Integer.parseInt(result);
        return mileage <= max && mileage >= min;
    }

    public boolean verifyLocationListed(int radius, int index) {
        String s = driver.findElements(selector.getActionItemSelector()).get(index).getText();
        int length = s.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            Character character = s.charAt(i);
            if (character == '.') {
                break;
            } else if (Character.isDigit(character)) {
                result = result + character;
            }
        }
        int distance =  Integer.parseInt(result);
        return radius >= distance;
    }

    public int getHeader() {
        String header = driver.findElement(selector.getHeaderSelector()).getText();
        String expected = header.substring(0, header.indexOf(" "));
        return Integer.parseInt(expected);
    }

    public boolean checkListingNumber(int expectedNum) {
        List<WebElement> listings = driver.findElements(selector.getListingSelector());
        int num = listings.size();
        return num <= expectedNum;
    }

    public int getListNumber() {
        List<WebElement> listings = driver.findElements(selector.getListingSelector());
        return listings.size();
    }

    public boolean verifyAlphaAd(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector.getAlphaAdSelector())).isDisplayed();
    }

    public boolean verifyViewInventoryFromAlphaAd(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector.getAlphaAdViewInventorySelector())).isDisplayed();
    }


}

