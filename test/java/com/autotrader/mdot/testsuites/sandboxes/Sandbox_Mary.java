package com.autotrader.mdot.testsuites.sandboxes;

import com.autotrader.mdot.pages.Dealers.DealerLocationPage;
import com.autotrader.mdot.pages.Dealers.DealerSearchResultsPage;
import com.autotrader.mdot.pages.SYC.SycLandingPage;
import com.autotrader.mdot.pages.TIM.TimLandingPage;
import com.autotrader.mdot.pages.misc.*;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 9/15/2015.
 */
public class Sandbox_Mary {

    String generatedEmail = "";
    String testingEnvironment = "https://m-test5.autotrader.com";
    WebDriver driver;
    WebDriverWait wait;

    HomeMainPage homeMainPage;
    HomeSidePage homeSidePage;
    TimLandingPage timLandingPage;
    PrivacyPolicyPage privacyPolicyPage;
    SignInPage signInPage;
    SignUpPage signUpPage;
    DealerLocationPage dealerLocationPage;
    VisitorAgreementPage visitorAgreementPage;
    SavedListingsPage savedListingsPage;
    SycLandingPage sycLandingPage;
    DealerSearchResultsPage dealerSearchResultsPage;


    //This initiates everything before the tests start running. Useful for how you want to run your tests!
    @BeforeClass
    public void setUp(){
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();

        visitorAgreementPage = new VisitorAgreementPage(driver);
        homeMainPage = new HomeMainPage(driver);
        homeSidePage = new HomeSidePage(driver);
        timLandingPage = new TimLandingPage(driver);
        privacyPolicyPage = new PrivacyPolicyPage(driver);
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);
        dealerLocationPage = new DealerLocationPage(driver);
        savedListingsPage = new SavedListingsPage(driver);
        sycLandingPage = new SycLandingPage(driver);
        dealerSearchResultsPage = new DealerSearchResultsPage(driver);
    }

    //This will simply stop the driver when the test is complete
    @AfterClass
    public void tearDown(){
        driver.quit();
    }


    /**
     * TEST #1:
     * The objective of this test is to display the mDOT FYC "Home" Page.
     * "FYC" is the acronym for "Find Your Car".
     * The current mDOT test URL is m-test5.autotrader.com.
     * This test case should be a standard module that can be "called" by other test cases.
     */

    @Test
    public void shouldBeAbleToAccessMdotHomePage () {
        // 1. Launch Chrome & Land on m.DOT test environment URL.
        driver.get(testingEnvironment);
        homeMainPage.waitForObject();
    }

    /**
     * TEST #2:
     * The objective of this test case is to register a brand new user via the GNM "Sign Up/Sign In" option.
     * "Hamburger" refers to the Global Navigation Menu icon.
     * The acronym "GNM" is referencing the Global Navigation Menu.
     */

    @Test(dependsOnMethods = {"shouldBeAbleToAccessMdotHomePage"})
    public void shouldBeAbleToSignUpFromGNM () throws InterruptedException {
        // 1. Complete the steps in TEST #1.
        // 2. Tap the "GNM" Hamburger.
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        // 3. Tap the Sign Up/In Option.
        signInPage = homeSidePage.clickSignInSignUp("SIGN UP/IN");
        signInPage.waitForObject();
        // 4. Tap the Sign Up Now link.
        signUpPage = signInPage.clickSignUpNow();
        signUpPage.waitForObject();
        // 5. Tap the "eMail" field and enter a valid email address.
        generatedEmail = generateEmail();
        signUpPage.enterEmailAddress(generatedEmail);
        // 6. Tap the "re-enter email" field and re-enter the valid email address.
        signUpPage.reEnterEmailAddress(generatedEmail);
        // 7. Tap the "password" field and enter a valid password.
        signUpPage.enterPassword();
        // 8. Tap the "re-enter" password field and reenter the valid password.
        signUpPage.reEnterPassword();
        // 9. Tap the "Sign Up" button.
        visitorAgreementPage = signUpPage.clickSignUpButton();
        Thread.sleep(2000);
        //10. Tap the "Accept" button to accept the agreement and to display the mDOT "Home" page.
        savedListingsPage = visitorAgreementPage.clickOnAcceptAgreement();
        Thread.sleep(2000);
    }


    /**
     * TEST #3:
     * The objective of this test is to verify that the "Sell Your Car" link on the mDOT "Home" page functions as it should.
     * As a result of clicking on the link, the "Sell Your Car Center" Page should display.
     * "Hamburger" refers to the Global Navigation Menu icon.
     * "GNM" is the acronym for the Global Navigation Menu.
     * This test will eventually return the user to the mDOT "Home" page after displaying the "Sell Your Car Center" Page.
     */

    @Test(dependsOnMethods = {"shouldBeAbleToSignUpFromGNM"})
    public void shouldBeAbleToLaunchSYCFromHomePage () throws InterruptedException{
        // 1. Complete the steps in TEST #1.
        // 2. Navigate to the "Sell Your Car" link & click
        driver.get(testingEnvironment);
        homeMainPage.waitForObject();
        sycLandingPage = homeMainPage.clickSellYourVehicle();
        sycLandingPage.waitForObject();
        assertTrue(sycLandingPage.checkOnCorrectPage());
        // 4. Tap the "Hamburger" to access the "GNM"
        homeSidePage = sycLandingPage.clickHamburgerButton();
        homeSidePage.waitForObject();
        // 5. Tap the "Home" option to return to the mDOT "Home" page.
        homeMainPage = homeSidePage.clickSideMenuHomeLink("HOME");
        homeMainPage.waitForObject();
    }


    /**
     * TEST #4:
     * The objective of this test is to verify that the "Trade Your Vehicle" link on the mDOT "Home" page functions as it should.
     * As a result of clicking on the link, the TIM "Instant Cash Offer" page should display.
     * "Hamburger" refers to the Global Navigation Menu icon.
     * "GNM" is the acronym for the Global Navigation Menu.
     * This test will eventually return the user to the mDOT "Home" page after displaying the "Instant Cash Offer" Page.
     */
    @Test(dependsOnMethods = {"shouldBeAbleToLaunchSYCFromHomePage"})
    public void shouldBeAbleToLaunchTIMFromHomePage () {
        // 1. Complete the steps in TEST #1.
        // 2. Navigate to the "Trade Your Vehicle" link.
        // 3. Tap the "Trade Your Vehicle" link.
        timLandingPage = homeMainPage.clickTradeYourVehicle();
        timLandingPage.waitForObject();
        assertTrue(timLandingPage.checkOnCorrectPage());
        // 4. Tap the "Hamburger" to access the "GNM".
        homeSidePage = timLandingPage.clickHamburgerButton();
        homeSidePage.waitForObject();
        // 5. Tap the "Home" option.
        homeMainPage = homeSidePage.clickSideMenuHomeLink("HOME");
        homeMainPage.waitForObject();

    }
        /**
         * TEST #5:
         * The objective of this test is to verify that the "View All Dealers" button on the mDOT "Home" page functions as it should.
         * As a result of clicking on the button, the Dealer's "Location" page should display.
         * "Hamburger" refers to the Global Navigation Menu icon.
         * "GNM" is the acronym for the Global Navigation Menu.
         * This test will eventually return the user to the mDOT "Home" page after displaying the "Car Dealers in your selected zip code area page".
         */
        @Test(dependsOnMethods = {"shouldBeAbleToLaunchTIMFromHomePage"})
        public void shouldBeAbleToLaunchDealersPageFromHomePage () {
            // 1. Complete the steps in TEST #1.
            // 2. Navigate to the "View All Dealers" button.
            // 3. Tap the "View All Dealers" button.
            dealerLocationPage = homeMainPage.clickViewAllDealers();
            dealerLocationPage.waitForObject();
            // 4. Enter a valid zip code in the "Zip Code" field.
            dealerLocationPage.enterZipCode("30004");
            // 5. Tap a "radius" option, i.e. "50 miles".
            dealerLocationPage.chooseRadius("50 Miles");
            // 6. Tap the "Done" button.
            dealerSearchResultsPage = dealerLocationPage.clickDone();
            dealerSearchResultsPage.waitForObject();
            assertTrue(dealerSearchResultsPage.checkOnCorrectPage());
            // 7. Tap the "Hamburger" to access the "GNM".
            homeSidePage = dealerSearchResultsPage.clickHamburgerButton();
            homeSidePage.waitForObject();
            // 8. Tap the "Home" option.
            homeMainPage = homeSidePage.clickSideMenuHomeLink("HOME");
            homeMainPage.waitForObject();

            }

    /**
     * TEST #6:
     * The objective of this test is to verify that the "Privacy Policy" link on the mDOT "Home" page functions as it should.
     * As a result of clicking on the link, the "Autotrader Privacy Statement" page should display.
     * This test will eventually return the user to the mDOT "Home" page after displaying the "Autotrader Privacy Statement" page.
     * The "Back" button is in the upper left-hand corner of the Autotrader Privacy Statement page.
     */
//    @Test
//    public void shouldBeAbleToLaunchPrivacyPolicyPageFromHomePage () throws InterruptedException {
//        // 1. Complete the steps in TEST #1.
//        // 2. Navigate to the "Private & Secure" section of the "Home" page.
//        // 3. Tap the "Privacy Policy" link to access the "Autotrader Privacy Statement" page.
//        // 4. Tap the "Back" button to return to the mDOT "Home" page.
//
//    }

    /**
     * TEST #7:
     * The objective of this test is to verify that the "Forgot Your Password" link functions as it should.
     * The user is a "returning/registered" user who has forgotten his password.
     * The user will use the original ID to retrieve his forgotten password.
     */
//    @Test
//    public void shouldBeAbleToRetrievePassword () {
//        // 1. Launch Chrome.
//        // 2. Launch the current m.dot test environment URL.
//        // 3. Tap the "GNM Hamburger".
//        // 4. Tap the "Sign Up/In" Option.
//        // 5. Tap the "eMail" field and enter your mDOT email address.
//        // 6. Tap the "Forgot Your Password?" link.
//        // 7. On the "Retrieve Password" page, enter your mDOT email address in the email field.
//        // 8. Tap the "Submit" button.
//        // 9. Tap "OK" on the "Message Sent" modal.
//        //10. Verify that an email containing your password is sent to your mDOT email address.
//    }

    //This is the method that will generate us a random email to sign up with
    public String generateEmail(){
        String tail = "@gmail.com";
        String s = "tester";
        int rand = (int)(Math.random() * 100000);
        String sf = s + rand + tail;
        return sf;
    }
}
