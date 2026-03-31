package com.example.registration.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.registration.model.RegistrationDetails;

public class CustomRegister implements UserDetails{

	@Autowired
	private RegistrationDetails registrationDetails;
	

	public CustomRegister(RegistrationDetails registrationDetails) {
		this.registrationDetails = registrationDetails;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of();
	}

	public String getFullname() {
        return registrationDetails.getName();
    }


    @Override
    public String getPassword() {
        return registrationDetails.getPassword();
    }


    @Override
    public String getUsername() {
       
        return registrationDetails.getPhone();
    }


    @Override
    public boolean isAccountNonExpired() {
   
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
   
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
   
        return true;
    }


   @Override
   public boolean isEnabled() {
	   return true;
   }
}
