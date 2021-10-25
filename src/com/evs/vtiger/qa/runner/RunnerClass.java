package com.evs.vtiger.qa.runner;


import com.evs.vtiger.qa.pages.testcases.ValidateAccountsfunctionality;
import com.evs.vtiger.qa.pages.testcases.Validateleadsfunctionality;

public class RunnerClass  {
	
    private static  Validateleadsfunctionality validateLeadFun;
    private static ValidateAccountsfunctionality validateAccountFun;
	public static void main(String[] args) {
		
		/*
		 * validateLeadFun= new Validateleadsfunctionality();
		 * validateLeadFun.verifyleadsCreation();
		 */
		
		
		validateAccountFun = new ValidateAccountsfunctionality();
		validateAccountFun.verifyAccountCreation();
	}
	
}
