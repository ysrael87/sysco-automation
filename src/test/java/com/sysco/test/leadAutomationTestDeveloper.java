package com.sysco.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sma.utils.Utility;
import com.sysco.framework.WebApp;







public class leadAutomationTestDeveloper {
	static WebDriver driver;
	private String baseUrl;
	

	@BeforeClass
	public void initDriver() {
		driver = new FirefoxDriver();
		baseUrl = "http://www.sysco.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void mikeDoe() {
		driver.get(baseUrl);
		
		
		com.sysco.pages.HomePage homepage = new com.sysco.pages.HomePage();
		homepage.careersButton(driver);
		com.sysco.pages.careersPage careerspage = new com.sysco.pages.careersPage();
		careerspage.textJobSearch(driver, "Lead Automation Test Developer");
		careerspage.clickSeachButton(driver);
		com.sysco.pages.searchJobsPage searchjobspage = new com.sysco.pages.searchJobsPage();
		searchjobspage.clickLeadAutomationTestDeveloper(driver);
		com.sysco.pages.leadAutomationTestDeveloperJobDescriptionPage leadautomationtestdeveloper = new com.sysco.pages.leadAutomationTestDeveloperJobDescriptionPage();
		leadautomationtestdeveloper.applyNowdleadAutomationTestDeveloper(driver);
		com.sysco.pages.CandidateInformationInput candidateinformationinput = new com.sysco.pages.CandidateInformationInput();
		candidateinformationinput.firstName(driver, "Mike");
		candidateinformationinput.lastName(driver, "Doe");
		candidateinformationinput.email(driver, "MikeDoe@doesnotexist.com");
		candidateinformationinput.state(driver, "TX");
		candidateinformationinput.zipcode(driver, "77077");
		candidateinformationinput.primaryTelephoneNumber(driver, "2819999999");
		candidateinformationinput.TextMessageOptInButtonNo(driver);
		candidateinformationinput.mobileCarrier(driver, "AT&T");
		candidateinformationinput.AreYouCurrently21YearsOfAgeYes(driver);
		candidateinformationinput.LicenseTypeHeldDropDown(driver);
		candidateinformationinput.totalMonthsOfDrivingExperience(driver, "120");
		candidateinformationinput.NextButton(driver);
		com.sysco.pages.candidateCardPage candidatecardpage = new com.sysco.pages.candidateCardPage();
		candidatecardpage.pageCheck(driver);
		System.out.println("Scenario1 testcase successful");
		

	}
	
	
	@AfterClass
	public void quitDriver() {
		driver.quit();
	}
	

}
