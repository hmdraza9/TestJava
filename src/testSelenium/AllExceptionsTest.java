package testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllExceptionsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
    	System.setProperty("webdriver.chrome.driver", "C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");
    	String url = "http://www.demo.guru99.com/v4/";
    	ChromeDriver driver = new ChromeDriver();
    	driver.get(url);
    	WebElement username = driver.findElement(By.name("uid"));
    	WebElement password = driver.findElement(By.name("password"));
    	WebElement loginBtn = driver.findElement(By.name("btnLogin"));
    	username.sendKeys("mngr136913");
    	password.sendKeys("bath1234@");
    	loginBtn.click();
    	try {
//    	username.sendKeys("mngr136913"); //Stale element exception
//    	WebElement noSuch = driver.findElement(By.name("btndddLogin")); //No Such element
//    	driver.switchTo().window("ss"); // no such window
//    	driver.switchTo().frame("deded"); //no such frame
//    	driver.switchTo().alert().getText(); //no alert present
//    	driver.findElement(By.xpath("//button[type='button']/[100]")).click(); //invalid selector
//		driver.close(); driver.close(); //no Such session
    	}
    	catch(Exception ex) {
    		driver.quit();
    		ex.printStackTrace();
    	}    	
	}

}
