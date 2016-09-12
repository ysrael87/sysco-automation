package com.sysco.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class searchJobsPage {

		public void clickLeadAutomationTestDeveloper(WebDriver driver){
			//searching and clicking for lead automation test developer
			try{
			driver.findElement(By.xpath("//div[1]//li[1]/a/h2")).click();
			System.out.println("Succesfully clicked lead automation test developer");
			}
			catch(Exception e){
				System.out.println("leadAutomationTestDeveloper failed");
			}
			

}
}
