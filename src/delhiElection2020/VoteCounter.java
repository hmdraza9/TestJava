package delhiElection2020;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import uTilities.ScreenshotTaker;

public class VoteCounter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abdul Hamid Raza\\Documents\\all-drivers\\chromedriver.exe");
		VoteCounter vc = new VoteCounter();
		ScreenshotTaker st = new ScreenshotTaker();
		String Url = "http://results.eci.gov.in/DELHITRENDS2020/ConstituencywiseU05";
		ChromeDriver driver = null;
		vc.seleniumWorker(driver, Url, st);
		
	}

	public void seleniumWorker(WebDriver driver, String Url, ScreenshotTaker st) throws IOException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("headless");
		driver = new ChromeDriver(co);
		driver.get("http://results.eci.gov.in/DELHITRENDS2020/ConstituencywiseU051.htm?ac=1");
		
		Select select = new Select(driver.findElement(By.id("ddlAC")));
		List<WebElement> optionList = new ArrayList<WebElement>();
		optionList = select.getOptions();
		
		List<String> elText = new ArrayList<String>();
		for(WebElement el:optionList) {
			elText.add(el.getText());
		}
		int x = elText.size();
		for(int i=1;i<x;i++) {
			
			String tempUrl = Url+i+".htm?ac="+i;    //String Uri = "42.htm?ac=42";
			driver.get(tempUrl);
			driver.manage().window().maximize();
			ECTableFetcher(driver, elText.get(i),i);
			st.Snapper(driver, false);
		}
		driver.quit();
	}
	
	public static void ECTableFetcher(WebDriver driver, String str, int consNum) throws IOException {
		String xpathStr = "//*[@id='div1']/table[1]/tbody/tr";
		int startTr = 4;
		String candidName="";
		String partyName = "";
		int totalVotes = 0;
		int endTr = driver.findElements(By.xpath("//*[@id=\"div1\"]/table[1]/tbody/tr")).size();
		for(int i=startTr;i<endTr;i++) {
			String tempXpath = xpathStr+"["+i+"]";
			candidName = driver.findElement(By.xpath((tempXpath)+"/td[2]")).getText();
			partyName = driver.findElement(By.xpath((tempXpath)+"/td[3]")).getText();
			totalVotes = Integer.parseInt(driver.findElement(By.xpath((tempXpath)+"/td[6]")).getText());
			String rowText = str+"|"+consNum+"|"+candidName+"|"+partyName+"|"+totalVotes;
			System.out.println(rowText);
			String[] rowData = {str,Integer.toString(consNum),candidName,partyName,Integer.toString(totalVotes)};
			ExcelWriterExisting.writeInOldExcel(rowData);
		}
	}
}

