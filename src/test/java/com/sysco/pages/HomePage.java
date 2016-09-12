package com.sysco.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	public void careersButton(WebDriver driver){
		try {
			driver.findElement(By.xpath(".//*[@id='item5']/a")).click();
			//String careersTitle = driver.getTitle();
			System.out.println("Careers butont clicked Succesfully");
		} catch (Exception e) {
			System.out.println("failed to click Careers button succesfully");
			e.printStackTrace();
		}
	}
}
