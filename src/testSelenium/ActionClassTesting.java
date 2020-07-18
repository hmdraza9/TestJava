package testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionClassTesting {

	static WebDriver driver;
	
	public static void dragAndDropMethod(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub

		String dragDropUrl = "http://www.demo.guru99.com/test/drag_drop.html";
		WebElement minus_amt_5000_1;
		WebElement plus_amt_5000_1;
		WebElement minus_amt_5000_2;
		WebElement plus_amt_5000_2;
		WebElement bank_btn;
		WebElement sales_btn;
		WebElement ownersEquityBtn;
		WebElement loanBtn;
		WebElement bank_btn_placeholder;
		WebElement sales_btn_placeholder;
		WebElement debitSide_amt_placeholder;
		WebElement creditSide_amt_placeholder;

		Actions builder = new Actions(driver);

		driver.get(dragDropUrl);

		minus_amt_5000_1 = driver.findElement(By.xpath(
				"//div[@id='products']/div/ul/li[@class='sel4 ui-draggable' and @data-id='1' and @id='credit']"));
		plus_amt_5000_1 = driver.findElement(By.xpath(
				"//div[@id='products']/div/ul/li[@class='block13 ui-draggable' and @data-id='2' and @id='fourth'][1]"));
		minus_amt_5000_2 = driver.findElement(By.xpath(
				"//div[@id='products']/div/ul/li[@class='sel4 ui-draggable' and @data-id='3' and @id='credit0']"));
		plus_amt_5000_2 = driver.findElement(By.xpath(
				"//div[@id='products']/div/ul/li[@class='block13 ui-draggable' and @data-id='2' and @id='fourth'][2]"));
		bank_btn = driver.findElement(By.xpath(
				"//div[@id='products']/div/ul/li[@class='block14 ui-draggable' and @data-id='5' and @id='credit2']"));
		sales_btn = driver.findElement(By.xpath(
				"//div[@id='products']/div/ul/li[@class='block15 ui-draggable' and @data-id='6' and @id='credit1']"));
		ownersEquityBtn = driver.findElement(By.xpath(
				"//div[@id='products']/div/ul/li[@class='sel4 ui-draggable' and @data-id='7' and @id='credit3']"));
		loanBtn = driver.findElement(By.xpath(
				"//div[@id='products']/div/ul/li[@class='sel4 ui-draggable' and @data-id='8' and @id='credit4']"));

		bank_btn_placeholder = driver.findElement(By.xpath("//ol[@id='bank']/li[@class='placeholder']"));
		sales_btn_placeholder = driver.findElement(By.xpath("//ol[@id='loan']/li[@class='placeholder']"));
		debitSide_amt_placeholder = driver.findElement(By.xpath("//ol[@id='amt7']/li[@class='placeholder']"));
		creditSide_amt_placeholder = driver.findElement(By.xpath("//ol[@id='amt8']/li[@class='placeholder']"));

		Action hover_minus_amt_5000_1 = builder.moveToElement(minus_amt_5000_1).build();
		hover_minus_amt_5000_1.perform();
		Thread.sleep(1000);
		Action hover_plus_amt_5000_1 = builder.moveToElement(plus_amt_5000_1).build();
		hover_plus_amt_5000_1.perform();
		Thread.sleep(1000);
		Action hover_minus_amt_5000_2 = builder.moveToElement(minus_amt_5000_2).build();
		hover_minus_amt_5000_2.perform();
		Thread.sleep(1000);
		Action hover_plus_amt_5000_2 = builder.moveToElement(plus_amt_5000_2).build();
		hover_plus_amt_5000_2.perform();
		Thread.sleep(1000);
		Action hover_bank_btn = builder.moveToElement(bank_btn).build();
		hover_bank_btn.perform();
		Thread.sleep(1000);
		Action hover_sales_btn = builder.moveToElement(sales_btn).build();
		hover_sales_btn.perform();
		Thread.sleep(1000);
		Action hover_ownersEquityBtn = builder.moveToElement(ownersEquityBtn).build();
		hover_ownersEquityBtn.perform();
		Thread.sleep(1000);
		Action hover_loanBtn = builder.moveToElement(loanBtn).build();
		hover_loanBtn.perform();
		Thread.sleep(1000);

		Action bank_bt_TO_bank_placeholderAction = builder.dragAndDrop(bank_btn, bank_btn_placeholder).build();
		bank_bt_TO_bank_placeholderAction.perform();

		Action plus_amt_5000_1_TO_debitSide_amt_placeholder = builder
				.dragAndDrop(plus_amt_5000_1, debitSide_amt_placeholder).build();
		plus_amt_5000_1_TO_debitSide_amt_placeholder.perform();

		Action plus_amt_5000_2_TO_creditSide_amt_placeholder = builder
				.dragAndDrop(plus_amt_5000_2, creditSide_amt_placeholder).build();
		plus_amt_5000_2_TO_creditSide_amt_placeholder.perform();

		Action sales_btn_TO_sales_btn_placeholder = builder.dragAndDrop(sales_btn, sales_btn_placeholder).build();
		sales_btn_TO_sales_btn_placeholder.perform();

		Thread.sleep(5000);

	}

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver","C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		
		dragAndDropMethod(driver);
		driver.get("http://the-internet.herokuapp.com/");

		driver.quit();
		
	}

}
