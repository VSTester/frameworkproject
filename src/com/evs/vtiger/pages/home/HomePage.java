package com.evs.vtiger.pages.home;

import org.openqa.selenium.WebElement;

import com.evs.vtiger.utils.WdUtil;

public class HomePage {
    
	private WdUtil webUtil;
	
	public HomePage(WdUtil webUtilObj) {
		this.webUtil=webUtilObj;
	}
	
	
	public void mouseOverMarketing() {
		webUtil.mouseOver("xpath", "//a[text()='Marketing']");
	}
	
	public void gotoLeads() {
		mouseOverMarketing();
		webUtil.click("xpath","(//a[text()='Leads'])[5]");

	}
	
	public void gotoAccounts() {
		mouseOverMarketing();		
		webUtil.click("xpath","(//a[text()='Accounts'])[5]");
	}
	
}
