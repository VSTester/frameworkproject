package com.evs.vtiger.qa.pages.commonpages;

import org.openqa.selenium.WebElement;

import com.evs.vtiger.genric.GenricMethods;

public class AccountsDetailPage {
	private GenricMethods genric ;
	
	public AccountsDetailPage(GenricMethods genric ) {
		this.genric = genric ;
	}		
	public void verifyAccountsDetailPage(String validateField, String validateElement) {
		WebElement crAccountVerifyField= genric.findElementBYXpath("//span[@id='dtlview_"+validateField+"']");
		if (genric.getElementText(crAccountVerifyField).contains(validateElement))
			System.out.println(validateField+"verify is sucessful");
		else
			System.out.println(validateField+"verify  is unsucessful");
	}
}
