package com.testvagrant.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.testvagrant.baseclass.BaseSetup;

public class ImdbSearchTest extends BaseSetup {
	
	
	@Test
	public void TC001_SearchMovieNameWikiPage() throws Exception {
		
		driver.get("https://www.imdb.com/");
		driver.findElement(By.id("suggestion-search")).sendKeys("pushpa: The Rise");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[contains(text(),'Pushpa: The Rise')]//ancestor::li[@id='react-autowhatever-1--item-0']")).click();
		//driver.findElement(By.id("searchButton")).click();
		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Release date')]//following::a")).getText());
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Country of origin')]//following::a[text()='India']")).getText());  
		
	}
	
	
	
}
