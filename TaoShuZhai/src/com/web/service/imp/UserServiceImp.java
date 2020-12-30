package com.web.service.imp;


import com.web.dao.DAOFactory;
import com.web.model.User;
import com.web.service.UserService;

public class UserServiceImp implements UserService{
	
	public User findByEmail(String email) throws Exception{
		return DAOFactory.getUserDAO().findByEmail(email);
	}
	
	public User findById(int  id) throws Exception{
		return DAOFactory.getUserDAO().findById(id);
	}
	
	public void  update(User  u) throws Exception{
		 DAOFactory.getUserDAO().update(u);
	}
	
	public void  save(User user) throws Exception{
		 DAOFactory.getUserDAO().save(user);
	}
}
