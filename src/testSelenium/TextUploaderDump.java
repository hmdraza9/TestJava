package testSelenium;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import uTilities.DatabaseFetcher;
import uTilities.PropertyReaderClass;

public class TextUploaderDump {

	static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		String url = "https://textuploader.com/";
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");
		driver = new ChromeDriver(option);
		// insert INTO TextUploaderDump(Title,Text,Posted,Status,Short_Link)
		// VALUES("TEST TITLE", "TEST TEXT", "03/04/20 1:00:06 AM CST", "Expired",
		// "txt.do/162d0");
		loginTextUploader(driver, url);

		driver.quit();
	}

	public static void loginTextUploader(WebDriver driver, String url) {

		try {
			driver.manage().window().maximize();
			driver.get(url);

			driver.findElement(
					By.xpath("//a[contains(text(),'Login') and @href='https://textuploader.com/auth/login']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.id("username")).sendKeys("tesla2020");
			driver.findElement(By.id("password")).sendKeys("Jan@2020");
			driver.findElement(By.xpath("//input[@class='btn btn-beoro-3' and @type='submit' and @value='Login']"))
					.click();
//			driver.findElement(By.xpath("//a[@href='https://textuploader.com/' and @class='btn btn-small' and contains(text(),'Create a New Post!')]")).click();

			TableDataTextUploader(driver);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.quit();
			e.getCause();
		}

	}

	public static void TableDataTextUploader(WebDriver driver) {

		String dataRecordXpath = "//div/div[2]/table/tbody/tr";
		int rowCount = driver.findElements(By.xpath(dataRecordXpath)).size();
		List<String> dataList = new ArrayList<String>();
		for (int i = 1; i <= rowCount; i++) {
			dataList.add(driver.findElement(By.xpath(dataRecordXpath + "[" + i + "]/td[1]")).getText());
			dataList.add(driver.findElement(By.xpath(dataRecordXpath + "[" + i + "]/td[4]")).getText());
			driver.findElement(By.xpath(dataRecordXpath + "[" + i + "]/td[1]/a")).click();
			dataList.add(driver.findElement(By.xpath("//div/pre/code[@class='no-highlight']")).getText());
			dataList.add(driver.findElement(By.xpath("//ul[@id='breadcrumbs']/li[4]/span")).getText()
					.replace("Posted on: ", ""));
			dataList.add(driver.getCurrentUrl());
			

			dbLogger(dataList);
			dataList.clear();
			
			
			driver.navigate().back();
		}
//		System.out.println("DataList: " + dataList);

	}
	
	public static void dbLogger(List<String> list) {
		String title = list.get(0).toString().trim();//title
		String status = list.get(1).toString().trim();//status
		String text = list.get(2).toString().trim();//text
		String posted = list.get(3).toString().trim();//date
		String short_link = list.get(4).toString().trim();//url
		String sqlQuery = "INSERT INTO TextUploaderDump(Title,Text,Posted,Status,Short_Link,Created_Date) VALUES(\""+title+"\", \""+text+"\", \""+posted+"\", \""+status+"\", \""+short_link+"\",current_timestamp());";
		DatabaseFetcher df = new DatabaseFetcher();
		PropertyReaderClass pr = new PropertyReaderClass();
		System.out.println("sqlQuery: "+sqlQuery);
		df.testDB(pr.propReader("dbUrl"), pr.propReader("username"), pr.propReader("password"), sqlQuery);
	}

}
