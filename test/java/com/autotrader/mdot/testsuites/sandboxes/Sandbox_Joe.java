package com.autotrader.mdot.testsuites.sandboxes;
import com.autotrader.mdot.pages.misc.CalculatePaymentPage;
import com.autotrader.mdot.pages.misc.HomeMainPage;
import com.autotrader.mdot.pages.misc.HomeSidePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Sandbox_Joe {
    /**
     * TEST #1:
     * The User can select every month selection of the calculator
     * Created by Joe Wittman on 9/18/2015
     */

    WebDriver driver;

    CalculatePaymentPage calculatePaymentPage;
    HomeMainPage homeMainPage;
    HomeSidePage homeSidePage;


    @BeforeClass
    public void setUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();

        homeMainPage = new HomeMainPage(driver);
        homeSidePage = new HomeSidePage(driver);
        calculatePaymentPage = new CalculatePaymentPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void shouldBeAbleToNavigateToCalculatePaymentPage() {
        driver.get(homeMainPage.pageUrl);
        homeMainPage.waitForObject();
        homeSidePage = homeMainPage.clickHambergerButton();
        calculatePaymentPage = homeSidePage.clickSideMenuPaymentCalculator("PAYMENT CALCULATOR");
        calculatePaymentPage.waitForObject();
    }

    @Test(dependsOnMethods = {"shouldBeAbleToNavigateToCalculatePaymentPage"})
    public void shouldBeAbleToClick24Months() {
        //1. Choose 24 from top right of Calculator screen
        calculatePaymentPage.selectMonth("24");
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClick24Months"})
    public void shouldBeAbleToClick36Months() {
        //1. Choose 36 from top right of Calculator screen
        calculatePaymentPage.selectMonth("36");
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClick36Months"})
    public void shouldBeAbleToClick48Months() {
        //1. Choose 48 from top right of Calculator screen
        calculatePaymentPage.selectMonth("48");
    }

    @Test(dependsOnMethods = {"shouldBeAbleToClick48Months"})
    public void shouldBeAbleToClick60Months() {
        //1. Choose 60 from top right of Calculator screen
        calculatePaymentPage.selectMonth("60");
    }


    @Test(dependsOnMethods = {"shouldBeAbleToClick60Months"})
    public void shouldBeAbleToClick72Months() {
        //1. Choose 72 from top right of Calculator screen
        calculatePaymentPage.selectMonth("72");
    }


    /**
     * TEST #2:
     * The Interest Rate field should accept single digits and double digits
     */

    @Test(dependsOnMethods = {"shouldBeAbleToClick72Months"})
    public void shouldBeAbleToInputNumericCharactersInInterestRateField() {
        //1. Enter 6 in the Interest Rate Field
        calculatePaymentPage.setInterestRateInput("6");
        //2. Enter 11 in the Interest Rate Field
        calculatePaymentPage.setInterestRateInput("11");
    }


    /**
     * TEST #3:
     * The Interest Rate field should only accept numeric characters
     */

    @Test(dependsOnMethods = {"shouldBeAbleToInputNumericCharactersInInterestRateField"})
    public void shouldNotBeAbleToInputAlphaCharactersInInterestRateField() {
        //1. Enter B in the Interest Rate Field
        calculatePaymentPage.setInterestRateInput("B");
        //2. Enter z in the Interest Rate Field
        calculatePaymentPage.setInterestRateInput("z");
    }

    @Test(dependsOnMethods = {"shouldNotBeAbleToInputAlphaCharactersInInterestRateField"})
    public void shouldNotBeAbleToInputSpecialCharactersInInterestRateField() {
        //1. Enter + in the Interest Rate Field
        calculatePaymentPage.setInterestRateInput("+");
        //2. Enter = in the Interest Rate Field
        calculatePaymentPage.setInterestRateInput("=");
        //3. Enter @ in the Interest Rate Field
        calculatePaymentPage.setInterestRateInput("@");
        //4. Enter * in the Interest Rate Field
        calculatePaymentPage.setInterestRateInput("*");
        //5. Enter $ in the Interest Rate Field
        calculatePaymentPage.setInterestRateInput("$");
    }


    /**
     * TEST #4:
     * The Price field should accept up to 8 numeric characters
     */


    @Test(dependsOnMethods = {"shouldNotBeAbleToInputSpecialCharactersInInterestRateField"})
    public void shouldAbleToInputNumericCharactersInPriceField() {
        //1.  Enter 1 in the Price field
        calculatePaymentPage.setPriceInput("1");
        //2.  Enter 12 in the Price field
        calculatePaymentPage.setPriceInput("12");
        //3.  Enter 123 in the Price field
        calculatePaymentPage.setPriceInput("123");
        //4.  Enter 1234 in the Price field
        calculatePaymentPage.setPriceInput("1234");
        //5.  Enter 12345 in the Price field
        calculatePaymentPage.setPriceInput("12345");
        //6.  Enter 123456 in the Price field
        calculatePaymentPage.setPriceInput("123456");
        //7.  Enter 1234567 in the Price field
        calculatePaymentPage.setPriceInput("1234567");
        //6.  Enter 12345678 in the Price field
        calculatePaymentPage.setPriceInput("12345678");
    }


    /**
     * TEST #6:
     * The Price field should only accept numeric characters
     */


    @Test(dependsOnMethods = {"shouldAbleToInputNumericCharactersInPriceField"})
    public void shouldNotBeAbleToInputAlphaCharactersInPriceField() {
        //1. Enter B in the Price Field
        calculatePaymentPage.setPriceInput("B");
        //2. Enter z in the Price Field
        calculatePaymentPage.setPriceInput("z");
    }

    @Test(dependsOnMethods = {"shouldNotBeAbleToInputAlphaCharactersInPriceField"})
    public void shouldNotBeAbleToInputSpecialCharactersInPriceField() {
        //1. Enter + in the Price Field
        calculatePaymentPage.setPriceInput("+");
        //2. Enter = in the Price Field
        calculatePaymentPage.setPriceInput("=");
        //3. Enter @ in the Price Field
        calculatePaymentPage.setPriceInput("@");
        //4. Enter * in the Price Field
        calculatePaymentPage.setPriceInput("*");
        //5. Enter $ in the PriceField
        calculatePaymentPage.setPriceInput("$");
    }


    /**
     * TEST #7:
     * The Down Payment field should accept up to 6 numeric characters
     */


    @Test(dependsOnMethods = {"shouldNotBeAbleToInputSpecialCharactersInPriceField"})
    public void shouldAbleToInputNumericCharactersInDownPaymentField() {
        //1.  Enter 1 in the Down Payment field
        calculatePaymentPage.setDownPaymentInput("1");
        //2.  Enter 12 in the Down Payment field
        calculatePaymentPage.setDownPaymentInput("12");
        //3.  Enter 123 in the Down Payment field
        calculatePaymentPage.setDownPaymentInput("123");
        //4.  Enter 1234 in the Down Payment field
        calculatePaymentPage.setDownPaymentInput("1234");
        //5.  Enter 12345 in the Down Payment field
        calculatePaymentPage.setDownPaymentInput("12345");
        //6.  Enter 123456 in the Down Payment field
        calculatePaymentPage.setDownPaymentInput("123456");
        //7.  Enter 1234567 in the Down Payment field
        calculatePaymentPage.setDownPaymentInput("1234567");
        //6.  Enter 12345678 in the Down Payment field
        calculatePaymentPage.setDownPaymentInput("12345678");

    }


    /**
     * TEST #8:
     * The Down Payment field should only accept numeric characters
     */


    @Test(dependsOnMethods = {"shouldAbleToInputNumericCharactersInDownPaymentField"})
    public void shouldNotBeAbleToInputAlphaCharactersInDownPaymentfield() {
        //1. Enter B in the Down Payment Field
        calculatePaymentPage.setDownPaymentInput("B");
        //2. Enter z in the Down Payment Field
        calculatePaymentPage.setDownPaymentInput("z");
    }

    @Test(dependsOnMethods = {"shouldNotBeAbleToInputDownPaymentField"})
    public void shouldNotBeAbleToInputSpecialCharactersInDownPaymentField() throws InterruptedException {
        //1. Enter + in the Down Payment Field
        calculatePaymentPage.setDownPaymentInput("+");
        //2. Enter = in the Down Payment Field
        calculatePaymentPage.setDownPaymentInput("=");
        //3. Enter @ in the Down Payment Field
        calculatePaymentPage.setDownPaymentInput("@");
        //4. Enter * in the Down Payment Field
        calculatePaymentPage.setDownPaymentInput("*");
        //5. Enter $ in the Down Payment Field
        calculatePaymentPage.setDownPaymentInput("$");
        Thread.sleep(4000);
    }


    /**
     * TEST #9:
     * The Trade-In Value field should accept up to 6 numeric characters
     */


    @Test
    public void shouldAbleToInputNumericCharactersInTradeInValueField() {

//1.  Enter 1 in the Trade-In Value field
//2.  Enter 12 in the Trade-In Value field
//3.  Enter 123 in the Trade-In Value field
//4.  Enter 1234 in the Trade-In Value field
//5.  Enter 12345 in the Trade-In Value field
//6.  Enter 123456 in the Trade-In Value field
//7.  Enter 1234567 in the Trade-In Value field
//6.  Enter 12345678 in the Trade-In Value field
//6.  Enter 12345678 in the Trade-In Value field

    }


    /**
     * TEST #10:
     * The Trade-In Value field should only accept numeric characters
     */

    @Test

    public void shouldNotBeAbleToInputAlphaCharactersInTradeInValueField() {
//1. Enter B in the Trade-In Value field
//2. Enter z in the Trade-In Value field
    }

    @Test
    public void shouldNotBeAbleToInputSpecialCharactersInTradeInValueField() {
//1. Enter + in the Down Payment Field
//2. Enter = in the Down Payment Field
//3. Enter @ in the Down Payment Field
//4. Enter * in the Down Payment Field
//5. Enter $ in the Down Payment Field
    }


    /**
     * TEST #11:
     * The Amount Owed on Trade field should accept up to 6 numeric characters
     */


    @Test
    public void shouldAbleToInputNumericCharactersInAmountOwedOnTradeField() {

//1.  Enter 1 in the Amount Owed on Trade field
//2.  Enter 12 in the Amount Owed on Trade field
//3.  Enter 123 in the Amount Owed on Trade field
//4.  Enter 1234 in the Amount Owed on Trade field
//5.  Enter 12345 in the Amount Owed on Trade field
//6.  Enter 123456 in the Amount Owed on Trade field
//7.  Enter 1234567 in the Amount Owed on Trade field
//6.  Enter 12345678 in the Amount Owed on Trade field
//6.  Enter 12345678 in the Amount Owed on Trade field

    }


    /**
     * TEST #12:
     * The Amount Owed on Trade field should only accept numeric characters
     */

    @Test

    public void shouldNotBeAbleToInputAlphaCharactersInAmountOwedOnTradeField() {
//1. Enter B in the Trade-In Value field
//2. Enter z in the Trade-In Value field
    }

    @Test
    public void shouldNotBeAbleToInputSpecialCharactersInAmountOwedOnTradeField() {
//1. Enter + in the Down Payment Field
//2. Enter = in the Down Payment Field
//3. Enter @ in the Down Payment Field
//4. Enter * in the Down Payment Field
//5. Enter $ in the Down Payment Field
    }


    /**
     * TEST #13:
     * Selecting the Reset Button should set all values to 0.
     */

    @Test
    public void shouldSeeZeroValueWhenResetButtonIsSelected() {


        //1. Select the Reset button.
        //2. Verify Interest rate= 0.0
        //3. Verify Price= 0
        //4. Verify Down Payment= 0
        //5.  Verify Trade-In Value= 0
        //6. Verify Amount Owed in Trade=0
    }


    /**
     * TEST #14:
     * When '24' months is selected, user should be able to Calculate a payment.
     */

    @Test
    public void shouldCalculatePaymentWhen24MonthsIsSelected() {


        //1. Select '24'
        //2. Enter 7 in the Interest Rate field
        //3. Enter 25000 in the Price field.
        //4. Enter 1500 in the Down Payment Field.
        //5. Inter 3000 in the Trade in Value field.
        //6.  Enter 593.86 in the Amount owed on Trade field.
        //7.  Select the Calculate button.
        //8.  Verify that Estimated Payment - $945 / month for 24 months at 7.0%.


        //1. Select '36'
        //2. Enter 4 in the Interest Rate field
        //3. Enter 35000 in the Price field.
        //4. Enter 2500 in the Down Payment Field.
        //5. Inter 2000 in the Trade in Value field.
        //6.  Enter 593.86 in the Amount owed on Trade field.
        //7.  Select the Calculate button.
        //8.  Verify that Estimated Payment - $919 / month for 36 months at 4.0%.


        //1. Select '48'
        //2. Enter 5 in the Interest Rate field
        //3. Enter 45000 in the Price field.
        //4. Enter 3500 in the Down Payment Field.
        //5. Inter 3000 in the Trade in Value field.
        //6.  Enter 593.86 in the Amount owed on Trade field.
        //7.  Select the Calculate button.
        //8.  Verify that Estimated Payment - $901 / month for 48 months at 5.0%.


        //1. Select '60'
        //2. Enter 6 in the Interest Rate field
        //3. Enter 55000 in the Price field.
        //4. Enter 4500 in the Down Payment Field.
        //5. Inter 4000 in the Trade in Value field.
        //6.  Enter 593.86 in the Amount owed on Trade field.
        //7.  Select the Calculate button.
        //8.  Verify that Estimated Payment - $911 / month for 60 months at 6.0%.


        //1. Select '72'
        //2. Enter 8 in the Interest Rate field
        //3. Enter 65000 in the Price field.
        //4. Enter 5500 in the Down Payment Field.
        //5. Inter 5000 in the Trade in Value field.
        //6.  Enter 593.86 in the Amount owed on Trade field.
        //7.  Select the Calculate button.
        //8.  Verify that Estimated Payment - $966 / month for 72 months at 8.0%.


    }
}



