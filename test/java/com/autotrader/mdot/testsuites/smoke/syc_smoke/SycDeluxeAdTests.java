package com.autotrader.mdot.testsuites.smoke.syc_smoke;

import com.autotrader.mdot.pages.SYC.*;
import com.autotrader.mdot.pages.misc.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.awt.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

/**
 * Created by mwstratton on 8/21/2015.
 */
public class SycDeluxeAdTests {

    public WebDriver driver;
    public WebDriverWait wait;
    public String validateUrl;
    public String baseUrl;
    public String cardNumber = "378282246310005";
    //public String homeUrl = "https://m-test1.autotrader.com";

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
    HomeMainPage homeMainPage;
    SignInPage signInPage;
    HomeSidePage homeSidePage;
    EditYourAdPage editYourAdPage;
    RemoveYourAdPage removeYourAdPage;
    AdRemovedPage adRemovedPage;
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
            driver.manage().window().maximize();
        }
        this.wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        this.baseUrl = baseUrl;
        sycLandingPage = new SycLandingPage(driver);
        action = new Actions(driver);

        adRemovedPage = new AdRemovedPage(driver);
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
        homeMainPage = new HomeMainPage(driver);
        signInPage = new SignInPage(driver);
        homeSidePage = new HomeSidePage(driver);
        editYourAdPage = new EditYourAdPage(driver);
        removeYourAdPage = new RemoveYourAdPage(driver);
        sycManageYourAdPage = new SycManageYourAdPage(driver);
    }

    /**
     * Preliminary Tests (Navigate to Deluxe Ad Selection
     *
     */

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
        sycRequiredInfoPage.selectYear("1996");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleYear"})
    public void shouldSelectVehicleMake() throws InterruptedException{
        sycRequiredInfoPage.selectMake("Ferrari");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleMake"})
    public void shouldSelectVehicleModel() throws InterruptedException{
        sycRequiredInfoPage.selectModel("F355");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleModel"})
    public void shouldSelectVehicleBodyStyle() throws InterruptedException{
        sycRequiredInfoPage.selectBodyStyle("Coupe");
    }

    @Test(dependsOnMethods = {"shouldSelectVehicleBodyStyle"})
    public void shouldSelectVehicleMileage() throws InterruptedException{
        sycRequiredInfoPage.setMileageInputField("50000");
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
        sycOptionalInfoPage.waitForObject();
        sycOptionalInfoPage.selectEngine("6 Cylinder");
    }

    @Test(dependsOnMethods = {"shouldSelectAnEngineType"})
    public void shouldSelectATrim() throws InterruptedException{
        sycOptionalInfoPage.selectTrim("GTS");
    }

    @Test(dependsOnMethods = {"shouldSelectATrim"})
    public void shouldSelectAFuelType() throws InterruptedException{
        sycOptionalInfoPage.selectFuel("Gasoline");
    }

    @Test(dependsOnMethods = {"shouldSelectAFuelType"})
    public void shouldEnterAComment() throws InterruptedException{
        sycOptionalInfoPage.enterComments("I hope this Test works yo! :D  :P   :O   >.<");
    }

    @Test(dependsOnMethods = {"shouldEnterAComment"})
    public void shouldSelectNextAddPhotosButton() throws InterruptedException{
        sycAddPhotosPage = sycOptionalInfoPage.clickOnNextButton();
        Thread.sleep(2000);
    }

    /**
     * Add Photos Page Tests
     *
     */

    @Test(dependsOnMethods = {"shouldSelectNextAddPhotosButton"})
    public void shouldSelectNextReviewAdButton() throws InterruptedException{
        //sycAddPhotosPage.waitForObject();
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
        //sycReviewAdPage.waitForObject();
        assertTrue(sycReviewAdPage.checkOnCorrectPage());
        sycReviewAdPage.waitForObject();
        sycCheckoutPage = sycReviewAdPage.clickNextCheckOutButton();
    }

    /**
     * Checkout Page Tests
     *
     */

    @Test(dependsOnMethods = {"shouldSelectNextCheckoutButton"})
    public void shouldSelectACardType() throws InterruptedException{
        //sycCheckoutPage.waitForObject();
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
        assertTrue(sycManageYourAdPage.checkOnCorrectPage());
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


}
