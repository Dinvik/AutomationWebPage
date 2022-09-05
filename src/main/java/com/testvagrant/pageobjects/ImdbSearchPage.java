package com.testvagrant.pageobjects;

import static com.testvagrant.utils.DynamicXpathUtils.getDynamicXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testvagrant.utils.PropertyUtils;

public class ImdbSearchPage extends PropertyUtils {

	private WebDriver driver;
	private String imdbSearchBox;
	private String imdbSuggestedList;
	private String imdbgetReleasedate;
	private String imdbgetCountry;
	protected ExtentTest logger;

	public ImdbSearchPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		ObjRepro();
	}

	public String getImdbSearchBox() {
		this.imdbSearchBox = testdata.get("imdbSearchBox");
		return this.imdbSearchBox;
	}

	public String getImdbSuggestedList() {
		this.imdbSuggestedList = testdata.get("imdbSuggestedList");
		return this.imdbSuggestedList;
	}

	public String getImdbGetReleasedate() {
		this.imdbgetReleasedate = testdata.get("imdbgetReleasedate");
		return this.imdbgetReleasedate;
	}

	public String getImdbGetCountry() {

		this.imdbgetCountry = testdata.get("imdbgetCountry");
		return this.imdbgetCountry;
	}

	public WebElement clickOnWikiSearchBox() {

		return driver.findElement(By.id(this.getImdbSearchBox()));

	}

	public WebElement clickOnSuggestionSearchBox(String movieName) {
		this.imdbSuggestedList = getDynamicXpath(this.getImdbSuggestedList(), movieName);
		return driver.findElement(By.xpath(this.imdbSuggestedList));

	}

	public String extractCountryName() {
		String ImdbCountryName = driver.findElement(By.xpath(this.getImdbGetCountry())).getText();
		if (!ImdbCountryName.isEmpty()) {
			logger.log(Status.PASS, "country name extract from Imdb page successfully -" + ImdbCountryName);
			System.out.println(ImdbCountryName);

		} else {
			logger.log(Status.FAIL, "Unable to extract country name  from wiki page");

		}
		return ImdbCountryName;

	}

	public String extractReleaseDate() {
		String ImdbReleaseDate = driver.findElement(By.xpath(this.getImdbGetReleasedate())).getText();
		if (!ImdbReleaseDate.isEmpty()) {
			logger.log(Status.PASS, "Release date extract from Imdb page successfully -" + ImdbReleaseDate);
			System.out.println(ImdbReleaseDate);

		} else {
			logger.log(Status.FAIL, "Unable to extract country name  from wiki page");

		}

		return ImdbReleaseDate;

	}

}
