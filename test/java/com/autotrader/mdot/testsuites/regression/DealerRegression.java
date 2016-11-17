package com.autotrader.mdot.testsuites.regression;

import com.autotrader.mdot.pages.Dealers.*;
import com.autotrader.mdot.pages.FYC.FiltersSliderPage;
import com.autotrader.mdot.pages.FYC.LocationAndRadiusSliderPage;
import com.autotrader.mdot.pages.FYC.SearchResultsLandingPage;
import com.autotrader.mdot.pages.misc.*;
import com.autotrader.mdot.testsuites.TestExtension;
import org.openqa.selenium.By;
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
 * Created by mwstratton on 10/6/2015.
 */
public class DealerRegression extends TestExtension{

    DealerSearchResultsPage dealerSearchResultsPage;
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
    DealerLocationPage dealerLocationPage;
    DealerDetailPage dealerDetailPage;
    DdpFilterPage ddpFilterPage;
    VehicleDetailsPage vehicleDetailsPage;
    ResearchPage researchPage;
    SellerInfoPage sellerInfoPage;
    DsrpFilterPage dsrpFilterPage;

    public String minPrice = "2000";
    public String maxPrice = "25000";
    public String generatedEmail = generateEmail();
    public String zipCode = "30032";
    public String[] sortingOptions = {"Distance - Near to Far", "Distance - Far to Near", "Price - High to Low", "Price - Low to High",
            "Mileage - Low to High", "Mileage - High to Low", "Year - New to Old", "Year - Old to New", "Make/Model - A to Z",
            "Make/Model - Z to A", "Best Match"};
    public String dealerName = "";
    public String[] radiusOptions = {"Any Distance", "10 miles", "25 miles", "50 miles", "75 miles", "100 miles",
                "200 miles", "300 miles", "500 miles"};

    @BeforeClass(alwaysRun = true)
    public void setUp() {


        dealerSearchResultsPage = new DealerSearchResultsPage(driver);
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
        dealerLocationPage = new DealerLocationPage(driver);
        dealerDetailPage = new DealerDetailPage(driver);
        ddpFilterPage = new DdpFilterPage(driver);
        vehicleDetailsPage = new VehicleDetailsPage(driver);
        researchPage = new ResearchPage(driver);
        sellerInfoPage = new SellerInfoPage(driver);
        dsrpFilterPage = new DsrpFilterPage(driver);
    }


    @Test
    public void shouldBeAbleToLandOnHomepage() {
        driver.get(baseUrl);
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToLandOnHomepage"})
    public void shouldVerifyViewAllDealersButtonIsDisplayed(){
        assertTrue(homeMainPage.verifyDealersButtonIsClickable());
    }

    @Test(dependsOnMethods = {"shouldVerifyViewAllDealersButtonIsDisplayed"})
    public void shouldBeAbleToClickDealersFromGnm(){
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        dealerLocationPage = homeSidePage.clickSideMenuDealersLink("DEALERS");
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickDealersFromGnm"})
    public void shouldVerifyDealerLocationPage(){
        assertTrue(dealerLocationPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldVerifyDealerLocationPage"})
    public void shouldVerifyUseCurrentLocationOption(){
        assertTrue(dealerLocationPage.verifyUseCurrentLocationButton());
    }

    @Test(dependsOnMethods = {"shouldVerifyUseCurrentLocationOption"})
    public void shouldBeAbleToEnterAZipCode(){
        dealerLocationPage.enterZipCode(zipCode);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEnterAZipCode"})
    public void shouldBeAbleToSelectARadius() {
        dealerLocationPage.chooseRadius("200 miles");
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSelectARadius"})
    public void shouldBeAbleToClickDoneAndBeRedirectedToDsrp(){
        dealerSearchResultsPage = dealerLocationPage.clickDone();
        assertTrue(dealerSearchResultsPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickDoneAndBeRedirectedToDsrp"})
    public void shouldVerifyMapViewOnDsrp(){
        dealerSearchResultsPage.MapView();
        assertTrue(dealerSearchResultsPage.confirmMapView());
    }

    @Test(dependsOnMethods = {"shouldVerifyMapViewOnDsrp"})
    public void shouldVerifyListViewOnDsrp(){
        dealerSearchResultsPage.ListView();
        assertTrue(dealerSearchResultsPage.confirmListView());
    }

    @Test(dependsOnMethods = {"shouldVerifyListViewOnDsrp"})
    public void shouldVerifyZipIsCorrect(){
        assertTrue(dealerSearchResultsPage.verifyCorrectZip(zipCode));
    }

    @Test(dependsOnMethods = {"shouldVerifyZipIsCorrect"})
    public void shouldVerifyAddressIsListedForFirstFiveListings(){
        for(int i = 0; i < 5; i ++){
            assertTrue(dealerSearchResultsPage.verifyAddressIsDisplayed(i));
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyAddressIsListedForFirstFiveListings"})
    public void shouldVerifyPhoneNumberIsListedForFirstFiveListings(){
        for(int i = 0; i < 5; i++){
            assertTrue(dealerSearchResultsPage.verifyPhoneNumbersAreDisplayed(i));
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyPhoneNumberIsListedForFirstFiveListings"})
    public void shouldVerifyFirstFiveListingsAreClickable(){
        for(int i = 0; i < 5; i++){
            assertTrue(dealerSearchResultsPage.verifyViewListingButtons(i));
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyFirstFiveListingsAreClickable"})
    public void shouldBeAbleToClickFirstListingAndGoToDdp(){
        dealerName = dealerSearchResultsPage.getNameOfDealer(0);
        dealerDetailPage = dealerSearchResultsPage.clickListingByIndex(0);
        assertTrue(dealerDetailPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickFirstListingAndGoToDdp"})
    public void shouldVerifySortingOptions(){
        for(int i = 0; i < sortingOptions.length; i++){
            assertTrue(dealerDetailPage.verifyFilterOptions(sortingOptions[i]));
        }
    }

    @Test(dependsOnMethods = {"shouldVerifySortingOptions"})
    public void shouldVerifyEmailDealerButtonIsDisplayed(){
        assertTrue(dealerDetailPage.verifyEmailDealerButton());
    }

    @Test(dependsOnMethods = {"shouldVerifyEmailDealerButtonIsDisplayed"})
    public void shouldBeRedirectedToSignInFromAttemptingToSaveListingOnDdp() throws InterruptedException{
        signInPage = dealerDetailPage.clickSaveListingLoggedOutByIndex(0);
        Thread.sleep(2000);
        assertTrue(signInPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeRedirectedToSignInFromAttemptingToSaveListingOnDdp"})
    public void shouldBeAbleToRegisterNewUserFromDdp() throws InterruptedException{
        signUpPage = signInPage.clickSignUpNow();
        assertTrue(signUpPage.checkOnCorrectPage());
        signUp();
        Thread.sleep(2000);
    }

    /**This test is not permanent - Should be redirected to ddp after signing up**/
    @Test(dependsOnMethods = {"shouldBeAbleToRegisterNewUserFromDdp"})
    public void shouldBeAbleToNavigateBackToDsrpFromGnm() throws InterruptedException{
        homeSidePage = savedListingsPage.clickHamburgerButton();
        Thread.sleep(2000);
        dealerSearchResultsPage = homeSidePage.clickSideMenuDealersLinkFromDdp("DEALERS");
        assertTrue(dealerSearchResultsPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToNavigateBackToDsrpFromGnm"})
    public void shouldBeAbleToReturnToDdp(){
        dealerDetailPage = dealerSearchResultsPage.clickListingByIndex(0);
        assertTrue(dealerDetailPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToReturnToDdp"})
    public void shouldClickImageViewAndVerify() throws InterruptedException{
        Thread.sleep(2000);
        dealerDetailPage.clickImageView();
        assertTrue(dealerDetailPage.verifyImageView());
    }

    @Test(dependsOnMethods = {"shouldClickImageViewAndVerify"})
    public void shouldClickListViewAndVerify(){
        dealerDetailPage.clickListView();
        assertTrue(dealerDetailPage.verifyListView());
    }

    @Test(dependsOnMethods = {"shouldClickListViewAndVerify"})
    public void shouldVerifyDealerName(){
        assertTrue(dealerDetailPage.verifyDealerName(dealerName));
    }

    @Test(dependsOnMethods = {"shouldVerifyDealerName"})
    public void shouldBeAbleToSaveFirstFiveListings() throws InterruptedException{
        for(int i = 0; i < 5; i++){
            dealerDetailPage.saveListing(i);
            Thread.sleep(2000);
        }
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSaveFirstFiveListings"})
    public void  shouldBeAbleToGoToFilterPage() throws InterruptedException{
        ddpFilterPage = dealerDetailPage.clickFilterButton();
        Thread.sleep(2000);
        assertTrue(ddpFilterPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToGoToFilterPage"})
    public void shouldBeAbleToSetFilterForCondition(){
        ddpFilterPage.clickNewUsedCertifiedAndSelect("Used");
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSetFilterForCondition"})
    public void shouldBeAbleToSetFilterForPrice(){
        ddpFilterPage.clickPriceAndSelectMinAndMax(minPrice, maxPrice);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSetFilterForPrice"})
    public void shouldBeAbleToClickApplyFromFilterPage(){
        dealerDetailPage = ddpFilterPage.clickOnApply();
        assertTrue(dealerDetailPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickApplyFromFilterPage"})
    public void shouldVerifyPriceFilterWorked() throws InterruptedException{
        for(int i = 0; i < 2; i++){
            Thread.sleep(2000);
            assertTrue(dealerDetailPage.verifyPriceListed(minPrice, maxPrice, i));
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyPriceFilterWorked"})
    public void shouldSelectAListingAndBeRedirectedToVdp(){
        dealerDetailPage.selectListingByIndex(5);
        assertTrue(vehicleDetailsPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldSelectAListingAndBeRedirectedToVdp"})
    public void shouldVerifyVdpPage(){
        assertTrue(vehicleDetailsPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldVerifyVdpPage"})
    public void shouldBeAbleToSaveListingFromVdp()throws InterruptedException{
        vehicleDetailsPage.saveListing();
        Thread.sleep(4000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSaveListingFromVdp"})
    public void shouldVerifyAmountOfSavedListings(){
        homeSidePage = vehicleDetailsPage.clickHamburgerButton();
        homeSidePage.waitForObject();
        assertTrue(homeSidePage.verifyAmountOfSavedListings("SAVED LISTINGS", "6"));
        driver.navigate().refresh();
    }

    @Test(dependsOnMethods = {"shouldVerifyAmountOfSavedListings"})
    public void shouldBeAbleToNavigateToResearchPageAndValidateCorrectPage(){
        researchPage = vehicleDetailsPage.clickResearch();
        assertTrue(researchPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToNavigateToResearchPageAndValidateCorrectPage"})
    public void shouldBeAbleToNavigateToSellerInfoPageAndValidateCorrectPage(){
        sellerInfoPage = researchPage.clickSellerInfo();
        assertTrue(sellerInfoPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToNavigateToSellerInfoPageAndValidateCorrectPage"})
    public void shouldBeAbleToNavigateBackToVdpAndValidateCorrectPage(){
        vehicleDetailsPage = sellerInfoPage.clickCarInfo();
        assertTrue(vehicleDetailsPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToNavigateBackToVdpAndValidateCorrectPage"})
    public void shouldBeAbleToSelectDealersFromGnm(){
        homeSidePage = vehicleDetailsPage.clickHamburgerButton();
        homeSidePage.waitForObject();
        dealerSearchResultsPage = homeSidePage.clickSideMenuDealersLinkFromDdp("DEALERS");
        assertTrue(dealerSearchResultsPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSelectDealersFromGnm"})
    public void shouldBeAbleToClickFilter(){
        dsrpFilterPage = dealerSearchResultsPage.clickFilter();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickFilter"})
    public void shouldVerifyDsrpFilterOptions(){
        assertTrue(dsrpFilterPage.verifyDsrpOptions());
    }

    @Test(dependsOnMethods = {"shouldVerifyDsrpFilterOptions"})
    public void shouldVerifyRadiusFilterFunctionality() throws InterruptedException{
        //checkForPopUp();
        dsrpFilterPage.displayLocationDropDown();
        Thread.sleep(2000);
        dsrpFilterPage.selectRadius("Any Distance");
        Thread.sleep(6000);
        int x = dsrpFilterPage.returnAmtOfListings();
        for(int i = radiusOptions.length-1; i > 0; i--){
            dsrpFilterPage.selectRadius(radiusOptions[i]);
            Thread.sleep(4000);
            int y = dsrpFilterPage.returnAmtOfListings();
            assertTrue(y < x);
            x = dsrpFilterPage.returnAmtOfListings();
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyRadiusFilterFunctionality"})
    public void shouldBeAbleToClickApplyAndReturnToDsrp() throws InterruptedException{
        dealerSearchResultsPage = dsrpFilterPage.clickApply();
        Thread.sleep(2000);
        assertTrue(dealerSearchResultsPage.checkOnCorrectPage());
    }

    public void signUp() throws InterruptedException{
        signUpPage.enterEmailAddress(generatedEmail);
        signUpPage.reEnterEmailAddress(generatedEmail);
        signUpPage.enterPassword();
        signUpPage.reEnterPassword();
        visitorAgreementPage = signUpPage.clickSignUpButton();
        Thread.sleep(2000);
        savedListingsPage = visitorAgreementPage.clickOnAcceptAgreement();
        assertTrue(savedListingsPage.checkOnCorrectPageAfterAcceptingAgreement());
    }

    public String generateEmail(){
        String gmail = "@gmail.com";
        String s = "tester";
        int rand1 = (int)(Math.random() * 100000000);
        String sf = s + rand1 + gmail;
        return sf;
    }

}
