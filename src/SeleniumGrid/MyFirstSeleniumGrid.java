package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import uTilities.ScreenshotTaker;

public class MyFirstSeleniumGrid {

	static WebDriver driver=null;
	static ScreenshotTaker st=null;
	public static final String URL = "http://192.168.0.15:10826/wd/hub";
	
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub

//		driver = BrowserFactory.createInstance("chrome");
		
//		SeleniumLongsScript.testMethod(driver, st);
		
//		System.setProperty("webdriver.gecko.driver",  "C:/Users/Abdul Hamid Raza/Documents/all-drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");

		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
//		cap.setVersion("84");
		driver = new RemoteWebDriver(new URL(URL), cap);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("Automations");
		driver.findElement(By.name("q")).submit();
		Thread.sleep(5000);
		

		SeleniumLongsScript.testMethod(driver, st);
		
		driver.quit();
		
		
	}

}
