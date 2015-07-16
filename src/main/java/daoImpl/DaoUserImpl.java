package daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

import dao.DaoUser;
import entity.User;
import freemarker.log.Logger;

import org.hibernate.SessionFactory;

@Repository
public class DaoUserImpl implements DaoUser {
	
	Logger log = Logger.getLogger(this.getClass().getCanonicalName());
	
	@Autowired
	SessionFactory session;

	public User getUser(String login, char[] password) {
		log.info("CLASS USERS DAO. GET LOGIN");
		return null;
	}

	public List<User> getUsers() {
		List<User> users = null;
		try {
			users = session.getCurrentSession().createQuery("FROM User").list();

		} catch(Exception ex) {
			log.info("Get user exception");
		}
		if(users == null) {
			log.info("INFO! Users is null!"); 
			return users;
		}
		log.info("Info! User list size: " + users.size()); 
		return users;
	}

	public void createUser(User user) {
		log.info("Create new user: " + user);
		session.getCurrentSession().save(user);
	}

 
}
