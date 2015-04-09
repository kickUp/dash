package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import entity.Course;
 
public interface DaoCourse {
	
	public void createCourse(Course course);
	
	public void updateCourse(Course course);
	 
	public List<Course> getCourses();

	public Course getCourseById(Integer id) throws DataAccessException;

}
