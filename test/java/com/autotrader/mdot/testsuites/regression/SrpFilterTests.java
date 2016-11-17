package com.autotrader.mdot.testsuites.regression;

import com.autotrader.mdot.pages.FYC.FiltersSliderPage;
import com.autotrader.mdot.pages.FYC.LocationAndRadiusSliderPage;
import com.autotrader.mdot.pages.FYC.SearchResultsLandingPage;
import com.autotrader.mdot.pages.misc.HomeMainPage;
import com.autotrader.mdot.pages.misc.VehicleDetailsPage;
import com.autotrader.mdot.testsuites.TestExtension;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

/**
 * Created by mwstratton on 11/12/2015.
 */
public class SrpFilterTests extends TestExtension {

    HomeMainPage homeMainPage;
    SearchResultsLandingPage searchResultsLandingPage;
    FiltersSliderPage filtersSliderPage;
    LocationAndRadiusSliderPage locationAndRadiusSliderPage;
    VehicleDetailsPage vehicleDetailsPage;

    String yearFrom = "1998";
    String yearTo = "2010";
    String make = "Ford";
    String model = "Mustang";
    String trim = "GT";

    String intColor = "Black";
    String extColor = "Black";
    String condition = "Used";
    String style = "Coupe";
    String minPrice = "15000";
    String maxPrice = "40000";
    String mileage = "Under 100,000";
    String transmission = "Automatic";
    String engineType = "8 Cylinder";
    String fuelType = "Gasoline";
    String driveType = "Rear Wheel Drive";
    String doors = "Two Door";
    String feature = "Cruise Control";
    String fuelEconomy = "Any";
    String keyword1 = "Power Windows";

    @BeforeClass(alwaysRun = true)
    public void setUp(){

        homeMainPage = new HomeMainPage(driver);
        searchResultsLandingPage = new SearchResultsLandingPage(driver);
        filtersSliderPage = new FiltersSliderPage(driver);
        locationAndRadiusSliderPage = new LocationAndRadiusSliderPage(driver);
        vehicleDetailsPage = new VehicleDetailsPage(driver);

    }

    @Test
    public void shouldNavigateToHomepage(){
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldNavigateToHomepage"})
    public void shouldClickSearchForCars() throws InterruptedException{
        locationAndRadiusSliderPage = homeMainPage.clickSearchForCarsWithoutZipCode();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldClickSearchForCars"})
    public void shouldClickDoneAndVerifyNationalSrp(){
        searchResultsLandingPage = locationAndRadiusSliderPage.clickOnDoneToGetToNationalSrp();
        assertTrue(searchResultsLandingPage.checkOnNationalSrp());
    }

    @Test(dependsOnMethods = {"shouldClickDoneAndVerifyNationalSrp"})
    public void shouldClickFilters(){
        filtersSliderPage = searchResultsLandingPage.clickFiltersButton();
        assertTrue(filtersSliderPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldClickFilters"})
    public void shouldVerifyLocationOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Location", 0));
    }

    @Test(dependsOnMethods = {"shouldVerifyLocationOptionIsAvailable"})
    public void shouldVerifyNewUsedCertifiedOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("New/Used/Certified", 1));
    }

    @Test(dependsOnMethods = {"shouldVerifyNewUsedCertifiedOptionIsAvailable"})
    public void shouldVerifyYearMakeModelTrimOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Year/Make/Model/Trim", 2));
    }

    @Test(dependsOnMethods = {"shouldVerifyYearMakeModelTrimOptionIsAvailable"})
    public void shouldVerifyStyleOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Style", 3));
    }

    @Test(dependsOnMethods = {"shouldVerifyStyleOptionIsAvailable"})
    public void shouldVerifyPriceOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Price", 4));
    }

    @Test(dependsOnMethods = {"shouldVerifyPriceOptionIsAvailable"})
    public void shouldVerifyDealersOrPrivateSellersOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Dealers or Private Sellers", 5));
    }

    @Test(dependsOnMethods = {"shouldVerifyDealersOrPrivateSellersOptionIsAvailable"})
    public void shouldVerifyMileageOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Mileage", 6));
    }

    @Test(dependsOnMethods = {"shouldVerifyMileageOptionIsAvailable"})
    public void shouldVerifyExteriorColorOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Exterior Color", 7));
    }

    @Test(dependsOnMethods = {"shouldVerifyExteriorColorOptionIsAvailable"})
    public void shouldVerifyInteriorColorOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Interior Color", 8));
    }

    @Test(dependsOnMethods = {"shouldVerifyInteriorColorOptionIsAvailable"})
    public void shouldVerifyTransmissionOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Transmission", 9));
    }

    @Test(dependsOnMethods = {"shouldVerifyTransmissionOptionIsAvailable"})
    public void shouldVerifyEngineTypeOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Engine Type", 10));
    }

    @Test(dependsOnMethods = {"shouldVerifyEngineTypeOptionIsAvailable"})
    public void shouldVerifyFuelEconomyOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Fuel Economy", 11));
    }

    @Test(dependsOnMethods = {"shouldVerifyFuelEconomyOptionIsAvailable"})
    public void shouldVerifyFuelTypeOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Fuel Type", 12));
    }

    @Test(dependsOnMethods = {"shouldVerifyFuelTypeOptionIsAvailable"})
    public void shouldVerifyDriveTypeOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Drive Type", 13));
    }

    @Test(dependsOnMethods = {"shouldVerifyDriveTypeOptionIsAvailable"})
    public void shouldVerifyDoorsOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Doors", 14));
    }

    @Test(dependsOnMethods = {"shouldVerifyDoorsOptionIsAvailable"})
    public void shouldVerifyVehicleFeaturesOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Vehicle Features", 15));
    }

    @Test(dependsOnMethods = "shouldVerifyVehicleFeaturesOptionIsAvailable")
    public void shouldVerifyPremiumFeaturesOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Premium Features", 16));
    }

    @Test(dependsOnMethods = {"shouldVerifyPremiumFeaturesOptionIsAvailable"})
    public void shouldVerifyListingFeaturesOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Listing Features ", 20));
    }

    @Test(dependsOnMethods = {"shouldVerifyListingFeaturesOptionIsAvailable"})
    public void shouldVerifyKeywordOptionIsAvailable(){
        assertTrue(filtersSliderPage.confirmOptionIsAvailable("Keyword", 21));
    }

    @Test(dependsOnMethods = {"shouldVerifyKeywordOptionIsAvailable"})
    public void shouldApplyAFilterForCondition(){
        filtersSliderPage.selectCondition("Used");
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForCondition"})
    public void shouldApplyAFilterForYearRange() throws InterruptedException{
        Thread.sleep(2000);
        filtersSliderPage.selectFromAndToYear(yearFrom, yearTo);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForYearRange"})
    public void shouldApplyAFilterForMake() throws InterruptedException{
        filtersSliderPage.clickMakeAndSelect(make);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForMake"})
    public void shouldApplyAFilterForModel() throws InterruptedException{
        filtersSliderPage.clickModelAndSelect(model);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForModel"})
    public void shouldApplyAFilterForTrim() throws InterruptedException{
        filtersSliderPage.clickTrimAndSelect(trim);
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForTrim"})
    public void shouldClickApplyAndReturnToSrp() throws InterruptedException{
        searchResultsLandingPage = filtersSliderPage.clickOnApply();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldClickApplyAndReturnToSrp"})
    public void shouldVerifyConditionFilterFunctionality() throws InterruptedException{
        for(int i = 3; i < 7; i++){
            assertTrue(searchResultsLandingPage.verifyConditionListed(condition, i));
            Thread.sleep(1000);
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyConditionFilterFunctionality"})
    public void shouldVerifyYearRangeFilterFunctionality() throws InterruptedException{
        for(int i = 3; i < 7; i++){
            assertTrue(searchResultsLandingPage.verifyYearListed(yearFrom, yearTo, i));
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyYearRangeFilterFunctionality"})
    public void shouldVerifyMakeFilterFunctionality() throws InterruptedException{
        for(int i = 3; i < 7; i++){
            assertTrue(searchResultsLandingPage.verifyMakeListed(make, i));
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyMakeFilterFunctionality"})
    public void shouldVerifyModelFilterFunctionality() throws InterruptedException{
        for(int i = 3; i < 7; i++){
            assertTrue(searchResultsLandingPage.verifyModelListed(model, i));
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyModelFilterFunctionality"})
    public void shouldVerifyTrimFilterFunctionality() throws InterruptedException{
        for(int i = 5; i < 9; i++){
            assertTrue(searchResultsLandingPage.verifyTrimListed(trim, i));
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyTrimFilterFunctionality"})
    public void shouldReturnToFilterPage(){
        filtersSliderPage = searchResultsLandingPage.clickFiltersButton();
        assertTrue(filtersSliderPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldReturnToFilterPage"})
    public void shouldApplyAFilterForStyle(){
        filtersSliderPage.selectAnOption("Style");
        filtersSliderPage.selectStyle(style);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForStyle"})
    public void shouldApplyAFilterForPrice(){
        filtersSliderPage.enterMinAndMaxPrice(minPrice, maxPrice);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForPrice"})
    public void shouldApplyAFilterForMileage(){
        filtersSliderPage.selectMileage(mileage);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForMileage"})
    public void shouldApplyAFilterForExteriorColor(){
        filtersSliderPage.selectAnOption("Exterior Color");
        filtersSliderPage.selectExteriorColor(extColor);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForExteriorColor"})
    public void shouldClickApplyAndReturnBackToSrp() throws InterruptedException{
        searchResultsLandingPage = filtersSliderPage.clickOnApply();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldClickApplyAndReturnBackToSrp"})
    public void shouldVerifyPriceFilterFunctionality() throws InterruptedException{
        for(int i = 3; i < 7; i++){
            assertTrue(searchResultsLandingPage.verifyPriceListed(minPrice, maxPrice, i));
            Thread.sleep(1000);
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyPriceFilterFunctionality"})
    public void shouldVerifyExteriorColorFilterFunctionality() throws InterruptedException{
        for(int i = 3; i < 7; i++){
            assertTrue(searchResultsLandingPage.verifyExtColorListed(extColor, i));
        }
    }

    @Test(dependsOnMethods = {"shouldVerifyExteriorColorFilterFunctionality"})
    public void shouldReturnToTheFilterPage(){
        filtersSliderPage = searchResultsLandingPage.clickFiltersButton();
        assertTrue(filtersSliderPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldReturnToTheFilterPage"})
    public void shouldApplyAFilterForInteriorColor(){
        filtersSliderPage.selectAnOption("Interior Color");
        filtersSliderPage.selectInteriorColor(intColor);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForInteriorColor"})
    public void shouldApplyAFilterForTransmission() throws InterruptedException{
        filtersSliderPage.selectAnOption("Transmission");
        filtersSliderPage.selectSubOption(transmission);
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForTransmission"})
    public void shouldApplyAFilterForEngineType() throws InterruptedException{
        filtersSliderPage.selectEngineType(engineType);
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForEngineType"})
    public void shouldApplyAFilterForFuelEconomy() throws InterruptedException{
        filtersSliderPage.selectFuelEconomy(fuelEconomy);
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForFuelEconomy"})
    public void shouldApplyAFilterForFuelType() throws InterruptedException{
        filtersSliderPage.selectFuelType(fuelType);
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForFuelType"})
    public void shouldApplyAFilterForDriveType() throws InterruptedException{
        filtersSliderPage.selectDriveType(driveType);
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForDriveType"})
    public void shouldApplyAFilterForDoors() throws InterruptedException{
        filtersSliderPage.selectDoors(doors);
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForDoors"})
    public void shouldApplyAFilterForVehicleFeatures() throws InterruptedException{
        filtersSliderPage.selectVehicleFeatures(feature);
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForVehicleFeatures"})
    public void shouldApplyAFilterForKeywords()throws InterruptedException{
        filtersSliderPage.enterKeywords(keyword1);
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldApplyAFilterForKeywords"})
    public void shouldClickApplyAndReturnToTheSrp() throws InterruptedException{
        searchResultsLandingPage = filtersSliderPage.clickOnApply();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldClickApplyAndReturnToTheSrp"})
    public void shouldClickAListingAndGoToVdp() throws InterruptedException{
        vehicleDetailsPage = searchResultsLandingPage.clickOneListing(2);
        assertTrue(vehicleDetailsPage.checkOnCorrectPage());
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldClickAListingAndGoToVdp"})
    public void shouldVerifyFuelTypeFilterFunctionality(){
        assertTrue(vehicleDetailsPage.verifyFeature(fuelType));
    }

    @Test(dependsOnMethods = {"shouldVerifyFuelTypeFilterFunctionality"})
    public void shouldVerifyTransmissionFilterFunctionality(){
        assertTrue(vehicleDetailsPage.verifyTransmission(transmission));
    }

    @Test(dependsOnMethods = {"shouldVerifyTransmissionFilterFunctionality"})
    public void shouldVerifyDoorsFilterFunctionality(){
        assertTrue(vehicleDetailsPage.verifyDoors(doors));
    }

    @Test(dependsOnMethods = {"shouldVerifyDoorsFilterFunctionality"})
    public void shouldVerifyEngineTypeFilterFunctionality(){
        assertTrue(vehicleDetailsPage.verifyEngine(engineType));
    }

    @Test(dependsOnMethods = {"shouldVerifyEngineTypeFilterFunctionality"})
    public void shouldVerifyIntColorFilterFunctionality(){
        assertTrue(vehicleDetailsPage.verifyFuelType(intColor));
    }

    @Test(dependsOnMethods = {"shouldVerifyIntColorFilterFunctionality"})
    public void shouldVerifyExtColorFilterFunctionality(){
        assertTrue(vehicleDetailsPage.verifyExteriorColor(extColor));
    }










}
