package com.web.service;

import java.util.List;

import com.web.model.User;

public interface UserService {

	public User findByEmail(String email) throws Exception;
	
	public User findById(int  id) throws Exception;
	
	public void  update(User  u) throws Exception;
	
	public void  save(User  user) throws Exception;
}
