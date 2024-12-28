package com.training.base;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.*;
import java.text.*;

public class BasePage {

	private static final TimeUnit seconds = null;
	static WebDriver driver;
	WebDriverWait wait;
	String presentPageName;

	static HashMap<String, By> objectRepo = new HashMap<>();
	HashMap<String, Object> objectRepo1 = new HashMap<>();

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void addObject(String elementName, By by) {
		objectRepo.put(elementName, by);
	}

	public String getPageName() {
		return presentPageName;
	}

	public void setPageName(String presentPageName) {
		this.presentPageName = presentPageName;
	}

	public static WebElement getElement(String elementName) {
		By by = objectRepo.get(elementName);
		WebElement element = driver.findElement(by);
		return element;
	}

	public void waitForTheVisibilityOfElement(WebElement element, int time) {
		wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitForElementToBeVisibleByLocator(By locator) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			Assert.fail("element is not visible after given time : " + locator);
		}
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	public void waitForElementToBeInvisibleByLocator(By locator) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (Exception e) {
			Assert.fail("element is not visible after given time : " + locator);
		}
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	public void enterIntoTextbox(String elementName, String value) {
		WebElement element = getElement(elementName);
		if (element.isDisplayed()) {
			element.clear();
		} else {
			System.out.println("No such element is displayed");
		}
		element.sendKeys(value);
	}

	public void enterTextByJS(String elementName, String value) {
		WebElement element = getElement(elementName);
		if (element.isDisplayed()) {
			element.clear();
		} else {
			System.out.println("No such element is displayed");
		}
		String js = "arguments[0].value='" + value + ",;";
		((JavascriptExecutor) driver).executeScript(js, element);
	}

	public void enterTextByAction(String elementName, String value) {
		WebElement element = getElement(elementName);
		if (element.isDisplayed()) {
			element.clear();
		} else {
			System.out.println("No such element is displayed");
		}
		Actions actions = new Actions(driver);
		actions.click(element).sendKeys(Keys.RETURN).build().perform();
	}

	public void waitAndEnterIntoTextbox(String elementName, String value) {

		WebElement element = getElement(elementName);
		if (element.isDisplayed()) {
			element.clear();
		} else {
			System.out.println("No such element is displayed");
		}
		element.sendKeys(value);
	}

	public void clickOnButton(String elementName) {

		WebElement element = getElement(elementName);
		if (element.isDisplayed()) {
			element.click();
		} else {
			System.out.println("No such element is displayed");
		}

	}

	public void waitAndClickOnButton(String elementName) {

		WebElement element = getElement(elementName);
		waitForTheVisibilityOfElement(element, 10);
		if (element.isDisplayed()) {
			element.click();
		} else {
			System.out.println("No such element is displayed");
		}

	}

	public void validateText(String logicalName, String expectedText) {
		WebElement element = getElement(logicalName.toLowerCase());
		scrollToView(logicalName);
		String actualText;
		if (isElementVisible(element)) {
			actualText = element.getText();
		} else {
			scrollToViewBottom(logicalName);
			if (isElementVisible(getElement(logicalName.toLowerCase()))) {
				actualText = getElement(logicalName.toLowerCase()).getText();
			} else {
				actualText = "";
			}
		}
		assertEquals(actualText, expectedText);
		System.out.println(actualText);
		System.out.println(expectedText);
	}

	public String getTextOfFirstVisibleElement(String logicalName) {
		List<WebElement> elements = getElements(logicalName.toLowerCase());
		for (WebElement element : elements) {
			if (element.isDisplayed()) {
				return element.getText();
			}

		}
		return "";
	}

	public void validateTextContains(String elementName, String expectedText) {
		WebElement element = getElement(elementName.toLowerCase());
		scrollToView(element);
		waitForTheVisibilityOfElement(element, 20);
		String actualText = element.getText().trim();
		System.setProperty(elementName, actualText);
		System.out.println("text capture -" + actualText);
		if (actualText.toLowerCase().contains(expectedText.toLowerCase().trim())
				|| expectedText.toLowerCase().trim().contains(actualText.toLowerCase().trim())) {

		} else {
			assertEquals(actualText, expectedText);
		}
	}

	private void scrollToViewBottom(String logicalName) {
		WebElement element = getElement(logicalName.trim());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	public void waitInSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

	public void mouseOver(String elementName) {
		try {
			WebElement element = getElement(elementName.toLowerCase());
			waitForTheVisibilityOfElement(element, 10);
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		} catch (Exception e) {

		}
	}

	public void mouseOver(WebElement element) {
		try {

			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		} catch (Exception e) {

		}
	}

	public void mouseOverAndClick(String logicalName) {
		try {
			WebElement element = getElement(logicalName.toLowerCase());
			waitForTheVisibilityOfElement(element, 10);
			Actions action = new Actions(driver);
			action.moveToElement(element).click().build().perform();
		} catch (Exception e) {

		}
	}

	public void navigateBack() {
		driver.navigate().back();
		waitForPageToLoad();
	}

	private void waitForPageToLoad() {

	}

	public void scrollToView(String elementName) {
		WebElement element = getElement(elementName.toLowerCase());

		((JavascriptExecutor) driver).executeScript(" arguments[0].scrollIntoView(true)", element);
		waitInSeconds(1);
	}

	public List<WebElement> getElements(String logicalName) {
		By by = objectRepo.get(logicalName.toLowerCase());
		List<WebElement> elements = driver.findElements(by);
		return elements;

	}

	public void verifyGivenTextIsNotAvailableInTheElements(String expectedText, String logicalName) {
		List<WebElement> elements = getElements(logicalName.toLowerCase());
		for (WebElement element : elements) {
			scrollToView(element);
			Assert.assertNotEquals(element.getText(), expectedText);

		}
	}

	private void scrollToView(WebElement element) {
		((JavascriptExecutor) driver).executeScript(" arguments[0].scrollIntoView(true)", element);
		waitInSeconds(1);

	}

	public void verifyGivenTextIsAvailableInTheElements(String expectedText, String logicalName) {
		List<WebElement> elements = getElements(logicalName.toLowerCase());
		for (WebElement element : elements) {
			scrollToView(element);
			Assert.assertEquals(element.getText(), expectedText);

		}
	}

	public void clickOnButtonByJs(String logicalName) {
		WebElement element = getElement(logicalName.toLowerCase());
		waitForTheVisibilityOfElement(element, 20);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	public void clearTheData(String elementName) {
		mouseOver(elementName);
		WebElement element = getElement(elementName.toLowerCase());
		if (element.isDisplayed()) {
			element.clear();
		} else {
			System.out.println("No such element is displayed .");
		}
	}

	public void pressKeyOnElement(String value, String elementName) {
		WebElement element = getElement(elementName);
		switch (value) {
		case "Enter":
			element.sendKeys(Keys.ENTER);
			break;
		case "Return":
			element.sendKeys(Keys.RETURN);
			break;
		case "Arrow_Down":
			element.sendKeys(Keys.ARROW_DOWN);
			break;
		case "Select_All":
			element.sendKeys(Keys.CONTROL + "A");
			break;

		default:
			break;
		}
	}

	public void switchToNewWindow() {
		String parentWindowHanle = driver.getWindowHandle();
		Set<String> allwindowHandles = driver.getWindowHandles();
		for (String handle : allwindowHandles) {
			if (!handle.equals(parentWindowHanle)) {
				try {
					driver.switchTo().window(handle);
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
	}

	public void closeThePresentWindowAndSwitchToParentWindow() {
		driver.close();
		for (String wh : driver.getWindowHandles()) {
			driver.switchTo().window(wh);
			break;

		}
	}

	public void switchToNewWindowAndCloseThatWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> allwhs = driver.getWindowHandles();
		for (String handle : allwhs) {
			System.out.println(handle);
			if (!handle.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(handle);
				driver.close();
			}

		}
		driver.switchTo().window(parentWindow);

	}

//	public By getByValue(String logicalName) {
//		
//		Object obj = objectRepo1.get(logicalName.toLowerCase());
//		
//		if(obj==null) {
//			Assert.fail("No locator found for : "+ logicalName + "in page : "+ presentPageName);
//		}
//		By by;
//		if(obj instanceof By) {
//			by=(By)obj;
//			
//		}else {
//			Pattern pattern=Pattern.compile("'\\$\\{([^}]*)\\}'");
//			String xpath = (String)obj;
//			Matcher matcher=pattern.matcher(xpath);
//			String variableName;
//			while(matcher.find()) {
//				variableName=matcher.group(1);
//				System.out.println("found variableName in xapth :"+variableName);
//				WebDriver globalVariables;
//				xpath=xpath.replace("${"+variableName + "}", globalVariables.get(variableName));
//			}
//			by=By.xpath(xpath);
//		}
//		return by;
//		
//	}
//	public Dimension getSize(String logicalName) {
//	WebElement element = getElement(logicalName);
//	Dimension size = element.getSize();
//	return size;
//		
//	}
	public void clickByScrolling(String logicalName) {
		scrollToView(logicalName.toLowerCase());
		mouseOver(logicalName.toLowerCase());
		WebElement element = getElement(logicalName.trim());
		waitforElementClickable(element);

	}

	private void waitforElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	private boolean isElementClickable(WebElement element) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait;
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			return false;
		}
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		return true;

	}

	public void scrollDownByJS(int number) {
		for (int i = 1; i < number; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)", " ");
		}
	}

	public void scrollUpByJS(int number) {
		for (int i = 1; i < number; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-1000)", " ");
		}
	}

	private boolean isElementVisible(WebElement element) {
		WebDriverWait wait = null;
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void backPage() {
		driver.navigate().back();
	}

	public boolean isElementSelected(String logicalName) {
		WebElement element = getElement(logicalName.toLowerCase());
		if (element.isSelected()) {
			return true;
		} else {
			return false;
		}

	}

	public void switchToFrame(String frameName) {
		WebElement frameElement = getElement(frameName);
		waitForTheVisibilityOfElement(frameElement, 20);
		driver.switchTo().frame(frameElement);

	}

	public void switchToIFrame(String elementgName) {
		driver.switchTo().frame(getElement(elementgName));
	}

	public void switchToDefaltFrame() {
		driver.switchTo().defaultContent();
	}

	public void switchToAlert(String elementName) {
		WebElement element = getElement(elementName.toLowerCase());
		Alert alert = driver.switchTo().alert();
	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert(String elementName) {
		WebElement element = getElement(elementName.toLowerCase());
		driver.switchTo().alert().dismiss();

	}

	public void fileUpload(String elementName) throws AWTException {
		WebElement element = getElement(elementName.toLowerCase());
		Robot rb = new Robot();
		StringSelection str = new StringSelection("c:\\user\\sahana\\");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

	}

	public void verifyTheUrl(String expectedUrl, String presentPage) {
		String actualurl = driver.getCurrentUrl();
		Assert.assertEquals(actualurl, expectedUrl);
		System.out.println(actualurl);
		System.out.println(expectedUrl);

	}

	public void selectByVisibleTextFromTheDropdown(String value, String dropdownName) {
		WebElement dropdownElement = null;
		try {
			dropdownElement = BasePage.getElement(dropdownName);
		} catch (Exception e) {
			e.printStackTrace();
		} // Fetch the dropdown WebElement
		Select dropdown = new Select(dropdownElement); // Initialize Select class
		dropdown.selectByVisibleText(value); // Select the option by visible text

	}

	public void validateThePageTitle(String pageName, String expectedTitle) {
		setPageName(pageName);
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	public void getTextFromFirstSelectedDrodown(String dropdownName) {

		WebElement element = getElement(dropdownName);
		Select select = new Select(element);
		String text = select.getFirstSelectedOption().getText();
		System.out.println(text);
	}

	public void selectByIndex(int index, String dropdownName) {
		try {
			WebElement dropdown = getElement(dropdownName);
			Select select = new Select(dropdown);
			select.selectByIndex(index);
		} catch (NoSuchElementException e) {
			System.out.println("Dropdown not found: " + dropdownName);
			throw e;
		}
	}

	public void waitForPageLoad() {
		driver.findElement(By.xpath("//*"));
		waitForElementToBeInvisibleByLocator(By.xpath("//*contains(@class,'auraLoadingBox')]"));
		waitForElementToBeInvisibleByLocator(By.xpath("//lightning-spinner"));
		waitForElementToBeInvisibleByLocator(By.xpath("//*contains(@class,'loading')]"));
		waitForElementToBeInvisibleByLocator(By.xpath("//*contains(@class,'loadingSpinner')]"));
		waitForElementToBeInvisibleByLocator(By.xpath("//*contains(@class,'Spinner')]"));
		waitForElementToBeInvisibleByLocator(By.xpath("//*contains(@class,'slds-spinner-container')]"));
		waitForElementToBeInvisibleByLocator(By.xpath("//*contains(@class,'auraLoadingBox')]"));
		waitForElementToBeInvisibleByLocator(By.xpath("//*contains(@class,'auraLoadingBox')]"));
		waitForElementToBeInvisibleByLocator(By.xpath("//*contains(@class,'auraLoadingBox')]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
			wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
		} catch (Exception e) {

		}
		waitForElementToBeInvisibleByLocator(By.xpath("//*contains(@class,'auraLoadingBox')]"));
		waitForElementToBeInvisibleByLocator(By.xpath("//lightning-spinner"));
		waitForElementToBeInvisibleByLocator(By.xpath("//*contains(@class,'loading')]"));
		waitForElementToBeInvisibleByLocator(By.xpath("//*contains(@class,'loadingSpinner')]"));
		waitForElementToBeInvisibleByLocator(By.xpath("//*contains(@class,'Spinner')]"));
		waitForElementToBeInvisibleByLocator(By.xpath("//*contains(@class,'slds-spinner-container')]"));
		waitForElementToBeInvisibleByLocator(By.xpath("//*contains(@class,'auraLoadingBox')]"));
		waitForElementToBeInvisibleByLocator(By.xpath("//*contains(@class,'auraLoadingBox')]"));
		waitForElementToBeInvisibleByLocator(By.xpath("//*contains(@class,'auraLoadingBox')]"));

	}
	public void takesPageScreenshot(String filePath) throws IOException {
		 // Get the current date
	    Date d = new Date();
	    String pattern = "dd-MM-yyyy";
	    SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
	    String date = dateFormat.format(d);

	    // Create a directory for the screenshot with the current date
	    File destDir = new File(filePath + File.separator + date);
	    if (!destDir.exists()) {
	        destDir.mkdir();
	    }

	    // Generate a unique filename using the current timestamp
	    String fileName = "Screenshot_" + new SimpleDateFormat("HH-mm-ss").format(d) + ".png";

	    // Capture the screenshot
	    File actualFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	    // Save the screenshot to the desired location
	    File destFile = new File(destDir + File.separator + fileName);
	    FileUtils.copyFile(actualFile, destFile);

	    System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
	}
	public void todayDate(String logicalName) {
		DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date=new Date();
		String date1=dateFormat.format(date);
		System.out.println("current date and time is "+date1);
	}

//	public List<String> validateActualAndExpctedListFromDropdowns(List<WebElement> actualList,
//			List<WebElement> expectedList) {
//		List<String> list = new ArrayList<String>();
//		for (WebElement webElement : actualList) {
//			String text = webElement.getText();
//			list.add(text);
//			System.out.println(text);
//
//		}
//		return list;
//
//	}
}
