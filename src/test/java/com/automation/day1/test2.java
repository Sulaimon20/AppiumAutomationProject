package com.automation.day1;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.sql.Driver;

public class test2 {
    private RemoteWebDriver driver;

    @Test
    public void test1() throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", Platform.ANDROID);
        desiredCapabilities.setCapability("platformVersion", "7.0");
        desiredCapabilities.setCapability("deviceName", "Pixel_2");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
        desiredCapabilities.setCapability("w3c", true);

        WebDriverManager.chromedriver().version("2.23").setup();
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, WebDriverManager.chromedriver().getBinaryPath());

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROME_OPTIONS, chromeOptions);

        driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.get("https://login2.nextbasecrm.com/");
        Thread.sleep(5000);

        driver.findElement(By.name("USER_LOGIN")).sendKeys("hr3@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser", Keys.ENTER);

        Thread.sleep(3000);
        String actualTitle = "Portal";
        Assert.assertEquals(driver.getTitle(), actualTitle);


        Thread.sleep(5000);
        driver.quit();

    }
}
