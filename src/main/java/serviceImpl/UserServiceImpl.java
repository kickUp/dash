package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import dao.DaoUser;

import entity.User;
import service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {
	
	@Autowired
	DaoUser user;

	public User getUser(String login, char[] password) { 
		return user.getUser(login, password);
	}

	public List<User> getUsers() {
		return user.getUsers();
	}

	public void createUser(User us) {
		user.createUser(us);
	}

}
