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
 * Created by mwstratton on 8/13/2015.
 */
public class SycPremierAdTests {

    public WebDriver driver;
    public String validateUrl;
    public String baseUrl;
    public String cardNumber = "378282246310005";
    public String masterCard = "5105105105105100";


    SycLandingPage sycLandingPage;
    SycSelectAdPackagePage sycSelectAdPackagePage;
    SycEnterZipPage sycEnterZipPage;
    SycRequiredInfoPage sycRequiredInfoPage;
    SycOptionalInfoPage sycOptionalInfoPage;
    SycCheckoutPage sycCheckoutPage;
    SycReviewAdPage sycReviewAdPage;
    SycAddPhotosPage sycAddPhotosPage;
    SycOrderConfirmationPage sycOrderConfirmationPage;
    DesiredCapabilities capability;
    EditYourAdPage editYourAdPage;
    HomeMainPage homeMainPage;
    AdRemovedPage adRemovedPage;
    RemoveYourAdPage removeYourAdPage;
    Actions action;
    SycManageYourAdPage sycManageYourAdPage;


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
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        sycOrderConfirmationPage = new SycOrderConfirmationPage(driver);
        editYourAdPage = new EditYourAdPage(driver);
        homeMainPage = new HomeMainPage(driver);
        adRemovedPage = new AdRemovedPage(driver);
        removeYourAdPage = new RemoveYourAdPage(driver);
        sycManageYourAdPage = new SycManageYourAdPage(driver);

    }

    /**
     * Preliminary Tests (Navigate To Premium Ad Selection)
     *
     */

    @Test
    public void shouldBeAbleToClickPlaceYourAd() throws InterruptedException{
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
    public void shouldBeAbleToClickDeluxeAdAndVerifyItsPage() throws InterruptedException{
        sycRequiredInfoPage = sycSelectAdPackagePage.clickSelectMOBDeluxeAd();
        Thread.sleep(4000);
        validateUrl = driver.getCurrentUrl();
    }
    /**
     * Required Info Page Tests
     *
     */

    @Test(dependsOnMethods = {"shouldBeAbleToClickDeluxeAdAndVerifyItsPage"})
    public void shouldSelectVehicleYear() throws InterruptedException{
        assertTrue(sycRequiredInfoPage.checkOnCorrectPage());
        sycRequiredInfoPage.selectYear("2010");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleYear"})
    public void shouldSelectVehicleMake() throws InterruptedException{
        sycRequiredInfoPage.selectMake("Honda");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleMake"})
    public void shouldSelectVehicleModel() throws InterruptedException{
        sycRequiredInfoPage.selectModel("Civic");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleModel"})
    public void shouldSelectVehicleBodyStyle() throws InterruptedException{
        sycRequiredInfoPage.selectBodyStyle("Sedan");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleBodyStyle"})
    public void shouldSelectVehicleMileage() throws InterruptedException{
        sycRequiredInfoPage.setMileageInputField("120000");
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
    public void shouldSelectYesMobileNumber() throws InterruptedException{
        sycRequiredInfoPage.checkMobileNumberBox();
    }

    @Test(dependsOnMethods = {"shouldSelectYesMobileNumber"})
    public void shouldSelectNoMobileContact() throws InterruptedException{
        sycRequiredInfoPage.checkMobileContactBox();
    }

    @Test(dependsOnMethods = {"shouldSelectNoMobileContact"})
    public void shouldSelectEmailAddress() throws InterruptedException{
        sycRequiredInfoPage.setEmailAddressInputField("testietester07@yahoo.com");
    }

    @Test(dependsOnMethods = {"shouldSelectEmailAddress"})
    public void shouldSelectSecurityQuestion() throws InterruptedException{
        sycRequiredInfoPage.setSecurityQuestionInputSelector("Mother's maiden name?");
    }

    @Test(dependsOnMethods = {"shouldSelectSecurityQuestion"})
    public void shouldSelectSecurityQuestionAnswer() throws InterruptedException{
        sycRequiredInfoPage.setAnswerInputField("auth");
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
    public void shouldSelectAnEngineType() throws InterruptedException{
        assertTrue(sycOptionalInfoPage.checkOnCorrectPage());
        sycOptionalInfoPage.selectEngine("4 Cylinder");
    }

    @Test(dependsOnMethods = {"shouldSelectAnEngineType"})
    public void shouldEnterAComment() throws InterruptedException{
        sycOptionalInfoPage.enterComments("pew pew a spaceship!");
    }

    @Test(dependsOnMethods = {"shouldEnterAComment"})
    public void shouldSelectNextAddPhotosButton() throws InterruptedException{
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
     *  Review Ad Page Tests
     *
     */

    @Test(dependsOnMethods = {"shouldSelectNextReviewAdButton"})
    public void shouldSelectNextCheckoutButton() throws InterruptedException{
        assertTrue(sycReviewAdPage.checkOnCorrectPage());
        sycReviewAdPage.waitForObject();
        sycCheckoutPage = sycReviewAdPage.clickNextCheckOutButton();
    }

    /**
     * Checkout Page Test
     *
     */

    @Test(dependsOnMethods = {"shouldSelectNextCheckoutButton"})
    public void shouldSelectACardType() throws InterruptedException{
        assertTrue(sycCheckoutPage.checkOnCorrectPage());
        sycCheckoutPage.waitForObject();
        sycCheckoutPage.selectCardType("MasterCard");
    }

    @Test(dependsOnMethods = {"shouldSelectACardType"})
    public void shouldEnterACardNumber() throws InterruptedException{
        sycCheckoutPage.setCardNumber(masterCard);
    }

    @Test(dependsOnMethods = {"shouldEnterACardNumber"})
    public void shouldEnterASecurityCode() throws InterruptedException{
        sycCheckoutPage.setSecurityCode("101");
    }

    @Test(dependsOnMethods = {"shouldEnterASecurityCode"})
    public void shouldSelectExpirationMonth() throws InterruptedException{
        sycCheckoutPage.selectExpirationMonth("May");
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
        takeABreakYo();
    }

    @Test(dependsOnMethods = {"shouldEnterLastName"})
    public void shouldEnterAddress() throws InterruptedException{
        sycCheckoutPage.setAddressLine("245 Fakead Lane");
    }

    @Test(dependsOnMethods = {"shouldEnterAddress"})
    public void shouldEnterCity() throws InterruptedException{
        sycCheckoutPage.setCity("Alpharetta");
        takeABreakYo();
    }

    @Test(dependsOnMethods = {"shouldEnterCity"})
    public void shouldSelectState() throws InterruptedException{
        sycCheckoutPage.selectState("GA");
        takeABreakYo();
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

    @AfterClass
    public void tearDown(){
        this.driver.quit();
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
