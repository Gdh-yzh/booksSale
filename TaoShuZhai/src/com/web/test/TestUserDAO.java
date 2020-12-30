package com.web.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.web.dao.UserDAO;
import com.web.dao.imp.UserDAOImp;
import com.web.model.User;

public class TestUserDAO {
	
	@Before
	public void setUp() throws Exception{
		
	}
	
	@Test
	public void test() {
		UserDAO userDAO = new UserDAOImp(); 
		try{
			User user = userDAO.findById(2);
			System.out.println(user.getNickname());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
