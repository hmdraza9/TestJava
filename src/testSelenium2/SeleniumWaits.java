package testSelenium2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumWaits {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Abdul Hamid Raza//Documents/all-drivers/chromedriver.exe");
//		raceAroundCond(driver);
//		printTableData(driver);
		waitFunctions(driver);

	}
	
	public static void waitFunctions(WebDriver driver) {
		String url = "http://the-internet.herokuapp.com/dynamic_controls";
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		int elementCount = driver.findElements(By.xpath("//div[@id='checkbox']/input")).size();
		System.out.println("elementCount: "+elementCount);
		if(elementCount>0) {
			driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
		}
		else{
			driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		}
		
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
		
		driver.findElement(By.xpath("//form[@id='input-example']/button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement enableDisableTextBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']/input")));
		enableDisableTextBox.sendKeys("example text");
		
		driver.quit();
	}

	public static void printTableData(WebDriver driver) throws IOException {
		driver = new ChromeDriver();
		driver.get(
				"https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html");
		int sizeOfRow = driver.findElements(By.xpath("//table/tbody/tr/td[2]/code/span/a")).size();

		for (int i = 2; i < sizeOfRow + 2; i++) {

			String tempHead = "//table/tbody/tr[" + i + "]/td[2]/code/span/a";
			String tempDetail = "//table/tbody/tr[" + i + "]/td[2]/div";
//			System.out.println(tempHead+", "+tempDetail);
			try {
				System.out.print(driver.findElement(By.xpath(tempHead)).getText() + "-->");
				System.out.print(driver.findElement(By.xpath(tempDetail)).getText());
				System.out.println("\n");
			} catch (NoSuchElementException ex) {
				//
				System.out.println("\n");
			}

		}

		driver.get("http://demo.guru99.com/test/basic_auth.php");

		driver.switchTo().alert().sendKeys("guru99");
		driver.switchTo().alert().accept();
		driver.switchTo().alert().sendKeys("guru99");
		driver.switchTo().alert().accept();
		driver.quit();

	}

	public static void raceAroundCond(WebDriver driver) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.get("file:///C:/Users/Abdul%20Hamid%20Raza/Downloads/race_condition.html");
		WebElement element = driver.findElement(By.tagName("p"));
		System.out.println(element.getText());
		Assert.assertEquals(element.getText(), "Hello from JavaScript!");

		driver.get("https://google.com");

		// Enter text "q" and perform keyboard action "Enter"
		driver.findElement(By.name("q")).sendKeys("q" + Keys.ENTER);

	}

}
