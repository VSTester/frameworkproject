package com.evs.vtiger.testcases;

import com.evs.vtiger.pages.home.HomePage;
import com.evs.vtiger.pages.login.LoginPage;
import com.evs.vtiger.pages.marketing.leads.LeadsCreatePage;
import com.evs.vtiger.pages.marketing.leads.LeadsDetailsPage;
import com.evs.vtiger.pages.marketing.leads.LeadsLandingPage;
import com.evs.vtiger.utils.WdUtil;

public class ValidateLeadsFunctionality {

	public static void main(String[] args) {
		new ValidateLeadsFunctionality().verifyLeadCreation();
	}
	public void verifyLeadCreation() {

		WdUtil webUtil=new WdUtil();
		webUtil.launchBrowser("CH");
		webUtil.openUrl("http://localhost:8888/");

		LoginPage loginPage=new LoginPage(webUtil);
		loginPage.validLogin();

		HomePage homePage= new HomePage(webUtil);
		homePage.gotoLeads();

		LeadsLandingPage leadsLandingPage=new LeadsLandingPage(webUtil);
		leadsLandingPage.clickCreateLeadButton();
        String company="ExpertView";
        String lastName="Yadav";
		LeadsCreatePage leadsCreatePage=new LeadsCreatePage(webUtil);
		leadsCreatePage.enterLeadsMandatoryInfo(company, lastName);
		leadsCreatePage.saveLead();

		LeadsDetailsPage leadsDetailPage=new LeadsDetailsPage(webUtil);
		leadsDetailPage.verifyLastName( lastName);
		leadsDetailPage.verifyLeadsDetailsHeader( lastName);
	}	
}
