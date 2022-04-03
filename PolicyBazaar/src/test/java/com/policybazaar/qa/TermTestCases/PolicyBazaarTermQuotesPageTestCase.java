package com.policybazaar.qa.TermTestCases;

import org.testng.annotations.Test;

import com.policybazaar.qa.base.Test_Base;
import com.policybazaar.qa.pagesTerm.PolicyBazaarTermPreQuotesPage;
import com.policybazaar.qa.pagesTerm.PolicyBazaarTermQuotesPage;

public class PolicyBazaarTermQuotesPageTestCase extends Test_Base {
	
	private PolicyBazaarTermPreQuotesPage pbPreQuotesPage;
	private PolicyBazaarTermQuotesPage pbQuotesPage;
	
	public PolicyBazaarTermQuotesPageTestCase() {
		super();

	}

	public void beforeCurrentTestScript() {
		pbPreQuotesPage = new PolicyBazaarTermPreQuotesPage(util);
		pbQuotesPage = pbPreQuotesPage.enterPreQuotesPageCredentials();
	}
	
	
	

	@Test(priority = 1, groups = {"sanity"})
	public void validateClickOnProduct() {
		beforeCurrentTestScript();
		pbQuotesPage.startJourneyInSBIProduct();
	}

}
