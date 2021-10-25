package com.evs.vtiger.utils;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WdUtil {

	private WebDriver  driver;

    public WebDriver getDriver() {
    	return driver;
    }

	public  void launchBrowser(String browser) {

        if(browser.equalsIgnoreCase("CH")) {
        	System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
    		driver=new ChromeDriver(); 
        }else if(browser.equalsIgnoreCase("FF")) {
        	System.setProperty("webdriver.gecko.driver","Drivers\\geckodriver.exe");
    		driver=new FirefoxDriver(); 
        }else {
        	System.out.println(browser+" - browser name is wrong. Please check");
        }
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);



	}

	public void openUrl(String url) {
		driver.get(url);

	}


	public  void click(String locatorType, String locatorValue) {
		WebElement we=getElement(locatorType, locatorValue);
		if(we.isDisplayed()) {
			System.out.println("displayed"); 
			if(we.isEnabled()){
				we.click();
				System.out.println("Enabled");			
			}

		}

	}

	public  void sendkeys(String xpath,String input,String locatorValue) {
		WebElement we=getElement(xpath,locatorValue);
		we.clear();
		if(we.getSize().getHeight()>0 && we.getSize().getWidth()>0) {
			if(we.isDisplayed()) {
				if(we.isEnabled()) {
					we.sendKeys(input);
					System.out.println("displayed");
				}
			}else {
				System.out.println("not displayed");
			}
		}  
	}

	public  String getText(String xpath,String locatorValue) {
		WebElement we=getElement(xpath,locatorValue);
		String text=we.getText();
		System.out.println(text);
		return text;	



	}
	
	public WebElement  getElement(String locatorType, String locatorValue) {
		WebElement we=null;
		if(locatorType.equalsIgnoreCase("xpath")) {
			we=driver.findElement(By.xpath(locatorValue));
	
		}else if(locatorType.equalsIgnoreCase("css")) {
			we=driver.findElement(By.cssSelector(locatorValue));
	
		}else if(locatorType.equalsIgnoreCase("name")) {
			we=driver.findElement(By.name(locatorValue));
	
		}else if(locatorType.equalsIgnoreCase("id")) {
			we=driver.findElement(By.id(locatorValue));
	
		}else {
			System.out.println("locator type is wrong");
		}
		
		
		return we;
	}
	
	
	public void mouseOver(String locatorType, String locatorValue) {
		WebElement we=getElement(locatorType, locatorValue);
		Actions action=new Actions(driver);
		action.moveToElement(we).build().perform();

	}

	public void findElements() {

	}


	public  String getCssValue(WebElement we,String cssvalue) {
		String cssValue=we.getCssValue(cssvalue);
		return cssValue;
	}


	public  void actDragAnddrop(WebElement we,WebElement we1) {
		Actions action=new Actions(driver);
		action.dragAndDrop(we, we1).build().perform();
	}

	public  void actClickAndHold(String xpath, String locatorValue) {
		WebElement we=getElement(xpath,locatorValue);
		Actions action=new Actions(driver);
		action.clickAndHold(we).build().perform();
	}
	public  void actRightClick(String xpath, String locatorValue) {
		WebElement we=getElement(xpath, locatorValue);
		Actions action=new Actions(driver);
		action.contextClick(we).build().perform();
	}

	public String getAttribute(String xpath, String locatorValue) {
		WebElement we=getElement(xpath,locatorValue);
		String attri=we.getAttribute(null);
		return attri;
	}

	public  Point getLocation(String xpath, String locatorValue) {
		WebElement we=getElement(xpath,locatorValue);
		Point location=we.getLocation();
		int x=location.getX();
		System.out.println(x);
		int y=location.getY();
		System.out.println(y);
		return location;
	}

	public  Dimension getSize(WebElement we) {
		Dimension dim=we.getSize();	   
		int hight=dim.getHeight();
		System.out.println(hight);
		int width=dim.getWidth();
		System.out.println(width);
		return dim;
	}


	public  String getTagName(String xpath, String locatorValue) {
		WebElement we=getElement(xpath,locatorValue);
		String tagName=we.getTagName();	
		return tagName;
	}
	public void holdOn(int num) {
		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public  void clear(WebElement we) {
		we.clear();	   
	}
	public  void selectByIndex(WebElement we,int num) {
		Select sel=new Select(we);	
		sel.selectByIndex(num);   
	}

	public  void actDoubleClick(WebElement we) {
		Actions action=new Actions(driver);	
		action.doubleClick(we).build().perform();
	}

	public  void selectByValue(WebElement we,String val) {
		Select sel=new Select(we);
		sel.selectByValue(val);
	}

	public  void selectByVisibleText(WebElement we,String args) {
		Select sel=new Select(we);
		sel.selectByVisibleText(args);
	}

	public  void deselectByAllElements(WebElement we) {
		Select sel=new Select(we);
		sel.deselectAll();
	}

	public  void popupAlertAccept() {
		driver.switchTo().alert().accept();	   
	}

	public  void popupAlertDismiss() {
		driver.switchTo().alert().dismiss();	   
	}

	public  void getWindowHandle() {


	}

	public  void switchToWindowByTitle(WebElement se) {
		Set<String> ha =driver.getWindowHandles();
		for(String handle:ha) {
			driver.switchTo().window(handle);
			String title =driver.getTitle();
			System.out.println(title); 
		}
	}

	public WebDriver  frame(int args) {
		WebDriver frem=driver.switchTo().frame(args);	
		return frem;
	}

	public WebDriver  frame(WebElement args) {
		WebDriver frem=driver.switchTo().frame(args);
		return frem;
	}

	public  WebDriver frame(String args) {
		WebDriver frem=driver.switchTo().frame(args);
		return frem;
	}
	public WebDriver parentFrame() {
		WebDriver par=driver.switchTo().parentFrame();
		return par;
	}

	public WebDriver defaultContent() {
		WebDriver par=driver.switchTo().defaultContent();
		return par;
	}

	public String getCurrentUrl() {
		String currentUrl=driver.getCurrentUrl();	
		return currentUrl;

	}

	public void actMoveToElement(WebElement we) {	
		Actions action=new Actions(driver);
		action.moveToElement(we).build().perform();
	}

	public String PopupAlertgetText() {
		String text=driver.switchTo().alert().getText();
		return text;

	}

	
	
	
	
}
