package com.danielnunesro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.danielnunesro.repositories.UserRepository;

public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	public UserService(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = repository.findByUsername(username);
		if(user != null) {
			return user;
		} 
		else {
			throw new UsernameNotFoundException("Username " + username + " not found!");
		}
	}
	
	
	
}
