package security;

public class UsernamePassword {
	
	private String username;
	private char[] password;
	
	
	public UsernamePassword() {}
	
	public UsernamePassword(final String username, final char[] password) {
		this.username = username;
		this.password = password;
	}
	
	public void setUsernamePassword(final String username, final char[] password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(final String username) {
		this.username = username;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(final char[] password) {
		this.password = password;
	}
	
	public void clear() {
		username = null;
		if(password != null) {
			for(int i = 0; i < password.length; i++) 
				password[i] = 0x01;
			password = null;
		}
	}

}
