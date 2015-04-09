package controller;
 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; 
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Course;
import freemarker.log.Logger;

import service.CourseService;


@Controller
@RequestMapping("/courses/{id}/update")
public class UpdateCourse {
	
	Logger log = Logger.getLogger(this.getClass().getCanonicalName());
	
	@Autowired
	private CourseService courseService;
	 
	
	@RequestMapping(method = RequestMethod.GET)
	public String updateCourse(@PathVariable Integer id, Model model) {
		Course course = courseService.getCourseById(id);
		
		log.info("Description length: " + course.getDescription().length());
		
		model.addAttribute("course", course);		
		return "/updateCourse";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String updateCourse(@PathVariable Integer id, @Validated Course course, 
								BindingResult result, Model model) {
		log.info("UPDATE COURSE POST: " + course	);
		log.info("DESCRIPTION LENGTH: " + course.getDescription().length());
		if(result.hasErrors()) {
			model.addAttribute("errors", result.getFieldErrors());
			return "redirect:/courses/" + course.getId() + "/update";
		}
		
		log.info("No error. Continue");
		Course oldCourse = courseService.getCourseById(id);
		oldCourse.setName(course.getName());
		oldCourse.setDescription(course.getDescription());
		
		courseService.updateCourse(oldCourse);
		
		return "redirect:/courses";
	}

}
