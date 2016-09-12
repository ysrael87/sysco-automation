package com.sysco.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class candidateCardPage {
	
	public void pageCheck(WebDriver driver){
	try {
		String candidatePageTitle = driver.getTitle();
		System.out.println(candidatePageTitle);
		Assert.assertEquals("Candidate Card", candidatePageTitle);
		System.out.println("Page title verification successful");
		
	} catch (Exception e) {
		System.out.println("Pager title assertion failed");
		e.printStackTrace();
	}
	}
}
