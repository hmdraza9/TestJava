package javaConcepts2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnonymousClassExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");
		WebDriver driver  = new ChromeDriver() {
			public void ttt() {
				
			}
		};
		testMyInterface tt = new testMyInterface() {
			public void test() {
				System.out.println("Hello anonymous class's method");
			}
		};
		tt.test();
		
	}
}


interface testMyInterface{
	void test();
}
