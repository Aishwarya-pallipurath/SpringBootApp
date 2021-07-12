package com.cg.ebs.model;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Supervisor {

	@Id
	//@Email
	//@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-zA-A]+", message = "enter email in valid format")
	private String email;
	
	//@NotNull
	private String password;
	
	public Supervisor() {
	}

	public Supervisor(String email,String password){
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public String setPassword(String password) {
		return this.password = password;
	}
	
	@Override
	public String toString() {
		return "Supervisor [ email=" + email + ", password=" + password + "]";
	}

	
}
