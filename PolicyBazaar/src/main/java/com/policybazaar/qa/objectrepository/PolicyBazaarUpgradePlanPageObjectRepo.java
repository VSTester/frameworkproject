package com.policybazaar.qa.objectrepository;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.policybazaar.qa.objectrepositorycommon.PolicyBazaarCommonObjectRepo;
import com.policybazaar.qa.webUtil.TestUtil;

import lombok.Getter;

@Getter
public class PolicyBazaarUpgradePlanPageObjectRepo extends PolicyBazaarCommonObjectRepo {

	
	
	//   ** plan and Nominee  Option  **  //
	@FindBys(@FindBy(xpath = "//div[starts-with(@class,'planOptionBox card rounded pt-3 pb')]//child::div//label//h4"))
	private List<WebElement> listOfPlanOptionRBtn;
	
	
	@FindBys(@FindBy(xpath = "//div[@class='planOptionBox card rounded pt-3 pl-3 pr-3 mr-0 mb-2 w-100']//span[starts-with(@class,'longtxtRadio')]"))
	private List<WebElement> listOfNomineeOptionRBtn;
	
	
	
	
	//    **  whole life / save option    **  //
	@FindBy(xpath = "//div[@id='liWholeLife']//label//span")
	private WebElement wholeLifeRemoveBtn;
	
	
	@FindBy(xpath = "//div[@id='liSaveMoneyWithLimitedPay']//span[@class='addRemoveBtn']")
	private WebElement saveMoneyRemoveBtn;
	

	//    **  options amount  **  //
	
	
	@FindBy(xpath =  "//div[@class='totalAmt']//span[@class='lblWholeLife']")
	private WebElement wholeLifeAmount;
	
	
	
	
	
	
	
	
public PolicyBazaarUpgradePlanPageObjectRepo(TestUtil util) {
		PageFactory.initElements(util.getDriver(),this);
	}
}
