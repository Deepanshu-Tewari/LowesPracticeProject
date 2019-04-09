package com.sbmapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sbmapp.models.User;

public interface UserRepo extends CrudRepository<User, String> {
	
}
