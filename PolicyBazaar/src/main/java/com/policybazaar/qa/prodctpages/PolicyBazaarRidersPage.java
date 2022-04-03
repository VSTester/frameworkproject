package com.policybazaar.qa.prodctpages;

import com.policybazaar.qa.objectrepository.PolicyBazaarRiderPageObjectRepo;
import com.policybazaar.qa.webUtil.TestUtil;

public class PolicyBazaarRidersPage extends PolicyBazaarRiderPageObjectRepo{
	private TestUtil util;
	
	
	
	public PolicyBazaarRidersPage(TestUtil util) {
		super(util);
		this.util = util;
	}
	
	
	
	
	
	
	public void selectSpousePlan() {
		String spousePlan= util.getExcelRf().get("Spouse_plan");
		if (getCoverYourSpouseBtn().isDisplayed()) {
			if (spousePlan=="Yes") {
				util.clickOnElement(getCoverYourSpouseBtn());
				util.getLog().debug("sucessfull select your spouse Plan in rider page");
			}else if (spousePlan=="No") {
				util.getLog().debug("spouse Plan option is not select");
			}
		}
		else
			util.getLog().debug("spouse plan option is not avialable in rider page ");
	}
	
	
	
	
	
	
	
	

}
