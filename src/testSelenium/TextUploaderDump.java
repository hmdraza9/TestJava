/*
 * insert INTO TextUploaderDump(Title,Text,Posted,Status,Short_Link,Created_Date)
 * VALUES("TEST TITLE", "TEST TEXT", "03/04/20 1:00:06 AM CST", "Expired", "txt.do/162d0",current_timestamp());
 */

package testSelenium;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import junit.framework.Assert;
import uTilities.DatabaseFetcher;
import uTilities.PropertyReaderClass;

public class TextUploaderDump {

	static WebDriver driver = null;

	public static void main(String[] args) {

		String url = "https://textuploader.com/";
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");

		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--headless");
		driver = new ChromeDriver(option);

		driver.manage().window().maximize();
		driver.get(url);

		driver.findElement(By.xpath("//a[contains(text(),'Login') and @href='https://textuploader.com/auth/login']"))
				.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("tesla2020");
		driver.findElement(By.id("password")).sendKeys("Jan@2020");
		driver.findElement(By.xpath("//input[@class='btn btn-beoro-3' and @type='submit' and @value='Login']")).click();
		
		
		TableDataTextUploader(driver);
		
		newTestUploader("test", "test");

		driver.quit();
	}


	public static void TableDataTextUploader(WebDriver driver) {

		try {
			String dataRecordXpath = "//div/div[2]/table/tbody/tr";
			int rowCount = driver.findElements(By.xpath(dataRecordXpath)).size();
//			int rowCount = 2;
			List<String> dataList = new ArrayList<String>();
			for (int i = 1; i <= rowCount; i++) {
				dataList.add(driver.findElement(By.xpath(dataRecordXpath + "[" + i + "]/td[1]")).getText());
				dataList.add(driver.findElement(By.xpath(dataRecordXpath + "[" + i + "]/td[4]")).getText());
				driver.findElement(By.xpath(dataRecordXpath + "[" + i + "]/td[1]/a")).click();
				dataList.add(driver.findElement(By.xpath("//div/pre/code[@class='no-highlight']")).getText());
				dataList.add(driver.findElement(By.xpath("//ul[@id='breadcrumbs']/li[4]/span")).getText().replace("Posted on: ", ""));
				dataList.add(driver.getCurrentUrl());

				dbLogger(dataList);
				dataList.clear();

				driver.navigate().back();
			}
			driver.get("https://textuploader.com/auth/logout");
			
		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();
			e.getCause();
		}

	}

	public static void dbLogger(List<String> list) {
		String title = list.get(0).toString().trim();// title
		String status = list.get(1).toString().trim();// status
		String text = list.get(2).toString().trim();// text
		String posted = list.get(3).toString().trim();// date
		String short_link = list.get(4).toString().trim();// url
		String sqlQuery = "INSERT INTO TextUploaderDump(Title,Text,Posted,Status,Short_Link,Created_Date) VALUES(\""
				+ title + "\", \"" + text + "\", \"" + posted + "\", \"" + status + "\", \"" + short_link
				+ "\",current_timestamp());";
		DatabaseFetcher df = new DatabaseFetcher();
		PropertyReaderClass pr = new PropertyReaderClass();
		df.updateDeleteDb(pr.propReader("dbUrl"), pr.propReader("username"), pr.propReader("password"), sqlQuery);
	}

	public static void newTestUploader(String title, String text) {
		System.out.println("Creating new entry and then deletion.");
		driver.findElement(By.id("username")).sendKeys("tesla2020");
		driver.findElement(By.id("password")).sendKeys("Jan@2020");
		driver.findElement(By.xpath("//input[@class='btn btn-beoro-3' and @type='submit' and @value='Login']")).click();
		driver.findElement(By.xpath("//a[@href='https://textuploader.com/' and @class = 'btn btn-small' and contains(text(),'Create a New Post!')]")).click();
		driver.findElement(By.id("textdata")).sendKeys(text);
		driver.findElement(By.id("texttitle")).sendKeys(title);
		driver.findElement(By.xpath("//input[@class='btn btn-primary span12 ptip_nw' and @type='submit' and @value='Submit']")).click();
		
		
		Assert.assertEquals("SUCCESS: ".trim(), driver.findElement(By.xpath("//div[@class='w-box-content cnt_a ']/div/div/strong")).getText().toString().trim());
		
		String savedOn = driver.findElement(By.xpath("//ul[@id='breadcrumbs']/li[4]/span")).getText().replace("Posted on: ", "");
		System.out.println("Saved on: "+savedOn);
		System.out.println("URL: "+driver.findElement(By.xpath("//div[@class='w-box-content cnt_a ']/div/div/a[2]")).getText());
		driver.findElement(By.partialLinkText("Dashboard")).click();
		
		driver.findElement(By.xpath("//tr/td[contains(text(),'07/02/20 12:28:05 AM')]/following-sibling::td/a[contains(text(),'Delete') and @class='delConfirm']")).click();
		driver.switchTo().alert().accept();

		Assert.assertEquals("SUCCESS: ".trim(), driver.findElement(By.xpath("//div[@class='w-box-content cnt_a ']/div/div/strong")).getText().toString().trim());
		
	}

}
