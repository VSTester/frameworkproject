package com.evs.vtiger.qa.pages.login;

import org.openqa.selenium.WebElement;

import com.evs.vtiger.genric.GenricMethods;

public class LoginPage {
private GenricMethods genric  ;
 
  public LoginPage(GenricMethods genric) {
	this.genric = genric;
 }
	
	public void verifyLoginPagewithvalidandinvalidcr(String username, String password) {
		
		WebElement userName = genric.findElementBYName("user_name");
		genric.inputOnElement(userName, username);
		WebElement userPass = genric.findElementBYXpath("//input[@name='user_password']");
		genric.acInputValue(userPass,password);
		WebElement loginBtn = genric.findElementBYXpath("//input[@title='Login [Alt+L]']");
		genric.clickOnElement(loginBtn);
		genric.screenShot("login");
		String title = genric.getPageTitle();
		if (title.equalsIgnoreCase("admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM")) { 
			System.out.println("Login with valid credantials");
			System.out.println("Your credential is :    " +  username +"  "  +  password);
		}	else {
			System.out.println("Login with invalid credantials");
			System.out.println("Your credential is :    " +  username   +"      "+  password);
		}
	}
	
//	public static void main(String[] args) {
//		 genric  = new GenricMethods(); 
//		genric.launchBrowser();
//		BaseClass base  = new BaseClass();
//		base.LoginPage(genric);
//	}
}
