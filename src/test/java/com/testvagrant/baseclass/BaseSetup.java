package com.testvagrant.baseclass;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testvagrant.drivermanager.DriverClass;
import com.testvagrant.utils.PropertyUtils;

public class BaseSetup extends PropertyUtils {

	protected ExtentHtmlReporter htmlReporter;
	protected ExtentReports extent;
	protected ExtentTest logger;
	protected String todaydatetime;
	protected String classname;
	// Initiate browser
	protected static WebDriver driver;

	@BeforeTest
	protected void driverSetup() {
		driver = DriverClass.launchBrowser();
	}

	// Close browser
	@AfterTest
	protected void quitBrowser() {
		DriverClass.closeAndQuitBrowser();
	}

	@BeforeClass(alwaysRun = true)
	protected void getReportInstance() {
		Date d = new Date();
		String[] classArray = this.getClass().getName().split("\\.");
		String css = ".r-img {width: 100%;}";
		classname = classArray[classArray.length - 1];
		todaydatetime = new SimpleDateFormat("MMM-dd-yyyy_HH_mm_ss_SSS").format(d);
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Reports/DEV_" + classname + "_" + todaydatetime + ".html");
		// Create an object of Extent Reports
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation");
		extent.setSystemInfo("Environment", "DEV");
		extent.setSystemInfo("User Name", "Dinesh Baskaran");
		htmlReporter.config().setCSS(css);
		htmlReporter.config().setDocumentTitle("Selenium Automation");
		// Name of the report
		htmlReporter.config().setReportName("Automation");
		// Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	@BeforeMethod(alwaysRun = true)
	protected void log(ITestResult MethodName) {
		logger = extent.createTest(MethodName.getMethod().getMethodName(), "DEV");
	}

	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(
					"Current test failed due to " + result.getThrowable().toString() + ".", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
	}

	@AfterClass(alwaysRun = true)
	protected void extentReportFlush() {
		extent.flush();

	}

}
