package com.autotrader.mdot.testsuites.newfeature;

import com.autotrader.mdot.pages.Dealers.DealerDetailPage;
import com.autotrader.mdot.pages.Dealers.DealerLocationPage;
import com.autotrader.mdot.pages.Dealers.DealerSearchResultsPage;
import com.autotrader.mdot.pages.FYC.LocationAndRadiusSliderPage;
import com.autotrader.mdot.pages.FYC.SearchResultsLandingPage;
import com.autotrader.mdot.pages.TIM.*;
import com.autotrader.mdot.pages.misc.HomeMainPage;
import com.autotrader.mdot.pages.misc.HomeSidePage;
import com.autotrader.mdot.pages.misc.SignInPage;
import com.autotrader.mdot.pages.misc.VehicleDetailsPage;
import com.autotrader.mdot.utilities.Environments;
import com.autotrader.mdot.utilities.mDotElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by amsummerour on 10/7/2015.
 * A Test to verify that all mDot pages are being redirected to HTTPS
 */
public class HttpsTests {

    // Driver declaration
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseUrl;

    //<editor-fold desc="Page objects used in this test">
    HomeMainPage homeMainPage;
    LocationAndRadiusSliderPage locationAndRadiusSliderPage;
    HomeSidePage homeSidePage;
    DealerLocationPage dealerLocationPage;
    TimLandingPage timLandingPage;
    SignInPage signInPage;
    SearchResultsLandingPage searchResultsLandingPage;
    VehicleDetailsPage vehicleDetailsPage;
    DealerSearchResultsPage dealerSearchResultsPage;
    DealerDetailPage dealerDetailPage;
    TimOptionsPage timOptionsPage;
    TimVehicleHistoryPage timVehicleHistoryPage;
    TimVehicleConditionPage timVehicleConditionPage;
    TimContactInfoPage timContactInfoPage;
    TimReviewOfferPage timReviewOfferPage;
    //</editor-fold>

    // Other classes used
    DesiredCapabilities capability;
    private String listingID;

    /**
     * This always runs true at the beginning of the test(s)
     */
    @BeforeClass(alwaysRun = true)
    @org.testng.annotations.Parameters(value={"browserName","browser_version","platform","device","baseUrl","local","os","os_version","resolution","bsAccount"})
    public void setup(@Optional("browserName")String browserName,
                      @Optional("version") String browser_version,
                      @Optional("platform") String platform,
                      @Optional("device") String device,
                      @Optional("baseUrl")String baseUrl,
                      @Optional("local")String local,
                      @Optional("os")String os,
                      @Optional("os_version")String os_version,
                      @Optional("resolution")String resolution,
                      @Optional("bsAccount")String bsAccount)
            throws Exception {
        if (local.equals("false")) {
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

        } else {
            Environments url = new Environments();
            this.baseUrl = url.getUrl();
            baseUrl = url.getUrl();
            this.driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        //<editor-fold desc="Page object instantiations">
        homeMainPage = new HomeMainPage(driver);
        locationAndRadiusSliderPage = new LocationAndRadiusSliderPage(driver);
        homeSidePage = new HomeSidePage(driver);
        dealerLocationPage = new DealerLocationPage(driver);
        timLandingPage = new TimLandingPage(driver);
        signInPage = new SignInPage(driver);
        searchResultsLandingPage = new SearchResultsLandingPage(driver);
        vehicleDetailsPage = new VehicleDetailsPage(driver);
        dealerSearchResultsPage = new DealerSearchResultsPage(driver);
        dealerDetailPage = new DealerDetailPage(driver);
        timOptionsPage = new TimOptionsPage(driver);
        timVehicleHistoryPage = new TimVehicleHistoryPage(driver);
        timVehicleConditionPage = new TimVehicleConditionPage(driver);
        timContactInfoPage = new TimContactInfoPage(driver);
        timReviewOfferPage = new TimReviewOfferPage(driver);
        //</editor-fold>

        this.wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.baseUrl = baseUrl;
    }

    /**
     *  This always runs true at the end of the test(s)
     */
    @AfterClass(alwaysRun = true)
     public void teardown(){
        this.driver.quit();
    }

    /**
     *  The following tests will navigate through the site and verify
     *  that the pages use https rather than http
     */
    @Test(priority = 0, groups = "url_tests")
    public void testHomeMainPageUrl() throws InterruptedException{
        driver.get(baseUrl);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-bordered")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 2, groups = "url_tests")
    public void testSRPUrl() throws InterruptedException{
        driver.get(baseUrl);
        homeMainPage.clickLocationAndRadius();
        locationAndRadiusSliderPage.setZip("30606");
        locationAndRadiusSliderPage.selectRadius(mDotElements.Radius.TWENTY_FIVE_MILES);
        locationAndRadiusSliderPage.setZip("30606");
        locationAndRadiusSliderPage.clickOnDone();
        homeMainPage.clickSearchForCars();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 4, groups = "url_tests")
    public void testVDPUrl() throws InterruptedException{
        vehicleDetailsPage = searchResultsLandingPage.clickFirstListingAndGoToVDP();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-primary.atcui-transparent.ui-link")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
        listingID = vehicleDetailsPage.getListingIdFromUrl();
    }

    @Test(priority = 6, groups = "url_tests")
    public void testVDPResearchUrl() throws InterruptedException{
        driver.get(baseUrl + "cars-for-sale/vehicledetails.xhtml?listingId=" + listingID);
        vehicleDetailsPage.clickResearch();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-transparent")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 6, groups = "url_tests")
    public void testVDPSellerInfoUrl() throws InterruptedException{
        driver.get(baseUrl + "cars-for-sale/vehicledetails.xhtml?listingId=" + listingID);
        vehicleDetailsPage.clickSellerInfo();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-transparent")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 8, groups = "url_tests")
    public void testSignInPageUrl() throws InterruptedException{
        driver.get(baseUrl);
        homeMainPage.clickSignInButtonTopRight();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-primary.myatc-primary-button")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
        signInPage.enterEmail("httpstester@tester.com");
        signInPage.enterPassword("tester");
        signInPage.clickSignIn();
    }

    @Test(priority = 10, groups = "url_tests")
    public void testSavedListingsUrl() throws InterruptedException{
        driver.get(baseUrl);
        homeMainPage.clickHambergerButton();
        homeSidePage.clickSideMenuSavedListingsLinkSignedIn("SAVED LISTINGS");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-action")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 10, groups = "url_tests")
    public void testSavedSearchesUrl() throws InterruptedException{
        driver.get(baseUrl);
        homeMainPage.clickHambergerButton();
        homeSidePage.clickSideMenuSavedSearchesLinkSignedIn("SAVED SEARCHES");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-action")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }
    @Test(priority = 12, groups = "url_tests")
    public void testDSRPUrl() throws InterruptedException{
        driver.get(baseUrl);
        homeSidePage = homeMainPage.clickHambergerButton();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-icon.atcui-dealers.atcui-content-icon")));
        homeSidePage.clickSideMenuDealersLink("DEALERS");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-strong")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 14, groups = "url_tests")
    public void testDDPUrl() throws InterruptedException{
        dealerDetailPage = dealerSearchResultsPage.clickViewListings();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-action")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    // <editor-fold desc="TIM Tests">

    @Test(priority = 16, groups = "url_tests")
    public void testTIMLandingUrl() throws InterruptedException{
        driver.get(baseUrl);
        homeMainPage.clickHambergerButton();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-icon.atcui-dealers.atcui-content-icon")));
        homeSidePage.clickSideMenuDealersLink("TRADE IN YOUR CAR");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-action.atcui-bold")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 18, groups = "url_tests")
    public void testTIMOptionsUrl() throws InterruptedException{
        timLandingPage.selectYear("2014");
        timLandingPage.selectMake("Acura");
        timLandingPage.selectModel("ILX");
        timLandingPage.selectStyle("4dr Sedan 15.L Hybrid");
        timLandingPage.selectExtColor("Beige (Non Metallic)");
        timLandingPage.selectIntColor("Black");
        timLandingPage.setMileage("24245");
        timLandingPage.setZip("30606");
        timLandingPage.clickNextButton();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-btn.ui-corner-all.ui-btn-inherit.ui-btn-icon-left.ui-radio-off")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }
//
    @Test(priority = 20, groups = "url_tests")
    public void testTIMPedigreeUrl() throws InterruptedException{
        timOptionsPage.clickNoAftermarketEquipment();
        timOptionsPage.clickNextButton();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-btn.ui-corner-all.ui-btn-inherit.ui-btn-icon-left.ui-radio-on")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 22, groups = "url_tests")
    public void testTIMConditionUrl() throws InterruptedException{
        timVehicleHistoryPage.clickYesOriginalOwner();
        timVehicleHistoryPage.clickYesClearTitle();
        timVehicleHistoryPage.clickYesCleanHistoryReport();
        timVehicleHistoryPage.clickNoInsuranceClaims();
        timVehicleHistoryPage.clickNoSmokingInVehicle();
        timVehicleHistoryPage.clickYesCompleteServiceRecords();
        timVehicleHistoryPage.clickYesTwoSetsOfKeys();
        timVehicleHistoryPage.clickNoAutoAuction();
        timVehicleHistoryPage.clickNoRentalCar();
        timVehicleHistoryPage.clickNextButton();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-btn.ui-corner-all.ui-btn-inherit.ui-btn-icon-left.ui-radio-off")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 24, groups = "url_tests")
    public void testTIMContactInfoUrl() throws InterruptedException{
        timVehicleConditionPage.clickNoWearAndTear();
        timVehicleConditionPage.clickNoMechanicalIssues();
        timVehicleConditionPage.clickNoSeriousAccidentDamage();
        timVehicleConditionPage.clickNextButton();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='timContactInfo-j_id_ag-j_id_am-qui_FirstName_input']")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 26, groups = "url_tests")
    public void testTIMReviewOfferUrl() throws InterruptedException{
        timContactInfoPage.setFirstNameInputField("Tester");
        timContactInfoPage.setLastNameInputField("Tester");
        timContactInfoPage.setEmailInputField("httpstester@tester.com");
        timContactInfoPage.setEmailVerifyInputField("httpstester@tester.com");
        timContactInfoPage.setPhoneInputField("7705555555");
        timContactInfoPage.clickVisitAgreementCheckBox();
        timContactInfoPage.clickNextButton();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-action")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 28, groups = "url_tests")
    public void testTIMOfferUrl() throws InterruptedException{
        timReviewOfferPage.clickSubmitButton();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-primary")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    // </editor-fold>

    @Test(priority = 30, groups = "url_tests")
    public void testTIMRetrieveOfferUrl() throws InterruptedException{
        driver.get(baseUrl);
        homeMainPage.clickHambergerButton();
        homeSidePage.clickRetrieveMyOffer("RETRIEVE MY OFFER");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-primary")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 30, groups = "url_tests")
    public void testSYCLandingUrl() throws InterruptedException{
        driver.get(baseUrl);
        homeMainPage.clickHambergerButton();
        homeSidePage.clickSellYourCar("SELL YOUR CAR");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-action")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 30, groups = "url_tests")
    public void testPrivacyPolicyUrl() throws InterruptedException{
        driver.get(baseUrl);
        homeMainPage.clickHambergerButton();
        homeSidePage.clickPrivacyPolicy("PRIVACY POLICY");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-primary")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 30, groups = "url_tests")
    public void testVisitorAgreementUrl() throws InterruptedException{
        driver.get(baseUrl);
        homeMainPage.clickHambergerButton();
        homeSidePage.clickVisitorAgreement("VISITOR AGREEMENT");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-primary")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 30, groups = "url_tests")
    public void testFraudAwarenessUrl() throws InterruptedException{
        driver.get(baseUrl);
        homeMainPage.clickHambergerButton();
        homeSidePage.clickSideMenuFraudAwareness("FRAUD AWARENESS");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-primary")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 30, groups = "url_tests")
    public void testMobileToDesktopUrl() throws InterruptedException{
        driver.get(baseUrl);
        homeMainPage.clickHambergerButton();
        homeSidePage.clickDesktopSite("DESKTOP SITE");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-primary.search.atcui-medium.atcui-form-submit")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }

    @Test(priority = 30, groups = "url_tests")
    public void testTIMErrorUrl() throws InterruptedException{
        driver.get(baseUrl + "trade-in/error.xhtml");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".atcui-button.atcui-action")));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("https"));
    }
}
