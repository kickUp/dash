package controller;
 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.UserService;
import entity.User; 
import freemarker.log.Logger; 


@Controller
@RequestMapping(value = {"/login", "/"})
public class Login {	
	
	Logger log = Logger.getLogger(Login.class.getName()); 

	@Autowired
	UserService userServ;
	
//	@Autowired
//	private Validator validator;
//
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}

	@RequestMapping(method = RequestMethod.GET)
	public String login(Model model) {	  	
		log.debug("USER GET:"); 
		model.addAttribute("users", userServ.getUsers());
		//model.addAttribute("user", new User());
		return "/login";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@Valid User user, BindingResult result, Model model) { 		
		log.debug("USER: " + user.getLogin() + " " + user.getPassword()); 
		if(result.hasErrors()) {			
			model.addAttribute("errors", result.getFieldErrors());
			return "/login";
		} 
		return "redirect:/courses";
	}

}
