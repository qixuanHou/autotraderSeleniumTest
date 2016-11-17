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
 * Created by sacown on 9/3/2015. Stories Tested:
 * B-06029 - Display Mullinax tile under car info on mobile VDP
 * B-12957 - Display Mullinax tile on Warranty Accordion on mobile VDP
 * B-12999 - Display "See Inventory" text link on Warranty Accordion on mobile VDP
 * B-12997 - Navigate User to Mullinax offsite on click
 * B-10546 - Display Mullinax Warranty copy on Warranty Accordion on mobile VDP
 */
public class MullinaxOffBrandTests {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    public String baseUrl;
    public WebDriver driver;
    public String listingUrl;
    DesiredCapabilities capability;
    String copy =
        "Why Choose us?\n"
            + "3 Great Reasons to Shop at Mullinax:\n"
            + "Up Front ® Price Our lowest price on every windshield.\n"
            + "Huge Selection Over 2,500 New and Used Cars and Trucks on Sale!\n"
            + "No Dealer Fees Mullinax Ford never had them and never will. We have a strong and committed sales staff with many years of experience satisfying our customers' needs. Feel free to browse our inventory online, request more information about vehicles, set up a test drive or inquire about financing!";

    HomeMainPage homeMainPage;
    LocationAndRadiusSliderPage locationAndRadiusSliderPage;
    MoreOptionsSliderPage moreOptionsSliderPage;
    String MullinaxLinkText = "See Inventory";
    String MullinaxTileImageUrl = "/certified/offbrand-tiles/243624.png";
    String MullinaxUrl = "http://www.mullinaxfordfl.com/used-inventory/index.htm";
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
     * B-12997 - Navigate User to Mullinax offsite on click
     *
     * @throws InterruptedException on error
     */
    @Test(priority = 4, groups = "B-12997", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldNavigateUserOffsite() throws InterruptedException {
        driver.get(listingUrl);
        vehicleDetailsPage.expandWarrantySection();
        waitFor.waitForExpectedConditions(driver, By.cssSelector(".visit.ui-link"));
        vehicleDetailsPage.clickWarrantyLink();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        Assert.assertEquals(driver.getCurrentUrl(), MullinaxUrl);
    }

    /**
     * Should verify Mullinax link
     * B-12999 - Display "See Inventory" text link on Warranty Accordion on mobile VDP
     */
    @Test(priority = 2, groups = "B-12999", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldVerifyMullinaxlink() {
        driver.get(listingUrl);
        vehicleDetailsPage.expandWarrantySection();
        waitFor.waitForExpectedConditions(driver, By.cssSelector(".visit.ui-link"));
        Assert.assertTrue(vehicleDetailsPage.getWarrantyTabLinkText().equals(MullinaxLinkText));
    }

    /**
     * Should verify Mullinax tile on Car Info
     * B-06029 - Display Mullinax tile under car info on mobile VDP
     */
    @Test(priority = 1, groups = "B-06029", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldVerifyMullinaxTileOnCarInfo() {
        driver.get(listingUrl);
        waitFor.waitForExpectedConditions(driver, By.cssSelector(".atc-image.cpoTile"));
        Assert.assertTrue(vehicleDetailsPage.getURLForCPOTileOnCarInfo().contains(MullinaxTileImageUrl));
    }

    /**
     * Should verify the Mullinax CPO tile on warranty accordion
     * B-12957 - Display Mullinax tile on Warranty Accordion on mobile VDP
     */
    @Test(priority = 2, groups = "B-12957", dependsOnMethods = "shouldVerifySearchResults")
    public void shouldVerifyMullinaxTileOnWarrantyAccordion() {
        driver.get(listingUrl);
        vehicleDetailsPage.expandWarrantySection();
        Assert.assertTrue(vehicleDetailsPage.getURLForCPOTileOnWarrantyAccordion().contains(MullinaxTileImageUrl));
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
        locationAndRadiusSliderPage.setZip("32703");
        locationAndRadiusSliderPage.selectRadius(mDotElements.Radius.ANY_DISTANCE);
        locationAndRadiusSliderPage.setZip("32703");
        homeMainPage = locationAndRadiusSliderPage.clickOnDone();
        waitFor.waitForExpectedConditions(driver, By.cssSelector("img[alt='Autotrader.com']"));
        moreOptionsSliderPage = homeMainPage.clickMoreOptions();
        moreOptionsSliderPage.enterKeywords("Mullinax Ford - Apopka");
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
     * Should verify copy on warranty tab
     * B-10546 - Display Mullinax Warranty copy on Warranty Accordion on mobile VDP
     */
    @Test(priority = 2, groups = "B-10546", dependsOnMethods = "shouldVerifySearchResults")
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
