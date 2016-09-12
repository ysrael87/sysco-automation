package com.sysco.test;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class leadPerformanceTest_QA {
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
	public void susanDoe() {
		driver.get(baseUrl);
		
		com.sysco.pages.HomePage homepage = new com.sysco.pages.HomePage();
		homepage.careersButton(driver);
		com.sysco.pages.careersPage careerspage = new com.sysco.pages.careersPage();
		careerspage.textJobSearch(driver, "Lead Performance Test- QA");
		careerspage.clickSeachButton(driver);
		com.sysco.pages.searchJobsPage searchjobspage = new com.sysco.pages.searchJobsPage();
		searchjobspage.clickLeadAutomationTestDeveloper(driver);
		com.sysco.pages.leadPerformanceTestQAJobDescriptionPage leadperformancetestQA = new com.sysco.pages.leadPerformanceTestQAJobDescriptionPage();  
		leadperformancetestQA.applyNowdleadPerformanceQA(driver);
		com.sysco.pages.CandidateInformationInput candidateinformationinput = new com.sysco.pages.CandidateInformationInput();
		candidateinformationinput.firstName(driver, "Susan");
		candidateinformationinput.lastName(driver, "Doe");
		candidateinformationinput.email(driver, "SusanDoe@doesnotexist.com");
		candidateinformationinput.state(driver, "TX");
		candidateinformationinput.zipcode(driver, "77077");
		candidateinformationinput.primaryTelephoneNumber(driver, "8329999999");
		candidateinformationinput.TextMessageOptInButtonNo(driver);
		candidateinformationinput.mobileCarrier(driver, "Verizon");
		candidateinformationinput.AreYouCurrently21YearsOfAgeYes(driver);
		candidateinformationinput.LicenseTypeHeldDropDown(driver);
		candidateinformationinput.totalMonthsOfDrivingExperience(driver, "120");
		candidateinformationinput.NextButton(driver);
		com.sysco.pages.candidateCardPage candidatecardpage = new com.sysco.pages.candidateCardPage();
		candidatecardpage.pageCheck(driver);
		System.out.println("Scenario2 testcase successful");
	}

	@AfterClass
	public void quitDriver() {
		driver.quit();
	}
}
