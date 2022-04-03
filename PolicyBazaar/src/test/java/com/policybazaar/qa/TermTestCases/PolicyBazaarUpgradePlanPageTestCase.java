package com.policybazaar.qa.TermTestCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.policybazaar.qa.base.Test_Base;
import com.policybazaar.qa.pagesTerm.PolicyBazaarTermPreQuotesPage;
import com.policybazaar.qa.pagesTerm.PolicyBazaarTermQuotesPage;
import com.policybazaar.qa.pagescommon.PoicyBazaarCommonfunctionalityPage;
import com.policybazaar.qa.prodctpages.PolicyBazaarCountryDetailPage;
import com.policybazaar.qa.prodctpages.PolicyBazaarUpgradePlanPage;
import com.policybazaar.qa.prodctpages.PolicyBazaarYourDetailPage;

public class PolicyBazaarUpgradePlanPageTestCase extends Test_Base {
	
	private PolicyBazaarTermPreQuotesPage pbLoginPage;
	private PolicyBazaarTermQuotesPage pbQuotesPage;
	private PolicyBazaarYourDetailPage pbYourDeatalPage;
    private PolicyBazaarCountryDetailPage pbCountryDetailPage;
    private PolicyBazaarUpgradePlanPage pbUpgradePlanPage;
    private PoicyBazaarCommonfunctionalityPage pbCommonFuntPage;
    
    
    
	public PolicyBazaarUpgradePlanPageTestCase() {
		super();

	}

	

	public void beforeCurrentTestScript() {
		
		pbLoginPage = new PolicyBazaarTermPreQuotesPage(util);
		pbQuotesPage = pbLoginPage.enterPreQuotesPageCredentials();
		pbQuotesPage.startJourneyInSBIProduct();
		pbYourDeatalPage = new PolicyBazaarYourDetailPage(util);
		pbYourDeatalPage.enterDetailInProductPage();
		pbCountryDetailPage = new PolicyBazaarCountryDetailPage(util);
		pbCountryDetailPage.enterDetailInCountryPage();
		pbUpgradePlanPage = new PolicyBazaarUpgradePlanPage(util);
		
	}
	
	
	public void WholeLifeOption() {
		beforeCurrentTestScript();
		util.waitTillInvisibilityOfElement(pbUpgradePlanPage.getWholeLifeRemoveBtn(), 10);
		util.jsScrollUpDown(0.6);
		util.jsScrollDownTillEleFound(pbUpgradePlanPage.getWholeLifeRemoveBtn());
		pbUpgradePlanPage.selectWholeLifeOption(); 
	}
	
	
	@Test(priority = 1, groups = ("smoke"))
	public void validatePlanOpton() {
		beforeCurrentTestScript();
		pbUpgradePlanPage.selectPlanOption();
		util.verifyMethod(pbUpgradePlanPage.getExpectedHeader(), pbUpgradePlanPage.getActualHeader());
	}
	
	
	
	@Test(priority = 2, groups = ("smoke"))
	public void validateNomineeOpton() {
		beforeCurrentTestScript();
		util.jsScrollUpDown(1.5);
		pbUpgradePlanPage.selectNomineeOption();
		util.verifyMethod(pbUpgradePlanPage.getExpectedHeader(), pbUpgradePlanPage.getActualHeader());
	}
	
	
	@Test(priority = 3, groups = ("smoke"))
     public void validateCoverTillAgeWithWholeLife() {
		WholeLifeOption();
		WebElement weCoverTillAgeAftWholeLife = util.getFirstSelectedValueInDD(pbYourDeatalPage.getCoverTillAgeDd());
		String actualCoverTillAgeAftWholeLife = weCoverTillAgeAftWholeLife.getText();
		String expectedCoverTillAgeAftWholeLife = "100 Years";
		util.verifyMethod(expectedCoverTillAgeAftWholeLife, actualCoverTillAgeAftWholeLife);
		System.out.println("hello");
	}
	
	
	
	@Test(priority = 3, groups = ("smoke"))
	public void validatePremiumWithWholeLife() {
	WholeLifeOption();
	String expectedWholelifeAmount=	pbUpgradePlanPage.getWholeLifeAmountAfterSelectWholeLife();
	String actualPremiumAmount = pbCommonFuntPage.getActualPremiumAmount();
	util.verifyMethod(expectedWholelifeAmount, actualPremiumAmount);
	}
	
	@Test(priority = 4, groups = ("smoke"))
	public void validateSaveMoneyOption() {
		beforeCurrentTestScript();
		util.jsScrollUpDown(0.8);
		util.jsScrollDownTillEleFound(pbUpgradePlanPage.getSaveMoneyRemoveBtn());
		pbUpgradePlanPage.selectSaveMoneyPayOption();
	}
	
	
	

	
	
	
	@Test(priority = 1, groups = ("sanity"))
	public void validateUpgradePlanPage() {
		beforeCurrentTestScript();
		pbUpgradePlanPage.enterUpgradePlanDetails();
	}

}
