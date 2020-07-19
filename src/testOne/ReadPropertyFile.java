package testOne;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException, SQLException{
		// TODO Auto-generated method stub

		FileReader reader = new FileReader("C:\\workspace\\TestJava\\Data\\dataFile.properties");
		Properties pr = new Properties();
		pr.load(reader);
		System.out.println("Username: "+pr.getProperty("guru99user")+", password: "+pr.getProperty("password"));
		System.out.println("Username 1: "+pr.getProperty("username1")+", password 1: "+pr.getProperty("password1"));
	}

}
