package security;

public class UserContext {
	
	private User user;
	
	public UserContext(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

}
