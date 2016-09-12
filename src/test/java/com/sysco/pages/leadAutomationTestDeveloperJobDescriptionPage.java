package com.sysco.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class leadAutomationTestDeveloperJobDescriptionPage {
	
	public void applyNowdleadAutomationTestDeveloper(WebDriver driver){ 
		
		try {
			driver.findElement(By.xpath("//div[1]/a[1]/span")).click();
			System.out.println("Apply now button for lead automation test developer clicked successfully");
		} catch (Exception e) {
			System.out.println("Failed to click apply now button for lead automation test developer");
			e.printStackTrace();
		}
	}

}
