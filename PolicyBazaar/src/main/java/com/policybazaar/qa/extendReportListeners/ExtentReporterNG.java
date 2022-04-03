package com.policybazaar.qa.extendReportListeners;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReporterNG  {
	
	private ExtentReports report;
	private ExtentTest extentTest;
	private ExtentHtmlReporter htmlReport;

	//private ExtentReports extent;


	public ExtentTest setExtentLogger(String methodName) {
		extentTest = report.createTest(methodName);
		return extentTest;
	}
	
	public void flushReport() {
		report.flush();
	}

	
	public String time() {
		Date date = new Date();
		String[] time = date.clone().toString().replaceAll(":", "_").split(" ");
		String requir = time[2] + "_" + time[1] + "_" + time[3];
		return requir;
	}

	public void initHtmlReport() {
		htmlReport = new ExtentHtmlReporter(".\\Reports\\" + time() + "_PolicyBazaar.html");
		htmlReport.config().setDocumentTitle("PolicyBazaar_ExtentReport");
		htmlReport.config().setReportName("Automation_Report");
		htmlReport.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Host Name", "Vikas Sahu");
		report.setSystemInfo("Enviromenet", "QA");
		report.setSystemInfo("OS", "Window");

	}

	
	
	
	public ExtentTest getExtentTestLogger() {
		return extentTest;
	}	
	
	
	
	
//	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites) {
//		extent = new ExtentReports("Reports/"+ time()+ ".html");
//
//		for (ISuite suite : suites) {
//			Map<String, ISuiteResult> result = suite.getResults();
//
//			for (ISuiteResult r : result.values()) {
//				ITestContext context = r.getTestContext();
//
//				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
//				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
//				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
//			}
//		}
//
//		extent.flush();
//		extent.close();
//	}

	
	
	
	
	
	
	
	
//	private void buildTestNodes(IResultMap tests, LogStatus status) {
//		ExtentTest test;
//
//		if (tests.size() > 0) {
//			for (ITestResult result : tests.getAllResults()) {
//				test = extent.startTest(result.getMethod().getMethodName());
//
//				test.setStartedTime(getTime(result.getStartMillis()));
//				test.setEndedTime(getTime(result.getEndMillis()));
//
//				for (String group : result.getMethod().getGroups())
//					test.assignCategory(group);
//
//				if (result.getThrowable() != null) {
//					test.log(status, result.getThrowable());
//				} else {
//					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
//				}
//
//				extent.endTest(test);
//			}
//		}
//	}

	
	
	
	
	
	
	
	
	
//	public void onTestFailure(ITestResult result) {
//		// util.getSnapShot(result.getName());
//	}

	
	
	
	
	
	
	
//	private Date getTime(long millis) {
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTimeInMillis(millis);
//		return calendar.getTime();
//	}
//	
	
}
