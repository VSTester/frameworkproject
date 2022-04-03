package com.policybazaar.qa.objectrepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.policybazaar.qa.objectrepositorycommon.PolicyBazaarCommonObjectRepo;
import com.policybazaar.qa.webUtil.TestUtil;

import lombok.Getter;
@Getter
public class PolicyBazaarYourDetailPageObjectRepo extends PolicyBazaarCommonObjectRepo  {

	@FindBy(xpath = "//img[@alt='Client Logo']")
	private WebElement productLogo;
	
	@FindBy(id = "lifeCoverSection")
	private WebElement lifeCoverRd;
	
	 @FindBys(@FindBy(xpath  = "//ul[@id='rdoBasicSumAssured']//li"))
	 private List<WebElement> lifeCoverRdBtn;
	 
	 
	 @FindBy(xpath = "//select[@id='PolicyTerm']")
	private WebElement coverTillAgeDd;
	 
	 @FindBy(xpath = "//select[@id='PremiumPayingTerm']")
	 private WebElement payForAgeDd;
	 
	 @FindBy(id = "ModeOfPremium")
	 private WebElement premiumModeDd;
	 
	 
	 @FindBy(id = "FirstName")
	 private WebElement fullNameEd;
	 
	@FindBy(id = "Email")
	private WebElement emailEd;
	
	@FindBy(id = "AnnualIncome")
	private WebElement annoualIncomeEd;
	
	@FindBy(id = "Occupation")
	private WebElement OccupationDd;
	
	@FindBy(id = "Education")
	private WebElement educationDd;
	

	
	
	
	
	
public PolicyBazaarYourDetailPageObjectRepo(TestUtil util) {
		PageFactory.initElements(util.getDriver(),this);
	}
}
