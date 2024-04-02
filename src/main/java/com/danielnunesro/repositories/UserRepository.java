package com.danielnunesro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.danielnunesro.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(@Param("userName")String username);
	
}
