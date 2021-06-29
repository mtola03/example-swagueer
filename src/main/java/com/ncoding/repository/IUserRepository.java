package com.ncoding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncoding.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
	
}
