package com.report.sonar;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class sample {
public static void main(String[] args) {
	String[][] arr = new String[1][6];
	arr[0][0] = ("Component Id");
	arr[0][1] = ("Severity");
	arr[0][2] = ("Status");
	arr[0][3] = ("Resolution");
	arr[0][4] = ("Component");
	arr[0][5] = ("Message");
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("report");
	ExcelSheetUtil util = new ExcelSheetUtil();
	util.writeRecordSetToSheet(arr, sheet);
	util.writeSheetToDisk(workbook);
}
}
