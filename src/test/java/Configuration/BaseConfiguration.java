package Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseConfiguration {
    protected WebDriver driver;

    @BeforeSuite
    @Parameters({"browser", "nodeUrl"})
    public void setUp(@Optional("chrome") String browser, @Optional("http://192.168.1.5:4444/wd/hub") String nodeUrl) throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new RemoteWebDriver(new URL(nodeUrl), options);
                break;

            case "firefox":
            	//Set any desired options for Firefox
                DesiredCapabilities firefoxCaps = DesiredCapabilities.firefox();
                driver = new RemoteWebDriver(new URL(nodeUrl), firefoxCaps);


                break;

            case "ie":
                //Set any desired options for Internet Explorer
                DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
                driver = new RemoteWebDriver(new URL(nodeUrl), ieCaps);
                
                break;

            default:
                throw new IllegalArgumentException("Invalid browser name: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
