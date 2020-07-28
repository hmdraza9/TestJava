package testSelenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDownSortValidate {

	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		checkSortedList(driver);
		
	}
	
	public static void checkSortedList(WebDriver driver) {
		
		String url="https://ts.meeseva.telangana.gov.in/meeseva/home.htm";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abdul Hamid Raza\\Documents\\all-drivers\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		option.addArguments("--headless");
		driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.xpath("//*[@id='cd-side-nav-ul']/li[5]/a")).click();
		WebElement deptCodeList = driver.findElement(By.id("deptCode"));
		Select select = new Select(deptCodeList);
		List<WebElement> elList = select.getOptions();
		List<String> elListText = new ArrayList<String>();
		
		for(WebElement ele : elList) {
			elListText.add(ele.getText());
		}
		
		
		List<String> newTextList = new ArrayList<String>();
		elListText.addAll(newTextList);
		Collections.sort(elListText);
		System.out.println("Are list same? : "+(newTextList==elListText));
		
		driver.quit();
		
	}

}
