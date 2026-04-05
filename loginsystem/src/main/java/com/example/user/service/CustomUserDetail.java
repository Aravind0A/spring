package com.example.user.service;

import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetail implements UserDetails {

	private com.example.user.model.UserDetails user;
	
	public CustomUserDetail(com.example.user.model.UserDetails user) {
        this.user = user;
    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of();
	}

	@Override
	public @Nullable String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
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
