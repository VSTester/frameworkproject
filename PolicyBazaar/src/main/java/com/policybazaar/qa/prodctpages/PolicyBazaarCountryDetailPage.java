package com.policybazaar.qa.prodctpages;

import org.openqa.selenium.WebElement;

import com.policybazaar.qa.objectrepository.PolicyBazaarCountryDetailPageObjectRepo;
import com.policybazaar.qa.webUtil.TestUtil;

import lombok.Getter;

public class PolicyBazaarCountryDetailPage extends PolicyBazaarCountryDetailPageObjectRepo {
	@Getter
private String actualCity;
	@Getter
private String expectedCity;
	private TestUtil util;

	public PolicyBazaarCountryDetailPage(TestUtil util) {
		super(util);
		this.util = util;
	}
	
	
	
	
	
	
	public String enterPinCode() {
		String actualPinCode = util.getExcelRf().get("PinCode_Ed");
		util.input(getPinCodeEd(), actualPinCode);
		util.getLog().debug("pincode sucessfull entered");
		return actualPinCode;
	}
	
	
	
	
	public PolicyBazaarCountryDetailPage selectCity() {
		util.clickOnElement(getCityFd());
		for (WebElement singleCity : getListOfCityName()) {
			actualCity = util.getElementText(singleCity);
			expectedCity = util.getExcelRf().get("valid_City");
			if (actualCity.equals(expectedCity)) {
				util.clickOnElement(singleCity);
				util.getLog().debug(actualCity + "is equal to" + expectedCity);
				break;
			}
			util.getLog().debug(actualCity + "is not equal to" + expectedCity);
		}
		return this;
	}
	
	
	
	
	
	
	public PolicyBazaarUpgradePlanPage enterDetailInCountryPage() {
		enterPinCode();
		selectCity();
		util.clickOnElement(getProceedBtn());
		return new PolicyBazaarUpgradePlanPage(util);
	}
	
	
	
	
	}
	

	
