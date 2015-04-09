package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;  
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 

@Entity
@Table(name="courses")
public class Course implements Serializable {	
 
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique=true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	@NotNull(message="Name field is required.")
	@Size(min=3, max=20, message="Name field is required.")	
	private String name;
	
	@Column
	@NotNull(message="Description field is required.")
	@Size(min=1, max=100, message="Description field is required.")
	private String description;
	 
	@ManyToOne	
	private User user; // Course owner
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", description="
				+ description +  ", owner " + user + "]";
	}

}
