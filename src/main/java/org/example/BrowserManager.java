package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserManager extends BasePage {

    public static final String AUTOMATE_USERNAME = "prag_5lCXPe";
    public static final String AUTOMATE_ACCESS_KEY = "T9bWxLzv28xBw7zH2rnw";
    public static final String BROWSERSTACKURL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    LoadProp loadProp = new LoadProp();
//    public String browserName = "chrome";
//    boolean cloud = false;
    public String browserName = System.getProperty("browser");
    boolean cloud = Boolean.parseBoolean(System.getProperty("cloud"));

    public void openBrowser() {
        DesiredCapabilities caps = new DesiredCapabilities();
        if (cloud) {
            if (browserName.equalsIgnoreCase("chrome")) {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.14.0");
            } else if (browserName.equalsIgnoreCase("edge")) {

                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Edge");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.14.0");
            } else if (browserName.equalsIgnoreCase("firefox")) {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.10.0");

            } else {
                System.out.println("Wrong browser!!!");
            }

            try {
                driver = new RemoteWebDriver(new URL(BROWSERSTACKURL), caps);
            } catch (
                    MalformedURLException e) {
                System.out.println(e);
            }
        } else {
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", "src/test/java/drivers/msedgedriver.exe");
                driver = new ChromeDriver();
            }

        }


        driver.manage().window().maximize();
        driver.get(loadProp.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }


    public void closeBrowser() {
        driver.close();
    }

}
