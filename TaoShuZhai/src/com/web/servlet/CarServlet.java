package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.web.model.CartItem;

import com.web.service.ProductService;
import com.web.service.ServiceDAOFactory;

@WebServlet("/car.do")
public class CarServlet extends HttpServlet{

	private static final long serialVersionUID = -3280508488742164468L;
	
	public static final String METHOD_ADD = "0";
	public static final String METHOD_DELETE = "1";
	public static final String METHOD_EDIT = "2";
	public static final String METHOD_CLEAR = "3";
	public static final String METHOD_LIST = "4";
	
	@Override
	protected void doGet (HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		doPost(req,resp);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		String method = req.getParameter("method");
		HttpSession session = req.getSession();
		Map<Integer,CartItem> map = (Map<Integer,CartItem>) session.getAttribute("s_car");
		if(method != null){
			switch(method){
				case CarServlet.METHOD_ADD:
					add(req,resp);
					break;
				case CarServlet.METHOD_LIST:
					list(req,resp,map);
					break;
				case CarServlet.METHOD_DELETE:
					map.remove(new Integer(req.getParameter("id")));
					list(req,resp,map);
					break;
				case CarServlet.METHOD_EDIT:
					String num = req.getParameter("num");
					Integer id =  new Integer(req.getParameter("id"));
					CartItem cartItem = map.get(id);
					cartItem.setNum(new Integer(num).intValue()); 
					map.put(id,cartItem);
					list(req,resp,map);
					break;
				case CarServlet.METHOD_CLEAR:
					map.clear();
					list(req,resp,map);
					break;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		boolean flag =  true;
		Map<Integer,CartItem> map = null;
		try{
			Integer id = new Integer(req.getParameter("id"));
			HttpSession session = req.getSession();
			
			//ÅÐ¶ÏÊÇ·ñµÇÂ¼
			if(session.getAttribute("s_user") == null){
				flag = false;
			}else{
				map = (Map<Integer,CartItem>) session.getAttribute("s_car");
				if(map == null){
					map = new HashMap<Integer,CartItem>();
				}
				if(map.containsKey(id)){
					CartItem cartItem = map.get(id);
					cartItem.setNum(cartItem.getNum() + 1);
				}else{
					CartItem cartItem = new CartItem();
					ProductService service = ServiceDAOFactory.getProductService();
					cartItem.setPro(service.findById(id));
					map.put(id, cartItem);
				}
			}
			session.setAttribute("s_car", map);
			JSONObject json  = new JSONObject();
			json.put("flag", flag);
			PrintWriter out = resp.getWriter();
			out.print(json.toString());
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	//return list
	private void list(HttpServletRequest req, HttpServletResponse resp, Map<Integer, CartItem> map) throws ServletException,IOException{
		
		req.setAttribute("totalDang", total(map,false));
		req.setAttribute("totalSave", totalSave(total(map,true) - total(map,false)));
		req.setAttribute("s_car", map);
		req.getRequestDispatcher("/WEB-INF/view/car/cart_list.jsp").forward(req, resp);
		
	}
	
	//flag?true:fixedPrice,false:DangPrice
	@SuppressWarnings("static-access")
	public double totalSave(double totalSave){
		BigDecimal bd = new BigDecimal(totalSave);
		BigDecimal bd1 = bd.setScale(2,bd.ROUND_HALF_UP);
		return bd1.doubleValue();
	}
	
	//flag?true:fixedPrice,false:DangPrice
	@SuppressWarnings("static-access")
	public double total(Map<Integer,CartItem> map,boolean flag){
		double totalPrice = 0.0;
		if(flag){
			for(Map.Entry<Integer, CartItem> entry : map.entrySet()){
				totalPrice += entry.getValue().getNum()*entry.getValue().getPro().getFixedPrice();
			}
		}else{
			for(Map.Entry<Integer, CartItem> entry : map.entrySet()){
				totalPrice += entry.getValue().getNum()*entry.getValue().getPro().getDangPrice();
			}
		}
		BigDecimal bd =  new BigDecimal(totalPrice);
		BigDecimal bd1 =  bd.setScale(2,bd.ROUND_HALF_UP);
		return bd1.doubleValue();
	}
	

}
