package com.policybazaar.qa.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.policybazaar.qa.webUtil.TestUtil;

import lombok.Getter;

@Getter
public class PolicyBazaarRiderPageObjectRepo {
	
	
	
	@FindBy(xpath = "//div[@id='spouseCard']//div[@class='radio radioBtnAbsolute mr-0']//span")
	private WebElement coverYourSpouseBtn;
	
	
	
	
	
	
	
	
	
	
	
	
	public PolicyBazaarRiderPageObjectRepo(TestUtil util) {
		PageFactory.initElements(util.getDriver(),this);
	}

}
