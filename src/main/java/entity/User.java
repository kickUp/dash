package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 

@Entity
@Table(name="users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Date of registration?

	@Id
	@Column(name = "id", unique=true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	@NotNull
	@Size(min=1, max=10, message="Password field is required!")
	private String password;
	 
	@Column
	@NotNull
	@Size(min=1, max=10, message="Login field is required!")
	private String login;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="role_id")
	private Role role;
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	
	public String getLogin() {
		return login;
	}

	public void setPassword(String password) {		
		this.password = password.trim();
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [password=" + password + ", login=" + login + ", role=" + role + "]";
	}
	
	
	

 
}
