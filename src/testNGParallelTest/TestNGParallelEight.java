package testNGParallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGParallelEight {

	
	WebDriver driver=null;
	String url = "http://www.demo.guru99.com/v4/";
	
	@BeforeClass
	public void setUp() {

    	System.setProperty("webdriver.chrome.driver", "C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get(url);
	}
	
	@Test (priority=1, threadPoolSize=3)
	public void login() {
		System.out.println(driver.getTitle());
		System.out.println("Thread ID: "+Thread.currentThread().getId());
		driver.findElement(By.name("uid")).sendKeys("mngr136913");
		driver.findElement(By.name("password")).sendKeys("bath1234@");
		driver.findElement(By.name("btnLogin")).click();
	}
	
	@Test (priority=2)
	public void goToNewAccount() {
    	driver.get(url);
		System.out.println("Thread ID: "+Thread.currentThread().getId());
		driver.findElement(By.name("uid")).sendKeys("mngr136913");
		driver.findElement(By.name("password")).sendKeys("bath1234@");
		driver.findElement(By.name("btnLogin")).click();
		System.out.println("Thread ID: "+Thread.currentThread().getId());
		driver.findElement(By.partialLinkText("New Account")).click();
		driver.findElement(By.name("cusid")).sendKeys("11122333");
		driver.findElement(By.name("inideposit")).sendKeys("5000");
		driver.findElement(By.name("button2")).click();
		if(TestNGParallelOne.isAlertPresent(driver)) {
			driver.switchTo().alert().accept();
		}
	}

	
	@Test (priority=3)
	public void goToNewCust() {
    	driver.get(url);
		System.out.println("Thread ID: "+Thread.currentThread().getId());
		driver.findElement(By.name("uid")).sendKeys("mngr136913");
		driver.findElement(By.name("password")).sendKeys("bath1234@");
		driver.findElement(By.name("btnLogin")).click();
		System.out.println(driver.getTitle());
		System.out.println("Thread ID: "+Thread.currentThread().getId());
		driver.findElement(By.partialLinkText("New Customer")).click();
		driver.findElement(By.name("name")).sendKeys("test");
		driver.findElement(By.name("sub")).click();
		if(TestNGParallelOne.isAlertPresent(driver)) {
			driver.switchTo().alert().accept();
		}
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
