package testSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElementsByVisbility {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");
		FindElementsByVisbility fs = new FindElementsByVisbility();
		fs.findElementByState(driver);
		
	}
	
	public void findElementByState(WebDriver driver) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://www.toolsqa.com/selenium-webdriver/c-sharp/webelement-commands-in-c/");
		
		List<WebElement> list = driver.findElements(By.xpath("//*"));
		System.out.println("list.size: "+list.size());
		
		for(WebElement el:list) {
			if(el.getText().length()>0) {
				System.out.println(el.getText()+", "+el.getTagName()+" --> "+el.isDisplayed()+", "+el.isEnabled());
			}
		}
		driver.quit();		
	}
}
