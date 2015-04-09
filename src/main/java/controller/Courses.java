package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Course;
import freemarker.log.Logger;

import service.CourseService;

@Controller
public class Courses {	
	
	Logger log = Logger.getLogger(Courses.class.getCanonicalName());
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping("/courses")
	public String getCourses(HttpSession session) {
		List<Course> courses = courseService.getCourses(); 
		session.setAttribute("courses", courses);
		session.setAttribute("user", "user_login");
		
		return "courses";
	}
	

}
