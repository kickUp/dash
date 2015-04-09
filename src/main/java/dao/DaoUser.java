package dao;

import entity.User;
import java.util.List;

public interface DaoUser {
	
	public User getUser(String login, char[] password);

	public List<User> getUsers();

	public void createUser(User user);
 

}
