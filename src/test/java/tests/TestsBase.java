package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;



public class TestsBase extends AbstractTestNGCucumberTests {
    AppiumDriver driver;

    @BeforeTest
    public AppiumDriver setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("platformVersion","12");
        caps.setCapability("deviceName","Android Emulator");
        caps.setCapability("app",System.getProperty("user.dir")+"/apps/app-debug.apk");
        //set this capability to simulate Slow Internet Connection
        caps.setCapability("networkSpeed", "lte");
        return driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
    }
    public void waitForVisibility(WebElement element) {
        Duration waitTimeout = Duration.ofSeconds(5);
        driver.manage().timeouts().implicitlyWait(waitTimeout);
        WebDriverWait wait = new WebDriverWait(driver, waitTimeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
