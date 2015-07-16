package controller.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import freemarker.log.Logger; 
import service.UserService;
import entity.User; 

import java.util.List;
import java.util.ListIterator;


@Controller
@RequestMapping(value = "/json/users")
public class Users {


	
	Logger log = Logger.getLogger(Users.class.getCanonicalName()); 

	@Autowired
	UserService userServ; 

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Object users() {
		log.info("------- json users ---------");
		List<User> users = userServ.getUsers();
		log.info("Size: " + users.size());
		return users;
	} 	

}