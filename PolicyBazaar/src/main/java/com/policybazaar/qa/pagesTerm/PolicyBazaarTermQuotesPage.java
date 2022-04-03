package com.policybazaar.qa.pagesTerm;

import com.policybazaar.qa.objectrepository.PolicyBazaarQuotesPageObjectRepo;
import com.policybazaar.qa.prodctpages.PolicyBazaarYourDetailPage;
import com.policybazaar.qa.webUtil.TestUtil;

public class PolicyBazaarTermQuotesPage extends PolicyBazaarQuotesPageObjectRepo {

	private TestUtil util;

	public PolicyBazaarTermQuotesPage(TestUtil util) {
		super(util);
		this.util = util;
	}

	public PolicyBazaarTermQuotesPage closeWelcomePopUp() {
		util.clickOnElement(getTobaccoDropDown());
		util.acClickOnElement(getQuotesCloseBtn());
		return this;
	}


	public PolicyBazaarYourDetailPage startJourneyInSBIProduct() {
		util.waitTillElementIsVisible(getQuotesCloseBtn(), 6);
		closeWelcomePopUp();
		util.waitTillInvisibilityOfElement(getQuotesCloseBtn(), 5);
		util.jsScrollUpDown(2.5);
		util.clickOnElement(getQuotesSbiPaymentBtn());
		return new PolicyBazaarYourDetailPage(util);
	}

}
