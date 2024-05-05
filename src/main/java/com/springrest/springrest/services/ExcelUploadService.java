package com.springrest.springrest.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.helper.UploadExcelHelper;

@Service
public class ExcelUploadService {
    @Autowired
	private CourseDao courseDao;
	public void save(MultipartFile file ) {
		
		
		try {
			
			List<Course> courses = UploadExcelHelper.convertExcelToCourse(file.getInputStream()) ;
			this.courseDao.saveAll(courses);
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	public List<Course> getAllCourse(){
		return this.courseDao.findAll();
		
		
		
	}
	
}
