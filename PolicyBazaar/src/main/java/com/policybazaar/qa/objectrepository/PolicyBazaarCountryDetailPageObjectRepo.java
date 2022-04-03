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
public class PolicyBazaarCountryDetailPageObjectRepo extends PolicyBazaarCommonObjectRepo  {

@FindBy(id = "Pincode")
private WebElement pinCodeEd;

@FindBy(id = "City")
private WebElement cityFd;

@FindBys(@FindBy(xpath = "//ul[@id='cityUL']//li"))
private List<WebElement> listOfCityName;
	
	
	
	
	
public PolicyBazaarCountryDetailPageObjectRepo(TestUtil util) {
		PageFactory.initElements(util.getDriver(),this);
	}
}
