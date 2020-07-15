package testOne;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ObjectRepositoryTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println(System.getProperty("user.dir"));
		final String filePath = "C://workspace//TestJava//ObjectRepository.xlsx";
		FileInputStream fis = new FileInputStream(new File(filePath));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(1);
		int x = wb.getNumberOfSheets();
		System.out.println("NumberOfSheets: "+x+", "+sheet.getSheetName());
		
	}

}
