package com.autotrader.mdot.testsuites.regression;

import com.autotrader.mdot.pages.FYC.FiltersSliderPage;
import com.autotrader.mdot.pages.FYC.LocationAndRadiusSliderPage;
import com.autotrader.mdot.pages.FYC.SearchResultsLandingPage;
import com.autotrader.mdot.pages.FYC.YearMakeModelTrimSliderPage;
import com.autotrader.mdot.pages.misc.*;
import com.autotrader.mdot.testsuites.TestExtension;
import com.autotrader.mdot.utilities.mDotElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 10/2/2015.
 */
public class MyAtcRegression extends TestExtension {



    LocationAndRadiusSliderPage locationAndRadiusSliderPage;
    HomeMainPage homeMainPage;
    SearchResultsLandingPage searchResultsLandingPage;
    SavedListingsPage savedListingsPage;
    SavedSearchPage savedSearchPage;
    SignInPage signInPage;
    SignUpPage signUpPage;
    VisitorAgreementPage visitorAgreementPage;
    HomeSidePage homeSidePage;
    FiltersSliderPage filtersSliderPage;
    VehicleDetailsPage vehicleDetailsPage;

    private String generatedEmail = generateEmail();
    private String zip = "30032";
    private String saveSearchOne = "Saved Search 1";
    private String saveSearchTwo = "Saved Search 2";
    private String saveSearchThree = "Saved Search 3";
    private String fromYear = "1998";
    private String toYear = "2015";
    private String make = "Honda";
    private String model = "Accord";
    private String condition = "Used";
    private String minPrice = "5000";
    private String maxPrice = "30000";
    private String mileage = "Under 100,000";
    private String doors = "Four Door";
    private String fuelType = "Gasoline";

    private String[] sortingOptions = {"Distance - Near to Far", "Distance - Far to Near", "Price - High to Low", "Price - Low to High",
                                      "Mileage - Low to High", "Mileage - High to Low", "Year - New to Old", "Year - Old to New", "Make/Model - A to Z",
                                      "Make/Model - Z to A", "Best Match"};

    @BeforeClass(alwaysRun = true)
    public void setUp(){

        locationAndRadiusSliderPage = new LocationAndRadiusSliderPage(driver);
        homeMainPage = new HomeMainPage(driver);
        searchResultsLandingPage = new SearchResultsLandingPage(driver);
        savedListingsPage = new SavedListingsPage(driver);
        savedSearchPage = new SavedSearchPage(driver);
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);
        visitorAgreementPage = new VisitorAgreementPage(driver);
        homeSidePage = new HomeSidePage(driver);
        filtersSliderPage = new FiltersSliderPage(driver);
        vehicleDetailsPage = new VehicleDetailsPage(driver);
    }

    @Test
    public void shouldBeAbleToLandOnHomePage(){
        driver.get(baseUrl);
        assertTrue(homeMainPage.checkOnCorrectPage());
        }

    /**
     * SAVED LISTINGS / SAVED SEARCHES
     *
     */

    @Test(dependsOnMethods = {"shouldBeAbleToLandOnHomePage"})
    public void shouldBeAbleToClickLocationAndRadius(){
        locationAndRadiusSliderPage = homeMainPage.clickLocationAndRadius();
        locationAndRadiusSliderPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickLocationAndRadius"})
    public void shouldBeAbleToEnterAZip(){
        locationAndRadiusSliderPage.setZip(zip);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEnterAZip"})
    public void shouldBeAbleToEnterARadius(){
        locationAndRadiusSliderPage.selectRadius(mDotElements.Radius.FIVE_HUNDRED_MILES);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEnterARadius"})
    public void shouldClickDone() throws InterruptedException{
        locationAndRadiusSliderPage.clickOnDone();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldClickDone"})
    public void shouldClickSearchForCarsAndBeRedirectedToSrp(){
        searchResultsLandingPage = homeMainPage.clickSearchForCars();
        assertTrue(searchResultsLandingPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldClickSearchForCarsAndBeRedirectedToSrp"})
    public void verifySaveSearchStarButtonIsDisplayed(){
        searchResultsLandingPage.verifySaveSearchButton();
    }

    @Test(dependsOnMethods = {"verifySaveSearchStarButtonIsDisplayed"})
    public void verifySortingOptions(){
        for(int i = 0; i < sortingOptions.length; i++){
            assertTrue(searchResultsLandingPage.verifyFilterOptions(sortingOptions[i]));
        }
    }

    @Test(dependsOnMethods = {"verifySortingOptions"})
    public void shouldAttemptToSaveASearch(){
        signInPage = searchResultsLandingPage.clickSaveSearchStarButtonLoggedOut();
        assertTrue(signInPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldAttemptToSaveASearch"})
    public void shouldNavigateToSignUpPageFromSaveSearch(){
        signUpPage = signInPage.clickSignUpNow();
        assertTrue(signUpPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldNavigateToSignUpPageFromSaveSearch"})
    public void shouldAttemptToSignUpWithError(){
        signUpPage.clickSignUpButton();
        assertTrue(signUpPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldAttemptToSignUpWithError"})
    public void shouldCatchEmailValidationError(){
        assertTrue(signUpPage.validateEmailError());
    }

    @Test(dependsOnMethods = {"shouldCatchEmailValidationError"})
    public void shouldEnterEmail(){
        signUpPage.enterEmailAddress(generatedEmail);
    }

    @Test(dependsOnMethods = {"shouldEnterEmail"})
    public void shouldReEnterEmail(){
        signUpPage.reEnterEmailAddress(generatedEmail);
    }

    @Test(dependsOnMethods = {"shouldReEnterEmail"})
    public void shouldAttemptToSignUpWithoutPass(){
        signUpPage.clickSignUpButton();
        assertTrue(signUpPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldAttemptToSignUpWithoutPass"})
    public void shouldCatchPasswordValidationError(){
        assertTrue(signUpPage.validatePasswordError());
    }

    @Test(dependsOnMethods = {"shouldCatchPasswordValidationError"})
    public void shouldBeAbleToEnterAPassword(){
        signUpPage.enterPassword();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEnterAPassword"})
    public void shouldBeAbleToConfirmPassword(){
        signUpPage.reEnterPassword();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToConfirmPassword"})
    public void shouldClickSignUpAndBeRedirectedToVisitorAgreementPage(){
        visitorAgreementPage = signUpPage.clickSignUpButton();
        assertTrue(visitorAgreementPage.checkOnCorrectPageAfterSignUp());
    }

    @Test(dependsOnMethods = {"shouldClickSignUpAndBeRedirectedToVisitorAgreementPage"})
    public void shouldBeAbleToAcceptTheAgreement() throws InterruptedException{
        savedListingsPage = visitorAgreementPage.clickOnAcceptAgreement();
        assertTrue(savedListingsPage.checkOnCorrectPageAfterAcceptingAgreement());
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToAcceptTheAgreement"})
    public void shouldBeAbleToClickStartYourSearch(){
        homeMainPage = savedListingsPage.clickStartYourSearch();
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickStartYourSearch"})
    public void shouldBeAbleToClickSearchForCarsAndReturnToSrp(){
        searchResultsLandingPage = homeMainPage.clickSearchForCars();
        assertTrue(searchResultsLandingPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickSearchForCarsAndReturnToSrp"})
    public void shouldVerifyFirstAdIsDisplayed(){
        assertTrue(searchResultsLandingPage.verifyFirstAdIsDisplayed());
    }

    @Test(dependsOnMethods = {"shouldVerifyFirstAdIsDisplayed"})
    public void shouldVerifySecondAdIsDisplayed(){
        assertTrue(searchResultsLandingPage.verifySecondAdIsDisplayed());
    }

    @Test(dependsOnMethods = {"shouldVerifySecondAdIsDisplayed"})
    public void shouldVerifyThirdAdIsDisplayed(){
        assertTrue(searchResultsLandingPage.verifyThirdAdIsDisplayed());
    }

    @Test(dependsOnMethods = {"shouldVerifyThirdAdIsDisplayed"})
    public void shouldBeAbleToClickSaveSearchStarAndSaveFirstSearch() throws InterruptedException{
        Thread.sleep(2000);
        searchResultsLandingPage.clickSaveSearchStarButtonLoggedIn();
        searchResultsLandingPage.inputSavedSearchName(saveSearchOne);
        searchResultsLandingPage.clickDoneButton();
        assertTrue(searchResultsLandingPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickSaveSearchStarAndSaveFirstSearch"})
    public void shouldBeAbleToVerifyPremiumListingsBanner(){
        assertTrue(searchResultsLandingPage.verifyPremiumListingsBannerIsDisplayed());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToVerifyPremiumListingsBanner"})
    public void shouldBeAbleToClickFilter(){
        filtersSliderPage = searchResultsLandingPage.clickFiltersButton();
        assertTrue(filtersSliderPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickFilter"})
    public void shouldBeAbleToFilterYearRange(){
        filtersSliderPage.selectFromAndToYear(fromYear, toYear);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToFilterYearRange"})
    public void shouldBeAbleToFilterMake()throws InterruptedException{
        filtersSliderPage.clickMakeAndSelect(make);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToFilterMake"})
    public void shouldBeAbleToFilterModel()throws InterruptedException{
        filtersSliderPage.clickModelAndSelect(model);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToFilterModel"})
    public void shouldBeAbleToFilterCondition(){
        filtersSliderPage.selectCondition(condition);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToFilterCondition"})
    public void shouldBeAbleToFilterPrice(){
        filtersSliderPage.enterMinAndMaxPrice(minPrice, maxPrice);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToFilterPrice"})
    public void shouldBeAbleToFilterMileage(){
        filtersSliderPage.selectMileage(mileage);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToFilterMileage"})
    public void shouldBeAbleToClickApplyAndVerifySrp() throws InterruptedException{
        searchResultsLandingPage = filtersSliderPage.clickOnApply();
        Thread.sleep(2000);
        assertTrue(searchResultsLandingPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickApplyAndVerifySrp"})
    public void shouldVerifyYear() throws InterruptedException{
        for(int i = 5; i < 8; i++){
            Thread.sleep(2000);
            assertTrue(searchResultsLandingPage.verifyYearListed(fromYear, toYear, i));
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyYear"})
    public void shouldVerifyMake(){
        for(int i = 5; i < 8; i++){
            assertTrue(searchResultsLandingPage.verifyMakeListed(make, i));
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyMake"})
    public void shouldVerifyModel(){
        for(int i = 5; i < 7; i++){
            assertTrue(searchResultsLandingPage.verifyModelListed(model, i));
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyModel"})
    public void shouldVerifyCondition(){
        for(int i = 5; i < 10; i++){
            assertTrue(searchResultsLandingPage.verifyConditionListed(condition, i));
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyCondition"})
    public void shouldVerifyAlphaAd(){
        assertTrue(searchResultsLandingPage.verifyAlphaAd());
    }

//    @Test(dependsOnMethods = {"shouldVerifyAlphaAd"})
//    public void shouldVerifyAlphaAdCarousel() throws InterruptedException{
//        for(int i = 0; i < 5; i++){
//            searchResultsLandingPage.clickAlphaAdCarouselByIndex(i);
//            Thread.sleep(2000);
//        }
//    }
//
//    @Test(dependsOnMethods = {"shouldVerifyAlphaAdCarousel"})
//    public void shouldVerifyAlphaAdContainsViewInventory(){
//        assertTrue(searchResultsLandingPage.verifyViewInventoryFromAlphaAd());
//    }

    @Test(dependsOnMethods = {"shouldVerifyAlphaAd"})
    public void shouldBeAbleToSaveFiveListings() throws InterruptedException{
        for(int i = 5; i < 10; i++){
            searchResultsLandingPage.saveListing(i);
            Thread.sleep(2000);
        }
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSaveFiveListings"})
    public void shouldVerifyAmountOfCurrentlySavedSearches(){
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        assertTrue(homeSidePage.verifyAmountOfSavedListings("SAVED LISTINGS", "5"));
        driver.navigate().refresh();
    }

    @Test(dependsOnMethods = {"shouldVerifyAmountOfCurrentlySavedSearches"})
    public void shouldBeAbleToUnSaveListingFromSrp() throws InterruptedException{
        searchResultsLandingPage.saveListing(5);
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToUnSaveListingFromSrp"})
    public void shouldBeAbleToAssertSavedListingIsRemoved(){
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        assertTrue(homeSidePage.verifyAmountOfSavedListings("SAVED LISTINGS", "4"));
        driver.navigate().refresh();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToAssertSavedListingIsRemoved"})
    public void shouldBeAbleToSaveSecondSearch() throws InterruptedException{
        Thread.sleep(2000);
        searchResultsLandingPage.clickSaveSearchStarButtonLoggedIn();
        searchResultsLandingPage.inputSavedSearchName(saveSearchTwo);
        searchResultsLandingPage.clickDoneButton();
        assertTrue(searchResultsLandingPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSaveSecondSearch"})
    public void shouldBeAbleToAccessFiltersTwice(){
        searchResultsLandingPage.clickFiltersButton();
        assertTrue(filtersSliderPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToAccessFiltersTwice"})
    public void shouldBeAbleToApplyFilterForDoors(){
        filtersSliderPage.selectDoors(doors);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToApplyFilterForDoors"})
    public void shouldBeAbleToApplyFilterForFuelType(){
        filtersSliderPage.selectFuelType(fuelType);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToApplyFilterForFuelType"})
    public void shouldBeAbleToClickApplyAndGoBackToSrp() throws InterruptedException{
        searchResultsLandingPage = filtersSliderPage.clickOnApply();
        Thread.sleep(2000);
        assertTrue(searchResultsLandingPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickApplyAndGoBackToSrp"})
    public void shouldBeAbleToSaveAThirdSearch()throws InterruptedException{
        Thread.sleep(2000);
        searchResultsLandingPage.clickSaveSearchStarButtonLoggedIn();
        searchResultsLandingPage.inputSavedSearchName(saveSearchThree);
        searchResultsLandingPage.clickDoneButton();
        assertTrue(searchResultsLandingPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSaveAThirdSearch"})
    public void shouldBeAbleToClickListingAndGoToVdp()throws InterruptedException{
        Thread.sleep(4000);
        vehicleDetailsPage = searchResultsLandingPage.clickOneListing(5);
        assertTrue(vehicleDetailsPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickListingAndGoToVdp"})
    public void shouldVerifyVdpAd(){
        assertTrue(vehicleDetailsPage.verifyVdpAdIsDisplayed());
    }

    @Test(dependsOnMethods = {"shouldVerifyVdpAd"})
    public void shouldAssertSaveListingStar(){
        assertTrue(vehicleDetailsPage.verifySaveListingStar());
    }

    @Test(dependsOnMethods = {"shouldAssertSaveListingStar"})
    public void shouldBeAbleToSaveListingFromVdp()throws InterruptedException{
        vehicleDetailsPage.saveListing();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSaveListingFromVdp"})
    public void shouldVerifyAmountOfSavedListings() throws InterruptedException{
        homeSidePage = vehicleDetailsPage.clickHamburgerButton();
        homeSidePage.waitForObject();
        Thread.sleep(2000);
        assertTrue(homeSidePage.verifyAmountOfSavedListings("SAVED LISTINGS", "5"));
    }

    @Test(dependsOnMethods = {"shouldVerifyAmountOfSavedListings"})
    public void shouldClickReturnToSearchAndVerifySrp(){
        searchResultsLandingPage = homeSidePage.clickReturnToSearch("RETURN TO SEARCH");
        assertTrue(searchResultsLandingPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldClickReturnToSearchAndVerifySrp"})
    public void shouldClickSavedListingsFromGnmAndVerifySavedListings(){
        homeSidePage = searchResultsLandingPage.clickHamburgerButton();
        homeSidePage.waitForObject();
        savedListingsPage = homeSidePage.clickSideMenuSavedListingsLinkSignedIn("SAVED LISTINGS");
        assertTrue(savedListingsPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldClickSavedListingsFromGnmAndVerifySavedListings"})
    public void shouldClickAndVerifyImageView(){
        savedListingsPage.clickImageView();
        assertTrue(savedListingsPage.verifyImageView());
    }

    @Test(dependsOnMethods = {"shouldClickAndVerifyImageView"})
    public void shouldClickAndVerifyListView(){
        savedListingsPage.clickListView();
        assertTrue(savedListingsPage.verifyListView());
    }

    @Test(dependsOnMethods = {"shouldClickAndVerifyListView"})
    public void shouldBeAbleToDeleteSavedListing() throws InterruptedException{
        savedListingsPage.deleteSavedListing(0);
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToDeleteSavedListing"})
    public void shouldBeAbleToClickEditButton()throws InterruptedException{
        savedListingsPage.clickOnEdit();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickEditButton"})
    public void shouldBeAbleToDeleteListingFromEditMode()throws InterruptedException{
        savedListingsPage.deleteListingFromEditMode(0);
        Thread.sleep(4000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToDeleteListingFromEditMode"})
    public void shouldBeAbleToDeleteAllFromEditMode() throws InterruptedException{
        savedListingsPage.deleteAllListings();
        savedListingsPage.confirmDeleteAll();
        Thread.sleep(4000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToDeleteListingFromEditMode"})
    public void shouldBeAbleToNavigateToSavedSearchesFromGnm(){
        homeSidePage = savedListingsPage.clickHamburgerButton();
        homeSidePage.waitForObject();
        savedSearchPage = homeSidePage.clickSideMenuSavedSearchesLinkSignedIn("SAVED SEARCHES");
        assertTrue(savedSearchPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToNavigateToSavedSearchesFromGnm"})
    public void shouldBeAbleToVerifyClickingSavedSearchRedirectsToSrp(){
        savedSearchPage.clickSavedSearchByIndex(0);
        assertTrue(searchResultsLandingPage.checkOnCorrectPage());
        driver.navigate().back();
        assertTrue(savedSearchPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToVerifyClickingSavedSearchRedirectsToSrp"})
    public void shouldBeAbleToDeleteASavedSearchFromEditMode() throws InterruptedException{
        savedSearchPage.clickEditButton();
        Thread.sleep(2000);
        savedSearchPage.deleteSearchFromEditMode(0);
        Thread.sleep(4000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToDeleteASavedSearchFromEditMode"})
    public void shouldBeAbleToDeleteAllSavedSearches() throws InterruptedException{
        savedSearchPage.clickDeleteAll();
        savedSearchPage.clickConfirmDeleteAll();
        Thread.sleep(4000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToDeleteAllSavedSearches"})
    public void shouldVerifyDeletionOfAllSavedSearches(){
        homeSidePage = savedSearchPage.clickHamburgerButton();
        homeSidePage.waitForObject();
        assertTrue(homeSidePage.verifyAmountOfSavedSearches("SAVED SEARCHES", "0"));
    }

    @Test(dependsOnMethods = {"shouldVerifyDeletionOfAllSavedSearches"})
    public void shouldVerifyDeletionOfAllSavedListings(){
        assertTrue(homeSidePage.verifyAmountOfSavedListings("SAVED LISTINGS", "0"));
    }

    @Test(dependsOnMethods = {"shouldVerifyDeletionOfAllSavedListings"})
    public void shouldBeAbleToSignOutFromGnm() throws InterruptedException{
        homeSidePage.clickSignOut("SIGN OUT");
        signInPage = homeSidePage.confirmLogOut();
        Thread.sleep(4000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSignOutFromGnm"})
    public void shouldLandOnSignInPage() throws InterruptedException{
        assertTrue(signInPage.checkOnCorrectPage());
        driver.get(baseUrl);
    }

    @Test(dependsOnMethods = {"shouldLandOnSignInPage"})
    public void shouldClickSignInFromGnm(){
        assertTrue(homeMainPage.checkOnCorrectPage());
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        signInPage = homeSidePage.clickSignInSignUp("SIGN UP/IN");
        assertTrue(signInPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldClickSignInFromGnm"})
    public void shouldAttemptToSignInWithIncorrectPassword() throws InterruptedException{
        signInPage.enterEmail(generatedEmail);
        signInPage.enterPassword("notthepassstupid");
        signInPage.clickSignIn();
        Thread.sleep(2000);
        assertTrue(signInPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldAttemptToSignInWithIncorrectPassword"})
    public void shouldBeAbleToSignInWithCorrectCredentials(){
        signInPage.enterEmail(generatedEmail);
        signInPage.enterPassword("Aaaaaa07");
        homeMainPage = signInPage.clickSignIn();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSignInWithCorrectCredentials"})
    public void shouldBeAbleToVerifyLogInSuccess(){
        assertTrue(homeMainPage.checkOnCorrectPage());
    }











    public String generateEmail(){
        String gmail = "@gmail.com";
        String s = "tester";
        int rand1 = (int)(Math.random() * 100000000);
        String sf = s + rand1 + gmail;
        return sf;
    }

    public void signUp(){
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        signInPage = homeSidePage.clickSignInSignUp("SIGN UP/IN");
        assertTrue(signInPage.checkOnCorrectPage());
        signUpPage = signInPage.clickSignUpNow();
        assertTrue(signUpPage.checkOnCorrectPage());
        signUpPage.enterEmailAddress(generatedEmail);
        signUpPage.reEnterEmailAddress(generatedEmail);
        signUpPage.enterPassword();
        signUpPage.reEnterPassword();
        visitorAgreementPage = signUpPage.clickSignUpButton();
        assertTrue(visitorAgreementPage.checkOnCorrectPageAfterSignUp());
        savedListingsPage = visitorAgreementPage.clickOnAcceptAgreement();
        assertTrue(savedListingsPage.checkOnCorrectPageAfterAcceptingAgreement());
        homeMainPage = savedListingsPage.clickStartYourSearch();
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

}
