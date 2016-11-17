package com.autotrader.mdot.testsuites.smoke.fyc_smoke;

import com.autotrader.mdot.pages.Dealers.DsrpFilterPage;
import com.autotrader.mdot.pages.Dealers.DealerLocationPage;
import com.autotrader.mdot.pages.Dealers.DealerDetailPage;
import com.autotrader.mdot.pages.Dealers.DealerSearchResultsPage;
import com.autotrader.mdot.pages.misc.*;
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


/**
 * Created by qhou on 9/8/2015.
 */
public class findDealersTests {

    public WebDriver driver;
    public String baseUrl;

    HomeMainPage homeMainPage;
    HomeSidePage homeSidePage;
    DealerSearchResultsPage dealerSearchResultsPage;
    ATHomePage atHomePage;
    DealerLocationPage dealerLocationPage;
    DsrpFilterPage dsrpFilterPage;
    DealerDetailPage dealerDetailPage;
    VehicleDetailsPage vehicleDetailsPage;
    SignInPage signInPage;
    SavedListingsPage savedListingsPage;
    SellerInfoPage sellerInfoPage;
    DesiredCapabilities capability;

    String userName = "qhou6@gatech.edu";
    String password = "123456";
    String zipCode = "30332";
    String chosenRadius = "100";
    String selectedMake = "Chevrolet";
    String keyword = "Corvette";
    String newZipCode = "30319";
    String newSelectedRadius = "50";
    String selectedSortingOption = "Price - High to Low";


    @BeforeClass(alwaysRun = true)
    @org.testng.annotations.Parameters(value={"browserName","browser_version","platform","device","baseUrl","local","os","os_version","resolution","bsAccount"})
    public void setup(@Optional("browserName")String browserName,@Optional("version") String browser_version,@Optional("platform") String platform,@Optional("device") String device,@Optional("baseUrl")String baseUrl,@Optional("local")String local,@Optional("os")String os,@Optional("os_version")String os_version,@Optional("resolution")String resolution,@Optional("bsAccount")String bsAccount) throws Exception {
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

        homeMainPage = new HomeMainPage(driver);
        homeSidePage = new HomeSidePage(driver);
        dealerSearchResultsPage = new DealerSearchResultsPage(driver);
        atHomePage = new ATHomePage(driver);
        dealerLocationPage = new DealerLocationPage(driver);
        dsrpFilterPage = new DsrpFilterPage(driver);
        dealerDetailPage = new DealerDetailPage(driver);
        vehicleDetailsPage = new VehicleDetailsPage(driver);
        signInPage = new SignInPage(driver);
        savedListingsPage = new SavedListingsPage(driver);
        sellerInfoPage = new SellerInfoPage(driver);
    }

    @Test(priority = 1, groups = "FindDealersTests")
    public void shouldBeAbleToLaunchToLocationPage() {
        driver.get(homeMainPage.pageUrl);
        homeSidePage = homeMainPage.clickHambergerButton();
        dealerLocationPage = homeSidePage.clickSideMenuDealersLink("DEALERS");
        dealerLocationPage.waitForObject();
    }

    @Test(priority = 2, groups = "FindDealersTests")
    public void shouldBeAbleToInputZipCode() {
        dealerLocationPage.enterZipCode(zipCode);
    }

    @Test(priority = 3, groups = "FindDealersTests")
    public void shouldBeAbleToChooseRadius() {
        dealerLocationPage.chooseRadius(chosenRadius);
    }

    @Test(priority = 4, groups = "FindDealersTests")
    public void shouldBeAbleToClickDoneButton() {
        dealerSearchResultsPage = dealerLocationPage.clickDone();
        dealerSearchResultsPage.waitForObject();
    }

    @Test(priority = 5, groups = "FindDealersTests")
    public void shouldBeAbleToClickLoadMore()  {
        dealerSearchResultsPage.clickLoadMore();
        dealerSearchResultsPage.waitForObject();
    }

    @Test(priority = 6, groups = "FindDealersTests")
    public void shouldBeAbleToClickMapView() {
        dealerSearchResultsPage.MapView();
    }

    @Test(priority = 7, groups = "FindDealersTests")
    public void shouldBeAbleToConfirmMapView() {
        Assert.assertTrue(dealerSearchResultsPage.confirmMapView());
    }

    @Test(priority = 8, groups = "FindDealersTests")
    public void shouldBeAbleToClickListView() {
        dealerSearchResultsPage.ListView();
    }

    @Test(priority = 9, groups = "FindDealersTests")
    public void shouldBeAbleToConfirmListView() throws InterruptedException{
        Thread.sleep(2000);
        Assert.assertTrue(dealerSearchResultsPage.confirmListView());
    }

    @Test(priority = 10, groups = "FindDealersTests")
    public void shouldBeAbleToClickFilterButton() {
        dealerSearchResultsPage.clickFilter();
        dsrpFilterPage.waitForObject();
    }

    @Test(priority = 11, groups = "FindDealersTests")
    public void shouldBeAbleToClickCancelButton() {
        dsrpFilterPage.clickCancel();
        dealerSearchResultsPage.waitForObject();
    }

    @Test(priority = 12, groups = "FindDealersTests")
    public void shouldBeAbleToClickFilterButtonAgain() throws InterruptedException{
        Thread.sleep(2000);
        dealerSearchResultsPage.clickFilter();
        dsrpFilterPage.waitForObject();
    }

    @Test(priority = 13, groups = "FindDealersTests")
    public void shouldBeAbleToClickClearAllButton() throws InterruptedException {
        dsrpFilterPage.clickClearAll();
    }

    @Test(priority = 14, groups = "FindDealersTests")
    public void shouldBeAbleToClickMakeButton() {
        dsrpFilterPage.displayMakeDropDown();
    }

    @Test(priority = 15, groups = "FindDealersTests")
    public void shouldBeAbleToSelectMake() {
        dsrpFilterPage.selectMake(selectedMake);
    }

    @Test(priority = 16, groups = "FindDealersTests")
    public void shouldBeAbleToConfirmMake() {
        Assert.assertTrue(dsrpFilterPage.confirmMake(selectedMake));
    }

    @Test(priority = 17, groups = "FindDealersTests")
    public void shouldBeAbleToClickLocationButton() {
        dsrpFilterPage.displayLocationDropDown();
    }

    @Test(priority = 18, groups = "FindDealersTests")
    public void shouldBeAbleToInputZipCodeInFilter() {
        dsrpFilterPage.inputZipCode(newZipCode);
    }

    @Test(priority = 19, groups = "FindDealersTests")
    public void shouldBeAbleToSelectRadius() {
        dsrpFilterPage.selectRadius(newSelectedRadius);
    }

    @Test(priority = 20, groups = "FindDealersTests")
    public void shouldBeAbleToConfirmZipCode() {
        Assert.assertTrue(dsrpFilterPage.confirmZipCode(newZipCode));
    }

    @Test(priority = 21, groups = "FindDealersTests")
    public void shouldBeAbleToInputKeyword() {
        dsrpFilterPage.displayKeywordDropDown();
        dsrpFilterPage.inputKeyword(keyword);
        dsrpFilterPage.displayKeywordDropDown();
    }

    @Test(priority = 22, groups = "FindDealersTests")
    public void shouldBeAbleToConfirmKeyword() {
        Assert.assertTrue(dsrpFilterPage.confirmKeyword());
    }

    @Test(priority = 23, groups = "FindDealersTests")
    public void shouldBeAbleToClickApply() {
        dealerSearchResultsPage = dsrpFilterPage.clickApply();
        dealerSearchResultsPage.waitForObject();
    }

    @Test(priority = 24, groups = "FindDealersTests")
    public void shouldBeAbleToClickViewListings() throws InterruptedException{
        Thread.sleep(3000);
        dealerSearchResultsPage.clickViewListings();
        dealerDetailPage.waitForObject();
        Thread.sleep(2000);
    }

    @Test(priority = 25, groups = "FindDealersTests")
    public void shouldBeAbleToClickImageViewButton() {
        dealerDetailPage.clickImageView();
    }

    @Test(priority = 26, groups = "FindDealersTests")
    public void shouldBeAbleToFindImage() {
        Assert.assertTrue(dealerDetailPage.foundImage());
        Assert.assertTrue(dealerDetailPage.foundContactButton());
    }

    @Test(priority = 27, groups = "FindDealersTests")
    public void shouldBeAbleToClickListViewButton() {
        dealerDetailPage.clickListView();
    }

    @Test(priority = 28, groups = "FindDealersTests")
    public void shouldBeAbleToFindList() throws  InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(dealerDetailPage.foundList());
        Assert.assertTrue(dealerDetailPage.foundContactButton());
    }

    @Test(priority = 29, groups = "FindDealersTests")
    public void shouldBeAbleToChangeSortingOption() {
        dealerDetailPage.changeSortingOption(selectedSortingOption);
    }

    @Test(priority = 30, groups = "FindDealersTests")
    public void shouldBeAbleToClickFirstListing() {
        dealerDetailPage.selectFirstListing();
    }

    @Test(priority = 31, groups = "FindDealersTests")
    public void shouldBeAbleToClickResearch() {
        vehicleDetailsPage.clickResearch();
   }

    @Test(priority = 32, groups = "FindDealersTests")
    public void shouldBeAbleToClickStar() throws InterruptedException {
        Thread.sleep(2000);
        vehicleDetailsPage.saveListing();
        vehicleDetailsPage = signIn();
    }

    public VehicleDetailsPage signIn() {
        signInPage.enterPassword(password);
        signInPage.enterEmail(userName);
        return signInPage.clickSignInForSaveListing();
    }

    @Test(priority = 33, groups = "FindDealersTests")
    public void shouldBeAbleToClickSellerInfo() throws InterruptedException{
        Thread.sleep(2000);
        sellerInfoPage = vehicleDetailsPage.clickSellerInfo();
        Assert.assertTrue(sellerInfoPage.checkGetDirections());
        Assert.assertTrue(sellerInfoPage.checkEmailDealer());
        Assert.assertTrue(sellerInfoPage.checkViewInventory());
        Thread.sleep(2000);
        vehicleDetailsPage.saveListing();
    }

    @Test(priority = 34, groups = "FindDealersTests")
    public void shouldBeAbleToGoBack() throws InterruptedException {
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(2000);
        Assert.assertTrue(vehicleDetailsPage.checkFoundThePage());
        deleteSavedListing();
    }

    public void deleteSavedListing() throws InterruptedException {
        driver.get(homeMainPage.pageUrl);
        Thread.sleep(2000);
        homeSidePage = homeMainPage.clickHambergerButton();
        Thread.sleep(2000);
        savedListingsPage = homeSidePage.clickSideMenuSavedListingsLinkSignedIn("SAVED LISTINGS");
        Thread.sleep(2000);
        savedListingsPage.deleteSavedListing(0);
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}




