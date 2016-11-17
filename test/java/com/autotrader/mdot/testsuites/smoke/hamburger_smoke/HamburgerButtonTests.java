package com.autotrader.mdot.testsuites.smoke.hamburger_smoke;

import com.autotrader.mdot.pages.Dealers.DealerLocationPage;
import com.autotrader.mdot.pages.Dealers.DealerSearchResultsPage;
import com.autotrader.mdot.pages.SYC.SycLandingPage;
import com.autotrader.mdot.pages.TIM.TimLandingPage;
import com.autotrader.mdot.pages.TIM.TimRetrieveOfferPage;
import com.autotrader.mdot.pages.TIM.TimReviewOfferPage;
import com.autotrader.mdot.pages.misc.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by cher1 on 7/14/2015.
 */
public class HamburgerButtonTests {

    public WebDriver driver; // Declare the driver
    public WebDriverWait wait;
    public String baseUrl;

    // Classes (Pages) that the test will touch
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
    DesiredCapabilities capability;


    // This always runs true at the beginning of the test(s)
    @BeforeClass(alwaysRun = true)
    @org.testng.annotations.Parameters(value={"browserName","browser_version","platform","device","baseUrl","local","os","os_version","resolution","bsAccount"})
    public void setup(@Optional("browserName")String browserName,@Optional("version") String browser_version,@Optional("platform") String platform,@Optional("device") String device,@Optional("baseUrl")String baseUrl,@Optional("local")String local,@Optional("os")String os,@Optional("os_version")String os_version,@Optional("resolution")String resolution,@Optional("bsAccount")String bsAccount)throws Exception{
        if(local.equals("false")){
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
            baseUrl = "https://m-test1.autotrader.com/";
        }

        this.wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.baseUrl = baseUrl;
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
    }

    // This always runs true at the end of the test(s)
    @AfterClass(alwaysRun = true)
    public void teardown() {
        this.driver.quit();
    }

    /**
     *
     *
     * The Following Tests under Group "hamburger_test" aim to verify that all links located in the GNM are
     * accessbile and will direct you to the correct Page.
     *
     *
     *
     */

    @Test(priority = 1, groups = "hamburger_tests")
    public void shouldBeAbleToClickTheHomeLinkAndValidateItsPage() throws InterruptedException {
        driver.get(baseUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton(); // This is where the hand off begins
        homeSidePage.waitForObject();
        homeMainPage = homeSidePage.clickSideMenuHomeLink("HOME"); // This is where the hand off gives back control
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(priority = 2, groups = "hamburger_tests")
    public void shouldBeAbleToClickTheSavedListingsLinkAndValidateItsPage() throws InterruptedException {
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton(); // This is where the hand off begins
        homeSidePage.waitForObject();
        signInPage = homeSidePage.clickSideMenuSavedListingsLink("SAVED LISTINGS"); // This is where the hand off gives back control
        assertTrue(signInPage.checkOnCorrectPage());
    }

    @Test(priority = 3, groups = "hamburger_tests")
    public void shouldBeAbleToClickTheSavedSearchesLinkAndValidateItsPage() throws InterruptedException {
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton(); // This is where the hand off begins
        homeSidePage.waitForObject();
        signInPage = homeSidePage.clickSideMenuSavedSearchesLink("SAVED SEARCHES"); // This is where the hand off gives back control
        assertTrue(signInPage.checkOnCorrectPage());

    }

    @Test(priority = 4, groups = "hamburger_tests")
    public void shouldBeAbleToClickTheDealersLinkAndValidateItsPage() throws InterruptedException{
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton(); // This is where the hand off begins
        homeSidePage.waitForObject();
        dealerLocationPage = homeSidePage.clickSideMenuDealersLink("DEALERS"); // This is where the hand off gives back control
        assertTrue(dealerLocationPage.checkOnCorrectPage());
    }

    @Test(priority = 5, groups = "hamburger_tests")
    public void shouldBeAbleToClickOnThePaymentCalculatorLinkAndValidateItsPage() throws InterruptedException{
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        calculatePaymentPage = homeSidePage.clickSideMenuPaymentCalculator("PAYMENT CALCULATOR");
        calculatePaymentPage.waitForObject();
        assertTrue(calculatePaymentPage.checkOnCorrectPage());
    }

    @Test(priority = 6, groups = "hamburger_tests")
    public void shouldBeAbleToClickOnSignUpInLinkAndValidateItsPage() throws InterruptedException{
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        signInPage = homeSidePage.clickSignInSignUp("SIGN UP/IN");
        signInPage.waitForObject();
        assertTrue(signInPage.checkOnCorrectPage());
    }

    @Test(priority = 7, groups = "hamburger_tests")
    public void shouldBeAbleToClickOnDesktopSiteLinkAndValidateItsPage() throws InterruptedException{
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        atHomePage = homeSidePage.clickDesktopSite("DESKTOP SITE");
        //assertTrue(atHomePage.checkOnCorrectPage());
        Thread.sleep(2000);
    }


    @Test(priority = 8, groups = "hamburger_tests")
    public void shouldBeAbleToClickTradeInYourCarAndValidateItsPage() throws InterruptedException{
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        timLandingPage = homeSidePage.clickTradeInYourCar("TRADE IN YOUR CAR");
        timLandingPage.waitForObject();
        assertTrue(timLandingPage.checkOnCorrectPage());
    }

    @Test(priority = 9, groups = "hamburger_tests")
    public void shouldBeAbleToClickRetrieveMyOfferAndValidateItsPage() throws InterruptedException{
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        timRetrieveOfferPage = homeSidePage.clickRetrieveMyOffer("RETRIEVE MY OFFER");
        assertTrue(timRetrieveOfferPage.checkOnCorrectPage());
        Thread.sleep(2000);
    }

    @Test(priority = 10, groups = "hamburger_tests")
    public void shouldBeAbleToClickSellYourCarAndVerifyItsPage() throws InterruptedException{
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        sycLandingPage = homeSidePage.clickSellYourCar("SELL YOUR CAR");
        sycLandingPage.waitForObject();
        assertTrue(sycLandingPage.checkOnCorrectPage());
    }

    @Test(priority = 11, groups = "hamburger_tests")
    public void shouldBeAbleToClickOnEditYourAdAndVerifyItsPage() throws InterruptedException{
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        sycLandingPage = homeSidePage.clickEditYourAd("EDIT YOUR AD");
        sycLandingPage.waitForObject();
        assertTrue(sycLandingPage.checkOnCorrectPage());
    }

    @Test(priority = 12, groups = "hamburger_tests")
    public void shouldBeAbleToClickPrivacyPolicyLinkAndVerifyItsPage() throws InterruptedException{
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        privacyPolicyPage = homeSidePage.clickPrivacyPolicy("PRIVACY POLICY");
        assertTrue(privacyPolicyPage.checkOnCorrectPage());
        Thread.sleep(2000);
    }

    @Test(priority = 13, groups = "hamburger_tests")
    public void shouldBeAbleToClickVisitorAgreementLinkAndVerifyItsPage() throws InterruptedException{
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        visitorAgreementPage = homeSidePage.clickVisitorAgreement("VISITOR AGREEMENT");
        assertTrue(visitorAgreementPage.checkOnCorrectPage());
        Thread.sleep(2000);
    }

    @Test(priority = 14, groups = "hamburger_tests")
    public void shouldBeAbleToClickFraudAwarenessLinkAndValidateItsPage() throws InterruptedException{
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        fraudAwarenessPage = homeSidePage.clickSideMenuFraudAwareness("FRAUD AWARENESS");
        assertTrue(fraudAwarenessPage.checkOnCorrectPage());
        Thread.sleep(2000);
    }

    @Test(priority = 15, groups = "hamburger_tests")
    public void shouldBeAbleToClickCopyrightLink() throws InterruptedException{
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        homeSidePage.clickPopUpLinks("COPYRIGHT");
        Thread.sleep(2000);
    }

    @Test(priority = 16, groups = "hamburger_tests")
    public void shouldBeAbleToClickFeedbackLink() throws InterruptedException{
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        homeSidePage.clickPopUpLinks("FEEDBACK");
        Thread.sleep(2000);
    }

    @Test(priority = 17, groups = "hamburger_tests")
    public void shouldBeAbleToClickAdChoicesLink() throws InterruptedException {
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        homeSidePage.clickPopUpLinks("ADCHOICES");
        Thread.sleep(2000);
    }

    /**
     *
     * The following tests below verify that the functionality of the calculate payment page is working
     *
     *
     */

    @Test(priority = 1, groups = "calc_pay")
    public void shouldBeAbleToNavigateToCalculatePaymentPage() throws InterruptedException{
        driver.get(homeMainPage.pageUrl);
        homeSidePage = homeMainPage.clickHambergerButton();
        calculatePaymentPage = homeSidePage.clickSideMenuPaymentCalculator("PAYMENT CALCULATOR");
        calculatePaymentPage.waitForObject();
        assertTrue(calculatePaymentPage.checkOnCorrectPage());
    }

    @Test(priority = 2, groups = "calc_pay", dependsOnMethods = {"shouldBeAbleToNavigateToCalculatePaymentPage"})
    public void shouldBeAbleToClickAMonth() throws InterruptedException{
        calculatePaymentPage.selectMonth("24");
    }

    @Test(priority = 3, groups = "calc_pay", dependsOnMethods = {"shouldBeAbleToClickAMonth"})
    public void shouldSelectInterestRate() throws InterruptedException{
        calculatePaymentPage.setInterestRateInput("2");
    }

    @Test(priority = 4, groups = "calc_pay", dependsOnMethods = {"shouldSelectInterestRate"})
    public void shouldSelectPrice() throws InterruptedException{
        calculatePaymentPage.setPriceInput("20000");
    }

    @Test(priority = 5, groups = "calc_pay", dependsOnMethods = {"shouldSelectPrice"})
    public void shouldSelectDownPayment() throws InterruptedException{
        calculatePaymentPage.setDownPaymentInput("3000");
    }

    @Test(priority = 6, groups = "calc_pay", dependsOnMethods = {"shouldSelectDownPayment"})
    public void shouldSelectTradeInValue() throws InterruptedException{
        calculatePaymentPage.setTradeInValueInput("10000");
    }

    @Test(priority = 7, groups = "calc_pay", dependsOnMethods = {"shouldSelectTradeInValue"})
    public void shouldSelectAmountOwedOnTrade() throws InterruptedException{
        calculatePaymentPage.setAmountOwnedOnTradeInput("2000");
    }

    @Test(priority = 8, groups = "calc_pay", dependsOnMethods = {"shouldSelectAmountOwedOnTrade"})
    public void shouldSelectCalculateButton() throws InterruptedException{
        calculatePaymentPage.clickCalculateButton();
    }


}
