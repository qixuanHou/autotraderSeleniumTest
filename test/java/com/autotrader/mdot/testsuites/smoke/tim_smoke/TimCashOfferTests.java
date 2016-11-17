package com.autotrader.mdot.testsuites.smoke.tim_smoke;

import com.autotrader.mdot.pages.TIM.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

/**
 * Created by jmcox1 on 7/9/2015.
 */

public class TimCashOfferTests {

    public WebDriver driver;
    public WebDriverWait wait;
    public String baseUrl;
    DesiredCapabilities capability;
    TimLandingPage timLandingPage;
    TimOptionsPage timOptionsPage;
    TimVehicleHistoryPage timVehicleHistoryPage;
    TimVehicleConditionPage timVehicleConditionPage;
    TimContactInfoPage timContactInfoPage;
    TimReviewOfferPage timReviewOfferPage;
    TimOfferPage timOfferPage;
//<editor-fold desc="Setup Information For All Tests">
    /**
     * Starts up webdriver, sets waits, and sets the params for test.
     *
     */
    @BeforeClass
    @org.testng.annotations.Parameters(value={"browserName","browser_version","platform","device","baseUrl","local","os","os_version","resolution","bsAccount"})
    public void setUp(@Optional("browserName")String browserName,@Optional("version") String browser_version,@Optional("platform") String platform,@Optional("device") String device,@Optional("baseUrl")String baseUrl,@Optional("local")String local,@Optional("os")String os,@Optional("os_version")String os_version,@Optional("resolution")String resolution,@Optional("bsAccount")String bsAccount) throws Exception {
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

        }
        this.wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.baseUrl = baseUrl;

        timLandingPage = new TimLandingPage(driver);
        timOptionsPage = new TimOptionsPage(driver);
        timVehicleHistoryPage = new TimVehicleHistoryPage(driver);
        timVehicleConditionPage = new TimVehicleConditionPage(driver);
        timContactInfoPage = new TimContactInfoPage(driver);
        timReviewOfferPage = new TimReviewOfferPage(driver);
        timOfferPage = new TimOfferPage(driver);

    }

    /**
     * Closes Web Driver After Tests
     * Takes screenshot on pass or fail.
     *
     */
    @AfterClass
    public void tearDown() throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd hh mm a");
        Date date = new Date();
        FileUtils.copyFile(screenshot, new File("c:\\tmp\\" + capability.getBrowserName() +" "+ dateFormat.format(date) + ".png"));
        driver.quit();
    }

    //</editor-fold>

    /**
     * Landing Page Tests
     *
     */
    @Test()
    public void shouldNavigateToLandingPage() throws InterruptedException {
        Thread.sleep(4000);
        timLandingPage.navigateToUrl(baseUrl + "index.xhtml?LNX=TIMATCMOBSITNAV");
        Thread.sleep(4000);
        assertTrue(timLandingPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldNavigateToLandingPage"})
    public void shouldSelectVehicleYear() throws InterruptedException {
        timLandingPage.selectYear("2003");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleYear"})
    public void shouldSelectVehicleMake() throws InterruptedException {
        timLandingPage.selectMake("Acura");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleMake"})
    public void shouldSelectVehicleModel() throws InterruptedException {

        timLandingPage.selectModel("MDX");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleModel"})
    public void shouldSelectVehicleStyle() throws InterruptedException {
        timLandingPage.selectStyle("4dr SUV 4WD Touring Package");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleStyle"})
    public void shouldSelectVehicleExtColor() throws InterruptedException {
        timLandingPage.selectExtColor("Sandstone");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleExtColor"})
    public void shouldSelectVehicleIntColor() throws InterruptedException {
        timLandingPage.selectIntColor("Saddle");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleIntColor"})
    public void shouldSelectVehicleMileage() throws InterruptedException {
        timLandingPage.setMileage("50000");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleMileage"})
    public void shouldSelectVehicleZip() throws InterruptedException {
        timLandingPage.setZip("30680");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleZip"})
    public void shouldSubmitLandingPage() throws InterruptedException {
        timLandingPage.clickNextButton();
    }

    /**
     * Options Page Tests
     *
     */
    @Test(dependsOnMethods = {"shouldSubmitLandingPage"})
    public void shouldCheckOnVehicleOptionsPage() throws InterruptedException {
        Thread.sleep(5000);
        assertTrue(timOptionsPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldCheckOnVehicleOptionsPage"})
    public void shouldClickNoAftermarketEquipButton() throws InterruptedException {
        assertTrue(timOptionsPage.clickNoAftermarketEquipment());
    }

    @Test(dependsOnMethods = {"shouldClickNoAftermarketEquipButton"})
    public void shouldClickNextButton() throws InterruptedException {
        timOptionsPage.clickNextButton();
    }

    /**
     * History Page Tests
     *
     */
    @Test(dependsOnMethods = {"shouldClickNextButton"})
    public void shouldCheckOnVehicleHistoryPage() throws InterruptedException {
        Thread.sleep(4000);
        assertTrue(timVehicleHistoryPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldCheckOnVehicleHistoryPage"})
    public void shouldClickYesOriginalOwner() throws InterruptedException {
        assertTrue(timVehicleHistoryPage.clickYesOriginalOwner());
    }

    @Test(dependsOnMethods = {"shouldClickYesOriginalOwner"})
    public void shouldClickYesClearTitle() throws InterruptedException {
        assertTrue(timVehicleHistoryPage.clickYesClearTitle());
    }

    @Test(dependsOnMethods = {"shouldClickYesClearTitle"})
    public void shouldClickYesCleanHistory() throws InterruptedException {
        assertTrue(timVehicleHistoryPage.clickYesCleanHistoryReport());
    }

    @Test(dependsOnMethods = {"shouldClickYesCleanHistory"})
    public void shouldClickNoInsuranceClaims() throws InterruptedException {
        assertTrue(timVehicleHistoryPage.clickNoInsuranceClaims());
    }

    @Test(dependsOnMethods = {"shouldClickNoInsuranceClaims"})
    public void shouldClickNoSmokeInVehicle() throws InterruptedException {
        assertTrue(timVehicleHistoryPage.clickNoSmokingInVehicle());
    }

    @Test(dependsOnMethods = {"shouldClickNoSmokeInVehicle"})
    public void shouldClickYesServiceRecordsAvailable() throws InterruptedException {
        assertTrue(timVehicleHistoryPage.clickYesCompleteServiceRecords());
    }

    @Test(dependsOnMethods = {"shouldClickYesServiceRecordsAvailable"})
    public void shouldClickYesTwoKeysAvailable() throws InterruptedException {
        assertTrue(timVehicleHistoryPage.clickYesTwoSetsOfKeys());
    }

    @Test(dependsOnMethods = {"shouldClickYesTwoKeysAvailable"})
    public void shouldClickNoAutoAuction() throws InterruptedException {
        assertTrue(timVehicleHistoryPage.clickNoAutoAuction());
    }

    @Test(dependsOnMethods = {"shouldClickNoAutoAuction"})
    public void shouldClickNoRentalCar() throws InterruptedException {
        assertTrue(timVehicleHistoryPage.clickNoRentalCar());
    }

    @Test(dependsOnMethods = {"shouldClickNoRentalCar"})
    public void shouldClickNextButtonOnHistoryPage() throws InterruptedException {
        timVehicleHistoryPage.clickNextButton();
    }

    /**
     * Condition Page Tests
     *
     */
    @Test(dependsOnMethods = {"shouldClickNextButtonOnHistoryPage"})
    public void shouldCheckOnVehicleConditionPage() throws InterruptedException {
        Thread.sleep(4000);
        assertTrue(timVehicleConditionPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldCheckOnVehicleConditionPage"})
    public void shouldClickNoWearAndTear() throws InterruptedException {
        assertTrue(timVehicleConditionPage.clickNoWearAndTear());
    }

    @Test(dependsOnMethods = {"shouldClickNoWearAndTear"})
    public void shouldClickNoMechanicalIssues() throws InterruptedException {
        assertTrue(timVehicleConditionPage.clickNoMechanicalIssues());
    }

    @Test(dependsOnMethods = {"shouldClickNoMechanicalIssues"})
    public void shouldClickNoSeriousConditions() throws InterruptedException {
        assertTrue(timVehicleConditionPage.clickNoSeriousAccidentDamage());
    }

    @Test(dependsOnMethods = {"shouldClickNoSeriousConditions"})
    public void shouldClickNextButtonOnVehicleConditionPage() throws InterruptedException {
        timVehicleConditionPage.clickNextButton();
    }

    /**
     *
     * Contact Page Tests
     *
     */
    @Test(dependsOnMethods = {"shouldClickNextButtonOnVehicleConditionPage"})
    public void shouldCheckOnMobileContactPage() throws InterruptedException {
        Thread.sleep(4000);
        assertTrue(timContactInfoPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldCheckOnMobileContactPage"})
    public void shouldFillOutFirstNameField() throws InterruptedException {
        timContactInfoPage.setFirstNameInputField("Joseph");
    }

    @Test(dependsOnMethods = {"shouldFillOutFirstNameField"})
    public void shouldFillOutLastNameField() throws InterruptedException {
        timContactInfoPage.setLastNameInputField("Cox");
    }

    @Test(dependsOnMethods = {"shouldFillOutLastNameField"})
    public void shouldFillOutEmailAddressField() throws InterruptedException {
        timContactInfoPage.setEmailInputField("joe.cox@autotrader.com");
    }

    @Test(dependsOnMethods = {"shouldFillOutEmailAddressField"})
    public void shouldFillOutEmailAddressVerifyField() throws InterruptedException {
        timContactInfoPage.setEmailVerifyInputField("joe.cox@autotrader.com");
    }

    @Test(dependsOnMethods = {"shouldFillOutEmailAddressVerifyField"})
    public void shouldFillOutPhoneNumberField() throws InterruptedException {
        timContactInfoPage.setPhoneInputField("6787904520");
    }

    @Test(dependsOnMethods = {"shouldFillOutPhoneNumberField"})
    public void shouldClickAcceptVisitorAgreement() throws InterruptedException {
        timContactInfoPage.clickVisitAgreementCheckBox();
    }

    @Test(dependsOnMethods = {"shouldClickAcceptVisitorAgreement"})
    public void shouldClickNextButtonOnContactInfoPage() throws InterruptedException {
        timContactInfoPage.clickNextButton();
        Thread.sleep(10000);
    }

    /**
     * Review Offer Page Tests
     *
     */
    @Test(dependsOnMethods = {"shouldClickNextButtonOnContactInfoPage"})
    public void shouldCheckOnReviewOfferPage() throws InterruptedException {
        Thread.sleep(4000);
        assertTrue(timReviewOfferPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldCheckOnReviewOfferPage"})
    public void shouldClickSubmitButton() throws InterruptedException {
        timReviewOfferPage.clickSubmitButton();
        Thread.sleep(10000);
    }

    @Test(dependsOnMethods = {"shouldClickSubmitButton"})
    public void shouldValidateOnOfferPage() throws InterruptedException {
        Thread.sleep(4000);
        assertTrue(timOfferPage.checkOnOfferPage());
    }


}


