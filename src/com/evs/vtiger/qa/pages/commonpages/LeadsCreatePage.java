package com.evs.vtiger.qa.pages.commonpages;

import org.openqa.selenium.WebElement;
import com.evs.vtiger.genric.GenricMethods;

public class LeadsCreatePage {

	private GenricMethods genric;

	public LeadsCreatePage(GenricMethods genric) {
		this.genric = genric;

	}

	
	public void enterLeadsCredentials(String salutation, String enfirstname, String enlastname, String enphone,
			String encompany, String endesignation){
		
		WebElement salutationtype = genric.findElementBYXpath("//select[@name='salutationtype']");
		genric.selectValueByValue(salutationtype, salutation);
    
		WebElement firstName = genric.findElementBYName("firstname");
		genric.inputOnElement(firstName, enfirstname);
        
		WebElement lastName = genric.findElementBYName("lastname");
		genric.inputOnElement(lastName, enlastname);
		
		WebElement phone = genric.findElementBYName("phone");
		genric.acInputValue(phone, enphone);
		 
	   WebElement company = genric.findElementBYXpath("//input[@name='company']");
       genric.inputOnElement(company,encompany);
       
		WebElement title = genric.findElementBYID("designation");
        genric.inputOnElement(title, endesignation);

		WebElement leadSource = genric.findElementBYXpath("//select[@name='leadsource']");
      	genric.selectValueByRealValue(leadSource, "Cold Call");

	}
	public void saveCreateLead() {

		WebElement leadSaveBtn = genric.findElementBYXpath("//input[@title='Save [Alt+S]']");
		genric.acClick(leadSaveBtn);
	}

public void cancelCreateLead() {
		
		WebElement leadCancelBtn = genric.findElementBYXpath("//input[@title='Cancel [Alt+X]']");
		genric.acClick(leadCancelBtn);
	}


	public void deleteLeads(String firstnameforsrh) {
		genric.screenShot("LeadswithoutDelete");
		WebElement searchField = genric.findElementBYXpath("//select[@name='search_field']");
		genric.selectValueByValue(searchField, "firstname");
		WebElement searchLead = genric.findElementBYName("search_text");
		genric.acInputValue(searchLead, firstnameforsrh);

		WebElement searchBtn = genric.findElementBYXpath("//input[@name='submit']");
		genric.clickOnElement(searchBtn);

		WebElement deleteLink = genric.findElementBYLink(firstnameforsrh);
		genric.acClick(deleteLink);

		WebElement deleteBtn = genric.findElementBYXpath("//input[@value='Delete']");
		genric.clickOnElement(deleteBtn);

		String text = genric.getTextFromAlert();
		System.out.println("alert text :  " + text);
		genric.alertAccept();
		genric.screenShot("delete Leads");
	}

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