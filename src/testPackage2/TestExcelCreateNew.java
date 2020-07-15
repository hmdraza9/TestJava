package testPackage2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcelCreateNew {
	
	static TestExcelCreateNew tc = new TestExcelCreateNew();
	public static void main(String[] args) throws IOException {

		long starttime = System.nanoTime();
		tc.createNewExcel();
		long time = (System.nanoTime()-starttime)/1000000;
		System.out.println("Time taken: "+time/1000+"."+time%1000+" seconds");
	}
	
	public void createNewExcel() throws IOException {
	File file =	new File("Test.xlsx");
	System.out.println(file.getCanonicalPath());
	if(file.exists()) {
		System.out.println("File exist");
	}
	else {
		
	}
	XSSFWorkbook wb = new XSSFWorkbook();
	
	for(int k=0;k<1000;k++) {
		XSSFSheet sh = wb.createSheet("Sheet"+Integer.toString(k));
		sheetWriter(sh);
	}
	System.out.println("Number of Sheets: "+wb.getNumberOfSheets());
	
	FileOutputStream fout = new FileOutputStream(file);
	wb.write(fout);
	
	}
	
	public static void sheetWriter(XSSFSheet sh) {

		Row row = null;
		Cell cell = null;
		int rowNum = 0;
		int colNum = 0;
		for(rowNum=0;rowNum<10;rowNum++) {
			for(colNum=0;colNum<=rowNum;colNum++) {
				row = sh.createRow(rowNum);
				cell = row.createCell(colNum);
				String temp = "i="+Integer.toString(rowNum)+", \nj="+Integer.toString(colNum);
				cell.setCellValue(sh.getSheetName()+","+temp);
			}
		}
	}
}
