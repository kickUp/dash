package validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
 
import entity.User;
import freemarker.log.Logger;
 
@Component
public class LoginFieldValidator implements Validator {
	
	Logger loger = Logger.getLogger(LoginFieldValidator.class.getName());

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object clazz, Errors errors) { 
	       User user  = (User) clazz;
	       
	       loger.info("USER validation " + user); 
	       loger.info("USER login regerct " + (user.getLogin() == null) + " " + user.getLogin().isEmpty()); 
	       if(user.getLogin() == null || user.getLogin().isEmpty()) {  
	    	   loger.info("login error added ");
	    	   errors.rejectValue("login", "Login field can't be empty");
	       }
	       if(user.getPassword() == null || user.getPassword().isEmpty()) {
	    	
	    	   errors.rejectValue("password","Password field can't be empty");
	    	   
	       }
	    //   else if(!user.equals(usr))
	    //	   errors.reject("Uknwown user");		
	}

}
