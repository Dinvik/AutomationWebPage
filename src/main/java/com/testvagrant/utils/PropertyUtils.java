package com.testvagrant.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testvagrant.constants.FrameworkConstants;

public class PropertyUtils{
    
	
	
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected static Map<String,String> testdata = new HashMap();
	
	protected static Properties environmentData = new Properties();
	protected static Properties objRepro = new Properties();
	protected static void readProperties() {
		try (FileInputStream Fp = new FileInputStream(FrameworkConstants.getPropertiesconfigfilepath())) {
			environmentData = new Properties();
			environmentData.load(Fp);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	protected static void ObjRepro() {
		try (FileInputStream Fp = new FileInputStream(FrameworkConstants.getPropertiesObjectReprofilepath())) {
			objRepro = new Properties();
			objRepro.load(Fp);
			
			for(Map.Entry<Object, Object> proObjRepro:objRepro.entrySet())
			{
				testdata.put(String.valueOf(proObjRepro.getKey()), String.valueOf(proObjRepro.getValue()));
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	
	
}
