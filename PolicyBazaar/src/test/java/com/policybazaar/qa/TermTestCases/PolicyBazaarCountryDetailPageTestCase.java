package com.policybazaar.qa.TermTestCases;

import org.testng.annotations.Test;

import com.policybazaar.qa.base.Test_Base;
import com.policybazaar.qa.pagesTerm.PolicyBazaarTermPreQuotesPage;
import com.policybazaar.qa.pagesTerm.PolicyBazaarTermQuotesPage;
import com.policybazaar.qa.prodctpages.PolicyBazaarCountryDetailPage;
import com.policybazaar.qa.prodctpages.PolicyBazaarYourDetailPage;

public class PolicyBazaarCountryDetailPageTestCase extends Test_Base {
	private PolicyBazaarTermPreQuotesPage pbLoginPage;
	private PolicyBazaarTermQuotesPage pbQuotesPage;
	private PolicyBazaarYourDetailPage pbYourDeatalPage;
    private PolicyBazaarCountryDetailPage pbCountryDetailPage;
	public PolicyBazaarCountryDetailPageTestCase() {
		super();
		
	}
	
	
	

	public void beforeCurrentTestScript() {
		pbLoginPage = new PolicyBazaarTermPreQuotesPage(util);
		pbQuotesPage = pbLoginPage.enterPreQuotesPageCredentials();
		pbQuotesPage.startJourneyInSBIProduct();
		pbYourDeatalPage = new PolicyBazaarYourDetailPage(util);
		pbYourDeatalPage.enterDetailInProductPage();
		pbCountryDetailPage = new PolicyBazaarCountryDetailPage(util);
	}
	
	
	@Test( priority = 1, groups = {"smoke"})
	public void validatePinCode() {
		beforeCurrentTestScript();
		String expectedPinCode = pbCountryDetailPage.enterPinCode();
		util.verifyByAttributeValue(pbCountryDetailPage.getPinCodeEd(), "value", expectedPinCode);
	}
	
	
	
	@Test(priority = 2,  groups = {"smoke"})
	public void validateCity() {
		beforeCurrentTestScript();
		pbCountryDetailPage.selectCity();
		util.verifyMethod(pbCountryDetailPage.getExpectedCity(),pbCountryDetailPage.getActualCity());
	}
	
	
	
	@Test(priority = 3, groups = {"sanity"})
	public void validateCountryDetail() {
		beforeCurrentTestScript();
		pbCountryDetailPage.enterDetailInCountryPage();
		util.getFullPageSnapShot("validateCountryDetail");
	}

	
}
