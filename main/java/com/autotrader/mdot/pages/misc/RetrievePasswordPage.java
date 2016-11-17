package com.autotrader.mdot.pages.misc;

import com.autotrader.mdot.pageselector.RetrievePasswordPageSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mwstratton on 11/23/2015.
 */
public class RetrievePasswordPage {

    public WebDriver driver;
    public WebDriverWait wait;
    public RetrievePasswordPageSelector selector;

    public RetrievePasswordPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.selector = new RetrievePasswordPageSelector();
    }

    public void enterEmail(String email){
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getEmailInputSelector())).sendKeys(email);
    }

    public void clickSubmitButton(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getSubmitButtonSelector())).click();
    }

    public boolean checkOnCorrectPage(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector.getHeaderSelector())).isDisplayed();
    }

}
