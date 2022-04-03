package com.policybazaar.qa.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.policybazaar.qa.webUtil.TestUtil;

import lombok.Getter;




//    ** We Create this class for Store every page class locators   **  //
@Getter
public class PolicyBazaarPreQuotesPageObjectRepo   {

	
	
//  ** it is a feature provided by selenium. we use this as a driver.findElement(By.locator);  **   //
	@FindBy (xpath = "//input[@id='nameAdd']")
	protected WebElement loginFullNameEd;

	@FindBy (xpath = "//input[@id='mobileNo']")
	protected WebElement loginMobileEd;
	
	@FindBy (id = "dob")
    protected WebElement loginDobEd;
	
	
	@FindBy(id = "submitButton")
	protected WebElement loginVeiwFreeQuotesBtn;
	
	
	
	
	
	
	
	
	
	//***///////////**/////////**///////////
	
	
	@FindBy (xpath = "//input[@id='txtCustomerName']")
	protected WebElement invLoginFullNameEd;

	
	@FindBy (xpath = "//input[@id='txtMobileNo']")
	protected WebElement invLoginMobileEd;
	
	
	@FindBy (xpath = "//input[@id='txtEmail']")
	protected WebElement invLoginEmailEd;
	
	@FindBy(tagName = "button")
	protected WebElement invLoginVeiwFreeQuotesBtn;
	
	
	
	
	/*
	 * We Create constructor of this class under this we use pageFactory class
	 * method. It is initElements for initialize all @FindBy and @FindBys locator
	 */ 
	
public PolicyBazaarPreQuotesPageObjectRepo(TestUtil util) {
		PageFactory.initElements(util.getDriver(),this);
	}
}
