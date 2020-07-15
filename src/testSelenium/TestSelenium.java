package testSelenium;

import java.io.FileNotFoundException;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestSelenium {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		// TODO Auto-generated method stub

//		PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
//		System.setOut(out); // this puts everything on a text file
		
		
		String url = "http://demo.guru99.com/test/delete_customer.php";
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");
		System.out.println(System.getProperty("user.dir"));
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("headless");
		
		ChromeDriver driver = new ChromeDriver(option);
		
		driver.get(url);
//		driver.findElement(By.name("submit")).click();

		System.out.println("isAlertPresent: "+isAlertPresent(driver));
		System.out.println("Code after isAlertPresent test");
		for(int i=0;i<10;i++) {
			Thread.sleep(1);
			System.out.println(i);
		}
		
	}
	
	public static boolean isAlertPresent(ChromeDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
			//alert present
		}
		catch(NoAlertPresentException ex) {
			ex.printStackTrace();
			return false;
			//alert not present
		}
	}

}
