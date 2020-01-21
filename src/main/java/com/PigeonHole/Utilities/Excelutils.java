package com.PigeonHole.Utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {
    static XSSFWorkbook workbook;             
	static XSSFSheet sheet;

	//workbook initilization
	public Excelutils(String excelpath, String sheetName) {

		try {
			workbook = new XSSFWorkbook(excelpath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//get row count of workbook
	public int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;

	}

	//get column count of workbook
	public int getcolCount() {
		int colCount = 1;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return colCount;
	}

	
	//get cell data in workbook
	public String getCellData(int rowNum, int colNum) {
		String cellData = null;
		try {
			if(sheet.getRow(rowNum).getCell(colNum).getCellType() == CellType.NUMERIC)
			{
				int data = (int)
						sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
				cellData = String.valueOf(data);
			}
			else {
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellData;

	}  

}
