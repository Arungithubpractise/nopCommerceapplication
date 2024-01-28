package com.nopCommerceapplication.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xlreader {
	
	

	public static Object[][] Readdatafromexcel(String sheetname) throws IOException, InterruptedException {
		
		File file = new File("C:\\Users\\arunn\\eclipse-workspace\\nopCommerceapplication\\Testdata\\nopEcommercedata.xlsx");

		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet(sheetname);

		int Lastrow = sheet.getPhysicalNumberOfRows()-1;
		int Lastcolumn = sheet.getRow(0).getLastCellNum()-1;
		
		Object[][] data = new Object[Lastrow][Lastcolumn];

		for (int i=0; i<Lastrow-1; i++) {

			XSSFRow row = sheet.getRow(i+1);
			 

			for (int j=0; j<Lastcolumn; j++) {
				
				XSSFCell cell = row.getCell(j);
				CellType celltype = cell.getCellType();

				switch (celltype) {

				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;

				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;

				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;

				}

			}
		}
		return data;

	}

}
