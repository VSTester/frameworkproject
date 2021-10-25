package com.evs.vtiger.qa.pages.testcases;

import com.evs.vtiger.genric.GenricMethods;
import com.evs.vtiger.qa.pages.commonpages.LeadsCreatePage;
import com.evs.vtiger.qa.pages.commonpages.LeadsDetailPage;
import com.evs.vtiger.qa.pages.commonpages.LeadsLandinPage;
import com.evs.vtiger.qa.pages.home.HomePage;
import com.evs.vtiger.qa.pages.login.LoginPage;

public class Validateleadsfunctionality {
private GenricMethods genric;
private LoginPage login ;
private HomePage home ;
private LeadsCreatePage leadCrPage;
private LeadsDetailPage leadDePage;
private LeadsLandinPage leadlandPage;
	public void verifyleadsCreation() {
genric = new GenricMethods();
genric.launchBrowser();

login = new LoginPage(genric);
login.verifyLoginPagewithvalidandinvalidcr("admin","admin");

home = new HomePage(genric);
home.gotoLeadsBySales();

leadlandPage = new LeadsLandinPage(genric);
leadlandPage.clickOnCreateleadBtn();

String salut = "Mr.";
String firstName = "krish";
String lastName = "rathore";
String phone = "4545454545";
String company = "rathore&Company";
String designation = "QA Engineer";
leadCrPage = new LeadsCreatePage(genric);
leadCrPage.enterLeadsCredentials(salut, firstName, lastName, phone, company, designation);
leadCrPage.saveCreateLead();

leadDePage = new LeadsDetailPage(genric);
leadDePage.verifyLeadsDetailPage("firstname",firstName);

		
		
	}
	
}
