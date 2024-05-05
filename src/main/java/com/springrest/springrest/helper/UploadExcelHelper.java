package com.springrest.springrest.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;


import com.springrest.springrest.entities.Course;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class UploadExcelHelper {

	
	
	public static boolean checkExcelFormat(MultipartFile file) {
		String contentType = file.getContentType();
		
		
		//check the file is of excel type of not
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		{
			return true;
		}
		else {
			
			return false;
		}
	}
		
		//convert excel to list of courses
		
		public static List<Course> convertExcelToCourse(InputStream is){
			
			List<Course> list = new ArrayList<>();
			
		
			try {
			  
				XSSFWorkbook workbook =  new XSSFWorkbook(is);
				
				System.out.println("checkig is "+is.toString());
				XSSFSheet sheet =  workbook.getSheet("course_data");
				
				int rowNumber = 0;
				
				System.out.println("Checkihg cotet -> "+sheet.toString());
				
				//Iterator<org.apache.poi.ss.usermodel.Row> iterator = sheet.iterator();
				
				Iterator<Row> iterator = sheet.iterator();
				
				while(iterator.hasNext()) {
					
					Row row = iterator.next();
					
					
					if(rowNumber == 0) {
						
						rowNumber++;
						continue;
					}
					Iterator<Cell> cells = row.iterator();
					
					int cid = 0;
					
					Course course = new Course();
					
					while(cells.hasNext()) {
						
						Cell cell = cells.next();
						
						switch(cid)
						
						{
						case 0 : 
							course.setId((int)cell.getNumericCellValue());
							break;
						case 1:
							
							course.setTitle(cell.getStringCellValue());
							break;
						case 2:
							course.setDescription(cell.getStringCellValue());
							break;
							
						default:
							
							
							break;
							
						}
						
						cid++;
					}
					list.add(course);
				}
				
			
				
				
		}
			catch(Exception e){
				e.printStackTrace();
			
			}
			
		return list;
		
		
		
	}
}
