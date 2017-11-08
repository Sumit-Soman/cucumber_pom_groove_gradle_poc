package driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import util.Property;

/*
 Driver Class to get driver according to browser
 */
public class DriverFactory {

    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static int waitTime = 40;
    public static int pageLoadTimeOut = 40;

    public static Platform currentOS = Platform.getCurrent();
    public static Properties configData;

    public static void createDriver(Properties config, boolean internal) {
        configData = config;
        String URL = "";
        if (internal) {
            URL = "URLinternal";
        } else {
            URL = "URLexternal";
        }
        createDriver(configData.getProperty("browser"));
        OpenURL(configData.getProperty(URL), internal);
        
        System.out.println("Test Type : " + System.getProperty("test.type"));
        System.out.println("Test.env : " + System.getProperty("test.env"));
        System.out.println("Test.app : " + System.getProperty("test.app"));
        System.out.println("Browser = " + configData.getProperty("browser"));
        System.out.println("Platform = " + currentOS);
        System.out.println("URL = " + configData.getProperty("baseURL"));
    }

    public static void createDriver(final String browserId) {
        if (browserId.equalsIgnoreCase("firefox")) {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("browser.download.folderList",2);
            profile.setPreference("browser.download.manager.showWhenStarting",false);
            profile.setPreference("browser.download.dir",Property.exportExcelPath);
            profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/x-msexcel,application/excel,application/x-excel,application/excel,application/x-excel,application/excel,application/vnd.ms-excel,application/x-excel,application/x-msexcel");
            profile.setPreference("browser.download.manager.showWhenStarting", false);
            profile.setPreference("browser.download.manager.focusWhenStarting", false);
            profile.setPreference("browser.helperApps.alwaysAsk.force", false);
            profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
            profile.setPreference("browser.download.manager.closeWhenDone", false);
            profile.setPreference("browser.download.manager.showAlertOnComplete", false);
            profile.setPreference("browser.download.manager.useWindow", false);
            profile.setPreference("browser.download.manager.showWhenStarting", false);
            profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
            profile.setPreference("pdfjs.disabled", true);
            
            driver = new FirefoxDriver(profile);
        }
    }

    public static void OpenURL(String baseURL, boolean internal) {
        driver.manage().window().maximize();
        driver.get(baseURL);
        wait = new WebDriverWait(driver, waitTime);
        driver.manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

	public static void saveScreen(Scenario scenario) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String date = new SimpleDateFormat("MM-dd-yyyy").format(new Date()).toString();
        String filename =  Property.screenShotPath + scenario.getName() + File.separator + date + ".jpg";
        try {
            FileUtils.copyFile(src, new File(filename));
         } catch (IOException ex) {
            System.out.println(ex);
        }
    	  // Take a screenshot...
//	     try{
//    	  final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//	      scenario.embed(screenshot, "image/png");
//	      scenario.write("<a href='"+filename+">Screenshot</a>");
//	     }catch(Exception  e){
//	    	 System.out.println(e);
//	     }

    }

}