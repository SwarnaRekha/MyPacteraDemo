package coreFramework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import pageObjects.HomePage;


public class TestEnvironment {
	
	
	
	
	public static WebDriver driver = null;
	private Browser browser = null;
	private Configuration config = null;

	public TestEnvironment()
	{		
		String browserName = getConfiguration().getBrowserName();
		if("firefox".equalsIgnoreCase(browserName) || "".equals(browserName))
		{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if("chrome".equalsIgnoreCase(browserName))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/include/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			options.addArguments("chrome.switches","--disable-extensions");
			driver = new ChromeDriver(options);
		}
		else if("ie".equals(browserName) || "iexplore".equals("iexplore") || "Internet Explorer".equalsIgnoreCase(browserName))
		{
			
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
				capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
				capabilities.setJavascriptEnabled(true);
				capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/src/include/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
		}
		
	
	}

	
	public void terminate() {
		driver.quit();
	}

	public Browser getBrowser() {
		if(browser==null)
		{
			browser = new Browser(this);
		}
		return browser;
	}

	public Configuration getConfiguration() {
		if(config == null)
		{
			config = new Configuration();
		}
		return config;
	}

	public WebDriver getDriver()
	{
		return driver;
	}


	

}
