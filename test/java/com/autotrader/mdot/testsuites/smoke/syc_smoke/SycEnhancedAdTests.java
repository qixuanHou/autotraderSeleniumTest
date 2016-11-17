package com.autotrader.mdot.testsuites.smoke.syc_smoke;

import com.autotrader.mdot.pages.SYC.*;
import com.autotrader.mdot.pages.misc.AdRemovedPage;
import com.autotrader.mdot.pages.misc.EditYourAdPage;
import com.autotrader.mdot.pages.misc.HomeMainPage;
import com.autotrader.mdot.pages.misc.RemoveYourAdPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


/**
 * Created by mwstratton on 8/18/2015.
 */
public class SycEnhancedAdTests {

    public WebDriver driver;
    public String validateUrl;
    //public String baseUrl = "https://m-test1.autotrader.com/sell-your-car/index.xhtml";
    public String cardNumber = "378282246310005";
    public String baseUrl;

    SycLandingPage sycLandingPage;
    SycSelectAdPackagePage sycSelectAdPackagePage;
    SycEnterZipPage sycEnterZipPage;
    SycRequiredInfoPage sycRequiredInfoPage;
    SycOptionalInfoPage sycOptionalInfoPage;
    SycCheckoutPage sycCheckoutPage;
    SycReviewAdPage sycReviewAdPage;
    SycAddPhotosPage sycAddPhotosPage;
    SycEnhanceYourAdPage sycEnhanceYourAdPage;
    SycOrderConfirmationPage sycOrderConfirmationPage;
    DesiredCapabilities capability;
    EditYourAdPage editYourAdPage;
    RemoveYourAdPage removeYourAdPage;
    AdRemovedPage adRemovedPage;
    HomeMainPage homeMainPage;
    SycManageYourAdPage sycManageYourAdPage;

    Actions action;

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
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.baseUrl = baseUrl;
        sycLandingPage = new SycLandingPage(driver);
        action = new Actions(driver);

        sycLandingPage = new SycLandingPage(driver);
        sycSelectAdPackagePage = new SycSelectAdPackagePage(driver);
        sycEnterZipPage = new SycEnterZipPage(driver);
        sycRequiredInfoPage = new SycRequiredInfoPage(driver);
        sycOptionalInfoPage = new SycOptionalInfoPage(driver);
        sycCheckoutPage = new SycCheckoutPage(driver);
        sycReviewAdPage = new SycReviewAdPage(driver);
        sycAddPhotosPage = new SycAddPhotosPage(driver);
        sycEnhanceYourAdPage = new SycEnhanceYourAdPage(driver);
        sycOrderConfirmationPage = new SycOrderConfirmationPage(driver);
        editYourAdPage = new EditYourAdPage(driver);
        removeYourAdPage = new RemoveYourAdPage(driver);
        adRemovedPage = new AdRemovedPage(driver);
        homeMainPage = new HomeMainPage(driver);
        sycManageYourAdPage = new SycManageYourAdPage(driver);
    }

    /**
     * Preliminary Tests (Navigate to Enhanced Ad Selection)
     *
     */

    @AfterClass
    public void tearDown(){
        this.driver.quit();
    }

    @Test
    public void shouldBeAbleToClickPlaceYourAd(){
        driver.get(baseUrl);
        assertTrue(sycLandingPage.checkOnCorrectPage());
        sycLandingPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickPlaceYourAd"})
    public void shouldBeAbleToEnterAZipCode(){
        sycEnterZipPage = sycLandingPage.clickPlaceYourAd();
        assertTrue(sycEnterZipPage.checkOnCorrectPage());
        sycEnterZipPage.waitForObject();
        sycEnterZipPage.enterZipCode();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEnterAZipCode"})
    public void shouldBeAbleToNavigateToAdPackagePage(){
        sycSelectAdPackagePage = sycEnterZipPage.clickSubmitZipButton();
        assertTrue(sycSelectAdPackagePage.checkOnCorrectPage());
        sycSelectAdPackagePage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToNavigateToAdPackagePage"})
    public void shouldBeAbleToClickEnhancedAdAndVerifyItsPage() throws InterruptedException{
        sycRequiredInfoPage = sycSelectAdPackagePage.clickSelectMOBEnhancedAd();
        Thread.sleep(2000);
        validateUrl = driver.getCurrentUrl();

    }

    /**
     * Required Info Page Tests
     *
     */

    @Test(dependsOnMethods = {"shouldBeAbleToClickEnhancedAdAndVerifyItsPage"})
    public void shouldSelectVehicleYear() throws InterruptedException{
        assertTrue(sycRequiredInfoPage.checkOnCorrectPage());
        sycRequiredInfoPage.selectYear("2012");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleYear"})
    public void shouldSelectVehicleMake() throws InterruptedException{
        sycRequiredInfoPage.selectMake("Ford");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleMake"})
    public void shouldSelectVehicleModel() throws InterruptedException{
        sycRequiredInfoPage.selectModel("Mustang");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleModel"})
    public void shouldSelectVehicleBodyStyle() throws InterruptedException{
        sycRequiredInfoPage.selectBodyStyle("Convertible");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleBodyStyle"})
    public void shouldSelectVehicleMileage() throws InterruptedException{
        sycRequiredInfoPage.setMileageInputField("20000");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleMileage"})
    public void shouldSelectVehiclePrice() throws InterruptedException{
        sycRequiredInfoPage.setPriceInputField("15000");
    }

    @Test(dependsOnMethods = {"shouldSelectVehiclePrice"})
    public void shouldSelectPhoneNumber() throws InterruptedException{
        sycRequiredInfoPage.setPhoneInputField("7709983435");
    }

    @Test(dependsOnMethods = {"shouldSelectPhoneNumber"})
    public void shouldSelectNoMobileNumber() throws InterruptedException{
        sycRequiredInfoPage.checkNoMobileContactBox();
    }

    @Test(dependsOnMethods = {"shouldSelectNoMobileNumber"})
    public void shouldSelectEmailAddress() throws InterruptedException{
        sycRequiredInfoPage.setEmailAddressInputField("testietester07@yahoo.com");
    }

    @Test(dependsOnMethods = {"shouldSelectEmailAddress"})
    public void shouldSelectSecurityQuestion() throws InterruptedException{
        sycRequiredInfoPage.setSecurityQuestionInputSelector("Where you met your spouse?");
    }

    @Test(dependsOnMethods = {"shouldSelectSecurityQuestion"})
    public void shouldSelectSecurityQuestionAnswer() throws InterruptedException{
        sycRequiredInfoPage.setAnswerInputField("Ohio");
    }

    @Test(dependsOnMethods = {"shouldSelectSecurityQuestionAnswer"})
    public void shouldSelectNextOptionalInfo() throws InterruptedException{
        sycOptionalInfoPage = sycRequiredInfoPage.clickNextOptionalInfoButton();
    }


    /**
     * Optional Info Page Tests
     *
     */

    @Test(dependsOnMethods = {"shouldSelectNextOptionalInfo"})
    public void shouldSelectATransmissionType() throws InterruptedException{
        assertTrue(sycOptionalInfoPage.checkOnCorrectPage());
        sycOptionalInfoPage.waitForObject();
        sycOptionalInfoPage.selectTransmission("Manual");
    }

    @Test(dependsOnMethods = {"shouldSelectATransmissionType"})
    public void shouldSelectADriveType(){
        sycOptionalInfoPage.selectDriveType("Front Wheel Drive");
    }

    @Test(dependsOnMethods = {"shouldSelectADriveType"})
    public void shouldSelectAmountOfDoors() throws InterruptedException{
        sycOptionalInfoPage.selectDoors("Four Door");
    }

    @Test(dependsOnMethods = {"shouldSelectAmountOfDoors"})
    public void shouldSelectExtColor() throws InterruptedException{
        sycOptionalInfoPage.selectExtColor("GRAY");
    }

    @Test(dependsOnMethods = {"shouldSelectExtColor"})
    public void shouldSelectIntColor() throws InterruptedException{
        sycOptionalInfoPage.selectIntColor("BLACK");
    }

    @Test(dependsOnMethods = {"shouldSelectIntColor"})
    public void shouldEnterAComment() throws InterruptedException {
        sycOptionalInfoPage.enterComments("<(*-<)  <(*-*)>  (>-*)>   woot!");
    }

    @Test(dependsOnMethods = {"shouldEnterAComment"})
    public void shouldSelectNextAddPhotosButton() throws InterruptedException {
        sycAddPhotosPage = sycOptionalInfoPage.clickOnNextButton();
        takeABreakYo();
    }

    /**
     * Add Photos Page Tests
     *
     */

    @Test(dependsOnMethods = {"shouldSelectNextAddPhotosButton"})
    public void shouldSelectNextReviewAdButton() throws InterruptedException{
        assertTrue(sycAddPhotosPage.checkOnCorrectPage());
        sycAddPhotosPage.waitForObject();
        sycReviewAdPage = sycAddPhotosPage.clickNextReviewAdButton();
    }

    /**
     * Review Ad Page Tests
     *
     */

    @Test(dependsOnMethods = {"shouldSelectNextReviewAdButton"})
    public void shouldSelectNextEnhanceYourAdButton() throws InterruptedException{
        assertTrue(sycReviewAdPage.checkOnCorrectPage());
        sycReviewAdPage.waitForObject();
        sycEnhanceYourAdPage = sycReviewAdPage.clickNextEnhanceAdButton();
    }

    /**
     * Enhance Your Ad Page
     *
     */

    @Test(dependsOnMethods = {"shouldSelectNextEnhanceYourAdButton"})
    public void shouldSelectPremiumListingEnhancement() throws InterruptedException {
        assertTrue(sycEnhanceYourAdPage.checkOnCorrectPage());
        sycEnhanceYourAdPage.waitForObject();
        sycEnhanceYourAdPage.checkPremiumEhn();
    }

    @Test(dependsOnMethods = {"shouldSelectPremiumListingEnhancement"})
    public void shouldSelectKbbOnlineAdEnhancement() throws InterruptedException{
        sycEnhanceYourAdPage.checkKbbEhn();
    }

    @Test(dependsOnMethods = {"shouldSelectKbbOnlineAdEnhancement"})
    public void shouldSelectNextCheckoutButton() throws InterruptedException{
        sycCheckoutPage = sycEnhanceYourAdPage.clickNextCheckout();
    }

    /**
     * Checkout Page Tests
     *
     */

    @Test(dependsOnMethods = {"shouldSelectNextCheckoutButton"})
    public void shouldSelectACardType() throws InterruptedException{
        assertTrue(sycCheckoutPage.checkOnCorrectPage());
        sycCheckoutPage.waitForObject();
        sycCheckoutPage.selectCardType("American Express");
    }

    @Test(dependsOnMethods = {"shouldSelectACardType"})
    public void shouldEnterACardNumber() throws InterruptedException{
        sycCheckoutPage.setCardNumber(cardNumber);
    }

    @Test(dependsOnMethods = {"shouldEnterACardNumber"})
    public void shouldEnterASecurityCode() throws InterruptedException{
        sycCheckoutPage.setSecurityCode("1212");
    }

    @Test(dependsOnMethods = {"shouldEnterASecurityCode"})
    public void shouldSelectExpirationMonth() throws InterruptedException{
        sycCheckoutPage.selectExpirationMonth("January");
    }

    @Test(dependsOnMethods = {"shouldSelectExpirationMonth"})
    public void shouldSelectExpirationYear() throws InterruptedException{
        sycCheckoutPage.selectExpirationYear("2016");
    }

    @Test(dependsOnMethods = {"shouldSelectExpirationYear"})
    public void shouldEnterFirstName() throws InterruptedException{
        sycCheckoutPage.setFirstName("Matthias");
    }

    @Test(dependsOnMethods = {"shouldEnterFirstName"})
    public void shouldEnterLastName() throws InterruptedException{
        sycCheckoutPage.setLastName("Griffon");
    }

    @Test(dependsOnMethods = {"shouldEnterLastName"})
    public void shouldEnterAddress() throws InterruptedException{
        sycCheckoutPage.setAddressLine("245 Fakead Lane");
    }

    @Test(dependsOnMethods = {"shouldEnterAddress"})
    public void shouldEnterCity() throws InterruptedException{
        sycCheckoutPage.setCity("Alpharetta");
    }

    @Test(dependsOnMethods = {"shouldEnterCity"})
    public void shouldSelectState() throws InterruptedException{
        sycCheckoutPage.selectState("GA");
    }

    @Test(dependsOnMethods = {"shouldSelectState"})
    public void shouldEnterZipCode() throws InterruptedException{
        sycCheckoutPage.setZipCode("30004");
    }

    @Test(dependsOnMethods = {"shouldEnterZipCode"})
    public void shouldClickOnSubmitButton() throws InterruptedException{
        sycOrderConfirmationPage = sycCheckoutPage.clickSubmitButton();
        assertTrue(sycOrderConfirmationPage.checkOnCorrectPage());
        sycOrderConfirmationPage.waitForObject();
    }

    /**
     *Edit your ad tests
     */

    @Test(dependsOnMethods = {"shouldClickOnSubmitButton"})
    public void shouldBeAbleToEditYourAd() throws InterruptedException{
        sycManageYourAdPage = sycOrderConfirmationPage.clickOnEditYourAd();
        assertTrue(editYourAdPage.checkOnCorrectPage());
        editYourAdPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEditYourAd"})
    public void shouldBeAbleToDeleteYourAd() throws InterruptedException{
        removeYourAdPage = editYourAdPage.cancelAd();
        Thread.sleep(2000);
        adRemovedPage = removeYourAdPage.clickRemoveAdListing();
        Thread.sleep(2000);
        homeMainPage = adRemovedPage.clickHomeButton();
        Thread.sleep(2000);
    }


    //<editor-fold desc="Take A Break  &  Take A Nap">
        public void takeABreakYo(){
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }

        public void takeANapYo(){
            try
            {
                Thread.sleep(10000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        //</editor-fold>



}
