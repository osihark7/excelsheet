package com.excelsheet.com.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.excelsheet.com.model.UserDetails;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "Id", "Name", "Email","Mobile Number", "Address", "D.O.B" };
	  static String SHEET = "user-details";

	  public static ByteArrayInputStream userDataToExcel(List<UserDetails> users) {

	    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
	      Sheet sheet = workbook.createSheet(SHEET);

	      // Header
	      Row headerRow = sheet.createRow(0);

	      for (int col = 0; col < HEADERs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(HEADERs[col]);
	      }

	      int rowIdx = 1;
	      for (UserDetails userData : users) {
	        Row row = sheet.createRow(rowIdx++);

	        row.createCell(0).setCellValue(userData.getId());
	        row.createCell(1).setCellValue(userData.getName());
	        row.createCell(2).setCellValue(userData.getEmail());
	        row.createCell(3).setCellValue(userData.getMobileNumber());
	        row.createCell(4).setCellValue(userData.getAddress());
	        row.createCell(5).setCellValue(userData.getDob());
	      }

	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	    }
	  }
}
