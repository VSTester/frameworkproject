package com.evs.vtiger.qa.pages.commonpages;

import org.openqa.selenium.WebElement;

import com.evs.vtiger.genric.GenricMethods;

public class AccountsLandinPage {
	private GenricMethods genric;

	public AccountsLandinPage(GenricMethods genric) {
		this.genric = genric;

	}

	public void clickOnCreateAccountsBtn() {

		WebElement createAccountsBtn = genric.findElementBYXpath("//img[@title='Create Account...']");
		genric.acClick(createAccountsBtn);
	}
}
