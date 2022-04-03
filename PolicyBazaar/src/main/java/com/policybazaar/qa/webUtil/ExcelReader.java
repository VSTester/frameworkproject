package com.policybazaar.qa.webUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private File file;
	private FileInputStream fis;
    private Workbook workBook;
    private Sheet sheetObj;
	private Row rowObj;
	private Cell cellObj;

	public ExcelReader(String filePath, int sheetName) {
		String fileExtenstion = filePath.split("\\.")[1];
		file = new File(filePath);
		try {
			fis = new FileInputStream(file);

			if (fileExtenstion.equalsIgnoreCase("xlsx")) {
				try {
					workBook = new XSSFWorkbook(fis);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (fileExtenstion.equalsIgnoreCase("xls")) {
				try {
					workBook = new HSSFWorkbook(fis);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else
				System.out.println("please enter valid excel file");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sheetObj = workBook.getSheetAt(sheetName);
	}

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		ExcelReader reader = new ExcelReader(
				"C:\\Users\\Vikassahu\\policybazaar\\PolicyBazaar\\src\\main\\java\\com\\policybazaar\\qa\\testData\\TestCaseData.xlsx",
				0);
		Row rowObj = reader.getRow(1);
		System.out.println(reader.getLastWorkingCell(rowObj));
		System.out.println(reader.getRowData(0));
		System.out.println(reader.getColumnNumberByColumnName("TestCaseID"));
		System.out.println(reader.getRowNumberByRowName("TC-007"));
		System.out.println(reader.getCellData("TestData1"));
		System.out.println(reader.getTestCaseData("TC-007"));
	}

	// ** get Workbook object for use another methods** //
	public Sheet getWorkingSheet() {
		return sheetObj;
	}
	
	
	

	// ** get last row number ** //
	public int getLastWorkingRow(Sheet sheetObj) {
		int lastWorkingRow = sheetObj.getLastRowNum();
		return lastWorkingRow;
	}
	
	
	

	// ** get row ** //
	public Row getRow(int rowNumber) {
		rowObj = sheetObj.getRow(rowNumber);
		return rowObj;
	}
	
	
	

	// ** Method for get row data ** //
	public String getRowData(int rowNumber){
		String rowData = "";
		sheetObj = getWorkingSheet();
		rowObj = sheetObj.getRow(rowNumber);
		for (int i = 0; i < getLastWorkingCell(rowObj); i++) {
			cellObj = getCell(rowObj, i);
			rowData = rowData + cellObj.getStringCellValue() + ",  ";
		}
		return rowData;
	}
	
	
	
	
	

	// ** get last cell number ** //
	public int getLastWorkingCell(Row rowObj) {
		int lastWorkingCell = rowObj.getLastCellNum();
		return lastWorkingCell;
	}
	
	
	
	

	// ** get cell ** //
	public Cell getCell(Row rowObj, int cellNumber) {
		cellObj = rowObj.getCell(cellNumber, MissingCellPolicy.CREATE_NULL_AS_BLANK);
		return cellObj;
	}
	
	
	

	// ** Method for get cell Data ** //
	public String getCellData(String columnName) {
		String cellValue = "";
		int columnNumber = getColumnNumberByColumnName(columnName);
		sheetObj = getWorkingSheet();
		for (int i = 0; i <= getLastWorkingRow(sheetObj); i++) {
			rowObj = getRow(i);
			cellObj = getCell(rowObj, columnNumber);
			cellValue = cellValue + getCellValue(cellObj) + " , ";
		}

		return cellValue;
	}
	
	
	

	// ** get cell value in string ** //
	public String getCellValue(Cell cellObj) {
		String cellValue = cellObj.getStringCellValue();
		return cellValue;
	}
	
	
	
	

	// ** Get column number with the help of column name ** //
	public int getColumnNumberByColumnName(String columnName) {
		int columnNumber = -1;
		rowObj = getRow(0);
		for (int i = 0; i < getLastWorkingCell(rowObj); i++) {
			cellObj = getCell(rowObj, i);
			String cellValue = getCellValue(cellObj);
			if (cellValue.equalsIgnoreCase(columnName)) {
				columnNumber = i;
				break;
			}
		}
		return columnNumber;
	}
	
	
	
	

	// ** Get row number with the help of row name ** //
	public int getRowNumberByRowName(String testCaseId) {
		int rowNumber = -1;
		int columnNumber = getColumnNumberByColumnName("TestCaseID");
		for (int i = 0; i < getLastWorkingRow(sheetObj); i++) {
			rowObj = getRow(i);
			cellObj = getCell(rowObj, columnNumber);
			String cellvalue = getCellValue(cellObj);
			if (cellvalue.equalsIgnoreCase(testCaseId)) {
				rowNumber = i;
				break;
			}
		}
		return rowNumber;
	}
	
	
	

	public Map<String, String> getTestCaseData(String testCaseId) {
		sheetObj = getWorkingSheet();
		Map<String, String> map = new HashMap<String, String>();
		int rowNumber = getRowNumberByRowName(testCaseId);
		int startColumnNumber = getColumnNumberByColumnName("TestData1");
		rowObj = getRow(rowNumber);
		for (int i = startColumnNumber; i < getLastWorkingCell(rowObj); i = i + 2) {
			cellObj = getCell(rowObj, i);
			String testData = getCellValue(cellObj);
			cellObj = getCell(rowObj, i + 1);
			String testValue = getCellValue(cellObj);
			map.put(testData, testValue);
		}
		return map;
	}
	
	
	
	

}
