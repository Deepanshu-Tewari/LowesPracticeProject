package com.sbmapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	
	@Id
	String id;
	String name;
	String password;
	
	public User() {
	}
	
	public User(String name, String password) {
		this.name=name;
		this.password=password;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getId() {
		return id;
	}
}
