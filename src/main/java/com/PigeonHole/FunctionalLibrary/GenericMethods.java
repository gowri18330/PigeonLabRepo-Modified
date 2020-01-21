package com.PigeonHole.FunctionalLibrary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.PigeonHole.Utilities.ConstantUtils;
import com.PigeonHole.Utilities.PropertyUtil;

public class GenericMethods {
	public static WebDriver driver;

	/* Launches Required Browser */
	public static WebDriver openBrowser() {

		if (PropertyUtil.getValueFromKey("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ConstantUtils.chromePath);
			driver = new ChromeDriver();
		} else if (PropertyUtil.getValueFromKey("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ConstantUtils.firefoxPath);
			driver = new FirefoxDriver();
		} else if (PropertyUtil.getValueFromKey("browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", ConstantUtils.internetExplorerPath);
			driver = new InternetExplorerDriver();
		}
		return driver;
	}

	/* Navigate Application Url */
	public static void navigateAppUrl(String url) {
		driver.get(PropertyUtil.getValueFromKey(url));
		driver.manage().window().maximize();
		// return driver;
	}

	/* closing WebDriver Session */
	public static void CloseDriverSession() {
		driver.quit();
	}

	/* get Current Application Page Url */
	public static String titleValidation() {
		return driver.getTitle();
	}

	/* Reusable method to validate if element is available in application */
	public static boolean elementToBePresent(WebElement element) {
		return element.isDisplayed();
	}

	/* Reusable method to validate if element is Enable in application */
	public static boolean elementToBeEnable(WebElement element) {
		return element.isEnabled();
	}

	/* Reusable method for get ScreenShot */
	public static void getSnapShot(String testName) {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile,
					new File(ConstantUtils.screenShotPath + testName + "  " + generateDate() + "  " + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Method for get Current Date with Time */
	public static String generateDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MM_dd" + " " + "_HH_mm_ss");
		return sdf.format(date);
	}

	/* Reusable Wait method */
	public static void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ConstantUtils.waitTime));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ConstantUtils.waitTime));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void switchToNewWindow(int windowNumber) {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite = s.iterator();
		int i = 1;
		while (ite.hasNext() && i < 10) { // replace i < 10 value with s.size()
			String popupHandle = ite.next().toString();
			driver.switchTo().window(popupHandle);
		//	System.out.println("Window title is : " + driver.getTitle());
			if (i == windowNumber)
				break;
			i++;
		}
	}

	public static void checkIfButtonExistsAndClick(WebElement element) {
		if (element.isDisplayed()) {
			element.click();
		}
	}

	public static boolean checkIfElementExists(WebElement element) {
		if (element.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public static void sychronizationinterval() throws Throwable
	{
		Thread.sleep(ConstantUtils.sychronizationTime);
	}
	
	public static String getColourOfElement(WebElement element) throws Throwable
	{
		GenericMethods.sychronizationinterval();
		String colorString1 = element.getCssValue("color").trim();
      String[] hexValues = colorString1.replace("rgba(", "").replace(")", "").split(",");
      int hexValue1 = Integer.parseInt(hexValues[0]);
      hexValues[1] = hexValues[1].trim();
      int hexValue2 = Integer.parseInt(hexValues[1]);
      hexValues[2] = hexValues[2].trim();
      int hexValue3 = Integer.parseInt(hexValues[2]);
      String actualColorValue = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
      return actualColorValue;
	}
}
