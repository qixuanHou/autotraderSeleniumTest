package com.autotrader.mdot.testsuites.newfeature;

import com.autotrader.mdot.pages.FYC.LocationAndRadiusSliderPage;
import com.autotrader.mdot.pages.FYC.MoreOptionsSliderPage;
import com.autotrader.mdot.pages.FYC.SearchResultsLandingPage;
import com.autotrader.mdot.pages.FYC.StyleSliderPage;

import com.autotrader.mdot.pages.misc.HomeMainPage;
import com.autotrader.mdot.pages.misc.VehicleDetailsPage;

import com.autotrader.mdot.utilities.WaitFor;
import com.autotrader.mdot.utilities.mDotElements;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

/**
 * Created by sacown on 9/25/2015. Stories Tested: B-14237 - Display eCarOne tile under car info on mobile VDP B-14240 -
 * Display "Reserve Now" Link on Warranty Accordion B-14239 - Display eCarOne Warranty copy on Warranty Accordion on
 * mobile VDP B-14238 - Display eCarOne Tile on Warranty Tab B-14241 - Navigate user to eCarOne offsite link
 */
public class eCarOneTests {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    public String baseUrl;
    public WebDriver driver;
    public String listingUrl;
    DesiredCapabilities capability;
    String copy =
        "Why Choose us?\n"
            + "Haggle-Free, Best Price Guaranteed\n"
            + "Salesman-Free Shopping Experience\n"
            + "Most for your trade Guaranteed";
    String eCarOneLinkText = "Reserve Now";
    String eCarOneTileImageUrl =
        "http://images.qa.autotrader.com/scaler/88/31/cms/images/na/certified/offbrand-tiles/244393.png";
    String eCarOneUrl = "ecarone";

    HomeMainPage homeMainPage;
    LocationAndRadiusSliderPage locationAndRadiusSliderPage;
    MoreOptionsSliderPage moreOptionsSliderPage;
    SearchResultsLandingPage searchResultsLandingPage;
    StyleSliderPage styleSliderPage;
    VehicleDetailsPage vehicleDetailsPage;
    WaitFor waitFor;

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * TODO: Enter Javadoc
     *
     * @param browserName in value
     * @param browser_version in value
     * @param baseUrl in value
     * @param local in value
     * @param testGroup in value
     * @param os in value
     * @param os_version in value
     * @param resolution in value
     * @param bsAccount in value
     * @param bsLocal in value
     * @param listingUrl in value
     *
     * @throws MalformedURLException on error
     */
    @BeforeClass(alwaysRun = true)
    @org.testng.annotations.Parameters(value =
            {
                "browserName", "browser_version", "baseUrl", "local", "testGroup",
                "os", "os_version", "resolution", "bsAccount", "bsLocal", "listingUrl"
            })
    public void setup(@Optional("browserName") String browserName,
            @Optional("version") String browser_version,
            @Optional("baseUrl") String baseUrl,
            @Optional("local") String local,
            @Optional("testGroup") String testGroup,
            @Optional("os") String os,
            @Optional("os_version") String os_version,
            @Optional("resolution") String resolution,
            @Optional("bsAccount") String bsAccount,
            @Optional("bsLocal") String bsLocal,
            @Optional("listingUrl") String listingUrl) throws MalformedURLException {
        if (local.equals("false")) {
            this.capability = new DesiredCapabilities();
            capability.setCapability("browserName", browserName);
            capability.setCapability("browser_version", browser_version);
            capability.setCapability("project", "TimResponsiveFunnelTests");
            capability.setCapability("build", "1.0");
            capability.setCapability("browserstack.debug", "true");
            capability.setCapability("browserstack.local", bsLocal);
            capability.setCapability("os", os);
            capability.setCapability("os_version", os_version);
            capability.setCapability("resolution", resolution);

            this.driver = new RemoteWebDriver(new URL(bsAccount), capability);
        } else {
            this.baseUrl = baseUrl;
            this.listingUrl = listingUrl;
            System.setProperty("webdriver.chrome.driver", "target\\drivers\\chromedriver.exe");
            this.driver = new ChromeDriver();
        }

        driver.get(baseUrl);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.waitFor = new WaitFor(driver);
        homeMainPage = new HomeMainPage(driver); // This is your starting point page
        locationAndRadiusSliderPage = new LocationAndRadiusSliderPage(driver);
        styleSliderPage = new StyleSliderPage(driver);
        moreOptionsSliderPage = new MoreOptionsSliderPage(driver);
        searchResultsLandingPage = new SearchResultsLandingPage(driver);
    }

    /**
     * Should verify link redirect
     * B-14241 - Navigate user to eCarOne offsite link
     *
     * @throws InterruptedException on error
     */
    @Test(priority = 4, groups = "B-14241", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldNavigateUserOffsite() throws InterruptedException {
        driver.get(listingUrl);
        vehicleDetailsPage.expandWarrantySection();
        waitFor.waitForExpectedConditions(driver, By.cssSelector(".visit.ui-link"));
        vehicleDetailsPage.clickWarrantyLink();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        Assert.assertTrue(driver.getCurrentUrl().contains(eCarOneUrl));
    }

    /**
     * Should verify link redirect
     * B-14242 - Navigate user to eCarOne offsite link
     */
    @Test(priority = 3, groups = "B-14242")
    public void shouldVerifyBITag() {
        driver.get(listingUrl);
        vehicleDetailsPage.expandWarrantySection();
        Assert.assertTrue(vehicleDetailsPage.getCPOBITag().equals("mdot_cert_lnk"));
    }

    /**
     * Should verify eCarOne link
     * B-14240 - Display "Reserve Now" Link on Warranty Accordion
     */
    @Test(priority = 2, groups = "B-14240", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldVerifyECarOnelink() {
        driver.get(listingUrl);
        vehicleDetailsPage.expandWarrantySection();
        waitFor.waitForExpectedConditions(driver, By.cssSelector(".visit.ui-link"));
        Assert.assertTrue(vehicleDetailsPage.getWarrantyTabLinkText().equals(eCarOneLinkText));
    }

    /**
     * Should verify eCarOne tile on Car Info
     * B-14237 - Display eCarOne tile under car info on mobile VDP
     */
    @Test(priority = 1, groups = "B-14237", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldVerifyECarOneTileOnCarInfo() {
        driver.get(listingUrl);
        waitFor.waitForExpectedConditions(driver, By.cssSelector(".atc-image.cpoTile"));
        Assert.assertTrue(vehicleDetailsPage.getURLForCPOTileOnCarInfo().equals(eCarOneTileImageUrl));
    }

    /**
     * Should display eCarOne Tile on Warranty Tab
     * B-14238 - Display eCarOne Tile on Warranty Tab
     */
    @Test(priority = 2, groups = "B-14238", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldVerifyMullinaxTileOnWarrantyAccordion() {
        driver.get(listingUrl);
        vehicleDetailsPage.expandWarrantySection();
        Assert.assertTrue(vehicleDetailsPage.getURLForCPOTileOnWarrantyAccordion().equals(eCarOneTileImageUrl));
    }

    /**
     * Search funnel test
     *
     * @throws InterruptedException on error
     */
    /**
     * This test case verifies that the items are searchable.
     *
     * @throws InterruptedException on error
     */
    @Test
    public void shouldVerifySearchResults() throws InterruptedException {
        locationAndRadiusSliderPage = homeMainPage.clickLocationAndRadius();
        locationAndRadiusSliderPage.setZip("30067");
        locationAndRadiusSliderPage.selectRadius(mDotElements.Radius.ANY_DISTANCE);
        locationAndRadiusSliderPage.setZip("30067");
        homeMainPage = locationAndRadiusSliderPage.clickOnDone();
        waitFor.waitForExpectedConditions(driver, By.cssSelector("img[alt='Autotrader.com']"));
        moreOptionsSliderPage = homeMainPage.clickMoreOptions();
        moreOptionsSliderPage.enterKeywords("Wiese");
        homeMainPage = moreOptionsSliderPage.clickOnApply();
        waitFor.waitForExpectedConditions(driver, By.cssSelector("img[alt='Autotrader.com']"));
        searchResultsLandingPage = homeMainPage.clickSearchForCars();
        waitFor.waitForExpectedConditions(driver,
            By.cssSelector(".atcui-container.atcui-.mdot-listing.listing-listView"));
        vehicleDetailsPage = searchResultsLandingPage.clickFirstListingAndGoToVDP();
    }

    /**
     * Should verify copy on warranty tab
     * B-14239 - Display eCarOne Warranty copy on Warranty Accordion on mobile VDP
     */
    @Test(priority = 2, groups = "B-14239", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldVerifyWarrantyTabCopy() {
        driver.get(listingUrl);
        vehicleDetailsPage.expandWarrantySection();
        waitFor.waitForExpectedConditions(driver, By.cssSelector(".visit.ui-link"));
        Assert.assertEquals(vehicleDetailsPage.getWarrantyText(), copy);
    }

    /**
     * This always runs true at the end of the test(s)
     */
    @AfterClass(alwaysRun = true)
    public void teardown() {
        this.driver.quit();
    }
    // </editor-f>
}
