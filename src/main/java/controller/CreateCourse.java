package controller;
 
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.CourseService; 

import entity.Course;
import freemarker.log.Logger;

@Controller
@RequestMapping("/courses/create")
public class CreateCourse {
	
	@Autowired
	private CourseService courseService;
	 
	
	Logger log = Logger.getLogger(this.getClass().getCanonicalName()); 
	
	@RequestMapping(method = RequestMethod.GET)
	public String createCourse() {		
		return "/createCourse";		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String createCourse(@Valid Course course, BindingResult result, Model model) {
		if(result.hasErrors()) {		
			model.addAttribute("errors", result.getFieldErrors());
			return "/createCourse";			
		}
		
		courseService.createCourse(course);
		return "redirect:/courses";
	}

}
