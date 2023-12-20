package com.demoBanking.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xlsheet);
		int rowCount = ws.getLastRowNum();
		System.out.println(rowCount);
		wb.close();
		fis.close();
		return rowCount;
	}

	public static int getColCount(String xlfile, String xlsheet, int rownum) throws IOException {
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int colcount = row.getLastCellNum();
		wb.close();
		fis.close();
		return colcount;
	}

	public static String getCellData(String xlfile, String xlsheet, int rownum, int cellnum) throws IOException {
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(cellnum);
		String value = cell.toString();
		wb.close();
		fis.close();
		return value;

	}

}
