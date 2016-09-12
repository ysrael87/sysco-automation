package com.sysco.framework;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import com.sysco.framework.ReadProperties;



/**
 * Created by ysrael on 09/11/2016.
 */

public class WebApp {
    /* WebDriver variables */
    private static WebDriver driver = null;
    private static WebApp instance = null;
    private static final int timeout = 50;
    private static final String pageLoadedText = "sysco";


    /* Logging variables */
	
   private static final Logger log = LogManager.getLogger(WebApp.class);

    /* Properties */
    
    private static Properties props = ReadProperties.getProperties();
    private static final String url = props.getProperty("url");
    
    
  

    /* Private constructor - only one instance possible for this class */
   private WebApp() {
        instance = this;
    }

    public static WebApp getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new WebApp();
            return instance;
        }
    }

    public static String getBaseUrl() {
        return url;
    }

    public static WebDriver initializeDriver() {
        if (driver != null) {
            driver.quit();
        }

        String browser = props.getProperty("browser.name");
        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
            	System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("unrecognized browser");
                System.exit(0);
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        log.info("Launching application with url::"+url);
        driver.get(url);
        
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = initializeDriver();
        }
        return driver;
    }


   

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
           
        }
    }
    
    
    @AfterClass(alwaysRun=true)
    protected void finalize() throws Throwable {
        quitDriver();
        super.finalize();
    }

    public static void resetDriver() {
        driver = getDriver();
        driver.manage().deleteAllCookies();
        driver.get(url);
    }

    
    public static void safeSleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return;
    }
}
