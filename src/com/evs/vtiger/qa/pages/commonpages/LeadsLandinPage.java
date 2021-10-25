package com.evs.vtiger.qa.pages.commonpages;

import org.openqa.selenium.WebElement;

import com.evs.vtiger.genric.GenricMethods;

public class LeadsLandinPage {
	private GenricMethods genric;

	public LeadsLandinPage(GenricMethods genric) {
		this.genric = genric;

	}

	public void clickOnCreateleadBtn() {

		WebElement createLeadBtn = genric.findElementBYXpath("//img[@title='Create Lead...']");
		genric.acClick(createLeadBtn);
	}
}
