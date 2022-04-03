package com.policybazaar.qa.pagescommon;

import com.policybazaar.qa.objectrepositorycommon.PolicyBazaarCommonObjectRepo;
import com.policybazaar.qa.webUtil.TestUtil;

public class PoicyBazaarCommonfunctionalityPage  extends PolicyBazaarCommonObjectRepo{
	private TestUtil util;
	
	
	
	public PoicyBazaarCommonfunctionalityPage(TestUtil util) {
		super();
		this.util = util;
	}
	
	
	
	
	
	public String getActualPremiumAmount() {
		String actualPremiumAmount = util.getElementText(getPremiumAmount());
		util.getLog().debug("Actual Premium Amount is :  " + actualPremiumAmount);
		return actualPremiumAmount;
	}

}
