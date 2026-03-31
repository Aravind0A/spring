package com.example.registration.service;

import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.registration.model.UserRegistration;

public class CustomUserDetail implements UserDetails{
	
	private UserRegistration userRegistration;

	public CustomUserDetail(UserRegistration userRegistration) {
        this.userRegistration = userRegistration;
    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of();
		
	}

	public String getFullname() {
        return userRegistration.getfName();
    }


    @Override
    public String getPassword() {
        return userRegistration.getPassword();
    }


    @Override
    public String getUsername() {
       
        return userRegistration.getEmail();
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
