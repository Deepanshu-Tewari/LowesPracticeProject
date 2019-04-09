package com.sbmapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbmapp.models.User;
import com.sbmapp.repositories.UserRepo;

@RestController
public class UserController {
	
	@Autowired
	UserRepo userRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="/Users")
	public Iterable<User> user(){
		return userRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/Users")
	public User save(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/Users/{id}")
	public Optional<User> show(@PathVariable String id){
		return userRepository.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Users/{id}")
	public User update(@PathVariable String id, @RequestBody User user) {
		Optional<User> optuser = userRepository.findById(id);
		User u = optuser.get();
		if(user.getName()!=null) {
			u.setName(user.getName());
		}
		if(user.getPassword()!=null) {
			u.setPassword(user.getPassword());
		}
		userRepository.save(u);
		return u;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Users/{id}")
	public String delete(@PathVariable String id) {
		Optional<User> optuser = userRepository.findById(id);
		User user=optuser.get();
		userRepository.delete(user);
		
		return "";
	}
	
}
