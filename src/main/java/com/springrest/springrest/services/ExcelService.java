package com.springrest.springrest.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.helper.Helper;

@Service
public class ExcelService {
    
	@Autowired
	public CourseDao courseRepo;
	
	
	public ByteArrayInputStream getActualData() throws IOException{
		List<Course> all = courseRepo.findAll();
		
		ByteArrayInputStream byteArrayInputStream = Helper.dataToExcel(all);
		
		return byteArrayInputStream;
		
		
	}
}
