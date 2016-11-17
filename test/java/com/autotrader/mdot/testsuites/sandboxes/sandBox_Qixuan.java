package com.autotrader.mdot.testsuites.sandboxes;

import com.autotrader.mdot.pages.FYC.*;
import com.autotrader.mdot.pages.misc.*;
import com.autotrader.mdot.testsuites.TestExtension;
import com.autotrader.mdot.utilities.mDotElements;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import sun.management.HotspotMemoryMBean;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

/**
 * Created by qhou on 9/29/2015.
 */
public class sandBox_Qixuan extends TestExtension {

    HomeMainPage homeMainPage;
    LocationAndRadiusSliderPage locationAndRadiusSliderPage;
    NewUsedCertifiedSliderPage newUsedCertifiedSliderPage;
    StyleSliderPage styleSliderPage;
    YearMakeModelTrimSliderPage yearMakeModelTrimSliderPage;
    MoreOptionsSliderPage moreOptionsSliderPage;
    SearchResultsLandingPage searchResultsLandingPage;
    SignInPage signInPage;
    FiltersSliderPage filtersSliderPage;
    VehicleDetailsPage vehicleDetailsPage;
    ResearchPage researchPage;
    SellerInfoPage sellerInfoPage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        homeMainPage = new HomeMainPage(driver);
        locationAndRadiusSliderPage = new LocationAndRadiusSliderPage(driver);
        newUsedCertifiedSliderPage = new NewUsedCertifiedSliderPage(driver);
        styleSliderPage = new StyleSliderPage(driver);
        yearMakeModelTrimSliderPage = new YearMakeModelTrimSliderPage(driver);
        moreOptionsSliderPage = new MoreOptionsSliderPage(driver);
        searchResultsLandingPage = new SearchResultsLandingPage(driver);
        filtersSliderPage = new FiltersSliderPage(driver);
        vehicleDetailsPage = new VehicleDetailsPage(driver);
        signInPage = new SignInPage(driver);
        researchPage = new ResearchPage(driver);
        sellerInfoPage = new SellerInfoPage(driver);
    }

}


