package com.evs.vtiger.qa.pages.home;

import org.openqa.selenium.WebElement;

import com.evs.vtiger.genric.GenricMethods;

public class HomePage {
	private GenricMethods genric ;
	
	public HomePage(GenricMethods genric) {
		this.genric = genric;
	}
	
	public void handlewindow() {
		  WebElement aboutuslink =  genric.findElementBYLink("About Us");
		  genric.acClick(aboutuslink);
		  
		  WebElement helplink =  genric.findElementBYLink("Help");
		  genric.acClick(helplink);
		  
		  genric.focusOnhandleWindow("http://localhost:8888/index.php?module=Users&action=about_us");
		  genric.screenShot("AboutUs");
	WebElement closeBtn =  genric.findElementBYXpath("//input[@name='close']");
	genric.acClick(closeBtn);
	
	}
	
	public void gotoLeadsBySales() {
		WebElement salesLink = genric.findElementBYLink("Sales");
		genric.moveOnElement(salesLink);
		WebElement leadsLink =genric.findElementBYLink("Leads");
		genric.acClick(leadsLink);
	}
	
	public void gotoAccountsBySales() {
		WebElement salesLink = genric.findElementBYLink("Sales");
		genric.moveOnElement(salesLink);
		WebElement accountsLink =genric.findElementBYLink("Accounts");
		genric.acClick(accountsLink);
	}
}
