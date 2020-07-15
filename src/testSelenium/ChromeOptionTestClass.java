package testSelenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeOptionTestClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");
//		String url = "https://www.google.co.in/";
		String url = "https://badssl.com/"; //sites with expired certificates
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setAcceptInsecureCerts(true);
		options.merge(cap);
		options.addArguments("--start-maximized");
//		options.addArguments("--start-fullscreen");//-suppress-message-center-popups
//		options.addArguments("--window-size=1300,700");
		options.addExtensions(new File("C:/Users/Abdul Hamid Raza/Documents/all-extensions/Alexa-Extension.crx"));
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);//
		driver.findElement(By.xpath("//*[@id=\"links\"]/div[1]/div[2]/a[1]")).click();
//		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText());
		driver.quit();
		
		
	}

}
