package com.springrest.springrest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.helper.UploadExcelHelper;
import com.springrest.springrest.services.ExcelUploadService;

@RestController
public class ExcelUploadController {

	@Autowired
	private ExcelUploadService excelUploadService;
	
	
	
	@PostMapping("/courses/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file ){
		
		if(UploadExcelHelper.checkExcelFormat(file)) {
			
			System.out.println("checkig iput file"+file.toString());
		
			this.excelUploadService.save(file);
			
			return ResponseEntity.ok(Map.of("message","file is uploaded saved"));
		
	} 
	
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload the file  excel format");
	
}
	

	}
	
	
