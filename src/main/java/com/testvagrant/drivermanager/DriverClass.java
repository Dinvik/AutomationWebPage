package com.testvagrant.drivermanager;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testvagrant.constants.FrameworkConstants;
import com.testvagrant.exceptions.BrowserExceptions;
import com.testvagrant.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverClass extends PropertyUtils

{

	
	
	
	protected DriverClass() {}
	private static WebDriver driver;
	public static WebDriver launchBrowser() {
		// call properties method to read properties file
		readProperties();
		try {
			switch (environmentData.getProperty("Browser").toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().clearCache();
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().clearCache();
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			case "edge":
				WebDriverManager.edgedriver().clearCache();
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			default:
				throw new BrowserExceptions("Browser not configured for the given browser name !");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;
		} catch (Exception e) {
			throw new BrowserExceptions("Exception occured during initiation of browser: ", e);
		}
	}


	
	
	
	public static void closeAndQuitBrowser() {
		driver.close();
		driver.quit();
		
	}


}
