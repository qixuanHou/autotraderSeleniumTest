package com.autotrader.mdot.testsuites.regression;

import com.autotrader.mdot.pages.TIM.*;
import com.autotrader.mdot.pages.misc.HomeMainPage;
import com.autotrader.mdot.testsuites.TestExtension;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
public class TimCashOfferRegression extends TestExtension{

    DesiredCapabilities capability;
    TimLandingPage timLandingPage;
    TimOptionsPage timOptionsPage;
    TimVehicleHistoryPage timVehicleHistoryPage;
    TimVehicleConditionPage timVehicleConditionPage;
    TimContactInfoPage timContactInfoPage;
    TimReviewOfferPage timReviewOfferPage;
    TimOfferPage timOfferPage;
    TimInfoPage timInfoPage;
    HomeMainPage homeMainPage;


    //<editor-fold desc="Setup Information For All Tests">
    /**
     * Starts up webdriver, sets waits, and sets the params for test.
     *
     */
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        timLandingPage = new TimLandingPage(driver);
        timOptionsPage = new TimOptionsPage(driver);
        timVehicleHistoryPage = new TimVehicleHistoryPage(driver);
        timVehicleConditionPage = new TimVehicleConditionPage(driver);
        timContactInfoPage = new TimContactInfoPage(driver);
        timReviewOfferPage = new TimReviewOfferPage(driver);
        timOfferPage = new TimOfferPage(driver);
        timInfoPage = new TimInfoPage(driver);
        homeMainPage = new HomeMainPage(driver);
    }

    /**
     * Closes Web Driver After Tests
     * Takes screenshot on pass or fail.
     *
     */

    //</editor-fold>

    /**
     * Landing Page Tests
     *
     */
    @Test()
    public void shouldNavigateToHomepage(){
        driver.get(baseUrl);
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldNavigateToHomepage"})
    public void shouldNavigateToLandingPage() throws InterruptedException {
        timLandingPage = homeMainPage.clickTradeYourVehicle();
        timLandingPage.checkOnCorrectPage();
    }

    @Test(dependsOnMethods = {"shouldNavigateToLandingPage"})
    public void shouldNavigateToTimInfoPage() throws InterruptedException{
        timInfoPage = timLandingPage.clickLearnMore();
        Thread.sleep(2000);
        assertTrue(timInfoPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldNavigateToTimInfoPage"})
    public void shouldCheckForInformationHeaders(){
        assertTrue(timInfoPage.verifyInfoTitle("Instant Cash Offer"));
        assertTrue(timInfoPage.verifyInfoTitle("Kelley Blue Book"));
    }

    @Test(dependsOnMethods = {"shouldCheckForInformationHeaders"})
    public void shouldCheckForInformationBoxHeader(){
        assertTrue(timInfoPage.verifyBoxHeader("How is an Instant Cash Offer different"));
    }

    @Test(dependsOnMethods = {"shouldCheckForInformationBoxHeader"})
    public void shouldCheckForAtcBulletInformation(){
        assertTrue(timInfoPage.verifyBulletInfo("An actual offer based on your car's condition,"));
        assertTrue(timInfoPage.verifyBulletInfo("A quick and easy way to trade in or sell your car"));
        assertTrue(timInfoPage.verifyBulletInfo("Based on specific elements of your car,"));
    }

    @Test(dependsOnMethods = {"shouldCheckForAtcBulletInformation"})
    public void shouldCheckForKbbBulletInfo(){
        assertTrue(timInfoPage.verifyBulletInfo("An independent value range for similar cars of the same year"));
        assertTrue(timInfoPage.verifyBulletInfo("The Trade-In Value Range is Kelley Blue Book's estimate"));
        assertTrue(timInfoPage.verifyBulletInfo("Derived in part from actual transactions of cars like yours"));
    }

    @Test(dependsOnMethods = {"shouldCheckForKbbBulletInfo"})
    public void shouldNavigateBackToTimLandingPage()throws InterruptedException{
        driver.navigate().back();
        assertTrue(timLandingPage.checkOnCorrectPage());
        Thread.sleep(2000);
    }

    @Test (dependsOnMethods = {"shouldNavigateBackToTimLandingPage"})
    public void shouldGetYearValidationError() throws InterruptedException {
        timLandingPage.clickNextButton();
        Assert.assertTrue(timLandingPage.checkYearValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetYearValidationError"})
    public void shouldSelectVehicleYear() throws InterruptedException {
        timLandingPage.selectYear("2003");
    }

    @Test (dependsOnMethods = {"shouldSelectVehicleYear"})
    public void shouldGetMakeValidationError() throws InterruptedException {
        timLandingPage.clickNextButton();
        Thread.sleep(2000);
        Assert.assertTrue(timLandingPage.checkMakeValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetMakeValidationError"})
    public void shouldSelectVehicleMake() throws InterruptedException {
        timLandingPage.selectMake("Acura");
    }

    @Test (dependsOnMethods = {"shouldSelectVehicleMake"})
    public void shouldGetModelValidationError() throws InterruptedException {
        timLandingPage.clickNextButton();
        Assert.assertTrue(timLandingPage.checkModelValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetModelValidationError"})
    public void shouldSelectVehicleModel() throws InterruptedException {

        timLandingPage.selectModel("MDX");
    }

    @Test (dependsOnMethods = {"shouldSelectVehicleModel"})
    public void shouldGetStyleValidationError() throws InterruptedException {
        timLandingPage.clickNextButton();
        Assert.assertTrue(timLandingPage.checkStyleValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetStyleValidationError"})
    public void shouldSelectVehicleStyle() throws InterruptedException {
        timLandingPage.selectStyle("4dr SUV 4WD Touring Package");
    }

    @Test (dependsOnMethods = {"shouldSelectVehicleStyle"})
    public void shouldGetExteriorColorValidationError() throws InterruptedException {
        timLandingPage.clickNextButton();
        Thread.sleep(2000);
        Assert.assertTrue(timLandingPage.checkExteriorColorValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetExteriorColorValidationError"})
    public void shouldSelectVehicleExtColor() throws InterruptedException {
        timLandingPage.selectExtColor("Sandstone");
    }

    @Test (dependsOnMethods = {"shouldSelectVehicleExtColor"})
    public void shouldGetInteriorColorValidationError() throws InterruptedException {
        timLandingPage.clickNextButton();
        Assert.assertTrue(timLandingPage.checkInteriorColorValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetInteriorColorValidationError"})
    public void shouldSelectVehicleIntColor() throws InterruptedException {
        timLandingPage.selectIntColor("Saddle");
    }

    @Test (dependsOnMethods = {"shouldSelectVehicleIntColor"})
    public void shouldGetNullMileageValidationError() throws InterruptedException {
        timLandingPage.setMileage("");
        timLandingPage.clickNextButton();
        Assert.assertTrue(timLandingPage.checkNullMileageValidationError());
    }

    @Test (dependsOnMethods = {"shouldGetNullMileageValidationError"})
    public void shouldGetZeroMileageValidationError() throws InterruptedException {
        timLandingPage.setMileage("0");
        timLandingPage.clickNextButton();
        Assert.assertTrue(timLandingPage.checkZeroMileageValidationError());
    }

    @Test (dependsOnMethods = {"shouldGetZeroMileageValidationError"})
    public void shouldGetHighMileageValidationError() throws InterruptedException {
        timLandingPage.setMileage("200001");
        timLandingPage.clickNextButton();
        Assert.assertTrue(timLandingPage.checkHighMileageValidationError());
    }

    @Test(dependsOnMethods = {"shouldGetHighMileageValidationError"})
    public void shouldSelectVehicleMileage() throws InterruptedException {
        timLandingPage.setMileage("50000");
    }

    @Test (dependsOnMethods = {"shouldSelectVehicleMileage"})
    public void shouldGetZipValidationError() throws InterruptedException {
        timLandingPage.clickNextButton();
//        Assert.assertTrue(timLandingPage.checkZipValidationError());
    }
    @Test(dependsOnMethods = {"shouldGetZipValidationError"})
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
        Thread.sleep(6000);
        timOptionsPage.checkOnCorrectPage();
    }

    @Test(dependsOnMethods = {"shouldCheckOnVehicleOptionsPage"})
    public void shouldGetAfterMarketOptionYesNoError() throws InterruptedException {
        timOptionsPage.clickNextButton();
        Thread.sleep(10000);
        timOptionsPage.checkAfterMarketOptionsYesNoError(driver);
    }

    @Test(dependsOnMethods = {"shouldGetAfterMarketOptionYesNoError"})
    public void shouldClickNoAftermarketEquipButton() throws InterruptedException {
        timOptionsPage.clickNoAftermarketEquipment();
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
        Thread.sleep(10000);
        timVehicleHistoryPage.checkOnCorrectPage();
    }

    @Test(dependsOnMethods = {"shouldCheckOnVehicleHistoryPage"})
    public void shouldCheckOriginalOwnerValidation() throws InterruptedException{
        timVehicleHistoryPage.clickNextButton();
        Thread.sleep(2000);
        Assert.assertTrue(timVehicleHistoryPage.checkOriginalOwnerValidation());
    }
    @Test(dependsOnMethods = {"shouldCheckOriginalOwnerValidation"})
    public void shouldCheckClearTitleValidation(){
        Assert.assertTrue(timVehicleHistoryPage.checkClearTitleValidation());
    }
    @Test(dependsOnMethods = {"shouldCheckClearTitleValidation"})
     public void shouldCheckCleanHistoryReportValidation(){
        Assert.assertTrue(timVehicleHistoryPage.checkCleanHistoryReportValidation());
    }
    @Test(dependsOnMethods = {"shouldCheckCleanHistoryReportValidation"})
    public void shouldCheckInsuranceClaimsValidation(){
        Assert.assertTrue(timVehicleHistoryPage.checkInsuranceClaimsValidation());
    }
    @Test(dependsOnMethods = {"shouldCheckInsuranceClaimsValidation"})
    public void shouldCheckSmokingInVehicleValidation(){
        Assert.assertTrue(timVehicleHistoryPage.checkSmokingInVehicleValidation());
    }
    @Test(dependsOnMethods = {"shouldCheckSmokingInVehicleValidation"})
    public void shouldCheckCompleteServiceRecordsValidation(){
        Assert.assertTrue(timVehicleHistoryPage.checkCompleteServiceRecordsValidation());
    }
    @Test(dependsOnMethods = {"shouldCheckCompleteServiceRecordsValidation"})
    public void shouldCheckTwoSetsOfKeysValidation(){
        Assert.assertTrue(timVehicleHistoryPage.checkTwoSetsOfKeysValidation());
    }
    @Test(dependsOnMethods = {"shouldCheckTwoSetsOfKeysValidation"})
    public void shouldCheckAutoAuctionValidation(){
        Assert.assertTrue(timVehicleHistoryPage.checkAutoAuctionValidation());
    }
    @Test(dependsOnMethods = {"shouldCheckAutoAuctionValidation"})
    public void shouldCheckRentalCarValidation(){
        Assert.assertTrue(timVehicleHistoryPage.checkRentalCarValidation());
    }

    @Test(dependsOnMethods = {"shouldClickYesOriginalOwner"})
    public void shouldSmokingInVehicleValidation() throws InterruptedException {
        timVehicleHistoryPage.clickYesOriginalOwner();
    }

    @Test(dependsOnMethods = {"shouldCheckInsuranceClaimsValidation"})
    public void shouldClickYesOriginalOwner() throws InterruptedException {
        timVehicleHistoryPage.clickYesOriginalOwner();
    }

    @Test(dependsOnMethods = {"shouldClickYesOriginalOwner"})
    public void shouldClickYesClearTitle() throws InterruptedException {
        timVehicleHistoryPage.clickYesClearTitle();
    }

    @Test(dependsOnMethods = {"shouldClickYesClearTitle"})
    public void shouldClickYesCleanHistory() throws InterruptedException {
        timVehicleHistoryPage.clickYesCleanHistoryReport();
    }

    @Test(dependsOnMethods = {"shouldClickYesCleanHistory"})
    public void shouldClickNoInsuranceClaims() throws InterruptedException {
        timVehicleHistoryPage.clickNoInsuranceClaims();
    }

    @Test(dependsOnMethods = {"shouldClickNoInsuranceClaims"})
    public void shouldClickNoSmokeInVehicle() throws InterruptedException {
        timVehicleHistoryPage.clickNoSmokingInVehicle();
    }

    @Test(dependsOnMethods = {"shouldClickNoSmokeInVehicle"})
    public void shouldClickYesServiceRecordsAvailable() throws InterruptedException {
        timVehicleHistoryPage.clickYesCompleteServiceRecords();
    }

    @Test(dependsOnMethods = {"shouldClickYesServiceRecordsAvailable"})
    public void shouldClickYesTwoKeysAvailable() throws InterruptedException {
        timVehicleHistoryPage.clickYesTwoSetsOfKeys();
    }

    @Test(dependsOnMethods = {"shouldClickYesTwoKeysAvailable"})
    public void shouldClickNoAutoAuction() throws InterruptedException {
        timVehicleHistoryPage.clickNoAutoAuction();
    }

    @Test(dependsOnMethods = {"shouldClickNoAutoAuction"})
    public void shouldClickNoRentalCar() throws InterruptedException {
        timVehicleHistoryPage.clickNoRentalCar();
    }

    @Test(dependsOnMethods = {"shouldClickNoRentalCar"})
    public void shouldClickNextButtonOnHistoryPage() throws InterruptedException {
        Thread.sleep(10000);
        timVehicleHistoryPage.clickNextButton();
    }

    /**
     * Condition Page Tests
     *
     */
    @Test(dependsOnMethods = {"shouldClickNextButtonOnHistoryPage"})
    public void shouldCheckOnVehicleConditionPage() throws InterruptedException {
        Thread.sleep(7000);
        timVehicleConditionPage.checkOnCorrectPage();
    }

    @Test(dependsOnMethods = {"shouldCheckOnVehicleConditionPage"})
    public void shouldCheckWearAndTearValidation() throws InterruptedException{
        timVehicleConditionPage.clickNextButton();
        Assert.assertTrue(timVehicleConditionPage.checkWearAndTearValidation());
    }
    @Test(dependsOnMethods = {"shouldCheckWearAndTearValidation"})
    public void shouldCheckMechanicalIssuesValidation() {
        Assert.assertTrue(timVehicleConditionPage.checkMechanicalIssuesValidation());
    }
    @Test(dependsOnMethods = {"shouldCheckMechanicalIssuesValidation"})
    public void shouldCheckSeriousAccidentDamageValidation() {
        Assert.assertTrue(timVehicleConditionPage.checkSeriousAccidentDamageValidation());
    }

    @Test(dependsOnMethods = {"shouldCheckSeriousAccidentDamageValidation"})
    public void shouldClickNoWearAndTear() throws InterruptedException {
        timVehicleConditionPage.clickNoWearAndTear();
    }

    @Test(dependsOnMethods = {"shouldClickNoWearAndTear"})
    public void shouldClickNoMechanicalIssues() throws InterruptedException {
        timVehicleConditionPage.clickNoMechanicalIssues();
    }

    @Test(dependsOnMethods = {"shouldClickNoMechanicalIssues"})
    public void shouldClickNoSeriousConditions() throws InterruptedException {
        timVehicleConditionPage.clickNoSeriousAccidentDamage();
    }

    @Test(dependsOnMethods = {"shouldClickNoSeriousConditions"})
    public void shouldClickNextButtonOnVehicleConditionPage() throws InterruptedException {
        timVehicleConditionPage.clickNextButton();
    }

    /**
     * Contact Page Tests
     *
     */
    @Test(dependsOnMethods = {"shouldClickNextButtonOnVehicleConditionPage"})
    public void shouldCheckOnMobileContactPage() throws InterruptedException {
        Thread.sleep(4000);
        timContactInfoPage.checkOnCorrectPage();
    }

    @Test(dependsOnMethods = {"shouldCheckOnMobileContactPage"})
    public void shouldCheckEmptyFirstNameInputFieldValidation() throws InterruptedException{
        timContactInfoPage.clickNextButton();
        Assert.assertTrue(timContactInfoPage.checkEmptyFirstNameInputFieldValidation());
    }
    @Test(dependsOnMethods = {"shouldCheckEmptyFirstNameInputFieldValidation"})
    public void shouldCheckEmptyLastNameInputFieldValidation(){
        Assert.assertTrue(timContactInfoPage.checkEmptyLastNameInputFieldValidation());
    }
    @Test(dependsOnMethods = {"shouldCheckEmptyLastNameInputFieldValidation"})
    public void shouldCheckEmptyEmailInputFieldValidation(){
        Assert.assertTrue(timContactInfoPage.checkEmptyEmailInputFieldValidation());
    }
    @Test(dependsOnMethods = {"shouldCheckEmptyEmailInputFieldValidation"})
    public void shouldCheckEmptyEmailVerifyInputFieldValidation(){
        Assert.assertTrue(timContactInfoPage.checkEmptyEmailVerifyInputFieldValidation());
    }
    @Test(dependsOnMethods = {"shouldCheckEmptyEmailVerifyInputFieldValidation"})
    public void shouldCheckEmptyPhoneInputFieldValidation(){
        Assert.assertTrue(timContactInfoPage.checkEmptyPhoneInputFieldValidation());
    }

    @Test(dependsOnMethods = {"shouldCheckEmptyPhoneInputFieldValidation"})
    public void shouldGetMismatchEmailError() throws InterruptedException {
        timContactInfoPage.setEmailInputField("joe.cox@autotrader.com");
        timContactInfoPage.setEmailVerifyInputField("Tyler.Harnach@autotrader.com");
        Assert.assertTrue(timContactInfoPage.checkContactEmailsMatchValidation());
    }

    @Test(dependsOnMethods = {"shouldGetMismatchEmailError"})
    public void shouldGetEmailFormatError() throws InterruptedException {
        timContactInfoPage.setEmailInputField("tyler");
        Assert.assertTrue(timContactInfoPage.checkContactEmailFormatValidation());
    }
    @Test(dependsOnMethods = {"shouldGetEmailFormatError"})
    public void shouldGetVerifyEmailFormatError() throws InterruptedException {
        timContactInfoPage.setEmailVerifyInputField("tyler");
        Assert.assertTrue(timContactInfoPage.checkContactVerifyEmailFormatValidation());
    }

    @Test(dependsOnMethods = {"shouldGetVerifyEmailFormatError"})
    public void shouldFillOutFirstNameField() throws InterruptedException {
        timContactInfoPage.setFirstNameInputField("Mat");
    }

    @Test(dependsOnMethods = {"shouldFillOutFirstNameField"})
    public void shouldFillOutLastNameField() throws InterruptedException {
        timContactInfoPage.setLastNameInputField("Stratton");
    }

    @Test(dependsOnMethods = {"shouldFillOutLastNameField"})
    public void shouldFillOutEmailAddressField() throws InterruptedException {
        timContactInfoPage.setEmailInputField("attest1@yahoo.com");
    }

    @Test(dependsOnMethods = {"shouldFillOutEmailAddressField"})
    public void shouldFillOutEmailAddressVerifyField() throws InterruptedException {
        timContactInfoPage.setEmailVerifyInputField("attest1@yahoo.com");
    }

    @Test(dependsOnMethods = {"shouldFillOutEmailAddressVerifyField"})
    public void shouldGetPhoneNumberFormatError() throws InterruptedException {
        timContactInfoPage.setPhoneInputField("asdf");
        Assert.assertTrue(timContactInfoPage.checkPhoneFormatValidation());
    }

    @Test(dependsOnMethods = {"shouldGetPhoneNumberFormatError"})
    public void shouldFillOutPhoneNumberField() throws InterruptedException {
        timContactInfoPage.setPhoneInputField("4044212833");
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
        timReviewOfferPage.checkOnCorrectPage();
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


