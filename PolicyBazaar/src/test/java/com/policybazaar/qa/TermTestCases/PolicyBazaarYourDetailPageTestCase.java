package com.policybazaar.qa.TermTestCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.policybazaar.qa.base.Test_Base;
import com.policybazaar.qa.pagesTerm.PolicyBazaarTermPreQuotesPage;
import com.policybazaar.qa.pagesTerm.PolicyBazaarTermQuotesPage;
import com.policybazaar.qa.prodctpages.PolicyBazaarYourDetailPage;

public class PolicyBazaarYourDetailPageTestCase extends Test_Base {
	private PolicyBazaarTermPreQuotesPage pbPreQuotesPage;
	private PolicyBazaarTermQuotesPage pbQuotesPage;
	private PolicyBazaarYourDetailPage pbYourDeatalPage;

	public PolicyBazaarYourDetailPageTestCase() {
		super();
		
	}
	
	

	public void beforeCurrentTestScript() {
		pbPreQuotesPage = new PolicyBazaarTermPreQuotesPage(util);
		pbQuotesPage = pbPreQuotesPage.enterPreQuotesPageCredentials();
		pbQuotesPage.startJourneyInSBIProduct();
		pbYourDeatalPage = new PolicyBazaarYourDetailPage(util);
	}

	@Test(priority = 1, groups = {"smoke"})
	public void validateProductPageLogo() {
		beforeCurrentTestScript();
		String expectedLogo = util.getExcelRf().get("verify_pp_logo_Text");
		util.verifyByAttributeValue(pbYourDeatalPage.getProductLogo(),"alt", expectedLogo);
	}

	@Test(priority = 2, groups = {"smoke"})
	public void validateLifeCoverValue() {
		beforeCurrentTestScript();
		pbYourDeatalPage.selectLifeCoverAmmount();
		util.verifyMethod(pbYourDeatalPage.getExpectedCoverAmmount(),pbYourDeatalPage.getActualCoverAmount());
	}

	
	
	@Test( priority = 3, groups = {"smoke"})
	public void validateCoverTillAge() {
		beforeCurrentTestScript();
		String expectedCoverAge =pbYourDeatalPage.selectCoverTillAge();
		util.holdScript(1);
		WebElement option = util.getFirstSelectedValueInDD(pbYourDeatalPage.getCoverTillAgeDd());
		String actualSelectedCoverAge = option.getText();
		util.verifyMethod(expectedCoverAge, actualSelectedCoverAge);
		
	}
	
	@Test(priority = 4, groups = {"smoke"})
	public void vaidatePayForAge() {
		beforeCurrentTestScript();
		String expectedPayFor = pbYourDeatalPage.selectPayForAge();
		WebElement option = util.getFirstSelectedValueInDD(pbYourDeatalPage.getPayForAgeDd());
		String actualSelectedPayFor = option.getText();
		util.verifyMethod(expectedPayFor, actualSelectedPayFor);
	}

	@Test(priority = 5, groups = {"smoke"})
	public void validateModeOfPremium() {
		beforeCurrentTestScript();
		String expectedPremiumMode =pbYourDeatalPage.selectModeOfPremium();
		WebElement option = util.getFirstSelectedValueInDD(pbYourDeatalPage.getPremiumModeDd());
		String actualSelectedPremiumMode = option.getText();
		util.verifyMethod(expectedPremiumMode, actualSelectedPremiumMode);
	}

	@Test(priority = 6, groups = {"smoke"})
	public void validateFUllName() {
		beforeCurrentTestScript();
		String expectedFullName = pbYourDeatalPage.enterFullName();
		util.verifyByAttributeValue(pbYourDeatalPage.getFullNameEd(),"value", expectedFullName);
		
	}

	@Test(priority = 7, groups = {"smoke"})
	public void validateEmail() {
		beforeCurrentTestScript();
		String expectedEmailId = pbYourDeatalPage.enterEmailId();
		util.verifyByAttributeValue(pbYourDeatalPage.getEmailEd(), "value", expectedEmailId);
	}
	
	@Test(priority = 8, groups = {"smoke"})
	public void validateAnnualIncome() {
		beforeCurrentTestScript();
		String expectedIncome= pbYourDeatalPage.enterAnnualIncome();
		util.verifyByAttributeValue(pbYourDeatalPage.getAnnoualIncomeEd(),"value", expectedIncome);
	}
	
	
	@Test(priority = 9, groups = {"smoke"})
	public void validateOccupation() {
		beforeCurrentTestScript();
		String expectedOccupation= pbYourDeatalPage.selectOccupation();
		WebElement option = util.getFirstSelectedValueInDD(pbYourDeatalPage.getOccupationDd());
		String actualSelectedOccupation = option.getText();
		util.verifyMethod(expectedOccupation, actualSelectedOccupation);
	}
	
	
	@Test(priority = 10, groups = {"smoke"})
	public void validateEduation() {
		beforeCurrentTestScript();
		String expectedEducation =pbYourDeatalPage.selectEducation();
		WebElement option = util.getFirstSelectedValueInDD(pbYourDeatalPage.getEducationDd());
		String actualSelectedEducation = option.getText();
		util.verifyMethod(expectedEducation, actualSelectedEducation);
	}
	
	
	
	
	
	
	
	
	
	@Test(priority = 2, groups = {"sanity"})
	public void validateDetailPage() {
		beforeCurrentTestScript();
		pbYourDeatalPage.enterDetailInProductPage();
		util.getFullPageSnapShot("validateProductPage");
	}

}
