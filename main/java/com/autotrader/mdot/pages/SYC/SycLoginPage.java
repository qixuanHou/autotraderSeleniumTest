package com.autotrader.mdot.pages.SYC;

import com.autotrader.mdot.pageselector.SycLoginPageSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mwstratton on 11/23/2015.
 */
public class SycLoginPage {

    public WebDriver driver;
    public WebDriverWait wait;
    public SycLoginPageSelector selector;

    public SycLoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.selector = new SycLoginPageSelector();
    }

    public void enterEmailForSycAd(String email){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getEmailInputSelector())).sendKeys(email);
    }

    public void enterAdIdForSycAd(String id){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getAdIdInputSelector())).sendKeys(id);
    }

    public SycLandingPage clickCancel(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getCancelButtonSelector())).click();
        return new SycLandingPage(driver);
    }

    public SycManageYourAdPage clickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getLoginButtonSelector())).click();
        return new SycManageYourAdPage(driver);
    }

}
