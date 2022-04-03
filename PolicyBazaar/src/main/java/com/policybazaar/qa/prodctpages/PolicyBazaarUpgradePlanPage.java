package com.policybazaar.qa.prodctpages;


import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.policybazaar.qa.base.Test_Base;
import com.policybazaar.qa.objectrepository.PolicyBazaarUpgradePlanPageObjectRepo;
import com.policybazaar.qa.webUtil.TestUtil;

import lombok.Getter;


public class PolicyBazaarUpgradePlanPage extends PolicyBazaarUpgradePlanPageObjectRepo{
	private TestUtil util;
	@Getter
	String actualHeader;
	@Getter
	String expectedHeader;
	
	
	
	public PolicyBazaarUpgradePlanPage(TestUtil util) {
		super(util);
		this.util = util;
	}
	
	
	
	
	
	
	
	public PolicyBazaarUpgradePlanPage selectPlanOption() {
		for (WebElement singlePOHeader : getListOfPlanOptionRBtn()) {
			actualHeader = util.getElementText(singlePOHeader);
			expectedHeader = util.getExcelRf().get("Plan_Option");
			if (actualHeader.equalsIgnoreCase(expectedHeader)) {
				util.clickOnElement(singlePOHeader);
				util.getLog().debug(actualHeader + "is equal to" + expectedHeader);
				break;
			}
			util.getLog().debug(actualHeader + "is not equal to" + expectedHeader);
		}
		return this;
	}	
	
	
	
	
	
	public PolicyBazaarUpgradePlanPage selectNomineeOption() {
		for (WebElement singleNomineeHeader : getListOfNomineeOptionRBtn()) {
			actualHeader = util.getElementText(singleNomineeHeader);
			expectedHeader = util.getExcelRf().get("Nominee_Option");
			if (actualHeader.equalsIgnoreCase(expectedHeader)) {
				util.clickOnElement(singleNomineeHeader);
				util.getLog().debug(actualHeader + "is equal to" + expectedHeader);
				break;
			}
			util.getLog().debug(actualHeader + "is not equal to" + expectedHeader);
		}
		return this;
	}
	
	
	
	
	public void selectWholeLifeOption() {
		String wholeLifeOption = util.getExcelRf().get("Whole_Life_Option");
		util.waitTillInvisibilityOfElement(getWholeLifeRemoveBtn(), 10);
		//String abcd = util.getElementAttributeValue(getWholeLifeRemoveBtn(), "value");
		if (util.elementIsDisplayed(getWholeLifeRemoveBtn())) {
			if (wholeLifeOption.equals("Yes")) {
				util.clickOnElement(getWholeLifeRemoveBtn());
				util.getLog().debug("Whole Life Plan Option is select");
				Test_Base.extendReport.getExtentTestLogger().log(Status.INFO,
						MarkupHelper.createLabel("whole life option select sucessfull ", ExtentColor.GREEN));
			} else if (wholeLifeOption.equals("No")) {
				util.getLog().debug("Whole Life Plan Option is not select");
				Test_Base.extendReport.getExtentTestLogger().log(Status.INFO,
						MarkupHelper.createLabel("Whole Life Plan Option is not select ", ExtentColor.GREY));
			}
		} else {
			util.getLog().debug("whole life option is not avilable");
			Test_Base.extendReport.getExtentTestLogger().log(Status.INFO,
					MarkupHelper.createLabel("whole life option is not avilable", ExtentColor.BLUE));
		}

	}
	
	public void selectSaveMoneyPayOption() {
		String saveMoneyOption = util.getExcelRf().get("Save_money_pay");
		if (util.elementIsDisplayed(getSaveMoneyRemoveBtn())) {
			if (saveMoneyOption.equals("Yes")) {
				util.clickOnElement(getSaveMoneyRemoveBtn());
				util.getLog().debug("save money Plan Option is select");
				Test_Base.extendReport.getExtentTestLogger().log(Status.INFO,
						MarkupHelper.createLabel("save money option select sucessfull ", ExtentColor.GREEN));
			} else if (saveMoneyOption.equals("No")) {
				util.getLog().debug("save money Plan Option is not select");
				Test_Base.extendReport.getExtentTestLogger().log(Status.INFO,
						MarkupHelper.createLabel("save money Plan Option is not select ", ExtentColor.GREY));
			}
		} else {
			util.getLog().debug("save money option is not avilable");
			Test_Base.extendReport.getExtentTestLogger().log(Status.INFO,
					MarkupHelper.createLabel("save money option is not avilable", ExtentColor.BLUE));
		}
	}
	
	
	public String getWholeLifeAmountAfterSelectWholeLife() {
		String wholeAmount = null;
		String wholeLifeOption = util.getExcelRf().get("Whole_Life_Option");
		if (wholeLifeOption.equalsIgnoreCase("Yes")) {
		 wholeAmount = util.getElementText(getWholeLifeAmount());
		util.getLog().debug("whole Life Amount is :  " + wholeAmount);
		}
		return wholeAmount;
	}
	
	
	
	
	
	public PolicyBazaarRidersPage enterUpgradePlanDetails() {
		selectPlanOption();
		selectNomineeOption();
		selectSaveMoneyPayOption();
		selectWholeLifeOption();
		util.clickOnElement(getProceedBtn());
		return new PolicyBazaarRidersPage(util);
	}

}
	
	
	
