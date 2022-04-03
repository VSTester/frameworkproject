package com.policybazaar.qa.InvestmentTestCases;

import org.testng.annotations.Test;

import com.policybazaar.qa.base.Test_Base;
import com.policybazaar.qa.pagesInvestment.PolicyBazaarInvestmentPreQuotesPage;
import com.policybazaar.qa.pagesInvestment.PolicyBazaarInvestmentQuotesPage;

public class PolicyBazaarInvestmentQuotesPageTestCase extends Test_Base {
	
	private PolicyBazaarInvestmentPreQuotesPage pbInvPreQuotesPage;
	private PolicyBazaarInvestmentQuotesPage pbInvQuotesPage;
	
	public PolicyBazaarInvestmentQuotesPageTestCase() {
		super();

	}

	public void beforeCurrentTestScript() {
		pbInvPreQuotesPage = new PolicyBazaarInvestmentPreQuotesPage(util);
		pbInvQuotesPage = pbInvPreQuotesPage.enterPreQuotesPageCredentials();
	}
	
	
	

	@Test(priority = 1, groups = {"sanity"})
	public void validateClickOnProduct() {
		beforeCurrentTestScript();
		pbInvQuotesPage.startJourneyInSBIProduct();
	}

}
