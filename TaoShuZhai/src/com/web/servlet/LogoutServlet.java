package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/logout.do")
public class LogoutServlet extends HttpServlet{

	private static final long serialVersionUID = 3323933338997379627L;
	
	@Override
	protected void doGet (HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		req.getSession().invalidate();
		req.getRequestDispatcher("/WEB-INF/view/user/login_form.jsp").forward(req, resp);
	}

}
