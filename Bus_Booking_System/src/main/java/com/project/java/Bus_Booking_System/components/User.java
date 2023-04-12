package com.project.java.Bus_Booking_System.components;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String username;
	@Column
	private String password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return firstname;
	}
	public void setFirst_name(String first_name) {
		this.firstname = first_name;
	}
	public String getLast_name() {
		return lastname;
	}
	public void setLast_name(String last_name) {
		this.lastname = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String first_name, String last_name, String email, String username, String password) {
//		super();
//		this.id = id;
		this.firstname = first_name;
		this.lastname = last_name;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", first_name=" + firstname + ", last_name=" + lastname + ", email=" + email
				+ ", username=" + username + ", password=" + password + "]";
	}
	
}

