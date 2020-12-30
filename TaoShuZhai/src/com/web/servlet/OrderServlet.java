package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.web.model.CartItem;
import com.web.model.Order;
import com.web.model.ReceiveAddress;
import com.web.model.User;
import com.web.service.ReceiveAddressService;
import com.web.service.ServiceDAOFactory;

@WebServlet("/order.do")
public class OrderServlet extends HttpServlet{

	private static final long serialVersionUID = -4767411007105461381L;
	public  static final String METHOD_CONFIRM = "0";
	public static final String METHOD_SUBMIT = "1";
	public static final String METHOD_ADDRESS = "2";
	public static final String METHOD_FINISH = "3";
	
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
				case OrderServlet.METHOD_CONFIRM:
					confirm(req,resp,map);
					break;
				case OrderServlet.METHOD_SUBMIT:
					submit(req,resp);
					break;
				case OrderServlet.METHOD_ADDRESS:
					address(req,resp);
					break;
				case OrderServlet.METHOD_FINISH:
					finish(req,resp);
					break;
				default:
					break;
			}
		}
	}

	private void confirm(HttpServletRequest req, HttpServletResponse resp, Map<Integer, CartItem> map) throws ServletException, IOException{
		req.setAttribute("totalDang", total(map));
		req.setAttribute("s_car", map);
		req.getRequestDispatcher("/WEB-INF/view/order/order_info.jsp").forward(req, resp);
	}

	@SuppressWarnings("static-access")
	private double total(Map<Integer, CartItem> map) {
		double totalPrice = 0.0;
		for(Map.Entry<Integer, CartItem> entry : map.entrySet()){
			totalPrice += entry.getValue().getNum()*entry.getValue().getPro().getDangPrice();
		}
		BigDecimal bd =  new BigDecimal(totalPrice);
		BigDecimal bd1 =  bd.setScale(2,bd.ROUND_HALF_UP);
		return bd1.doubleValue();
	}

	private void submit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/order/address_form.jsp").forward(req, resp);
	}

	private void finish(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		ReceiveAddress addr = new ReceiveAddress();
		Order order = new Order();
		HttpSession session = req.getSession();
		try{
			String receiveName = req.getParameter("receiveName");
			String fullAddress = req.getParameter("fullAddress");
			String postalCode = req.getParameter("postalCode");
			String phone = req.getParameter("phone");
			String mobile = req.getParameter("mobile");
			//��ȡ�û�ID
			int userId = ((User)session.getAttribute("s_user")).getId();
			//��ȡ���ﳵ
			Map<Integer,CartItem> map = (Map<Integer,CartItem>) session .getAttribute("s_car");
			//������ﳵ��û����Ʒ���򷵻�mian/main.jsp
			if(map.isEmpty()){
				req.getRequestDispatcher("/WEB-INF/view/order/order_ok.jsp").forward(req, resp);
			}
			//���û�ID����addrʵ��
			addr.setUserId(userId);
			addr.setFullAddress(fullAddress);
			addr.setReceiveName(receiveName);
			addr.setMobile(mobile);
			addr.setPhone(phone);
			addr.setPostalCode(postalCode);
			//����orderʵ������������ֵ
			order.setId(addr.getId());
			order.setFullAddress(addr.getFullAddress());
			order.setUserId(userId);
			order.setMobile(addr.getMobile());
			order.setOrderDesc("desc demo");
			order.setOrderTime(System.currentTimeMillis());
			order.setPhone(addr.getPhone());
			order.setPostalCode(addr.getPostalCode());
			order.setReceiveName(addr.getReceiveName());
			order.setStatus(0);
			order.setTotalPrice(total(map));
			//order.setTotalPrice(totalPrice);
			//ͨ��dao�����ݴ������ݿ���
			//�����ַ��Ϣ�����ݿ�
			ReceiveAddressService service = ServiceDAOFactory.getReceiveAddressService();
			if(service.findById(addr.getId()) == null){
				service.save(addr);
			}
			//������Ϣ�����ݿ�
			int orderId = ServiceDAOFactory.getOrderService().save(order);
			
			//��չ��ﳵ
			map.clear();
			session.setAttribute("s_car", map);
			
			//���ض����ź��ܼ۵��ɹ�ҳ��
			req.setAttribute("orderId", orderId);
			req.setAttribute("totalPrice", order.getTotalPrice());
			req.getRequestDispatcher("/WEB-INF/view/order/order_ok.jsp").forward(req, resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//return json for dropdown list
	private void address(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		int userId = ((User)req.getSession().getAttribute("s_user")).getId();
		List<ReceiveAddress> addrs;
		try{
			addrs = ServiceDAOFactory.getReceiveAddressService().findByUserId(userId);
			com.alibaba.fastjson.JSONObject json = new com.alibaba.fastjson.JSONObject();
			com.alibaba.fastjson.JSONArray array = new com.alibaba.fastjson.JSONArray();
			for(ReceiveAddress receiveAddress : addrs){
				com.alibaba.fastjson.JSONObject json1 = (com.alibaba.fastjson.JSONObject) JSON.toJSON(receiveAddress);
				array.add(json1);	
			}
			
			json.put("addrs",array);
			PrintWriter out = resp.getWriter();
			out.print(json.toString());
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
