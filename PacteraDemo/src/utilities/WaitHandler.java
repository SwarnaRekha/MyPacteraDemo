package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import coreFramework.TestEnvironment;


public class WaitHandler {

	private static final long GLOBAL_TIMEOUT = 10;
	private WebDriver driver;
	
	
	public WaitHandler(TestEnvironment testEnv) {
		driver = testEnv.getDriver();
		
	}
 


	public void waitForDocStateReady() {
	    ExpectedCondition<Boolean> pageLoadCondition = new
	        ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	            }
	        };
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(pageLoadCondition);
	}
	
	
	public void waitForElementVisibility(By locator) {
		Wait<WebDriver> wait = new WebDriverWait(driver,40);
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	
}
