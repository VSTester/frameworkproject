package com.evs.vtiger.pages.login;

import org.openqa.selenium.WebElement;

import com.evs.vtiger.utils.WdUtil;


public class LoginPage{
	private WdUtil util;
	public LoginPage(WdUtil webUtilObj) {
		this.util=webUtilObj;
	}

	public void validLogin() {

		util.sendkeys("xpath","//input[@name='user_name']", "admin");
		util.sendkeys("xpath","//input[@name='user_password']", "admin");
		util.click("xpath","//input[@name='Login']");

	}

	public void invalidLogin() {

	}








}
