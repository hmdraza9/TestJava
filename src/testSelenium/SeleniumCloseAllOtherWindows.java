package testSelenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCloseAllOtherWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");
		String url = "http://demo.guru99.com/test/delete_customer.php";
		
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
//		windowHandler(driver);
		
		driver.get("http://demo.guru99.com/popup.php");
		String currentHandle = driver.getWindowHandle();
		
		for(int i=0;i<10;i++) {
			driver.findElement(By.xpath("//a[text()='Click Here']")).click();
			driver.switchTo().window(currentHandle);
		}
		
		Set<String> tabSet = driver.getWindowHandles();
		for(String str:tabSet) {
			driver.switchTo().window(str);
			driver.close();
		}
		
	}
	
	public static void windowHandler(ChromeDriver driver) throws InterruptedException {


		String firstWindowHandle = driver.getWindowHandle();

		System.out.println("Current window handle: "+firstWindowHandle);
		System.out.println("\n");
		
		((JavascriptExecutor) driver).executeScript("window.open('https://www.news18.com/entertainment/');");
		((JavascriptExecutor) driver).executeScript("window.open('https://in.yahoo.com/?p=us');");
		((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com/');");
		((JavascriptExecutor) driver).executeScript("window.open('https://www.bing.com/');");
		((JavascriptExecutor) driver).executeScript("window.open('https://duckduckgo.com/');");
		
		Set<String> tabs = driver.getWindowHandles();
		
		for(String tab:tabs) {
			driver.switchTo().window(tab);

//			if(!tab.equalsIgnoreCase(firstWindowHandle)) {
			if(driver.getTitle().contains("Bing")) {
				System.out.print(tab.toString()+", ");
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		

		System.out.println("\n");
		
		System.out.println(driver.switchTo().window(firstWindowHandle));
		System.out.println(driver.getTitle());
		Thread.sleep(2500);
		
		driver.close();

		Thread.sleep(2500);
		
		driver.quit();
		
	}

}
