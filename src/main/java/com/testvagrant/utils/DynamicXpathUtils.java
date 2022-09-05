package com.testvagrant.utils;

public class DynamicXpathUtils {
	
	public static String getDynamicXpath(String xpath, String value){
        return String.format(xpath, value);
    }
}
