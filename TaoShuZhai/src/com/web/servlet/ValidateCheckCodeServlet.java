package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/validateCheckCode.do")
public class ValidateCheckCodeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 5730274185750131068L;
	private boolean flag;
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		String checkCode = req.getParameter("checkCode");
		try{
			if(checkCode != null && checkCode.equalsIgnoreCase(req.getSession().getAttribute("checkCode").toString())){
				flag = true;
			}else{
				flag = false;
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
