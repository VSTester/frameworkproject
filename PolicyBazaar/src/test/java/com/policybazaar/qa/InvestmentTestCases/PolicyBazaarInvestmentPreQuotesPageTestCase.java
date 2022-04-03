package com.policybazaar.qa.InvestmentTestCases;


import org.testng.annotations.Test;
import com.policybazaar.qa.base.Test_Base;
import com.policybazaar.qa.pagesInvestment.PolicyBazaarInvestmentPreQuotesPage;





public class PolicyBazaarInvestmentPreQuotesPageTestCase extends Test_Base {
	private PolicyBazaarInvestmentPreQuotesPage pbInvPreQuotesPage;
	
	
	
	
	public PolicyBazaarInvestmentPreQuotesPageTestCase() {
		super();
	}
	
	
	
	

	
	@Test(priority = 1, groups = {"sanity"})
	public void verifyLoginPageWithCredentials() throws InterruptedException {
		pbInvPreQuotesPage = new PolicyBazaarInvestmentPreQuotesPage(util);
		pbInvPreQuotesPage.enterPreQuotesPageCredentials();
	}

	
	


	


}
