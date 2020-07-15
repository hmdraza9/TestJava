package testOne;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class findAllElements {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/Abdul Hamid Raza/Documents/all-drivers/chromedriver.exe");
		System.out.println(System.getProperty("user.dir"));
		ChromeOptions option = new ChromeOptions();
		option.addArguments("headless");
//		driver=new ChromeDriver(option);
		findAllElements fal = new findAllElements();
//		fal.printCountOfElements(driver, urlDemoAut);
		String file1;
//		file1="C:\\Users\\Abdul Hamid\\selenium\\testNGProject\\myExcel.xlsx";
//		file1="C:\\Users\\Abdul Hamid\\selenium\\testNGProject\\ExtraNet.xlsx";
		file1="C:\\workspace\\TestJava\\ObjectRepository.xlsx";
		fal.readAllExcelSheets(file1);
	}

	public void readAllExcelSheets(String fileName) throws InvalidFormatException, IOException{
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int count = workbook.getNumberOfSheets();
		System.out.println("Number of sheets: "+count);
		
		for(int i =0;i<count;i++){
			System.out.println("\nSheetName: "+workbook.getSheetName(i));
			XSSFSheet sh = workbook.getSheetAt(i);
			Iterator<Row> rowIterator = sh.iterator();
			int rowNum = 0;
			
			while(rowIterator.hasNext()){
				Row row = sh.getRow(rowNum);
				rowNum++;
				Iterator<Cell> cellIterator = row.cellIterator();
				int cellNum = 0;
				
				while(cellIterator.hasNext()){
					Cell cell = row.getCell(cellNum);
					cellNum++;
					DataFormatter df = new DataFormatter();
					String value = df.formatCellValue(cell);
					System.out.print(value+",");
					cellIterator.next();
				}
				System.out.println("");
				rowIterator.next();
			}
		}
//		workbook.close();
	}
	
	public void printAllElements(ChromeDriver driver, String URL){

		driver.get(URL);
		List<WebElement> listOfEl = driver.findElements(By.cssSelector("*"));
		System.out.println("List size: "+listOfEl.size());
		int count=1;
		for(WebElement el:listOfEl){
			System.out.println(count+". [Text: "+el.getText()+"]["+"Tag: "+el.getTagName()+"]");
			count++;
		}
	}
	
	public void printCountOfElements(ChromeDriver driver, String URL){

		driver.get(URL);
		List<WebElement> listOfEl = driver.findElements(By.cssSelector("*"));
		System.out.println("List size: "+listOfEl.size());
	}

}
