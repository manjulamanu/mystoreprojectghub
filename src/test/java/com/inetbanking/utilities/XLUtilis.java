package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtilis {

	public static FileInputStream fi;
	public static FileOutputStream op;
	public static XSSFWorkbook workbk;
	public static XSSFSheet sheet;
	public static XSSFCell column;
	public static XSSFRow row;
	public static String path;

	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(path);
		workbk = new XSSFWorkbook(fi);
		sheet = workbk.getSheet(xlsheet);
		int rowcount = sheet.getLastRowNum();
		workbk.close();
		fi.close();
		return rowcount;

	}
	
	public static int getColumnCount(String xlfile, int rownum) throws IOException {
		fi = new FileInputStream(path);
		workbk = new XSSFWorkbook(fi);
		sheet = workbk.getSheet(xlfile);
		row= sheet.getRow(rownum);
		int cellcount = row.getLastCellNum	();
		workbk.close();
		fi.close();	
		return cellcount;

	}
	
	
	public static String getCellData(String sheetName, int rownum, int columnum) throws IOException {
		
		fi=new FileInputStream(path);
		workbk =new XSSFWorkbook(fi);
		sheet = workbk.getSheet(sheetName);
		row= sheet.getRow(rownum);
		column =row.getCell(columnum);
		// we read data from cell in above as there will be a different data but will read entire data as string so to read data in string format we have 
		//dataformat class
		
		DataFormatter dataformat = new DataFormatter();
		String data;
		try {
		data = dataformat.formatCellValue(column);
		//above line returns the cell data is format of string regardless data type
		
		}
		catch(Exception e) {
			data="";
		}
		workbk.close();
		return data;
		
		
	}
	

}
