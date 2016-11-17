package com.autotrader.mdot.testsuites.regression;

import com.autotrader.mdot.pages.FYC.LocationAndRadiusSliderPage;
import com.autotrader.mdot.pages.FYC.SearchResultsLandingPage;
import com.autotrader.mdot.pages.FYC.StyleSliderPage;
import com.autotrader.mdot.pages.FYC.YearMakeModelTrimSliderPage;
import com.autotrader.mdot.pages.misc.HomeMainPage;
import com.autotrader.mdot.pages.misc.VehicleDetailsPage;
import com.autotrader.mdot.testsuites.TestExtension;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

/**
 * Created by mwstratton on 12/9/2015.
 */
public class AdVerificationTests extends TestExtension {

    HomeMainPage homeMainPage;
    YearMakeModelTrimSliderPage yearMakeModelTrimSliderPage;
    StyleSliderPage styleSliderPage;
    SearchResultsLandingPage searchResultsLandingPage;
    LocationAndRadiusSliderPage locationAndRadiusSliderPage;
    VehicleDetailsPage vehicleDetailsPage;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        homeMainPage = new HomeMainPage(driver);
        yearMakeModelTrimSliderPage = new YearMakeModelTrimSliderPage(driver);
        styleSliderPage = new StyleSliderPage(driver);
        searchResultsLandingPage = new SearchResultsLandingPage(driver);
        locationAndRadiusSliderPage = new LocationAndRadiusSliderPage(driver);
        vehicleDetailsPage = new VehicleDetailsPage(driver);
    }

    @Test
    public void shouldLandOnProductionHomepage() throws InterruptedException{
        driver.get("http://m.autotrader.com/");
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldLandOnProductionHomepage"})
    public void shouldVerifyHomepageAdvertisement(){
        assertTrue(homeMainPage.checkForAd());
    }

    @Test(dependsOnMethods = {"shouldVerifyHomepageAdvertisement"})
    public void shouldVerifyMakePageAdvertisement() throws InterruptedException{
        yearMakeModelTrimSliderPage = homeMainPage.clickYearMakeModelTrim();
        Thread.sleep(2000);
        yearMakeModelTrimSliderPage.clickMakeSelector();
        Thread.sleep(2000);
        assertTrue(yearMakeModelTrimSliderPage.verifyMakeAdIsDisplayed());
        yearMakeModelTrimSliderPage.selectMake("Audi");
        yearMakeModelTrimSliderPage.clickMakeSelect();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldVerifyMakePageAdvertisement"})
    public void shouldVerifyModelPageAdvertisement() throws InterruptedException{
        yearMakeModelTrimSliderPage.clickModelSelector();
        Thread.sleep(2000);
        assertTrue(yearMakeModelTrimSliderPage.verifyModelAdIsDisplayed());
        yearMakeModelTrimSliderPage.clickModelSelect();
        Thread.sleep(2000);
        homeMainPage = yearMakeModelTrimSliderPage.clickApplyButton();
    }

    @Test(dependsOnMethods = {"shouldVerifyModelPageAdvertisement"})
    public void shouldNavigateToSrp() throws InterruptedException {
        locationAndRadiusSliderPage = homeMainPage.clickSearchForCarsWithoutZipCode();
        searchResultsLandingPage = locationAndRadiusSliderPage.clickOnDoneToGetToNationalSrp();
        Thread.sleep(2000);
        assertTrue(searchResultsLandingPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldNavigateToSrp"})
    public void shouldVerifyAdDisplayedAfterFifthListing(){
        assertTrue(searchResultsLandingPage.verifyFirstAdIsDisplayed());
    }

    @Test(dependsOnMethods = {"shouldVerifyAdDisplayedAfterFifthListing"})
    public void shouldVerifyAdDisplayedAfterTenthListing(){
        assertTrue(searchResultsLandingPage.verifySecondAdIsDisplayed());
    }

    @Test(dependsOnMethods = {"shouldVerifyAdDisplayedAfterTenthListing"})
    public void shouldVerifyAdDisplayedAfterFifteenthListing(){
        assertTrue(searchResultsLandingPage.verifyThirdAdIsDisplayed());
    }

    @Test(dependsOnMethods = {"shouldVerifyAdDisplayedAfterFifteenthListing"})
    public void shouldNavigateToVDP() throws InterruptedException{
        vehicleDetailsPage = searchResultsLandingPage.clickOneListing(6);
        Thread.sleep(2000);
        assertTrue(vehicleDetailsPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldNavigateToVDP"})
    public void shouldVerifyVdpAdvertisement()throws InterruptedException{
        Thread.sleep(2000);
        assertTrue(vehicleDetailsPage.verifyVdpAdIsDisplayed());
    }


}
