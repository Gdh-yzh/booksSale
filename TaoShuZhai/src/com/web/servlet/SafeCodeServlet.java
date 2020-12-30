package com.web.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.web.model.User;
import com.web.service.ServiceDAOFactory;
import com.web.service.UserService;
import com.web.util.ImageUtil;

@WebServlet("/checkCode.action")
public class SafeCodeServlet extends HttpServlet{

	private static final long serialVersionUID = 939482423471641095L;
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		Map<String,BufferedImage> map = ImageUtil.createImage();
		String key = map.keySet().iterator().next();
		session.setAttribute("checkCode", key);	
		BufferedImage image = map.get(key);
		ServletOutputStream out = resp.getOutputStream();
		JPEGImageEncoder imageEncoder = JPEGCodec.createJPEGEncoder(out);
		imageEncoder.encode(image);
		out.flush();
	}

}
