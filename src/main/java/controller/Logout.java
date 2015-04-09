package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import freemarker.log.Logger;

@Controller
@RequestMapping(value = "/logout")
public class Logout {
	
	Logger log = Logger.getLogger(this.getClass().getName());
	
	@RequestMapping(method = RequestMethod.GET)
	public String logout() { 
		return "logout";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String logout(HttpSession session) {	
		session.removeAttribute("user");

		return "redirect:/login";
	}
	

}
