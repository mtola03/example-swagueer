package com.ncoding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncoding.model.User;
import com.ncoding.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description = "Endpoint to consult and manage user data")
@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private IUserService service;
	@ApiOperation(value = "get the list of users")
	@GetMapping
	public List<User> list(){
		return service.All();
	}
	@ApiOperation(value = "get a username by id")
	@GetMapping("/{id}")
	public User findByid(@PathVariable("id") Integer id){
		return service.findById(id);
	}
	@ApiOperation(value = "Register a new user")
	@PostMapping
	public User register(@RequestBody User user){
		return service.register(user);
	}
	
	@ApiOperation(value="update an existing user")
	@PutMapping
	public User update(@RequestBody User user){
		return service.update(user);
	}
	@ApiOperation(value="delete an existing user")
	@DeleteMapping
	public void delete(@PathVariable("id") Integer id){
		 service.delete(id);
	}


}
