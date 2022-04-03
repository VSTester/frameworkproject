package com.policybazaar.qa.TermTestCases;

import com.policybazaar.qa.base.Test_Base;
import com.policybazaar.qa.pagesTerm.PolicyBazaarTermPreQuotesPage;
import com.policybazaar.qa.pagesTerm.PolicyBazaarTermQuotesPage;
import com.policybazaar.qa.prodctpages.PolicyBazaarCountryDetailPage;
import com.policybazaar.qa.prodctpages.PolicyBazaarUpgradePlanPage;
import com.policybazaar.qa.prodctpages.PolicyBazaarYourDetailPage;

public class PolicyBazaarRIderPageTestCase extends Test_Base {
	
	
	private PolicyBazaarTermPreQuotesPage pbLoginPage;
	private PolicyBazaarTermQuotesPage pbQuotesPage;
	private PolicyBazaarYourDetailPage pbYourDeatalPage;
    private PolicyBazaarCountryDetailPage pbCountryDetailPage;
    private PolicyBazaarUpgradePlanPage pbUpgradePlanPage;
    
    
    
	public PolicyBazaarRIderPageTestCase() {
		super();
		
	}
	
	
	

	public void beforeCurrentTestScript() {
		pbLoginPage = new PolicyBazaarTermPreQuotesPage(util);
		pbQuotesPage = pbLoginPage.enterPreQuotesPageCredentials();
		pbQuotesPage.startJourneyInSBIProduct();
		pbYourDeatalPage = new PolicyBazaarYourDetailPage(util);
		pbYourDeatalPage.enterDetailInProductPage();
		pbCountryDetailPage = new PolicyBazaarCountryDetailPage(util);
		pbCountryDetailPage.enterDetailInCountryPage();
		pbUpgradePlanPage = new PolicyBazaarUpgradePlanPage(util);
		pbUpgradePlanPage.enterUpgradePlanDetails();
		
		
	}
	
	
	
	
	
	
	
	


}
