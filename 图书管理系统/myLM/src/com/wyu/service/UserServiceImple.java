package com.wyu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wyu.mapper.UserMapper;
import com.wyu.pojo.User;
import com.wyu.pojo.UserExample;

@Service
public class UserServiceImple implements UserService {
	//用spring容器创建对象，用注解的方式
	@Autowired
	private UserMapper mapper;//定义一个变量
	//查询用户
	@Override
	public User findByUserNumber(String number) {
		// TODO Auto-generated method stub
		//调用dao层完成数据查询
		
		return mapper.selectByPrimaryKey(number);//得到结果
	}
	//添加用户
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return mapper.insert(user);
	}
	//查询用户
	@Override
	public List<User> findUSers() {
		// TODO Auto-generated method stub
		//example.clear();//spring默认创建的都是单列模式
		UserExample example = new UserExample();
		List<User> list = mapper.selectByExample(example);
		list.forEach(li->System.out.println("原始数据"+li));
		return list;
	}
	//删除用户
	@Override
	public int deleteUserByNumber(String number) {
		// TODO Auto-generated method stub
		
		return mapper.deleteByPrimaryKey(number);
	}
	//更新数据
	@Override
	public int updateUserByNumber(User user) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(user);
	}
	//模糊查询
	@Override
	public List<User> findLikeNumbers(String number, String username, String roleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
