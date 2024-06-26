package com.springrest.springrest.helper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.springrest.springrest.entities.Course;



public class Helper {

	public static String[] HEADERS={
		"id",
		"title",
		"description",
	};
	
	public static String SHEET_NAME = "course_data";
	
	public static ByteArrayInputStream dataToExcel(List<Course> list) throws IOException  {
		//create workbook
		
		Workbook workbook = new XSSFWorkbook();
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		
		try {
			
			
			//create sheet
			
			Sheet sheet = workbook.createSheet(SHEET_NAME);
			
			
			//create row
			
			
			Row row = sheet.createRow(0);
			
			for (int i = 0; i < HEADERS.length; i++) {
			 Cell cell  =  row.createCell(i);
			 cell.setCellValue(HEADERS[i]);
			 
			 
			}
			
			//value rows
			
			int rowIndex = 1;
			for(Course c: list) {
				Row dataRow = sheet.createRow(rowIndex);
				rowIndex++;
				dataRow.createCell(0).setCellValue(c.getId());
				dataRow.createCell(1).setCellValue(c.getTitle());
				dataRow.createCell(2).setCellValue(c.getDescription());
				
				
			}
			
			workbook.write(out);
		    return new ByteArrayInputStream(out.toByteArray()); 	
		}
		
		catch(IOException e){
			e.printStackTrace();
			System.out.println("failed to load output");
			return null;
			
		}finally {
			workbook.close();
			out.close();
		}
		
	}	
}
		
		
		
		
		
	
	
