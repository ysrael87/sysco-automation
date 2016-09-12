package com.sysco.pages;

import java.io.File;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sysco.framework.WebApp;
import com.sma.utils.Utility;

public class UploadPage {
	
	private WebDriver driver;
	 /* Logging variables */
    private static final Logger log = LogManager.getLogger(UploadPage.class);

	public UploadPage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".navbar-brand>img")
	private WebElement homePageImg;
	
	@FindBy(id="file-upload")
	private WebElement browserButton;
	
	@FindBy(css="th.gx_extra_headers:nth-child(4) > div:nth-child(1) > input:nth-child(2)")
	private WebElement searchFileTextBox;
	
	@FindBy(xpath=".//*[@id='file-upload-table']/tbody/tr/td[2]/div")
	private WebElement uploadSuccessMsg;
	
	@FindBy(id="close-upload-progress")
	private WebElement closeUploadModel;
	
	
	@FindBy(css=".spaced.filename.ng-binding")
	private List<WebElement> fileNamesInList;
	
	
	@FindBy(css="input.file-checkbox")
	private List <WebElement> selectFileCheckBx;
	
	
	@FindBy(css="#analyze-dropdown-btn")
	private WebElement reportDropDown;
	
	
	@FindBy(css="#file-reports-dropdown-btn")
	private WebElement fileReportDropDown;
	
	@FindBy(xpath=".//*[@id='analyze-dropdown-list']/li[1]/a")
	private WebElement quickStratsReportDropDownLink;
	
	@FindBy(xpath=".//*[@id='analysis-file-name']/span")
	private WebElement quickStratsReportHeader;
	
	//@FindBy(xpath="//a[text()='Quick Strats with models']")
	//private WebElement qucikStratsWithModelDropdownLink;
	
	@FindBy(xpath=".//*[@id='analyze-dropdown-list']/li[2]")
	private WebElement qucikStratsWithModelDropdownLink;
	
	
	
	@FindBy(xpath=".//*[@id='modal-undefined-label']")
	private WebElement quickStratsModelHeader;
	
	@FindBy(css="a.btn:nth-child(2)")
	private WebElement selectModelsButton;
	
	@FindBy(xpath="//*[@id='btn-container']/div[3]/a[text()='Refresh models']")
	private WebElement refreshModelButton;
	
	public boolean isHomePageLogoDisplayed(){
		return homePageImg.isDisplayed();
	}
	
	public void switchToHomePage(){
		Utility.waitForElementPresent(driver, homePageImg);
		homePageImg.click();
	}
	
	public Boolean verifyFileUpload(String path){
		log.info("Uploading file with path:"+path);
		File f=new File(path);
		boolean ret=true;
		ret=ret && homePageImg.isDisplayed();
		log.info("File AbsolutePath::"+f.getAbsolutePath());
		browserButton.sendKeys(f.getAbsolutePath());
		log.info("Uploading file done");
		Utility.waitForSeconds(5);
		Utility.waitForElementPresent(driver, uploadSuccessMsg);
		ret=ret && uploadSuccessMsg.getText().contains("Upload successful");
		closeUploadModel.click();
		return ret;
		
	}
	
	public void searchFileInListPage(String fileName){
		Utility.waitForElementPresent(driver, searchFileTextBox);
		searchFileTextBox.clear();
		searchFileTextBox.sendKeys(fileName);
	}
	
	public String verifyCreatedFileInListPage(String fileName){
		Utility.waitForElementPresent(driver, fileNamesInList.get(0));
		return fileNamesInList.get(0).getText();	
	}
	
	public String viewQuickStratsReport(){
		selectFileCheckBx.get(0).click();
		Utility.waitForElementPresent(driver, reportDropDown);
		reportDropDown.click();
		quickStratsReportDropDownLink.click();
		Utility.waitForSeconds(3);
		Utility.waitForElementPresent(driver, quickStratsReportHeader);
		System.out.println("texxtxt:::"+quickStratsReportHeader.getText());
		return quickStratsReportHeader.getText();	
	}
	
	public Boolean viewQuickStratsWithModelReport(int value){
		switchToHomePage();
		selectFileCheckBx.get(0).click();
		Boolean ret=true;
		Utility.waitForElementPresent(driver, reportDropDown);
		reportDropDown.click();
		Utility.waitForElementPresent(driver, qucikStratsWithModelDropdownLink);
		qucikStratsWithModelDropdownLink.click();
		Utility.waitForElementPresent(driver, quickStratsModelHeader);
		ret=ret && quickStratsModelHeader.isDisplayed();
		//select simple on the fly option
		driver.findElement(By.xpath("//input[@value='" + value + "']")).click();
		selectModelsButton.click();
		Utility.waitForElementPresent(driver, refreshModelButton);
		return refreshModelButton.isDisplayed();	
	}
	
	public void resetServer(){
		driver.get("http://54.209.93.83:8011/reset");
		driver.get("http://54.209.93.83:8011/restart");
		}
}
