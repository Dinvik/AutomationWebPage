package com.testvagrant.constants;

public class FrameworkConstants {

	 private static final String MAINRESOURCEROOTPATH = System.getProperty("user.dir") + "/src/main/resources";
	 private static final String PROPERTIESCONFIGFILEPATH = MAINRESOURCEROOTPATH + "/configuration/config.properties";
	 private static final String OBJECTREPROPATH = MAINRESOURCEROOTPATH + "/configuration/objectRepro.properties";
	 private static final String EXTENTREPORT = "C:/Users/DineshVicky/Downloads/TestProject/TestProject/Reports";
	 
	 public static String getPropertiesconfigfilepath() {
		return PROPERTIESCONFIGFILEPATH;
	 }
	 
	 public static String getPropertiesObjectReprofilepath() {
			return OBJECTREPROPATH;
		 }
	 public static String getEXTENTREPORTfilepath() {
			return EXTENTREPORT;
		 }
	 
}
