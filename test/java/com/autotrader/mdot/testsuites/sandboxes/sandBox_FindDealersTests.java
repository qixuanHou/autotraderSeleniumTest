package com.autotrader.mdot.testsuites.sandboxes;

import com.autotrader.mdot.pages.Dealers.DsrpFilterPage;
import com.autotrader.mdot.pages.Dealers.DealerLocationPage;
import com.autotrader.mdot.pages.Dealers.DealerDetailPage;
import com.autotrader.mdot.pages.Dealers.DealerSearchResultsPage;
import com.autotrader.mdot.pages.misc.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


/**
 * Created by qhou on 9/8/2015.
 */
public class sandBox_FindDealersTests {

    public WebDriver driver;

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
    public void setup() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();

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
    }

    @Test
    public void shouldBeAbleToLaunchToLocationPage() throws InterruptedException {
        signIn();
        homeSidePage = homeMainPage.clickHambergerButton();
        dealerLocationPage = homeSidePage.clickSideMenuDealersLink("DEALERS");
        Thread.sleep(4000);
    }

    public void signIn() throws InterruptedException{
        driver.get(homeMainPage.pageUrl);
        signInPage = homeMainPage.clickSignInButtonTopRight();
        signInPage.enterPassword(password);
        signInPage.enterEmail(userName);
        homeMainPage = signInPage.clickSignIn();
        Thread.sleep(4000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToLaunchToLocationPage"})
    public void shouldBeAbleToInputZipCode() throws InterruptedException {
        dealerLocationPage.enterZipCode(zipCode);
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToInputZipCode"})
    public void shouldBeAbleToChooseRadius() throws InterruptedException {
        dealerLocationPage.chooseRadius(chosenRadius);
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToChooseRadius"})
    public void shouldBeAbleToClickDoneButton() throws InterruptedException {
        dealerLocationPage.clickDone();
        Thread.sleep(2000);
    }

    //added test case
    @Test(dependsOnMethods = {"shouldBeAbleToClickDoneButton"})
    public void shouldBeAbleToClickMapView() throws InterruptedException {
        dealerSearchResultsPage.MapView();
        Thread.sleep(2000);
    }

    //added test case
    @Test(dependsOnMethods = {"shouldBeAbleToClickMapView"})
    public void shouldBeAbleToClickListView() throws InterruptedException {
        dealerSearchResultsPage.ListView();
        Thread.sleep(2000);
    }


    @Test(dependsOnMethods = {"shouldBeAbleToClickListView"})
    public void shouldBeAbleToClickFilterButton() throws InterruptedException {
        dealerSearchResultsPage.clickFilter();
        Thread.sleep(2000);
    }

    //added test case
    @Test(dependsOnMethods = {"shouldBeAbleToClickFilterButton"})
    public void shouldBeAbleToClickCancelButton() throws InterruptedException {
        dsrpFilterPage.clickCancel();
        Thread.sleep(2000);
        dealerSearchResultsPage.clickFilter();
        Thread.sleep(2000);
    }

    //added test case
    @Test(dependsOnMethods = {"shouldBeAbleToClickCancelButton"})
    public void shouldBeAbleToClickClearAllButton() throws InterruptedException {
        dsrpFilterPage.displayMakeDropDown();
        dsrpFilterPage.selectMake("BMW");
        dsrpFilterPage.clickClearAll();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickClearAllButton"})
    public void shouldBeAbleToClickMakeButton() throws InterruptedException {
        dsrpFilterPage.displayMakeDropDown();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickMakeButton"})
    public void shouldBeAbleToSelectMake() throws InterruptedException {
        dsrpFilterPage.selectMake(selectedMake);
        Thread.sleep(2000);
    }

    //added test case
    @Test(dependsOnMethods = {"shouldBeAbleToSelectMake"})
    public void shouldBeAbleToClickLocationButton() throws InterruptedException {
        dsrpFilterPage.displayLocationDropDown();
        Thread.sleep(2000);
    }

    //added test case
    @Test(dependsOnMethods = {"shouldBeAbleToClickLocationButton"})
    public void shouldBeAbleToInputZipCodeInFilter() throws InterruptedException {
        dsrpFilterPage.inputZipCode(newZipCode);
        Thread.sleep(2000);
    }

    //added test case
    @Test(dependsOnMethods = {"shouldBeAbleToInputZipCodeInFilter"})
    public void shouldBeAbleToSelectRadius() throws InterruptedException {
        dsrpFilterPage.selectRadius(newSelectedRadius);
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSelectRadius"})
    public void shouldBeAbleToInputKeyword() throws InterruptedException {
        dsrpFilterPage.displayKeywordDropDown();
        dsrpFilterPage.inputKeyword(keyword);
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToInputKeyword"})
    public void shouldBeAbleToClickApply() throws InterruptedException {
        dsrpFilterPage.clickApply();
        Thread.sleep(2000);
    }

    //added test case
    @Test(dependsOnMethods = {"shouldBeAbleToClickApply"})
    public void shouldBeAbleToClickLoadMore() throws InterruptedException {
        dealerSearchResultsPage.clickLoadMore();
        Thread.sleep(6000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickLoadMore"})
    public void shouldBeAbleToClickViewListings() throws InterruptedException {
        dealerSearchResultsPage.clickViewListings();
        Thread.sleep(2000);
    }

    //added test case
    @Test(dependsOnMethods = {"shouldBeAbleToClickViewListings"})
    public void shouldBeAbleToClickImageViewButton() throws InterruptedException {
        dealerDetailPage.clickImageView();
        Thread.sleep(4000);
    }

    //added test case
    @Test(dependsOnMethods = {"shouldBeAbleToClickImageViewButton"})
    public void shouldBeAbleToFindImage() throws InterruptedException {
        Assert.assertTrue(dealerDetailPage.foundImage());
        Assert.assertTrue(dealerDetailPage.foundContactButton());
        Assert.assertTrue(dealerDetailPage.foundGetDirectionButton());
    }

    //added test case
    @Test(dependsOnMethods = {"shouldBeAbleToFindImage"})
    public void shouldBeAbleToClickListViewButton() throws InterruptedException {
        dealerDetailPage.clickListView();
        Thread.sleep(4000);
    }

    //added test case
    @Test(dependsOnMethods = {"shouldBeAbleToClickListViewButton"})
    public void shouldBeAbleToFindList() throws InterruptedException {
        Assert.assertTrue(dealerDetailPage.foundList());
        Assert.assertTrue(dealerDetailPage.foundContactButton());
        Assert.assertTrue(dealerDetailPage.foundGetDirectionButton());
    }

    //added test case
    @Test(dependsOnMethods = {"shouldBeAbleToFindList"})
    public void shouldBeAbleToChangeSortingOption() throws InterruptedException {
        dealerDetailPage.changeSortingOption(selectedSortingOption);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToChangeSortingOption"})
    public void shouldBeAbleToClickFirstListing() throws InterruptedException {
        dealerDetailPage.selectFirstListing();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickFirstListing"})
    public void shouldBeAbleToClickStar() throws InterruptedException {
        vehicleDetailsPage.saveListing();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickStar"})
    public void shouldBeAbleToClickResearch() throws InterruptedException {
        vehicleDetailsPage.clickResearch();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickResearch"})
    public void shouldBeAbleToClickSellerInfo() throws InterruptedException {
        SellerInfoPage sellerInfoPage = vehicleDetailsPage.clickSellerInfo();
        Assert.assertTrue(sellerInfoPage.checkGetDirections());
        Assert.assertTrue(sellerInfoPage.checkEmailDealer());
        Assert.assertTrue(sellerInfoPage.checkViewInventory());
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickSellerInfo"})
    public void shouldBeAbleToGoBack() throws InterruptedException {
        driver.navigate().back();
        driver.navigate().back();
        Assert.assertTrue(vehicleDetailsPage.checkFoundThePage());
        Thread.sleep(2000);
        deleteSavedListing();
    }

    public void deleteSavedListing() throws InterruptedException {
        driver.get(homeMainPage.pageUrl);
        Thread.sleep(2000);
        homeSidePage = homeMainPage.clickHambergerButton();
        Thread.sleep(2000);
        savedListingsPage = homeSidePage.clickSideMenuSavedListingsLinkSignedIn("SAVED LISTINGS");
        Thread.sleep(4000);
        savedListingsPage.deleteSavedListing(0);
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown(){
        this.driver.quit();
    }
}




