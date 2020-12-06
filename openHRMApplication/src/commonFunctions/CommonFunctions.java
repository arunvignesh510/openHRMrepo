package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonFunctions {
	public static WebDriver driver=null;
	public static Properties properties=null;
    static Logger logger= Logger.getLogger(CommonFunctions.class);
	
	public Properties loadpropertyFile() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("config.properties");
		properties = new Properties(); 
		properties.load(fileInputStream); 
		return properties;
	}
	
	@BeforeSuite
	public void launchbrowser() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Orange HRM Test Begins");
		logger.info("Loading the property file");
		loadpropertyFile();
		
		
		
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String driverlocation = properties.getProperty("driverlocation");
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverlocation);
			logger.info("Launching Chrome");
			driver = new ChromeDriver();
			
			}
		else
			if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverlocation);
			logger.info("Launching firefox");
			driver = new FirefoxDriver();
			}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
   @AfterSuite
	public void teardown() {
	   logger.info("Execution done. Closing the browser");
        driver.quit();
   
   
	}
}
