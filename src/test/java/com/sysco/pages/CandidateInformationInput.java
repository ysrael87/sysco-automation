package com.sysco.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CandidateInformationInput {

	public void firstName(WebDriver driver, String firstName) {
		try {
			driver.findElement(By.name("FirstName")).sendKeys(firstName);
			System.out.println("First name input successful");
		} catch (Exception e) {
			System.out.println("Failed to input first name ");
			e.printStackTrace();
		}
	}

	public void lastName(WebDriver driver, String lastName) {
		try {
			driver.findElement(By.name("LastName")).sendKeys("Doe");
			System.out.println("Last name input successful");
		} catch (Exception e) {
			System.out.println("Failed to input last name");
			e.printStackTrace();
		}
	}

	public void email(WebDriver driver, String email) {
		try {
			driver.findElement(By.name("EmailAddress")).sendKeys(email);
			System.out.println("Email adress input successful");
		} catch (Exception e) {
			System.out.println("Failed to input email adress");
			e.printStackTrace();
		}
	}

	public void state(WebDriver driver, String state) {
		try {
			driver.findElement(By.name("Region")).sendKeys(state);
			System.out.println("State input successfsul");
		} catch (Exception e) {
			System.out.println("Fail to input state");
			e.printStackTrace();
		}
	}

	public void zipcode(WebDriver driver, String zipcode) {
		try {
			driver.findElement(By.name("PostalCode")).sendKeys(zipcode);
			System.out.println("Zipcode input successful");
		} catch (Exception e) {
			System.out.println("Failed to input Zipcode");
			e.printStackTrace();
		}
	}

	public void primaryTelephoneNumber(WebDriver driver, String primaryTelephoneNumber) {
		try {
			driver.findElement(By.name("HomePhone")).sendKeys(primaryTelephoneNumber);
			System.out.println("Primary Telphone number input successful");
		} catch (Exception e) {
			System.out.println("Failed primary telephone number input");
			e.printStackTrace();
		}
	}

	public void TextMessageOptInButtonNo(WebDriver driver) {
		try {
			driver.findElement(By.xpath("//div//fieldset[2]/p[2]/input")).click();
			System.out.println("Text message opt in button was successfully clicked, option No ");
		} catch (Exception e) {
			System.out.println("Failed to click No in text message opt in button");
			e.printStackTrace();
		}
	}

	public void mobileCarrier(WebDriver driver, String MobileCarrier) {
		try {
			driver.findElement(By.name("Skills")).sendKeys(MobileCarrier);
			System.out.println("Mobile carrier input was succesful");
		} catch (Exception e) {
			System.out.println("Failed to input mobile carrier");
			e.printStackTrace();
		}
	}

	public void AreYouCurrently21YearsOfAgeYes(WebDriver driver) {
		try {
			driver.findElement(By.xpath("//div//fieldset[3]/p[1]/input")).click();
			System.out.println("Successfully clicked yes to over 21");
		} catch (Exception e) {
			System.out.println("Failed in clicking yes to over 21");
			e.printStackTrace();
		}
	}

	public void LicenseTypeHeldDropDown(WebDriver driver) {
		try {
			Select LicenseTypeHeldDropDown = new Select(driver.findElement(By.cssSelector(".form-field>select")));
			List<WebElement> options = LicenseTypeHeldDropDown.getOptions();
			int size = options.size();

			for (int i = 0; i < size; i++) {
				String optionsName = LicenseTypeHeldDropDown.getOptions().get(i).getText();
				System.out.println(optionsName);
			}

			LicenseTypeHeldDropDown.selectByValue("Regular Driver’s License");
			System.out.println("Succesfully clicked Regular Driver's License");
		} catch (Exception e) {
			System.out.println("Failed at clicking Regular Driver's License");
			e.printStackTrace();
		}
	}

	public void totalMonthsOfDrivingExperience(WebDriver driver, String experienceDrivingHours) {
		try {
			driver.findElement(By.xpath("//label[text()='Total Months of Driving Experience']")).sendKeys(experienceDrivingHours);
			System.out.println("Successfully input total driving experience in hours");
		} catch (Exception e) {
			System.out.println("Failed to input total hours of driving experience");
			e.printStackTrace();
		}
	}

	public void NextButton(WebDriver driver) {
		try {
			driver.findElement(By.xpath("//div/div[2]/p[2]/input")).click();
			System.out.println("Successfully clicked next button");
		} catch (Exception e) {
			System.out.println("Failed at clicking next button");
			e.printStackTrace();
		}
	}

}
