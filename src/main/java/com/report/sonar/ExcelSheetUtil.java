package com.report.sonar;

import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetUtil {

	//private static final Logger logger = Logger.getLogger(ExcelSheetUtil.class.getName());

	private static final String EXCELFILENAME = "SonarReport.xslx";
	
	public XSSFWorkbook getNewWorkBook() {
		//logger.info("creating workbook.");
		return new XSSFWorkbook();
	}

	public XSSFSheet createNewSheetInWorkBook(XSSFWorkbook workbook, String sheetName) {
		//logger.info("adding new sheet " + sheetName + " to workbook.");
		return workbook.createSheet(sheetName);
	}

	public void writeSheetToDisk(XSSFWorkbook workbook) {
		try {
			//logger.info("Begin writing sheet to disk.");
			FileOutputStream outputStream = new FileOutputStream(EXCELFILENAME);
			workbook.write(outputStream);
			//workbook.close();
			outputStream.close();
			//logger.info(EXCELFILENAME + " written to disk.");
		} catch (Exception e) {
			//logger.fatal("Can't write workbook to disk.");
			e.printStackTrace();
		}
	}

	public void writeRecordSetToSheet(Object[][] resordSets, XSSFSheet sheet) {
		int rowNum = 0;
		for (Object[] datatype : resordSets) {
			Row row = sheet.createRow(rowNum++);
			int colNum = 0;
			for (Object field : datatype) {
				Cell cell = row.createCell(colNum++);
				if (field instanceof String) {
					String cellValue = (String) field;
					if(cellValue.matches(".*IFERROR.*")){
						cell.setCellType(2);
						cell.setCellFormula(cellValue.replaceAll("COLUMN_ROW", "C"+rowNum));
					}else{
						cell.setCellValue((String) field);
					}
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}
		}
		//logger.info("Number of rows written to sheet : " + rowNum);
	}

}
