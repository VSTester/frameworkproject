package com.policybazaar.qa.pagesInvestment;



import com.policybazaar.qa.objectrepository.PolicyBazaarPreQuotesPageObjectRepo;
import com.policybazaar.qa.webUtil.TestUtil;



public class PolicyBazaarInvestmentPreQuotesPage extends PolicyBazaarPreQuotesPageObjectRepo {
	TestUtil util;
	
	
	

	
	//  **  we create this page class constructor or call locator in this class object Repository**//
	public PolicyBazaarInvestmentPreQuotesPage(TestUtil util) {
		super(util);
		this.util = util;
		
	}

	
	
	//  ** we create a method for performing action on UI   ** //
	public PolicyBazaarInvestmentQuotesPage enterPreQuotesPageCredentials() {
	
		util.slowInput(getInvLoginFullNameEd(), util.getExcelRf().get("User_name") );
		util.input(getInvLoginMobileEd(),util.getExcelRf().get("Mobile"));
		util.input(getInvLoginEmailEd(),util.getExcelRf().get("Email_Ed"));
		util.clickOnElement(getInvLoginVeiwFreeQuotesBtn());
		return new PolicyBazaarInvestmentQuotesPage(util);
	}
	
}
