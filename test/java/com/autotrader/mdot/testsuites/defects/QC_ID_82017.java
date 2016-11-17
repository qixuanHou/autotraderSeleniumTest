package com.autotrader.mdot.testsuites.defects;

import com.autotrader.mdot.pages.FYC.LocationAndRadiusSliderPage;
import com.autotrader.mdot.pages.FYC.NewUsedCertifiedSliderPage;
import com.autotrader.mdot.pages.FYC.SearchResultsLandingPage;
import com.autotrader.mdot.pages.FYC.YearMakeModelTrimSliderPage;
import com.autotrader.mdot.pages.misc.HomeMainPage;
import com.autotrader.mdot.pages.misc.VehicleDetailsPage;
import com.autotrader.mdot.utilities.mDotElements;
import com.google.common.cache.LoadingCache;
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
public class QC_ID_82017 {

    public WebDriver driver;
    public String qaEnv = "https://m-test1.autotrader.com/";


    //These are the test variables. Change these if desired.
    public String baseUrl = "https://m-test1.autotrader.com/";
    public String make = "Honda";
    public String model = "Accord";
    public String newUsedCert = "Used";
    public String trim = "LX";

    HomeMainPage homeMainPage;
    YearMakeModelTrimSliderPage yearMakeModelTrimSliderPage;
    LocationAndRadiusSliderPage locationAndRadiusSliderPage;
    NewUsedCertifiedSliderPage newUsedCertifiedSliderPage;
    SearchResultsLandingPage searchResultsLandingPage;
    VehicleDetailsPage vehicleDetailsPage;
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
            baseUrl = qaEnv;
        }
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.baseUrl = baseUrl;
        homeMainPage = new HomeMainPage(driver);
        yearMakeModelTrimSliderPage = new YearMakeModelTrimSliderPage(driver);
        locationAndRadiusSliderPage = new LocationAndRadiusSliderPage(driver);
        newUsedCertifiedSliderPage = new NewUsedCertifiedSliderPage(driver);
        searchResultsLandingPage = new SearchResultsLandingPage(driver);
        vehicleDetailsPage = new VehicleDetailsPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    /**
     *
     * This test ensures that the vehicle description appears at the top of the page on the VDP
     *
     *
     */

    @Test
    public void shouldBeAbleToLandOnHomePage(){
        driver.get(baseUrl);
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToLandOnHomePage"})
    public void shouldNavigateToLocationAndRadiusSliderPage(){
        locationAndRadiusSliderPage = homeMainPage.clickLocationAndRadius();
        locationAndRadiusSliderPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldNavigateToLocationAndRadiusSliderPage"})
    public void shouldEnterZipAndRadius(){
        locationAndRadiusSliderPage.setZip("30032");
        locationAndRadiusSliderPage.selectRadius(mDotElements.Radius.ONE_HUNDRED_MILES);
        homeMainPage = locationAndRadiusSliderPage.clickOnDone();
    }

    @Test(dependsOnMethods = {"shouldEnterZipAndRadius"})
    public void shouldNavigateToNewUsedCertifiedSliderPage(){
        newUsedCertifiedSliderPage = homeMainPage.clickNewUsedCertified();
        newUsedCertifiedSliderPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldNavigateToNewUsedCertifiedSliderPage"})
    public void shouldSelectUsed(){
        newUsedCertifiedSliderPage.selectUsed();
        homeMainPage = newUsedCertifiedSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldSelectUsed"})
    public void shouldNavigateToYearMakeModelTrimSliderPage(){
        yearMakeModelTrimSliderPage = homeMainPage.clickYearMakeModelTrim();
        yearMakeModelTrimSliderPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldNavigateToYearMakeModelTrimSliderPage"})
    public void shouldSelectFromAndToYear(){
        yearMakeModelTrimSliderPage.selectYearBeginning("2012");
        yearMakeModelTrimSliderPage.selectYearEnding("2015");
    }

    @Test(dependsOnMethods = {"shouldSelectFromAndToYear"})
    public void shouldSelectAMake() throws InterruptedException{
        yearMakeModelTrimSliderPage.clickMakeSelector();
        Thread.sleep(2000);
        yearMakeModelTrimSliderPage.selectMake(make);
        yearMakeModelTrimSliderPage.clickMakeSelect();
        yearMakeModelTrimSliderPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldSelectAMake"})
    public void shouldSelectAModel() throws InterruptedException{
        yearMakeModelTrimSliderPage.clickModelSelector();
        Thread.sleep(2000);
        yearMakeModelTrimSliderPage.selectModel(model);
        yearMakeModelTrimSliderPage.clickModelSelect();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldSelectAModel"})
    public void shouldSelectATrim() throws InterruptedException{
        yearMakeModelTrimSliderPage.clickTrimSelector();
        Thread.sleep(2000);
        yearMakeModelTrimSliderPage.selectTrim(trim);
        yearMakeModelTrimSliderPage.clickTrimSelect();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldSelectATrim"})
    public void shouldNavigateBackToHomePage() throws InterruptedException{
        homeMainPage = yearMakeModelTrimSliderPage.clickApplyButton();
        homeMainPage.waitForObject();
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldSelectATrim"})
    public void shouldNavigateToTheSrp() {
        searchResultsLandingPage = homeMainPage.clickSearchForCars();
        searchResultsLandingPage.waitForObject();
        assertTrue(searchResultsLandingPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldNavigateToTheSrp"})
    public void shouldSelectAListing() throws InterruptedException{
        searchResultsLandingPage.clickOneListing(4);
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldSelectAListing"})
    public void shouldAssertVehicleDetailsHeader(){
        assertTrue(vehicleDetailsPage.verifyVehicleDetails(make));
        assertTrue(vehicleDetailsPage.verifyVehicleDetails(model));
        assertTrue(vehicleDetailsPage.verifyVehicleDetails(newUsedCert));
        assertTrue(vehicleDetailsPage.verifyVehicleDetails(trim));
    }



}
