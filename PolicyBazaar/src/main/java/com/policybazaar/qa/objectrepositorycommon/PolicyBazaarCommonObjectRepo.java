package com.policybazaar.qa.objectrepositorycommon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import lombok.Getter;



@Getter
public class PolicyBazaarCommonObjectRepo {
	
	@FindBy(id = "btnsaveProceed")
	private WebElement proceedBtn;
	
	
	@FindBy(id = "//span[@id='spnTotalPremiumWithRiders']")
	private WebElement premiumAmount;

}
