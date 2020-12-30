package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.User;
import com.web.service.ServiceDAOFactory;
import com.web.service.UserService;
import com.web.util.EmailCode;
import com.web.util.Md5Code;

@WebServlet("/user/regist.do")
public class RegistServlet extends HttpServlet{
	
	private static final long serialVersionUID = -4776713813302160051L;
	public static final String METHOD_REGIST_FORM = "0";
	public static final String METHOD_REGIST_STEP1 = "1";
	public static final String METHOD_REGIST_STEP2 = "2";
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		String method = req.getParameter("method");
		if(method != null){
			switch(method){
				case  RegistServlet.METHOD_REGIST_FORM:
					registTo(req,resp);
					break;
				case RegistServlet.METHOD_REGIST_STEP1:
					registStep1(req,resp);
					break;
				case RegistServlet.METHOD_REGIST_STEP2:
					registStep2(req,resp);
					break;
				default:
					break;
			}
		}
	}
	private void registStep1(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		User user = new User();
		try{
			UserService userService = ServiceDAOFactory.getUserDAO();
			user.setEmail(req.getParameter("email"));
			user.setNickname(req.getParameter("nickname"));
			//将密码加密
			String pwd = Md5Code.createMD5Code(req.getParameter("password"));
			user.setPassword(pwd);
			user.setUserIntegral(10);
			user.setEmailVerify(false);
			String emailCode = "testtest";
			
			user.setEmailVerifyCode(emailCode);
			user.setLastLoginTime(System.currentTimeMillis());
			user.setLastLoginIp(req.getRemoteAddr());
			
			userService.save(user);
			req.getSession().setAttribute("s_user", user);
		}catch(Exception e){
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/view/user/verify_form.jsp").forward(req, resp);
	}
	
	private void registTo(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		req.getRequestDispatcher("/WEB-INF/view/user/register_form.jsp").forward(req, resp);
	}
	
	private void registStep2(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		String code = req.getParameter("code");
		String uid = EmailCode.getUid(code);
		if(uid == null){
			req.setAttribute("verify_err", "验证码错误，请检查后重输");
			req.getRequestDispatcher("/WEB-INF/view/user/register_form.jsp").forward(req, resp);
			return ;
		}
		int id = Integer.parseInt(uid);
		String vCode = EmailCode.getUUID(code);
		//去数据库比较是否正确
		UserService userService = ServiceDAOFactory.getUserDAO();
		try{
			User u = userService.findById(id);
			if(u != null && vCode.trim().equals(u.getEmailVerifyCode())){
				u.setEmailVerify(true);
				userService.update(u);
				req.getRequestDispatcher("/WEB-INF/view/user/register_ok.jsp").forward(req, resp);
				return ;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet (HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		doPost(req,resp);
	}
}
