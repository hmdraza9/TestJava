package delhiElection2020;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriterExisting {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		writeInOldExcel(null);
	}
	
	public static void writeInOldExcel(String[] str) throws IOException {
		
		File file = new File("Test2.xlsx");
		FileInputStream fin = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fin);
		XSSFSheet sh = wb.getSheet("Election Data");
		int rowNum = sh.getLastRowNum();
		Row row = sh.createRow(rowNum+1);
		Cell cell = null;
		for(int k=0;k<str.length;k++) {
			cell = row.createCell(k);
			if(k==4||k==1) {
				int m = Integer.parseInt(str[k]);
				cell.setCellValue((Integer) m);
				System.out.println("m: "+m);
			}
			else {
				cell.setCellValue(str[k]);
			}
			
			
		}
		
		FileOutputStream fout = new FileOutputStream(file);
		wb.write(fout);
		
	}

}
