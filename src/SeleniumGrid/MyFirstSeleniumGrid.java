package SeleniumGrid;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import uTilities.PropertyReaderClass;
import uTilities.ScreenshotTaker;

public class MyFirstSeleniumGrid {

	static WebDriver driver=null;
	static ScreenshotTaker st=null;
	public static final String URL1 = PropertyReaderClass.propReader("gridUrl1")+"/wd/hub";
	
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub

//		driver = BrowserFactory.createInstance("chrome");
		
//		SeleniumLongsScript.testMethod(driver, st);
		
//		System.setProperty("webdriver.gecko.driver",  "C:/Users/Abdul Hamid Raza/Documents/all-drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");

		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
//		cap.setVersion("84");
		driver = new RemoteWebDriver(new URL(URL1), cap);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		Runnable r = new ThreadSnapper(driver, st);
		Thread t1 = new Thread(r);
		t1.start();
		
		SeleniumLongsScript.testMethod(driver, st);
		
		driver.quit();
		
		
	}

}

class ThreadSnapper implements Runnable{
	
	ScreenshotTaker st=null;
	WebDriver driver = null;
	
	ThreadSnapper(WebDriver driver, ScreenshotTaker st){
		this.st = st;
		this.driver = driver;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		st = new ScreenshotTaker();
		try {
			for (int i = 0; i < 10000; i++) {
				st.Snapper(driver);
				Thread.sleep(10);
			}
			System.out.println("Screenshot done.loop");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchSessionException p) {
			// TODO Auto-generated catch block
			System.out.println("Screenshot done.exc");
		}
		
	}
	
}
