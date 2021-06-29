package com.ncoding.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncoding.model.User;
import com.ncoding.repository.IUserRepository;
import com.ncoding.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
	IUserRepository userRepo;
	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		
		return userRepo.save(user);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public List<User> All() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User findById(Integer id) {
		Optional<User> opUser= userRepo.findById(id);
		return opUser.isPresent()?opUser.get():new User() ;
	}

	@Override
	public void delete(Integer id) {
		userRepo.deleteById(id);
		
	}

}
