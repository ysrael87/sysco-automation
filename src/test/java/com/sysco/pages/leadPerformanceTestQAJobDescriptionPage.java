package com.sysco.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class leadPerformanceTestQAJobDescriptionPage {
	
	public void applyNowdleadPerformanceQA(WebDriver driver){ 
		
		try {
			driver.findElement(By.xpath("//div[1]/a[1]/span")).click();
			System.out.println("Apply now button for lead performance test_QA clicked successfully");
		} catch (Exception e) {
			System.out.println("Failed to click apply now button for lead performance test_QA");
			e.printStackTrace();
		}
	}

}
