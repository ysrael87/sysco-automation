package com.sysco.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class careersPage {
	
	public void textJobSearch(WebDriver driver,String jobName ){
		try {
			//searching and clicking for lead automation test developer
			driver.findElement(By.className("search-keyword")).clear();
			driver.findElement(By.className("search-keyword")).sendKeys(jobName);
			System.out.println("Job search succesfull");
		} catch (Exception e) {
			System.out.println("Failed to send text to job search");
			e.printStackTrace();
		}
	}
	
	public void clickSeachButton(WebDriver driver){
		try {
			driver.findElement(By.xpath("//div[@class='search-form-fields']/button")).click();
		} catch (Exception e) {
			System.out.println("failed to click search button for job search ");
			e.printStackTrace();
		}
	}
	
}
