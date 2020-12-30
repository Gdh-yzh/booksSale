package com.web.dao;

import java.util.List;

import com.web.model.User;

public interface UserDAO {

	public User findByEmail(String email) throws Exception;
	
	public User findById(int id) throws Exception;
	
	public void save(User user) throws Exception;
	
	public void update(User u) throws Exception;
}
