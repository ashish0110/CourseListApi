package com.springrest.springrest.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.services.ExcelService;

@RestController

public class ExcelController {
	
	@Autowired
	private ExcelService excelService;

	@GetMapping("/courses/downloadList")
	public ResponseEntity<Resource> download() throws IOException{
		
		String fileName = "course.xlsx";
		ByteArrayInputStream actualData =  excelService.getActualData();
		InputStreamResource file = new InputStreamResource(actualData);
		
		ResponseEntity<Resource> body = ResponseEntity.ok()
		.header(HttpHeaders.CONTENT_DISPOSITION, "attachement; fileName =" )
		.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
		.body(file);
		
		
		
		return body;
				
	}
	
	
	
}
