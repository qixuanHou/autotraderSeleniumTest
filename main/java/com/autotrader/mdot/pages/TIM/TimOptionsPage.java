package com.autotrader.mdot.pages.TIM;

import com.autotrader.mdot.pageselector.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class TimOptionsPage
{
    WebDriver driver;
    WebDriverWait wait;
    TimOptionsPageSelector selector;

    public TimOptionsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.selector = new TimOptionsPageSelector();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public boolean checkOnCorrectPage()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(selector.getNoAfterMarketEquipSelector()));
        return driver.findElement(selector.getNoAfterMarketEquipSelector()).isDisplayed();
    }

    public boolean clickNoAftermarketEquipment()
    {
        driver.findElement(selector.getNoAfterMarketEquipSelector()).click();
        return  driver.findElement(selector.getNoAfterMarketEquipSelector()).getAttribute("class").contains("ui-radio-on");
    }

    public void clickNextButton()
    {
        driver.findElement(selector.getNextButtonSelector()).click();
    }

    public boolean checkAfterMarketOptionsYesNoError(WebDriver driver)
    {
        return driver.findElement(selector.getNoAfterMarketEquipmentValidationSelector()).getText().equals("This field is required");
    }
}


