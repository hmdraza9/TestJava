package javaConcepts2;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.HashMap;
import java.util.Hashtable;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class hashMapTestForNullValue {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub

		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("key1", "value1");
		hm.put("key2", "value2");
		hm.put("key3", "value3");
		hm.put(null, "KeyNull1");
		hm.put(null, "KeyNull2");
		hm.put("valuenull1", null);
		hm.put("valuenull2", null);
		
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("key1", "value1");
		ht.put("key2", "value2");
		ht.put("key3", "value3");
//		ht.put(null, "KeyNull");
//		ht.put(null, "KeyNull");
//		ht.put("valuenull1", null);
//		ht.put("valuenull2", null);

		System.out.println("HM: "+hm);
		System.out.println("HT: "+ht);
		System.out.println(hm.get(null));
		
		
		Robot robot = new Robot();
//		Actions builder = new Actions(new ChromeDriver());
//		robot.
//		Action action1 = builder.keyDown(key)
		
		String str1 = "";
		String temp = "//div[@class='rt-tbody']/div["+4+"]/div/div[4]";
//		temp = str1;
		str1 = temp;
		System.out.println("Str1: "+str1);
		System.out.println("temp: "+temp);
		
		
		String str=null;
		
		for(int i=0;i<33;i++) {
			if(i==4) {
				str = "ll";
			}
		}
		System.out.println(str);
		
		
	}

}
