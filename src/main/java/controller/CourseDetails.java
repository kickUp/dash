package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Course;

import service.CourseService;

@Controller
@RequestMapping(value = "/courses/{id}")
public class CourseDetails {
	
	//TODO: Сохранять данные после запроса?
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showDetails(@PathVariable Integer id, Model model) {
		try {
			Course course = courseService.getCourseById(id);
			model.addAttribute("course", course);
		} catch (DataAccessException e) {
			model.addAttribute("exception", e);
			return "/unknownCourse";
		}
		return "/courseDetails";
	}

}
