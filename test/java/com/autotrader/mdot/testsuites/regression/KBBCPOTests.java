package com.autotrader.mdot.testsuites.regression;

import com.autotrader.mdot.pages.FYC.*;

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
 * Created by sacown on 9/3/2015. Stories Tested: B-12925 - Display KBB CPO tile under Car Info on mobile VDP B-12931 -
 * Display "Visit Kelley Blue Book" text link on Warranty Accordion on mobile VDP B-05906 - Display KBB CPO tile on
 * Warranty Accordion on mobile VDP B-12923 - Navigate User to KBB offsite on click B-12928 - Display KBB CPO Warranty
 * copy on Warranty Accordion on mobile VDP
 */

public class KBBCPOTests {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    public String baseUrl;

    public WebDriver driver;
    public String listingUrl;
    DesiredCapabilities capability;
    String copy =
        "Why Choose us?\n"
            + "The Kelley Blue Book Certified Pre-Owned Program is a non-manufacturer certified pre-owned program being offered by Kelley Blue Book and its affiliates. Kelley Blue Book has established the standards that a vehicle must meet to be offered by participating dealers as a Kelley Blue Book Certified Pre-Owned Vehicle. You can find more information about the Program standards and the inspection process at www.KBBCPO.com.\n"
            + "Vehicles that meet the standards of Kelley Blue Book Certified Pre-Owned Vehicle Program are offered with a powertrain limited warranty that covers the vehicle until it has 100,000 miles or is 6 years old from the Original In- Service Date*, whichever comes first. The warranty includes roadside assistance, towing benefit, trip interruption benefit, and rental car reimbursement. The warranty is underwritten by a third party underwriter and administered by Safe-Guard Products International, LLC. In order to meet the standards for the Kelley Blue Book Certified Pre-Owned Vehicle Program, the qualifying vehicles require the following:\n"
            + "Qualifying vehicles must be current-model or one of the five previous model years and have less than 75,000 odometer miles.\n"
            + "Kelley Blue Book Certified Pre-Owned Vehicles require a 150+ point quality inspection by the participating dealer signed off by a technician certified by the National Institute for Automotive Service Excellence (ASE)\n"
            + "Each Kelley Blue Book Certified Pre-Owned Vehicle includes a vehicle history report\n"
            + "Participating dealers must confirm and certify that the vehicle meets the above requirements before it can be classified as a Kelley Blue Book Certified Pre-Owned Vehicle. The participating dealers are responsible for the inspection and self-certification that the vehicles meet the established standards.\n"
            + "\n"
            + "* \"Original In-Service Date\" means the date the Manufacturer's Warranty for the vehicle began (as determined by the manufacturer's records) or the original record of sale/original DMV registration date (as noted on the vehicle history report e.g.: AutoCheck or Carfax).\n"
            + "\n"
            + "The participating dealer is responsible for inspecting and reconditioning the vehicle and confirming and certifying to Kelley Blue Book that the vehicle meets the program requirements.\n"
            + "\n"
            + "Dealers participating in the Kelley Blue Book Certified Pre-Owned Program must provide reports and other information to Kelley Blue Book and its service providers to verify certain eligibility requirements. Dealer is required to pay a subscription fee for the inspection software and a transaction fee for the warranty and to advertise vehicle as Kelley Blue Book Certified Pre-Owned Vehicle.\n"
            + "\n"
            + "DISCLAIMERS\n"
            + "\n"
            + "Kelley Blue Book does not inspect, qualify or endorse any individual vehicles being offered or sold through the Kelley Blue Book Certified Pre-Owned Vehicle Program. Instead, each participating dealer is responsible for the inspection and self-certification of the vehicles they offer and sell with the Kelley Blue Book Certified Pre-Owned badge. UNLESS OTHERWISE PROVIDED BY THE PARTICIPATING DEALER OR THE VEHICLE'S MANUFACTURER, THE POWERTRAIN LIMITED WARRANTY DESCRIBED ABOVE IS THE ONLY WARRANTY PROVIDED WITH THE KELLEY BLUE BOOK CERTIFIED PRE-OWNED VEHICLE. NEITHER KELLEY BLUE BOOK NOR ITS AFFILIATES MAKES ANY OTHER REPRESENTATION OR WARRANT - EITHER EXPRESSLY OR IMPLIEDLY - ON ANY VEHICLES OFFERED OR SOLD BY ANY PARTICIPATING DEALER.";

    HomeMainPage homeMainPage;
    String KBBLinkText = "Visit Kelley Blue Book Certified";
    String KBBTileImageUrl = "/certified/offbrand-tiles/238659.png";
    String KBBurl = "http://www.kbbcpo.com/";
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
     * B-12923 - Navigate User to KBB offsite on click
     *
     * @throws InterruptedException on error
     */
    @Test(priority = 4, groups = "B-12923", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldNavigateUserOffsite() throws InterruptedException {
        driver.get(listingUrl);
        vehicleDetailsPage.expandWarrantySection();
        waitFor.waitForExpectedConditions(driver, By.cssSelector(".visit.ui-link"));
        vehicleDetailsPage.clickWarrantyLink();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        Assert.assertEquals(driver.getCurrentUrl(), KBBurl);
    }

    /**
     * Should verify KBB link
     * B-12931 - Display "Visit Kelley Blue Book" text link on Warranty Accordion on mobile VDP
     */
    @Test(priority = 2, groups = "B-12931", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldVerifyKBBlink() {
        driver.get(listingUrl);
        vehicleDetailsPage.expandWarrantySection();
        waitFor.waitForExpectedConditions(driver, By.cssSelector(".atc-image.cpoTile"));
        Assert.assertTrue(vehicleDetailsPage.getWarrantyTabLinkText().equals(KBBLinkText));
    }

    /**
     * Should verify KBB tile on Car Info
     * B-12925 - Display KBB CPO tile under Car Info on mobile VDP
     */
    @Test(priority = 1, groups = "B-12925", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldVerifyKBBTileOnCarInfo() {
        driver.get(listingUrl);
        Assert.assertTrue(vehicleDetailsPage.getURLForCPOTileOnCarInfo().contains(KBBTileImageUrl));
    }

    /**
     * Should verify the KBB CPO tile on warranty accordion
     * B-05906 - Display KBB CPO tile on Warranty Accordion on mobile VDP
     */
    @Test(priority = 2, groups = "B-05906", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldVerifyKBBTileOnWarrantyAccordion() {
        driver.get(listingUrl);
        vehicleDetailsPage.expandWarrantySection();
        Assert.assertTrue(vehicleDetailsPage.getURLForCPOTileOnWarrantyAccordion().contains(KBBTileImageUrl));
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
        locationAndRadiusSliderPage.setZip("85232");
        locationAndRadiusSliderPage.selectRadius(mDotElements.Radius.FIVE_HUNDRED_MILES);
        locationAndRadiusSliderPage.setZip("85232");
        homeMainPage = locationAndRadiusSliderPage.clickOnDone();
        waitFor.waitForExpectedConditions(driver, By.cssSelector("img[alt='Autotrader.com']"));
        moreOptionsSliderPage = homeMainPage.clickMoreOptions();
        moreOptionsSliderPage.enterKeywords("Mark Mitsubishi Scottsdale");
        homeMainPage = moreOptionsSliderPage.clickOnApply();
        waitFor.waitForExpectedConditions(driver, By.cssSelector("img[alt='Autotrader.com']"));
        searchResultsLandingPage = homeMainPage.clickSearchForCars();
        vehicleDetailsPage = searchResultsLandingPage.clickFirstListingAndGoToVDP();
        waitFor.waitForExpectedConditions(driver, By.cssSelector(".carInfo"));
        listingUrl = driver.getCurrentUrl();
    }

    /**
     * Should verify copy on warranty tab
     * B-12928 - Display KBB CPO Warranty copy on Warranty Accordion on mobile VDP
     */
    @Test(priority = 2, groups = "B-12928", dependsOnMethods = "shouldVerifySearchResults")
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
