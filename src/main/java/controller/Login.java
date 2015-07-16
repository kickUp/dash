package controller;
 
import org.springframework.context.ApplicationContext;

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

import java.util.List;
import java.util.ListIterator;
 
 
@Controller
@RequestMapping(value = {"/login", "/"})
public class Login {	
	
	Logger log = Logger.getLogger(Login.class.getCanonicalName()); 

	@Autowired
	UserService userServ; 
 

	@RequestMapping(method = RequestMethod.GET)
	public String login(Model model) {
		List<User> users = userServ.getUsers();
		log.info("------------------------- --------------------------------");
		model.addAttribute("users", users); 
		return "/login";
	} 	
 
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@Valid User user, BindingResult result, Model model) { 		
		log.info("Info USER: " + user.getLogin() + " " + user.getPassword()); 
		if(result.hasErrors()) {			
			model.addAttribute("errors", result.getFieldErrors());
			model.addAttribute("users", userServ.getUsers());

			return "/login";
		} 
		return "redirect:/courses";
	}

	public String toString() {
		return "Login controller class";
	}

}
