package com.policybazaar.qa.pagesInvestment;

import com.policybazaar.qa.objectrepository.PolicyBazaarQuotesPageObjectRepo;
import com.policybazaar.qa.prodctpages.PolicyBazaarYourDetailPage;
import com.policybazaar.qa.webUtil.TestUtil;

public class PolicyBazaarInvestmentQuotesPage extends PolicyBazaarQuotesPageObjectRepo {

	private TestUtil util;

	public PolicyBazaarInvestmentQuotesPage(TestUtil util) {
		super(util);
		this.util = util;
	}

	public PolicyBazaarInvestmentQuotesPage closeWelcomePopUp() {
		boolean popUp = util.elementIsDisplayed(invCustomerAgeEd);
		if (popUp) {
			util.input(invCustomerAgeEd, "38");
			util.acClickOnElement(invContinueBtn);
			// util.input(invCustomerCityEd, "Gurgaon");
		} else {
			util.getLog().debug("pop up is nnot avilable");
		}
		return this;
	}
	
	
	
	public void changeDetailInHeader() {
	util.clickOnElement(invHeader);
	}


	public PolicyBazaarYourDetailPage startJourneyInSBIProduct() {
		util.waitTillElementIsVisible(invContinueBtn, 6);
		closeWelcomePopUp();
		util.holdScript(1);
		changeDetailInHeader();
//		util.jsScrollUpDown(2.5);
//		util.clickOnElement(getQuotesSbiPaymentBtn());
		return new PolicyBazaarYourDetailPage(util);
	}

}
