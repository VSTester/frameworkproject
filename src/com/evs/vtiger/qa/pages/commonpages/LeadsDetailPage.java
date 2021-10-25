package com.evs.vtiger.qa.pages.commonpages;

import org.openqa.selenium.WebElement;

import com.evs.vtiger.genric.GenricMethods;

public class LeadsDetailPage {
	private GenricMethods genric ;
	
	public LeadsDetailPage(GenricMethods genric ) {
		this.genric = genric ;
	}		
	public void verifyLeadsDetailPage(String validateField, String validateElement) {
		WebElement crLeadVerifyField= genric.findElementBYXpath("//input[@name='"+validateField+"']");
		if (genric.getElementText(crLeadVerifyField).contains(validateElement))
			System.out.println(validateField+"verify is sucessful");
		else
			System.out.println(validateField+"verify  is unsucessful");
	}
}
