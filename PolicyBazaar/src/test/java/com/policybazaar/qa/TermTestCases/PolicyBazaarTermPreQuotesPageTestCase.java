package com.policybazaar.qa.TermTestCases;


import org.testng.annotations.Test;
import com.policybazaar.qa.base.Test_Base;
import com.policybazaar.qa.pagesTerm.PolicyBazaarTermPreQuotesPage;





public class PolicyBazaarTermPreQuotesPageTestCase extends Test_Base {
	private PolicyBazaarTermPreQuotesPage pbLoginPage;
	
	
	
	
	public PolicyBazaarTermPreQuotesPageTestCase() {
		super();
	}
	
	
	
	

	
	@Test(priority = 1, groups = {"sanity"})
	public void verifyLoginPageWithCredentials() throws InterruptedException {
		pbLoginPage = new PolicyBazaarTermPreQuotesPage(util);
        pbLoginPage.enterPreQuotesPageCredentials();
	}

	
	


	


}
