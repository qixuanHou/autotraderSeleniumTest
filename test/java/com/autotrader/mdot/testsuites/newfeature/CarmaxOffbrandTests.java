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
 * Created by sacown on 11/24/2015.
 */
public class CarmaxOffbrandTests {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    public String baseUrl;
    public WebDriver driver;
    public String listingUrl;
    DesiredCapabilities capability;
    String CarmaxLinkText = "Visit Carmax";
    String CarmaxTileImageUrl = "/certified/offbrand-tiles/245944.gif";
    String CarmaxUrl = "http://www.carmax.com/";
    String copy =
        "Why Choose us?\n"
            + "TOP QUALITY VEHICLES\n"
            + "Every used vehicle DriveTime sells comes with these unbeatable buyer protection benefits:\n"
            + "30-Day Limited Warranty\n"
            + "5-Day Return Guarantee\n"
            + "AutoCheck History Report\n"
            + "Certified Multi-Point Inspection";

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
     * Should verify link redirect B-17373 - Navigate User to Carmax offsite on click
     *
     * @throws InterruptedException on error
     */
    @Test(priority = 4, groups = "CarmaxTests", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldNavigateUserOffsite() throws InterruptedException {
        driver.get(listingUrl);
        vehicleDetailsPage.expandWarrantySection();
        waitFor.waitForExpectedConditions(driver, By.cssSelector(".visit.ui-link"));
        vehicleDetailsPage.clickWarrantyLink();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        Assert.assertEquals(driver.getCurrentUrl(), CarmaxUrl);
    }

    /**
     * Should verify Carmax link B-17372 - Display "Visit Carmax" text link on Warranty Accordion on mobile VDP
     */
    @Test(priority = 2, groups = "CarmaxTests", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldVerifyCarmaxLink() {
        driver.get(listingUrl);
        vehicleDetailsPage.expandWarrantySection();
        waitFor.waitForExpectedConditions(driver, By.cssSelector(".visit.ui-link"));
        Assert.assertTrue(vehicleDetailsPage.getWarrantyTabLinkText().equals(CarmaxLinkText));
    }

    /**
     * Should verify Carmax tile on Car Info B-17368 - Display Carmax tile under car info on mobile VDP
     */
    @Test(priority = 1, groups = "CarmaxTests", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldVerifyCarmaxTileOnCarInfo() {
        driver.get(listingUrl);
        waitFor.waitForExpectedConditions(driver, By.cssSelector(".atc-image.cpoTile"));
        Assert.assertTrue(vehicleDetailsPage.getURLForCPOTileOnCarInfo().contains(CarmaxTileImageUrl));
    }

    /**
     * Should verify the Carmax CPO tile on warranty accordion B-17370 - Display Carmax tile on Warranty Accordion on
     * mobile VDP
     */
    @Test(priority = 2, groups = "CarmaxTests", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldVerifyCarmaxTileOnWarrantyAccordion() {
        driver.get(listingUrl);
        vehicleDetailsPage.expandWarrantySection();
        Assert.assertTrue(vehicleDetailsPage.getURLForCPOTileOnWarrantyAccordion().contains(CarmaxTileImageUrl));
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
        locationAndRadiusSliderPage.setZip("78626");
        locationAndRadiusSliderPage.selectRadius(mDotElements.Radius.ANY_DISTANCE);
        locationAndRadiusSliderPage.setZip("78626");
        locationAndRadiusSliderPage.selectRadius(mDotElements.Radius.ANY_DISTANCE);
        homeMainPage = locationAndRadiusSliderPage.clickOnDone();
        waitFor.waitForExpectedConditions(driver, By.cssSelector("img[alt='Autotrader.com']"));
        moreOptionsSliderPage = homeMainPage.clickMoreOptions();
        moreOptionsSliderPage.enterKeywords("WP0AB2A93ES121690");
        homeMainPage = moreOptionsSliderPage.clickOnApply();
        waitFor.waitForExpectedConditions(driver, By.cssSelector("img[alt='Autotrader.com']"));
        searchResultsLandingPage = homeMainPage.clickSearchForCars();
        waitFor.waitForExpectedConditions(driver,
            By.cssSelector(".atcui-container.atcui-.mdot-listing.listing-listView"));
        vehicleDetailsPage = searchResultsLandingPage.clickFirstListingAndGoToVDP();
        waitFor.waitForExpectedConditions(driver, By.cssSelector(".carInfo"));
        listingUrl = driver.getCurrentUrl();
    }

    /**
     * Should verify copy on warranty tab B-17371 - Display Carmax Warranty copy on Warranty Accordion on mobile VDP
     */
    @Test(priority = 2, groups = "CarmaxTests", dependsOnMethods = "shouldVerifySearchResults")
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
