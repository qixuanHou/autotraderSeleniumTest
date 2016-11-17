package com.autotrader.mdot.testsuites.smoke.fyc_smoke;

import com.autotrader.mdot.pages.FYC.*;
import com.autotrader.mdot.pages.misc.*;
import com.autotrader.mdot.pages.FYC.SearchResultsLandingPage;
import com.autotrader.mdot.utilities.mDotElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

/**
 * Created by mwstratton on 8/21/2015.
 */
public class FycTests {

    public WebDriver driver;
    public String baseUrl;

    HomeMainPage homeMainPage;
    LocationAndRadiusSliderPage locationAndRadiusSliderPage;
    NewUsedCertifiedSliderPage newUsedCertifiedSliderPage;
    StyleSliderPage styleSliderPage;
    YearMakeModelTrimSliderPage yearMakeModelTrimSliderPage;
    MoreOptionsSliderPage moreOptionsSliderPage;
    SearchResultsLandingPage searchResultsLandingPage;
    SignInPage signInPage;
    FiltersSliderPage filtersSliderPage;
    VehicleDetailsPage vehicleDetailsPage;
    ResearchPage researchPage;
    SellerInfoPage sellerInfoPage;
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
            baseUrl = "https://m-test1.autotrader.com/";
        }
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.baseUrl = baseUrl;

        homeMainPage = new HomeMainPage(driver); // This is your starting point page
        locationAndRadiusSliderPage = new LocationAndRadiusSliderPage(driver);
        newUsedCertifiedSliderPage = new NewUsedCertifiedSliderPage(driver);
        styleSliderPage = new StyleSliderPage(driver);
        yearMakeModelTrimSliderPage = new YearMakeModelTrimSliderPage(driver);
        moreOptionsSliderPage = new MoreOptionsSliderPage(driver);
        searchResultsLandingPage = new SearchResultsLandingPage(driver);
        filtersSliderPage = new FiltersSliderPage(driver);
        vehicleDetailsPage = new VehicleDetailsPage(driver);
        signInPage = new SignInPage(driver);
        researchPage = new ResearchPage(driver);
        sellerInfoPage = new SellerInfoPage(driver);
    }

    @Test(priority = 1, groups = "FYC")
    public void shouldNavigateToHomeMainPage(){
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
    }

    @Test(priority = 2, groups = "FYC")
    public void shouldNavigateToLocationAndRadiusSliderPage(){
        locationAndRadiusSliderPage = homeMainPage.clickLocationAndRadius();
        locationAndRadiusSliderPage.waitForObject();
    }

    @Test(priority = 3, groups = "FYC")
    public void shouldEnterZipAndRadius(){
        locationAndRadiusSliderPage.setZip("30032");
        locationAndRadiusSliderPage.selectRadius(mDotElements.Radius.ONE_HUNDRED_MILES);
        homeMainPage = locationAndRadiusSliderPage.clickOnDone();
    }

    @Test(priority = 4, groups = "FYC")
    public void shouldNavigateToNewUsedCertifiedSliderPage(){
        newUsedCertifiedSliderPage = homeMainPage.clickNewUsedCertified();
        newUsedCertifiedSliderPage.waitForObject();
    }

    @Test(priority = 5, groups = "FYC")
    public void shouldSelectUsed(){
        newUsedCertifiedSliderPage.selectUsed();
        homeMainPage = newUsedCertifiedSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
    }

    @Test(priority = 6, groups = "FYC")
    public void shouldDisplaySelectedNewUsedCertified() {
        Assert.assertTrue(homeMainPage.confirmUsedSelectedCertifiedDisplayed("Used"));
    }

    @Test(priority = 7, groups = "FYC")
    public void shouldNavigateToYearMakeModelTrimSliderPage(){
        yearMakeModelTrimSliderPage = homeMainPage.clickYearMakeModelTrim();
        yearMakeModelTrimSliderPage.waitForObject();
    }

    @Test(priority = 8, groups = "FYC")
    public void shouldSelectFromAndToYear(){
        yearMakeModelTrimSliderPage.selectYearBeginning("2012");
        yearMakeModelTrimSliderPage.selectYearEnding("2015");
    }

    @Test(priority = 9, groups = "FYC")
    public void shouldSelectAMake() throws InterruptedException{
        yearMakeModelTrimSliderPage.clickMakeSelector();
        Thread.sleep(2000);
        yearMakeModelTrimSliderPage.selectMake("Honda");
        yearMakeModelTrimSliderPage.clickMakeSelect();
        yearMakeModelTrimSliderPage.waitForObject();
    }


    @Test(priority = 10, groups = "FYC")
    public void shouldDisplaySelectedMake() {
        Assert.assertTrue(yearMakeModelTrimSliderPage.confirmMake("Honda"));
    }


    @Test(priority = 11, groups = "FYC")
    public void shouldSelectAModel() throws InterruptedException{
        yearMakeModelTrimSliderPage.clickModelSelector();
        Thread.sleep(2000);
        yearMakeModelTrimSliderPage.selectModel("Accord");
        yearMakeModelTrimSliderPage.clickModelSelect();
        Thread.sleep(2000);
    }

    @Test(priority = 12, groups = "FYC")
    public void shouldDisplaySelectedModel() {
        Assert.assertTrue(yearMakeModelTrimSliderPage.confirmModel("Accord"));
    }


    @Test(priority = 13, groups = "FYC")
    public void shouldSelectATrim() throws InterruptedException{
        yearMakeModelTrimSliderPage.clickTrimSelector();
        Thread.sleep(2000);
        yearMakeModelTrimSliderPage.selectTrim("LX");
        yearMakeModelTrimSliderPage.clickTrimSelect();
        Thread.sleep(2000);
    }

    @Test(priority = 14, groups = "FYC")
    public void shouldDisplaySelectedTrim() {
        Assert.assertTrue(yearMakeModelTrimSliderPage.confirmTrim("LX"));
    }

    @Test(priority = 15, groups = "FYC")
    public void shouldNavigateBackToHomePage() {
        homeMainPage = yearMakeModelTrimSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
        Assert.assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(priority = 16, groups = "FYC")
    public void shouldDisplaySelectedYearMakeModelTrim() {
        Assert.assertTrue(homeMainPage.confirmYearMakeModelTrim("1 Selected"));
    }

    @Test(priority = 17, groups = "FYC")
    public void shouldSelectAStyle() throws InterruptedException{
        styleSliderPage = homeMainPage.clickStyle();
        styleSliderPage.waitForObject();
        styleSliderPage.selectStyle("Sedan");
        homeMainPage = styleSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(priority = 18, groups = "FYC")
    public void shouldDisplaySelectedStyle() {
        Assert.assertTrue(homeMainPage.confirmStyle("Sedan"));
    }

    @Test(priority = 19, groups = "FYC")
    public void shouldSelectMoreOptions() throws InterruptedException {
        moreOptionsSliderPage = homeMainPage.clickMoreOptions();
        Thread.sleep(2000);
        moreOptionsSliderPage.selectAnOption("Transmission");
        moreOptionsSliderPage.selectSubOption("Automatic");
        homeMainPage = moreOptionsSliderPage.clickOnApply();
        homeMainPage.waitForObject();
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(priority = 20, groups = "FYC")
    public void shouldConfirmOption() {
        Assert.assertTrue(homeMainPage.confirmOption("1 Selected"));
    }

    @Test(priority = 21, groups = "FYC")
    public void shouldConfirmRadiusAndLocation() {
        Assert.assertTrue(homeMainPage.confirmRadiusAndLocation("30032"));
    }

    @Test(priority = 22, groups = "FYC")
    public void shouldNavigateToTheSrp() {
        searchResultsLandingPage = homeMainPage.clickSearchForCars();
        searchResultsLandingPage.waitForObject();
        Assert.assertTrue(searchResultsLandingPage.checkOnCorrectPage());
    }

    @Test(priority = 29, groups = "FYC")
    public void shouldBeAbleToClickImageView() throws InterruptedException{
        searchResultsLandingPage.clickImageView();
        Assert.assertTrue(searchResultsLandingPage.confirmImageView());
        Thread.sleep(2000);
    }

    @Test(priority = 30, groups = "FYC")
    public void shouldBeAbleToClickListView() throws InterruptedException{
        searchResultsLandingPage.clickListView();
        Thread.sleep(2000);
        Assert.assertTrue(searchResultsLandingPage.confirmListView());
    }

    @Test(priority = 31, groups = "FYC")
    public void shouldBeAbleToClickFilter() {
        filtersSliderPage = searchResultsLandingPage.clickFiltersButton();
        filtersSliderPage.waitForObject();
    }

    @Test(priority = 32, groups = "FYC")
    public void shouldBeAbleToSelectDriveType() {
        filtersSliderPage.selectDriveType("Front Wheel Drive");
    }

    @Test(priority = 33, groups = "FYC")
    public void shouldBeAbleToSelectFuelType() {
        filtersSliderPage.selectFuelType("Gasoline");
    }

    @Test(priority = 34, groups = "FYC")
    public void shouldBeAbleToSelectVehicleFeature() {
        filtersSliderPage.selectVehicleFeatures("Keyless Entry");
    }

    @Test(priority = 35, groups = "FYC")
    public void shouldConfirmDriveType() {
        Assert.assertTrue(filtersSliderPage.confirmDriveType("Front Wheel"));
    }

    @Test(priority = 36, groups = "FYC")
    public void shouldConfirmFuelType() {
        Assert.assertTrue(filtersSliderPage.confirmFuelType("Gasoline"));
    }

    @Test(priority = 37, groups = "FYC")
    public void shouldConfirmVehicleFeatures() {
        Assert.assertTrue(filtersSliderPage.confirmVehicleFeatures("Keyless Entry"));
    }

    @Test(priority = 38, groups = "FYC")
    public void shouldBeAbleToClickApply() throws InterruptedException {
        searchResultsLandingPage = filtersSliderPage.clickOnApply();
        Thread.sleep(4000);
        searchResultsLandingPage.waitForObject();
    }

    @Test(priority = 39, groups = "FYC")
    public void shouldBeAbleToChangeSortOption() {
        searchResultsLandingPage.changeSortingOption("Price - High to Low");
    }

    @Test(priority = 40, groups = "FYC")
    public void shouldConfirmSortOption() {
        Assert.assertTrue(searchResultsLandingPage.confirmSortSelected("Price - High to Low"));
    }

    @Test(priority =  41, groups = "FYC")
    public void shouldBeAbleToClickFirstListing() {
        vehicleDetailsPage = searchResultsLandingPage.clickOneListing(5);
    }

    @Test(priority =  42, groups = "FYC")
    public void shouldBeAbleToClickResearch() {
        researchPage = vehicleDetailsPage.clickResearch();
        researchPage.waitForObject();
    }

    @Test(priority =  43, groups = "FYC")
    public void shouldBeAbleToClickSellerInfo() {
        sellerInfoPage = vehicleDetailsPage.clickSellerInfo();
    }

    @Test(priority =  44, groups = "FYC")
    public void shouldHaveGetDirectionButton() {
        Assert.assertTrue(sellerInfoPage.checkGetDirections());
    }

    @Test(priority =  45, groups = "FYC")
    public void shouldHaveEmailDealerButton() {
        Assert.assertTrue(sellerInfoPage.checkEmailDealer());
    }

    @Test(priority =  46, groups = "FYC")
    public void shouldHaveViewInventoryButton() {
        Assert.assertTrue(sellerInfoPage.checkViewInventory());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
