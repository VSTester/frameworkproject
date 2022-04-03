package com.policybazaar.qa.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.policybazaar.qa.webUtil.TestUtil;

import lombok.Getter;




//    ** We Create this class for Store every page class locators   **  //
@Getter
public class PolicyBazaarQuotesPageObjectRepo   {

	
	
//  ** it is a feature provided by selenium. we use this as a driver.findElement(By.locator);  **   //
	@FindBy (xpath = "//a[@class='close ng-star-inserted']")
	protected WebElement QuotesCloseBtn;
	
	
	@FindBy (xpath = "//select[@name='tobacco']")
	protected WebElement tobaccoDropDown;
	
	
	@FindBy (xpath = "//ul[@planid='11057']//div//button")
    protected WebElement QuotesSbiPaymentBtn;
	
	
	
	
	//**////////***///////***/////***///////
	
	
	
	
	@FindBy(xpath = "//input[@id='txtCustomerAge']")
	protected WebElement invCustomerAgeEd;
	
	@FindBy(xpath = "//input[@id='txtCity']")
	protected WebElement invCustomerCityEd;
	
	@FindBy(xpath = "//button[@class='ripple ng-tns-c96-2']")
	protected WebElement invContinueBtn;
	
	@FindBy(xpath = "//div[@id='stickyHeader']//li[@class='ng-tns-c119-0'][last()]//span")
	protected WebElement invHeader;
	
	
	
	/*
	 * We Create constructor of this class under this we use pageFactory class
	 * method. It is initElements for initialize all @FindBy and @FindBys locator
	 */ 
	
public PolicyBazaarQuotesPageObjectRepo(TestUtil util) {
		PageFactory.initElements(util.getDriver(),this);
	}
}
