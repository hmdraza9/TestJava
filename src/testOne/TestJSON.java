package testOne;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import uTilities.ScreenshotTaker;

public class TestJSON {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Abdul Hamid Raza//Documents/all-drivers/chromedriver.exe");

		TestJSON ts = new TestJSON();
//		ts.JasonFileRead();
		// ts.testKeysActionsClass(driver);
		// ts.listAddToList();
		// ts.swapStrings(str1, str2);
		// ts.edgeBrowserTest(driver);
		ScreenshotTaker st = new ScreenshotTaker();
		// ts.DemoShopElement(driver, st);
		// ts.testDemoShop(driver, st);
		// ts.testHighlightElementCenter(driver, st);
//		ts.frameTestMethod(driver, st);
		ts.cssSelectorframeMethod(driver, st);

	}

	public void cssSelectorframeMethod(WebDriver driver,ScreenshotTaker st) throws IOException {
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String frameLocator = "iframe[src*='youtube.com/embed/']";

		driver.get("http://demo.guru99.com/test/guru99home/");

		st.Snapper(driver);
		driver.manage().window().fullscreen();
		st.Snapper(driver);

		driver.switchTo().frame(driver.findElement(By.cssSelector(frameLocator)));

		driver.findElement(By.cssSelector("button.ytp-large-play-button")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.cssSelector(frameLocator)));

		Actions builder = new Actions(driver);
		Action action = builder.moveToElement(driver.findElement(By.cssSelector("div[class*='html5-video-player']")))
				.build();
		action.perform();

		driver.findElement(By.cssSelector("button[aria-label='Pause (k)']")).click();
	}

	public void frameTestMethod(WebDriver driver, ScreenshotTaker st) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.get("http://demo.guru99.com/test/guru99home/");

		//

		System.out.println("************Elements in main frame**************");
		List<WebElement> frameElementList12 = new ArrayList<>();
		frameElementList12 = driver.findElements(By.tagName("a"));
		System.out.println("Number of elements in this frame: " + frameElementList12.size());
		for (WebElement frameEl : frameElementList12) {
			String elText = "";
			elText = frameEl.getText();
			if (elText.length() > 0) {
				System.out.println(elText);
			}
		}
		System.out.println("**************************");
		//
		List<WebElement> frameList = new ArrayList<>();
		frameList = driver.findElements(By.tagName("iframe"));
		System.out.println(frameList.size());
		int index = 0;
		for (WebElement el : frameList) {
			String frameName = el.getAttribute("name");
			index++;
			System.out.println("frameName: " + frameName);
			driver.switchTo().frame(el);
			List<WebElement> frameElementList = new ArrayList<>();
			// frameElementList = driver.findElements(By.cssSelector("*"));
			frameElementList = driver.findElements(By.tagName("a"));
			System.out.println("Number of elements in this frame: " + frameElementList.size());
			for (WebElement frameEl : frameElementList) {
				String elText = "";
				elText = frameEl.getText();
				if (elText.length() > 0) {
					System.out.println(elText);
				}
			}
			int count = 0;
			count = driver.findElements(By.tagName("img")).size();
			if (count > 0) {
				System.out.println("Element found in frame: " + index + ". " + frameName);
				// String value = driver.findElement(By.tagName("img")).getAttribute("src");
				// System.out.println("value: "+value);
			}
			driver.switchTo().parentFrame();
		}
		closeBrowser(driver);
	}

	public void testHighlightElementCenter(WebDriver driver, ScreenshotTaker st)
			throws IOException, InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		// options.addArguments("start-maximzed");
		WebElement el = null;
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		el = driver.findElement(By.name("q"));
		ScreenshotTaker.elementHighlighter(driver, el);
		st.Snapper(driver);
		el.sendKeys("Automation");
		st.Snapper(driver);
		el.submit();
		closeBrowser(driver);
	}

	public void testDemoShop(WebDriver driver, ScreenshotTaker st) throws IOException {
		driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("(//*[@href='/books' and contains(text(),'Books')])[3]")).click();
		st.Snapper(driver);
		String xpathAddToCart = "((//*[contains(text(),'Computing and Internet') and @href='/computing-and-internet'])[2]//following::input[@value='Add to cart'])[1]";
		String xpathGoToCart = "//a[@href='/cart' and contains(text(),'shopping cart')]";
		String valueCountry = "India";
		String xpathEstimate = "//input[@type='submit' and @value='Estimate shipping']";
		String xpathCheckout = "//button[@type='submit']";
		driver.findElement(By.xpath(xpathAddToCart)).click();
		driver.findElement(By.xpath(xpathGoToCart)).click();
		Select selectCountry = new Select(driver.findElement(By.id("CountryId")));
		selectCountry.selectByValue(valueCountry);
		driver.findElement(By.xpath(xpathEstimate)).click();
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.xpath(xpathCheckout)).click();
		closeBrowser(driver);
	}

	public void DemoShopElement(WebDriver driver, ScreenshotTaker st) throws IOException {

		List<WebElement> list1 = null;
		List<WebElement> refineList = new ArrayList<>();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("disable-infobars", "start-maximized");
		co.setExperimentalOption("useAutomationExtension", false);
		co.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		driver = new ChromeDriver(co);
		driver.get("http://demowebshop.tricentis.com/");
		st.Snapper(driver);
		list1 = driver.findElements(By.cssSelector("*"));
		System.out.println("Element count: " + list1.size());
		for (WebElement el : list1) {
			int elTextLength = el.getText().length();
			if ((elTextLength > 0) && (el.isDisplayed()) && (el.isEnabled())) {
				if (!(el.getAttribute("name") == null)) {
					refineList.add(el);
					// System.out.print("Name tag :
					// "+el.getAttribute("name")+st.spacerMethod(50-(el.getAttribute("name").toString().length())));
					// System.out.print("|| ");
					// System.out.println("Text:
					// "+el.getText()+st.spacerMethod(50-(el.getText().toString().length()))+"||"+el.getText().toString().length());
				}
			}
		}
		System.out.println("refineList length: " + refineList.size());
		closeBrowser(driver);
	}

	public void edgeBrowserTest(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");
		// System.setProperty("webdriver.edge.driver", "C:/Users/Abdul Hamid
		// Raza/Documents/all-drivers/MicrosoftWebDriver.exe");
		System.setProperty("webdriver.edge.driver",
				"C:/Users/Abdul Hamid Raza/Documents/all-drivers/MicrosoftWebDriver.exe");
		// msedgedriver.exe
		driver = new EdgeDriver();
	}

	public void swapStrings(String str1, String str2) {

		int len1 = str1.length();
		System.out.println("str1: " + str1 + ", str2: " + str2);
		str1 = str1 + str2; // HamidSabina
		str2 = str1.substring(0, len1);
		str1 = str1.substring(str2.length());
		System.out.println("str1: " + str1 + ", str2: " + str2);

	}

	public void listAddToList() {
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		list1.add("e");
		list1.add("f");
		list1.add("g");
		list1.add("h");
		System.out.println("Size of List1: " + list1.size());
		list2.add("i");
		list2.add("j");
		list2.add("k");
		list2.add("l");
		list2.add("m");
		System.out.println("Size of List2: " + list2.size());
		System.out.println("Adding in progress");
		list1.addAll(list2);
		System.out.println("Size of List1: " + list1.size());
		System.out.println("Size of List2: " + list2.size());
		System.out.print("list1: ");
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + ", ");
		}
		System.out.println("");

		System.out.print("list2: ");
		for (int i = 0; i < list2.size(); i++) {
			System.out.print(list2.get(i) + ", ");
		}
		System.out.println("");

	}

	public void testKeysActionsClass(WebDriver driver) {
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		String shiftText = "shifttext";
		String normalText = "normaltext";
		WebElement searchField = driver.findElement(By.name("q"));
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder.moveToElement(searchField).click().keyDown(searchField, Keys.SHIFT)
				.sendKeys(searchField, shiftText).keyUp(searchField, Keys.SHIFT).doubleClick(searchField).build();
		seriesOfActions.perform();

		seriesOfActions = builder.moveToElement(searchField).click().sendKeys(searchField, normalText)
				.doubleClick(searchField).build();
		seriesOfActions.perform();
	}

	public void JasonFileRead() throws IOException, ParseException {

		File file = new File("TestData.json");
		FileReader reader = new FileReader(file);
		JSONParser jparser = new JSONParser();
		Object obj = jparser.parse(reader);
		// System.out.println(obj.toString());
		JSONArray userList = (JSONArray) obj;
		// System.out.println("User list: \n"+userList);
		System.out.println("User list: \n");
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i));
		}
		System.out.println("\n");

		int arrSize = userList.size();
		for (int i = 0; i < arrSize; i++) {
			JSONObject users = (JSONObject) userList.get(i);
			// System.out.println("User["+i+"]: "+users);
			JSONObject user = (JSONObject) users.get("users");
			// System.out.println("User: "+user);
			String username = (String) user.get("username");
			String password = (String) user.get("password");
			System.out.println("Username: " + username);
			System.out.println("Password: " + password + "\n");
		}
	}

	public static void closeBrowser(WebDriver driver) {

		driver.close();
		driver.quit();
	}

	public static void closeBrowser(ChromeDriver driver) {

		driver.close();
		driver.quit();
	}

	public static void closeBrowser(FirefoxDriver driver) {
		driver.close();
		driver.quit();
	}
}
