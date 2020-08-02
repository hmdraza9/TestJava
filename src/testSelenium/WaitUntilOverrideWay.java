package testSelenium;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import uTilities.ScreenshotTaker;

public class WaitUntilOverrideWay {

	static WebDriver driver;
	static ScreenshotTaker st;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// refer:https://www.selenium.dev/documentation/en/webdriver/browser_manipulation/
		// using apply in wait.until override

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Abdul Hamid Raza\\Documents\\all-drivers\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--headless");
		driver = new ChromeDriver(option);
		st = new ScreenshotTaker();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		someWindowFunctionsAndReturnTypes(driver, st);
		
		cssSelectorTestMethod(driver);
		
		
		
		driver.quit();
		try {
			driver.getTitle();
		}
		catch(NoSuchSessionException nss) {
			System.out.println("Brswer session closed.");
		}
		

	}
	
	
	public static void cssSelectorTestMethod(WebDriver driver) {
		String blazemeterUrl = "https://guide.blazemeter.com/hc/en-us/articles/360002052998-The-Continuous-Testing-Journey-The-Continuous-Testing-Journey";
		String guru99Url = "http://www.demo.guru99.com/v4/";
		
		driver.get(blazemeterUrl);
		String text = driver.findElement(By.cssSelector("ul#categories>li:nth-of-type(n)+li:nth-of-type(2)")).getText();
		System.out.println("text: "+text);
		
		driver.get(guru99Url);
		text = driver.findElement(By.cssSelector("input[name='uid'][type='text']")).getAttribute("type");
		System.out.println("text: "+text);
		driver.close();
		
	}

	public static void someWindowFunctionsAndReturnTypes(WebDriver driver, ScreenshotTaker st) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://www.popuptest.com/");
		String currWind = driver.getWindowHandle();
		Assert.assertTrue(driver.getWindowHandles().size() == 1);
		driver.findElement(By.xpath("//a[contains(text(),'Multi-PopUp Test') and @href='popuptest1.html']")).click();
		// PopupTest 1 - test your popup killer software
		wait.until(titleIs("PopupTest 1 - test your popup killer software"));
		Assert.assertTrue(driver.getTitle().contentEquals("PopupTest 1 - test your popup killer software"));
		wait.until(numberOfWindowsToBe(7)); // to wait until the number of windows are 7
		Assert.assertTrue(driver.getWindowHandles().size() == 7);

		Set<String> winList = driver.getWindowHandles();
		winList.remove(currWind);
		System.out.println("winList size: " + winList.size() + ": " + winList);

		int i = 0;
		for (String str : winList) {
			driver.switchTo().window(str);
			System.out.println("getCurrentUrl" + (++i) + ": " + driver.getCurrentUrl());
			try {
				st.Snapper(driver);
			} catch (IOException e) {
				e.printStackTrace();
			}
			driver.close();
		}
		driver.switchTo().window(currWind);
		
		

	}

	public static ExpectedCondition<Boolean> numberOfWindowsToBe(int numberOfWindows) {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				driver.getWindowHandles();
				return driver.getWindowHandles().size() == numberOfWindows;
			}
		};
	}

	public static ExpectedCondition<Boolean> titleIs(String str) {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				driver.getTitle();
				return driver.getTitle().contentEquals("PopupTest 1 - test your popup killer software");
			}
		};
	}

}
