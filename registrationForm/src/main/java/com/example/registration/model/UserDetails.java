package com.example.registration.model;

import jakarta.validation.constraints.NotBlank;

public class UserDetails {

	@NotBlank(message = "Name must not be blank")
	private String name;
	@Email(message = "email must contain @gmail.com")
	@NotBlank(message = "must not be blank")
	private String email;
	@Address(message = "address must include India")
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
