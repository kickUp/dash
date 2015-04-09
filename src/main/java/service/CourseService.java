package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import entity.Course;
 
public interface CourseService {
	
	@Transactional
	public void createCourse(Course course);

	@Transactional
	public void updateCourse(Course course);
	
	@Transactional(readOnly=true)
	public List<Course> getCourses();
	
	@Transactional(readOnly=true)
	public Course getCourseById(Integer id);

}
