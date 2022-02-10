package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
 
	//List<Course> list;
	@Autowired
	private CourseDao courseDao;
	
	
	/**
	 * @param list
	 */
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(125,"Java","this is first course"));
//		list.add(new Course(126,"Python","this is second course"));
//		
	}



	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		//return list;
		return courseDao.findAll();
	}



	@Override
	public Course getCourse(long courseId) {
		//Course c = null;
//		for(Course course: list) {
//		if(course.getId()==courseId) {
//			c= course;
//			break;
//		}
		return courseDao.findById(courseId).get();	
			
	}
		//return c ;
	



	@Override
	public Course addCourse(Course course) {
	    //list.add(course);
		courseDao.save(course);
		return course;
	}



	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//				
//			}
//		});
		courseDao.save(course);
		return course;
	}



	@Override
	public Course deleteCourse(long parseLong) {
	    Course course = new Course();	
	
//		list.forEach(e -> {
//			if(e.getId()==course.getId()) {
//				e.setId(0);
//				e.setTitle(null);
//				e.setDescription(null);
//				
//			}
//		});
	    Course entity= courseDao.getOne(parseLong);
	    courseDao.delete(entity);
		return course;
	}
}


	

