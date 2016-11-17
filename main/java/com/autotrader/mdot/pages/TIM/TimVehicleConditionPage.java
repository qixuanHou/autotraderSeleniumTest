package com.autotrader.mdot.pages.TIM;

import com.autotrader.mdot.pageselector.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class TimVehicleConditionPage
{
    WebDriver driver;
    WebDriverWait wait;
    TimVehicleConditionPageSelector selector;


    public TimVehicleConditionPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.selector = new TimVehicleConditionPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean checkOnCorrectPage()
    {
        return driver.findElement(selector.getNoWearAndTearSelector()).isDisplayed();
    }

    public  boolean clickNoWearAndTear()
    {
        driver.findElement(selector.getNoWearAndTearSelector()).click();
        return driver.findElement(selector.getNoWearAndTearSelector()).getAttribute("class").contains("ui-radio-on");
    }

    public boolean clickNoMechanicalIssues()
    {
        driver.findElement(selector.getNoMechanicalIssuesSelector()).click();
        return driver.findElement(selector.getNoMechanicalIssuesSelector()).getAttribute("class").contains("ui-radio-on");
    }

    public boolean clickNoSeriousAccidentDamage()
    {
        driver.findElement(selector.getNoSeriousAccidentDamageSelector()).click();
       return driver.findElement(selector.getNoSeriousAccidentDamageSelector()).getAttribute("class").contains("ui-radio-on");
    }

    public void clickNextButton() throws InterruptedException
    {
        driver.findElement(selector.getNextButtonSelector()).click();
        Thread.sleep(500);
    }

    public boolean checkWearAndTearValidation(){
    return driver.findElement(selector.getNoWearAndTearValidationSelector()).getText().equals("This field is required");
}
    public boolean checkMechanicalIssuesValidation() {
        return driver.findElement(selector.getNoMechanicalIssuesValidationSelector()).getText().equals("This field is required");
    }
    public boolean checkSeriousAccidentDamageValidation(){
        return driver.findElement(selector.getNoSeriousAccidentDamageValidationSelector()).getText().equals("This field is required");
    }
}
