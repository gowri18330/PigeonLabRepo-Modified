package com.PigeonHole.Utilities;

public class ConstantUtils {
	public static String projectPath = System.getProperty("user.dir");

	/* Paths Section */
	public static final String chromePath = "./BrowserServers/chromedriver.exe";

	public static final String chromeLinuxPath = "./BrowserServers/chromedriver";

	public static final String firefoxPath = "./BrowserServers/geckodriver.exe";

	public static final String internetExplorerPath = "./BrowserServers/IEDriverServer.exe";

	public static final String screenShotPath = "./ScreenShots/";

	public static final String propertyFilePath = "./Object_Repository/EnvironmentProperties.properties";

	public static final String extentReportsPath = "./ExtentReports/ ";

	/* Test Inputs */
	public static final String waitTime = "90";

	public static final int sychronizationTime = 2000;
}
