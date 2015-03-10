package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.*;
import testNG.*;


public class Search extends TestBase{
	
	 
	
	@Test(dataProvider="TestData",groups={"smoke"})
	@TestInfo(tcid="TC-001",dataFileName="TestSearchPactera.csv")
	public void testSearch(String SearchString) 
	{
		
		//assert that user is at home page
		Assert.assertEquals(homePage.isAt(),true,"Home page not loaded");
	
		//search for the string
		SearchResults searchResults = homePage.search(SearchString);

        //Assert the title of search results page
		Assert.assertEquals(searchResults.getTitle(), SearchString+" | Search Results | Pactera", "Search page is not loaded");
		
	}

}
