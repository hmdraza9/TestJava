package testSelenium;

import java.io.FileNotFoundException;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestSelenium {


	static WebDriver driver;
	static WebDriver driver1;
	static WebDriver driver2;
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		// TODO Auto-generated method stub

//		PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
//		System.setOut(out); // this puts everything on a text file
		
		String url = "http://demo.guru99.com/test/delete_customer.php";
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");
		System.setProperty("webdriver.ie.driver",     "C:/Users/Abdul Hamid Raza/Documents/all-drivers/IEDriverServer.exe");
		System.setProperty("webdriver.gecko.driver",  "C:/Users/Abdul Hamid Raza/Documents/all-drivers/geckodriver.exe");
		
		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--headless");

		driver = new ChromeDriver(option);
		driver1 = new FirefoxDriver();
		driver2 = new InternetExplorerDriver();

		driver.get(url);
		driver1.get(url);
		driver2.get(url);
		Thread.sleep(5000);
		driver.quit();
		driver1.quit();
		driver2.quit();
		System.exit(0);
		System.out.println("isAlertPresent: "+isAlertPresent(driver));
		System.out.println("Code after isAlertPresent test");
		
	}
	
	public static boolean isAlertPresent(WebDriver driver3) {
		try {
			driver3.switchTo().alert();
			return true;
			//alert present
		}
		catch(NoAlertPresentException ex) {
			System.out.println("No alert present");
			return false;
			//alert not present
		}
	}

}
