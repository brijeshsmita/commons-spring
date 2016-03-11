package com.cg.mvc.service;

import com.cg.mvc.domain.User;

public class UserService implements IUserService {

	public void add(User user) {
		//Persist the user object here. 
		System.out.println("User added successfully");

	}

}
