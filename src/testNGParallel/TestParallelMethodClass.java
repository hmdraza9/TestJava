package testNGParallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestParallelMethodClass {
	
	//-Dtestng.dtd.http=true
	WebDriver driver;
	
	@BeforeClass
	public void setSysProp() {
    	System.setProperty("webdriver.chrome.driver", "C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");		
	}
	
	@BeforeMethod
	public void BeforeMethod() {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("start-maximized");
//    	options.addArguments("--headless");
    	driver = new ChromeDriver(options);
	}
	
	@AfterMethod
	public void AfterMethod() {
		driver.quit();
	}
	
	@Test
	public void openGoogle() {
    	driver.get("https://www.google.co.in/");
	}
	
	@Test
	public void openGuru99() {
    	driver.get("https://www.guru99.com/");
	}
	
	@Test
	public void openYahoo() {
    	driver.get("https://in.yahoo.com/");
	}
	
	@Test
	public void openIn() {
    	driver.get("https://www.news18.com/entertainment/");
	}

}
