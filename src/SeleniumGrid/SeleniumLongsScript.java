package SeleniumGrid;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import uTilities.ScreenshotTaker;

public class SeleniumLongsScript {


	public static void testMethod(WebDriver driver, ScreenshotTaker st) {


		try {
			String FullName = "Test Name";
			String Email = "Test123@test.com";
			String cAdd = "A-123";
			String pAdd = "Iliyas";

			st = new ScreenshotTaker();

			driver.get("https://demoqa.com/");

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][1]")).click();

			driver.findElement(By.id("item-0")).click();

			driver.findElement(By.id("userName")).sendKeys(FullName);
			driver.findElement(By.id("userEmail")).sendKeys(Email);
			driver.findElement(By.id("currentAddress")).sendKeys(cAdd);
			driver.findElement(By.id("permanentAddress")).sendKeys(pAdd);
			WebElement element = driver.findElement(By.id("submit"));
			ScreenshotTaker.elementToCenter(driver, element);
			element.click();
			String nameOutput = driver.findElement(By.xpath("//div[@id='output']/div/p[@id='name']")).getText();
			String emailOutput = driver.findElement(By.xpath("//div[@id='output']/div/p[@id='email']")).getText();
			String cAddOutput = driver.findElement(By.xpath("//div[@id='output']/div/p[@id='currentAddress']"))
					.getText();
			String pAddOutput = driver.findElement(By.xpath("//div[@id='output']/div/p[@id='permanentAddress']"))
					.getText();

			Assert.assertTrue(nameOutput.contains(FullName));
			Assert.assertTrue(emailOutput.contains(Email));
			Assert.assertTrue(cAddOutput.contains(cAdd));
			Assert.assertTrue(pAddOutput.contains(pAdd));

			driver.findElement(By.id("item-1")).click();

			WebElement checkBox = driver.findElement(By.xpath("//span[@class='rct-checkbox']"));
			st.clickWithJS(driver, checkBox);
			String checkboxResult = driver.findElement(By.id("result")).getText();
			Assert.assertTrue(checkboxResult.contains("Desktop") || checkboxResult.contains("desktop"));

			WebElement item_2 = driver.findElement(By.id("item-2"));
			st.clickWithJS(driver, item_2);

			System.out.println("No radio is enabled? " + driver.findElement(By.id("noRadio")).isEnabled());

			WebElement impressiveRadio = driver.findElement(By.id("impressiveRadio"));
			st.clickWithJS(driver, impressiveRadio);
			Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'You have selected')]")).getText()
					.contains("Impressive"));

			WebElement item_3 = driver.findElement(By.id("item-3"));
			st.clickWithJS(driver, item_3);

			WebElement adddNewTableData = driver.findElement(By.id("addNewRecordButton"));
			st.clickWithJS(driver, adddNewTableData);

			System.out.println("Table header: " + driver.findElement(By.id("registration-form-modal")).getText());
			driver.findElement(By.id("firstName")).sendKeys(FullName.substring(0, 4));
			driver.findElement(By.id("lastName")).sendKeys(FullName.substring(5, 9));
			driver.findElement(By.id("userEmail")).sendKeys(Email);
			driver.findElement(By.id("age")).sendKeys("11");
			driver.findElement(By.id("salary")).sendKeys("2000");
			driver.findElement(By.id("department")).sendKeys("Play");
			driver.findElement(By.id("submit")).click();

			int tsize = driver.findElements(By.xpath("//div[@class='rt-tbody']/div")).size();
			int rowIndex = 0;
			for (int i = 1; i <= tsize; i++) {
				String temp = "//div[@class='rt-tbody']/div[" + i + "]/div/div[4]";
				if (driver.findElement(By.xpath(temp)).getText().equalsIgnoreCase(Email)) {
					rowIndex = i;
					break;
				}
			}

			Assert.assertTrue(driver.findElement(By.xpath("//div[@class='rt-tbody']/div[" + rowIndex + "]/div/div[1]"))
					.getText().equals(FullName.substring(0, 4)));
			Assert.assertTrue(driver.findElement(By.xpath("//div[@class='rt-tbody']/div[" + rowIndex + "]/div/div[2]"))
					.getText().equals(FullName.subSequence(5, 9)));
			Assert.assertTrue(driver.findElement(By.xpath("//div[@class='rt-tbody']/div[" + rowIndex + "]/div/div[3]"))
					.getText().equals("11"));
			Assert.assertTrue(driver.findElement(By.xpath("//div[@class='rt-tbody']/div[" + rowIndex + "]/div/div[4]"))
					.getText().equals(Email));
			Assert.assertTrue(driver.findElement(By.xpath("//div[@class='rt-tbody']/div[" + rowIndex + "]/div/div[5]"))
					.getText().equals("2000"));
			Assert.assertTrue(driver.findElement(By.xpath("//div[@class='rt-tbody']/div[" + rowIndex + "]/div/div[6]"))
					.getText().equals("Play"));
			driver.findElement(By.xpath("//div[@class='rt-tbody']/div[" + rowIndex + "]/div/div[7]/div/span[2]"))
					.click();

			WebElement item_4 = driver.findElement(By.id("item-4"));
			st.clickWithJS(driver, item_4);

			driver.findElement(By.xpath("//*[contains(text(),'Right Click Me')]/following::button")).click();
			Assert.assertTrue(driver.findElement(By.id("dynamicClickMessage")).getText()
					.equals("You have done a dynamic click".trim()));

			WebElement item_5 = driver.findElement(By.id("item-5"));
			
			st.clickWithJS(driver, item_5);

			WebElement item_6 = driver.findElement(By.id("item-6"));
			st.clickWithJS(driver, item_6);

			driver.findElement(By.id("downloadButton")).click();

			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				st.Snapper(driver, true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.quit();
			e.printStackTrace();
		}
	}
	
}
