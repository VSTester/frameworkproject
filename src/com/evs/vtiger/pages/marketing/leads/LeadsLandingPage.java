package com.evs.vtiger.pages.marketing.leads;


import com.evs.vtiger.utils.WdUtil;

public class LeadsLandingPage {

	private WdUtil webUtil;
	public LeadsLandingPage(WdUtil webUtilObj) {
		this.webUtil=webUtilObj;
	}
	
	public void clickCreateLeadButton() {
		
		webUtil.click("xpath","//img[@title='Create Lead...']");

	}
	
	
}
