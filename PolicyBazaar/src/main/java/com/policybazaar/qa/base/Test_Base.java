package com.policybazaar.qa.base;


import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.policybazaar.qa.extendReportListeners.ExtentReporterNG;
import com.policybazaar.qa.webUtil.TestUtil;


public class Test_Base {

	
	
	protected TestUtil util = new TestUtil();
	public static ExtentReporterNG extendReport ;
	

	
	
	
	
	@BeforeSuite(alwaysRun = true)
	public void beforSuite() {
		 extendReport = new ExtentReporterNG();
		extendReport.initHtmlReport();
	}

	
	

	
	
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method methodName) {
		extendReport.setExtentLogger(methodName.getName());
		util.intializationAndLaunchBrowser();
		util.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(util.getIMPLICIT_WAIT()));
		util.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(util.getPAGE_LOAD_TIMEOUT()));
		util.getDriver().manage().window().maximize();
		util.hiturl(util.getPropertiesFile().getProperty("QA_Investment_Testing_Url"));
		//util.hiturl(util.getPropertiesFile().getProperty("QA_Term_Testing_Url"));
	}
	
	
	/*
	 * ** Create Test_base class constructor for load our configure file to fetch
	 * some common TestData **
	 */

	public Test_Base() {
		util.loadConfigFile();
	}

	
	
	
	
//     **   create intializationAndLaunchBrowser method for launch browser and hit Url  **   //	


	
	
	

	
	
	
	@AfterMethod(alwaysRun = true)
	public void failSnapShot(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String snapShotPath = util.getfailSnapShot(result.getName());
			extendReport.getExtentTestLogger().log(Status.FAIL, result.getName() + " is fail");
			try {
				extendReport.getExtentTestLogger().addScreenCaptureFromPath(snapShotPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			extendReport.getExtentTestLogger().log(Status.SKIP, result.getName() + " is skip");

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extendReport.getExtentTestLogger().log(Status.PASS, result.getName() + " is pass");
		}

		//util.browserClose();
	}
	
	
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		extendReport.flushReport();
	}
	
}
