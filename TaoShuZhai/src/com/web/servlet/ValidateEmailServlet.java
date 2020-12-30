package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.HTTP;
import org.json.JSONObject;

import com.web.model.User;
import com.web.service.ServiceDAOFactory;

@WebServlet("/validateEmail.do")
public class ValidateEmailServlet extends HttpServlet{

	private static final long serialVersionUID = -300984661016630503L;
	private boolean flag;
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		String email = req.getParameter("email");
		try{
			User user = ServiceDAOFactory.getUserDAO().findByEmail(email);
			if(user != null){
				flag = false;
			}else{
				flag = true;
			}
			 JSONObject json = new JSONObject();
			 json.put("flag", flag);
			 PrintWriter out = resp.getWriter();
			 out.print(json.toString());
			 out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
