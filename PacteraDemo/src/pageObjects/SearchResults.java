
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import coreFramework.*;

public class SearchResults {

	
	private WebDriver driver = null;
	private TestEnvironment testEnv = null;
	private Browser browser = null;
	
	public SearchResults(TestEnvironment testEnv) {
		this.testEnv = testEnv;
		this.driver = testEnv.getDriver();
		this.browser = testEnv.getBrowser();
	}

        public String getTitle()
        {
             
             return driver.getTitle();
        }
	
}
