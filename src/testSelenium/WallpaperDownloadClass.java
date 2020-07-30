package testSelenium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import uTilities.ScreenshotTaker;

public class WallpaperDownloadClass {

	static WebDriver driver;
	static ScreenshotTaker st;

	public static void main(String[] args) throws IOException, StaleElementReferenceException {
		// TODO Auto-generated method stub
		st = new ScreenshotTaker();
		List<WebElement> elList;
		List<String> elTextList;
		String url = "https://wonderfulengineering.com/biggest-collection-of-hd-baby-wallpaper-for-desktop-and-mobile/amp/";
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");

		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
//		option.addArguments("--headless");
		driver = new ChromeDriver(option);

		driver.get(url);
		elList = new ArrayList<WebElement>();//
		elList = driver.findElements(By.xpath("//*[contains(@src,'http://wonderfulengineering.com/wp-content/')]"));
		elTextList = new ArrayList<String>();
		for (WebElement el : elList) {
			elTextList.add(el.getAttribute("src"));
		}

		for (int i = 0; i < elTextList.size(); i++) {
			String tempElText = elTextList.get(i).toString();
			int tempElTextLength = tempElText.length();
			System.out.println(tempElText);
			String tempUrl = tempElText;
			if (tempElText.endsWith(".jpg")
					&& ((tempElText.substring(tempElTextLength - 12, tempElTextLength).contains("x")))) {
				tempUrl = tempElText.substring(0, tempElTextLength - 12)
						+ tempElText.substring(tempElTextLength - 4, tempElTextLength);
			} else if (tempElText.endsWith(".jpeg")
					&& ((tempElText.substring(tempElTextLength - 13, tempElTextLength).contains("x")))) {
				tempUrl = tempElText.substring(0, tempElTextLength - 13)
						+ tempElText.substring(tempElTextLength - 5, tempElTextLength);
			}
			System.out.println(tempUrl);
			driver.get(tempUrl);
			st.Snapper(driver);
		}

		driver.quit();
	}

}
