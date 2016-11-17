package com.autotrader.mdot.testsuites;

import java.io.File;
import java.net.URL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;

/**
 * Created by mali1 on 10/8/2015.
 */
public class TestExtension {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    protected String baseUrl;

    protected DesiredCapabilities capability;
    protected WebDriver driver;
    protected String userName;
    protected String userPassword;

    //~ Methods --------------------------------------------------------------------------------------------------------

    @BeforeClass(alwaysRun = true)
    @org.testng.annotations.Parameters(value =
            {
                "browserName", "browser_version", "baseUrl", "local", "testGroup",
                "os", "os_version", "resolution", "bsAccount", "bsLocal", "project", "userName", "userPassword",
                "platformName", "device", "udid", "platformVersion"
            })
    public void setUp(@Optional("browserName") String browserName,
            @Optional("version") String browser_version,
            @Optional("baseUrl") String baseUrl,
            @Optional("local") String local,
            @Optional("testGroup") String testGroup,
            @Optional("os") String os,
            @Optional("os_version") String os_version,
            @Optional("resolution") String resolution,
            @Optional("bsAccount") String bsAccount,
            @Optional("bsLocal") String bsLocal,
            @Optional("project") String project,
            @Optional("userName") String userName,
            @Optional("userPassword") String userPassword,
            @Optional("platformName") String platformName,
            @Optional("device") String device,
            @Optional("udid") String udid,
            @Optional("platformVersion") String platformVersion) throws Exception {
        if (local.equals("false")) {
            capability = new DesiredCapabilities();
            capability.setCapability("browserName", browserName);
            capability.setCapability("browser_version", browser_version);
            capability.setCapability("project", "Mobile Tests Road Show");
            capability.setCapability("build", "1.0");
            capability.setCapability("browserstack.debug", "true");
            capability.setCapability("browserstack.local", bsLocal);
            capability.setCapability("os", os);
            capability.setCapability("os_version", os_version);
            capability.setCapability("resolution", resolution);
            capability.setCapability("platformName", platformName);
            capability.setCapability("device", device);
            capability.setCapability("platformVersion", platformVersion);
            capability.setCapability("autoAcceptAlerts", "true");
            driver = new RemoteWebDriver(new URL(bsAccount), capability);
        }else if(local.equals("appium")){
            capability = new DesiredCapabilities();
            capability.setCapability("deviceName", device);
            capability.setCapability("platformName", platformName);
            capability.setCapability("platformVersion", platformVersion);
            capability.setCapability("browserName", browserName);
            capability.setCapability("udid", udid);
            driver = new AndroidDriver(new URL(bsAccount), capability);
        } else{
            driver = new ChromeDriver();
            capability = new DesiredCapabilities();
            capability.setCapability("browserName", "chrome");
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.baseUrl = baseUrl;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    /**
     * TODO: Enter Javadoc
     */
    @AfterClass(alwaysRun = true)
    public void teardown() throws Exception{
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd hh mm a");
        Date date = new Date();
        FileUtils.copyFile(screenshot,
                new File("c:\\tmp\\" + capability.getBrowserName() + " " + dateFormat.format(date) + ".png"));
        driver.quit();
    }
}
