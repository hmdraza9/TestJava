package uTilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderClass {

	public String propReader(String propKey){
		// TODO Auto-generated method stub

		Properties pr = new Properties();
		try {
			FileReader reader = new FileReader("C:\\workspace\\TestJava\\Data\\dataFile.properties");
			pr.load(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pr.getProperty(propKey);
		
	}

}
