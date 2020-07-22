package SeleniumGrid;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import uTilities.ScreenshotTaker;

public class GridTestSnapperParallelBrowserStack {

	public static final String USERNAME = "testgmail5";
	public static final String AUTOMATE_KEY = "mph2q6L1mMEm2D4Qq8YP";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public static ScreenshotTaker st = null;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "IE");
//		caps.setCapability("browser_version", "72");
		caps.setCapability("browserstack.console", "errors");
		caps.setCapability("browserstack.networkLogs", true);

		caps.setCapability("name", "testgmail5's First Test");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		
		Runnable r = new ThreadHelperOne(driver, st);
		Thread t1 = new Thread(r);
		t1.start();

		st = new ScreenshotTaker();
		try {
			for (int i = 0; i < 10000; i++) {
				st.Snapper(driver);
				Thread.sleep(10);
			}
			System.out.println("Screenshot done.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchSessionException p) {
			// TODO Auto-generated catch block
			System.out.println("Screenshot done.");
		}

	}

}


class ThreadHelperOne implements Runnable {

	public WebDriver driver = null;
	public ScreenshotTaker st = null;

	ThreadHelperOne(WebDriver driver, ScreenshotTaker st) {
		this.driver = driver;
		this.st = st;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		SeleniumLongsScript.testMethod(driver, st);
	}

}
