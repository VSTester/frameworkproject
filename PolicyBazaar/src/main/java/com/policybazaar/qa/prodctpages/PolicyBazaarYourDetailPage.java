package com.policybazaar.qa.prodctpages;

import org.openqa.selenium.WebElement;

import com.policybazaar.qa.objectrepository.PolicyBazaarYourDetailPageObjectRepo;
import com.policybazaar.qa.webUtil.TestUtil;

import lombok.Getter;


@Getter
public class PolicyBazaarYourDetailPage extends PolicyBazaarYourDetailPageObjectRepo {
	private TestUtil util;
    private String expectedCoverAmmount = "";
	private String actualCoverAmount = ""; 
	
	public PolicyBazaarYourDetailPage(TestUtil util) {
		super(util);
		this.util = util;
	}

	
	
	
	
	
	


	public PolicyBazaarYourDetailPage selectLifeCoverAmmount() {
		util.clickOnElement(getLifeCoverRd());
		for (WebElement singleLfRdBtn : getLifeCoverRdBtn()) {
			actualCoverAmount = util.getElementAttributeValue(singleLfRdBtn, "Value");
			expectedCoverAmmount = util.getExcelRf().get("Life_Cover_Amount");
			if (actualCoverAmount.equals(expectedCoverAmmount)) {
				util.clickOnElement(singleLfRdBtn);
				util.getLog().debug(actualCoverAmount + "is equal to" + expectedCoverAmmount);
				break;
			}
			util.getLog().debug(actualCoverAmount + "is not equal to" + expectedCoverAmmount);
		}
		return this;
	}

	public String selectCoverTillAge() {
		String expectedCoverAge = util.getExcelRf().get("cover_Age");
		util.selectDropDownByVisibleText(getCoverTillAgeDd(), expectedCoverAge);
		return expectedCoverAge;
	}

	public String selectPayForAge() {
		String expectedPayFor = util.getExcelRf().get("Pay_for");
		util.selectDropDownByVisibleText(getPayForAgeDd(), expectedPayFor);
		return expectedPayFor;
	}

	public String selectModeOfPremium() {
		String expectedPremiumMode = util.getExcelRf().get("Mode_Of_Premium");
		util.selectDropDownByVisibleText(getPremiumModeDd(), expectedPremiumMode);
		return expectedPremiumMode;
	}

	public String selectEducation() {
		String expectedEducation = util.getExcelRf().get("Education_Dd");
		util.selectDropDownByVisibleText(getEducationDd(), expectedEducation);
		return expectedEducation;
	}

	public String selectOccupation() {
		String expectedOccupation = util.getExcelRf().get("Occupation_Value");
		util.selectDropDownByVisibleText(getOccupationDd(), expectedOccupation);
		return expectedOccupation;
	}

	public String enterFullName() {
		String expectedFullName = util.getExcelRf().get("User_name");
		util.clean(getFullNameEd());
		util.input(getFullNameEd(), expectedFullName);
		return expectedFullName;
	}

	public String enterEmailId() {
		String expectedEmailId = util.getExcelRf().get("Email_Ed");
		util.input(getEmailEd(), expectedEmailId);
		return expectedEmailId;
	}

	public String enterAnnualIncome() {
		String expectedIncome = util.getExcelRf().get("Annual_Income");
		util.input(getAnnoualIncomeEd(), expectedIncome);
		return expectedIncome;
	}
	
	
	public PolicyBazaarYourDetailPage enterDetailInProductPage() {
		enterFullName();
		enterEmailId();
		enterAnnualIncome();
		selectOccupation();
		selectEducation();
		selectLifeCoverAmmount();
		selectCoverTillAge();
		selectPayForAge();
		selectModeOfPremium();
		util.clickOnElement(getProceedBtn());
		return new PolicyBazaarYourDetailPage(util);
	}
	
	
	
	
	

	

}
