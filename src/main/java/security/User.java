package security;

public class User {
	
	private boolean isLogged = false;
	private UsernamePassword up;
	
	
	public void login(UsernamePassword user) {		
		this.up = user;		 
		this.isLogged = true;
	}
	
	public void logout() {
		this.isLogged = false;
	}
	
	
	public boolean isLogged() {
		return this.isLogged;
	}

}
