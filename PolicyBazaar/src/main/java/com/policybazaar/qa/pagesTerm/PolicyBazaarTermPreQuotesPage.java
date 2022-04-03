package com.policybazaar.qa.pagesTerm;



import com.policybazaar.qa.objectrepository.PolicyBazaarPreQuotesPageObjectRepo;
import com.policybazaar.qa.webUtil.TestUtil;



public class PolicyBazaarTermPreQuotesPage extends PolicyBazaarPreQuotesPageObjectRepo {
	TestUtil util;
	
	
	

	
	//  **  we create this page class constructor or call locator in this class object Repository**//
	public PolicyBazaarTermPreQuotesPage(TestUtil util) {
		super(util);
		this.util = util;
		
	}

	
	
	//  ** we create a method for performing action on UI   ** //
	public PolicyBazaarTermQuotesPage enterPreQuotesPageCredentials() {
	
		util.slowInput(getLoginFullNameEd(), util.getExcelRf().get("User_name") );
		util.input(getLoginDobEd(), util.getExcelRf().get("DOB"));
		util.input(getLoginMobileEd(),util.getExcelRf().get("Mobile"));
		util.clickOnElement(getLoginVeiwFreeQuotesBtn());
		return new PolicyBazaarTermQuotesPage(util);
	}
	
}
