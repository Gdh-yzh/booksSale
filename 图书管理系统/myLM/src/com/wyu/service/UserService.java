package com.wyu.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.wyu.pojo.User;

@Service
public interface UserService {
	User findByUserNumber(String number);
	//添加
	int insertUser(User user);
	//查询所有用户
	List<User> findUSers();
	int deleteUserByNumber(String number);
	int updateUserByNumber(User user);	
	//模糊查询
	List<User> findLikeNumbers(String number,String username,String roleId);
}
