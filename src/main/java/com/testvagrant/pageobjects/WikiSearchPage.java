package com.testvagrant.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.testvagrant.utils.DynamicXpathUtils.getDynamicXpath;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testvagrant.utils.PropertyUtils;

public  class WikiSearchPage extends PropertyUtils {

	private WebDriver driver;
	private String wikiSearchBox;
	private String wikiSuggestedList;
	private String wikiGetReleasedate;
	private String wikiGetCountry;
	protected ExtentTest logger;
	
	

	public WikiSearchPage(WebDriver driver,ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		ObjRepro();
		
	}
	
	public String getWikiSearchBox() {
		this.wikiSearchBox = testdata.get("wikiSearchBox");
		return this.wikiSearchBox;
		
	}

	public String getWikiSuggestedList() {	
		this.wikiSuggestedList = testdata.get("wikiSuggestedList");
		return this.wikiSuggestedList;
	}

	public String getWikiGetReleasedate() {
		this.wikiGetReleasedate = testdata.get("wikiGetReleasedate");
		return this.wikiGetReleasedate;
	}

	public String getWikiGetCountry() {
		 
		this.wikiGetCountry = testdata.get("wikiGetCountry");
		return this.wikiGetCountry;
	}

	public WebElement clickOnWikiSearchBox() {
		WebElement getWikiSearchBox =  driver.findElement(By.id(this.getWikiSearchBox()));
		//logger.log(Status.PASS, "Successfully entered the value in Wiki search box");
		return getWikiSearchBox;
		
	}

	public WebElement clickOnSuggestionSearchBox(String movieName) {
		this.wikiSuggestedList  = getDynamicXpath(this.getWikiSuggestedList(),movieName);
		
		return driver.findElement(By.xpath(this.wikiSuggestedList));

	}

	public String extractCountryName() {
		String countryName = driver.findElement(By.xpath(this.getWikiGetCountry())).getText();
		System.out.println(countryName);
		if(!countryName.isEmpty()) {
			logger.log(Status.PASS, "country name extract from wiki page successfully -" + countryName);
		System.out.println(countryName);
		
		}else {
			logger.log(Status.FAIL, "Unable to extract country name  from wiki page");	
			
		}
		return countryName;
	}
	
	public String extractReleaseDate() {
		
		String releaseDate = driver.findElement(By.xpath(this.getWikiGetReleasedate())).getText();
//		logger.log(Status.PASS, "Release date retrived from wiki page successfully -" + releaseDate);
//		System.out.println(releaseDate);
		
		if(!releaseDate.isEmpty()) {
			logger.log(Status.PASS, "Release date extract from wiki page successfully -" + releaseDate);
			System.out.println(releaseDate);
			
			}else {
				logger.log(Status.FAIL, "Unable to extract release date from wiki page ");	
				
			}
		return releaseDate;

	}

	
	
}
