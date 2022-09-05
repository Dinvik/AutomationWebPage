package com.testvagrant.testcases;

import java.util.Objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testvagrant.baseclass.BaseSetup;
import com.testvagrant.pageobjects.ImdbSearchPage;
import com.testvagrant.pageobjects.WikiSearchPage;

public class WikiPageSearchTest extends BaseSetup {

	public String ImdbcountryName;
	public String ImdbReleaseDate;
	public String WikicountryName;
	public String WikiReleaseDate;

	@Test(priority = 1)
	public void TC001_SearchMovieNameWikiPage() throws Exception {

		WikiSearchPage Wiki = new WikiSearchPage(driver, logger);
		driver.get(environmentData.getProperty("wikiUrl").toLowerCase());
		Wiki.clickOnWikiSearchBox().sendKeys(environmentData.getProperty("movieName"));
		// Wiki.clickOnWikiSearchBox().sendKeys(Keys.ENTER);
		Wiki.clickOnSuggestionSearchBox(environmentData.getProperty("movieName")).click();
		WikicountryName = Wiki.extractCountryName();
		WikiReleaseDate = Wiki.extractReleaseDate();
		Assert.assertTrue(!Objects.isNull(WikicountryName));
		Assert.assertTrue(!Objects.isNull(WikiReleaseDate));

	}

	@Test(dependsOnMethods = "TC001_SearchMovieNameWikiPage")
	public void TC002_SearchMovieNameImdbPage() throws Exception {
		ImdbSearchPage Imdb = new ImdbSearchPage(driver,logger);
		driver.get(environmentData.getProperty("IMDbUrl").toLowerCase());
		Imdb.clickOnWikiSearchBox().sendKeys(environmentData.getProperty("movieName"));
		//Wiki.clickOnWikiSearchBox().sendKeys(Keys.ENTER);
		Imdb.clickOnSuggestionSearchBox(environmentData.getProperty("movieName")).click();
		ImdbReleaseDate = Imdb.extractReleaseDate();
		ImdbcountryName  = Imdb.extractCountryName();
		
			 Assert.assertEquals(ImdbcountryName, WikicountryName, "Both counrtyName not matched    - ");
			 Assert.assertEquals(ImdbReleaseDate, WikiReleaseDate, "Both ReleaseDate  not matched   - ");
	
	}
	
}
