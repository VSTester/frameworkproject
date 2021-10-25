package com.evs.vtiger.pages.marketing.leads;


import com.evs.vtiger.utils.WdUtil;

public class LeadsCreatePage {
    private WdUtil webUtil;
	public LeadsCreatePage(WdUtil webUtilObj) {
		this.webUtil=webUtilObj;
	}
	public void enterLeadsMandatoryInfo( String company, String lastName) {
		
		webUtil.sendkeys("xpath","//input[@name='lastname']", lastName);
		webUtil.sendkeys("xpath","//input[@name='company']", company);
		
	}
	public void saveLead() {
		
		webUtil.click("xpath", "//input[@class='crmbutton small save']");
		
	}
	
	public void  cancelLead() {
		
		webUtil.click("xpath","//input[@class='crmbutton small cancel']");
		
	}
	
	
	
}
