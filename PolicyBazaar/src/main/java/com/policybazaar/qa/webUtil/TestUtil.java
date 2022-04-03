package com.policybazaar.qa.webUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.common.io.Files;
import com.policybazaar.qa.base.Test_Base;
import com.policybazaar.qa.extendReportListeners.ExtentReporterNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
@NoArgsConstructor
public class TestUtil extends ExtentReporterNG {

	private SoftAssert sAssert;
	private Select select;
	private Actions actions;
	@Getter
	private WebDriver driver;
	@Getter
	private Properties propertiesFile;
	@Getter
	private Logger log = Logger.getLogger("devpinoyLogger");
	@Getter
	private long IMPLICIT_WAIT = 40;
	@Getter
	private long PAGE_LOAD_TIMEOUT = 55;

	/*
	 * ** Constructor ** We create for get the WebDriver reference. This reference
	 * we use in Actions class
	 */
	
	

	// *** Objects Methods*** //

	public void selectClassObj(WebElement element) {
		select = new Select(element);
	}

	public void actionClassObj() {
		actions = new Actions(driver);
	}

	public SoftAssert softAssertObj() {
		sAssert = new SoftAssert();
		return sAssert;
	}


	
	
	// ** WebElement Methods** //

	public void clickOnElement(WebElement element) {
		Assert.assertEquals(true, elementIsDisplayed(element));
		element.click();
		Test_Base.extendReport.getExtentTestLogger().log(Status.INFO,
				"click on element by clickOnElemen method, Element name is   " + getLocator(element));
	}

	public void input(WebElement element, String testValue) {
		Assert.assertEquals(true, elementIsDisplayed(element));
		element.sendKeys(testValue);
		Test_Base.extendReport.getExtentTestLogger().log(Status.INFO,
				"value eneter in text field by input method  " + getLocator(element));
	}

	public void clean(WebElement element) {
		element.clear();
       log.debug("your field is clear");
       Test_Base.extendReport.getExtentTestLogger().log(Status.INFO,
				getLocator(element)+ " field is clear");
	}

	public void slowInput(WebElement element, String testValue) {
		Assert.assertEquals(true, elementIsDisplayed(element));
		//String[] value = testValue.split("");
		for (int i = 0; i < testValue.length(); i++) {
			try {
				Thread.sleep(50);
				element.sendKeys(testValue.substring(i, i+1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Test_Base.extendReport.getExtentTestLogger().log(Status.INFO,
				"value eneter in text field by slowInput method  " + getLocator(element));
	}
	
	
	
	
	// ** Select Methods** //
	public void selectDropDownByIndex(WebElement element, int valueIndex) {
		sAssert = new SoftAssert();
		sAssert.assertEquals(true, elementIsDisplayed(element));
		if (true == elementIsDisplayed(element)) {
			selectClassObj(element);
			select.selectByIndex(valueIndex);
			log.debug("sucessfull select value in drop down by index");
			Test_Base.extendReport.getExtentTestLogger().log(Status.INFO,
					"value select by Index method" + getLocator(element));
		} else {
			log.debug("your element:(" + getLocator(element) + " ) is not visible so, value is not select");
		}
	}

	public void selectDropDownByValue(WebElement element, String value) {
		sAssert = new SoftAssert();
		sAssert.assertEquals(true, elementIsDisplayed(element));
		if (true == elementIsDisplayed(element)) {
			selectClassObj(element);
			select.selectByValue(value);
			log.debug("sucessfull select value in drop down by value");
		} else {
			log.debug("your element:(" + getLocator(element) + " ) is not visible so, value is not select");
		}
	}

	public void selectDropDownByVisibleText(WebElement element, String visibleText) {
 		sAssert = new SoftAssert();
		sAssert.assertEquals(true, elementIsDisplayed(element));
		if (true == element.isDisplayed()) {
			selectClassObj(element);
			select.selectByVisibleText(visibleText);
			log.debug("sucessfull select value in drop down by visibleText");
			Test_Base.extendReport.getExtentTestLogger().log(Status.INFO,
					"value is select by visible text method" + getLocator(element));
		} else {
			log.debug("your element:(" + getLocator(element) + " ) is not visible so, value is not select");
		}
	}

	public WebElement getFirstSelectedValueInDD(WebElement element) {
		sAssert = new SoftAssert();
		sAssert.assertEquals(true, elementIsDisplayed(element));
		if (true == element.isDisplayed()) {
			selectClassObj(element);
			element = select.getFirstSelectedOption();
			log.debug("your first selected value is : " +element);
		} else {
			log.debug("your element:(" + getLocator(element) + " ) is not visible ");
		}
		return element;
	}

	public void disselectDropDownByIndex(WebElement element, int valueIndex) {
		sAssert = new SoftAssert();
		sAssert.assertEquals(true, elementIsDisplayed(element));
		if (true == elementIsDisplayed(element)) {
			selectClassObj(element);
			select.deselectByIndex(valueIndex);
			log.debug("sucessfull disselect value in drop down by index");
		} else {
			log.debug("your element:(" + getLocator(element) + " ) is not visible so, value is not disselect");
		}
	}

	public void disselectDropDownByValue(WebElement element, String value) {
		sAssert = new SoftAssert();
		sAssert.assertEquals(true, elementIsDisplayed(element));
		if (true == elementIsDisplayed(element)) {
			selectClassObj(element);
			select.selectByValue(value);
			log.debug("sucessfull disselect value in drop down by value");
		} else {
			log.debug("your element:(" + getLocator(element) + " ) is not visible so, value is not dsselect");
		}
	}

	public void disselectDropDownByVisibleText(WebElement element, String visibleText) {
		sAssert = new SoftAssert();
		sAssert.assertEquals(true, elementIsDisplayed(element));
		if (true == elementIsDisplayed(element)) {
			selectClassObj(element);
			select.selectByVisibleText(visibleText);
			log.debug("sucessfull disselect value in drop down by visible text");
		} else {
			log.debug("your element:(" + getLocator(element) + " ) is not visible so, value is not disselect");
		}
	}

	public List<WebElement> getAllDropDownValue(WebElement element) {
		List<WebElement> allDropDownElement = null;
		sAssert = new SoftAssert();
		sAssert.assertEquals(true, elementIsDisplayed(element));
		if (true == elementIsDisplayed(element)) {
			selectClassObj(element);
			allDropDownElement = select.getOptions();
			log.debug("your all element is : "+ allDropDownElement);
		} else {
			log.debug("your element:(" + getLocator(element) + " ) is not visible");
		}
		return allDropDownElement;
	}
	
	
	
	
	
	
	
	
	
	
	// **Action Class Method** //
	public void acClickOnElement(WebElement element) {
		String locator = getLocator(element);
		if (true == element.isDisplayed()) {
			actionClassObj();
			actions.click(element).build().perform();
			log.debug("click on element is sucessfull");
			Test_Base.extendReport.getExtentTestLogger().log(Status.INFO,
					"click on element by acclickOnElemen method, Element name is   " + locator);
		} else {
			log.debug("your element:(" + locator + " ) is not visible so, click is not done");
		}
	}

	public void acInput(WebElement element, String testValue) {
		sAssert = new SoftAssert();
		sAssert.assertEquals(true, elementIsDisplayed(element));
		if (true == elementIsDisplayed(element)) {
			actionClassObj();
			actions.sendKeys(element, testValue).build().perform();
			log.debug("enter " + testValue + "is sucessfull");
			Test_Base.extendReport.getExtentTestLogger().log(Status.INFO,
					"enter value by acInput method, Element name is   " + getLocator(element));
		} else {
			log.debug("your element:(" + getLocator(element) + " ) not visible so, driver is able to enter " + testValue);
		}
	}

	public void acMouseOver(WebElement element) {
		sAssert = new SoftAssert();
		sAssert.assertEquals(true, elementIsDisplayed(element));
		if (true == elementIsDisplayed(element)) {
			actionClassObj();
			actions.moveToElement(element).build().perform();
			log.debug("twice click is sucessfull");
			Test_Base.extendReport.getExtentTestLogger().log(Status.INFO,
					"mouseover on element by acMouseOver method, Element name is   " + getLocator(element));
		} else {
			log.debug("your element:(" + getLocator(element) + " ) is not visible so, twice click is not done");
		}
	}

	public void twiceClick(WebElement element) {
		sAssert = new SoftAssert();
		sAssert.assertEquals(true, elementIsDisplayed(element));
		if (true == elementIsDisplayed(element)) {
			actionClassObj();
			actions.doubleClick(element).build().perform();
			log.debug("twice click is sucessfull");
		} else {
			log.debug("your " + getLocator(element) + " is not visible so, twice click is not done");
		}
	}	
	
	
	
	
	
	
	
	// ** Get Methods ** //
	public boolean elementIsDisplayed(WebElement element) {
		boolean displayedElement = element.isDisplayed();
		if (displayedElement==true) {
			log.debug("your element:(" + getLocator(element) + " ) is displayed");
		}
		else
			log.debug("your element:(" + getLocator(element) + " ) is not displayed");
		return displayedElement;
	}

	public boolean elementIsSelected(WebElement element) {
		boolean selectedElement = element.isSelected();
		if (selectedElement==true) {
			log.debug("your element:(" + getLocator(element) + " ) is selected");
		}
		else
			log.debug("your element:(" + getLocator(element) + " ) is not selected");	
		return selectedElement;
	}

	public String getCurrenWindowUrl() {
		String currentWindowUrl = driver.getCurrentUrl();
		log.debug("your current url is :  "+ currentWindowUrl);
		return currentWindowUrl;
	}

	public String windowTitle(WebElement element) {
		String title = driver.getTitle();
		log.debug("your window title is :  "+title);
		return title;
	}

	
	
	
//	//    **   get reference **  //
//	public WebDriver getBrowserDriver() {
//		return driver;
//	}
//
//	public Properties getconfigureProperties() {
//		return propertiesFile;
//	}

	
	
	
	
	
	
	
	// ** Methods for Elements ** //
	public String getElementText(WebElement element) {
		String elementText = element.getText();
		log.debug("your element text is :  " +elementText);
		return elementText;
	}

	public String getElementAttributeValue(WebElement element, String attributeName) {
		String attributeValue = element.getAttribute(attributeName);
		log.debug("your attribute is : "+ attributeValue);
		return attributeValue;
	}

	public Point elementLocation(WebElement element) {
		Point point = element.getLocation();
		return point;
	}
	
	
	
	
	
	
	
	
	

	// ** Method for Url hit in browser and close ** //
	public void hiturl(String Url) {
		driver.get(Url);
	}

	public void browserClose() {
		driver.quit();
		log.debug("close all open window");
	}

	public void currentWindowClose() {
		driver.close();
		log.debug("close current open window");
	}
	
	
	
	
	
//    **  Method for get current Time  **  //
	public String time() {
		Date date = new Date();
		String[] time = date.clone().toString().replaceAll(":", "_").split(" ");
		String requir = time[2] + "_" + time[1] + "_" + time[3]+"_";
		return requir;
	}

public String getLocator(WebElement element) {
	String[] arry =element.toString().split("->");
	return arry[1];
}
	
	
	
	
	
	
	
//    ** Snap Shot Methods  **  //	
	public void getSnapShot(String methodName) {
		File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(file,new File(".//FailSnapShot/"+methodName+time()+ ".png"));
			log.debug("capture Snap sucessfull");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public String getfailSnapShot(String methodName) {
		TakesScreenshot tcc = ((TakesScreenshot) getDriver());
		File srcFile = tcc.getScreenshotAs(OutputType.FILE);
		File desFile = new File(".//FailSnapShot/" + time() + methodName + ".png");
		String path = desFile.getAbsolutePath();

		try {
			Files.copy(srcFile, desFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
	
	
	public void getFullPageSnapShot(String methodName) {

		Screenshot screenShot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(10))
				.takeScreenshot(driver);
		try {
			ImageIO.write(screenShot.getImage(), "jpg", new File(".//FullPageSnapShot/"+methodName + time() + ".png"));
			log.debug("capture Full page snap sucessfull");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	// ** Browser launch and configure file load ** //
		public WebDriver intializationAndLaunchBrowser() {
		String launchBrowserName = propertiesFile.getProperty("Browser_Name");
		System.out.println("browser name is " + launchBrowserName);
		Test_Base.extendReport.getExtentTestLogger().log(Status.INFO,
				"browser name is :  " +launchBrowserName);
		if (launchBrowserName.equalsIgnoreCase("chrome")) {
			log.debug("browser name is " + launchBrowserName);
			WebDriverManager.chromedriver().setup();
			ChromeOptions chOptionObj = new ChromeOptions();
			chOptionObj.addArguments("--incognito");
			chOptionObj.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			// chOptionObj.addArguments("--headless");
			driver = new ChromeDriver(chOptionObj);
		} else if (launchBrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fireFoxObj = new FirefoxOptions();
			fireFoxObj.addArguments("-private");
			driver = new FirefoxDriver(fireFoxObj);
		}
		log.debug("browser launch succesfull");
		return driver;
		
	}

	
	
	
	
	
	
	//    **  method for load configure file  **  //
	public Properties loadConfigFile() {
		
		try {
			propertiesFile = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\policybazaar\\qa\\configure\\configure.Properties");
			propertiesFile.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return propertiesFile;
	}

	
	
	
	
	
	
	//    ** Method for get reference of Excel  **  //
	public Map<String, String> getExcelRf() {
		ExcelReader reader = new ExcelReader(getPropertiesFile().getProperty("Excel_Sheet_Path"),0);
		Map<String, String> data = reader.getTestCaseData(getPropertiesFile().getProperty("TestCaseId"));
		return data;
	}

	
	
	
	
	
	
	
	// ** verification Methods ** //
	public void verifyMethod(String expected, String actual) {
		if (expected.contains(actual)) {
			Test_Base.extendReport.getExtentTestLogger().log(Status.PASS,
					MarkupHelper.createLabel(actual + " is equal to  " + expected, ExtentColor.GREEN));
			log.debug(actual + " is equal to  " + expected);
		} else {
			sAssert = softAssertObj();
			sAssert.assertEquals(actual, expected);
			Test_Base.extendReport.getExtentTestLogger().log(Status.FAIL,
					MarkupHelper.createLabel(actual + " is not equal to " + expected, ExtentColor.RED));
			log.debug(actual + " is not equal to " + expected);
		}
	}
	
	public void verifyByInnerText(WebElement element, String expected) {
	String actual = getElementText(element);
	    verifyMethod(expected,actual);	
	}
	
	public void verifyByAttributeValue(WebElement element, String attributeName, String expected) {
	String actual=	getElementAttributeValue(element,attributeName);
	verifyMethod(expected, actual);
		
	}
	
	

	
	
	
	
	
	

	// ** Method for Wait ** //
	public void holdScript(int time) {
		time = time * 1000;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	
	
	
	
	
	
	
	
	
	
	
	
	

   //   ** Scroll Down  **  //
	
	public void jsScrollDownTillEleFound(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public void jsScrollUpDown(double y_Coordinate) {
		y_Coordinate = y_Coordinate*1000;
		JavascriptExecutor js=   ((JavascriptExecutor)driver);
		   js.executeScript("window.scrollBy(0,"+y_Coordinate+")");
		   if (y_Coordinate>0) {
			   log.debug("Scroll Down sucessfull");	
		}else
			log.debug("Scroll up sucessfull");
	}

	public void jsScrollRightLeft(double x_Coordinate) {
		x_Coordinate = x_Coordinate*1000;
		JavascriptExecutor js=   ((JavascriptExecutor)driver);
		   js.executeScript("window.scrollBy("+x_Coordinate+",0)");
		   if (x_Coordinate>0) {
			   log.debug("Scroll right sucessfull");	
		}else
			log.debug("Scroll left sucessfull");
	}

	
	
	
	
	
	
	
	public int changeStringToInt(String value) {
		int intValue = Integer.parseInt(value);
		return intValue;
		
		
	}
	
	
	
	
	// =============== WebDriverWait=============\\
	
	
	
	public void waitTillElementIsVisible(WebElement element, int waitTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForElementToBeClickable(WebElement element, int waitTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitTillInvisibilityOfElement(WebElement element, int waitTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
		
	
	
	
	
	
	
	
	











