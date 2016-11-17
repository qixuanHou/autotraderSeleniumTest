package com.autotrader.mdot.pages.TIM;

import com.autotrader.mdot.pageselector.*;
import com.autotrader.mdot.pages.misc.HomeSidePage;
import com.autotrader.mdot.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TimLandingPage {

    WebDriver driver;
    WebDriverWait wait;
    // Wait Methods

    WaitFor waitFor;
    TimLandingPageSelector selector;


 public TimLandingPage(WebDriver driver){
     this.driver = driver;
     this.wait = new WebDriverWait(driver, 20);
     this.waitFor = new WaitFor(driver);
     this.selector = new TimLandingPageSelector();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 }

    public HomeSidePage clickHamburgerButton(){
        driver.findElement(selector.getHamburgerButtonSelector()).click();
        return new HomeSidePage(driver);
    }
    public void waitForObject(){
        waitFor.waitForExpectedConditions(driver, selector.getYearSelector());
    }
    public void navigateToUrl( String url)
    {
        driver.get(url);
    }
    public boolean checkOnCorrectPage()
    {
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector.getYearSelector())).isDisplayed();
    }

    public void selectYear( String text)
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getYearSelector(), text));
        new Select(driver.findElement(selector.getYearSelector())).selectByVisibleText(text);
    }

    public void selectMake( String text) throws InterruptedException {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getMakeSelector(), text));
                new Select(driver.findElement(selector.getMakeSelector())).selectByVisibleText(text);

//        new Select(driver.findElement(makeSelector)).selectByVisibleText(text);
    }

    public void selectModel( String text)
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getModelSelector(), text));
                new Select(driver.findElement(selector.getModelSelector())).selectByVisibleText(text);


    }

    public void selectStyle( String text)
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getStyleSelector(), text));
                new Select(driver.findElement(selector.getStyleSelector())).selectByVisibleText(text);

    }

    public void selectExtColor( String text)
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getExtColorSelector(), text));
                new Select(driver.findElement(selector.getExtColorSelector())).selectByVisibleText(text);

    }

    public void selectIntColor( String text)
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getIntColorSelector(), text));
                new Select(driver.findElement(selector.getIntColorSelector())).selectByVisibleText(text);
          }

    public void setMileage( String text)
    {
        driver.findElement(selector.getMileageSelector()).clear();
        driver.findElement(selector.getMileageSelector()).sendKeys(text);
    }

    public void setZip( String text)
    {
        driver.findElement(selector.getZipSelector()).sendKeys(text);
    }

    public void clickNextButton() throws InterruptedException
    {
        wait.until(ExpectedConditions.elementToBeClickable(selector.getNextButtonSelector())).click();
    }

    public boolean checkYearValidationError()
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getYearValidationSelector(), "Vehicle Year: Required"));
        return driver.findElement(selector.getYearValidationSelector()).getText().equals("Vehicle Year: Required");
    }

    public boolean checkZipValidationError()
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getZipValidationSelector(), "Please enter a valid Zip Code."));
        return driver.findElement(selector.getZipValidationSelector()).getText().equals("Please enter a valid Zip Code.");
    }

    public boolean checkMakeValidationError()
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getMakeValidationSelector(), "Make: Required"));
        return driver.findElement(selector.getMakeValidationSelector()).getText().equals("Make: Required");
    }

    public boolean checkModelValidationError()
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getModelValidationSelector(), "Model: Required"));
        return  driver.findElement(selector.getModelValidationSelector()).getText().equals("Model: Required");
        }

    public boolean checkStyleValidationError()
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getStyleValidationSelector(), "Style: Required"));
        return driver.findElement(selector.getStyleValidationSelector()).getText().equals("Style: Required");
      }

    public boolean checkExteriorColorValidationError()
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getExteriorColorValidationSelector(), "Exterior Color: Required"));
        return  driver.findElement(selector.getExteriorColorValidationSelector()).getText().equals("Exterior Color: Required");
              }

    public boolean checkInteriorColorValidationError() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getInteriorColorValidationSelector(), "Interior Color: Required"));
        return driver.findElement(selector.getInteriorColorValidationSelector()).getText().equals("Interior Color: Required");
    }

    public boolean checkNullMileageValidationError()
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getMileageValidationSelector(), "Mileage: may not be null"));
        return  driver.findElement(selector.getMileageValidationSelector()).getText().equals("Mileage: may not be null");
    }

    public boolean checkZeroMileageValidationError()
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getMakeValidationSelector(), "Mileage: Must be greater than 0"));
                return  driver.findElement(selector.getMakeValidationSelector()).getText().equals("Mileage: Must be greater than 0");
        }

    public boolean checkHighMileageValidationError()
    {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selector.getMileageValidationSelector(), "Mileage: Valuation Unavailable"));
                return  driver.findElement(selector.getMileageValidationSelector()).getText().equals("Mileage: Valuation Unavailable");
            }

    public void selectRandomValueFromComboBox(WebDriver driver, By by)
    {
        String one = driver.findElement(by).getText();
        String[] two = one.split(" ");
        Random r = new Random();
        int number = r.nextInt(two.length - 1)+1;
        new Select(driver.findElement(by)).deselectByIndex(number);
    }

    public TimInfoPage clickLearnMore(){
        wait.until(ExpectedConditions.elementToBeClickable(selector.getLearnMoreSelector())).click();
        return new TimInfoPage(driver);
    }

}



