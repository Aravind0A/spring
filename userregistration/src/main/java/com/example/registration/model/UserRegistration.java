package com.example.registration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
public class UserRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fName;
	private String lName;
	private String address;
	private String email;
	private String password;
	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRegistration(String fName, String lName, String address, String email, String password) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
