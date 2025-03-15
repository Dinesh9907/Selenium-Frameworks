package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static Cell ReadExcel(String sheetName,int row,int cell) throws IOException {
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Data1.xlsx";
		FileInputStream fs = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Row rows = sheet.getRow(row);
		Cell cellValue = rows.getCell(cell);
		workbook.close();
		return cellValue;
	}
	
	public static void WriteExcel(String sheetName,int cell,String CellValue) throws IOException {
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Data1.xlsx";
		FileInputStream fs = new FileInputStream(path);
		FileOutputStream fos = new FileOutputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum();
		Row rows = sheet.createRow(lastRow+1);
		Cell cellValue = rows.createCell(cell);
		cellValue.setCellValue(CellValue);
		
		workbook.write(fos);
		workbook.close();
		fos.close();
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(ReadExcel("SignUp", 1, 0));
		WriteExcel("SignUp",0,"Hello");
	}
}
