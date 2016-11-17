package com.autotrader.mdot.testsuites.smoke.myatc_smoke;

import com.autotrader.mdot.pages.misc.*;
import com.autotrader.mdot.testsuites.TestExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


import java.util.concurrent.TimeUnit;

/**
 * Created by mwstratton on 9/11/2015.
 */
public class SignInSignOutTests extends TestExtension{

    SavedListingsPage savedListingsPage;
    HomeMainPage homeMainPage;
    HomeSidePage homeSidePage;
    SignInPage signInPage;
    SignUpPage signUpPage;
    VisitorAgreementPage visitorAgreementPage;
    String generatedEmail = "";

    @BeforeClass(alwaysRun = true)
    public void setUp(){

        signInPage = new SignInPage(driver);
        homeSidePage = new HomeSidePage(driver);
        homeMainPage = new HomeMainPage(driver);
        signUpPage = new SignUpPage(driver);
        visitorAgreementPage = new VisitorAgreementPage(driver);
        savedListingsPage = new SavedListingsPage(driver);
    }

    /**
     * Sign Up/In tests from Hamburger Button
     *
     */

    @Test(priority = 1)
    public void shouldNavigateToHomepage(){
        driver.get(baseUrl);
        homeMainPage.waitForObject();
    }


    @Test(dependsOnMethods = {"shouldNavigateToHomepage"})
    public void clickSignInLinkFromHamburgerButton(){
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        signInPage = homeSidePage.clickSignInSignUp("SIGN UP/IN");
        signInPage.waitForObject();
    }

    @Test(dependsOnMethods = {"clickSignInLinkFromHamburgerButton"})
    public void clickSignUpNowHB(){
        signUpPage = signInPage.clickSignUpNow();
        signUpPage.waitForObject();
    }

    @Test(dependsOnMethods = {"clickSignUpNowHB"})
    public void shouldBeAbleToEnterEmailAndConfirmEmailHB(){
        generatedEmail = generateEmail();
        signUpPage.enterEmailAddress(generatedEmail);
        signUpPage.reEnterEmailAddress(generatedEmail);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEnterEmailAndConfirmEmailHB"})
    public void shouldBeAbleToEnterPasswordAndConfirmPasswordHB(){
        signUpPage.enterPassword();
        signUpPage.reEnterPassword();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEnterPasswordAndConfirmPasswordHB"})
    public void shouldClickSignUpAndBeRedirectedToVisitorAgreementHB(){
        visitorAgreementPage = signUpPage.clickSignUpButton();
        visitorAgreementPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldClickSignUpAndBeRedirectedToVisitorAgreementHB"})
    public void shouldBeAbleToAcceptAgreementHB() throws InterruptedException{
        savedListingsPage = visitorAgreementPage.clickOnAcceptAgreement();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToAcceptAgreementHB"})
    public void shouldClickStartYourSearchAndBeRedirectedToHomepageHB(){
        homeMainPage = savedListingsPage.clickStartYourSearch();
        homeMainPage.waitForObject();
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldClickStartYourSearchAndBeRedirectedToHomepageHB"})
    public void shouldSignOutFromGnmHb() throws InterruptedException{
        signOut();
    }

    @Test(dependsOnMethods = {"shouldSignOutFromGnmHb"})
    public void shouldSignInFromGnmHB() throws InterruptedException{
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        signInPage = homeSidePage.clickSignInSignUp("SIGN UP/IN");
        signInPage.waitForObject();
        signInPage.enterEmail(generatedEmail);
        signInPage.enterPassword(signUpPage.getPassForGeneratedEmail());
        homeMainPage = signInPage.clickSignIn();
        Thread.sleep(2000);
        assertTrue(homeMainPage.checkOnCorrectPage());
        signOut();
    }

    @Test(dependsOnMethods = {"shouldSignInFromGnmHB"})
    public void shouldClickSignInTopRight() throws InterruptedException{
        homeMainPage.waitForObject();
        signInPage = homeMainPage.clickSignInButtonTopRight();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldClickSignInTopRight"})
    public void clickSignUpNowTR(){
        signUpPage = signInPage.clickSignUpNow();
        signUpPage.waitForObject();
    }

    @Test(dependsOnMethods = {"clickSignUpNowTR"})
    public void shouldBeAbleToEnterEmailAndConfirmEmailTR(){
        generatedEmail = generateEmail();
        signUpPage.enterEmailAddress(generatedEmail);
        signUpPage.reEnterEmailAddress(generatedEmail);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEnterEmailAndConfirmEmailTR"})
    public void shouldBeAbleToEnterPasswordAndConfirmPasswordTR(){
        signUpPage.enterPassword();
        signUpPage.reEnterPassword();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEnterPasswordAndConfirmPasswordTR"})
    public void shouldClickSignUpAndBeRedirectedToVisitorAgreementTR(){
        visitorAgreementPage = signUpPage.clickSignUpButton();
        visitorAgreementPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldClickSignUpAndBeRedirectedToVisitorAgreementTR"})
    public void shouldBeAbleToAcceptAgreementTR() throws InterruptedException{
        savedListingsPage = visitorAgreementPage.clickOnAcceptAgreement();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToAcceptAgreementTR"})
    public void shouldClickStartYourSearchAndBeRedirectedToHomepageTR(){
        homeMainPage = savedListingsPage.clickStartYourSearch();
        homeMainPage.waitForObject();
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldClickStartYourSearchAndBeRedirectedToHomepageTR"})
    public void shouldSignOutFromGnmTR() throws InterruptedException{
        signOut();
    }

    @Test(dependsOnMethods = {"shouldSignOutFromGnmTR"})
    public void shouldSignInFromTopRight() throws InterruptedException{
        signInPage = homeMainPage.clickSignInButtonTopRight();
        signInPage.waitForObject();
        signInPage.enterEmail(generatedEmail);
        signInPage.enterPassword(signUpPage.getPassForGeneratedEmail());
        homeMainPage = signInPage.clickSignIn();
        Thread.sleep(2000);
        assertTrue(homeMainPage.checkOnCorrectPage());
        signOut();
    }

    @Test(dependsOnMethods = {"shouldSignInFromTopRight"})
    public void shouldClickSignInBottom() throws InterruptedException{
        homeMainPage.waitForObject();
        signInPage = homeMainPage.clickSignInButtonBottom();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldClickSignInBottom"})
    public void clickSignUpNowB() {
        signUpPage = signInPage.clickSignUpNow();
        signUpPage.waitForObject();
    }

    @Test(dependsOnMethods = {"clickSignUpNowB"})
    public void shouldBeAbleToEnterEmailAndConfirmEmailB(){
        generatedEmail = generateEmail();
        signUpPage.enterEmailAddress(generatedEmail);
        signUpPage.reEnterEmailAddress(generatedEmail);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEnterEmailAndConfirmEmailB"})
    public void shouldBeAbleToEnterPasswordAndConfirmPasswordB() {
        signUpPage.enterPassword();
        signUpPage.reEnterPassword();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToEnterPasswordAndConfirmPasswordB"})
    public void shouldClickSignUpAndBeRedirectedToVisitorAgreementB(){
        visitorAgreementPage = signUpPage.clickSignUpButton();
        visitorAgreementPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldClickSignUpAndBeRedirectedToVisitorAgreementB"})
    public void shouldBeAbleToAcceptAgreementB() throws InterruptedException{
        savedListingsPage = visitorAgreementPage.clickOnAcceptAgreement();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = {"shouldBeAbleToAcceptAgreementB"})
    public void shouldClickStartYourSearchAndBeRedirectedToHomepageB() {
        homeMainPage = savedListingsPage.clickStartYourSearch();
        homeMainPage.waitForObject();
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    @Test(dependsOnMethods = {"shouldClickStartYourSearchAndBeRedirectedToHomepageB"})
    public void shouldSignOutFromGnmB() throws InterruptedException {
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        homeSidePage.clickSignOut("SIGN OUT");
        homeMainPage.confirmLogOut();
        Thread.sleep(4000);
    }

    @Test(dependsOnMethods = {"shouldSignOutFromGnmB"})
    public void shouldSignInFromBottom() throws InterruptedException{
        signInPage = homeMainPage.clickSignInButtonBottom();
        signInPage.waitForObject();
        signInPage.enterEmail(generatedEmail);
        signInPage.enterPassword(signUpPage.getPassForGeneratedEmail());
        homeMainPage = signInPage.clickSignIn();
        Thread.sleep(2000);
        assertTrue(homeMainPage.checkOnCorrectPage());
    }

    public void signOut() throws InterruptedException{
        homeSidePage = homeMainPage.clickHambergerButton();
        homeSidePage.waitForObject();
        homeSidePage.clickSignOut("SIGN OUT");
        homeMainPage.confirmLogOut();
        Thread.sleep(4000);
    }

    public String generateEmail(){
        String gmail = "@gmail.com";
        String s = "tester";
        int rand = (int)(Math.random() * 100000000);
        String sf = s + rand + gmail;
        return sf;
    }

}
