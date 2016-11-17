package com.autotrader.mdot.testsuites.regression;

import com.autotrader.mdot.pages.Dealers.DealerLocationPage;
import com.autotrader.mdot.pages.Dealers.DealerSearchResultsPage;
import com.autotrader.mdot.pages.SYC.SycLandingPage;
import com.autotrader.mdot.pages.TIM.TimLandingPage;
import com.autotrader.mdot.pages.TIM.TimRetrieveOfferPage;
import com.autotrader.mdot.pages.misc.*;
import com.autotrader.mdot.testsuites.TestExtension;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by mwstratton on 10/28/2015.
 */
public class HomepageGnmRegression extends TestExtension {

    HomeMainPage homeMainPage;
    HomeSidePage homeSidePage;
    SignInPage signInPage;
    DealerSearchResultsPage dealerSearchResultsPage;
    SignUpPage signUpPage;
    VisitorAgreementPage visitorAgreementPage;
    PrivacyPolicyPage privacyPolicyPage;
    FraudAwarenessPage fraudAwarenessPage;
    CalculatePaymentPage calculatePaymentPage;
    ATHomePage atHomePage;
    TimLandingPage timLandingPage;
    TimRetrieveOfferPage timRetrieveOfferPage;
    SycLandingPage sycLandingPage;
    DealerLocationPage dealerLocationPage;
    SavedListingsPage savedListingsPage;
    SavedSearchPage savedSearchPage;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        homeMainPage = new HomeMainPage(driver); // This is your starting point page
        homeSidePage = new HomeSidePage(driver);
        signInPage = new SignInPage(driver);
        dealerSearchResultsPage = new DealerSearchResultsPage(driver);
        signUpPage = new SignUpPage(driver);
        visitorAgreementPage = new VisitorAgreementPage(driver);
        privacyPolicyPage = new PrivacyPolicyPage(driver);
        fraudAwarenessPage = new FraudAwarenessPage(driver);
        calculatePaymentPage = new CalculatePaymentPage(driver);
        atHomePage = new ATHomePage(driver);
        timRetrieveOfferPage = new TimRetrieveOfferPage(driver);
        timLandingPage = new TimLandingPage(driver);
        sycLandingPage = new SycLandingPage(driver);
        dealerLocationPage = new DealerLocationPage(driver);
        savedListingsPage = new SavedListingsPage(driver);
        savedSearchPage = new SavedSearchPage(driver);
    }

    @Test()
    public void shouldBeAbleToNavigateToHomepage(){
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToNavigateToHomepage"}, priority = 1)
    public void shouldBeAbleToVerifyHomepageAdvertisement(){
        assertTrue(homeMainPage.checkForAd());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToVerifyHomepageAdvertisement"}, priority = 2)
    public void shouldBeAbleToVerifySearchForCarsButton(){
        assertTrue(homeMainPage.checkSearchForCarButtonDisplayed());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToVerifySearchForCarsButton"}, priority = 3)
    public void shouldBeAbleToVerifyTradeYourVehicleButton(){
        assertTrue(homeMainPage.verifyTradeYourVehicleButtonIsClickable());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToVerifyTradeYourVehicleButton"}, priority = 4)
    public void shouldBeAbleToVerifyFYCSliderOptions(){
        assertTrue(homeMainPage.verifyNewUsedCertifiedIsClickable());
        assertTrue(homeMainPage.verifyYearMakeModelTrimIsClickable());
        assertTrue(homeMainPage.verifyStyleIsClickable());
        assertTrue(homeMainPage.verifyMoreOptionsIsClickable());
        assertTrue(homeMainPage.verifyLocationAndRadiusIsClickable());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToVerifyFYCSliderOptions"}, priority = 5)
    public void shouldBeAbleToVerifySellYourVehicleButton(){
        assertTrue(homeMainPage.verifySellYourVehicleButton());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToVerifySellYourVehicleButton"}, priority = 7)
    public void shouldBeAbleToClickHomeFromGnmAndBeRedirectedToHomepage(){
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        homeMainPage = homeSidePage.clickSideMenuHomeLink("HOME");
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickHomeFromGnmAndBeRedirectedToHomepage"}, priority = 8)
    public void shouldBeAbleToClickSavedListingsLoggedOutAndValidateItsPage(){
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        signInPage = homeSidePage.clickSideMenuSavedListingsLink("SAVED LISTINGS");
        assertTrue(signInPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickSavedListingsLoggedOutAndValidateItsPage"}, priority = 9)
    public void shouldBeAbleToClickSavedSearchesLoggedOutAndValidateItsPage(){
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        signInPage = homeSidePage.clickSideMenuSavedSearchesLink("SAVED SEARCHES");
        assertTrue(signInPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickSavedSearchesLoggedOutAndValidateItsPage"}, priority = 10)
    public void shouldBeAbleToClickDealersAndValidateItsPage(){
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        dealerLocationPage = homeSidePage.clickSideMenuDealersLink("DEALERS");
        assertTrue(dealerLocationPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickDealersAndValidateItsPage"}, priority = 11)
    public void shouldBeAbleToClickPaymentCalculatorAndVerifyItsPage(){
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        calculatePaymentPage = homeSidePage.clickSideMenuPaymentCalculator("PAYMENT CALCULATOR");
        assertTrue(calculatePaymentPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickPaymentCalculatorAndVerifyItsPage"}, priority = 12)
    public void shouldBeAbleToClickOnSignUpInAndValidateItsPage(){
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        signInPage = homeSidePage.clickSignInSignUp("SIGN UP/IN");
        signInPage.waitForObject();
        assertTrue(signInPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickOnSignUpInAndValidateItsPage"}, priority = 13)
    public void shouldBeAbleToClickDesktopSiteAndValidateItsPage()throws InterruptedException{
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        atHomePage = homeSidePage.clickDesktopSite("DESKTOP SITE");
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickDesktopSiteAndValidateItsPage"}, priority = 14)
    public void shouldBeAbleToClickTradeInYourCarAndValidateItsPage(){
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        timLandingPage = homeSidePage.clickTradeInYourCar("TRADE IN YOUR CAR");
        assertTrue(timLandingPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickTradeInYourCarAndValidateItsPage"}, priority = 15)
    public void shouldBeAbleToClickRetrieveMyOfferAndValidateItsPage(){
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        timRetrieveOfferPage = homeSidePage.clickRetrieveMyOffer("RETRIEVE MY OFFER");
        assertTrue(timRetrieveOfferPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickRetrieveMyOfferAndValidateItsPage"}, priority = 16)
    public void shouldBeAbleToClickSellYourCarAndVerifyItsPage(){
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        sycLandingPage = homeSidePage.clickSellYourCar("SELL YOUR CAR");
        assertTrue(sycLandingPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickSellYourCarAndVerifyItsPage"}, priority = 17)
    public void shouldBeAbleToClickEditYourAdAndVerifyItsPage(){
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        sycLandingPage = homeSidePage.clickEditYourAd("EDIT YOUR AD");
        //sycLandingPage.waitForObject();
        assertTrue(sycLandingPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickEditYourAdAndVerifyItsPage"}, priority = 18)
    public void shouldBeAbleToClickPrivacyPolicyAndVerifyItsPage(){
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        privacyPolicyPage = homeSidePage.clickPrivacyPolicy("PRIVACY POLICY");
        assertTrue(privacyPolicyPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickPrivacyPolicyAndVerifyItsPage"}, priority = 19)
    public void shouldBeAbleToClickVisitorAgreementAndVerifyItsPage(){
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        visitorAgreementPage = homeSidePage.clickVisitorAgreement("VISITOR AGREEMENT");
        assertTrue(visitorAgreementPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickVisitorAgreementAndVerifyItsPage"}, priority = 20)
    public void shouldBeAbleToClickFraudAwarenessAndVerifyItsPage(){
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        fraudAwarenessPage = homeSidePage.clickSideMenuFraudAwareness("FRAUD AWARENESS");
        assertTrue(fraudAwarenessPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickFraudAwarenessAndVerifyItsPage"})
    public void shouldBeAbleToClickSignInFromTopRight(){
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        signInPage = homeMainPage.clickSignInButtonTopRight();
        assertTrue(signInPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClickSignInFromTopRight"})
    public void shouldBeAbleToInputValidEmail(){
        signInPage.enterEmail("attest1@yahoo.com");
    }

    @Test(dependsOnMethods = {"shouldBeAbleToInputValidEmail"})
    public void shouldBeAbleToInputValidPassword(){
        signInPage.enterPassword("Aaaaaa07");
    }

    @Test(dependsOnMethods = {"shouldBeAbleToInputValidPassword"})
    public void shouldVerifySignInWorks() throws InterruptedException{
        homeMainPage = signInPage.clickSignIn();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldVerifySignInWorks"})
    public void shouldSelectSavedListingsFromGnmSignedInAndVerifyPage() throws InterruptedException{
        homeSidePage = homeMainPage.clickHambergerButton();
        Thread.sleep(2000);
        savedListingsPage = homeSidePage.clickSideMenuSavedListingsLinkSignedIn("SAVED LISTINGS");
        assertTrue(savedListingsPage.verifyHeaderIsDisplayed());
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldSelectSavedListingsFromGnmSignedInAndVerifyPage"})
    public void shouldSelectSavedSearchesFromGnmSignedInAndVerifyPage() throws InterruptedException{
        homeSidePage = savedListingsPage.clickHamburgerButton();
        homeSidePage.waitForObject();
        savedSearchPage = homeSidePage.clickSideMenuSavedSearchesLinkSignedIn("SAVED SEARCHES");
        assertTrue(savedSearchPage.verifyHeaderIsDisplayed());
    }


}
