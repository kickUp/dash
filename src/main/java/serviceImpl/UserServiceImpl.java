package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DaoUser;
import entity.User;
import service.UserService;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	DaoUser userDao;

	@Override 
	public User getUser(String login, char[] password) { 
		return userDao.getUser(login, password);
	}

	@Override 
	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
	@Override 
	public void createUser(User user) {
		userDao.createUser(user);
	}

}
