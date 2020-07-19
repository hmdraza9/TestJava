package uTilities;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	
	private DriverFactory() {
		//do nothing. This is to keep the class from getting instantiated.
	}
	
	private static DriverFactory instance = new DriverFactory();
	
	public static DriverFactory getInstance() {
		return instance;
	}
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public void setDriver(WebDriver driverParam) {
		driver.set(driverParam);
	}
	
	public void removeDriver() {
		driver.get().quit();
		driver.remove();
	}
	
	
}
