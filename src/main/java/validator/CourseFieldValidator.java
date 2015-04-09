package validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import entity.Course;
import freemarker.log.Logger;
 
@Component
public class CourseFieldValidator implements Validator {
	
	Logger log = Logger.getLogger(this.getClass().getCanonicalName());

	@Override
	public boolean supports(Class<?> clazz) {
		return Course.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object clazz, Errors err) {
		Course course = (Course) clazz;
		log.info("Validating course: " + course); 
		
		if(course.getName() == null || course.getName().isEmpty()) { 
			err.rejectValue("name", "Name field is required.");
		}
		if(course.getDescription() == null || course.getDescription().isEmpty()) { 
			err.rejectValue("description", "Description field is required.");
		}
	}

 
}
