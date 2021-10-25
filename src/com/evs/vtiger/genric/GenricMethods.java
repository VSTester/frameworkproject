package com.evs.vtiger.genric;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenricMethods  {
WebDriver driver ;
	
	public void launchBrowser() {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\toshiba\\eclipse-workspace\\VtigerTestingWithGenricMethods\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://localhost:8888/");
	
}
	
	public WebElement findElementBYXpath(String X_PATH) {
		return driver.findElement(By.xpath(X_PATH));
	}

	public WebElement findElementBYLink(String Link) {
		return driver.findElement(By.linkText(Link));
	}

	public WebElement findElementBYPartialLink(String Link) {
		return driver.findElement(By.partialLinkText(Link));
	}

	public WebElement findElementBYName(String Name) {
		return driver.findElement(By.name(Name));
	}

	public WebElement findElementBYClassName(String name) {
		return driver.findElement(By.name(name));
	}

	public WebElement findElementBYTageName(String name) {
		return driver.findElement(By.xpath(name));
	}

	public WebElement findElementBYID(String id) {
		return driver.findElement(By.id(id));
	}

	public void clickOnElement(WebElement we) {
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			System.out.println("element is visible in UI");
			if (we.isDisplayed()) {
				System.out.println("element is avilable for work");
				we.click();
				System.out.println("performnce is seccsussfull");
			} else
				System.out.println("eleement is not available for work");
		} else
			System.out.println("element is not visible in UI");
	}

	public String inputOnElement(WebElement we, String value) {
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			System.out.println("element is visible in UI");
			if (we.isDisplayed()) {
				System.out.println("element is avilable for work");
				we.sendKeys(value);
				System.out.println("performnce is seccsussfull");
			} else
				System.out.println("eleement is not available for work");
		} else
			System.out.println("element is not visible in UI");
		return value;
	}

	public void closeAllWindowWithoutExpected(String title) {
		Set<String> hndlval = driver.getWindowHandles();
		for (String handle : hndlval) {
			driver.switchTo().window(handle);
			String windowTitle = driver.getTitle();
			if (!windowTitle.equals(title)) {
				driver.close();
			}
		}
	}

	public void focusOnhandleWindow(String url) {
		Set<String> hndlval = driver.getWindowHandles();
		for (String handle : hndlval) {
			driver.switchTo().window(handle);
			String windowUrl = driver.getCurrentUrl();
			if (windowUrl.equals(url)) {
				driver.switchTo().window(handle);
			}
		}
	}

	public void screenShot(String filename) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file,
					new File("C:\\Users\\toshiba\\eclipse-workspace\\VtigerTestingWithGenricMethods\\screenShots/"
							+ (filename + (int) (Math.random() * 100)) + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		}

	public void selectValueByIndex(WebElement we, int INDEX) {
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			System.out.println("element is visible in UI");
			if (we.isDisplayed()) {
				System.out.println("element is avilable for work");
				Select se = new Select(we);
				se.selectByIndex(INDEX);
				System.out.println("performnce is seccsussfull");
			} else
				System.out.println("eleement is not available for work");
		} else
			System.out.println("element is not visible in UI");
	}

	public void selectValueByValue(WebElement we, String VALUE) {
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			System.out.println("element is visible in UI");
			if (we.isDisplayed()) {
				System.out.println("element is avilable for work");
				Select se = new Select(we);
				se.selectByValue(VALUE);
				System.out.println("performnce is seccsussfull");
			} else
				System.out.println("eleement is not available for work");
		} else
			System.out.println("element is not visible in UI");
	}

	public void selectValueByRealValue(WebElement we, String REAL_VALUE) {
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			System.out.println("element is visible in UI");
			if (we.isDisplayed()) {
				System.out.println("element is avilable for work");
				Select se = new Select(we);
				se.selectByVisibleText(REAL_VALUE);
				System.out.println("performnce is seccsussfull");
			} else
				System.out.println("eleement is not available for work");
		} else
			System.out.println("element is not visible in UI");
	}

	public void moveOnElement(WebElement we) {
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			System.out.println("element is visible in UI");
			if (we.isDisplayed()) {
				System.out.println("element is avilable for work");
				Actions action = new Actions(driver);
				action.moveToElement(we).build().perform();
				System.out.println("performnce is seccsussfull");
			} else
				System.out.println("eleement is not available for work");
		} else
			System.out.println("element is not visible in UI");
	}

	public void acClick(WebElement we) {
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			System.out.println("element is visible in UI");
			if (we.isDisplayed()) {
				System.out.println("element is avilable for work");
				Actions action = new Actions(driver);
				action.moveToElement(we).click().build().perform();
				System.out.println("performnce is seccsussfull");
			} else
				System.out.println("eleement is not available for work");
		} else
			System.out.println("element is not visible in UI");
	}

	public void acDragAndDrop(WebElement we1, WebElement we2) {
		if (we1.getSize().getHeight() > 0 && we1.getSize().getWidth() > 0 && we2.getSize().getHeight() > 0
				&& we2.getSize().getWidth() > 0) {
			System.out.println("element is visible in UI");
			if (we1.isDisplayed() && we2.isDisplayed()) {
				System.out.println("element is avilable for work");
				Actions action = new Actions(driver);
				action.dragAndDrop(we1, we2).perform();
				System.out.println("performnce is seccsussfull");
			} else
				System.out.println("eleement is not available for work");
		} else
			System.out.println("element is not visible in UI");
	}

	public void acDoubleClick(WebElement we) {
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			System.out.println("element is visible in UI");
			if (we.isDisplayed()) {
				System.out.println("element is avilable for work");
				Actions action = new Actions(driver);
				action.moveToElement(we).doubleClick().build().perform();
				System.out.println("performnce is seccsussfull");
			} else
				System.out.println("eleement is not available for work");
		} else
			System.out.println("element is not visible in UI");
	}

	public void acRightClick(WebElement we) {
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			System.out.println("element is visible in UI");
			if (we.isDisplayed()) {
				System.out.println("element is avilable for work");
				Actions action = new Actions(driver);
				action.moveToElement(we).contextClick().build().perform();
				System.out.println("performnce is seccsussfull");
			} else
				System.out.println("eleement is not available for work");
		} else
			System.out.println("element is not visible in UI");
	}

	public String acInputValue(WebElement we, String VALUE) {
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			System.out.println("element is visible in UI");
			if (we.isDisplayed()) {
				System.out.println("element is avilable for work");
				Actions action = new Actions(driver);
				action.sendKeys(we, VALUE).build().perform();
				System.out.println("performnce is seccsussfull");
			} else
				System.out.println("eleement is not available for work");
		} else
			System.out.println("element is not visible in UI");
		return VALUE;
	}

	public void alertAccept() {
		driver.switchTo().alert().accept();
	}

	public void alertDismiss() {
		driver.switchTo().alert().dismiss();
	}

	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public void getUrl(String URL) {
		driver.get(URL);
	}

	public String getTextFromAlert() {
		String text = driver.switchTo().alert().getText();
		return text;
	}

	public void frameHandleByIndex(WebElement we, int INDEX) {
		if (we.isEnabled()) {
			System.out.println("element is avilable for work");
			driver.switchTo().frame(INDEX);
			System.out.println("performnce is seccsussfull");
		} else
			System.out.println("eleement is not available for work");
	}

	public void frameHandleByName(WebElement we, String NAME) {
		if (we.isEnabled()) {
			System.out.println("element is avilable for work");
			driver.switchTo().frame(NAME);
			System.out.println("performnce is seccsussfull");
		} else
			System.out.println("eleement is not available for work");
	}

	public void frameHandleByWebElement(WebElement we) {
		if (we.isEnabled()) {
			System.out.println("element is avilable for work");
			driver.switchTo().frame(we);
			System.out.println("performnce is seccsussfull");
		} else
			System.out.println("eleement is not available for work");
	}

	public int getEementHeight(WebElement we) {
		int height = 0;
		if (we.isDisplayed() && we.isEnabled()) {
			height = we.getSize().getHeight();
		} else {
			System.out.println("element is not avilable for work");
		}
		return height;
	}

	public int getEementWidth(WebElement we) {
		int Width = 0;
		if (we.isDisplayed() && we.isEnabled()) {
			Width = we.getSize().getWidth();
		} else
			System.out.println("element is not avilable for work");
		return Width;
	}

	public String getEementAttributeValue(WebElement we, String Value) {
		String value = null;
		if (we.isDisplayed() && we.isEnabled()) {
			value = we.getAttribute(Value);
		} else
			System.out.println("element is not avilable for work");
		return value;
	}

	public String getPageTitle() {
		String title = null;
			title = driver.getTitle();
		return title;
	}

	
	public String getElementText(WebElement we) {
		String title = we.getText();
		return title;
	}
	public Point getElementLocation(WebElement we) {
		Point location = null;
		if (we.isDisplayed()) {
			location = we.getLocation();
		} else
			System.out.println("element is not avilable for work");
		return location;
	}

	public void wDWElementIsClickable(WebElement we) {
		WebDriverWait wait = new WebDriverWait(driver, 45);
		wait.until(ExpectedConditions.elementToBeClickable(we));
	}

	public void wDWSwitchToFrame(WebElement we) {
		WebDriverWait wait = new WebDriverWait(driver, 45);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(we));
	}

	public void jsClickOnElement(WebElement we) {
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			System.out.println("element is visible in UI");
			if (we.isDisplayed()) {
				System.out.println("element is avilable for work");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeAsyncScript("arguments[0].click();", we);
				System.out.println("performnce is seccsussfull");
			} else
				System.out.println("eleement is not available for work");
		} else
			System.out.println("element is not visible in UI");
	}

	public void jsSendValue(WebElement we, String input) {
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			System.out.println("element is visible in UI");
			if (we.isDisplayed()) {
				System.out.println("element is avilable for work");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeAsyncScript("arguments[0].value=" + "'" + input + ";" + "'", we);
				System.out.println("performnce is seccsussfull");
			} else
				System.out.println("element is not available for work");
		} else
			System.out.println("element is not visible in UI");
	}


}