package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 

@Entity
@Table(name="roles")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique=true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="role")
	@NotNull
	private String role;
	   

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRole() {
		return role;
	}
	
	 
	public void setRole(String role) {		
		this.role = role.trim();
	}

	@Override
	public String toString() {
		return"[roleId=" + getId() + ", role=" + getRole() +"]";
	} 
}
