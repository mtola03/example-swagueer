package com.ncoding.service;

import java.util.List;

import com.ncoding.model.User;

public interface IUserService {
	User register(User user);
	User update(User user);
	List<User> All();
	User findById(Integer id); 
	void delete(Integer id); 
}
