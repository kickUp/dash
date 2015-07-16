package controller.json;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import entity.Course;
import freemarker.log.Logger;

import service.CourseService;

import annotation.Logn;

@Controller("jsonCourses")
@RequestMapping(value = "/json/courses")
public class Courses {	
	
	Logger log = Logger.getLogger(Courses.class.getCanonicalName());
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody		
	public Object getCourses() {
		log.info("------- json courses ---------");
		List<Course> courses = courseService.getCourses(); 
		log.info("Size: " + courses.size());
		
		return courses;
	}
	

	public String toString() {
		return "Courses controller class";
	}

}
