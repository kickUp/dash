package service;

import entity.User;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface UserService {
	
	@Transactional(readOnly=true)
	public User getUser(String login, char[] password);

	@Transactional(readOnly=true)
	public List<User> getUsers();

	@Transactional
	public void createUser(User user);

}
