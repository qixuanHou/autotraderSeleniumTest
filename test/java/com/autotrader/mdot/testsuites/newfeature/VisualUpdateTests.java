package com.autotrader.mdot.testsuites.newfeature;

import com.autotrader.mdot.pages.Dealers.DealerDetailPage;
import com.autotrader.mdot.pages.Dealers.DealerSearchResultsPage;
import com.autotrader.mdot.pages.misc.VehicleDetailsPage;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by jsmorris and sacown on 9/16/2015.
 *
 * B-13378 = "Visual updates on mDot"
 * B-13904 = "Add Dealer's Website Link (mDot)"
 */
public class VisualUpdateTests {

    public WebDriver driver;
    public String baseUrl;
    public String listingUrl;
    DealerDetailPage dealerDetailPage;
    VehicleDetailsPage vehicleDetailsPage;
    DealerSearchResultsPage dealerSearchResultsPage;
    String dealerDetailPageURLFragment = "find-your-dealer/dealerInfo.xhtml?ownerIds=71917";
    String dsrpUrlFragment = "find-your-dealer/dealerResults.xhtml?zip=30312&searchRadius=0";
    String vdpUrlFragment = "cars-for-sale/vehicledetails.xhtml?listingId=278493454&zip=30312&searchRadius=0";

    //<editor-fold desc="BeforeAfterClass">
    DesiredCapabilities capability;
    WaitFor waitFor;

    @BeforeClass(alwaysRun = true)
    @org.testng.annotations.Parameters(value={"browserName","browser_version","baseUrl","local","testGroup",
            "os","os_version","resolution","bsAccount","bsLocal","listingUrl"})
    public void setup(@Optional("browserName")String browserName,@Optional("version") String browser_version,
                      @Optional("baseUrl")String baseUrl,@Optional("local")String local,@Optional("testGroup")String testGroup,
                      @Optional("os")String os,@Optional("os_version")String os_version,@Optional("resolution")String resolution,
                      @Optional("bsAccount")String bsAccount, @Optional("bsLocal")String bsLocal, @Optional("listingUrl")String listingUrl) throws MalformedURLException {
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

            this.driver = new RemoteWebDriver(
                    new URL(bsAccount),
                    capability);
        } else{
            //this.baseUrl = baseUrl;
            this.baseUrl = "http://qmweb4904.autotrader.com:2200/";
            baseUrl = "http://qmweb4904.autotrader.com:2200/";
            this.listingUrl = listingUrl;
            System.setProperty("webdriver.chrome.driver", "target\\drivers\\chromedriver.exe");
            this.driver = new ChromeDriver();
        }

        driver.get(baseUrl);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.waitFor = new WaitFor(driver);
        dealerDetailPage = new DealerDetailPage(driver);
        vehicleDetailsPage = new VehicleDetailsPage(driver);
        dealerSearchResultsPage = new DealerSearchResultsPage(driver);
    }

    // This always runs true at the end of the test(s)
    @AfterClass(alwaysRun = true)
    public void teardown() {
        this.driver.quit();
    }
    //</editor-fold>

    /** DDP Tests*/
    @Test(priority = 0, groups = {"B-13378", "B-13904","DDPTests"})
    public void navigateToDDP() {
        driver.get(baseUrl + dealerDetailPageURLFragment);
        Assert.assertTrue(dealerDetailPage.isCurrentPage());

    }

    @Test(priority = 2,groups = {"B-13378", "B-13904","DDPTests"})
    public void labelChangesOnDDP() {
        navigateToDDP();
        Assert.assertTrue(dealerDetailPage.getAddressLine().contains("Directions to"));
        Assert.assertFalse(dealerDetailPage.getAddressLine().contains("miles"));
        Assert.assertTrue(dealerDetailPage.getPhoneNumberLine().contains("Call"));
        Assert.assertTrue(dealerDetailPage.getWebsiteLine().contains("Visit"));
        Assert.assertEquals(dealerDetailPage.getContactButtonText(), "Email Dealer");
    }

    @Test(priority = 2,groups = {"B-13378","DDPTests"})
    public void getDirectionsButtonShouldNotBeDisplayedOnDDP() {
        Assert.assertFalse(dealerDetailPage.foundGetDirectionButton());
    }

    @Test(priority = 2,groups = {"B-13378", "B-13904","DDPTests"})
    public void wholeRowShouldBeTappableOnDDP() {
        Assert.assertTrue(dealerDetailPage.isDirectionRowTappable());
        Assert.assertTrue(dealerDetailPage.isCallRowTappable());
        Assert.assertTrue(dealerDetailPage.isWebsiteRowTappable());
    }

    /** Email Dealer Page Tests*/

    @Test(priority = 4,groups = {"B-13378","DDPTests"})
    public void labelChangesOnEmailDealerPage() {
        dealerDetailPage.clickContactDealerButton();
        Assert.assertTrue(dealerDetailPage.isContactDealerPanelVisable());
        Assert.assertEquals(dealerDetailPage.getContactDealerPanelHeader(), "Email Dealer");
        Assert.assertEquals(dealerDetailPage.getMessagePlaceholderText(), "Message  (optional)");
    }

    /** VDP Tests*/
    @Test(priority = 5,groups = {"B-13378","VDPTests"})
    public void navigateToVDP(){
        driver.get(baseUrl + vdpUrlFragment);
        Assert.assertEquals(vehicleDetailsPage.getPageHeading(), "New 2014 Volvo XC90 2WD 3.2");
    }

    @Test(priority = 6,groups = {"B-13378", "B-13904","VDPTests"})
    public void verifyVDPLabelChange(){
        Assert.assertTrue(vehicleDetailsPage.getDirectionsLine().contains("Directions to"));
        Assert.assertTrue(vehicleDetailsPage.getPhoneNumberLine().contains("Call"));
        // Assert.assertTrue(vehicleDetailsPage.getMilesLine().contains(" miles from ")); (Element does not exist)
        Assert.assertTrue(vehicleDetailsPage.getWebsiteLine().contains("Visit"));
    }

    @Test(priority = 6,groups = {"B-13378", "B-13904","VDPTests"})
    public void areAllLabelRowsTappable(){
        Assert.assertTrue(vehicleDetailsPage.isDirectionLineTappable());
        Assert.assertTrue(vehicleDetailsPage.isPhoneLineTappable());
        Assert.assertTrue(vehicleDetailsPage.isWebsiteLineTappable());
    }

    @Test(priority = 6,groups = {"B-13378","VDPTests"})
    public void verifyEmailDealerButtonText(){
        Assert.assertEquals(vehicleDetailsPage.getEmailDealerButtonText(), "Email Dealer");
    }

    /** DSRP Tests*/

    @Test(priority = 7,groups = {"B-13378","DSRPTests"})
    public void navigateToDSRP(){
        driver.get(baseUrl + dsrpUrlFragment);
        Assert.assertEquals(driver.getTitle(), "Car Dealers in Atlanta, GA 30312 - Autotrader");
        Assert.assertTrue(dealerSearchResultsPage.checkOnCorrectPage());
    }

    @Test(priority = 8,groups = {"B-13378","DSRPTests"})
    public void verifyDSRPLabelChanges(){
        Assert.assertTrue(dealerSearchResultsPage.getDirectionLine().contains("Directions to"));
        Assert.assertTrue(dealerSearchResultsPage.getPhoneNumberLine().contains("Call"));
        Assert.assertTrue(dealerSearchResultsPage.getDirectionLine().contains(" mi"));
    }

    @Test(priority = 8,groups = {"B-13378","DSRPTests"})
    public void areDirectionAndCallRowsTappable(){
        Assert.assertTrue(dealerSearchResultsPage.isDirectionLineTappable());
        Assert.assertTrue(dealerSearchResultsPage.isPhoneLineTappable());
    }
}
