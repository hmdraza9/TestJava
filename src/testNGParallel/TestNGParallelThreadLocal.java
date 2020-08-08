package testNGParallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import uTilities.BrowserFactory;
import uTilities.DriverFactory;
import uTilities.LibraryUtils;

public class TestNGParallelThreadLocal {

	public WebDriver driver = null;

	@BeforeClass
	@Parameters({ "browser" })
	void testSetUp(String browser) throws InterruptedException {
			driver = BrowserFactory.createInstance(browser);
			DriverFactory.getInstance().setDriver(driver);
			driver = DriverFactory.getInstance().getDriver();
			System.out.println("In set up, current thread ID: " + Thread.currentThread().getId());
	}

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "data one" }, { "data two" } };
    }
    

	@Test(dataProvider = "data-provider")
	@Parameters({ "search" })
	public void openGoogle(String search) {
		driver.get("https://www.google.co.in/");
		System.out.println("Title-->" + driver.getTitle() + ", Window Handle-->" + driver.getWindowHandle());
		WebElement searchBox = LibraryUtils.waitForElementToBeVisible(driver, driver.findElement(By.name("q")), 5);
		searchBox.sendKeys("search");
		driver.findElement(By.name("q")).submit();
	}

	@Test(dataProvider = "data-provider")
	public void openInCom() {
		driver.get("https://www.news18.com/entertainment/");
		System.out.println("Title: " + driver.getTitle() + ", Window Handle" + driver.getWindowHandle());
	}

	@Test
	public void openGUru99() {
		driver.get("https://www.guru99.com/");
		System.out.println("Title: " + driver.getTitle() + ", Window Handle" + driver.getWindowHandle());
	}

	@AfterClass
	public void endTest() {
		DriverFactory.getInstance().removeDriver();
	}

}
