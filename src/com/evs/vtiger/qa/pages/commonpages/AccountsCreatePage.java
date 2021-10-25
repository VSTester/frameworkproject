package com.evs.vtiger.qa.pages.commonpages;

import org.openqa.selenium.WebElement;
import com.evs.vtiger.genric.GenricMethods;

public class AccountsCreatePage {

	private GenricMethods genric;

	public AccountsCreatePage(GenricMethods genric) {
		this.genric = genric;

	}

	
	public void enterAccountsCredentials(String enaccountname, String enwebsite, String enphone){
		
		WebElement accountName = genric.findElementBYName("accountname");
		genric.inputOnElement(accountName, enaccountname);
        
		WebElement website = genric.findElementBYName("website");
		genric.inputOnElement(website, enwebsite);
		
		WebElement phone = genric.findElementBYName("phone");
		genric.acInputValue(phone, enphone);
		 
	}
	
	public void saveCreateAccounts() {

		WebElement accountsSaveBtn = genric.findElementBYXpath("//input[@title='Save [Alt+S]']");
		genric.acClick(accountsSaveBtn);
	}

public void cancelCreateAccounts() {
		
		WebElement accountsCancelBtn = genric.findElementBYXpath("//input[@title='Cancel [Alt+X]']");
		genric.acClick(accountsCancelBtn);
	}


	//public void deleteAccounts(String firstnameforsrh) {
//		genric.screenShot("AccountswithoutDelete");
//		WebElement searchField = genric.findElementBYXpath("//select[@name='search_field']");
//		genric.selectValueByValue(searchField, "firstname");
//		WebElement searchLead = genric.findElementBYName("search_text");
//		genric.acInputValue(searchLead, firstnameforsrh);
//
//		WebElement searchBtn = genric.findElementBYXpath("//input[@name='submit']");
//		genric.clickOnElement(searchBtn);
//
//		WebElement deleteLink = genric.findElementBYLink(firstnameforsrh);
//		genric.acClick(deleteLink);
//
//		WebElement deleteBtn = genric.findElementBYXpath("//input[@value='Delete']");
//		genric.clickOnElement(deleteBtn);
//
//		String text = genric.getTextFromAlert();
//		System.out.println("alert text :  " + text);
//		genric.alertAccept();
//		genric.screenShot("delete Leads");
//	}

	public void verifycreatedleads(String firstname) {

		WebElement crLeadToken = genric.findElementBYXpath("//span[contains(text(),'" + firstname + "')]");
		if (genric.getElementText(crLeadToken).contains(firstname))
			System.out.println("verify Token is sucessful");
		else
			System.out.println("verify Token is unsucessful");

		WebElement crfirstname = genric.findElementBYXpath("//span[@id = 'dtlview_First Name']");
		if (genric.getElementText(crfirstname).contains(firstname))
			System.out.println("verify Token is sucessful");
		else
			System.out.println("verify Token is unsucessful");

		WebElement crlastname = genric.findElementBYXpath("//span[@id = 'dtlview_Last Name']");
		if (genric.getElementText(crlastname).contains(firstname))
			System.out.println("verify Token is sucessful");
		else
			System.out.println("verify Token is unsucessful");

	}
}