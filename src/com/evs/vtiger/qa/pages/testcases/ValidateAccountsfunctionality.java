package com.evs.vtiger.qa.pages.testcases;

import com.evs.vtiger.genric.GenricMethods;
import com.evs.vtiger.qa.pages.commonpages.AccountsCreatePage;
import com.evs.vtiger.qa.pages.commonpages.AccountsDetailPage;
import com.evs.vtiger.qa.pages.commonpages.AccountsLandinPage;
import com.evs.vtiger.qa.pages.home.HomePage;
import com.evs.vtiger.qa.pages.login.LoginPage;

public class ValidateAccountsfunctionality {
private GenricMethods genric;
private LoginPage login ;
private HomePage home ;
private AccountsCreatePage accountCrPage;
private AccountsDetailPage accountDePage;
private AccountsLandinPage accountlandPage;
	
public void verifyAccountCreation() {
genric = new GenricMethods();
genric.launchBrowser();

login = new LoginPage(genric);
login.verifyLoginPagewithvalidandinvalidcr("admin","admin");

home = new HomePage(genric);
home.gotoAccountsBySales();

accountlandPage= new AccountsLandinPage(genric);
accountlandPage.clickOnCreateAccountsBtn();
String accountName = "vikas ";
String website = "vtiger.com";
String phone = "4545454545";
accountCrPage = new AccountsCreatePage(genric);
accountCrPage.enterAccountsCredentials(accountName, website, phone);
accountCrPage.saveCreateAccounts();

accountDePage = new AccountsDetailPage(genric);
accountDePage.verifyAccountsDetailPage("Website", website);

		
		
	}
	
}
