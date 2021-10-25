package com.evs.vtiger.pages.marketing.leads;

import org.openqa.selenium.WebElement;

import com.evs.vtiger.utils.WdUtil;

public class LeadsDetailsPage {

	private WdUtil webUtil;
	public LeadsDetailsPage(WdUtil webUtilObj) {
		this.webUtil=webUtilObj;
	}

	public void verifyLeadsDetailsHeader(String expLeadsHeader) {
		String actualLeadsHeader=webUtil.getText("xpath","//*[@class='dvHeaderText']");
		if(actualLeadsHeader.contains(expLeadsHeader)==true) {
			System.out.println("Leads Page Header Validation Passed. Actual-"+actualLeadsHeader+" , Expected-"+expLeadsHeader);
		}else {
			System.out.println("Leads Page Header Validation Failed. Actual-"+actualLeadsHeader+" , Expected-"+expLeadsHeader);

		}

	}

	public void verifyLastName(String expLastName) {
		String actualLastName=webUtil.getText("xpath","//*[@id='dtlview_Last Name']");
		if(actualLastName.equalsIgnoreCase(expLastName)) {
			System.out.println("Last Name Validation Passed. Actual-"+actualLastName+" , Expected-"+expLastName);
		}else {
			System.out.println("Last Name Validation Failed. Actual-"+actualLastName+" , Expected-"+expLastName);

		}

	}

	public void verifyCompanyName() {

	}

}
