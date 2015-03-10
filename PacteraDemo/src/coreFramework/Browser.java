package coreFramework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import utilities.WaitHandler;

public class Browser{

	
	
    public WebDriver driver = null;
	public TestEnvironment testEnv = null;
	public HomePage homePage = null;
 	public WaitHandler waitHandler = null;
	
	public Browser(TestEnvironment testEnv)
	{
		 this.testEnv = testEnv;
		 this.driver = testEnv.getDriver();
		 
	}
	
	

	public HomePage open() {
		return open(testEnv.getConfiguration().getURL());
	}

	
	public HomePage open(String url) {
		driver.get(url);
		getWaitHandler().waitForDocStateReady();
		return getHomePage();
		
	}
	
	
	public void close() {
		driver.close();
	}
	
	


	public HomePage getHomePage() {
		// TODO Auto-generated method stub
		if(homePage==null)
		{
			homePage = new HomePage(testEnv);
		}
		return homePage;

	}
	
	
	public WaitHandler getWaitHandler() {
		if(waitHandler == null)
		{
			waitHandler = new WaitHandler(testEnv);
		}
		return waitHandler;
	}

	
}
