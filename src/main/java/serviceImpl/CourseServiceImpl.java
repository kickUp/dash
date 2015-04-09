package serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DaoCourse;

import entity.Course;
import service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	DaoCourse daoCourse;
	
	@Override
	public List<Course> getCourses() {
		return daoCourse.getCourses();
	}

	@Override 
	public Course getCourseById(Integer id) {		 
		return daoCourse.getCourseById(id);
	}

	@Override
	@Transactional
	public void createCourse(Course course) {
		daoCourse.createCourse(course);
	}

	@Override
	@Transactional
	public void updateCourse(Course course) { 
		daoCourse.updateCourse(course);
	}

}
