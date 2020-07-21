package uTilities;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotTaker {
	
	public static void elementHighlighter(WebDriver driver, WebElement el) throws InterruptedException {
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		elementToCenter(driver, el);
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid blue;');", el);
		Thread.sleep(5000);
		js.executeScript("arguments[0].setAttribute('style', '');", el);
	}
	
	public static void elementToCenter(WebDriver driver, WebElement element) {

String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                                            + "var elementTop = arguments[0].getBoundingClientRect().top;"
                                            + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
	}
	
	public void Snapper(ChromeDriver driver) throws IOException {
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
String[] array1 = System.getProperty("user.dir").split("\\\\");
		String ScreenshotFullPath = "C:\\Users\\Abdul Hamid Raza\\Documents\\all-screenshots\\"+Arrays.asList(array1).get(array1.length-1)+"\\"+folderNameCreator()+"\\"+timeStampAppender()+".png";
		FileUtils.copyFile(scr, new File(ScreenshotFullPath));//Save file
		System.out.println("Screenshot taken"+scr.getName().toString());
	}


	//Arrays.asList(array1).get(array1.length-1)
	//C:\\Users\\Abdul Hamid Raza\\Documents\\all-screenshots\\
	
	
	public void Snapper(WebDriver driver) throws IOException {
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String[] array1 = System.getProperty("user.dir").split("\\\\");
		String ScreenshotFullPath = "C:\\Users\\Abdul Hamid Raza\\Documents\\all-screenshots\\"+Arrays.asList(array1).get(array1.length-1)+"\\"+folderNameCreator()+"\\"+timeStampAppender()+".png";
		FileUtils.copyFile(scr, new File(ScreenshotFullPath));//Save file
	}

	public void Snapper(WebDriver driver, boolean toPrint) throws IOException {
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String[] array1 = System.getProperty("user.dir").split("\\\\");
		String ScreenshotFullPath = "C:\\Users\\Abdul Hamid Raza\\Documents\\all-screenshots\\"+Arrays.asList(array1).get(array1.length-1)+"\\"+folderNameCreator()+"\\"+timeStampAppender()+".png";
		FileUtils.copyFile(scr, new File(ScreenshotFullPath));//Save file
		if(toPrint) {

			System.out.println("Screenshot taken: "+timeStampAppender()+".png");
		}
	}
	
	public synchronized void clickWithJS(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
		
	private String timeStampAppender(){
		final SimpleDateFormat sdfTime = new SimpleDateFormat("yyMMddHHmmssSSS");
//		final SimpleDateFormat sdfTime = new SimpleDateFormat("yyMMddHHmmss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String suffix = sdfTime.format(timestamp);
		return suffix;
	}

	private String folderNameCreator(){
		
		final SimpleDateFormat sdfDate = new SimpleDateFormat("ddMMyyyy");
		Date date = new Date(System.currentTimeMillis());
		String dateStamp = sdfDate.format(date);
		return dateStamp;
	}

}