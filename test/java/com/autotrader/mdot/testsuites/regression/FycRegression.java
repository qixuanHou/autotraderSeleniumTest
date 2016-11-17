package com.autotrader.mdot.testsuites.regression;

import com.autotrader.mdot.pages.FYC.*;
import com.autotrader.mdot.pages.misc.*;
import com.autotrader.mdot.testsuites.TestExtension;
import com.autotrader.mdot.utilities.mDotElements;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import sun.management.HotspotMemoryMBean;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

/**
 * Created by qhou on 9/29/2015.
 */
public class FycRegression extends TestExtension {

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

    @BeforeClass(alwaysRun = true)
    public void setup() {
        homeMainPage = new HomeMainPage(driver);
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

    @Test
    public void shouldNavigateToHomepage() {
        driver.get(baseUrl);
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldNavigateToHomepage"})
    public void checkFYCDisplayed() {
        Assert.assertTrue(homeMainPage.checkFYCDisplayed());
    }


    @Test(dependsOnMethods = {"checkFYCDisplayed"})
    public void checkFYCNewUsedCertifiedFilterDisplayed() {
        Assert.assertTrue(homeMainPage.checkFYCNewUsedCertifiedFilterDisplayed("Any"));
    }

    @Test(dependsOnMethods = {"checkFYCNewUsedCertifiedFilterDisplayed"})
    public void checkFYCYearMakeModelTrimFilterDisplayed() {
        Assert.assertTrue(homeMainPage.checkFYCYearMakeModelTrimFilterDisplayed("Any"));
    }

    @Test(dependsOnMethods = {"checkFYCYearMakeModelTrimFilterDisplayed"})
    public void checkFYCStyleFilterDisplayed() {
        Assert.assertTrue(homeMainPage.checkFYCStyleFilterDisplayed("Any"));
    }

    @Test(dependsOnMethods = {"checkFYCStyleFilterDisplayed"})
    public void checkFYCMoreOptionFilterDisplayed() {
        Assert.assertTrue(homeMainPage.checkFYCMoreOptionFilterDisplayed("Any"));
    }

    @Test(dependsOnMethods = {"checkFYCMoreOptionFilterDisplayed"})
    public void checkFYCLocationRadiusFilterDisplayed() {
        Assert.assertTrue(homeMainPage.checkFYCLocationRadiusFilterDisplayed());
    }

    @Test(dependsOnMethods = {"checkFYCLocationRadiusFilterDisplayed"})
    public void checkSearchForCarButtonDisplayed() {
        Assert.assertTrue(homeMainPage.checkSearchForCarButtonDisplayed());
    }

    @Test(dependsOnMethods = {"checkFYCLocationRadiusFilterDisplayed"})
    public void shouldNavigateToNewUsedCertifiedSliderPage() {
        newUsedCertifiedSliderPage = homeMainPage.clickNewUsedCertified();
        newUsedCertifiedSliderPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldNavigateToNewUsedCertifiedSliderPage"})
    public void shouldClickCancelButton() {
        homeMainPage = newUsedCertifiedSliderPage.clickCancelButton();
        homeMainPage.waitForObject();
        newUsedCertifiedSliderPage = homeMainPage.clickNewUsedCertified();
        newUsedCertifiedSliderPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldClickCancelButton"})
    public void shouldClickApplyButton() {
        homeMainPage = newUsedCertifiedSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
        newUsedCertifiedSliderPage = homeMainPage.clickNewUsedCertified();
        newUsedCertifiedSliderPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldClickApplyButton"})
    public void shouldClickAny() {
        Assert.assertTrue(newUsedCertifiedSliderPage.confirmAnyDisplayed());
        newUsedCertifiedSliderPage.selectAny();
        homeMainPage = newUsedCertifiedSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldClickAny"})
    public void shouldConfirmAny() {
        Assert.assertTrue(homeMainPage.checkFYCNewUsedCertifiedFilterDisplayed("Any"));
        newUsedCertifiedSliderPage = homeMainPage.clickNewUsedCertified();
        newUsedCertifiedSliderPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldConfirmAny"})
    public void shouldClickNew() {
        Assert.assertTrue(newUsedCertifiedSliderPage.confirmNewDisplayed());
        newUsedCertifiedSliderPage.selectNew();
        homeMainPage = newUsedCertifiedSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldClickNew"})
    public void shouldConfirmNew() {
        Assert.assertTrue(homeMainPage.checkFYCNewUsedCertifiedFilterDisplayed("New"));
        newUsedCertifiedSliderPage = homeMainPage.clickNewUsedCertified();
        newUsedCertifiedSliderPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldConfirmNew"})
    public void shouldClickCertified() {
        Assert.assertTrue(newUsedCertifiedSliderPage.confirmCertifiedDisplayed());
        newUsedCertifiedSliderPage.selectCertified();
        homeMainPage = newUsedCertifiedSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldClickCertified"})
    public void shouldConfirmCertified() {
        Assert.assertTrue(homeMainPage.checkFYCNewUsedCertifiedFilterDisplayed("Certified"));
        newUsedCertifiedSliderPage = homeMainPage.clickNewUsedCertified();
        newUsedCertifiedSliderPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldConfirmCertified"})
    public void shouldClickClearButton() throws InterruptedException {
        newUsedCertifiedSliderPage.clickClearButton();
        homeMainPage = newUsedCertifiedSliderPage.clickApplyButton();
        Assert.assertTrue(homeMainPage.checkFYCNewUsedCertifiedFilterDisplayed("Any"));
        newUsedCertifiedSliderPage = homeMainPage.clickNewUsedCertified();
    }

    @Test(dependsOnMethods = {"shouldClickClearButton"})
    public void shouldClickUsed() {
        Assert.assertTrue(newUsedCertifiedSliderPage.confirmUsedDisplayed());
        newUsedCertifiedSliderPage.selectUsed();
        homeMainPage = newUsedCertifiedSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldClickUsed"})
    public void shouldConfirmUsed() {
        Assert.assertTrue(homeMainPage.checkFYCNewUsedCertifiedFilterDisplayed("Used"));
    }

    @Test(dependsOnMethods = {"shouldConfirmUsed"})
    public void shouldNavigateToYearMakeModelTrimSliderPage() throws InterruptedException{
        Thread.sleep(2000);
        yearMakeModelTrimSliderPage = homeMainPage.clickYearMakeModelTrim();
        yearMakeModelTrimSliderPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldNavigateToYearMakeModelTrimSliderPage"})
    public void shouldSelectYearBegin() {
        yearMakeModelTrimSliderPage.selectYearBeginning("1994");
        Assert.assertTrue(yearMakeModelTrimSliderPage.confirmYearBegin("1994"));
    }

    @Test(dependsOnMethods = {"shouldSelectYearBegin"})
    public void checkYearRangeInYearEnd() {
        Assert.assertFalse(yearMakeModelTrimSliderPage.confirmYearRangeYearEnd("1993"));
    }

    @Test(dependsOnMethods = {"checkYearRangeInYearEnd"})
    public void shouldSelectYearEnd() {
        yearMakeModelTrimSliderPage.selectYearEnding("2015");
        Assert.assertTrue(yearMakeModelTrimSliderPage.confirmYearEnd("2015"));
    }

    @Test(dependsOnMethods = {"shouldSelectYearEnd"})
    public void checkYearRangeInYearBegin() {
        Assert.assertFalse(yearMakeModelTrimSliderPage.confirmYearRangeYearBegin("2016"));
    }

    @Test(dependsOnMethods = {"checkYearRangeInYearBegin"})
    public void checkYearOlderThan1981() throws InterruptedException{
        yearMakeModelTrimSliderPage.selectYearBeginning("1980 or older");
        Alert alt = driver.switchTo().alert();
        alt.accept();
        Thread.sleep(4000);
        driver.navigate().back();
        newUsedCertifiedSliderPage = homeMainPage.clickNewUsedCertified();
        newUsedCertifiedSliderPage.selectUsed();
        homeMainPage = newUsedCertifiedSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
        yearMakeModelTrimSliderPage = homeMainPage.clickYearMakeModelTrim();
        yearMakeModelTrimSliderPage.waitForObject();
        yearMakeModelTrimSliderPage.selectYearBeginning("1994");
        Assert.assertTrue(yearMakeModelTrimSliderPage.confirmYearBegin("1994"));
        yearMakeModelTrimSliderPage.selectYearEnding("2015");
        Assert.assertTrue(yearMakeModelTrimSliderPage.confirmYearEnd("2015"));
    }

    @Test(dependsOnMethods = {"checkYearOlderThan1981"})
    public void shouldClickLastMakeSelector() {
        yearMakeModelTrimSliderPage.clickMakeSelector();
        yearMakeModelTrimSliderPage.waitForMakeView();
        yearMakeModelTrimSliderPage.selectMake("Volvo");
        yearMakeModelTrimSliderPage.clickMakeSelect();
        yearMakeModelTrimSliderPage.waitForObject();
        Assert.assertTrue(yearMakeModelTrimSliderPage.confirmMake("Volvo"));
    }

    @Test(dependsOnMethods = {"shouldClickLastMakeSelector"})
    public void shouldClickMakeSelector() {
        yearMakeModelTrimSliderPage.clickMakeSelector();
        yearMakeModelTrimSliderPage.waitForMakeView();
        yearMakeModelTrimSliderPage.selectMake("Honda");
        yearMakeModelTrimSliderPage.clickMakeSelect();
        yearMakeModelTrimSliderPage.waitForObject();
        Assert.assertTrue(yearMakeModelTrimSliderPage.confirmMake("Honda"));
    }

    @Test(dependsOnMethods = {"shouldClickMakeSelector"})
    public void shouldClickModelSelector() {
        yearMakeModelTrimSliderPage.clickModelSelector();
        yearMakeModelTrimSliderPage.waitForModelView();
        yearMakeModelTrimSliderPage.selectModel("Pilot");
        yearMakeModelTrimSliderPage.clickModelSelect();
        Assert.assertTrue(yearMakeModelTrimSliderPage.confirmModel("Pilot"));
    }

    @Test(dependsOnMethods = {"shouldClickModelSelector"})
    public void shouldClickModelSelectorAgain() {
        yearMakeModelTrimSliderPage.clickModelSelector();
        yearMakeModelTrimSliderPage.waitForModelView();
        yearMakeModelTrimSliderPage.selectModel("CR-V");
        yearMakeModelTrimSliderPage.clickModelSelect();
        Assert.assertTrue(yearMakeModelTrimSliderPage.confirmModel("CR-V"));
    }

    @Test(dependsOnMethods = {"shouldClickModelSelectorAgain"})
    public void shouldClickTrimSelector() {
        yearMakeModelTrimSliderPage.clickTrimSelector();
        yearMakeModelTrimSliderPage.waitForTrimView();
        yearMakeModelTrimSliderPage.selectTrim("EX");
        yearMakeModelTrimSliderPage.clickTrimSelect();
        Assert.assertTrue(yearMakeModelTrimSliderPage.confirmTrim("EX"));
    }


    @Test(dependsOnMethods = {"shouldClickTrimSelector"})
    public void shouldNavigateBackToHomePage() {
        homeMainPage = yearMakeModelTrimSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldNavigateBackToHomePage"})
    public void shouldDisplaySelectedYearMakeModelTrim() {
        Assert.assertTrue(homeMainPage.confirmYearMakeModelTrim("1 Selected"));
    }

    @Test(dependsOnMethods = {"shouldDisplaySelectedYearMakeModelTrim"})
    public void shouldAddAnotherCar() throws InterruptedException{
        yearMakeModelTrimSliderPage = homeMainPage.clickYearMakeModelTrim();
        yearMakeModelTrimSliderPage.waitForObject();
        Thread.sleep(3000);
        yearMakeModelTrimSliderPage.clickAddAnotherCar();
        Assert.assertTrue(yearMakeModelTrimSliderPage.checkNumberOfCarDisplayed(2));
    }

    @Test(dependsOnMethods = {"shouldAddAnotherCar"})
    public void shouldCancelTheSelectedCar() {
        yearMakeModelTrimSliderPage.clickCancelTheSelectedCar(2);
        Assert.assertTrue(yearMakeModelTrimSliderPage.checkNumberOfCarDisplayed(1));
        homeMainPage = yearMakeModelTrimSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldCancelTheSelectedCar"})
    public void shouldNavigateToStyleSliderPage() {
        homeMainPage.waitForObject();
        styleSliderPage = homeMainPage.clickStyle();
        styleSliderPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldNavigateToStyleSliderPage"})
    public void shouldSelectStyle() {
        styleSliderPage.selectStyle("Sedan");
        homeMainPage = styleSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldSelectStyle"})
    public void shouldDisplaySelectedStyle() throws InterruptedException {
        Assert.assertTrue(homeMainPage.confirmStyle("Sedan"));
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldDisplaySelectedStyle"})
    public void shouldSelectMultipleStyles(){
        styleSliderPage = homeMainPage.clickStyle();
        styleSliderPage.selectStyle("AWD / 4WD");
        styleSliderPage.selectStyle("Commercial");
        styleSliderPage.selectStyle("Convertible");
        styleSliderPage.selectStyle("Coupe");
        styleSliderPage.selectStyle("Hatchback");
        styleSliderPage.selectStyle("Hybrid / Electric");
        styleSliderPage.selectStyle("Luxury");
        styleSliderPage.selectStyle("SUV / Crossover");
        styleSliderPage.selectStyle("Truck");
        styleSliderPage.selectStyle("Van / Minivan");
        styleSliderPage.selectStyle("Wagon");
        styleSliderPage.selectStyle("Van / Minivan");
        styleSliderPage.selectStyle("Hatchback");
        homeMainPage = styleSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
    }


    @Test(dependsOnMethods = {"shouldSelectMultipleStyles"})
    public void shouldDisplayMultipleSelectedStyle() {
        Assert.assertTrue(homeMainPage.confirmStyle("10 Selected"));
    }

    @Test(dependsOnMethods = {"shouldDisplayMultipleSelectedStyle"})
    public void shouldNavigateToMoreOptionsSliderPage() throws InterruptedException {
        Thread.sleep(2000);
        moreOptionsSliderPage = homeMainPage.clickMoreOptions();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldNavigateToMoreOptionsSliderPage"})
    public void shouldChangeSetMinPrice() {
        moreOptionsSliderPage.enterMinAndMaxPrice("1200", "40000");
    }

    @Test(dependsOnMethods = {"shouldChangeSetMinPrice"})
    public void shouldDisplayCorrectPriceRange() {
        moreOptionsSliderPage.selectAnOption("Price");
        Assert.assertTrue(moreOptionsSliderPage.checkSelectedLabel("1200 - 40000", 0));
    }

    @Test(dependsOnMethods = {"shouldDisplayCorrectPriceRange"})
    public void shouldSelectDealersOrPrivateSellers() {
        moreOptionsSliderPage.selectAnOption("Dealers or Private Sellers");
        moreOptionsSliderPage.selectSubOption("Dealers Only");
    }

    @Test(dependsOnMethods = {"shouldSelectDealersOrPrivateSellers"})
    public void shouldDisplaySelectedDealersOrPrivateSellers() {
        Assert.assertTrue(moreOptionsSliderPage.checkSelectedLabel("Dealers Only", 1));
    }

    @Test(dependsOnMethods = {"shouldDisplaySelectedDealersOrPrivateSellers"})
    public void shouldSelectMileage() {
        moreOptionsSliderPage.selectAnOption("Mileage");
        moreOptionsSliderPage.selectSubOption("Under 60,000");
    }

    @Test(dependsOnMethods = {"shouldSelectMileage"})
    public void shouldDisplayCorrectMileage() {
        Assert.assertTrue(moreOptionsSliderPage.checkSelectedLabel("Under 60,000", 2));
    }

    @Test(dependsOnMethods = {"shouldDisplayCorrectMileage"})
    public void shouldSelectExteriorColor() {
        moreOptionsSliderPage.selectAnOption("Exterior Color");
        moreOptionsSliderPage.selectExtColor("Black");
        moreOptionsSliderPage.selectExtColor("Blue");
        moreOptionsSliderPage.selectExtColor("Silver");
        moreOptionsSliderPage.selectExtColor("Brown");
        moreOptionsSliderPage.selectExtColor("White");
        moreOptionsSliderPage.selectExtColor("White");
    }


    @Test(dependsOnMethods = {"shouldSelectExteriorColor"})
    public void shouldDisplayCorrectExteriorColor() {
        Assert.assertTrue(moreOptionsSliderPage.checkSelectedLabel("4 Selected", 3));
    }

    @Test(dependsOnMethods = {"shouldDisplayCorrectExteriorColor"})
    public void shouldSelectInteriorColor() {
        moreOptionsSliderPage.selectAnOption("Interior Color");
        moreOptionsSliderPage.selectIntColor("Black");
        moreOptionsSliderPage.selectIntColor("Blue");
        moreOptionsSliderPage.selectIntColor("Silver");
        moreOptionsSliderPage.selectIntColor("Brown");
        moreOptionsSliderPage.selectIntColor("White");
        moreOptionsSliderPage.selectIntColor("White");
    }

    @Test(dependsOnMethods = {"shouldSelectInteriorColor"})
    public void shouldDisplayCorrectInteriorColor() {
        Assert.assertTrue(moreOptionsSliderPage.checkSelectedLabel("4 Selected", 4));
    }


    @Test(dependsOnMethods = {"shouldDisplayCorrectInteriorColor"})
    public void shouldSelectTransmission() {
        moreOptionsSliderPage.selectAnOption("Transmission");
        moreOptionsSliderPage.selectSubOption("Automatic");
    }

    @Test(dependsOnMethods = {"shouldSelectTransmission"})
    public void shouldDisplayCorrectTransmission() {
        Assert.assertTrue(moreOptionsSliderPage.checkSelectedLabel("Automatic", 5));
    }

    @Test(dependsOnMethods = {"shouldDisplayCorrectTransmission"})
    public void shouldSelectEngineType() {
        moreOptionsSliderPage.selectAnOption("Engine Type");
        moreOptionsSliderPage.selectSubOption("4 Cylinder");
    }

    @Test(dependsOnMethods = {"shouldSelectEngineType"})
    public void shouldDisplayCorrectEngineType() {
        Assert.assertTrue(moreOptionsSliderPage.checkSelectedLabel("4 Cylinder", 6));
    }

    @Test(dependsOnMethods = {"shouldDisplayCorrectEngineType"})
    public void shouldSelectFuelEconomy() {
        moreOptionsSliderPage.selectAnOption("Fuel Economy");
        moreOptionsSliderPage.selectSubOption("31 - 40 MPG");
    }

    @Test(dependsOnMethods = {"shouldSelectFuelEconomy"})
    public void shouldDisplayCorrectFuelEconomy() {
        Assert.assertTrue(moreOptionsSliderPage.checkSelectedLabel("31 - 40 MPG", 7));
    }

    @Test(dependsOnMethods = {"shouldDisplayCorrectFuelEconomy"})
    public void shouldSelectFuelType() {
        moreOptionsSliderPage.selectAnOption("Fuel Type");
        moreOptionsSliderPage.selectSubOption("Gasoline");
    }

    @Test(dependsOnMethods = {"shouldSelectFuelType"})
    public void shouldDisplayCorrectFuelType() {
        Assert.assertTrue(moreOptionsSliderPage.checkSelectedLabel("Gasoline", 8));
    }

    @Test(dependsOnMethods = {"shouldDisplayCorrectFuelType"})
    public void shouldSelectDriveType() {
        moreOptionsSliderPage.selectAnOption("Drive Type");
        moreOptionsSliderPage.selectSubOption("Front Wheel Drive");
    }

    @Test(dependsOnMethods = {"shouldSelectDriveType"})
    public void shouldDisplayCorrectDriveType() {
        Assert.assertTrue(moreOptionsSliderPage.checkSelectedLabel("Front", 9));
    }

    @Test(dependsOnMethods = {"shouldDisplayCorrectDriveType"})
    public void shouldSelectDoor() {
        moreOptionsSliderPage.selectAnOption("Doors");
        moreOptionsSliderPage.selectSubOption("Four Door");
    }

    @Test(dependsOnMethods = {"shouldSelectDoor"})
    public void shouldDisplayCorrectDoor() {
        Assert.assertTrue(moreOptionsSliderPage.checkSelectedLabel("Four", 10));
    }


    @Test(dependsOnMethods = {"shouldDisplayCorrectDoor"})
    public void shouldSelectVehicleFeatures() {
        moreOptionsSliderPage.selectAnOption("Vehicle Features");
        moreOptionsSliderPage.selectVehicleFeatures("Keyless Entry");
        moreOptionsSliderPage.selectVehicleFeatures("Lift Kit");
        moreOptionsSliderPage.selectVehicleFeatures("Lift Kit");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleFeatures"})
    public void shouldDisplayCorrectVehicleFeatures() {
        Assert.assertTrue(moreOptionsSliderPage.checkSelectedLabel("Keyless Entry", 11));
    }

    @Test(dependsOnMethods = {"shouldDisplayCorrectVehicleFeatures"})
    public void shouldSelectListingFeatures() {
        moreOptionsSliderPage.selectAnOption("Listing Features");
        moreOptionsSliderPage.selectSubOption("With Photos");
    }

    @Test(dependsOnMethods = {"shouldSelectListingFeatures"})
    public void shouldDisplayCorrectListingFeatures() {
        Assert.assertTrue(moreOptionsSliderPage.checkSelectedLabel("With Photos", 13));
    }

    @Test(dependsOnMethods = {"shouldDisplayCorrectListingFeatures"})
    public void shouldInputKeyword() {
        moreOptionsSliderPage.selectAnOption("Keyword");
        moreOptionsSliderPage.enterKeywords("Black");
    }

    @Test(dependsOnMethods = {"shouldInputKeyword"})
    public void shouldClickApply() {
        homeMainPage = moreOptionsSliderPage.clickOnApply();
    }

    @Test(dependsOnMethods = {"shouldClickApply"})
    public void shouldDisplayCorrectNumberInMoreOption() {
        Assert.assertTrue(homeMainPage.confirmOption("14 Selected"));
    }

    @Test(dependsOnMethods = {"shouldDisplayCorrectNumberInMoreOption"})
    public void shouldClickAllOptions() throws InterruptedException {
        moreOptionsSliderPage = homeMainPage.clickMoreOptions();
        moreOptionsSliderPage.clickClearButton();
        moreOptionsSliderPage.selectAnOption("Mileage");
        moreOptionsSliderPage.selectSubOption("Under 60,000");
        homeMainPage = moreOptionsSliderPage.clickOnApply();
        Assert.assertTrue(homeMainPage.confirmOption("1 Selected"));
    }

    @Test(dependsOnMethods = {"shouldClickAllOptions"})
    public void shouldNavigateToLocationAndRadiusSliderPage() throws InterruptedException {
        locationAndRadiusSliderPage = homeMainPage.clickLocationAndRadius();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldNavigateToLocationAndRadiusSliderPage"})
    public void shouldInputZipCode() {
        locationAndRadiusSliderPage.setZip("30032");
    }

    @Test(dependsOnMethods = {"shouldInputZipCode"})
    public void shouldSelectRadius() {
        locationAndRadiusSliderPage.selectRadius(mDotElements.Radius.ONE_HUNDRED_MILES);
        homeMainPage = locationAndRadiusSliderPage.clickOnDone();
    }

    @Test(dependsOnMethods = {"shouldSelectRadius"})
    public void shouldConfirmRadiusAndLocation() {
        Assert.assertTrue(homeMainPage.confirmRadiusAndLocation("30032"));
    }

    @Test(dependsOnMethods = {"shouldConfirmRadiusAndLocation"})
    public void shouldNavigateToTheSrp() {
        homeMainPage.waitForObject();
        searchResultsLandingPage = homeMainPage.clickSearchForCars();
        searchResultsLandingPage.waitForObject();
        Assert.assertTrue(searchResultsLandingPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldNavigateToTheSrp"})
    public void shouldBeAbleToClickImageView() throws InterruptedException {
        searchResultsLandingPage.clickImageView();
        Assert.assertTrue(searchResultsLandingPage.confirmImageView());
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickImageView"})
    public void shouldBeAbleToClickListView() throws InterruptedException {
        searchResultsLandingPage.clickListView();
        Thread.sleep(2000);
        Assert.assertTrue(searchResultsLandingPage.confirmListView());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickListView"})
    public void shouldBeAbleToChangeSortOption() {
        searchResultsLandingPage.changeSortingOption("Price - Low to High");
    }

    @Test(dependsOnMethods = {"shouldBeAbleToChangeSortOption"})
    public void shouldConfirmSortOption() {
        Assert.assertTrue(searchResultsLandingPage.confirmSortSelected("Price - Low to High"));
    }

    @Test(dependsOnMethods = {"shouldConfirmSortOption"})
    public void shouldGetCorrectNumberOfListings() {
        int i = searchResultsLandingPage.getHeader() + 5;
        Assert.assertTrue(searchResultsLandingPage.checkListingNumber(i));
    }

    @Test(dependsOnMethods = {"shouldGetCorrectNumberOfListings"})
    public void shouldVerifyPriceListed() {
        if (searchResultsLandingPage.getListNumber() > 10) {
            for (int i = 0; i < 10; i++) {
                Assert.assertTrue(searchResultsLandingPage.verifyPriceListed("1200", "40000", i+5));
            }
        } else {
            for (int i = 0; i < searchResultsLandingPage.getListNumber(); i++) {
                Assert.assertTrue(searchResultsLandingPage.verifyPriceListed("1200", "40000", i+5));
            }
        }

    }

    @Test(dependsOnMethods = {"shouldVerifyPriceListed"})
    public void shouldVerifyYearListed() {
        if (searchResultsLandingPage.getListNumber() > 10) {
            for (int i = 0; i < 10; i++) {
                Assert.assertTrue(searchResultsLandingPage.verifyYearListed("1994", "2015", i + 5));
            }
        } else {
            for (int i = 0; i < searchResultsLandingPage.getListNumber(); i++) {
                Assert.assertTrue(searchResultsLandingPage.verifyYearListed("1994", "2015", i + 5));
            }
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyYearListed"})
    public void shouldVerifyMakeListed() {
        if (searchResultsLandingPage.getListNumber() > 10) {
            for (int i = 0; i < 10; i++) {
                Assert.assertTrue(searchResultsLandingPage.verifyMakeListed("Honda", i + 5));
            }
        } else {
            for (int i = 0; i < searchResultsLandingPage.getListNumber(); i++) {
                Assert.assertTrue(searchResultsLandingPage.verifyMakeListed("Honda", i + 5));
            }
        }
    }


    @Test(dependsOnMethods = {"shouldVerifyMakeListed"})
    public void shouldVerifyModelListed() {
        if (searchResultsLandingPage.getListNumber() > 10) {
            for (int i = 0; i < 10; i++) {
                Assert.assertTrue(searchResultsLandingPage.verifyModelListed("CR-V", i + 5));
            }
        } else {
            for (int i = 0; i < searchResultsLandingPage.getListNumber(); i++) {
                Assert.assertTrue(searchResultsLandingPage.verifyModelListed("CR-V", i + 5));
            }
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyModelListed"})
    public void shouldVerifyConditionListed() {
        if (searchResultsLandingPage.getListNumber() > 9) {
            for (int i = 0; i < 9; i++) {
                Assert.assertTrue(searchResultsLandingPage.verifyConditionListed("Used", i + 5));
            }
        } else {
            for (int i = 0; i < searchResultsLandingPage.getListNumber(); i++) {
                Assert.assertTrue(searchResultsLandingPage.verifyConditionListed("Used", i + 5));
            }
        }
    }


    @Test(dependsOnMethods = {"shouldVerifyModelListed"})
    public void shouldVerifyTrimListed() {
        if (searchResultsLandingPage.getListNumber() > 9) {
            for (int i = 0; i < 9; i++) {
                Assert.assertTrue(searchResultsLandingPage.verifyTrimListed("EX", i + 5));
            }
        } else {
            for (int i = 0; i < searchResultsLandingPage.getListNumber(); i++) {
                Assert.assertTrue(searchResultsLandingPage.verifyTrimListed("EX", i + 5));
            }
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyTrimListed"})
    public void shouldVerifyLocationListed() {
        if (searchResultsLandingPage.getListNumber() > 9) {
            for (int i = 0; i < 9; i++) {
                Assert.assertTrue(searchResultsLandingPage.verifyLocationListed(100, i + 5));
            }
        } else {
            for (int i = 0; i < searchResultsLandingPage.getListNumber(); i++) {
                Assert.assertTrue(searchResultsLandingPage.verifyLocationListed(100, i + 5));
            }
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyLocationListed"})
    public void shouldVerifyMileageListed() {
        if (searchResultsLandingPage.getListNumber() > 9) {
            for (int i = 0; i < 9; i++) {
                Assert.assertTrue(searchResultsLandingPage.verifyMileageListed(0, 60000, i + 5));
            }
        } else {
            for (int i = 0; i < searchResultsLandingPage.getListNumber(); i++) {
                Assert.assertTrue(searchResultsLandingPage.verifyMileageListed(0, 60000, i + 5));
            }
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyMileageListed"})
    public void shouldNavigateToVDP() {
        vehicleDetailsPage = searchResultsLandingPage.clickOneListing(5);
        vehicleDetailsPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldNavigateToVDP"})
    public void shouldBeAbleToClickResearch() {
        researchPage = vehicleDetailsPage.clickResearch();
        researchPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickResearch"})
     public void shouldCheckOnResearchPage() {
        Assert.assertTrue(researchPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldCheckOnResearchPage"})
    public void shouldBeAbleToClickSellerInfo() {
        sellerInfoPage = researchPage.clickSellerInfo();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickSellerInfo"})
    public void shouldCheckOnSellerInfoPage() {
        Assert.assertTrue(sellerInfoPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldCheckOnSellerInfoPage"})
    public void shouldHaveGetDirectionButton() {
        Assert.assertTrue(sellerInfoPage.checkGetDirections());
    }

    @Test(dependsOnMethods = {"shouldHaveGetDirectionButton"})
    public void shouldHaveEmailDealerButton() {
        Assert.assertTrue(sellerInfoPage.checkEmailDealer());
    }

    @Test(dependsOnMethods = {"shouldHaveEmailDealerButton"})
    public void shouldBeAbleToEmailDealer() {
        sellerInfoPage.emailDealer();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEmailDealer"})
    public void shouldBeAbleToSubmitEmptyEmail() {
        sellerInfoPage.submitEmail();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSubmitEmptyEmail"})
    public void shouldDisplayAlerts() {
        Assert.assertTrue(sellerInfoPage.checkAlertDisplayed());
    }

    @Test(dependsOnMethods = {"shouldDisplayAlerts"})
    public void shouldCancelEmail() {
       sellerInfoPage.cancelEmail();
    }

    @Test(dependsOnMethods = {"shouldCancelEmail"})
    public void shouldHaveViewInventoryButton() {
        Assert.assertTrue(sellerInfoPage.checkViewInventory());
    }

    @Test(dependsOnMethods = {"shouldHaveViewInventoryButton"})
    public void shouldBeAbleToClickCarInfo() {
        sellerInfoPage.clickCarInfo();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickCarInfo"})
    public void shouldBeAbleToClickSellYourCall() {
        sellerInfoPage.clickSellYourCallButton();
        driver.navigate().back();
    }

}
