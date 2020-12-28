package com.wyu.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wyu.pojo.User;
import com.wyu.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	//1、登录功能
	@RequestMapping("/login")
	public String login(String number,String password,Model model,HttpSession session) {
		System.out.println("number==" + number + ",password==" + password);
		User user = service.findByUserNumber(number);
		System.out.println("查询到的数据是："+ user);
		String loginInfo = "没有这个用户";
		if(user != null) {
			if(user.getUserstatusnumber() == 2)
			{
				loginInfo = "该用户已被禁用";
			}
			else {
				if(password.equals(user.getPassword())) {
					System.out.println("登录成功");
					session.setAttribute("user", user);
					return "lms_bs";
				}else {
					loginInfo = "密码错误";
					System.out.println("密码错误");
				}
			}
		}
		model.addAttribute("loginfo",loginInfo);
		return "login_user";
	}		
	/*
	//2.注册功能
	@RequestMapping("/regUser")
	@ResponseBody
	public String regUser(User user) {
		System.out.println("得到的"+user);
		user.Registrationdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		//调用service完成添加功能
		int in = service.insertUser(user);
		if(in>0) {
			System.out.println("添加成功");
		}else {
			in=0;
		}
		//System.out.println("in"+in);
		return in+"";
		
	}
	
		//3.用户功能
		@RequestMapping(value="/findUsers",produces="appliction/json;charset=utf8")
		@ResponseBody
		public String findUsers(int  page,int rows) {
			System.out.println("page"+page+";rows"+rows);
			//（1，5）查询前面五条数据，（10，5）从第10条开始查询5条数据
			PageHelper.startPage(page,rows);
			List<User> list = service.findUSers();
			list.forEach(li->System.out.println(li));
			//PageInfo info = new PageInfo<>();
			PageInfo<User> info = new PageInfo<>(list);
			//得到总记录数
			long total = info.getTotal();
			//将list集合封装成json数据
			String jsonlist = JSON.toJSONString(list);
			//构建完成的json数据
			String json = "{\"total\" : "+total+",\"rows\" : "+jsonlist+"}";
			System.out.println("json="+json);
			return json;
			
		}


		//4.删除用户
		@RequestMapping(value="/deleteUser",produces="appliction/text;charset=utf-8")
		@ResponseBody()
		public String deleteUser(String number) {
			System.out.println("要删除的number："+number);
			//调用service完成删除
			int in = service.deleteUserByNumber(number);
			//定义一个变量用来存放删除结果
			String deleteRes = "删除失败";
			if(in > 0) {
				System.out.println("删除成功");
				deleteRes = "删除成功";
			}
			return deleteRes;
		}
		
		//5.更新用户信息
		@RequestMapping(value="/updateUser",produces="appliction/text;charset=utf-8")
		@ResponseBody()
		public String updateUser(User user) {
			System.out.println("修改的用户信息是"+user);
			int in = service.updateUserByNumber(user);
			String updateInfo = "0";
			if(in > 0) {
				System.out.println("修改成功");
				updateInfo = "1";
			}
			return updateInfo;
		}
		
		//6.模糊查询
		@RequestMapping(value="/findLikeNumbers",produces="appliction/json;charset=utf8")
		@ResponseBody()
		public String findLikeNumbers(int  page,int rows,String number,String username,String roleId) {
			System.out.println("page"+page+";rows"+rows);
			//number = "%"+number+"%";
			//（1，5）查询前面五条数据，（10，5）从第10条开始查询5条数据
			PageHelper.startPage(page,rows);
			List<User> list = service.findLikeNumbers(number,username,roleId);
			list.forEach(li->System.out.println(li));
			//PageInfo info = new PageInfo<>();
			PageInfo<User> info = new PageInfo<>(list);
			//得到总记录数
			long total = info.getTotal();
			//将list集合封装成json数据
			String jsonlist = JSON.toJSONString(list);
			//构建完成的json数据
			String json = "{\"total\" : "+total+",\"rows\" : "+jsonlist+"}";
			System.out.println("json="+json);
			return json;
			
		}
		
		//7.验证
		@RequestMapping("/isExistNumber")
		@ResponseBody()
		public String isExistNumber(String number) {
			System.out.println("number==" + number );
			User user = service.findByNumber(number);
			System.out.println("user---->"+user);
			String loginfo="0";
			if(user !=null) {
				loginfo="1";
			}
			return loginfo;
		}*/				
}
