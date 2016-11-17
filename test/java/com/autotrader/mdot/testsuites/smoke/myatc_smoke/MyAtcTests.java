package com.autotrader.mdot.testsuites.smoke.myatc_smoke;

import com.autotrader.mdot.pages.FYC.*;
import com.autotrader.mdot.pages.misc.*;
import com.autotrader.mdot.utilities.mDotElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 9/18/2015.
 */
public class MyAtcTests {

    public WebDriver driver;
    public WebDriverWait wait;
    public String testingEnvironment = "https://m-test1.autotrader.com/";
    public String generatedEmail = generateEmail();
    public String baseUrl;

    HomeMainPage homeMainPage;
    SearchResultsLandingPage searchResultsLandingPage;
    VehicleDetailsPage vehicleDetailsPage;
    SavedListingsPage savedListingsPage;
    SavedSearchPage savedSearchPage;
    LocationAndRadiusSliderPage locationAndRadiusSliderPage;
    NewUsedCertifiedSliderPage newUsedCertifiedSliderPage;
    YearMakeModelTrimSliderPage yearMakeModelTrimSliderPage;
    MoreOptionsSliderPage moreOptionsSliderPage;
    StyleSliderPage styleSliderPage;
    SignInPage signInPage;
    SignUpPage signUpPage;
    VisitorAgreementPage visitorAgreementPage;
    FiltersSliderPage filtersSliderPage;
    HomeSidePage homeSidePage;
    DesiredCapabilities capability;

    @BeforeClass(alwaysRun = true)
    @org.testng.annotations.Parameters(value={"browserName","browser_version","platform","device","baseUrl","local","os","os_version","resolution","bsAccount"})
    public void setUp(@Optional("browserName")String browserName,@Optional("version") String browser_version,@Optional("platform") String platform,@Optional("device") String device,@Optional("baseUrl")String baseUrl,@Optional("local")String local,@Optional("os")String os,@Optional("os_version")String os_version,@Optional("resolution")String resolution,@Optional("bsAccount")String bsAccount) throws Exception{
        if(local.equals("false")) {
            this.capability = new DesiredCapabilities();
            capability.setCapability("platform", platform);
            capability.setCapability("browserName", browserName);
            capability.setCapability("browser_version", browser_version);
            capability.setCapability("device", device);
            capability.setCapability("project", "Mobile Tests Road Show");
            capability.setCapability("build", "1.0");
            capability.setCapability("browserstack.debug", "true");
            capability.setCapability("os", os);
            capability.setCapability("os_version", os_version);
            capability.setCapability("resolution", resolution);

            this.driver = new RemoteWebDriver(
                    new URL(bsAccount),
                    capability);

        }
        else{
            this.driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        this.wait = new WebDriverWait(driver, 20);
        this.baseUrl = baseUrl;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homeSidePage = new HomeSidePage(driver);
        filtersSliderPage = new FiltersSliderPage(driver);
        yearMakeModelTrimSliderPage = new YearMakeModelTrimSliderPage(driver);
        moreOptionsSliderPage = new MoreOptionsSliderPage(driver);
        styleSliderPage = new StyleSliderPage(driver);
        homeMainPage = new HomeMainPage(driver);
        searchResultsLandingPage = new SearchResultsLandingPage(driver);
        vehicleDetailsPage = new VehicleDetailsPage(driver);
        savedListingsPage = new SavedListingsPage(driver);
        savedSearchPage = new SavedSearchPage(driver);
        locationAndRadiusSliderPage = new LocationAndRadiusSliderPage(driver);
        newUsedCertifiedSliderPage = new NewUsedCertifiedSliderPage(driver);
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);
        visitorAgreementPage = new VisitorAgreementPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    @Test(groups = "savedListings_savedSearches")
    public void shouldNavigateToHomepage(){
        driver.get(baseUrl);
        //homeMainPage.waitForObject();
    }

    /**
     *
     * The tests under the group savedListings_savedSearches verify the functionality of the saved listings and saved searches. It also tests the ability to log in after a user attempts to save
     * a listing or search when not logged in. After creating an account, saved listings and searches are created and verified.
     *
     */


    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldNavigateToHomepage"})
    public void shouldNavigateToLocationAndRadiusSliderPage(){
        locationAndRadiusSliderPage = homeMainPage.clickLocationAndRadius();
        locationAndRadiusSliderPage.waitForObject();
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldNavigateToLocationAndRadiusSliderPage"})
    public void shouldEnterZipAndRadius(){
        locationAndRadiusSliderPage.setZip("30032");
        locationAndRadiusSliderPage.selectRadius(mDotElements.Radius.ONE_HUNDRED_MILES);
        homeMainPage = locationAndRadiusSliderPage.clickOnDone();
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldEnterZipAndRadius"})
    public void shouldNavigateToNewUsedCertifiedSliderPage(){
        newUsedCertifiedSliderPage = homeMainPage.clickNewUsedCertified();
        newUsedCertifiedSliderPage.waitForObject();
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldNavigateToNewUsedCertifiedSliderPage"})
    public void shouldSelectUsed(){
        newUsedCertifiedSliderPage.selectUsed();
        homeMainPage = newUsedCertifiedSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldSelectUsed"})
    public void shouldNavigateToYearMakeModelTrimSliderPage(){
        yearMakeModelTrimSliderPage = homeMainPage.clickYearMakeModelTrim();
        yearMakeModelTrimSliderPage.waitForObject();
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldNavigateToYearMakeModelTrimSliderPage"})
    public void shouldSelectFromAndToYear(){
        yearMakeModelTrimSliderPage.selectYearBeginning("2012");
        yearMakeModelTrimSliderPage.selectYearEnding("2015");
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldSelectFromAndToYear"})
    public void shouldSelectAMake() throws InterruptedException{
        yearMakeModelTrimSliderPage.clickMakeSelector();
        Thread.sleep(2000);
        yearMakeModelTrimSliderPage.selectMake("Honda");
        yearMakeModelTrimSliderPage.clickMakeSelect();
        yearMakeModelTrimSliderPage.waitForObject();
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldSelectAMake"})
    public void shouldSelectAModel() throws InterruptedException{
        yearMakeModelTrimSliderPage.clickModelSelector();
        Thread.sleep(2000);
        yearMakeModelTrimSliderPage.selectModel("Accord");
        yearMakeModelTrimSliderPage.clickModelSelect();
        Thread.sleep(2000);
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldSelectAModel"})
    public void shouldSelectATrim() throws InterruptedException{
        yearMakeModelTrimSliderPage.clickTrimSelector();
        Thread.sleep(2000);
        yearMakeModelTrimSliderPage.selectTrim("LX");
        yearMakeModelTrimSliderPage.clickTrimSelect();
        Thread.sleep(2000);
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldSelectATrim"})
    public void shouldNavigateBackToHomePage() throws InterruptedException{
        homeMainPage = yearMakeModelTrimSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldNavigateBackToHomePage"})
    public void shouldSelectAStyle() throws InterruptedException{
        styleSliderPage = homeMainPage.clickStyle();
        styleSliderPage.waitForObject();
        styleSliderPage.selectStyle("Sedan");
        homeMainPage = styleSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldSelectAStyle"})
    public void shouldSelectMoreOptions() throws InterruptedException {
        moreOptionsSliderPage = homeMainPage.clickMoreOptions();
        Thread.sleep(2000);
        moreOptionsSliderPage.selectAnOption("Transmission");
        moreOptionsSliderPage.selectSubOption("Automatic");
        homeMainPage = moreOptionsSliderPage.clickOnApply();
        homeMainPage.waitForObject();
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldSelectMoreOptions"})
    public void shouldNavigateToTheSrp() {
        searchResultsLandingPage = homeMainPage.clickSearchForCars();
        searchResultsLandingPage.waitForObject();
        assertTrue(searchResultsLandingPage.checkOnCorrectPage());
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldNavigateToTheSrp"})
    public void shouldAttemptToSaveSearchAndBeRedirectedToSignIn(){
        signInPage = searchResultsLandingPage.clickSaveSearchStarButtonLoggedOut();
        signInPage.waitForObject();
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldAttemptToSaveSearchAndBeRedirectedToSignIn"})
    public void shouldNavigateToSignUpPage(){
        signUpPage = signInPage.clickSignUpNow();
        signUpPage.waitForObject();
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldNavigateToSignUpPage"})
    public void shouldEnterAndConfirmEmail(){
        signUpPage.enterEmailAddress(generatedEmail);
        signUpPage.reEnterEmailAddress(generatedEmail);

    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldEnterAndConfirmEmail"})
    public void shouldEnterAndConfirmPassword(){
        signUpPage.enterPassword();
        signUpPage.reEnterPassword();
    }

    @Test(groups = "shouldEnterAndConfirmPassword", dependsOnMethods = {"shouldEnterAndConfirmPassword"})
    public void shouldBeRedirectedToVisitorAgreementPage(){
        visitorAgreementPage = signUpPage.clickSignUpButton();
        visitorAgreementPage.waitForObject();
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldBeRedirectedToVisitorAgreementPage"})
    public void shouldAcceptAgreementAndBeRedirectedToSrp(){
        searchResultsLandingPage = visitorAgreementPage.clickOnAcceptAgreementSrp();
        searchResultsLandingPage.waitForObject();
        assertTrue(searchResultsLandingPage.checkOnCorrectPage());
    }


    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldAcceptAgreementAndBeRedirectedToSrp"})
    public void shouldBeAbleToSaveFirstSearch() throws InterruptedException{
        Thread.sleep(2000);
        searchResultsLandingPage.clickSaveSearchStarButtonLoggedIn();
        searchResultsLandingPage.inputSavedSearchName("Honda Accord1");
        Thread.sleep(2000);
        searchResultsLandingPage.clickDoneButton();
        searchResultsLandingPage.waitForObject();
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldBeAbleToSaveFirstSearch"})
    public void shouldNavigateToFilterPage() {
        filtersSliderPage = searchResultsLandingPage.clickFiltersButton();
        filtersSliderPage.waitForObject();
        assertTrue(filtersSliderPage.checkOnCorrectPage());
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldNavigateToFilterPage"})
    public void shouldApplyAFilterForDealersOrPrivateSellers() throws InterruptedException{
        filtersSliderPage.selectAnOption("Dealers or Private Sellers");
        Thread.sleep(2000);
        filtersSliderPage.selectSubOption("Dealers Only");
        searchResultsLandingPage = filtersSliderPage.clickOnApply();
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldApplyAFilterForDealersOrPrivateSellers"})
    public void shouldBeAbleToSaveSecondSearch() throws InterruptedException{
        Thread.sleep(2000);
        searchResultsLandingPage.clickSaveSearchStarButtonLoggedIn();
        searchResultsLandingPage.inputSavedSearchName("Honda's from Dealers Only");
        Thread.sleep(2000);
        searchResultsLandingPage.clickDoneButton();
        searchResultsLandingPage.waitForObject();
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldBeAbleToSaveSecondSearch"})
    public void shouldApplyAFilterForFuelType() throws InterruptedException {
        filtersSliderPage = searchResultsLandingPage.clickFiltersButton();
        filtersSliderPage.waitForObject();
        filtersSliderPage.selectAnOption("Fuel Type");
        Thread.sleep(2000);
        filtersSliderPage.selectSubOption("Gasoline");
        searchResultsLandingPage = filtersSliderPage.clickOnApply();
        Thread.sleep(2000);
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldApplyAFilterForFuelType"})
    public void shouldBeAbleToSaveThirdSearch() throws InterruptedException{
        searchResultsLandingPage.clickSaveSearchStarButtonLoggedIn();
        searchResultsLandingPage.inputSavedSearchName("Dealer Honda Gasoline");
        Thread.sleep(2000);
        searchResultsLandingPage.clickDoneButton();
        searchResultsLandingPage.waitForObject();
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldBeAbleToSaveThirdSearch"})
    public void shouldBeAbleToFilterAnyDealerGasFuelType() throws InterruptedException{
        filtersSliderPage = searchResultsLandingPage.clickFiltersButton();
        filtersSliderPage.waitForObject();
        filtersSliderPage.selectAnOption("Dealers or Private Sellers");
        Thread.sleep(2000);
        filtersSliderPage.selectSubOption("Any");
        filtersSliderPage.selectAnOption("Fuel Type");
        Thread.sleep(2000);
        filtersSliderPage.selectSubOption("Any");
        searchResultsLandingPage = filtersSliderPage.clickOnApply();
        Thread.sleep(2000);
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldBeAbleToFilterAnyDealerGasFuelType"})
    public void shouldBeAbleToSaveFirstFiveListings() throws InterruptedException{
        searchResultsLandingPage.saveListing(0);
        for(int i = 4; i < 7; i++){
            searchResultsLandingPage.saveListing(i);
            Thread.sleep(2000);
        }
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldBeAbleToSaveFirstFiveListings"})
    public void shouldBeAbleToDeselectAListing() throws InterruptedException{
        searchResultsLandingPage.unSaveListing(4);
        Thread.sleep(2000);
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldBeAbleToDeselectAListing"})
    public void shouldBeAbleToNavigateToSavedListings(){
        homeSidePage = searchResultsLandingPage.clickHamburgerButton();
        homeSidePage.waitForObject();
        savedListingsPage = homeSidePage.clickSideMenuSavedListingsLinkSignedIn("SAVED LISTINGS");
        savedListingsPage.waitForObject();
        assertTrue(savedListingsPage.checkOnCorrectPage());
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldBeAbleToNavigateToSavedListings"})
    public void shouldBeAbleToDeleteListingFromStar() throws InterruptedException{
        savedListingsPage.deleteSavedListing(0);
        Thread.sleep(2000);
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldBeAbleToDeleteListingFromStar"})
    public void shouldBeAbleToEnterEditMode() throws InterruptedException {
        savedListingsPage.clickOnEdit();
        Thread.sleep(2000);
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldBeAbleToEnterEditMode"})
    public void shouldBeAbleToDeleteListingFromEditMode() throws InterruptedException{
        savedListingsPage.deleteListingFromEditMode(0);
        Thread.sleep(2000);
        savedListingsPage.confirmDeletion();
        Thread.sleep(2000);
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldBeAbleToDeleteListingFromEditMode"})
    public void shouldBeAbleToDeleteAllSavedListings() throws InterruptedException{
        savedListingsPage.deleteAllListings();
        savedListingsPage.confirmDeleteAll();
        Thread.sleep(2000);
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldBeAbleToDeleteAllSavedListings"})
    public void shouldBeAbleToNavigateToSavedSearches(){
        homeSidePage = savedListingsPage.clickHamburgerButton();
        homeSidePage.waitForObject();
        savedSearchPage = homeSidePage.clickSideMenuSavedSearchesLinkSignedIn("SAVED SEARCHES");
    }

    @Test(groups = "savedListings_savedSearches", dependsOnMethods = {"shouldBeAbleToNavigateToSavedSearches"})
    public void shouldBeAbleToDeleteSavedSearchFromEditMode() throws InterruptedException{
        savedSearchPage.clickEditButton();
        savedSearchPage.deleteSearchFromEditMode(0);
        Thread.sleep(2000);
    }

    public String generateEmail(){
        String gmail = "@gmail.com";
        String s = "tester";
        int rand1 = (int)(Math.random() * 100000);
        String sf = s + rand1 + gmail;
        return sf;
    }


}
