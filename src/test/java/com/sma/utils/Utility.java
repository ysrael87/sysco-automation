package com.sma.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.sysco.framework.*;


public class Utility {
	public static void waitForElementPresent(WebDriver driver, WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * waiting for seconds
	 * 
	 * @param timeoutInSeconds
	 *            timeout in seconds for wait
	 */
	public static void waitForSeconds(int timeoutInSeconds) {
		try {
			Thread.sleep(timeoutInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void CaptureScreenShotAndPutInResult(ITestResult tr) {
		try {
			String parent = Constants.REPORT_SOURCE_PATH;
			//String imgfile = Constants.FAILED_IMAGE_FILE_NAME;
			String imgfile = Constants.SCREENCAPTURE_FOLDER_NAME + new SimpleDateFormat("MM-dd-yyyy_HH-ss-SSS").format(new Date().getTime())+ ".png";
			File scrFile = null;
			scrFile = ((TakesScreenshot) WebApp.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(parent, imgfile));

			String userDirector = System.getProperty("user.dir") + "/";
			// String userDirector = System.getProperty(".") + "/";
			System.out.println((userDirector));
			System.setProperty("org.uncommons.reportng.escape-output", "false");	 
			Reporter.log("<a href=" + imgfile + ">" + "<img src=" + imgfile
					+ " alt=\"\"" + "height='100' width='100'/> " + "<br />");
			Reporter.setCurrentTestResult(null);
		} catch (Exception a) {
			a.printStackTrace();
		}
	}
	
}
