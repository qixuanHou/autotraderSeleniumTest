package com.autotrader.mdot.testsuites.regression;

import com.autotrader.mdot.pages.SYC.*;
import com.autotrader.mdot.pages.misc.*;
import com.autotrader.mdot.testsuites.TestExtension;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

/**
 * Created by mwstratton on 8/25/2015.
 */
public class SycStandardAdRegression extends TestExtension {

    public String cardNumber = "378282246310005";
    public String cardType = "American Express";
    public String year = "2001";
    public String make = "Ford";
    public String model = "Explorer";
    public String bodyStyle = "Sport Utility";
    public String mileage = "120000";
    public String vehiclePrice = "30000";
    public String phoneNumber = "4044218899";
    public String emailAddress = "attest1@yahoo.com";
    public String trim = "AWD Limited";
    public String doors = "Four Door";
    public String engine = "4 Cylinder";
    public String transmission = "Automatic";
    public String fuelType = "Gasoline";
    public String driveType = "Front Wheel Drive";
    public String exteriorColor = "BLACK";
    public String interiorColor = "RED";
    public int amtChosenInstalledFeatures = 0;


    SycLandingPage sycLandingPage;
    SycSelectAdPackagePage sycSelectAdPackagePage;
    SycEnterZipPage sycEnterZipPage;
    SycRequiredInfoPage sycRequiredInfoPage;
    SycOptionalInfoPage sycOptionalInfoPage;
    SycCheckoutPage sycCheckoutPage;
    SycReviewAdPage sycReviewAdPage;
    SycAddPhotosPage sycAddPhotosPage;
    SycOrderConfirmationPage sycOrderConfirmationPage;
    SycEnhanceYourAdPage sycEnhanceYourAdPage;
    AdRemovedPage adRemovedPage;
    EditYourAdPage editYourAdPage;
    HomeMainPage homeMainPage;
    RemoveYourAdPage removeYourAdPage;
    SycViewOrderPage sycViewOrderPage;
    SycPhotoSuggestionsPage sycPhotoSuggestionsPage;
    SycManageYourAdPage sycManageYourAdPage;

    Actions action;

    @BeforeClass(alwaysRun = true)
    public void setUp(){

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
        sycEnhanceYourAdPage = new SycEnhanceYourAdPage(driver);
        homeMainPage = new HomeMainPage(driver);
        adRemovedPage = new AdRemovedPage(driver);
        editYourAdPage = new EditYourAdPage(driver);
        removeYourAdPage = new RemoveYourAdPage(driver);
        sycViewOrderPage = new SycViewOrderPage(driver);
        sycPhotoSuggestionsPage = new SycPhotoSuggestionsPage(driver);
        sycManageYourAdPage = new SycManageYourAdPage(driver);
    }

    /**
     * Preliminary Tests (Navigate to Deluxe Ad Selection
     *
     */
    @Test
    public void shouldNavigateToHomepage(){
        driver.get(baseUrl);
        assertTrue(homeMainPage.checkOnCorrectPage());
    }
    @Test(dependsOnMethods = {"shouldNavigateToHomepage"})
    public void shouldBeAbleToVerifySycLandingPage(){
        sycLandingPage = homeMainPage.clickSellYourVehicle();
        assertTrue(sycLandingPage.checkOnCorrectPage());
        sycLandingPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToVerifySycLandingPage"})
    public void shouldClickPlaceYourAd() throws InterruptedException{
        sycEnterZipPage = sycLandingPage.clickPlaceYourAd();
        //assertTrue(sycEnterZipPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldClickPlaceYourAd"})
    public void shouldGetZipValidationError(){
        sycEnterZipPage.clickSubmitZipButton();
        assertTrue(sycEnterZipPage.checkZipValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetZipValidationError"})
    public void shouldEnterZipAndBeRedirectedToAdPackagePage(){
        sycEnterZipPage.enterZipCode();
        sycSelectAdPackagePage = sycEnterZipPage.clickSubmitZipButton();
        assertTrue(sycSelectAdPackagePage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldEnterZipAndBeRedirectedToAdPackagePage"})
    public void shouldSelectStandardAdAndBeRedirectedToRequiredInfoPage(){
        sycRequiredInfoPage = sycSelectAdPackagePage.clickSelectMOBStandardAd();
        assertTrue(sycRequiredInfoPage.checkOnCorrectPage());
    }

    /**
     * Required Info Page
     *
     */

    @Test(dependsOnMethods = {"shouldSelectStandardAdAndBeRedirectedToRequiredInfoPage"})
    public void shouldGetYearValidationError(){
        sycRequiredInfoPage.clickNextOptionalInfoButton();
        assertTrue(sycRequiredInfoPage.checkYearValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetYearValidationError"})
    public void shouldGetBodyStyleValidationError(){
        assertTrue(sycRequiredInfoPage.checkBodyStyleValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetBodyStyleValidationError"})
    public void shouldGetMileageValidationError(){
        assertTrue(sycRequiredInfoPage.checkMileageValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetMileageValidationError"})
    public void shouldGetPriceValidationError(){
        assertTrue(sycRequiredInfoPage.checkPriceValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetPriceValidationError"})
    public void shouldGetPhoneValidationError(){
        assertTrue(sycRequiredInfoPage.checkPhoneValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetPhoneValidationError"})
    public void shouldGetMobileCheckValidationError(){
        assertTrue(sycRequiredInfoPage.checkMobileNumberCheckValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetMobileCheckValidationError"})
    public void shouldGetEmailValidationError(){
        assertTrue(sycRequiredInfoPage.checkEmailValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetEmailValidationError"})
    public void shouldGetSecurityQuestionValidationError(){
        assertTrue(sycRequiredInfoPage.checkSecurityQuestionValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetSecurityQuestionValidationError"})
    public void shouldGetSecurityQuestionAnswerValidationError(){
        assertTrue(sycRequiredInfoPage.checkSecurityQuestionAnswerValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetSecurityQuestionAnswerValidationError"})
    public void shouldEnterAYear(){
        sycRequiredInfoPage.selectYear(year);
    }

    @Test(dependsOnMethods = {"shouldEnterAYear"})
    public void shouldEnterABodyStyle(){
        sycRequiredInfoPage.selectBodyStyle(bodyStyle);
    }

    @Test(dependsOnMethods = {"shouldEnterABodyStyle"})
    public void shouldInputMileage(){
        sycRequiredInfoPage.setMileageInputField("150000a");
    }

    @Test(dependsOnMethods = {"shouldInputMileage"})
    public void shouldInputPrice(){
        sycRequiredInfoPage.setPriceInputField(vehiclePrice);
    }

    @Test(dependsOnMethods = {"shouldInputPrice"})
    public void shouldInputPhoneNumber(){
        sycRequiredInfoPage.setPhoneInputField("404345667");
    }

    @Test(dependsOnMethods = {"shouldInputPhoneNumber"})
    public void shouldCheckYesMobileNumber(){
        sycRequiredInfoPage.checkMobileNumberBox();
    }

    @Test(dependsOnMethods = "shouldCheckYesMobileNumber")
    public void shouldEnterAnEmail(){
        sycRequiredInfoPage.setEmailAddressInputField(emailAddress);
    }

    @Test(dependsOnMethods = {"shouldEnterAnEmail"})
    public void shouldSelectASecurityQuestion(){
        sycRequiredInfoPage.setSecurityQuestionInputSelector("Favorite sports team?");
    }

    @Test(dependsOnMethods = {"shouldSelectASecurityQuestion"})
    public void shouldSelectAnAnswerAndClickNext(){
        sycRequiredInfoPage.setAnswerInputField("Cleveland Browns");
        sycRequiredInfoPage.clickNextOptionalInfoButton();
        assertTrue(sycRequiredInfoPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldSelectAnAnswerAndClickNext"})
    public void shouldGetMakeValidationError(){
        assertTrue(sycRequiredInfoPage.checkMakeValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetMakeValidationError"})
    public void shouldGetPhoneNeedsTenDigitsValidationError(){
        assertTrue(sycRequiredInfoPage.checkPhoneTenDigitsValidationError());
    }

//    @Test(dependsOnMethods = {"shouldSelectAnAnswerAndClickNext"})
//    public void shouldGetMileageWithCharactersValidationError(){
//        assertTrue(sycRequiredInfoPage.checkMileageValidationError());
//    }

    @Test(dependsOnMethods = {"shouldGetPhoneNeedsTenDigitsValidationError"})
    public void shouldGetMobileContactValidationError(){
        assertTrue(sycRequiredInfoPage.checkContactValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetMobileContactValidationError"})
    public void shouldEnterAMake(){
        sycRequiredInfoPage.selectMake(make);
    }

    @Test(dependsOnMethods = {"shouldEnterAMake"})
    public void shouldEnterAValidMileage(){
        sycRequiredInfoPage.setMileageInputField(mileage);
    }

    @Test(dependsOnMethods = {"shouldEnterAValidMileage"})
    public void shouldEnterAValidPhoneNumber(){
        sycRequiredInfoPage.setPhoneInputField(phoneNumber);
    }

    @Test(dependsOnMethods = {"shouldEnterAValidPhoneNumber"})
    public void shouldSelectNoMobileContactAndClickNext() throws InterruptedException{
        sycRequiredInfoPage.checkNoMobileContactBox();
        Thread.sleep(2000);
        sycRequiredInfoPage.clickNextOptionalInfoButton();
        assertTrue(sycRequiredInfoPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldSelectNoMobileContactAndClickNext"})
    public void shouldGetModelValidationError(){
        assertTrue(sycRequiredInfoPage.checkModelValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetModelValidationError"})
    public void shouldSelectAModel(){
        sycRequiredInfoPage.selectModel(model);
    }

    @Test(dependsOnMethods = {"shouldSelectAModel"})
    public void shouldClickNextAndVerifyOptionalInfoPage(){
        sycOptionalInfoPage = sycRequiredInfoPage.clickNextOptionalInfoButton();
        assertTrue(sycOptionalInfoPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldClickNextAndVerifyOptionalInfoPage"})
    public void shouldBeAbleToViewTrimInfo(){
        sycOptionalInfoPage.clickTrimInfoIcon();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToViewTrimInfo"})
    public void shouldSelectATrim(){
        sycOptionalInfoPage.selectTrim(trim);
    }

    @Test(dependsOnMethods = {"shouldSelectATrim"})
    public void shouldSelectDoors(){
        sycOptionalInfoPage.selectDoors(doors);
    }

    @Test(dependsOnMethods = {"shouldSelectDoors"})
    public void shouldSelectAnEngineType(){
        sycOptionalInfoPage.selectEngine(engine);
    }

    @Test(dependsOnMethods = {"shouldSelectAnEngineType"})
    public void shouldSelectATransmission(){
        sycOptionalInfoPage.selectTransmission(transmission);
    }

    @Test(dependsOnMethods = {"shouldSelectATransmission"})
    public void shouldSelectAFuelType(){
        sycOptionalInfoPage.selectFuel(fuelType);
    }

    @Test(dependsOnMethods = {"shouldSelectAFuelType"})
    public void shouldSelectADriveType(){
        sycOptionalInfoPage.selectDriveType(driveType);
    }

    @Test(dependsOnMethods = {"shouldSelectADriveType"})
    public void shouldSelectExteriorColor(){
        sycOptionalInfoPage.selectExtColor(exteriorColor);
    }

    @Test(dependsOnMethods = {"shouldSelectExteriorColor"})
    public void shouldSelectInteriorColor(){
        sycOptionalInfoPage.selectIntColor(interiorColor);
    }

    @Test(dependsOnMethods = {"shouldSelectInteriorColor"})
    public void shouldBeAbleToEnterAVin(){
        sycOptionalInfoPage.enterVinNumber("8976789");
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEnterAVin"})
    public void shouldBeAbleToViewVinInfo(){
        sycOptionalInfoPage.clickVinInfoIcon();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToViewVinInfo"})
    public void shouldAttemptToClickNextAddPhotos() {
        sycOptionalInfoPage.clickOnNextButton();
        assertTrue(sycOptionalInfoPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldAttemptToClickNextAddPhotos"})
    public void shouldBeAbleToEnterAValidVin(){
        sycOptionalInfoPage.enterVinNumber("");
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEnterAValidVin"})
    public void shouldBeAbleToCheckoutFromOptionalInfoPage() throws InterruptedException{
        sycViewOrderPage = sycOptionalInfoPage.clickOnCheckout();
        assertTrue(sycViewOrderPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToCheckoutFromOptionalInfoPage"})
    public void shouldNavigateBackToOptionalInfoPage() throws InterruptedException{
        driver.navigate().back();
        assertTrue(sycOptionalInfoPage.checkOnCorrectPage());
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldNavigateBackToOptionalInfoPage"})
    public void shouldBeAbleToSelectInstalledFeatures()throws InterruptedException{
        sycOptionalInfoPage.clickInstalledFeatures();
        for(int i = 26; i < 32; i++){
            Thread.sleep(2000);
            amtChosenInstalledFeatures ++;
            sycOptionalInfoPage.selectInstalledFeatures(i);
        }
        sycOptionalInfoPage.clickDoneFromSelectedFeatures();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSelectInstalledFeatures"})
    public void shouldAssertAmountOfSelectedFeatures(){
        assertTrue(sycOptionalInfoPage.checkAmountOfInstalledFeatures(amtChosenInstalledFeatures));
    }

    @Test(dependsOnMethods = {"shouldAssertAmountOfSelectedFeatures"})
    public void shouldBeAbleToUseTheCommentBuilder() throws InterruptedException{
        sycOptionalInfoPage.clickCommentBuilder();
        for(int i = 0; i < 5; i++){
            Thread.sleep(2000);
            sycOptionalInfoPage.selectComments(i);
        }
        sycOptionalInfoPage.clickDoneFromCommentBuilder();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToUseTheCommentBuilder"})
    public void shouldClickNextAddPhotosAndBeRedirectedToAddPhotosPage(){
        sycAddPhotosPage = sycOptionalInfoPage.clickOnNextButton();
        assertTrue(sycAddPhotosPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldClickNextAddPhotosAndBeRedirectedToAddPhotosPage"})
    public void shouldBeAbleToNavigateToPhotoSuggestionsPage(){
        sycPhotoSuggestionsPage = sycAddPhotosPage.clickPhotoSuggestions();
        assertTrue(sycPhotoSuggestionsPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToNavigateToPhotoSuggestionsPage"})
    public void shouldNavigateBackToAddPhotosPage(){
        driver.navigate().back();
        assertTrue(sycAddPhotosPage.checkOnCorrectPage());
    }


//    @Test(dependsOnMethods = {"shouldNavigateBackToAddPhotosPage"})
//    public void shouldBeAbleToAddAPhoto() throws AWTException, InterruptedException{
//        sycAddPhotosPage.clickUploadPhoto();
//        Thread.sleep(4000);
//        sycAddPhotosPage.uploadPhoto();
//        Thread.sleep(2000);
//    }

    @Test(dependsOnMethods = {"shouldNavigateBackToAddPhotosPage"})
    public void shouldBeAbleToClickCheckoutFromAddPhotosPage(){
        sycViewOrderPage = sycAddPhotosPage.clickCheckout();
        assertTrue(sycViewOrderPage.checkOnCorrectPage());
        driver.navigate().back();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickCheckoutFromAddPhotosPage"})
    public void shouldBeAbleToClickNextReviewAd(){
        sycReviewAdPage = sycAddPhotosPage.clickNextReviewAdButton();
        assertTrue(sycReviewAdPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickNextReviewAd"})
    public void shouldVerifyAdDetails(){
       assertTrue(sycReviewAdPage.verifyHeader(year, make, model, trim));
    }

    @Test(dependsOnMethods = {"shouldVerifyAdDetails"})
    public void shouldVerifyEditRequiredInfoButton(){
        assertTrue(sycReviewAdPage.verifyEditRequiredInfoButton());
    }

    @Test(dependsOnMethods = {"shouldVerifyEditRequiredInfoButton"})
    public void shouldVerifyEmailSellerButton(){
        assertTrue(sycReviewAdPage.verifyEmailSellerButton());
    }

    @Test(dependsOnMethods = {"shouldVerifyEmailSellerButton"})
    public void shouldVerifyEditPhotoButton(){
        assertTrue(sycReviewAdPage.verifyEditPhotosButton());
    }

    @Test(dependsOnMethods = {"shouldVerifyEditPhotoButton"})
    public void shouldVerifyEditOptionalInfoButton(){
        assertTrue(sycReviewAdPage.verifyEditOptionalInfoButton());
    }

    @Test(dependsOnMethods = {"shouldVerifyEditOptionalInfoButton"})
    public void shouldClickNextAndBeRedirectedToEnhanceAdPage(){
        sycEnhanceYourAdPage = sycReviewAdPage.clickNextEnhanceAdButton();
        assertTrue(sycEnhanceYourAdPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldClickNextAndBeRedirectedToEnhanceAdPage"})
    public void shouldVerifyEnhanceOptionsAreAvailable(){
        assertTrue(sycEnhanceYourAdPage.verifyRtsUpsCheckBox());
        assertTrue(sycEnhanceYourAdPage.verifyThumbnailCheckBox());
    }

    @Test(dependsOnMethods = {"shouldVerifyEnhanceOptionsAreAvailable"})
    public void shouldClickNextCheckoutAndBeRedirectedToCheckoutPage(){
        sycCheckoutPage = sycEnhanceYourAdPage.clickNextCheckout();
        assertTrue(sycCheckoutPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldClickNextCheckoutAndBeRedirectedToCheckoutPage"})
    public void shouldNotBeAbleToCheckoutWithMissingInformation(){
        sycCheckoutPage.clickSubmitButton();
        assertTrue(sycCheckoutPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldNotBeAbleToCheckoutWithMissingInformation"})
    public void shouldBeAbleToEnterACardType(){
        sycCheckoutPage.selectCardType(cardType);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEnterACardType"})
    public void shouldBeAbleToEnterACardNumber(){
        sycCheckoutPage.setCardNumber(cardNumber);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEnterACardNumber"})
    public void shouldBeAbleToEnterASecurityCode(){
        sycCheckoutPage.setSecurityCode("1212");
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEnterASecurityCode"})
    public void shouldBeAbleToSelectAExpirationMonth(){
        sycCheckoutPage.selectExpirationMonth("January");
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSelectAExpirationMonth"})
    public void shouldBeAbleToSelectAExpirationYear(){
        sycCheckoutPage.selectExpirationYear("2016");
    }

    @Test(dependsOnMethods = {"shouldBeAbleToSelectAExpirationYear"})
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
    public void shouldBeAbleToClickOnSubmitButton() throws InterruptedException{
        sycOrderConfirmationPage = sycCheckoutPage.clickSubmitButton();
        Thread.sleep(2000);
        assertTrue(sycOrderConfirmationPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickOnSubmitButton"})
    public void shouldBeAbleToEditYourAd() throws InterruptedException{
        sycManageYourAdPage = sycOrderConfirmationPage.clickOnEditYourAd();
        assertTrue(sycManageYourAdPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEditYourAd"})
    public void shouldBeAbleToVerifyMileageListed(){
        assertTrue(sycManageYourAdPage.validateMileageListed(mileage));
    }

    @Test(dependsOnMethods = {"shouldBeAbleToVerifyMileageListed"})
    public void shouldBeAbleToVerifyPriceListed(){
        assertTrue(sycManageYourAdPage.validatePriceListed(vehiclePrice));
    }

    @Test(dependsOnMethods = {"shouldBeAbleToVerifyPriceListed"})
    public void shouldBeAbleToChangeMileage() throws InterruptedException{
        sycManageYourAdPage.clickMileageBox();
        sycManageYourAdPage.enterNewMileage("55000");
        sycManageYourAdPage.saveNewMileage();
        Thread.sleep(4000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToChangeMileage"})
    public void shouldBeAbleToChangePrice() throws InterruptedException{
        sycManageYourAdPage.clickPriceBox();
        sycManageYourAdPage.enterNewPrice("200000");
        sycManageYourAdPage.saveNewPrice();
        Thread.sleep(4000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToChangePrice"})
    public void shouldVerifyNewMileage(){
        assertTrue(sycManageYourAdPage.validateMileageListed("55000"));
    }

    @Test(dependsOnMethods = {"shouldVerifyNewMileage"})
    public void shouldVerifyNewPrice(){
        assertTrue(sycManageYourAdPage.validatePriceListed("200000"));
    }

    @Test(dependsOnMethods = {"shouldVerifyNewPrice"})
    public void shouldBeAbleToDeleteYourAd(){
        removeYourAdPage = sycManageYourAdPage.clickOnRemoveAd();
        adRemovedPage = removeYourAdPage.clickRemoveAdListing();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToDeleteYourAd"})
    public void shouldVerifyAdHasBeenDeleted(){
        assertTrue(adRemovedPage.checkOnCorrectPage());
    }



}
