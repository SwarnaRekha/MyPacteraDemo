package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import coreFramework.Browser;
import coreFramework.TestEnvironment;

public class HomePage {
	
	private WebDriver driver = null;
	private TestEnvironment testEnv = null;
	private Browser browser = null;
	public SearchResults searchResults = null;
	
	public HomePage(TestEnvironment testEnv) {
		this.testEnv = testEnv;
		this.driver = testEnv.getDriver();
		this.browser = testEnv.getBrowser();
	}


	public SearchResults search(String searchText)  {
		
		WebElement searchElmt = driver.findElement(By.id("s"));
				
		searchElmt.clear();
		searchElmt.sendKeys(searchText);
		searchElmt.sendKeys(Keys.ENTER);
		browser.waitHandler.waitForElementVisibility(By.id("content"));
		return getSearchResults();       

	}
	public boolean isAt()
    {
		
	    try {
		        driver.findElement(By.id("home-slides"));
		    }
	    catch (NoSuchElementException e)
	    	{
		        return false;
		    }
		    return true;
	}
	
	public SearchResults getSearchResults() {
		// TODO Auto-generated method stub
		if(searchResults==null)
		{
			searchResults = new SearchResults(testEnv);
		}
		return searchResults;

	}
	
}
	
	
	
	
		




