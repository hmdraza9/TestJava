package uTilities;

import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	
	
	public static WebDriver createInstance(String browser) throws InterruptedException {

		WebDriver driver=null;
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);
		}
		
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",  "C:/Users/Abdul Hamid Raza/Documents/all-drivers/geckodriver.exe");
			
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myprofile = profile.getProfile("default");
			myprofile.setPreference("network.http.phishy-underpass-length", 255);
			myprofile.setPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());
			
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			dc.setCapability(FirefoxDriver.PROFILE, myprofile);
			dc.setCapability("marionette", true);
			driver = new FirefoxDriver(dc);
		}
		
		Thread.sleep(500);
		driver.manage().window().maximize();
		
		return driver;
	}
	
}
