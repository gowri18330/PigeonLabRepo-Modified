package com.PigeonHole.FunctionalLibrary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.PigeonHole.Utilities.ConstantUtils;
import com.PigeonHole.Utilities.PropertyUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericMethods {
	public static WebDriver driver;

	/* Launches Required Browser */
	public static WebDriver openBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		return driver;
	}
	
	public static boolean isAlertPresent() {
        try {
          driver.switchTo().alert();
          return true;
        } catch (NoAlertPresentException e) {
          return false;
        }
      }

	/* Navigate Application Url */
	public static void navigateAppUrl(String url) {
		driver.manage().deleteAllCookies();
		driver.get(PropertyUtil.getValueFromKey(url));
		driver.manage().window().maximize();
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

	// Reusable method for wait and click
	public static void waitForElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ConstantUtils.waitTime));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Method for switch window
	public static void switchToNewWindow(int windowNumber) {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite = s.iterator();
		int i = 1;
		while (ite.hasNext() && i < 10) { // replace i < 10 value with s.size()
			String popupHandle = ite.next().toString();
			System.out.println(i + " " + driver.getTitle());
			driver.switchTo().window(popupHandle);
			if (i == windowNumber)
				break;
			i++;
		}
	}

	// Method for check the button and click on it
	public static void checkIfButtonExistsAndClick(WebElement element) throws Throwable {
		if (element.isDisplayed()) {
			GenericMethods.sychronizationinterval();
			element.click();
		}
	}

	// Method for verify element is present in application
	public static boolean checkIfElementExists(WebElement element) {
		if (element.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	// Method for Synchronization
	public static void sychronizationinterval() throws Throwable
	{
		Thread.sleep(ConstantUtils.sychronizationTime);
	}
	
	// Method for get colour of the element
	public static String getColourOfElement(WebElement element) throws Throwable
	{
		GenericMethods.sychronizationinterval();
		String colorString1 = element.getCssValue("color");
		System.out.println("actual first result  "+colorString1);
		String actualColorValue =Color.fromString(colorString1).asHex();
		System.out.println(actualColorValue);
      return actualColorValue;
	}
	
	// Method for handle multiple windows
	public static void switchToWindow(String WindowName ,String browser) {
		
		
		if(browser.equalsIgnoreCase("chrome")) {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite = s.iterator();
		int i = 1;
		while (ite.hasNext() && i <= s.size()) {
			String popupHandle = ite.next().toString();
			
			if(((i ==1) && WindowName.equalsIgnoreCase("dashboard")))
			{			
				driver.switchTo().window(popupHandle);
				System.out.println(i + " " + driver.getTitle());
				break;
			}
			else if (((i ==2) && WindowName.equalsIgnoreCase("audiencepage"))) {
				driver.switchTo().window(popupHandle);
				System.out.println(i + " " + driver.getTitle());
				break;
			}
			else if (((i ==3) && WindowName.equalsIgnoreCase("adminPannel"))) {
				driver.switchTo().window(popupHandle);
				System.out.println(i + " " + driver.getTitle());
				break;
			}
			else if (((i ==4) && WindowName.equalsIgnoreCase("projectorPannel"))) {
				driver.switchTo().window(popupHandle);
				System.out.println(i + " " + driver.getTitle());
				break;
			}
			i++;
		}
	}
		else if (browser.equalsIgnoreCase("firefox")) {
			
			Set<String> s = driver.getWindowHandles();
			Iterator<String> ite = s.iterator();
			int i = 1;
			while (ite.hasNext() && i <= s.size()) {
				String popupHandle = ite.next().toString();
				
				if(((i ==1) && WindowName.equalsIgnoreCase("dashboard")))
				{			
					driver.switchTo().window(popupHandle);
					System.out.println(i + " " + driver.getTitle());
					break;
				}
				else if (((i ==2) && WindowName.equalsIgnoreCase("projectorPannel"))) { 
					driver.switchTo().window(popupHandle);
					System.out.println(i + " " + driver.getTitle());
					break;
				}
				else if (((i ==3) && WindowName.equalsIgnoreCase("adminPannel"))) {  
					driver.switchTo().window(popupHandle);
					System.out.println(i + " " + driver.getTitle());
					break;
				}
				else if (((i ==4) && WindowName.equalsIgnoreCase("audiencepage"))) {
					driver.switchTo().window(popupHandle);
					System.out.println(i + " " + driver.getTitle());
					break;
				}
				i++;
		}
	}
	}
	
	public static void SwitchToAnotherWindow(int window_number){

	     List<String> windowlist = null;

	    Set<String> windows = driver.getWindowHandles();

	    windowlist = new ArrayList<String>(windows);

	   String currentWindow = driver.getWindowHandle();

	    System.out.println("size" +windowlist.size());
	    
	   for (int i=0; i<windowlist.size(); i++)
	   {
		   System.out.println(i +" is " +windowlist.get(i));
		   if(window_number == i)
		   {
			   System.out.println("selected window  "+windowlist.get(i));
			   driver.switchTo().window(windowlist.get(i));
			   break;
		   }
	   }
	}
	
}
